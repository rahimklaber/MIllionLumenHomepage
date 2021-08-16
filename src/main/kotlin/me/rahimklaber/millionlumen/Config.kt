package me.rahimklaber.millionlumen

import externals.stellar.Server

object Config{
    const val  address = "GDLDTFMP4OWQELMUU3WLCIAZUYADPJBLWBJWJKPTLMODGHJXFFEYDQBE"
    const val PRICEPERPIXEL = 0.1
    var server = Server("https://horizon-testnet.stellar.org")
    var testnet : Boolean = false

    //init
    operator fun invoke(testnet : Boolean){
        this.testnet = testnet
        if(!testnet){
            server.serverURL = "https://horizon.stellar.org"
        }
    }
}

