@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package Horizon.ErrorResponseData

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
import Horizon.TransactionFailedExtras

external interface Base {
    var status: Number
    var title: String
    var type: String
    var details: String
    var instance: String
}

external interface RateLimitExceeded : Base {
    override var status: Number /* 429 */
    override var title: String /* "Rate Limit Exceeded" */
}

external interface InternalServerError : Base {
    override var status: Number /* 500 */
    override var title: String /* "Internal Server Error" */
}

external interface TransactionFailed : Base {
    override var status: Number /* 400 */
    override var title: String /* "Transaction Failed" */
    var extras: TransactionFailedExtras
}