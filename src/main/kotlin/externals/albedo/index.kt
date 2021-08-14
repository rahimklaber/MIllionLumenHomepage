@file:JsModule("@albedo-link/intent")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package externals.albedo

import kotlin.js.Promise

external interface Record<T, T1>

external class AlbedoIntent {
    fun publicKey(params: PublicKeyIntentParams): Promise<PublicKeyIntentResult>
    fun signMessage(params: SignMessageIntentParams): Promise<SignMessageIntentResult>
    fun tx(params: TxIntentParams): Promise<TxIntentResult>
    fun pay(params: PayIntentParams): Promise<PayIntentResult>
    fun trust(params: TrustIntentParams): Promise<TrustIntentResult>
    fun exchange(params: ExchangeIntentParams): Promise<ExchangeIntentResult>
    fun implicitFlow(params: ImplicitFlowIntentParams): Promise<ImplicitFlowIntentResult>
    fun manageAccount(params: ManageAccountIntentParams): Promise<ManageAccountIntentResult>
    fun isImplicitSessionAllowed(intent: String, pubkey: String): Boolean
    fun listImplicitSessions(): Array<AlbedoImplicitSessionDescriptor>
    fun forgetImplicitSession(pubkey: String): Unit
    fun generateRandomToken(): String
}

external interface PublicKeyIntentParams {
    var token: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: String?
        get() = definedExternally
        set(value) = definedExternally
    var require_existing: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PublicKeyIntentResult {
    var pubkey: String
    var signed_message: String
    var signature: String
}

external interface SignMessageIntentParams {
    var message: String
    var pubkey: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SignMessageIntentResult {
    var pubkey: String
    var original_message: String
    var signed_message: String
    var message_signature: String
}

external interface TxIntentParams {
    var xdr: String
    var pubkey: String?
        get() = definedExternally
        set(value) = definedExternally
    var network: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: String?
        get() = definedExternally
        set(value) = definedExternally
    var submit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TxIntentResult {
    var xdr: String
    var tx_hash: String
    var signed_envelope_xdr: String
    var network: String
    var result: Any?
}

external interface PayIntentParams {
    var amount: String
    var destination: String
    var asset_code: String?
        get() = definedExternally
        set(value) = definedExternally
    var asset_issuer: String?
        get() = definedExternally
        set(value) = definedExternally
    var memo: String?
        get() = definedExternally
        set(value) = definedExternally
    var memo_type: String?
        get() = definedExternally
        set(value) = definedExternally
    var pubkey: String?
        get() = definedExternally
        set(value) = definedExternally
    var network: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: String?
        get() = definedExternally
        set(value) = definedExternally
    var submit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PayIntentResult {
    var amount: String
    var destination: String
    var asset_code: String
    var asset_issuer: String
    var memo: String
    var memo_type: String
    var tx_hash: String
    var signed_envelope_xdr: String
    var pubkey: String
    var network: String
    var result: Any?
}

external interface TrustIntentParams {
    var asset_code: String
    var asset_issuer: String
    var limit: String?
        get() = definedExternally
        set(value) = definedExternally
    var memo: String?
        get() = definedExternally
        set(value) = definedExternally
    var memo_type: String?
        get() = definedExternally
        set(value) = definedExternally
    var pubkey: String?
        get() = definedExternally
        set(value) = definedExternally
    var network: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: String?
        get() = definedExternally
        set(value) = definedExternally
    var submit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TrustIntentResult {
    var asset_code: String
    var asset_issuer: String
    var limit: String
    var tx_hash: String
    var signed_envelope_xdr: String
    var pubkey: String
    var network: String
    var result: Any?
}

external interface ExchangeIntentParams {
    var amount: String
    var max_price: String
    var sell_asset_code: String?
        get() = definedExternally
        set(value) = definedExternally
    var sell_asset_issuer: String?
        get() = definedExternally
        set(value) = definedExternally
    var buy_asset_code: String?
        get() = definedExternally
        set(value) = definedExternally
    var buy_asset_issuer: String?
        get() = definedExternally
        set(value) = definedExternally
    var memo: String?
        get() = definedExternally
        set(value) = definedExternally
    var memo_type: String?
        get() = definedExternally
        set(value) = definedExternally
    var pubkey: String?
        get() = definedExternally
        set(value) = definedExternally
    var network: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: String?
        get() = definedExternally
        set(value) = definedExternally
    var submit: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ExchangeIntentResult {
    var amount: String
    var max_price: String
    var sell_asset_code: String
    var sell_asset_issuer: String
    var buy_asset_code: String
    var buy_asset_issuer: String
    var tx_hash: String
    var signed_envelope_xdr: String
    var pubkey: String
    var network: String
    var result: Any?
}

external interface ImplicitFlowIntentParams {
    var intents: dynamic /* String | Array<String> */
        get() = definedExternally
        set(value) = definedExternally
    var network: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ImplicitFlowIntentResult {
    var granted: Boolean
    var intents: Array<String>
    var grants: Array<String>
    var session: String
    var valid_until: Number
    var pubkey: String
    var network: String
}

external interface ManageAccountIntentParams {
    var pubkey: String
    var network: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ManageAccountIntentResult {
    var pubkey: String
}

@JsName("default")
external var albedo: AlbedoIntent

external interface AlbedoImplicitSessionDescriptor {
    var pubkey: String
    var session: String
    var valid_until: Number
    var grants: Array<String>
}

external interface AlbedoIntentInterfaceParamDescriptor {
    var description: String
    var required: Boolean
    var type: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AlbedoIntentInterfaceDescriptor {
    var risk: String /* "low" | "medium" | "high" */
    var title: String
    var description: String
    var unsafe: Boolean
    var implicitFlow: Boolean
    var params: Record<String, AlbedoIntentInterfaceParamDescriptor>
    var returns: Array<String>
}

external var intentInterface: Record<String, AlbedoIntentInterfaceDescriptor>

external interface AlbedoIntentErrorDescriptor {
    var message: String
    var code: Number
}

external var intentErrors: Record<String, AlbedoIntentErrorDescriptor>