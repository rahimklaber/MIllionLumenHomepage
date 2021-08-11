@file:JsQualifier("Utils")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package Utils

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
import Keypair
import Transaction__0
import ServerApi.AccountRecordSigners
import FeeBumpTransaction

external fun buildChallengeTx(serverKeypair: Keypair, clientAccountID: String, homeDomain: String, timeout: Number?, networkPassphrase: String, webAuthDomain: String): String

external interface `T$209` {
    var tx: Transaction__0
    var clientAccountID: String
    var matchedHomeDomain: String
}

external fun readChallengeTx(challengeTx: String, serverAccountID: String, networkPassphrase: String, homeDomains: String, webAuthDomain: String): `T$209`

external fun readChallengeTx(challengeTx: String, serverAccountID: String, networkPassphrase: String, homeDomains: Array<String>, webAuthDomain: String): `T$209`

external fun verifyChallengeTxThreshold(challengeTx: String, serverAccountID: String, networkPassphrase: String, threshold: Number, signerSummary: Array<AccountRecordSigners>, homeDomains: String, webAuthDomain: String): Array<String>

external fun verifyChallengeTxThreshold(challengeTx: String, serverAccountID: String, networkPassphrase: String, threshold: Number, signerSummary: Array<AccountRecordSigners>, homeDomains: Array<String>, webAuthDomain: String): Array<String>

external fun verifyChallengeTxSigners(challengeTx: String, serverAccountID: String, networkPassphrase: String, signers: Array<String>, homeDomains: String, webAuthDomain: String): Array<String>

external fun verifyChallengeTxSigners(challengeTx: String, serverAccountID: String, networkPassphrase: String, signers: Array<String>, homeDomains: Array<String>, webAuthDomain: String): Array<String>

external fun verifyTxSignedBy(transaction: FeeBumpTransaction, accountID: String): Boolean

external fun verifyTxSignedBy(transaction: Transaction__0, accountID: String): Boolean

external fun gatherTxSigners(transaction: FeeBumpTransaction, signers: Array<String>): Array<String>

external fun gatherTxSigners(transaction: Transaction__0, signers: Array<String>): Array<String>