package me.rahimklaber.millionlumen

import io.kvision.core.*
import io.kvision.html.Canvas
import org.w3c.dom.CanvasImageSource
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.Image

fun CanvasRenderingContext2D.canvasImage(url: String,x: Double,y:Double, width: Double, height: Double){
    val image = Image(width.toInt(),height.toInt())
    image.src = url
    this.drawImage(image,x,x,width,height)
}

fun Container.pixelBoard(width: Int, height: Int) = Canvas(width, height) {
    onEvent {
        this.mousemove = {
            val rect = (this@Canvas.getElement() as HTMLCanvasElement).getBoundingClientRect()
            val x = it.x - rect.left
            val y = it.y - rect.top
            console.log("x : $x, y: $y")
        }
    }
    addAfterInsertHook {
        val ctx = this.context2D
//        ctx.beginPath()
//        ctx.lineWidth = 30.0
//        ctx.strokeStyle = "blue"
//        ctx.fillStyle = "blue"
//        ctx.rect(0.0, 0.0, 150.0, 80.0)
//        ctx.stroke()
       ctx.canvasImage("https://zvelo.com/wp-content/uploads/2018/11/anatomy-of-a-full-path-url-hostname-tld-path-protocol.jpg",100.0,100.0,100.0,100.0)
       ctx.canvasImage("https://zvelo.com/wp-content/uploads/2018/11/anatomy-of-a-full-path-url-hostname-tld-path-protocol.jpg",200.0,200.0,100.0,100.0)

    }
}.apply {
    this.style {
        border= Border(CssSize(1,UNIT.px),BorderStyle.DOTTED, Color.name(Col.RED))
    }
    this@pixelBoard.add(this)
}