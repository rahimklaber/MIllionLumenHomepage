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
import ServerApi.AccountRecord
import Horizon.AccountThresholds
import Horizon.Flags
import Horizon.BalanceLine
import ServerApi.AccountRecordSigners
import ServerApi.`T$188`
import tsstdlib.Record
import ServerApi.CallCollectionFunction
import ServerApi.OfferRecord
import ServerApi.PaymentOperationRecord
import ServerApi.TradeRecord

external open class AccountResponse(response: AccountRecord) {
    open var id: String
    open var paging_token: String
    open var account_id: String
    open var sequence: String
    open var subentry_count: Number
    open var home_domain: String
    open var inflation_destination: String
    open var last_modified_ledger: Number
    open var thresholds: AccountThresholds
    open var flags: Flags
    open var balances: Array<BalanceLine>
    open var signers: Array<AccountRecordSigners>
    open var data: (options: `T$188`) -> Promise<`T$188`>
    open var data_attr: Record<String, String>
    open var effects: CallCollectionFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>
    open var offers: CallCollectionFunction<OfferRecord>
    open var operations: CallCollectionFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    open var payments: CallCollectionFunction<PaymentOperationRecord>
    open var trades: CallCollectionFunction<TradeRecord>
    open var _baseAccount: Any
    open fun accountId(): String
    open fun sequenceNumber(): String
    open fun incrementSequenceNumber()
    open fun createSubaccount(id: String): MuxedAccount
}