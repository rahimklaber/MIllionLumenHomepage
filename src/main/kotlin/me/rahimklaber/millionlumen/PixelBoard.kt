package me.rahimklaber.millionlumen

import externals.stellar.ServerApi
import io.kvision.core.*
import io.kvision.html.Canvas
import io.kvision.state.ObservableValue
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.Image
import org.w3c.files.FileReader
import org.w3c.files.get

/**
 * Class to hold info about images which need to be rendered.
 *
 * @property url The url of the image.
 * @property x The x position of the image.
 * @property y The y position of the image.
 * @property height The height of the image.
 * @property width The width of the image.
 * @property hoverText Text that should show when hovering on image.
 * @property onClickLink Where to redirect to when the image was clicked on.
 */
class ImageInfo(
    val url: String,
    var x: Double,
    var y: Double,
    val height: Double,
    val width: Double,
    val hoverText: String = "",
    val onClickLink: String = "",
    val draggable: Boolean = false
)

fun CanvasRenderingContext2D.drawImage(
    url: String,
    x: Double,
    y: Double,
    width: Double,
    height: Double,
    initialDraw: Boolean = false
) {
    val image = Image(width.toInt(), height.toInt())
    //todo save these image objects so we don't have to keep recreating objects.
    image.src = url
    if (initialDraw) {
        image.onload = {
            this.drawImage(image, 0.0, 0.0, width, height, x, y, width, height)
        }
    } else {
        this.drawImage(image, 0.0, 0.0, width, height, x, y, width, height)
    }

}

/**
 * Draw image on canvas.
 *
 * @param imageInfo Object containing image url, coords and dimensions.
 * @param initialDraw If true, we wait until the image loads before drawing.
 */
fun CanvasRenderingContext2D.drawImage(imageInfo: ImageInfo, initialDraw: Boolean = false) {
    this.drawImage(
        imageInfo.url,
        imageInfo.x,
        imageInfo.y,
        imageInfo.width,
        imageInfo.height,
        initialDraw
    )
}


class PixelBoardState(
    var addingImageToCanvas: Boolean = false,
    var imageAddedToCanvas: Boolean = false,
    var settingImageLocation: Boolean = false,
//    var imageUrl : String,
    var saveImage: () -> Unit = {}
)

/**
 *  Render a canvas with the bought images.
 *
 *
 *
 * @param width width of the image.
 * @param height height of the image.
 */
