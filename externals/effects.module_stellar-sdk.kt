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
import Horizon.BaseResponse__0
import tsstdlib.Omit

external enum class EffectType {
    account_created /* = 0 */,
    account_removed /* = 1 */,
    account_credited /* = 2 */,
    account_debited /* = 3 */,
    account_thresholds_updated /* = 4 */,
    account_home_domain_updated /* = 5 */,
    account_flags_updated /* = 6 */,
    account_inflation_destination_updated /* = 7 */,
    signer_created /* = 10 */,
    signer_removed /* = 11 */,
    signer_updated /* = 12 */,
    trustline_created /* = 20 */,
    trustline_removed /* = 21 */,
    trustline_updated /* = 22 */,
    trustline_authorized /* = 23 */,
    trustline_deauthorized /* = 24 */,
    trustline_authorized_to_maintain_liabilities /* = 25 */,
    trustline_flags_updated /* = 26 */,
    offer_created /* = 30 */,
    offer_removed /* = 31 */,
    offer_updated /* = 32 */,
    trade /* = 33 */,
    data_created /* = 40 */,
    data_removed /* = 41 */,
    data_updated /* = 42 */,
    sequence_bumped /* = 43 */,
    claimable_balance_created /* = 50 */,
    claimable_balance_claimant_created /* = 51 */,
    claimable_balance_claimed /* = 52 */,
    account_sponsorship_created /* = 60 */,
    account_sponsorship_updated /* = 61 */,
    account_sponsorship_removed /* = 62 */,
    trustline_sponsorship_created /* = 63 */,
    trustline_sponsorship_updated /* = 64 */,
    trustline_sponsorship_removed /* = 65 */,
    data_sponsorship_created /* = 66 */,
    data_sponsorship_updated /* = 67 */,
    data_sponsorship_removed /* = 68 */,
    claimable_balance_sponsorship_created /* = 69 */,
    claimable_balance_sponsorship_updated /* = 70 */,
    claimable_balance_sponsorship_removed /* = 71 */,
    signer_sponsorship_created /* = 72 */,
    signer_sponsorship_updated /* = 73 */,
    signer_sponsorship_removed /* = 74 */,
    claimable_balance_clawed_back /* = 80 */
}

external interface BaseEffectRecord : BaseResponse__0 {
    var id: String
    var account: String
    var paging_token: String
    var type_i: EffectType
    var type: String
    var created_at: String
}

external interface AccountCreated : BaseEffectRecord {
    var starting_balance: String
}

external interface AccountCredited : BaseEffectRecord, OfferAsset {
    var amount: String
}

external interface AccountDebited : BaseEffectRecord {
    var amount: String
}

external interface AccountThresholdsUpdated : BaseEffectRecord {
    var low_threshold: Number
    var med_threshold: Number
    var high_threshold: Number
}

external interface AccountHomeDomainUpdated : BaseEffectRecord {
    var home_domain: String
}

external interface AccountFlagsUpdated : BaseEffectRecord {
    var auth_required_flag: Boolean
    var auth_revokable_flag: Boolean
}

external interface DataEvents : BaseEffectRecord {
    var name: Boolean
    var value: Boolean
}

external interface DataCreated : DataEvents

external interface DataUpdated : DataEvents

external interface DataRemoved : DataEvents

external interface SequenceBumped : BaseEffectRecord {
    var new_seq: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SignerEvents : BaseEffectRecord {
    var weight: Number
    var key: String
    var public_key: String
}

external interface SignerCreated : SignerEvents

external interface SignerRemoved : SignerEvents

external interface SignerUpdated : SignerEvents

external interface TrustlineEvents : BaseEffectRecord, OfferAsset {
    var limit: String
}

external interface TrustlineCreated : TrustlineEvents

external interface TrustlineRemoved : TrustlineEvents

external interface TrustlineUpdated : TrustlineEvents

external interface TrustlineAuthorized : BaseEffectRecord {
    var asset_type: Any
    var asset_code: String
    var trustor: String
}

external interface TrustlineDeauthorized : Omit<TrustlineAuthorized, String /* "type_i" */> {
    var type_i: Any
}

external interface TrustlineAuthorizedToMaintainLiabilities : Omit<TrustlineAuthorized, String /* "type_i" */> {
    var type_i: Any
}

external interface ClaimableBalanceCreated : BaseEffectRecord {
    var amount: String
    var balance_type_i: String
    var asset: String
}

external interface ClaimableBalanceClaimed : Omit<ClaimableBalanceCreated, String /* "type_i" */> {
    var type_i: Any
}

external interface ClaimableBalanceClaimantCreated : Omit<ClaimableBalanceCreated, String /* "type_i" */> {
    var type_i: Any
}

external interface SponsershipFields {
    var sponsor: String
    var new_sponsor: String
    var former_sponsor: String
}

external interface AccountSponsorshipEvents : BaseEffectRecord, SponsershipFields

external interface TrustlineSponsorshipEvents : BaseEffectRecord, SponsershipFields {
    var asset: String
}

external interface DataSponsorshipEvents : BaseEffectRecord, SponsershipFields {
    var data_name: String
}

external interface ClaimableBalanceSponsorshipEvents : BaseEffectRecord, SponsershipFields {
    var balance_type_i: String
}

external interface SignerSponsorshipEvents : BaseEffectRecord, SponsershipFields {
    var signer: String
}