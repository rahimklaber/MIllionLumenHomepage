package me.rahimklaber.millionlumen

import com.github.snabbdom.htmlDomApi
import externals.stellar.ServerApi
import io.kvision.core.*
import io.kvision.html.Canvas
import io.kvision.state.ObservableValue
import kotlinx.browser.window
import kotlinx.coroutines.*
import me.rahimklaber.millionlumen.Config.PRICEPERPIXEL
import me.rahimklaber.millionlumen.Config.server
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLVideoElement
import org.w3c.dom.Image
import org.w3c.files.File
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
 */
data class ImageInfo(
    val url: String,
    var x: Double,
    var y: Double,
    var height: Double?,
    var width: Double?,
    var draggable: Boolean = false,
    val video: Boolean = false
)

/**
 * Draw an image on the canvas.
 *
 * @param imageInfo
 * @param initialDraw Whether we should wait for the images to load.
 * @param onlyBoxes if true red boxes will be rendered instead of images.
 */
fun CanvasRenderingContext2D.drawImage(
    imageInfo: ImageInfo,
    initialDraw: Boolean = false,
    onlyBoxes: Boolean = false
) {
    if (onlyBoxes && !imageInfo.draggable) {
        this.fillStyle = "red"
        this.fillRect(imageInfo.x, imageInfo.y, imageInfo.width!!, imageInfo.height!!)
        return
    }
    val image = Image()
    image.src = imageInfo.url
    if (initialDraw) {
        image.onload = {
            if (imageInfo.width == null && imageInfo.height == null) {
                imageInfo.width = image.height.toDouble()
                imageInfo.height = image.height.toDouble()
            }
            this.drawImage(
                image,
                0.0,
                0.0,
                imageInfo.width!!,
                imageInfo.height!!,
                imageInfo.x,
                imageInfo.y,
                imageInfo.width!!,
                imageInfo.height!!
            )
        }
    } else {
        this.drawImage(
            image,
            0.0,
            0.0,
            imageInfo.width!!,
            imageInfo.height!!,
            imageInfo.x,
            imageInfo.y,
            imageInfo.width!!,
            imageInfo.height!!
        )
    }

}

fun CanvasRenderingContext2D.renderVideo(
    videoInfo: ImageInfo,
    initialDraw: Boolean = false,
    onlyBoxes: Boolean = false
) {
    if (onlyBoxes && !videoInfo.draggable) {
        this.fillStyle = "red"
        this.fillRect(videoInfo.x, videoInfo.y, videoInfo.width!!, videoInfo.height!!)
        return
    }
    if(initialDraw){
        val video = htmlDomApi.createElement("video") as HTMLVideoElement

        /**
         * Todo: [video.onload] isn't called, So I can't reliably set the height and width.
         */
        val playFun = {
            GlobalScope.launch {
                while (true){
                    delay(50)
                    this@renderVideo.drawImage(
                        video,
                       videoInfo.x,
                        videoInfo.y
                    )
                }
            }
        }
        video.muted = true
        video.onplay = {
            videoInfo.height = video.videoHeight.toDouble()
            videoInfo.width = video.videoWidth.toDouble()
            null
        }
        video.onended = {
            video.play()
        }
        video.src =  videoInfo.url
        // If I don't do this, I won't get the video height in the onplay event
        // no idea why.
        GlobalScope.launch {
            delay(100)
        video.play()
        }
        playFun()
    }
}


class PixelBoardState(
    var imageInfos: MutableList<ImageInfo> = mutableListOf(),
    var addingImageToCanvas: Boolean = false,
    var imageAddedToCanvas: Boolean = false,
    var settingImageLocation: Boolean = false,
    var imageInfo: ImageInfo? = null,
    var imageFile: File? = null, // file for uploading to ipfs
    var ipfsHash: String? = null,
    var txSucces: Boolean? = null,
    var tryDraw: (Boolean, Boolean) -> Unit = { _, _ -> }

)

/**
 *  Render a canvas with the bought images.
 *
 *
 *
 * @param canvaswidth canvaswidth of the image.
 * @param canvasheight canvasheight of the image.
 */
