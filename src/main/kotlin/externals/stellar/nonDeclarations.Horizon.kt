@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package Horizon

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

external interface BalanceLine {
    var balance: String
    var asset_type: String //todo
    var buying_liabilities: String
    var selling_liabilities: String
}

external interface BalanceLineNative : BalanceLine{
}

external interface BalanceLineAsset<T> : BalanceLine{
    override var asset_type : String //todo
    var asset_code: String;
    var asset_issuer: String;
    var last_modified_ledger: Int;
    var is_authorized: Int;
    var is_authorized_to_maintain_liabilities: Int;
    var sponsor: String?;
}
