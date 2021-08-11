@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package ServerApi

import AccountRecordSigners
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
import Horizon.Claimant
import Horizon.AccountThresholds
import Horizon.Flags
import Horizon.BalanceLine
import tsstdlib.`T$5`
import Horizon.OperationResponseType
import Horizon.OperationResponseTypeI
import Horizon.BaseOperationResponse
import Horizon.CreateAccountOperationResponse
import Horizon.PaymentOperationResponse
import Horizon.PathPaymentOperationResponse
import Horizon.PathPaymentStrictSendOperationResponse
import Horizon.ManageOfferOperationResponse
import Horizon.PassiveOfferOperationResponse
import Horizon.SetOptionsOperationResponse
import Horizon.ChangeTrustOperationResponse
import Horizon.AllowTrustOperationResponse
import Horizon.AccountMergeOperationResponse
import Horizon.InflationOperationResponse
import Horizon.ManageDataOperationResponse
import Horizon.BumpSequenceOperationResponse
import Horizon.CreateClaimableBalanceOperationResponse
import Horizon.ClaimClaimableBalanceOperationResponse
import Horizon.BeginSponsoringFutureReservesOperationResponse
import Horizon.EndSponsoringFutureReservesOperationResponse
import Horizon.RevokeSponsorshipOperationResponse
import Horizon.TransactionResponse
import Omit
import Asset
import OfferRecord

//typealias OfferRecord = OfferRecordType
//
//typealias AccountRecordSigners = AccountRecordSignersType
//
//typealias AssetRecord = AssetRecordType

external interface CollectionPage<T> {
    var records: Array<T>
    var next: () -> Promise<CollectionPage<T>>
    var prev: () -> Promise<CollectionPage<T>>
}

external interface CallFunctionTemplateOptions {
    var cursor: dynamic /* String? | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var limit: Number?
        get() = definedExternally
        set(value) = definedExternally
    var order: String? /* "asc" | "desc" */
        get() = definedExternally
        set(value) = definedExternally
}

typealias CallFunction<T> = () -> Promise<T>

typealias CallCollectionFunction<T> = (options: CallFunctionTemplateOptions) -> Promise<CollectionPage<T>>

external interface ClaimableBalanceRecord : BaseResponse__0 {
    var id: String
    var paging_token: String
    var asset: String
    var amount: String
    var sponsor: String?
        get() = definedExternally
        set(value) = definedExternally
    var last_modified_ledger: Number
    var claimants: Array<Claimant>
}

external interface `T$188` {
    var value: String
}

external interface AccountRecord : BaseResponse__0 {
    var id: String
    var paging_token: String
    var account_id: String
    var sequence: String
    var subentry_count: Number
    var home_domain: String?
        get() = definedExternally
        set(value) = definedExternally
    var inflation_destination: String?
        get() = definedExternally
        set(value) = definedExternally
    var last_modified_ledger: Number
    var thresholds: AccountThresholds
    var flags: Flags
    var balances: Array<BalanceLine>//todo
    var signers: Array<AccountRecordSigners>
    var data: (options: `T$188`) -> Promise<`T$188`>
    var data_attr: `T$5`
    var sponsor: String?
        get() = definedExternally
        set(value) = definedExternally
    var num_sponsoring: Number
    var num_sponsored: Number
    var effects: CallCollectionFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>
    var offers: CallCollectionFunction<OfferRecord>
    var operations: CallCollectionFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    var payments: CallCollectionFunction<PaymentOperationRecord>
    var trades: CallCollectionFunction<TradeRecord>
}

