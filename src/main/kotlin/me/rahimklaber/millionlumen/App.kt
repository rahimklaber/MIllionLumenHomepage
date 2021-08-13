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
import io.kvision.state.ObservableValue

class App : Application() {
    override fun start() {
        root("kvapp") {
            vPanel(alignItems = AlignItems.CENTER) {
                appHeader()
                pixelBoard(ObservableValue(false),1000, 1000)
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
