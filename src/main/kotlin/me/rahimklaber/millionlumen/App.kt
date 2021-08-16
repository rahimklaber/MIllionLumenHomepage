package me.rahimklaber.millionlumen

import io.kvision.Application
import io.kvision.core.*
import io.kvision.html.button
import io.kvision.html.h1
import io.kvision.module
import io.kvision.panel.hPanel
import io.kvision.panel.root
import io.kvision.panel.vPanel
import io.kvision.require
import io.kvision.startApplication
import io.kvision.state.ObservableValue
import kotlinx.browser.window
import org.w3c.dom.url.URLSearchParams

class App : Application() {

    init {
        require("style.css")
    }
    override fun start() {
        root("kvapp") {
            val pixelBoardState = ObservableValue(PixelBoardState())
                vPanel {
                    appHeader()

                    pixelBoard(pixelBoardState, 1000, 1000)
                }
            val search = window.location.search
            val params = URLSearchParams(search)
            var buy = false
            if (params.get("a") == "buy") {
                buy = true
            }


            if (buy) {
                // allow you to drag image on canvas.
                pixelBoardState.value = pixelBoardState.value.apply {
                    addingImageToCanvas = true
                }
                buyPixels(pixelBoardState).apply {
                    style{
                        marginLeft = CssSize(50,UNIT.px)
                        marginTop = CssSize(200,UNIT.px)
                    }
                }
            }

        }.apply {
            style {
                justifyContent = JustifyContent.CENTER
                display = Display.FLEX
                background = Background(image="stars.jpg")
            }
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
