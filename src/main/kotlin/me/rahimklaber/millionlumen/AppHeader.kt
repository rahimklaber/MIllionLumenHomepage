package me.rahimklaber.millionlumen

import io.kvision.core.*
import io.kvision.html.div
import io.kvision.html.h1
import io.kvision.html.link
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import kotlinx.browser.window

fun Container.appHeader() = div(className = "appheader") {
    vPanel {
        h1("Million Lumen Homepage", className = "appheaderh1"){
            onClick {
                window.location.href="/"
            }
            style {
                cursor = Cursor.POINTER
            }
        }

        hPanel {
            link("Home", "/") {
                style {
                    color = Color.name(Col.WHITE)
                }
            }
            div("|"){
                style {
                    marginRight = CssSize(5,UNIT.px)
                    marginLeft = CssSize(5,UNIT.px)
                }
            }
            link("Buy pixels", "?a=buy") {
                style {
                    color = Color.name(Col.WHITE)
                }
            }
            div("|"){
                style {
                    marginRight = CssSize(5,UNIT.px)
                    marginLeft = CssSize(5,UNIT.px)
                }
            }
            link("About", "?a=about") {
                style {
                    color = Color.name(Col.WHITE)
                }
            }
        }
    }
    style {
        width = CssSize(100, UNIT.perc)
        border = Border(CssSize(1, UNIT.px), BorderStyle.SOLID, Color.name(Col.LIGHTGRAY))
        padding = CssSize(10, UNIT.px)
        display = Display.FLEX
        justifyContent = JustifyContent.SPACEBETWEEN
        justifyItems = JustifyItems.CENTER
    }
}