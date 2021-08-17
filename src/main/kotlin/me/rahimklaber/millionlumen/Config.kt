package me.rahimklaber.millionlumen

import externals.stellar.Networks
import externals.stellar.Server

object Config {
    const val address = "GDLDTFMP4OWQELMUU3WLCIAZUYADPJBLWBJWJKPTLMODGHJXFFEYDQBE"
    const val PRICEPERPIXEL = 0.1
    var server = Server("https://horizon-testnet.stellar.org")
    var testnet: Boolean = false
    var networkPassPhrase: String = Networks.TESTNET

    //init
    operator fun invoke(testnet: Boolean) {
        this.testnet = testnet
        if (!testnet) {
            networkPassPhrase = Networks.PUBLIC
            server.serverURL = "https://horizon.stellar.org"
        }
    }
}

