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
import ServerApi.TransactionRecord
import ServerApi.CollectionPage

external open class TransactionCallBuilder(serverUrl: URI) : CallBuilder<CollectionPage<TransactionRecord>> {
    open fun transaction(transactionId: String): CallBuilder<TransactionRecord>
    open fun forAccount(accountId: String): TransactionCallBuilder /* this */
    open fun forClaimableBalance(claimableBalanceId: String): TransactionCallBuilder /* this */
    open fun forLedger(sequence: Number): TransactionCallBuilder /* this */
    open fun forLedger(sequence: String): TransactionCallBuilder /* this */
    open fun includeFailed(value: Boolean): TransactionCallBuilder /* this */
}