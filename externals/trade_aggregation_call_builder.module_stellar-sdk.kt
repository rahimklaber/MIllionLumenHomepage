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
import Horizon.BaseResponse__0

external open class TradeAggregationCallBuilder(serverUrl: URI, base: Asset, counter: Asset, start_time: Number, end_time: Number, resolution: Number, offset: Number) : CallBuilder<CollectionPage<TradeAggregationRecord>> {
    open var isValidResolution: Any
    open var isValidOffset: Any
}

external interface TradeAggregationRecord : BaseResponse__0 {
    var timestamp: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var trade_count: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var base_volume: String
    var counter_volume: String
    var avg: String
    var high: String
    var low: String
    var open: String
    var close: String
}