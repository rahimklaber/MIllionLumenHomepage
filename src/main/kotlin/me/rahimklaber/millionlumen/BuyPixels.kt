package me.rahimklaber.millionlumen

import Account
import Asset
import Memo
import TransactionBuilder
import externals.albedo.TxIntentParams
import externals.albedo.albedo
import externals.ipfs.Options
import externals.ipfs.create
import externals.stellar_base.createManageDataOpts
import externals.stellar_base.createPaymentOpts
import io.kvision.core.*
import io.kvision.html.*
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.toast.Toast
import kotlinx.browser.window
import kotlinx.coroutines.*
import me.rahimklaber.millionlumen.Config.PRICEPERPIXEL
import me.rahimklaber.millionlumen.Config.server
import xdrHidden.Operation

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
@OptIn(InternalCoroutinesApi::class)
fun Container.buyPixels(pixelBoardState: ObservableValue<PixelBoardState>) =
    vPanel(pixelBoardState, className = "buypixels") {
        val scope = CoroutineScope(Dispatchers.Default)
        h1("Buy pixels")
        div {
            h3("Info")
            div("Price per pixel : 0.1 XLM")
            p("Pixels are sold in blocks of 10 by 10. Make sure the image dimensions are divisible by 10.")
            style {
                border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.LIGHTGRAY))
                padding = CssSize(10, UNIT.px)
            }
        }

        div("First, drag an image onto the canvas.")
        if (pixelBoardState.value.imageAddedToCanvas) {
            div("Next, drag the image to the location you would like.")
            hPanel {
                button("Save image") {
                    onClick {
                        // check if there is another picture
                        val imageInfo = pixelBoardState.value.imageInfo
                        val validDimen =
                            imageInfo!!.height!! % 10 == 0.0 && imageInfo.width!! % 10 == 0.0
                        val conflict = pixelBoardState.value.imageInfos.any {
                            it !== imageInfo && imageInfo.x > it.x && imageInfo.x < it.x + it.width!! && imageInfo.y > it.y && imageInfo.y < it.y + it.height!!
                        }
                        if (!conflict && validDimen) {
                            pixelBoardState.value = pixelBoardState.value.apply {
                                settingImageLocation = false
                                imageInfo.draggable = false
                            }
                        } else if (conflict) {
                            Toast.error("The image is in the area of another image.")
                        } else if (!validDimen) {
                            Toast.error("Make sure the image has dimensions which are divisible by 10.")
                        }

                    }
                }
                if (pixelBoardState.value.imageAddedToCanvas) {
                    button("Clear", type = ButtonType.RESET) {
                        style {
                            marginLeft = CssSize(10, UNIT.px)
                        }
                        onClick {
                            pixelBoardState.value.imageInfos.removeLast()
                            pixelBoardState.value = pixelBoardState.value.apply {
                                addingImageToCanvas = true
                                imageAddedToCanvas = false
                                settingImageLocation = false
                                ipfsHash = null
                            }
                            pixelBoardState.value.tryDraw(false, true)
                        }
                    }
                }
            }
        }
        if (pixelBoardState.value.imageAddedToCanvas && !pixelBoardState.value.settingImageLocation) {
            div("Next, upload the image to ipfs.")
            button("Upload to ipfs") {
                onClick {
                    this@vPanel.div("uploading image to ipfs...")
                    ipfsClient.add(pixelBoardState.value.imageFile, js("{}")).then {
                        pixelBoardState.value = pixelBoardState.value.apply {
                            ipfsHash = it.path
                        }
                    }
                }
            }
        }

        if (pixelBoardState.value.ipfsHash != null) {
            div("Next, submit the image data to the blockchain and send the payment for the pixels")
            button("Upload data to the blockchain") {
                onClick {
                    this@vPanel.div("Uploading data to blockchain...")
                    scope.launch {
                        try {
                            val address = albedo.publicKey(js("{}")).await().pubkey
                            val account = server.loadAccount(address).await().let {
                                Account(address, it.sequence)
                            }
                            val imageInfo = pixelBoardState.value.imageInfo
                            val fee = server.fetchBaseFee().await().toString()
                            val tx = TransactionBuilder(
                                account,
                                object : TransactionBuilder.TransactionBuilderOptions {
                                    override var fee: String = fee
                                    override var networkPassphrase: String? =
                                        Config.networkPassPhrase
                                })
                                .addOperation(
                                    Operation.payment(
                                        createPaymentOpts(
                                            (imageInfo!!.width!!.toInt() * imageInfo.height!!.toInt() * PRICEPERPIXEL).toString(),
                                            Asset.native(),
                                            Config.address
                                        )
                                    )
                                )
                                .addOperation(
                                    Operation.manageData(
                                        createManageDataOpts(
                                            pixelBoardState.value.ipfsHash!!,
                                            "${imageInfo.width!!.toInt()}x${imageInfo.height!!.toInt()};${imageInfo.x.toInt()};${imageInfo.y.toInt()}"
                                        )
                                    )
                                )
                                .addOperation(
                                    Operation.manageData(
                                        createManageDataOpts(
                                            pixelBoardState.value.ipfsHash!!,
                                            null
                                        )
                                    )
                                )
                                .setTimeout(0)
                                .addMemo(Memo.text("millionlumen"))
                                .build()
                            val albedoTx = albedo.tx(object : TxIntentParams {
                                override var xdr: String = tx.toXDR()
                                override var network: String? =
                                    if (Config.testnet) "testnet" else "public"
                            }).await()
                            val albedoSignedTx = TransactionBuilder.fromXDR(
                                albedoTx.signed_envelope_xdr,
                                Config.networkPassPhrase
                            )

                            val res = server.submitTransaction(albedoSignedTx)
                                .catch {
                                    val obj = js("{}")
                                    obj.successful = false
                                    obj
                                }.await()
                            if (res.successful == true) {
                                pixelBoardState.value = pixelBoardState.value.apply {
                                    txSucces = true
                                }
                            } else {
                                Toast.error("Something went wrong.")
                            }
                        } catch (e: Throwable) {
                            Toast.error("Something went wrong.")
                        }

                    }.invokeOnCompletion(onCancelling = true){
                        Toast.error("Something went wrong.")
                    }
                }
            }
        }

        if (pixelBoardState.value.txSucces == true) {
            div("Successfully added image!")
            Toast.success("Successfully added image!")
            window.setInterval({ window.location.href = "?testnet=${Config.testnet}" }, 1000)
        }

        style {
            border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.LIGHTGRAY))
            padding = CssSize(10, UNIT.px)
            width = CssSize(400, UNIT.px)
            color = Color("white")
        }
    }