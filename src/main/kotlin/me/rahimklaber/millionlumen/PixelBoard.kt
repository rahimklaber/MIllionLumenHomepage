package me.rahimklaber.millionlumen

import externals.stellar.ServerApi
import io.kvision.core.*
import io.kvision.html.Canvas
import kotlinx.browser.window
import kotlinx.coroutines.*
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.Image

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
    val x: Double,
    val y: Double,
    val height: Double,
    val width: Double,
    val hoverText: String,
    val onClickLink: String
)

fun CanvasRenderingContext2D.canvasImage(
    url: String,
    x: Double,
    y: Double,
    width: Double,
    height: Double
) {
    val image = Image(width.toInt(), height.toInt())
    image.src = url
    this.drawImage(image, x, y, width, height)
}

fun CanvasRenderingContext2D.canvasImage(imageInfo: ImageInfo) {
    this.canvasImage(imageInfo.url, imageInfo.x, imageInfo.y, imageInfo.width, imageInfo.height)
}

/**
 *  Render a canvas with the bought images.
 *
 *  
 *
 * @param width width of the image.
 * @param height height of the image.
 */
fun Container.pixelBoard(width: Int, height: Int) = Canvas(width, height) {
    val scope =  CoroutineScope(Dispatchers.Default)
    val imageInfos = mutableListOf<ImageInfo>()
    val draw = { ctx: CanvasRenderingContext2D->
        scope.launch {
            imageInfos.forEach(ctx::canvasImage)
            ctx.canvasImage(
                "https://zvelo.com/wp-content/uploads/2018/11/anatomy-of-a-full-path-url-hostname-tld-path-protocol.jpg",
                100.0,
                100.0,
                100.0,
                100.0
            )
            ctx.canvasImage(
                "https://zvelo.com/wp-content/uploads/2018/11/anatomy-of-a-full-path-url-hostname-tld-path-protocol.jpg",
                200.0,
                200.0,
                100.0,
                100.0
            )
        }
    }
    onEvent {
        this.mousemove = {
            val rect = (this@Canvas.getElement() as HTMLCanvasElement).getBoundingClientRect()
            val ctx = this@Canvas.context2D
            val x = it.clientX - rect.left
            val y = it.clientY - rect.top
            console.log("x: $x, y: $y")
            draw(ctx)
            ctx.clearRect(0.0,0.0,1000.0,1000.0)
            for (imageInfo in imageInfos){
                if(x > imageInfo.x && x < imageInfo.x + imageInfo.width && y > imageInfo.y && y < imageInfo.y + imageInfo.height){
                    ctx.fillText(imageInfo.hoverText,imageInfo.x,imageInfo.y-10)
                    break
                }
            }
        }
    }
    addAfterInsertHook {
        val ctx = this.context2D
        scope.launch {
            val transactions = server.transactions().forAccount(address).call().await()
                transactions.records.forEach { tx ->
                    if(tx.memo == "millionlumen"){
                        require(tx.operation_count == 2)
                        val ops = tx.operations().await()
                        val paymentOp = ops.records[0]
                        val manageDataOp = ops.records[1]
                        require(paymentOp.type == "payment")
                        require(manageDataOp.type == "manage_data")
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
                        imageInfos.add(ImageInfo("https://ipfs.io/ipfs/$ipfsHash",x.toDouble(),y.toDouble(),height.toDouble(),width.toDouble(),"test",""))

                    }
                }
            draw(ctx)
            }
    }
}.apply {
    this.style {
        border = Border(CssSize(10, UNIT.px), BorderStyle.DOTTED, Color.name(Col.RED))
    }
    this@pixelBoard.add(this)
}