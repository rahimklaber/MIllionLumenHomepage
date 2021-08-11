@file:JsNonModule
@file:JsModule("stellar-sdk")
package externals.stellar

import kotlin.js.Promise


open external class CallBuilder<T>(serverUrl : Any /*URI from urijs*/){
    fun call(): Promise<T>

    fun stream(options: Any /*todo*/= definedExternally) : () -> Unit

    fun cursor(cursor : String) : CallBuilder<T>

    fun limit(recordsNumber: Int) : CallBuilder<T>

    /**
     * @param direction : "asc" | "desc"
     */
    fun order(direction: String) : CallBuilder<T>

    /**
     * @param include only valid parameter is "transactions"
     */
    fun join(include: String) : CallBuilder<T>

}