fun Container.pixelBoard(state: ObservableValue<PixelBoardState>, width: Int, height: Int) =
    Canvas(width, height) {
        val scope = CoroutineScope(Dispatchers.Default)
        val imageInfos = mutableListOf<ImageInfo>()
        val draw = { ctx: CanvasRenderingContext2D, init: Boolean ->
            ctx.fillStyle = "#D3D3D3"
            ctx.fillRect(0.0, 0.0, width.toDouble(), height.toDouble())
            // draw lines
            ctx.strokeStyle = "grey"
            for (i in 0 until 100) {
                ctx.beginPath()
                ctx.moveTo(10.0 * i, 0.0)
                ctx.lineTo(10.0 * i, height.toDouble())
                ctx.stroke()
            }
            for (i in 0 until 100) {
                ctx.beginPath()
                ctx.moveTo(0.0, 10.0 * i)
                ctx.lineTo(width.toDouble(), 10.0 * i)
                ctx.stroke()
            }
            imageInfos.forEach { ctx.drawImage(it, init) }
        }
        onEvent {
            //todo deal with hover text later

//        mousemove = {
//            it.preventDefault()
//            it.stopPropagation()
//
//            val ctx = this@Canvas.context2D
//            val x = it.offsetX
//            val y = it.offsetY
//            ctx.clearRect(0.0, 0.0, 1000.0, 1000.0)
//            draw(ctx, false)
//            for (imageInfo in imageInfos) {
//                if (x > imageInfo.x && x < imageInfo.x + imageInfo.width && y > imageInfo.y && y < imageInfo.y + imageInfo.height) {
//                    ctx.fillText(imageInfo.hoverText, 500.0, 500.0)
//                    break
//                }
//            }
//        }
            /**
             * Be able to drag and move image.
             * //todo only allow this when trying to upload something.
             */
            var moving = false
            var movingX = 0.0
            var movingY = 0.0
            mousedown = {
                if (state.value.imageAddedToCanvas) {
                    it.preventDefault()
                    it.stopPropagation()

                    moving = true
                    movingX = it.offsetX
                    movingY = it.offsetY
                }
            }
            mouseup = {
                if (state.value.imageAddedToCanvas) {

                    it.preventDefault()
                    it.stopPropagation()

                    moving = false
                }
            }
            mousemove = {
                if (state.value.imageAddedToCanvas) {

                    it.preventDefault()
                    it.stopPropagation()

                    val x = it.offsetX
                    val y = it.offsetY
                    val dx = x - movingX
                    val dy = y - movingY

                    val ctx = this@Canvas.context2D
                    if (moving) {
                        for (imageInfo in imageInfos) {
                            if (imageInfo.draggable && x > imageInfo.x && x < imageInfo.x + imageInfo.width && y > imageInfo.y && y < imageInfo.y + imageInfo.height) {
                                imageInfo.x += dx
                                imageInfo.y += dy
                                movingX = x
                                movingY = y
                                draw(ctx, false)
                                break
                            }
                        }
                    }
                }
            }
            // Suppor for adding image by draging it.
            dragenter = {
                console.log(state.value.addingImageToCanvas)
                    it.stopPropagation()
                    it.preventDefault()
            }
            dragover = {
                    it.stopPropagation()
                    it.preventDefault()
            }

            drop = {
                it.stopPropagation()
                it.preventDefault()
                if (state.value.addingImageToCanvas) {
                    console.log("dropped")
                    val imageFile = it.dataTransfer?.files?.get(0)
                    imageFile?.let { file ->
                        scope.launch {
                            val reader = FileReader()
                            reader.readAsDataURL(file)
                            reader.onload = { event ->
                                imageInfos.add(
                                    ImageInfo(
                                        event.target.asDynamic().result as String,
                                        500.0,
                                        500.0,
                                        128.0,
                                        128.0,
                                        "",
                                        "",
                                        true
                                    )
                                )
                                state.value = state.value.apply {
                                    addingImageToCanvas = false
                                    imageAddedToCanvas = true
                                }
                                draw(this@Canvas.context2D,true)
                                null
                            }

                        }

                    }
                }
            }


        }
        addAfterInsertHook {
            val ctx = this.context2D
            scope.launch {
                val transactions = server.transactions().forAccount(address).call().await()
                transactions.records.forEach { tx ->
                    if (tx.memo == "millionlumen") {
                        try {
                            require(tx.operation_count == 2) { "operation count not 2" }
                            val ops = tx.operations().await()
                            val paymentOp = ops.records[0]
                            val manageDataOp = ops.records[1]
                            require(paymentOp.type == "payment") { "first op not payment" }
                            require(manageDataOp.type == "manage_data") { "second op not manageData" }
                            manageDataOp as ServerApi.ManageDataOperationRecord
                            paymentOp as ServerApi.PaymentOperationRecord
                            val amountPaid = paymentOp.amount
                            val ipfsHash = manageDataOp.name
                            val data = window.atob(manageDataOp.value.toString()).split(";")
                            val dimensions = data[0].split("x")
                            val width = dimensions[0].toInt()
                            val height = dimensions[1].toInt()
                            val x = data[1].toInt()
                            val y = data[2].toInt()
                            println(window.atob(manageDataOp.value.toString()))
                            imageInfos.add(
                                ImageInfo(
                                    "https://ipfs.io/ipfs/$ipfsHash",
                                    x.toDouble(),
                                    y.toDouble(),
                                    height.toDouble(),
                                    width.toDouble(),
                                    "yeetss",
                                    ""
                                )
                            )
                        } catch (e: Exception) {
                            println(tx.hash)
                            println(e)
                        }
                    }
                }
                launch(Dispatchers.Main) {
                    println("Test")
                    draw(ctx, true)
                }
            }
        }
    }.apply {
        this.style {
            border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.RED))
        }
        this@pixelBoard.add(this)
    }