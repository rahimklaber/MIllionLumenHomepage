@file:JsNonModule
@file:JsModule("stellar-sdk")

package externals.stellar

import kotlin.js.Promise


external interface ServerApi {
    interface CollectionPage<T> {
        var records: Array<T>
        var next: () -> Promise<CollectionPage<T>>
        var prev: () -> Promise<CollectionPage<T>>
    }

    interface AccountRecord {
        var id: String
        var paging_token: String
        var account_id: String
        var sequence: String
    }

    interface OperationRecord

    interface TransactionRecord : Horizon.TransactionResponse {
        var account: () -> Promise<AccountRecord>

        //       var effects: CallCollectionFunction<EffectRecord>;
//       var ledger: CallFunction<LedgerRecord>;
        var operations: () -> Promise<CollectionPage<Horizon.BaseOperationResponse>>
        var precedes: () -> Promise<TransactionRecord>
        var self: () -> Promise<TransactionRecord>
        var succeeds: () -> Promise<TransactionRecord>

    }

    interface BaseOperationRecord {
        var self: () -> Promise<OperationRecord>
        var succeeds: () -> Promise<OperationRecord>
        var precedes: () -> Promise<OperationRecord>

        //        var effects: CallCollectionFunction<EffectRecord>;
        var transaction: () -> Promise<TransactionRecord>
    }

    interface PaymentOperationRecord : Horizon.PaymentOperationResponse, BaseOperationRecord,
        OperationRecord {
        var sender: () -> Promise<AccountRecord>
        var receiver: () -> Promise<AccountRecord>
    }

    interface ManageDataOperationRecord : Horizon.ManageDataOperationResponse, BaseOperationRecord,
        OperationRecord

}

