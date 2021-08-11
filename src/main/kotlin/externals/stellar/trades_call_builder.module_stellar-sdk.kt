@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import ServerApi.CollectionPage
import ServerApi.TradeRecord

external open class TradesCallBuilder(serverUrl: URI) : CallBuilder<CollectionPage<TradeRecord>> {
    open fun forAssetPair(base: Asset, counter: Asset): TradesCallBuilder /* this */
    open fun forOffer(offerId: String): TradesCallBuilder /* this */
    open fun forAccount(accountId: String): TradesCallBuilder /* this */
}