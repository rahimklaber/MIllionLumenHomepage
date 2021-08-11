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
        val server = Server("https://horizon-testnet.stellar.org")
        server.transactions().transaction("be31bc4643f2b337f7d6e869e0d1e073a6cb39dbeea44282e209bd1691bd63d7")
            .call().then {
                it.operations().then {
                    val op = it.records[0]
                    if(op.type == "manage_data"){
                        op as ServerApi.ManageDataOperationRecord
                        console.log(op)
                        println("""
                            name: ${op.name},
                            value: ${op.value.decodeToString()}
                        """.trimIndent())
                    }
                }
            }
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
