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
import Horizon.AssetAccounts
import Horizon.AssetBalances
import Horizon.Flags
import Horizon.BaseResponse__0

external interface AssetRecord : BaseResponse__0 {
    var asset_type: String /* "credit_alphanum4" | "credit_alphanum12" */
    var asset_code: String
    var asset_issuer: String
    var paging_token: String
    var accounts: AssetAccounts
    var num_claimable_balances: Number
    var balances: AssetBalances
    var claimable_balances_amount: String
    var amount: String
    var num_accounts: Number
    var flags: Flags
}