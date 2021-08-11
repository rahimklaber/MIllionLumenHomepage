@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")


import ServerApi.AccountRecord
import ServerApi.CollectionPage

external open class AccountCallBuilder(serverUrl: URI) : CallBuilder<CollectionPage<AccountRecord>> {
    open fun accountId(id: String): CallBuilder<AccountRecord>
    open fun forSigner(id: String): AccountCallBuilder /* this */
    open fun forAsset(asset: Asset): AccountCallBuilder /* this */
    open fun sponsor(id: String): AccountCallBuilder /* this */
}