fun Container.pixelBoard(
    state: ObservableValue<PixelBoardState>,
    canvaswidth: Int,
    canvasheight: Int
) =
    Canvas(canvaswidth, canvasheight) {
        val scope = CoroutineScope(Dispatchers.Default)
        val imageInfos = state.value.imageInfos
        val draw = { ctx: CanvasRenderingContext2D, init: Boolean, onlyBoxes: Boolean ->
            ctx.fillStyle = "#D3D3D3"
            ctx.fillRect(0.0, 0.0, canvaswidth.toDouble(), canvasheight.toDouble())
            // draw lines
            ctx.strokeStyle = "grey"
            for (i in 0 until 100) {
                ctx.beginPath()
                ctx.moveTo(10.0 * i, 0.0)
                ctx.lineTo(10.0 * i, canvasheight.toDouble())
                ctx.stroke()
            }
            for (i in 0 until 100) {
                ctx.beginPath()
                ctx.moveTo(0.0, 10.0 * i)
                ctx.lineTo(canvaswidth.toDouble(), 10.0 * i)
                ctx.stroke()
            }
            val images = imageInfos.filter{ !it.video }
            images.forEach { ctx.drawImage(it, init, onlyBoxes) }
            val videos = imageInfos - images
            videos.forEach { ctx.renderVideo(it,init,onlyBoxes) }
            console.log(imageInfos)
        }
        onEvent {
            var moving = false
            var movingX = 0.0
            var movingY = 0.0
            var currentlyMoving: ImageInfo? = null
            mousedown = {
                if (state.value.settingImageLocation) {
                    it.preventDefault()
                    it.stopPropagation()

                    movingX = it.offsetX
                    movingY = it.offsetY
                    console.log(state.value.imageFile)
                    console.log(state.value.imageInfo)
                        for (imageInfo in imageInfos) {
                            if (imageInfo.draggable && movingX > imageInfo.x && movingX < imageInfo.x + imageInfo.width!! && movingY > imageInfo.y && movingY < imageInfo.y + imageInfo.height!!) {
                                moving = true
                                currentlyMoving = imageInfo
                                console.log(currentlyMoving)
                            }
                        }



                }
            }
            mouseup = { mouseEvent ->
                if (state.value.settingImageLocation) {
                    val ctx = this@Canvas.context2D
                    mouseEvent.preventDefault()
                    mouseEvent.stopPropagation()

                    currentlyMoving?.also {
                        val remainderX = it.x % 10
                        val remainderY = it.y % 10
                        if (remainderX > 5) {
                            it.x = it.x - remainderX + 10
                        } else {
                            it.x = it.x - remainderX
                        }
                        if (remainderY > 5) {
                            it.y = it.y - remainderY + 10
                        } else {
                            it.y = it.y - remainderY
                        }
                        draw(ctx, false, true)
                    }
                    moving = false
                }
            }
            mousemove = {
                if (state.value.settingImageLocation) {

                    it.preventDefault()
                    it.stopPropagation()

                    val x = it.offsetX
                    val y = it.offsetY
                    val dx = x - movingX
                    val dy = y - movingY

                    val ctx = this@Canvas.context2D
                    if (moving) {
                        currentlyMoving?.also {
                            it.x += dx
                            it.y += dy
                            movingX = x
                            movingY = y
                            draw(ctx, false, true)
                        }
                    }
                }
            }
            // Suppor for adding image by draging it.
            dragenter = {
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
                                        null,
                                        null,
                                        true,
                                        imageFile.type.startsWith("video")
                                    )
                                )
                                state.value = state.value.apply {
                                    addingImageToCanvas = false
                                    imageAddedToCanvas = true
                                    settingImageLocation = true
                                    imageInfo = imageInfos.last()
                                    this.imageFile = file
                                }
                                draw(this@Canvas.context2D, true, true)
                                null // why do I have to do this? wrong typedefs?
                            }

                        }

                    }
                }
            }


        }
        addAfterInsertHook {
            val ctx = this.context2D
            state.value.tryDraw = { init, onlyBoxes -> draw(ctx, init, onlyBoxes) }
            scope.launch {
                val transactions =
                    server.transactions().forAccount(Config.address).limit(200).call().await()
                transactions.records.forEach { tx ->
                    if (tx.memo == "millionlumen") {
                        try {
                            require(tx.operation_count == 3) { "operation count not 3" }
                            val ops = tx.operations().await()
                            val paymentOp = ops.records[0]
                            val manageDataOp = ops.records[1]
                            require(paymentOp.type == "payment") { "first op not payment" }
                            require(manageDataOp.type == "manage_data") { "second op not manageData" }
                            manageDataOp as ServerApi.ManageDataOperationRecord
                            paymentOp as ServerApi.PaymentOperationRecord
                            val amountPaid = paymentOp.amount
                            val data = window.atob(manageDataOp.value.toString()).split(";")
                            val dimensions = data[0].split("x")
                            val width = dimensions[0].toInt()
                            val height = dimensions[1].toInt()
                            val x = data[1].toInt()
                            val y = data[2].toInt()
                            require(amountPaid.toDouble() >= width * height * PRICEPERPIXEL) {
                                "Insufficient payment"
                            }
                            val ipfsHash = manageDataOp.name
                            imageInfos.add(
                                ImageInfo(
                                    "https://ipfs.io/ipfs/$ipfsHash",
                                    x.toDouble(),
                                    y.toDouble(),
                                    height.toDouble(),
                                    width.toDouble(),
                                    // this should be cached.
                                    video = window.fetch("https://ipfs.io/ipfs/$ipfsHash").await().headers.get("content-type")?.startsWith("video") ?: false
                                )
                            )
                        } catch (e: Exception) {
                            // for invalid transactions
                        }
                    }
                }
                launch(Dispatchers.Main) {
                    draw(ctx, true, state.value.addingImageToCanvas)
                }
            }
        }
    }.apply {
        this.style {
            border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.LIGHTGRAY))
        }
        this@pixelBoard.add(this)
    }