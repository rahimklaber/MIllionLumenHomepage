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

external interface EventSourceOptions<T> {
    var onmessage: ((value: T) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onerror: ((event: MessageEvent) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var reconnectTimeout: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external open class CallBuilder<T>(serverUrl: URI) {
    open var url: Any
    open var filter: Array<Array<String>>
    open var originalSegments: Array<String>
    open fun call(): Promise<T>
    open fun stream(options: EventSourceOptions<T> = definedExternally): () -> Unit
    open fun cursor(cursor: String): CallBuilder<T> /* this */
    open fun limit(recordsNumber: Number): CallBuilder<T> /* this */
    open fun order(direction: String /* "asc" | "desc" */): CallBuilder<T> /* this */
    open fun join(include: String /* "transactions" */): CallBuilder<T> /* this */
    open var checkFilter: Any
    open var _requestFnForLink: Any
    open var _parseRecord: Any
    open var _sendNormalRequest: Any
    open var _parseResponse: Any
    open var _toCollectionPage: Any
    open var _handleNetworkError: Any
}