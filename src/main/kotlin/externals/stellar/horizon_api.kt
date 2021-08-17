@file:JsNonModule
@file:JsModule("stellar-sdk")

package externals.stellar


// use this as a namespace
external interface Horizon {

    interface BaseOperationResponse {
        var id: String
        var paging_token: String
        var source_account: String
        var type: String
        var type_i: Int
        var created_at: String
        var transaction_hash: String
    }

    interface PaymentOperationResponse : BaseOperationResponse {
        var from: String
        var to: String
        var asset_type: String
        var asset_code: String?
        var asset_issuer: String?
        var amount: String
    }

    interface ManageDataOperationResponse : BaseOperationResponse {
        var name: String
        var value: ByteArray
    }

    interface BalanceLine {
        var balance: String
        var asset_type: Any //todo
        var buying_liabilities: String
        var selling_liabilities: String
    }

    interface BalanceLineNative : BalanceLine {
        override var asset_type: Any //todo
    }

    interface BalanceLineAsset<T> : BalanceLine {
        override var asset_type: Any //todo
        var asset_code: String
        var asset_issuer: String
        var last_modified_ledger: Int
        var is_authorized: Int
        var is_authorized_to_maintain_liabilities: Int
        var sponsor: String?
    }

    interface Flags {
        var auth_immutable: Boolean
        var auth_required: Boolean
        var auth_revocable: Boolean
        var auth_clawback_enabled: Boolean
    }

    interface AccountThresholds {
        var low_threshold: Int
        var med_threshold: Int
        var high_threshold: Int
    }

    interface SubmitTransactionResponse {
        var hash: String
        var ledger: Int
        var envelope_xdr: String
        var result_xdr: String
        var result_meta_xdr: String
    }

    interface TransactionResponse : SubmitTransactionResponse {
        var created_at: String
        var fee_meta_xdr: String
        var fee_charged: String
        var max_fee: String
        var id: String

        //        var memo_type: MemoType;
        var memo: String?
        var memo_bytes: String?
        var operation_count: Int
        var paging_token: String
        var signatures: Array<String>
        var source_account: String
        var source_account_sequence: String
        var fee_account: String
//        var inner_transaction?: InnerTransactionResponse;
//        var fee_bump_transaction?: FeeBumpTransactionResponse;
    }


    interface FeeStatsResponse {
        var last_ledger: String
        var last_ledger_base_fee: String
        var ledger_capacity_usage: String
        var fee_charged: FeeDistribution
        var max_fee: FeeDistribution
    }

    interface FeeDistribution {
        var max: String
        var min: String
        var mode: String
        var p10: String
        var p20: String
        var p30: String
        var p40: String
        var p50: String
        var p60: String
        var p70: String
        var p80: String
        var p90: String
        var p95: String
        var p99: String
    }

    interface AccountSigner {
        var key: String
        var weight: Number
        var type: String
        var sponsor: String?
            get() = definedExternally
            set(value) = definedExternally
    }

    interface AccountResponse {
        var id: String
        var paging_token: String
        var account_id: String
        var sequence: String
        var subentry_count: Number
        var thresholds: AccountThresholds
        var flags: Flags
        var balances: Array<BalanceLine> //todo
        var signers: Array<AccountSigner>
        var data: Any
        var sponsor: String?
            get() = definedExternally
            set(value) = definedExternally
        var num_sponsoring: Number
        var num_sponsored: Number
    }
}