package me.rahimklaber.millionlumen

import io.kvision.Application
import io.kvision.core.CssSize
import io.kvision.core.UNIT
import io.kvision.form.text.text
import io.kvision.html.Canvas
import io.kvision.html.canvas
import io.kvision.html.div
import io.kvision.module
import io.kvision.panel.root
import io.kvision.startApplication
import io.kvision.window.window
import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

class App : Application() {
    override fun start() {
        root("kvapp") {
           pixelBoard(1000,1000).apply {
               marginLeft = Pair(300,UNIT.px)
           }
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
