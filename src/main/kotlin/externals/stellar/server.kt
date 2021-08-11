@file:JsNonModule
@file:JsModule("stellar-sdk")
package externals.stellar

import kotlin.js.Promise

open external class Server(serverURL: String, opts: Options = definedExternally) {
    open var serverURL: Any
    open fun fetchTimebounds(
        seconds: Number,
        _isRetry: Boolean = definedExternally
    ): Promise<Timebounds>

    open fun fetchBaseFee(): Promise<Number>
    open fun feeStats(): Promise<Horizon.FeeStatsResponse>
    fun submitTransaction(
        transaction: Transaction,
        opts: SubmitTransactionOptions = definedExternally
    ): Promise<Horizon.SubmitTransactionResponse>

    fun submitTransaction(
        transaction: FeeBumpTransaction,
        opts: SubmitTransactionOptions = definedExternally
    ): Promise<Horizon.SubmitTransactionResponse>

    open fun accounts(): AccountCallBuilder

    //    open fun claimableBalances(): ClaimableBalanceCallBuilder
//    open fun ledgers(): LedgerCallBuilder
    open fun transactions(): TransactionCallBuilder
//    open fun offers(): OfferCallBuilder
//    open fun orderbook(selling: Asset, buying: Asset): OrderbookCallBuilder
//    open fun trades(): TradesCallBuilder
//    open fun operations(): OperationCallBuilder
//    open fun strictReceivePaths(source: String, destinationAsset: Asset, destinationAmount: String): PathCallBuilder
//    open fun strictReceivePaths(source: Array<Asset>, destinationAsset: Asset, destinationAmount: String): PathCallBuilder
//    open fun strictSendPaths(sourceAsset: Asset, sourceAmount: String, destination: String): PathCallBuilder
//    open fun strictSendPaths(sourceAsset: Asset, sourceAmount: String, destination: Array<Asset>): PathCallBuilder
    open fun payments(): PaymentCallBuilder

    //    open fun effects(): EffectCallBuilder
//    open fun friendbot(address: String): FriendbotBuilder
//    open fun assets(): AssetsCallBuilder
    open fun loadAccount(accountId: String): Promise<Horizon.AccountResponse>

    //    open fun tradeAggregation(base: Asset, counter: Asset, start_time: Number, end_time: Number, resolution: Number, offset: Number): TradeAggregationCallBuilder
//    open fun checkMemoRequired(transaction: Transaction__0): Promise<Unit>
//    open fun checkMemoRequired(transaction: FeeBumpTransaction): Promise<Unit>
    interface Options {
        var allowHttp: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var appName: String?
            get() = definedExternally
            set(value) = definedExternally
        var appVersion: String?
            get() = definedExternally
            set(value) = definedExternally
    }

    interface Timebounds {
        var minTime: Number
        var maxTime: Number
    }

    interface SubmitTransactionOptions {
        var skipMemoRequiredCheck: Boolean?
            get() = definedExternally
            set(value) = definedExternally
    }
}