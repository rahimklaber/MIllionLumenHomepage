@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
@file:JsNonModule
@file:JsModule("stellar-base")
package SignerOptions

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