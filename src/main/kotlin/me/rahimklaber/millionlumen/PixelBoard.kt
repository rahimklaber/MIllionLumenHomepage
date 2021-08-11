package me.rahimklaber.millionlumen

import io.kvision.core.*
import io.kvision.html.Canvas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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


fun Container.pixelBoard(width: Int, height: Int) = Canvas(width, height) {
    val scope =  CoroutineScope(Dispatchers.Default)
    val imageInfos = mutableListOf<ImageInfo>()
    val draw = { ctx: CanvasRenderingContext2D, init: Boolean->
        scope.launch {
            val infos = mutableListOf<ImageInfo>()
            infos.add(ImageInfo("https://zvelo.com/wp-content/uploads/2018/11/anatomy-of-a-full-path-url-hostname-tld-path-protocol.jpg",
                100.0,100.0,100.0,100.0,"test","test"))
            if(init){
                imageInfos.addAll((infos))
            }
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
            draw(ctx,false)
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
        draw(ctx,true)
    }
}.apply {
    this.style {
        border = Border(CssSize(10, UNIT.px), BorderStyle.DOTTED, Color.name(Col.RED))
    }
    this@pixelBoard.add(this)
}