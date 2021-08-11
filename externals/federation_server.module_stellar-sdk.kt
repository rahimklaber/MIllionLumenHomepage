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
import FederationServer.Options
import FederationServer.Record

external open class FederationServer(serverURL: String, domain: String, opts: Options = definedExternally) {
    open var serverURL: Any
    open var domain: Any
    open var timeout: Any
    open fun resolveAddress(address: String): Promise<Record>
    open fun resolveAccountId(accountId: String): Promise<Record>
    open fun resolveTransactionId(transactionId: String): Promise<Record>
    open var _sendRequest: Any
    interface Record {
        var account_id: String
        var memo_type: String?
            get() = definedExternally
            set(value) = definedExternally
        var memo: String?
            get() = definedExternally
            set(value) = definedExternally
    }
    interface Options {
        var allowHttp: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var timeout: Number?
            get() = definedExternally
            set(value) = definedExternally
    }

    companion object {
        fun resolve(value: String, opts: Options = definedExternally): Promise<Record>
        fun createForDomain(domain: String, opts: Options = definedExternally): Promise<FederationServer>
    }
}