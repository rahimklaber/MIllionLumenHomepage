package me.rahimklaber.millionlumen

import io.kvision.core.*
import io.kvision.html.button
import io.kvision.html.header
import io.kvision.html.link
import io.kvision.panel.hPanel
import kotlinx.browser.window

fun Container.appHeader() = header("<h1>Million Lumen Homepage</h1>",rich = true) {
    hPanel {
        link("Home","/")
        link("Buy pixels","?a=buy")
        style {
            background = Background(Color.name(Col.AZURE))
            display = Display.FLEX
            justifyContent = JustifyContent.SPACEBETWEEN
            justifyItems = JustifyItems.CENTER
        }
    }
}