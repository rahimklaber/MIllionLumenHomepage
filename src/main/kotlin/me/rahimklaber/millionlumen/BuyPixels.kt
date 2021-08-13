package me.rahimklaber.millionlumen

import externals.ipfs.Options
import externals.ipfs.create
import io.kvision.core.*
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.h1
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue

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
            
        }

        style {
            border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.RED))
            padding = CssSize(10, UNIT.px)
            marginLeft = CssSize(30, UNIT.px)
        }
    }