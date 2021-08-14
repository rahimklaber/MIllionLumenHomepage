@file:JsQualifier("StrKey")
@file:JsNonModule
@file:JsModule("stellar-base")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package StrKey

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