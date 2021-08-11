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
import xdr.ClaimPredicate
import buffer.global.Buffer
import xdr.DecoratedSignature
import xdr.AccountId
import xdr.PublicKey
import MemoType.None
import MemoType.Hash
import MemoType.ID
import MemoType.Return
import MemoType.Text
import xdr.TransactionEnvelope
import TransactionBuilder.TransactionBuilderOptions
import xdrHidden.Operation2__0
import TransactionBuilder.`T$86`

external open class Account(accountId: String, sequence: String) {
    open fun accountId(): String
    open fun sequenceNumber(): String
    open fun incrementSequenceNumber()
    open fun createSubaccount(id: String): MuxedAccount
}

external open class MuxedAccount(account: Account, sequence: String) {
    open fun accountId(): String
    open fun sequenceNumber(): String
    open fun incrementSequenceNumber()
    open fun createSubaccount(id: String): MuxedAccount
    open fun baseAccount(): Account
    open fun id(): String
    open fun setId(id: String): MuxedAccount
    open fun toXDRObject(): xdr.MuxedAccount
    open fun equals(otherMuxedAccount: MuxedAccount): Boolean

    companion object {
        fun fromAddress(mAddress: String, sequenceNum: String): MuxedAccount
        fun parseBaseAddress(mAddress: String): String
    }
}

external open class Asset(code: String, issuer: String = definedExternally) {
    open fun getCode(): String
    open fun getIssuer(): String
    open fun getAssetType(): String /* "native" | "credit_alphanum4" | "credit_alphanum12" */
    open fun isNative(): Boolean
    open fun equals(other: Asset): Boolean
    open fun toXDRObject(): xdr.Asset
    open var code: String
    open var issuer: String

    companion object {
        fun native(): Asset
        fun fromOperation(xdr: xdr.Asset): Asset
    }
}

external open class Claimant(destination: String, predicate: ClaimPredicate = definedExternally) {
    open var destination: String
    open var predicate: ClaimPredicate
    open fun toXDRObject(): xdr.Claimant

    companion object {
        fun fromXDR(claimantXdr: xdr.Claimant): Claimant
        fun predicateUnconditional(): ClaimPredicate
        fun predicateAnd(left: ClaimPredicate, right: ClaimPredicate): ClaimPredicate
        fun predicateOr(left: ClaimPredicate, right: ClaimPredicate): ClaimPredicate
        fun predicateNot(predicate: ClaimPredicate): ClaimPredicate
        fun predicateBeforeAbsoluteTime(absBefore: String): ClaimPredicate
        fun predicateBeforeRelativeTime(seconds: String): ClaimPredicate
    }
}

external var FastSigning: Boolean

