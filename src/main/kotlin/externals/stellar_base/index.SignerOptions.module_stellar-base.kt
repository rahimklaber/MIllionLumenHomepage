@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsNonModule
@file:JsModule("stellar-base")

package SignerOptions

external interface Ed25519PublicKey {
    var ed25519PublicKey: String
    var weight: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface Sha256Hash {
    var sha256Hash: dynamic /* Buffer | String */
        get() = definedExternally
        set(value) = definedExternally
    var weight: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface PreAuthTx {
    var preAuthTx: dynamic /* Buffer | String */
        get() = definedExternally
        set(value) = definedExternally
    var weight: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}