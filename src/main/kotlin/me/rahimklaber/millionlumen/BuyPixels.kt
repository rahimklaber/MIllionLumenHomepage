package me.rahimklaber.millionlumen

import Account
import Operation.manageData
import Operation.payment
import TransactionBuilder
import externals.albedo.albedo
import externals.ipfs.Options
import externals.ipfs.create
import externals.stellar_base.*
import io.kvision.core.*
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.h1
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.await
import kotlinx.coroutines.launch

val opts = js("{}").unsafeCast<Options>().apply {
    host = "ipfs.infura.io"
    port = 5001
    protocol = "https"
}
val ipfsClient = create(opts)

/**
 * Container which controls the buying of pixels.
 *
 */
fun Container.buyPixels(pixelBoardState: ObservableValue<PixelBoardState>) =
    vPanel(pixelBoardState) {
        val scope = CoroutineScope(Dispatchers.Default)
        h1("Buy pixel")
        div("First, drag an image onto the canvas")
        if (pixelBoardState.value.imageAddedToCanvas) {
            div("Drag the image to the location you would like.")
            button("Save image info") {
                onClick {
                    pixelBoardState.value = pixelBoardState.value.apply {
                        settingImageLocation = false
                        imageInfo?.draggable = false
                    }
                    console.log(pixelBoardState.value.imageInfo)
                }
            }
        }
        if (pixelBoardState.value.imageAddedToCanvas && !pixelBoardState.value.settingImageLocation) {
            div("Next, upload the image to ipfs")
            button("Upload to ipfs") {
                onClick {
                    ipfsClient.add(pixelBoardState.value.imageFile, js("{}")).then {
                        pixelBoardState.value = pixelBoardState.value.apply {
                            ipfsHash = it.path
                        }
                    }
                }
            }
        }
        if(pixelBoardState.value.ipfsHash !=null){
           div("Next, submit the image data to the blockchain and send the payment for the pixels")
            scope.launch {
                val address = albedo.publicKey(js("{}")).await().pubkey
                val account = server.loadAccount(address).await().let {
                    Account(address,it.sequence)
                }
                val imageInfo = pixelBoardState.value.imageInfo
                val fee = server.fetchBaseFee().await().toString()
                val tx = TransactionBuilder(account, object :  TransactionBuilder.TransactionBuilderOptions {
                    override var fee: String = fee
                })
                    .addOperation(payment(createPaymentOpts("1",Asset.native(),address)))
                    .addOperation(manageData(createManageDataOpts(pixelBoardState.value.ipfsHash!!,"${imageInfo!!.width!!.toInt()}x${imageInfo!!.height!!.toInt()};${imageInfo.x.toInt()};${imageInfo.y.toInt()}")))
                    .setTimeout(0)
                    .build()
                val res = server.submitTransaction(tx).await()
                console.log(res)
            }
        }

        style {
            border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.RED))
            padding = CssSize(10, UNIT.px)
            marginLeft = CssSize(30, UNIT.px)
        }
    }