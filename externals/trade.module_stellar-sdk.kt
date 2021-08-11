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

external interface Trade : BaseEffectRecord {
    var seller: String
    var offer_id: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var bought_amount: String
    var bought_asset_type: String
    var bought_asset_code: String
    var bought_asset_issuer: String
    var sold_amount: String
    var sold_asset_type: String
    var sold_asset_code: String
    var sold_asset_issuer: String
}