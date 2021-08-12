package me.rahimklaber.millionlumen

import externals.stellar.Server
import externals.stellar.ServerApi
import io.kvision.Application
import io.kvision.core.*
import io.kvision.html.header
import io.kvision.module
import io.kvision.panel.root
import io.kvision.panel.vPanel
import io.kvision.startApplication

class App : Application() {
    override fun start() {
        root("kvapp") {
            vPanel(alignItems = AlignItems.CENTER) {
                header("hi")
                pixelBoard(1000, 1000)
            }

        }.apply {
            style {
                justifyContent = JustifyContent.CENTER
                display = Display.FLEX
            }
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
