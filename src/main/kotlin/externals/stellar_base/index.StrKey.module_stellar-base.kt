@file:JsQualifier("StrKey")
@file:JsNonModule
@file:JsModule("stellar-base")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package StrKey

external fun encodeEd25519PublicKey(data: ByteArray): String

external fun decodeEd25519PublicKey(data: String): ByteArray

external fun isValidEd25519PublicKey(Key: String): Boolean

external fun encodeEd25519SecretSeed(data: ByteArray): String

external fun decodeEd25519SecretSeed(data: String): ByteArray

external fun isValidEd25519SecretSeed(seed: String): Boolean

external fun encodePreAuthTx(data: ByteArray): String

external fun decodePreAuthTx(data: String): ByteArray

external fun encodeSha256Hash(data: ByteArray): String

external fun decodeSha256Hash(data: String): ByteArray