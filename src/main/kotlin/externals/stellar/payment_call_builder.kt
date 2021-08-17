@file:JsNonModule
@file:JsModule("stellar-sdk")

package externals.stellar


external class PaymentCallBuilder :
    CallBuilder<ServerApi.CollectionPage<ServerApi.PaymentOperationRecord>> {
    fun forAccount(accountId: String): CallBuilder<ServerApi.CollectionPage<ServerApi.PaymentOperationRecord>>
    fun forLedger(sequence: String): CallBuilder<ServerApi.CollectionPage<ServerApi.PaymentOperationRecord>>
    fun forLedger(sequence: Int): CallBuilder<ServerApi.CollectionPage<ServerApi.PaymentOperationRecord>>
    fun forTransaction(transactionId: String): CallBuilder<ServerApi.CollectionPage<ServerApi.PaymentOperationRecord>>
}