external interface EffectRecordMethods {
    var operation: CallFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>?
        get() = definedExternally
        set(value) = definedExternally
    var precedes: CallFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>?
        get() = definedExternally
        set(value) = definedExternally
    var succeeds: CallFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface LedgerRecord : BaseResponse__0 {
    var id: String
    var paging_token: String
    var hash: String
    var prev_hash: String
    var sequence: Number
    var transaction_count: Number
    var operation_count: Number
    var tx_set_operation_count: Number?
    var closed_at: String
    var total_coins: String
    var fee_pool: String
    var base_fee: Number
    var base_reserve: String
    var max_tx_set_size: Number
    var protocol_version: Number
    var header_xdr: String
    var base_fee_in_stroops: Number
    var base_reserve_in_stroops: Number
    var effects: CallCollectionFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>
    var operations: CallCollectionFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    var self: CallFunction<LedgerRecord>
    var transactions: CallCollectionFunction<TransactionRecord>
}

external interface BaseOperationRecord : BaseOperationResponse {
    var self: CallFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    var succeeds: CallFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    var precedes: CallFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    var effects: CallCollectionFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>
    var transaction: CallFunction<TransactionRecord>
}

external interface CreateAccountOperationRecord : BaseOperationRecord, CreateAccountOperationResponse

external interface PaymentOperationRecord : BaseOperationRecord, PaymentOperationResponse {
    var sender: CallFunction<AccountRecord>
    var receiver: CallFunction<AccountRecord>
}

external interface PathPaymentOperationRecord : BaseOperationRecord, PathPaymentOperationResponse

external interface PathPaymentStrictSendOperationRecord : BaseOperationRecord, PathPaymentStrictSendOperationResponse

external interface ManageOfferOperationRecord : BaseOperationRecord, ManageOfferOperationResponse

external interface PassiveOfferOperationRecord : BaseOperationRecord, PassiveOfferOperationResponse

external interface SetOptionsOperationRecord : BaseOperationRecord, SetOptionsOperationResponse

external interface ChangeTrustOperationRecord : BaseOperationRecord, ChangeTrustOperationResponse

external interface AllowTrustOperationRecord : BaseOperationRecord, AllowTrustOperationResponse

external interface AccountMergeOperationRecord : BaseOperationRecord, AccountMergeOperationResponse

external interface InflationOperationRecord : BaseOperationRecord, InflationOperationResponse

external interface ManageDataOperationRecord : BaseOperationRecord, ManageDataOperationResponse

external interface BumpSequenceOperationRecord : BaseOperationRecord, BumpSequenceOperationResponse

external interface CreateClaimableBalanceOperationRecord : BaseOperationRecord, CreateClaimableBalanceOperationResponse

external interface ClaimClaimableBalanceOperationRecord : BaseOperationRecord, ClaimClaimableBalanceOperationResponse

external interface BeginSponsoringFutureReservesOperationRecord : BaseOperationRecord, BeginSponsoringFutureReservesOperationResponse

external interface EndSponsoringFutureReservesOperationRecord : BaseOperationRecord, EndSponsoringFutureReservesOperationResponse

external interface RevokeSponsorshipOperationRecord : BaseOperationRecord, RevokeSponsorshipOperationResponse

external interface TradeRecord : BaseResponse__0 {
    var id: String
    var paging_token: String
    var ledger_close_time: String
    var offer_id: String
    var base_offer_id: String
    var base_account: String
    var base_amount: String
    var base_asset_type: String
    var base_asset_code: String?
        get() = definedExternally
        set(value) = definedExternally
    var base_asset_issuer: String?
        get() = definedExternally
        set(value) = definedExternally
    var counter_offer_id: String
    var counter_account: String
    var counter_amount: String
    var counter_asset_type: String
    var counter_asset_code: String?
        get() = definedExternally
        set(value) = definedExternally
    var counter_asset_issuer: String?
        get() = definedExternally
        set(value) = definedExternally
    var base_is_seller: Boolean
    var base: CallFunction<AccountRecord>
    var counter: CallFunction<AccountRecord>
    var operation: CallFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
}

external interface TransactionRecord : Omit<TransactionResponse, String /* "ledger" */> {
    var ledger_attr: Any
    var account: CallFunction<AccountRecord>
    var effects: CallCollectionFunction<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>
    var ledger: CallFunction<LedgerRecord>
    var operations: CallCollectionFunction<dynamic /* CreateAccountOperationRecord | PaymentOperationRecord | PathPaymentOperationRecord | ManageOfferOperationRecord | PassiveOfferOperationRecord | SetOptionsOperationRecord | ChangeTrustOperationRecord | AllowTrustOperationRecord | AccountMergeOperationRecord | InflationOperationRecord | ManageDataOperationRecord | BumpSequenceOperationRecord | PathPaymentStrictSendOperationRecord | CreateClaimableBalanceOperationRecord | ClaimClaimableBalanceOperationRecord | BeginSponsoringFutureReservesOperationRecord | EndSponsoringFutureReservesOperationRecord | RevokeSponsorshipOperationRecord */>
    var precedes: CallFunction<TransactionRecord>
    var self: CallFunction<TransactionRecord>
    var succeeds: CallFunction<TransactionRecord>
}

external interface `T$189` {
    var d: Number
    var n: Number
}

external interface `T$190` {
    var price_r: `T$189`
    var price: String
    var amount: String
}

external interface OrderbookRecord : BaseResponse__0 {
    var bids: Array<`T$190`>
    var asks: Array<`T$190`>
    var base: Asset
    var counter: Asset
}

external interface `T$191` {
    var asset_code: String
    var asset_issuer: String
    var asset_type: String
}

external interface PaymentPathRecord : BaseResponse__0 {
    var path: Array<`T$191`>
    var source_amount: String
    var source_asset_type: String
    var source_asset_code: String
    var source_asset_issuer: String
    var destination_amount: String
    var destination_asset_type: String
    var destination_asset_code: String
    var destination_asset_issuer: String
}