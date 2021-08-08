import io.nacular.doodle.application.Application
import io.nacular.doodle.application.Modules.Companion.PointerModule
import io.nacular.doodle.application.application
import io.nacular.doodle.core.*
import io.nacular.doodle.drawing.*
import io.nacular.doodle.event.PointerEvent
import io.nacular.doodle.event.PointerListener
import io.nacular.doodle.geometry.Circle
import io.nacular.doodle.geometry.Point
import io.nacular.doodle.geometry.Rectangle
import io.nacular.doodle.geometry.Size
import io.nacular.doodle.image.Image
import io.nacular.doodle.image.ImageLoader
import io.nacular.doodle.image.impl.ImageLoaderImpl
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance
import org.w3c.fetch.FOLLOW
import org.w3c.fetch.RequestRedirect
import kotlin.random.Random
import kotlin.random.nextUInt


//val container = container {
//    pointerChanged += PointerListener.entered { pointer ->
//        val rectUnderPointer =  takenRects.find {
//            it.rectangle.contains(pointer.location)
//        }
//        rectUnderPointer?.let {
//
//        }
//    }
//    size = Size(1000)
//    val containerpos = this.position
//    render = {
//        val canvas = this
//        GlobalScope.launch {
//            val image =
//                imageLoader.load("https://upload.wikimedia.org/wikipedia/commons/d/de/Windows_live_square.JPG")
//            for (y in 0 until 100) {
//                for (x in 0 until 100) {
//                    val pos = containerpos + Point(10 * x, y * 10)
//                    if (y == 0 && x == 0) {
//                        image?.let {
//                            canvas.image(it, Rectangle(pos, it.size))
//                        }
//                    }
//                    if (pos.x >= image!!.size.width || pos.y >= image.size.height)
//                        rect(
//                            Rectangle(pos, Size(10)),
//                            ColorPaint(Color(Random.nextUInt(16777214u)))
//                        )
//                }
//
//            }
//        }
//    }
//
//}

class ImageInfo(pos: Point,size: Size, val link: String, val onHoverText: String) {
    val rectangle = Rectangle(pos,size)
}


class PixelView(size: Size,private val imageLoader: ImageLoader) : View(){
    val takenRects = mutableListOf<ImageInfo>().apply {
        add(ImageInfo(Point.Origin,Size(300),"test","test"))
    }

    init {
        this.size = size


        children += imageView(Point.Origin,Size(300),"https://upload.wikimedia.org/wikipedia/commons/d/de/Windows_live_square.JPG")
    }


    fun imageView(pos:Point, size: Size, imageLink : String) = object : View() {
        init {
            this.position = pos
            this.size = size
            pointerFilter += PointerListener.pressed {
                window.location.href=imageLink
            }
        }

        override fun toolTipText(`for`: PointerEvent): String {
            return imageLink
        }

        override fun render(canvas: Canvas) {
            GlobalScope.launch {
                val image =
                    imageLoader.load(imageLink)
                image?.let {
                    canvas.image(it)
                }
            }
        }
    }

    override fun render(canvas: Canvas) {
        console.log("test")
        canvas.text("hi",color = Color.Blue)
    }
}


class HelloWorld(display: Display, imageLoader: ImageLoader) : Application {


    init {
        console.log("test")
        display += PixelView(display.size,imageLoader)
    }

    override fun shutdown() {}
}

fun main() {
    application(modules = listOf(
        PointerModule,
        DI.Module(name = "doodle") {
            bindSingleton<ImageLoader> { ImageLoaderImpl(instance(), instance()) }
        }
    )) {
        HelloWorld(display = instance(), imageLoader = instance())
    }
}