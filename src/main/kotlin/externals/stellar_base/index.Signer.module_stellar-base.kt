@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)
@file:JsNonModule
@file:JsModule("stellar-base")

package Signer

external interface Ed25519PublicKey {
    var ed25519PublicKey: String
    var weight: Number?
}

external interface Sha256Hash {
    var sha256Hash: ByteArray
    var weight: Number?
}

external interface PreAuthTx {
    var preAuthTx: ByteArray
    var weight: Number?
}