package me.rahimklaber.millionlumen

import io.kvision.Application
import io.kvision.core.*
import io.kvision.module
import io.kvision.panel.root
import io.kvision.panel.vPanel
import io.kvision.require
import io.kvision.startApplication
import io.kvision.state.ObservableValue
import kotlinx.browser.window
import org.w3c.dom.url.URLSearchParams

class App : Application() {
    var buy: Boolean = false
    var about: Boolean = false

    init {
        require("style.css")
        val search = window.location.search
        val params = URLSearchParams(search)
        if (params.get("a") == "buy") {
            buy = true
        } else if (params.get("a") == "about") {
            about = true
        }
        if (params.get("testnet")?.lowercase() == "true") {
            Config(true)
        } else {
            Config(false)
        }
    }

    override fun start() {
        root("kvapp") {
            val pixelBoardState = ObservableValue(PixelBoardState())
            vPanel {
                appHeader()
                if (!about) {
                    if (buy) {
                        pixelBoardState.value.addingImageToCanvas = true
                    }
                    pixelBoard(pixelBoardState, 1000, 1000)
                } else {
                    about()
                }
            }

            if (buy) {
                // allow you to drag image on canvas.
                pixelBoardState.value = pixelBoardState.value.apply {
                    addingImageToCanvas = true
                }
                buyPixels(pixelBoardState).apply {
                    style {
                        marginLeft = CssSize(50, UNIT.px)
                        marginTop = CssSize(200, UNIT.px)
                    }
                }
            }


        }.apply {
            style {
                justifyContent = JustifyContent.CENTER
                display = Display.FLEX
                background = Background(image = "stars.jpg")
            }
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