external interface `T$82` {
    var type: String /* "ed25519" */
    var secretKey: String
    var publicKey: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$83` {
    var type: String /* "ed25519" */
    var publicKey: String
}

external open class Keypair {
    constructor(keys: `T$82`)
    constructor(keys: `T$83`)
    open var type: String /* "ed25519" */
    open fun publicKey(): String
    open fun secret(): String
    open fun rawPublicKey(): Buffer
    open fun rawSecretKey(): Buffer
    open fun canSign(): Boolean
    open fun sign(data: Buffer): Buffer
    open fun signDecorated(data: Buffer): DecoratedSignature
    open fun signatureHint(): Buffer
    open fun verify(data: Buffer, signature: Buffer): Boolean
    open fun xdrAccountId(): AccountId
    open fun xdrPublicKey(): PublicKey
    open fun xdrMuxedAccount(id: String): xdr.MuxedAccount

    companion object {
        fun fromRawEd25519Seed(secretSeed: Buffer): Keypair
        fun fromSecret(secretKey: String): Keypair
        fun master(networkPassphrase: String): Keypair
        fun fromPublicKey(publicKey: String): Keypair
        fun random(): Keypair
    }
}

external var MemoNone: Any

external var MemoID: Any

external var MemoText: Any

external var MemoHash: Any

external var MemoReturn: Any

external open class Memo<T> {
    constructor(type: None, value: Nothing? = definedExternally)
    constructor(type: None)
    constructor(type: Hash, value: Buffer)
    constructor(type: Hash, value: String)
    constructor(type: T, value: String?)
    constructor(type: T, value: Buffer?)
    open var type: T
    open var value: Any
    open fun toXDRObject(): xdr.Memo

    companion object {
        fun fromXDRObject(memo: xdr.Memo): Memo__0
        fun hash(hash: String): Memo<Hash>
        fun id(id: String): Memo<ID>
        fun none(): Memo<None>
        fun `return`(hash: String): Memo<Return>
        fun text(text: String): Memo<Text>
    }
}

external open class Memo__0 : Memo<dynamic /* MemoType.None | MemoType.ID | MemoType.Text | MemoType.Hash | MemoType.Return */>

external enum class Networks {
    PUBLIC /* = 'Public Global Stellar Network ; September 2015' */,
    TESTNET /* = 'Test SDF Network ; September 2015' */
}

external var AuthRequiredFlag: Number /* 1 */

external var AuthRevocableFlag: Number /* 2 */

external var AuthImmutableFlag: Number /* 4 */

external var AuthClawbackEnabledFlag: Number /* 8 */

external open class TransactionI {
    open fun addSignature(publicKey: String, signature: String)
    open var fee: String
    open fun getKeypairSignature(keypair: Keypair): String
    open fun hash(): Buffer
    open var networkPassphrase: String
    open fun sign(vararg keypairs: Keypair)
    open fun signatureBase(): Buffer
    open var signatures: Array<DecoratedSignature>
    open fun signHashX(preimage: Buffer)
    open fun signHashX(preimage: String)
    open fun toEnvelope(): TransactionEnvelope
    open fun toXDR(): String
}

external open class FeeBumpTransaction : TransactionI {
    constructor(envelope: String, networkPassphrase: String, withMuxing: Boolean = definedExternally)
    constructor(envelope: String, networkPassphrase: String)
    constructor(envelope: TransactionEnvelope, networkPassphrase: String, withMuxing: Boolean = definedExternally)
    constructor(envelope: TransactionEnvelope, networkPassphrase: String)
    open var feeSource: String
    open var innerTransaction: Transaction__0
}

external interface `T$85` {
    var minTime: String
    var maxTime: String
}

external open class Transaction<TMemo : Memo__0, TOps : Array<dynamic /* Operation.CreateAccount | Operation.Payment | Operation.PathPaymentStrictReceive | Operation.PathPaymentStrictSend | Operation.CreatePassiveSellOffer | Operation.ManageSellOffer | Operation.ManageBuyOffer | SetOptions__0 | Operation.ChangeTrust | Operation.AllowTrust | Operation.AccountMerge | Operation.Inflation | Operation.ManageData | Operation.BumpSequence | Operation.CreateClaimableBalance | Operation.ClaimClaimableBalance | Operation.BeginSponsoringFutureReserves | Operation.EndSponsoringFutureReserves | Operation.RevokeAccountSponsorship | Operation.RevokeTrustlineSponsorship | Operation.RevokeOfferSponsorship | Operation.RevokeDataSponsorship | Operation.RevokeClaimableBalanceSponsorship | Operation.RevokeSignerSponsorship | Operation.Clawback | Operation.ClawbackClaimableBalance | Operation.SetTrustLineFlags */>> : TransactionI {
    constructor(envelope: String, networkPassphrase: String, withMuxing: Boolean = definedExternally)
    constructor(envelope: String, networkPassphrase: String)
    constructor(envelope: TransactionEnvelope, networkPassphrase: String, withMuxing: Boolean = definedExternally)
    constructor(envelope: TransactionEnvelope, networkPassphrase: String)
    open var memo: TMemo
    open var operations: TOps
    open var sequence: String
    open var source: String
    open var timeBounds: `T$85`
}

external open class Transaction__0 : Transaction<Memo__0, Array<dynamic /* Operation.CreateAccount | Operation.Payment | Operation.PathPaymentStrictReceive | Operation.PathPaymentStrictSend | Operation.CreatePassiveSellOffer | Operation.ManageSellOffer | Operation.ManageBuyOffer | SetOptions__0 | Operation.ChangeTrust | Operation.AllowTrust | Operation.AccountMerge | Operation.Inflation | Operation.ManageData | Operation.BumpSequence | Operation.CreateClaimableBalance | Operation.ClaimClaimableBalance | Operation.BeginSponsoringFutureReserves | Operation.EndSponsoringFutureReserves | Operation.RevokeAccountSponsorship | Operation.RevokeTrustlineSponsorship | Operation.RevokeOfferSponsorship | Operation.RevokeDataSponsorship | Operation.RevokeClaimableBalanceSponsorship | Operation.RevokeSignerSponsorship | Operation.Clawback | Operation.ClawbackClaimableBalance | Operation.SetTrustLineFlags */>>

external var BASE_FEE: Any

external var TimeoutInfinite: Any

external open class TransactionBuilder(sourceAccount: Account, options: TransactionBuilderOptions = definedExternally) {
    open fun addOperation(operation: Operation2__0): TransactionBuilder /* this */
    open fun addMemo(memo: Memo__0): TransactionBuilder /* this */
    open fun setTimeout(timeoutInSeconds: Number): TransactionBuilder /* this */
    open fun build(): Transaction__0
    open fun setNetworkPassphrase(networkPassphrase: String): TransactionBuilder /* this */
    open var supportMuxedAccounts: Boolean
    interface `T$86` {
        var minTime: dynamic /* Number? | String? */
            get() = definedExternally
            set(value) = definedExternally
        var maxTime: dynamic /* Number? | String? */
            get() = definedExternally
            set(value) = definedExternally
    }
    interface TransactionBuilderOptions {
        var fee: String
        var timebounds: `T$86`?
            get() = definedExternally
            set(value) = definedExternally
        var memo: Memo__0?
            get() = definedExternally
            set(value) = definedExternally
        var networkPassphrase: String?
            get() = definedExternally
            set(value) = definedExternally
        var v1: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var withMuxing: Boolean?
            get() = definedExternally
            set(value) = definedExternally
    }

    companion object {
        fun buildFeeBumpTransaction(feeSource: Keypair, baseFee: String, innerTx: Transaction__0, networkPassphrase: String, withMuxing: Boolean = definedExternally): FeeBumpTransaction
        fun buildFeeBumpTransaction(feeSource: String, baseFee: String, innerTx: Transaction__0, networkPassphrase: String, withMuxing: Boolean = definedExternally): FeeBumpTransaction
        fun fromXDR(envelope: String, networkPassphrase: String): dynamic /* Transaction__0 | FeeBumpTransaction */
        fun fromXDR(envelope: TransactionEnvelope, networkPassphrase: String): dynamic /* Transaction__0 | FeeBumpTransaction */
    }
}

external fun hash(data: Buffer): Buffer

external fun sign(data: Buffer, rawSecret: Buffer): Buffer

external fun verify(data: Buffer, signature: Buffer, rawPublicKey: Buffer): Boolean