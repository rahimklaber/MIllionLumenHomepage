@file:JsNonModule
@file:JsModule("stellar-sdk")

package externals.stellar

import Asset


external class AccountCallBuilder : CallBuilder<ServerApi.CollectionPage<ServerApi.AccountRecord>> {
    fun accountId(id: String): CallBuilder<ServerApi.AccountRecord>
    fun forSigner(id: String): CallBuilder<ServerApi.CollectionPage<ServerApi.AccountRecord>>
    fun forAsset(asset: Asset): CallBuilder<ServerApi.CollectionPage<ServerApi.AccountRecord>>
    fun sponsor(id: String): CallBuilder<ServerApi.CollectionPage<ServerApi.AccountRecord>>
}