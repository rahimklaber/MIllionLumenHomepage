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
import Horizon.PriceRShorthand
import Horizon.BaseResponse__0

external interface OfferAsset {
    var asset_type: Any
    var asset_code: String?
        get() = definedExternally
        set(value) = definedExternally
    var asset_issuer: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface OfferRecord : BaseResponse__0 {
    var id: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var paging_token: String
    var seller: String
    var selling: OfferAsset
    var buying: OfferAsset
    var amount: String
    var price_r: PriceRShorthand
    var price: String
    var last_modified_ledger: Number
    var last_modified_time: String
    var sponsor: String?
        get() = definedExternally
        set(value) = definedExternally
}