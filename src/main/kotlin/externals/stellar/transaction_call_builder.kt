package externals.stellar

external class TransactionCallBuilder :
    CallBuilder<ServerApi.CollectionPage<ServerApi.TransactionRecord>> {
    fun transaction(transactionId: String): CallBuilder<ServerApi.TransactionRecord>
    fun forAccount(accountId: String): CallBuilder<ServerApi.CollectionPage<ServerApi.TransactionRecord>>
}
