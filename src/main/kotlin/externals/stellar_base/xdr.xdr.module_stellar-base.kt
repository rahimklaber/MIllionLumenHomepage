@file:JsQualifier("xdr")
@file:JsNonModule
@file:JsModule("stellar-base")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package xdr

import xdrHidden.Operation

external interface SignedInt {
    var MAX_VALUE: Number /* 2147483647 */
    var MIN_VALUE: String /* "-2147483648" */
    fun read(io: ByteArray): Number
    fun write(value: Number, io: ByteArray)
    fun isValid(value: Number): Boolean
    fun toXDR(value: Number): ByteArray
    fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Number
    fun fromXDR(input: ByteArray): Number
    fun fromXDR(input: String, format: String /* "hex" | "base64" */): Number
    fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
    fun validateXDR(input: ByteArray): Boolean
    fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
}

external interface UnsignedInt {
    var MAX_VALUE: Number /* 4294967295 */
    var MIN_VALUE: Number /* 0 */
    fun read(io: ByteArray): Number
    fun write(value: Number, io: ByteArray)
    fun isValid(value: Number): Boolean
    fun toXDR(value: Number): ByteArray
    fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Number
    fun fromXDR(input: ByteArray): Number
    fun fromXDR(input: String, format: String /* "hex" | "base64" */): Number
    fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
    fun validateXDR(input: ByteArray): Boolean
    fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
}

open external class Hyper(low: Number, high: Number) {
    open var low: Number
    open var high: Number
    open var unsigned: Boolean
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun toXDR(value: Hyper): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Hyper
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Hyper
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
        var MAX_VALUE: Hyper
        var MIN_VALUE: Hyper
        fun read(io: ByteArray): Hyper
        fun write(value: Hyper, io: ByteArray)
        fun fromString(input: String): Hyper
        fun fromBytes(low: Number, high: Number): Hyper
        fun isValid(value: Hyper): Boolean
    }
}

open external class UnsignedHyper(low: Number, high: Number) {
    open var low: Number
    open var high: Number
    open var unsigned: Boolean
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun toXDR(value: UnsignedHyper): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): UnsignedHyper
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): UnsignedHyper
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
        var MAX_VALUE: UnsignedHyper
        var MIN_VALUE: UnsignedHyper
        fun read(io: ByteArray): UnsignedHyper
        fun write(value: UnsignedHyper, io: ByteArray)
        fun fromString(input: String): UnsignedHyper
        fun fromBytes(low: Number, high: Number): UnsignedHyper
        fun isValid(value: UnsignedHyper): Boolean
    }
}

open external class XDRString(maxLength: Number /* 4294967295 */) {
    open fun read(io: ByteArray): ByteArray
    open fun readString(io: ByteArray): String
    open fun write(value: String, io: ByteArray)
    open fun write(value: ByteArray, io: ByteArray)
    open fun isValid(value: String): Boolean
    open fun isValid(value: Array<Number>): Boolean
    open fun isValid(value: ByteArray): Boolean
    open fun toXDR(value: String): ByteArray
    open fun toXDR(value: ByteArray): ByteArray
    open fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ByteArray
    open fun fromXDR(input: ByteArray): ByteArray
    open fun fromXDR(input: String, format: String /* "hex" | "base64" */): ByteArray
    open fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
    open fun validateXDR(input: ByteArray): Boolean
    open fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
}

open external class XDRArray<T> {
    open fun read(io: ByteArray): ByteArray
    open fun write(value: Array<T>, io: ByteArray)
    open fun isValid(value: Array<T>): Boolean
    open fun toXDR(value: Array<T>): ByteArray
    open fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Array<T>
    open fun fromXDR(input: ByteArray): Array<T>
    open fun fromXDR(input: String, format: String /* "hex" | "base64" */): Array<T>
    open fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
    open fun validateXDR(input: ByteArray): Boolean
    open fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
}

open external class Opaque(length: Number) {
    open fun read(io: ByteArray): ByteArray
    open fun write(value: ByteArray, io: ByteArray)
    open fun isValid(value: ByteArray): Boolean
    open fun toXDR(value: ByteArray): ByteArray
    open fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ByteArray
    open fun fromXDR(input: ByteArray): ByteArray
    open fun fromXDR(input: String, format: String /* "hex" | "base64" */): ByteArray
    open fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
    open fun validateXDR(input: ByteArray): Boolean
    open fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
}

open external class VarOpaque(length: Number) : Opaque

external interface `T$82` {
    fun read(io: Any): Any
    fun write(value: Any, io: ByteArray)
    fun isValid(value: Any): Boolean
}

open external class Option(childType: `T$82`) {
    open fun read(io: ByteArray): Any
    open fun write(value: Any, io: ByteArray)
    open fun isValid(value: Any): Boolean
    open fun toXDR(value: Any): ByteArray
    open fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Any
    open fun fromXDR(input: ByteArray): Any
    open fun fromXDR(input: String, format: String /* "hex" | "base64" */): Any
    open fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
    open fun validateXDR(input: ByteArray): Boolean
    open fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
}

open external class AssetType {
    open var name: String /* "assetTypeNative" | "assetTypeCreditAlphanum4" | "assetTypeCreditAlphanum12" */
    open var value: Number /* 0 | 1 | 2 */

    companion object {
        fun assetTypeNative(): AssetType
        fun assetTypeCreditAlphanum4(): AssetType
        fun assetTypeCreditAlphanum12(): AssetType
    }
}

open external class ThresholdIndices {
    open var name: String /* "thresholdMasterWeight" | "thresholdLow" | "thresholdMed" | "thresholdHigh" */
    open var value: Number /* 0 | 1 | 2 | 3 */

    companion object {
        fun thresholdMasterWeight(): ThresholdIndices
        fun thresholdLow(): ThresholdIndices
        fun thresholdMed(): ThresholdIndices
        fun thresholdHigh(): ThresholdIndices
    }
}

open external class LedgerEntryType {
    open var name: String /* "account" | "trustline" | "offer" | "data" | "claimableBalance" */
    open var value: Number /* 0 | 1 | 2 | 3 | 4 */

    companion object {
        fun account(): LedgerEntryType
        fun trustline(): LedgerEntryType
        fun offer(): LedgerEntryType
        fun data(): LedgerEntryType
        fun claimableBalance(): LedgerEntryType
    }
}

open external class AccountFlags {
    open var name: String /* "authRequiredFlag" | "authRevocableFlag" | "authImmutableFlag" | "authClawbackEnabledFlag" */
    open var value: Number /* 1 | 2 | 4 | 8 */

    companion object {
        fun authRequiredFlag(): AccountFlags
        fun authRevocableFlag(): AccountFlags
        fun authImmutableFlag(): AccountFlags
        fun authClawbackEnabledFlag(): AccountFlags
    }
}

open external class TrustLineFlags {
    open var name: String /* "authorizedFlag" | "authorizedToMaintainLiabilitiesFlag" | "trustlineClawbackEnabledFlag" */
    open var value: Number /* 1 | 2 | 4 */

    companion object {
        fun authorizedFlag(): TrustLineFlags
        fun authorizedToMaintainLiabilitiesFlag(): TrustLineFlags
        fun trustlineClawbackEnabledFlag(): TrustLineFlags
    }
}

open external class OfferEntryFlags {
    open var name: String /* "passiveFlag" */
    open var value: Number /* 1 */

    companion object {
        fun passiveFlag(): OfferEntryFlags
    }
}

open external class ClaimPredicateType {
    open var name: String /* "claimPredicateUnconditional" | "claimPredicateAnd" | "claimPredicateOr" | "claimPredicateNot" | "claimPredicateBeforeAbsoluteTime" | "claimPredicateBeforeRelativeTime" */
    open var value: Number /* 0 | 1 | 2 | 3 | 4 | 5 */

    companion object {
        fun claimPredicateUnconditional(): ClaimPredicateType
        fun claimPredicateAnd(): ClaimPredicateType
        fun claimPredicateOr(): ClaimPredicateType
        fun claimPredicateNot(): ClaimPredicateType
        fun claimPredicateBeforeAbsoluteTime(): ClaimPredicateType
        fun claimPredicateBeforeRelativeTime(): ClaimPredicateType
    }
}

open external class ClaimantType {
    open var name: String /* "claimantTypeV0" */
    open var value: Number /* 0 */

    companion object {
        fun claimantTypeV0(): ClaimantType
    }
}

open external class ClaimableBalanceIdType {
    open var name: String /* "claimableBalanceIdTypeV0" */
    open var value: Number /* 0 */

    companion object {
        fun claimableBalanceIdTypeV0(): ClaimableBalanceIdType
    }
}

open external class ClaimableBalanceFlags {
    open var name: String /* "claimableBalanceClawbackEnabledFlag" */
    open var value: Number /* 1 */

    companion object {
        fun claimableBalanceClawbackEnabledFlag(): ClaimableBalanceFlags
    }
}

open external class EnvelopeType {
    open var name: String /* "envelopeTypeTxV0" | "envelopeTypeScp" | "envelopeTypeTx" | "envelopeTypeAuth" | "envelopeTypeScpvalue" | "envelopeTypeTxFeeBump" | "envelopeTypeOpId" */
    open var value: Number /* 0 | 1 | 2 | 3 | 4 | 5 | 6 */

    companion object {
        fun envelopeTypeTxV0(): EnvelopeType
        fun envelopeTypeScp(): EnvelopeType
        fun envelopeTypeTx(): EnvelopeType
        fun envelopeTypeAuth(): EnvelopeType
        fun envelopeTypeScpvalue(): EnvelopeType
        fun envelopeTypeTxFeeBump(): EnvelopeType
        fun envelopeTypeOpId(): EnvelopeType
    }
}

open external class StellarValueType {
    open var name: String /* "stellarValueBasic" | "stellarValueSigned" */
    open var value: Number /* 0 | 1 */

    companion object {
        fun stellarValueBasic(): StellarValueType
        fun stellarValueSigned(): StellarValueType
    }
}

open external class LedgerUpgradeType {
    open var name: String /* "ledgerUpgradeVersion" | "ledgerUpgradeBaseFee" | "ledgerUpgradeMaxTxSetSize" | "ledgerUpgradeBaseReserve" */
    open var value: Number /* 1 | 2 | 3 | 4 */

    companion object {
        fun ledgerUpgradeVersion(): LedgerUpgradeType
        fun ledgerUpgradeBaseFee(): LedgerUpgradeType
        fun ledgerUpgradeMaxTxSetSize(): LedgerUpgradeType
        fun ledgerUpgradeBaseReserve(): LedgerUpgradeType
    }
}

open external class BucketEntryType {
    open var name: String /* "metaentry" | "liveentry" | "deadentry" | "initentry" */
    open var value: dynamic /* "-1" | 0 | 1 | 2 */

    companion object {
        fun metaentry(): BucketEntryType
        fun liveentry(): BucketEntryType
        fun deadentry(): BucketEntryType
        fun initentry(): BucketEntryType
    }
}

open external class LedgerEntryChangeType {
    open var name: String /* "ledgerEntryCreated" | "ledgerEntryUpdated" | "ledgerEntryRemoved" | "ledgerEntryState" */
    open var value: Number /* 0 | 1 | 2 | 3 */

    companion object {
        fun ledgerEntryCreated(): LedgerEntryChangeType
        fun ledgerEntryUpdated(): LedgerEntryChangeType
        fun ledgerEntryRemoved(): LedgerEntryChangeType
        fun ledgerEntryState(): LedgerEntryChangeType
    }
}

open external class ErrorCode {
    open var name: String /* "errMisc" | "errData" | "errConf" | "errAuth" | "errLoad" */
    open var value: Number /* 0 | 1 | 2 | 3 | 4 */

    companion object {
        fun errMisc(): ErrorCode
        fun errData(): ErrorCode
        fun errConf(): ErrorCode
        fun errAuth(): ErrorCode
        fun errLoad(): ErrorCode
    }
}

open external class IpAddrType {
    open var name: String /* "iPv4" | "iPv6" */
    open var value: Number /* 0 | 1 */

    companion object {
        fun iPv4(): IpAddrType
        fun iPv6(): IpAddrType
    }
}

open external class MessageType {
    open var name: String /* "errorMsg" | "auth" | "dontHave" | "getPeers" | "peers" | "getTxSet" | "txSet" | "transaction" | "getScpQuorumset" | "scpQuorumset" | "scpMessage" | "getScpState" | "hello" | "surveyRequest" | "surveyResponse" */
    open var value: Number /* 0 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 */

    companion object {
        fun errorMsg(): MessageType
        fun auth(): MessageType
        fun dontHave(): MessageType
        fun getPeers(): MessageType
        fun peers(): MessageType
        fun getTxSet(): MessageType
        fun txSet(): MessageType
        fun transaction(): MessageType
        fun getScpQuorumset(): MessageType
        fun scpQuorumset(): MessageType
        fun scpMessage(): MessageType
        fun getScpState(): MessageType
        fun hello(): MessageType
        fun surveyRequest(): MessageType
        fun surveyResponse(): MessageType
    }
}

open external class SurveyMessageCommandType {
    open var name: String /* "surveyTopology" */
    open var value: Number /* 0 */

    companion object {
        fun surveyTopology(): SurveyMessageCommandType
    }
}

open external class ScpStatementType {
    open var name: String /* "scpStPrepare" | "scpStConfirm" | "scpStExternalize" | "scpStNominate" */
    open var value: Number /* 0 | 1 | 2 | 3 */

    companion object {
        fun scpStPrepare(): ScpStatementType
        fun scpStConfirm(): ScpStatementType
        fun scpStExternalize(): ScpStatementType
        fun scpStNominate(): ScpStatementType
    }
}

open external class OperationType {
    open var name: String /* "createAccount" | "payment" | "pathPaymentStrictReceive" | "manageSellOffer" | "createPassiveSellOffer" | "setOptions" | "changeTrust" | "allowTrust" | "accountMerge" | "inflation" | "manageData" | "bumpSequence" | "manageBuyOffer" | "pathPaymentStrictSend" | "createClaimableBalance" | "claimClaimableBalance" | "beginSponsoringFutureReserves" | "endSponsoringFutureReserves" | "revokeSponsorship" | "clawback" | "clawbackClaimableBalance" | "setTrustLineFlags" */
    open var value: Number /* 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 */

    companion object {
        fun createAccount(): OperationType
        fun payment(): OperationType
        fun pathPaymentStrictReceive(): OperationType
        fun manageSellOffer(): OperationType
        fun createPassiveSellOffer(): OperationType
        fun setOptions(): OperationType
        fun changeTrust(): OperationType
        fun allowTrust(): OperationType
        fun accountMerge(): OperationType
        fun inflation(): OperationType
        fun manageData(): OperationType
        fun bumpSequence(): OperationType
        fun manageBuyOffer(): OperationType
        fun pathPaymentStrictSend(): OperationType
        fun createClaimableBalance(): OperationType
        fun claimClaimableBalance(): OperationType
        fun beginSponsoringFutureReserves(): OperationType
        fun endSponsoringFutureReserves(): OperationType
        fun revokeSponsorship(): OperationType
        fun clawback(): OperationType
        fun clawbackClaimableBalance(): OperationType
        fun setTrustLineFlags(): OperationType
    }
}

open external class RevokeSponsorshipType {
    open var name: String /* "revokeSponsorshipLedgerEntry" | "revokeSponsorshipSigner" */
    open var value: Number /* 0 | 1 */

    companion object {
        fun revokeSponsorshipLedgerEntry(): RevokeSponsorshipType
        fun revokeSponsorshipSigner(): RevokeSponsorshipType
    }
}

open external class MemoType {
    open var name: String /* "memoNone" | "memoText" | "memoId" | "memoHash" | "memoReturn" */
    open var value: Number /* 0 | 1 | 2 | 3 | 4 */

    companion object {
        fun memoNone(): MemoType
        fun memoText(): MemoType
        fun memoId(): MemoType
        fun memoHash(): MemoType
        fun memoReturn(): MemoType
    }
}

open external class CreateAccountResultCode {
    open var name: String /* "createAccountSuccess" | "createAccountMalformed" | "createAccountUnderfunded" | "createAccountLowReserve" | "createAccountAlreadyExist" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" */

    companion object {
        fun createAccountSuccess(): CreateAccountResultCode
        fun createAccountMalformed(): CreateAccountResultCode
        fun createAccountUnderfunded(): CreateAccountResultCode
        fun createAccountLowReserve(): CreateAccountResultCode
        fun createAccountAlreadyExist(): CreateAccountResultCode
    }
}

open external class PaymentResultCode {
    open var name: String /* "paymentSuccess" | "paymentMalformed" | "paymentUnderfunded" | "paymentSrcNoTrust" | "paymentSrcNotAuthorized" | "paymentNoDestination" | "paymentNoTrust" | "paymentNotAuthorized" | "paymentLineFull" | "paymentNoIssuer" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" */

    companion object {
        fun paymentSuccess(): PaymentResultCode
        fun paymentMalformed(): PaymentResultCode
        fun paymentUnderfunded(): PaymentResultCode
        fun paymentSrcNoTrust(): PaymentResultCode
        fun paymentSrcNotAuthorized(): PaymentResultCode
        fun paymentNoDestination(): PaymentResultCode
        fun paymentNoTrust(): PaymentResultCode
        fun paymentNotAuthorized(): PaymentResultCode
        fun paymentLineFull(): PaymentResultCode
        fun paymentNoIssuer(): PaymentResultCode
    }
}

open external class PathPaymentStrictReceiveResultCode {
    open var name: String /* "pathPaymentStrictReceiveSuccess" | "pathPaymentStrictReceiveMalformed" | "pathPaymentStrictReceiveUnderfunded" | "pathPaymentStrictReceiveSrcNoTrust" | "pathPaymentStrictReceiveSrcNotAuthorized" | "pathPaymentStrictReceiveNoDestination" | "pathPaymentStrictReceiveNoTrust" | "pathPaymentStrictReceiveNotAuthorized" | "pathPaymentStrictReceiveLineFull" | "pathPaymentStrictReceiveNoIssuer" | "pathPaymentStrictReceiveTooFewOffers" | "pathPaymentStrictReceiveOfferCrossSelf" | "pathPaymentStrictReceiveOverSendmax" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" | "-10" | "-11" | "-12" */

    companion object {
        fun pathPaymentStrictReceiveSuccess(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveMalformed(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveUnderfunded(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveSrcNoTrust(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveSrcNotAuthorized(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveNoDestination(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveNoTrust(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveNotAuthorized(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveLineFull(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveNoIssuer(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveTooFewOffers(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveOfferCrossSelf(): PathPaymentStrictReceiveResultCode
        fun pathPaymentStrictReceiveOverSendmax(): PathPaymentStrictReceiveResultCode
    }
}

open external class PathPaymentStrictSendResultCode {
    open var name: String /* "pathPaymentStrictSendSuccess" | "pathPaymentStrictSendMalformed" | "pathPaymentStrictSendUnderfunded" | "pathPaymentStrictSendSrcNoTrust" | "pathPaymentStrictSendSrcNotAuthorized" | "pathPaymentStrictSendNoDestination" | "pathPaymentStrictSendNoTrust" | "pathPaymentStrictSendNotAuthorized" | "pathPaymentStrictSendLineFull" | "pathPaymentStrictSendNoIssuer" | "pathPaymentStrictSendTooFewOffers" | "pathPaymentStrictSendOfferCrossSelf" | "pathPaymentStrictSendUnderDestmin" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" | "-10" | "-11" | "-12" */

    companion object {
        fun pathPaymentStrictSendSuccess(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendMalformed(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendUnderfunded(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendSrcNoTrust(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendSrcNotAuthorized(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendNoDestination(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendNoTrust(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendNotAuthorized(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendLineFull(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendNoIssuer(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendTooFewOffers(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendOfferCrossSelf(): PathPaymentStrictSendResultCode
        fun pathPaymentStrictSendUnderDestmin(): PathPaymentStrictSendResultCode
    }
}

open external class ManageSellOfferResultCode {
    open var name: String /* "manageSellOfferSuccess" | "manageSellOfferMalformed" | "manageSellOfferSellNoTrust" | "manageSellOfferBuyNoTrust" | "manageSellOfferSellNotAuthorized" | "manageSellOfferBuyNotAuthorized" | "manageSellOfferLineFull" | "manageSellOfferUnderfunded" | "manageSellOfferCrossSelf" | "manageSellOfferSellNoIssuer" | "manageSellOfferBuyNoIssuer" | "manageSellOfferNotFound" | "manageSellOfferLowReserve" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" | "-10" | "-11" | "-12" */

    companion object {
        fun manageSellOfferSuccess(): ManageSellOfferResultCode
        fun manageSellOfferMalformed(): ManageSellOfferResultCode
        fun manageSellOfferSellNoTrust(): ManageSellOfferResultCode
        fun manageSellOfferBuyNoTrust(): ManageSellOfferResultCode
        fun manageSellOfferSellNotAuthorized(): ManageSellOfferResultCode
        fun manageSellOfferBuyNotAuthorized(): ManageSellOfferResultCode
        fun manageSellOfferLineFull(): ManageSellOfferResultCode
        fun manageSellOfferUnderfunded(): ManageSellOfferResultCode
        fun manageSellOfferCrossSelf(): ManageSellOfferResultCode
        fun manageSellOfferSellNoIssuer(): ManageSellOfferResultCode
        fun manageSellOfferBuyNoIssuer(): ManageSellOfferResultCode
        fun manageSellOfferNotFound(): ManageSellOfferResultCode
        fun manageSellOfferLowReserve(): ManageSellOfferResultCode
    }
}

open external class ManageOfferEffect {
    open var name: String /* "manageOfferCreated" | "manageOfferUpdated" | "manageOfferDeleted" */
    open var value: Number /* 0 | 1 | 2 */

    companion object {
        fun manageOfferCreated(): ManageOfferEffect
        fun manageOfferUpdated(): ManageOfferEffect
        fun manageOfferDeleted(): ManageOfferEffect
    }
}

open external class ManageBuyOfferResultCode {
    open var name: String /* "manageBuyOfferSuccess" | "manageBuyOfferMalformed" | "manageBuyOfferSellNoTrust" | "manageBuyOfferBuyNoTrust" | "manageBuyOfferSellNotAuthorized" | "manageBuyOfferBuyNotAuthorized" | "manageBuyOfferLineFull" | "manageBuyOfferUnderfunded" | "manageBuyOfferCrossSelf" | "manageBuyOfferSellNoIssuer" | "manageBuyOfferBuyNoIssuer" | "manageBuyOfferNotFound" | "manageBuyOfferLowReserve" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" | "-10" | "-11" | "-12" */

    companion object {
        fun manageBuyOfferSuccess(): ManageBuyOfferResultCode
        fun manageBuyOfferMalformed(): ManageBuyOfferResultCode
        fun manageBuyOfferSellNoTrust(): ManageBuyOfferResultCode
        fun manageBuyOfferBuyNoTrust(): ManageBuyOfferResultCode
        fun manageBuyOfferSellNotAuthorized(): ManageBuyOfferResultCode
        fun manageBuyOfferBuyNotAuthorized(): ManageBuyOfferResultCode
        fun manageBuyOfferLineFull(): ManageBuyOfferResultCode
        fun manageBuyOfferUnderfunded(): ManageBuyOfferResultCode
        fun manageBuyOfferCrossSelf(): ManageBuyOfferResultCode
        fun manageBuyOfferSellNoIssuer(): ManageBuyOfferResultCode
        fun manageBuyOfferBuyNoIssuer(): ManageBuyOfferResultCode
        fun manageBuyOfferNotFound(): ManageBuyOfferResultCode
        fun manageBuyOfferLowReserve(): ManageBuyOfferResultCode
    }
}

open external class SetOptionsResultCode {
    open var name: String /* "setOptionsSuccess" | "setOptionsLowReserve" | "setOptionsTooManySigners" | "setOptionsBadFlags" | "setOptionsInvalidInflation" | "setOptionsCantChange" | "setOptionsUnknownFlag" | "setOptionsThresholdOutOfRange" | "setOptionsBadSigner" | "setOptionsInvalidHomeDomain" | "setOptionsAuthRevocableRequired" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" | "-10" */

    companion object {
        fun setOptionsSuccess(): SetOptionsResultCode
        fun setOptionsLowReserve(): SetOptionsResultCode
        fun setOptionsTooManySigners(): SetOptionsResultCode
        fun setOptionsBadFlags(): SetOptionsResultCode
        fun setOptionsInvalidInflation(): SetOptionsResultCode
        fun setOptionsCantChange(): SetOptionsResultCode
        fun setOptionsUnknownFlag(): SetOptionsResultCode
        fun setOptionsThresholdOutOfRange(): SetOptionsResultCode
        fun setOptionsBadSigner(): SetOptionsResultCode
        fun setOptionsInvalidHomeDomain(): SetOptionsResultCode
        fun setOptionsAuthRevocableRequired(): SetOptionsResultCode
    }
}

open external class ChangeTrustResultCode {
    open var name: String /* "changeTrustSuccess" | "changeTrustMalformed" | "changeTrustNoIssuer" | "changeTrustInvalidLimit" | "changeTrustLowReserve" | "changeTrustSelfNotAllowed" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" */

    companion object {
        fun changeTrustSuccess(): ChangeTrustResultCode
        fun changeTrustMalformed(): ChangeTrustResultCode
        fun changeTrustNoIssuer(): ChangeTrustResultCode
        fun changeTrustInvalidLimit(): ChangeTrustResultCode
        fun changeTrustLowReserve(): ChangeTrustResultCode
        fun changeTrustSelfNotAllowed(): ChangeTrustResultCode
    }
}

open external class AllowTrustResultCode {
    open var name: String /* "allowTrustSuccess" | "allowTrustMalformed" | "allowTrustNoTrustLine" | "allowTrustTrustNotRequired" | "allowTrustCantRevoke" | "allowTrustSelfNotAllowed" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" */

    companion object {
        fun allowTrustSuccess(): AllowTrustResultCode
        fun allowTrustMalformed(): AllowTrustResultCode
        fun allowTrustNoTrustLine(): AllowTrustResultCode
        fun allowTrustTrustNotRequired(): AllowTrustResultCode
        fun allowTrustCantRevoke(): AllowTrustResultCode
        fun allowTrustSelfNotAllowed(): AllowTrustResultCode
    }
}

open external class AccountMergeResultCode {
    open var name: String /* "accountMergeSuccess" | "accountMergeMalformed" | "accountMergeNoAccount" | "accountMergeImmutableSet" | "accountMergeHasSubEntries" | "accountMergeSeqnumTooFar" | "accountMergeDestFull" | "accountMergeIsSponsor" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" */

    companion object {
        fun accountMergeSuccess(): AccountMergeResultCode
        fun accountMergeMalformed(): AccountMergeResultCode
        fun accountMergeNoAccount(): AccountMergeResultCode
        fun accountMergeImmutableSet(): AccountMergeResultCode
        fun accountMergeHasSubEntries(): AccountMergeResultCode
        fun accountMergeSeqnumTooFar(): AccountMergeResultCode
        fun accountMergeDestFull(): AccountMergeResultCode
        fun accountMergeIsSponsor(): AccountMergeResultCode
    }
}

open external class InflationResultCode {
    open var name: String /* "inflationSuccess" | "inflationNotTime" */
    open var value: dynamic /* 0 | "-1" */

    companion object {
        fun inflationSuccess(): InflationResultCode
        fun inflationNotTime(): InflationResultCode
    }
}

open external class ManageDataResultCode {
    open var name: String /* "manageDataSuccess" | "manageDataNotSupportedYet" | "manageDataNameNotFound" | "manageDataLowReserve" | "manageDataInvalidName" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" */

    companion object {
        fun manageDataSuccess(): ManageDataResultCode
        fun manageDataNotSupportedYet(): ManageDataResultCode
        fun manageDataNameNotFound(): ManageDataResultCode
        fun manageDataLowReserve(): ManageDataResultCode
        fun manageDataInvalidName(): ManageDataResultCode
    }
}

open external class BumpSequenceResultCode {
    open var name: String /* "bumpSequenceSuccess" | "bumpSequenceBadSeq" */
    open var value: dynamic /* 0 | "-1" */

    companion object {
        fun bumpSequenceSuccess(): BumpSequenceResultCode
        fun bumpSequenceBadSeq(): BumpSequenceResultCode
    }
}

open external class CreateClaimableBalanceResultCode {
    open var name: String /* "createClaimableBalanceSuccess" | "createClaimableBalanceMalformed" | "createClaimableBalanceLowReserve" | "createClaimableBalanceNoTrust" | "createClaimableBalanceNotAuthorized" | "createClaimableBalanceUnderfunded" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" */

    companion object {
        fun createClaimableBalanceSuccess(): CreateClaimableBalanceResultCode
        fun createClaimableBalanceMalformed(): CreateClaimableBalanceResultCode
        fun createClaimableBalanceLowReserve(): CreateClaimableBalanceResultCode
        fun createClaimableBalanceNoTrust(): CreateClaimableBalanceResultCode
        fun createClaimableBalanceNotAuthorized(): CreateClaimableBalanceResultCode
        fun createClaimableBalanceUnderfunded(): CreateClaimableBalanceResultCode
    }
}

open external class ClaimClaimableBalanceResultCode {
    open var name: String /* "claimClaimableBalanceSuccess" | "claimClaimableBalanceDoesNotExist" | "claimClaimableBalanceCannotClaim" | "claimClaimableBalanceLineFull" | "claimClaimableBalanceNoTrust" | "claimClaimableBalanceNotAuthorized" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" */

    companion object {
        fun claimClaimableBalanceSuccess(): ClaimClaimableBalanceResultCode
        fun claimClaimableBalanceDoesNotExist(): ClaimClaimableBalanceResultCode
        fun claimClaimableBalanceCannotClaim(): ClaimClaimableBalanceResultCode
        fun claimClaimableBalanceLineFull(): ClaimClaimableBalanceResultCode
        fun claimClaimableBalanceNoTrust(): ClaimClaimableBalanceResultCode
        fun claimClaimableBalanceNotAuthorized(): ClaimClaimableBalanceResultCode
    }
}

open external class BeginSponsoringFutureReservesResultCode {
    open var name: String /* "beginSponsoringFutureReservesSuccess" | "beginSponsoringFutureReservesMalformed" | "beginSponsoringFutureReservesAlreadySponsored" | "beginSponsoringFutureReservesRecursive" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" */

    companion object {
        fun beginSponsoringFutureReservesSuccess(): BeginSponsoringFutureReservesResultCode
        fun beginSponsoringFutureReservesMalformed(): BeginSponsoringFutureReservesResultCode
        fun beginSponsoringFutureReservesAlreadySponsored(): BeginSponsoringFutureReservesResultCode
        fun beginSponsoringFutureReservesRecursive(): BeginSponsoringFutureReservesResultCode
    }
}

open external class EndSponsoringFutureReservesResultCode {
    open var name: String /* "endSponsoringFutureReservesSuccess" | "endSponsoringFutureReservesNotSponsored" */
    open var value: dynamic /* 0 | "-1" */

    companion object {
        fun endSponsoringFutureReservesSuccess(): EndSponsoringFutureReservesResultCode
        fun endSponsoringFutureReservesNotSponsored(): EndSponsoringFutureReservesResultCode
    }
}

open external class RevokeSponsorshipResultCode {
    open var name: String /* "revokeSponsorshipSuccess" | "revokeSponsorshipDoesNotExist" | "revokeSponsorshipNotSponsor" | "revokeSponsorshipLowReserve" | "revokeSponsorshipOnlyTransferable" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" */

    companion object {
        fun revokeSponsorshipSuccess(): RevokeSponsorshipResultCode
        fun revokeSponsorshipDoesNotExist(): RevokeSponsorshipResultCode
        fun revokeSponsorshipNotSponsor(): RevokeSponsorshipResultCode
        fun revokeSponsorshipLowReserve(): RevokeSponsorshipResultCode
        fun revokeSponsorshipOnlyTransferable(): RevokeSponsorshipResultCode
    }
}

open external class ClawbackResultCode {
    open var name: String /* "clawbackSuccess" | "clawbackMalformed" | "clawbackNotClawbackEnabled" | "clawbackNoTrust" | "clawbackUnderfunded" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" */

    companion object {
        fun clawbackSuccess(): ClawbackResultCode
        fun clawbackMalformed(): ClawbackResultCode
        fun clawbackNotClawbackEnabled(): ClawbackResultCode
        fun clawbackNoTrust(): ClawbackResultCode
        fun clawbackUnderfunded(): ClawbackResultCode
    }
}

open external class ClawbackClaimableBalanceResultCode {
    open var name: String /* "clawbackClaimableBalanceSuccess" | "clawbackClaimableBalanceDoesNotExist" | "clawbackClaimableBalanceNotIssuer" | "clawbackClaimableBalanceNotClawbackEnabled" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" */

    companion object {
        fun clawbackClaimableBalanceSuccess(): ClawbackClaimableBalanceResultCode
        fun clawbackClaimableBalanceDoesNotExist(): ClawbackClaimableBalanceResultCode
        fun clawbackClaimableBalanceNotIssuer(): ClawbackClaimableBalanceResultCode
        fun clawbackClaimableBalanceNotClawbackEnabled(): ClawbackClaimableBalanceResultCode
    }
}

open external class SetTrustLineFlagsResultCode {
    open var name: String /* "setTrustLineFlagsSuccess" | "setTrustLineFlagsMalformed" | "setTrustLineFlagsNoTrustLine" | "setTrustLineFlagsCantRevoke" | "setTrustLineFlagsInvalidState" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" */

    companion object {
        fun setTrustLineFlagsSuccess(): SetTrustLineFlagsResultCode
        fun setTrustLineFlagsMalformed(): SetTrustLineFlagsResultCode
        fun setTrustLineFlagsNoTrustLine(): SetTrustLineFlagsResultCode
        fun setTrustLineFlagsCantRevoke(): SetTrustLineFlagsResultCode
        fun setTrustLineFlagsInvalidState(): SetTrustLineFlagsResultCode
    }
}

open external class OperationResultCode {
    open var name: String /* "opInner" | "opBadAuth" | "opNoAccount" | "opNotSupported" | "opTooManySubentries" | "opExceededWorkLimit" | "opTooManySponsoring" */
    open var value: dynamic /* 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" */

    companion object {
        fun opInner(): OperationResultCode
        fun opBadAuth(): OperationResultCode
        fun opNoAccount(): OperationResultCode
        fun opNotSupported(): OperationResultCode
        fun opTooManySubentries(): OperationResultCode
        fun opExceededWorkLimit(): OperationResultCode
        fun opTooManySponsoring(): OperationResultCode
    }
}

open external class TransactionResultCode {
    open var name: String /* "txFeeBumpInnerSuccess" | "txSuccess" | "txFailed" | "txTooEarly" | "txTooLate" | "txMissingOperation" | "txBadSeq" | "txBadAuth" | "txInsufficientBalance" | "txNoAccount" | "txInsufficientFee" | "txBadAuthExtra" | "txInternalError" | "txNotSupported" | "txFeeBumpInnerFailed" | "txBadSponsorship" */
    open var value: dynamic /* 1 | 0 | "-1" | "-2" | "-3" | "-4" | "-5" | "-6" | "-7" | "-8" | "-9" | "-10" | "-11" | "-12" | "-13" | "-14" */

    companion object {
        fun txFeeBumpInnerSuccess(): TransactionResultCode
        fun txSuccess(): TransactionResultCode
        fun txFailed(): TransactionResultCode
        fun txTooEarly(): TransactionResultCode
        fun txTooLate(): TransactionResultCode
        fun txMissingOperation(): TransactionResultCode
        fun txBadSeq(): TransactionResultCode
        fun txBadAuth(): TransactionResultCode
        fun txInsufficientBalance(): TransactionResultCode
        fun txNoAccount(): TransactionResultCode
        fun txInsufficientFee(): TransactionResultCode
        fun txBadAuthExtra(): TransactionResultCode
        fun txInternalError(): TransactionResultCode
        fun txNotSupported(): TransactionResultCode
        fun txFeeBumpInnerFailed(): TransactionResultCode
        fun txBadSponsorship(): TransactionResultCode
    }
}

open external class CryptoKeyType {
    open var name: String /* "keyTypeEd25519" | "keyTypePreAuthTx" | "keyTypeHashX" | "keyTypeMuxedEd25519" */
    open var value: Number /* 0 | 1 | 2 | 256 */

    companion object {
        fun keyTypeEd25519(): CryptoKeyType
        fun keyTypePreAuthTx(): CryptoKeyType
        fun keyTypeHashX(): CryptoKeyType
        fun keyTypeMuxedEd25519(): CryptoKeyType
    }
}

open external class PublicKeyType {
    open var name: String /* "publicKeyTypeEd25519" */
    open var value: Number /* 0 */

    companion object {
        fun publicKeyTypeEd25519(): PublicKeyType
    }
}

open external class SignerKeyType {
    open var name: String /* "signerKeyTypeEd25519" | "signerKeyTypePreAuthTx" | "signerKeyTypeHashX" */
    open var value: Number /* 0 | 1 | 2 */

    companion object {
        fun signerKeyTypeEd25519(): SignerKeyType
        fun signerKeyTypePreAuthTx(): SignerKeyType
        fun signerKeyTypeHashX(): SignerKeyType
    }
}

external var Thresholds: Opaque

external var String32: XDRString

external var String64: XDRString

external var DataValue: VarOpaque

external var AssetCode4: Opaque

external var AssetCode12: Opaque

external var UpgradeType: VarOpaque

external var LedgerEntryChanges: XDRArray<LedgerEntryChange>

external var EncryptedBody: VarOpaque

external var PeerStatList: XDRArray<PeerStats>

external var Value: VarOpaque

external var Hash: Opaque

external var Uint256: Opaque

external var Uint32: UnsignedInt

external var Int32: SignedInt

open external class Uint64(low: Number, high: Number) : UnsignedHyper

open external class Int64(low: Number, high: Number) : Hyper

external var Signature: VarOpaque

external var SignatureHint: Opaque

external interface `T$83` {
    var assetCode: ByteArray
    var issuer: AccountId
}

open external class AssetAlphaNum4(attributes: `T$83`) {
    open fun assetCode(value: ByteArray = definedExternally): ByteArray
    open fun issuer(value: AccountId = definedExternally): AccountId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AssetAlphaNum4
        fun write(value: AssetAlphaNum4, io: ByteArray)
        fun isValid(value: AssetAlphaNum4): Boolean
        fun toXDR(value: AssetAlphaNum4): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AssetAlphaNum4

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AssetAlphaNum4
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AssetAlphaNum12(attributes: `T$83`) {
    open fun assetCode(value: ByteArray = definedExternally): ByteArray
    open fun issuer(value: AccountId = definedExternally): AccountId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AssetAlphaNum12
        fun write(value: AssetAlphaNum12, io: ByteArray)
        fun isValid(value: AssetAlphaNum12): Boolean
        fun toXDR(value: AssetAlphaNum12): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AssetAlphaNum12

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AssetAlphaNum12
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$84` {
    var n: Number
    var d: Number
}

open external class Price(attributes: `T$84`) {
    open fun n(value: Number = definedExternally): Number
    open fun d(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Price
        fun write(value: Price, io: ByteArray)
        fun isValid(value: Price): Boolean
        fun toXDR(value: Price): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Price
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Price
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$85` {
    var buying: Int64
    var selling: Int64
}

open external class Liabilities(attributes: `T$85`) {
    open fun buying(value: Int64 = definedExternally): Int64
    open fun selling(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Liabilities
        fun write(value: Liabilities, io: ByteArray)
        fun isValid(value: Liabilities): Boolean
        fun toXDR(value: Liabilities): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Liabilities
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Liabilities
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$86` {
    var key: SignerKey
    var weight: Number
}

open external class Signer(attributes: `T$86`) {
    open fun key(value: SignerKey = definedExternally): SignerKey
    open fun weight(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Signer
        fun write(value: Signer, io: ByteArray)
        fun isValid(value: Signer): Boolean
        fun toXDR(value: Signer): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Signer
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Signer
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$87` {
    var numSponsored: Number
    var numSponsoring: Number
    var signerSponsoringIDs: Array<AccountId?>
    var ext: AccountEntryExtensionV2Ext
}

open external class AccountEntryExtensionV2(attributes: `T$87`) {
    open fun numSponsored(value: Number = definedExternally): Number
    open fun numSponsoring(value: Number = definedExternally): Number
    open fun signerSponsoringIDs(value: Array<AccountId?> = definedExternally): Array<AccountId?>
    open fun ext(value: AccountEntryExtensionV2Ext = definedExternally): AccountEntryExtensionV2Ext
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AccountEntryExtensionV2
        fun write(value: AccountEntryExtensionV2, io: ByteArray)
        fun isValid(value: AccountEntryExtensionV2): Boolean
        fun toXDR(value: AccountEntryExtensionV2): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AccountEntryExtensionV2

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AccountEntryExtensionV2
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$88` {
    var liabilities: Liabilities
    var ext: AccountEntryExtensionV1Ext
}

open external class AccountEntryExtensionV1(attributes: `T$88`) {
    open fun liabilities(value: Liabilities = definedExternally): Liabilities
    open fun ext(value: AccountEntryExtensionV1Ext = definedExternally): AccountEntryExtensionV1Ext
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AccountEntryExtensionV1
        fun write(value: AccountEntryExtensionV1, io: ByteArray)
        fun isValid(value: AccountEntryExtensionV1): Boolean
        fun toXDR(value: AccountEntryExtensionV1): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AccountEntryExtensionV1

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AccountEntryExtensionV1
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$89` {
    var accountId: AccountId
    var balance: Int64
    var seqNum: SequenceNumber
    var numSubEntries: Number
    var inflationDest: AccountId?
    var flags: Number
    var homeDomain: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
    var thresholds: ByteArray
    var signers: Array<Signer>
    var ext: AccountEntryExt
}

open external class AccountEntry(attributes: `T$89`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun balance(value: Int64 = definedExternally): Int64
    open fun seqNum(value: SequenceNumber = definedExternally): SequenceNumber
    open fun numSubEntries(value: Number = definedExternally): Number
    open fun inflationDest(value: AccountId? = definedExternally): AccountId?
    open fun flags(value: Number = definedExternally): Number
    open fun homeDomain(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun homeDomain(): dynamic /* String | ByteArray */
    open fun homeDomain(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun thresholds(value: ByteArray = definedExternally): ByteArray
    open fun signers(value: Array<Signer> = definedExternally): Array<Signer>
    open fun ext(value: AccountEntryExt = definedExternally): AccountEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AccountEntry
        fun write(value: AccountEntry, io: ByteArray)
        fun isValid(value: AccountEntry): Boolean
        fun toXDR(value: AccountEntry): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): AccountEntry
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AccountEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$90` {
    var liabilities: Liabilities
    var ext: TrustLineEntryV1Ext
}

open external class TrustLineEntryV1(attributes: `T$90`) {
    open fun liabilities(value: Liabilities = definedExternally): Liabilities
    open fun ext(value: TrustLineEntryV1Ext = definedExternally): TrustLineEntryV1Ext
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TrustLineEntryV1
        fun write(value: TrustLineEntryV1, io: ByteArray)
        fun isValid(value: TrustLineEntryV1): Boolean
        fun toXDR(value: TrustLineEntryV1): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TrustLineEntryV1

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TrustLineEntryV1
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$91` {
    var accountId: AccountId
    var asset: Asset
    var balance: Int64
    var limit: Int64
    var flags: Number
    var ext: TrustLineEntryExt
}

open external class TrustLineEntry(attributes: `T$91`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun asset(value: Asset = definedExternally): Asset
    open fun balance(value: Int64 = definedExternally): Int64
    open fun limit(value: Int64 = definedExternally): Int64
    open fun flags(value: Number = definedExternally): Number
    open fun ext(value: TrustLineEntryExt = definedExternally): TrustLineEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TrustLineEntry
        fun write(value: TrustLineEntry, io: ByteArray)
        fun isValid(value: TrustLineEntry): Boolean
        fun toXDR(value: TrustLineEntry): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TrustLineEntry

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TrustLineEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$92` {
    var sellerId: AccountId
    var offerId: Int64
    var selling: Asset
    var buying: Asset
    var amount: Int64
    var price: Price
    var flags: Number
    var ext: OfferEntryExt
}

open external class OfferEntry(attributes: `T$92`) {
    open fun sellerId(value: AccountId = definedExternally): AccountId
    open fun offerId(value: Int64 = definedExternally): Int64
    open fun selling(value: Asset = definedExternally): Asset
    open fun buying(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun price(value: Price = definedExternally): Price
    open fun flags(value: Number = definedExternally): Number
    open fun ext(value: OfferEntryExt = definedExternally): OfferEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): OfferEntry
        fun write(value: OfferEntry, io: ByteArray)
        fun isValid(value: OfferEntry): Boolean
        fun toXDR(value: OfferEntry): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): OfferEntry
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OfferEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$93` {
    var accountId: AccountId
    var dataName: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
    var dataValue: ByteArray
    var ext: DataEntryExt
}

open external class DataEntry(attributes: `T$93`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun dataName(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun dataName(): dynamic /* String | ByteArray */
    open fun dataName(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun dataValue(value: ByteArray = definedExternally): ByteArray
    open fun ext(value: DataEntryExt = definedExternally): DataEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): DataEntry
        fun write(value: DataEntry, io: ByteArray)
        fun isValid(value: DataEntry): Boolean
        fun toXDR(value: DataEntry): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): DataEntry
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): DataEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$94` {
    var destination: AccountId
    var predicate: ClaimPredicate
}

open external class ClaimantV0(attributes: `T$94`) {
    open fun destination(value: AccountId = definedExternally): AccountId
    open fun predicate(value: ClaimPredicate = definedExternally): ClaimPredicate
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimantV0
        fun write(value: ClaimantV0, io: ByteArray)
        fun isValid(value: ClaimantV0): Boolean
        fun toXDR(value: ClaimantV0): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ClaimantV0
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimantV0
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$95` {
    var ext: ClaimableBalanceEntryExtensionV1Ext
    var flags: Number
}

open external class ClaimableBalanceEntryExtensionV1(attributes: `T$95`) {
    open fun ext(value: ClaimableBalanceEntryExtensionV1Ext = definedExternally): ClaimableBalanceEntryExtensionV1Ext
    open fun flags(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimableBalanceEntryExtensionV1
        fun write(value: ClaimableBalanceEntryExtensionV1, io: ByteArray)
        fun isValid(value: ClaimableBalanceEntryExtensionV1): Boolean
        fun toXDR(value: ClaimableBalanceEntryExtensionV1): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimableBalanceEntryExtensionV1

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): ClaimableBalanceEntryExtensionV1

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$96` {
    var balanceId: ClaimableBalanceId
    var claimants: Array<Claimant>
    var asset: Asset
    var amount: Int64
    var ext: ClaimableBalanceEntryExt
}

open external class ClaimableBalanceEntry(attributes: `T$96`) {
    open fun balanceId(value: ClaimableBalanceId = definedExternally): ClaimableBalanceId
    open fun claimants(value: Array<Claimant> = definedExternally): Array<Claimant>
    open fun asset(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun ext(value: ClaimableBalanceEntryExt = definedExternally): ClaimableBalanceEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimableBalanceEntry
        fun write(value: ClaimableBalanceEntry, io: ByteArray)
        fun isValid(value: ClaimableBalanceEntry): Boolean
        fun toXDR(value: ClaimableBalanceEntry): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimableBalanceEntry

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimableBalanceEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$97` {
    var sponsoringId: AccountId?
    var ext: LedgerEntryExtensionV1Ext
}

open external class LedgerEntryExtensionV1(attributes: `T$97`) {
    open fun sponsoringId(value: AccountId? = definedExternally): AccountId?
    open fun ext(value: LedgerEntryExtensionV1Ext = definedExternally): LedgerEntryExtensionV1Ext
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerEntryExtensionV1
        fun write(value: LedgerEntryExtensionV1, io: ByteArray)
        fun isValid(value: LedgerEntryExtensionV1): Boolean
        fun toXDR(value: LedgerEntryExtensionV1): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerEntryExtensionV1

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerEntryExtensionV1
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$98` {
    var lastModifiedLedgerSeq: Number
    var data: LedgerEntryData
    var ext: LedgerEntryExt
}

open external class LedgerEntry(attributes: `T$98`) {
    open fun lastModifiedLedgerSeq(value: Number = definedExternally): Number
    open fun data(value: LedgerEntryData = definedExternally): LedgerEntryData
    open fun ext(value: LedgerEntryExt = definedExternally): LedgerEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerEntry
        fun write(value: LedgerEntry, io: ByteArray)
        fun isValid(value: LedgerEntry): Boolean
        fun toXDR(value: LedgerEntry): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): LedgerEntry
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$99` {
    var accountId: AccountId
}

open external class LedgerKeyAccount(attributes: `T$99`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerKeyAccount
        fun write(value: LedgerKeyAccount, io: ByteArray)
        fun isValid(value: LedgerKeyAccount): Boolean
        fun toXDR(value: LedgerKeyAccount): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerKeyAccount

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerKeyAccount
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$100` {
    var accountId: AccountId
    var asset: Asset
}

open external class LedgerKeyTrustLine(attributes: `T$100`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun asset(value: Asset = definedExternally): Asset
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerKeyTrustLine
        fun write(value: LedgerKeyTrustLine, io: ByteArray)
        fun isValid(value: LedgerKeyTrustLine): Boolean
        fun toXDR(value: LedgerKeyTrustLine): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerKeyTrustLine

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerKeyTrustLine
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$101` {
    var sellerId: AccountId
    var offerId: Int64
}

open external class LedgerKeyOffer(attributes: `T$101`) {
    open fun sellerId(value: AccountId = definedExternally): AccountId
    open fun offerId(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerKeyOffer
        fun write(value: LedgerKeyOffer, io: ByteArray)
        fun isValid(value: LedgerKeyOffer): Boolean
        fun toXDR(value: LedgerKeyOffer): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerKeyOffer

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerKeyOffer
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$102` {
    var accountId: AccountId
    var dataName: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
}

open external class LedgerKeyData(attributes: `T$102`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun dataName(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun dataName(): dynamic /* String | ByteArray */
    open fun dataName(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerKeyData
        fun write(value: LedgerKeyData, io: ByteArray)
        fun isValid(value: LedgerKeyData): Boolean
        fun toXDR(value: LedgerKeyData): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): LedgerKeyData
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerKeyData
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$103` {
    var balanceId: ClaimableBalanceId
}

open external class LedgerKeyClaimableBalance(attributes: `T$103`) {
    open fun balanceId(value: ClaimableBalanceId = definedExternally): ClaimableBalanceId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerKeyClaimableBalance
        fun write(value: LedgerKeyClaimableBalance, io: ByteArray)
        fun isValid(value: LedgerKeyClaimableBalance): Boolean
        fun toXDR(value: LedgerKeyClaimableBalance): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerKeyClaimableBalance

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerKeyClaimableBalance
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$104` {
    var nodeId: NodeId
    var signature: ByteArray
}

open external class LedgerCloseValueSignature(attributes: `T$104`) {
    open fun nodeId(value: NodeId = definedExternally): NodeId
    open fun signature(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerCloseValueSignature
        fun write(value: LedgerCloseValueSignature, io: ByteArray)
        fun isValid(value: LedgerCloseValueSignature): Boolean
        fun toXDR(value: LedgerCloseValueSignature): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerCloseValueSignature

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerCloseValueSignature
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$105` {
    var txSetHash: ByteArray
    var closeTime: TimePoint
    var upgrades: Array<ByteArray>
    var ext: StellarValueExt
}

open external class StellarValue(attributes: `T$105`) {
    open fun txSetHash(value: ByteArray = definedExternally): ByteArray
    open fun closeTime(value: TimePoint = definedExternally): TimePoint
    open fun upgrades(value: Array<ByteArray> = definedExternally): Array<ByteArray>
    open fun ext(value: StellarValueExt = definedExternally): StellarValueExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): StellarValue
        fun write(value: StellarValue, io: ByteArray)
        fun isValid(value: StellarValue): Boolean
        fun toXDR(value: StellarValue): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): StellarValue
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): StellarValue
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$106` {
    var ledgerVersion: Number
    var previousLedgerHash: ByteArray
    var scpValue: StellarValue
    var txSetResultHash: ByteArray
    var bucketListHash: ByteArray
    var ledgerSeq: Number
    var totalCoins: Int64
    var feePool: Int64
    var inflationSeq: Number
    var idPool: Uint64
    var baseFee: Number
    var baseReserve: Number
    var maxTxSetSize: Number
    var skipList: Array<ByteArray>
    var ext: LedgerHeaderExt
}

open external class LedgerHeader(attributes: `T$106`) {
    open fun ledgerVersion(value: Number = definedExternally): Number
    open fun previousLedgerHash(value: ByteArray = definedExternally): ByteArray
    open fun scpValue(value: StellarValue = definedExternally): StellarValue
    open fun txSetResultHash(value: ByteArray = definedExternally): ByteArray
    open fun bucketListHash(value: ByteArray = definedExternally): ByteArray
    open fun ledgerSeq(value: Number = definedExternally): Number
    open fun totalCoins(value: Int64 = definedExternally): Int64
    open fun feePool(value: Int64 = definedExternally): Int64
    open fun inflationSeq(value: Number = definedExternally): Number
    open fun idPool(value: Uint64 = definedExternally): Uint64
    open fun baseFee(value: Number = definedExternally): Number
    open fun baseReserve(value: Number = definedExternally): Number
    open fun maxTxSetSize(value: Number = definedExternally): Number
    open fun skipList(value: Array<ByteArray> = definedExternally): Array<ByteArray>
    open fun ext(value: LedgerHeaderExt = definedExternally): LedgerHeaderExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerHeader
        fun write(value: LedgerHeader, io: ByteArray)
        fun isValid(value: LedgerHeader): Boolean
        fun toXDR(value: LedgerHeader): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): LedgerHeader
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerHeader
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$107` {
    var ledgerVersion: Number
    var ext: BucketMetadataExt
}

open external class BucketMetadata(attributes: `T$107`) {
    open fun ledgerVersion(value: Number = definedExternally): Number
    open fun ext(value: BucketMetadataExt = definedExternally): BucketMetadataExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): BucketMetadata
        fun write(value: BucketMetadata, io: ByteArray)
        fun isValid(value: BucketMetadata): Boolean
        fun toXDR(value: BucketMetadata): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): BucketMetadata

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): BucketMetadata
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$108` {
    var previousLedgerHash: ByteArray
    var txes: Array<TransactionEnvelope>
}

open external class TransactionSet(attributes: `T$108`) {
    open fun previousLedgerHash(value: ByteArray = definedExternally): ByteArray
    open fun txes(value: Array<TransactionEnvelope> = definedExternally): Array<TransactionEnvelope>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionSet
        fun write(value: TransactionSet, io: ByteArray)
        fun isValid(value: TransactionSet): Boolean
        fun toXDR(value: TransactionSet): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionSet

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionSet
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$109` {
    var transactionHash: ByteArray
    var result: TransactionResult
}

open external class TransactionResultPair(attributes: `T$109`) {
    open fun transactionHash(value: ByteArray = definedExternally): ByteArray
    open fun result(value: TransactionResult = definedExternally): TransactionResult
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionResultPair
        fun write(value: TransactionResultPair, io: ByteArray)
        fun isValid(value: TransactionResultPair): Boolean
        fun toXDR(value: TransactionResultPair): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionResultPair

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionResultPair
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$110` {
    var results: Array<TransactionResultPair>
}

open external class TransactionResultSet(attributes: `T$110`) {
    open fun results(value: Array<TransactionResultPair> = definedExternally): Array<TransactionResultPair>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionResultSet
        fun write(value: TransactionResultSet, io: ByteArray)
        fun isValid(value: TransactionResultSet): Boolean
        fun toXDR(value: TransactionResultSet): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionResultSet

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionResultSet
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$111` {
    var ledgerSeq: Number
    var txSet: TransactionSet
    var ext: TransactionHistoryEntryExt
}

open external class TransactionHistoryEntry(attributes: `T$111`) {
    open fun ledgerSeq(value: Number = definedExternally): Number
    open fun txSet(value: TransactionSet = definedExternally): TransactionSet
    open fun ext(value: TransactionHistoryEntryExt = definedExternally): TransactionHistoryEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionHistoryEntry
        fun write(value: TransactionHistoryEntry, io: ByteArray)
        fun isValid(value: TransactionHistoryEntry): Boolean
        fun toXDR(value: TransactionHistoryEntry): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionHistoryEntry

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionHistoryEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$112` {
    var ledgerSeq: Number
    var txResultSet: TransactionResultSet
    var ext: TransactionHistoryResultEntryExt
}

open external class TransactionHistoryResultEntry(attributes: `T$112`) {
    open fun ledgerSeq(value: Number = definedExternally): Number
    open fun txResultSet(value: TransactionResultSet = definedExternally): TransactionResultSet
    open fun ext(value: TransactionHistoryResultEntryExt = definedExternally): TransactionHistoryResultEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionHistoryResultEntry
        fun write(value: TransactionHistoryResultEntry, io: ByteArray)
        fun isValid(value: TransactionHistoryResultEntry): Boolean
        fun toXDR(value: TransactionHistoryResultEntry): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionHistoryResultEntry

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): TransactionHistoryResultEntry

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$113` {
    var hash: ByteArray
    var header: LedgerHeader
    var ext: LedgerHeaderHistoryEntryExt
}

open external class LedgerHeaderHistoryEntry(attributes: `T$113`) {
    open fun hash(value: ByteArray = definedExternally): ByteArray
    open fun header(value: LedgerHeader = definedExternally): LedgerHeader
    open fun ext(value: LedgerHeaderHistoryEntryExt = definedExternally): LedgerHeaderHistoryEntryExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerHeaderHistoryEntry
        fun write(value: LedgerHeaderHistoryEntry, io: ByteArray)
        fun isValid(value: LedgerHeaderHistoryEntry): Boolean
        fun toXDR(value: LedgerHeaderHistoryEntry): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerHeaderHistoryEntry

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerHeaderHistoryEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$114` {
    var ledgerSeq: Number
    var messages: Array<ScpEnvelope>
}

open external class LedgerScpMessages(attributes: `T$114`) {
    open fun ledgerSeq(value: Number = definedExternally): Number
    open fun messages(value: Array<ScpEnvelope> = definedExternally): Array<ScpEnvelope>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerScpMessages
        fun write(value: LedgerScpMessages, io: ByteArray)
        fun isValid(value: LedgerScpMessages): Boolean
        fun toXDR(value: LedgerScpMessages): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerScpMessages

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerScpMessages
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$115` {
    var quorumSets: Array<ScpQuorumSet>
    var ledgerMessages: LedgerScpMessages
}

open external class ScpHistoryEntryV0(attributes: `T$115`) {
    open fun quorumSets(value: Array<ScpQuorumSet> = definedExternally): Array<ScpQuorumSet>
    open fun ledgerMessages(value: LedgerScpMessages = definedExternally): LedgerScpMessages
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpHistoryEntryV0
        fun write(value: ScpHistoryEntryV0, io: ByteArray)
        fun isValid(value: ScpHistoryEntryV0): Boolean
        fun toXDR(value: ScpHistoryEntryV0): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ScpHistoryEntryV0

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpHistoryEntryV0
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$116` {
    var changes: Array<LedgerEntryChange>
}

open external class OperationMeta(attributes: `T$116`) {
    open fun changes(value: Array<LedgerEntryChange> = definedExternally): Array<LedgerEntryChange>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): OperationMeta
        fun write(value: OperationMeta, io: ByteArray)
        fun isValid(value: OperationMeta): Boolean
        fun toXDR(value: OperationMeta): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): OperationMeta
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OperationMeta
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$117` {
    var txChanges: Array<LedgerEntryChange>
    var operations: Array<OperationMeta>
}

open external class TransactionMetaV1(attributes: `T$117`) {
    open fun txChanges(value: Array<LedgerEntryChange> = definedExternally): Array<LedgerEntryChange>
    open fun operations(value: Array<OperationMeta> = definedExternally): Array<OperationMeta>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionMetaV1
        fun write(value: TransactionMetaV1, io: ByteArray)
        fun isValid(value: TransactionMetaV1): Boolean
        fun toXDR(value: TransactionMetaV1): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionMetaV1

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionMetaV1
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$118` {
    var txChangesBefore: Array<LedgerEntryChange>
    var operations: Array<OperationMeta>
    var txChangesAfter: Array<LedgerEntryChange>
}

open external class TransactionMetaV2(attributes: `T$118`) {
    open fun txChangesBefore(value: Array<LedgerEntryChange> = definedExternally): Array<LedgerEntryChange>
    open fun operations(value: Array<OperationMeta> = definedExternally): Array<OperationMeta>
    open fun txChangesAfter(value: Array<LedgerEntryChange> = definedExternally): Array<LedgerEntryChange>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionMetaV2
        fun write(value: TransactionMetaV2, io: ByteArray)
        fun isValid(value: TransactionMetaV2): Boolean
        fun toXDR(value: TransactionMetaV2): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionMetaV2

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionMetaV2
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$119` {
    var result: TransactionResultPair
    var feeProcessing: Array<LedgerEntryChange>
    var txApplyProcessing: TransactionMeta
}

open external class TransactionResultMeta(attributes: `T$119`) {
    open fun result(value: TransactionResultPair = definedExternally): TransactionResultPair
    open fun feeProcessing(value: Array<LedgerEntryChange> = definedExternally): Array<LedgerEntryChange>
    open fun txApplyProcessing(value: TransactionMeta = definedExternally): TransactionMeta
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionResultMeta
        fun write(value: TransactionResultMeta, io: ByteArray)
        fun isValid(value: TransactionResultMeta): Boolean
        fun toXDR(value: TransactionResultMeta): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionResultMeta

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionResultMeta
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$120` {
    var upgrade: LedgerUpgrade
    var changes: Array<LedgerEntryChange>
}

open external class UpgradeEntryMeta(attributes: `T$120`) {
    open fun upgrade(value: LedgerUpgrade = definedExternally): LedgerUpgrade
    open fun changes(value: Array<LedgerEntryChange> = definedExternally): Array<LedgerEntryChange>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): UpgradeEntryMeta
        fun write(value: UpgradeEntryMeta, io: ByteArray)
        fun isValid(value: UpgradeEntryMeta): Boolean
        fun toXDR(value: UpgradeEntryMeta): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): UpgradeEntryMeta

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): UpgradeEntryMeta
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$121` {
    var ledgerHeader: LedgerHeaderHistoryEntry
    var txSet: TransactionSet
    var txProcessing: Array<TransactionResultMeta>
    var upgradesProcessing: Array<UpgradeEntryMeta>
    var scpInfo: Array<ScpHistoryEntry>
}

open external class LedgerCloseMetaV0(attributes: `T$121`) {
    open fun ledgerHeader(value: LedgerHeaderHistoryEntry = definedExternally): LedgerHeaderHistoryEntry
    open fun txSet(value: TransactionSet = definedExternally): TransactionSet
    open fun txProcessing(value: Array<TransactionResultMeta> = definedExternally): Array<TransactionResultMeta>
    open fun upgradesProcessing(value: Array<UpgradeEntryMeta> = definedExternally): Array<UpgradeEntryMeta>
    open fun scpInfo(value: Array<ScpHistoryEntry> = definedExternally): Array<ScpHistoryEntry>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerCloseMetaV0
        fun write(value: LedgerCloseMetaV0, io: ByteArray)
        fun isValid(value: LedgerCloseMetaV0): Boolean
        fun toXDR(value: LedgerCloseMetaV0): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerCloseMetaV0

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerCloseMetaV0
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$122` {
    var code: ErrorCode
    var msg: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
}

open external class Error(attributes: `T$122`) {
    open fun code(value: ErrorCode = definedExternally): ErrorCode
    open fun msg(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun msg(): dynamic /* String | ByteArray */
    open fun msg(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Error
        fun write(value: Error, io: ByteArray)
        fun isValid(value: Error): Boolean
        fun toXDR(value: Error): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Error
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Error
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$123` {
    var pubkey: Curve25519Public
    var expiration: Uint64
    var sig: ByteArray
}

open external class AuthCert(attributes: `T$123`) {
    open fun pubkey(value: Curve25519Public = definedExternally): Curve25519Public
    open fun expiration(value: Uint64 = definedExternally): Uint64
    open fun sig(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AuthCert
        fun write(value: AuthCert, io: ByteArray)
        fun isValid(value: AuthCert): Boolean
        fun toXDR(value: AuthCert): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): AuthCert
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AuthCert
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$124` {
    var ledgerVersion: Number
    var overlayVersion: Number
    var overlayMinVersion: Number
    var networkId: ByteArray
    var versionStr: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
    var listeningPort: Number
    var peerId: NodeId
    var cert: AuthCert
    var nonce: ByteArray
}

open external class Hello(attributes: `T$124`) {
    open fun ledgerVersion(value: Number = definedExternally): Number
    open fun overlayVersion(value: Number = definedExternally): Number
    open fun overlayMinVersion(value: Number = definedExternally): Number
    open fun networkId(value: ByteArray = definedExternally): ByteArray
    open fun versionStr(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun versionStr(): dynamic /* String | ByteArray */
    open fun versionStr(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun listeningPort(value: Number = definedExternally): Number
    open fun peerId(value: NodeId = definedExternally): NodeId
    open fun cert(value: AuthCert = definedExternally): AuthCert
    open fun nonce(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Hello
        fun write(value: Hello, io: ByteArray)
        fun isValid(value: Hello): Boolean
        fun toXDR(value: Hello): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Hello
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Hello
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$125` {
    var unused: Number
}

open external class Auth(attributes: `T$125`) {
    open fun unused(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Auth
        fun write(value: Auth, io: ByteArray)
        fun isValid(value: Auth): Boolean
        fun toXDR(value: Auth): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Auth
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Auth
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$126` {
    var ip: PeerAddressIp
    var port: Number
    var numFailures: Number
}

open external class PeerAddress(attributes: `T$126`) {
    open fun ip(value: PeerAddressIp = definedExternally): PeerAddressIp
    open fun port(value: Number = definedExternally): Number
    open fun numFailures(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PeerAddress
        fun write(value: PeerAddress, io: ByteArray)
        fun isValid(value: PeerAddress): Boolean
        fun toXDR(value: PeerAddress): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): PeerAddress
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PeerAddress
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$127` {
    var type: MessageType
    var reqHash: ByteArray
}

open external class DontHave(attributes: `T$127`) {
    open fun type(value: MessageType = definedExternally): MessageType
    open fun reqHash(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): DontHave
        fun write(value: DontHave, io: ByteArray)
        fun isValid(value: DontHave): Boolean
        fun toXDR(value: DontHave): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): DontHave
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): DontHave
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$128` {
    var surveyorPeerId: NodeId
    var surveyedPeerId: NodeId
    var ledgerNum: Number
    var encryptionKey: Curve25519Public
    var commandType: SurveyMessageCommandType
}

open external class SurveyRequestMessage(attributes: `T$128`) {
    open fun surveyorPeerId(value: NodeId = definedExternally): NodeId
    open fun surveyedPeerId(value: NodeId = definedExternally): NodeId
    open fun ledgerNum(value: Number = definedExternally): Number
    open fun encryptionKey(value: Curve25519Public = definedExternally): Curve25519Public
    open fun commandType(value: SurveyMessageCommandType = definedExternally): SurveyMessageCommandType
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SurveyRequestMessage
        fun write(value: SurveyRequestMessage, io: ByteArray)
        fun isValid(value: SurveyRequestMessage): Boolean
        fun toXDR(value: SurveyRequestMessage): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SurveyRequestMessage

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SurveyRequestMessage
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$129` {
    var requestSignature: ByteArray
    var request: SurveyRequestMessage
}

open external class SignedSurveyRequestMessage(attributes: `T$129`) {
    open fun requestSignature(value: ByteArray = definedExternally): ByteArray
    open fun request(value: SurveyRequestMessage = definedExternally): SurveyRequestMessage
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SignedSurveyRequestMessage
        fun write(value: SignedSurveyRequestMessage, io: ByteArray)
        fun isValid(value: SignedSurveyRequestMessage): Boolean
        fun toXDR(value: SignedSurveyRequestMessage): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SignedSurveyRequestMessage

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): SignedSurveyRequestMessage

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$130` {
    var surveyorPeerId: NodeId
    var surveyedPeerId: NodeId
    var ledgerNum: Number
    var commandType: SurveyMessageCommandType
    var encryptedBody: ByteArray
}

open external class SurveyResponseMessage(attributes: `T$130`) {
    open fun surveyorPeerId(value: NodeId = definedExternally): NodeId
    open fun surveyedPeerId(value: NodeId = definedExternally): NodeId
    open fun ledgerNum(value: Number = definedExternally): Number
    open fun commandType(value: SurveyMessageCommandType = definedExternally): SurveyMessageCommandType
    open fun encryptedBody(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SurveyResponseMessage
        fun write(value: SurveyResponseMessage, io: ByteArray)
        fun isValid(value: SurveyResponseMessage): Boolean
        fun toXDR(value: SurveyResponseMessage): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SurveyResponseMessage

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SurveyResponseMessage
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$131` {
    var responseSignature: ByteArray
    var response: SurveyResponseMessage
}

open external class SignedSurveyResponseMessage(attributes: `T$131`) {
    open fun responseSignature(value: ByteArray = definedExternally): ByteArray
    open fun response(value: SurveyResponseMessage = definedExternally): SurveyResponseMessage
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SignedSurveyResponseMessage
        fun write(value: SignedSurveyResponseMessage, io: ByteArray)
        fun isValid(value: SignedSurveyResponseMessage): Boolean
        fun toXDR(value: SignedSurveyResponseMessage): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SignedSurveyResponseMessage

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): SignedSurveyResponseMessage

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$132` {
    var id: NodeId
    var versionStr: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
    var messagesRead: Uint64
    var messagesWritten: Uint64
    var bytesRead: Uint64
    var bytesWritten: Uint64
    var secondsConnected: Uint64
    var uniqueFloodBytesRecv: Uint64
    var duplicateFloodBytesRecv: Uint64
    var uniqueFetchBytesRecv: Uint64
    var duplicateFetchBytesRecv: Uint64
    var uniqueFloodMessageRecv: Uint64
    var duplicateFloodMessageRecv: Uint64
    var uniqueFetchMessageRecv: Uint64
    var duplicateFetchMessageRecv: Uint64
}

open external class PeerStats(attributes: `T$132`) {
    open fun id(value: NodeId = definedExternally): NodeId
    open fun versionStr(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun versionStr(): dynamic /* String | ByteArray */
    open fun versionStr(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun messagesRead(value: Uint64 = definedExternally): Uint64
    open fun messagesWritten(value: Uint64 = definedExternally): Uint64
    open fun bytesRead(value: Uint64 = definedExternally): Uint64
    open fun bytesWritten(value: Uint64 = definedExternally): Uint64
    open fun secondsConnected(value: Uint64 = definedExternally): Uint64
    open fun uniqueFloodBytesRecv(value: Uint64 = definedExternally): Uint64
    open fun duplicateFloodBytesRecv(value: Uint64 = definedExternally): Uint64
    open fun uniqueFetchBytesRecv(value: Uint64 = definedExternally): Uint64
    open fun duplicateFetchBytesRecv(value: Uint64 = definedExternally): Uint64
    open fun uniqueFloodMessageRecv(value: Uint64 = definedExternally): Uint64
    open fun duplicateFloodMessageRecv(value: Uint64 = definedExternally): Uint64
    open fun uniqueFetchMessageRecv(value: Uint64 = definedExternally): Uint64
    open fun duplicateFetchMessageRecv(value: Uint64 = definedExternally): Uint64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PeerStats
        fun write(value: PeerStats, io: ByteArray)
        fun isValid(value: PeerStats): Boolean
        fun toXDR(value: PeerStats): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): PeerStats
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PeerStats
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$133` {
    var inboundPeers: Array<PeerStats>
    var outboundPeers: Array<PeerStats>
    var totalInboundPeerCount: Number
    var totalOutboundPeerCount: Number
}

open external class TopologyResponseBody(attributes: `T$133`) {
    open fun inboundPeers(value: Array<PeerStats> = definedExternally): Array<PeerStats>
    open fun outboundPeers(value: Array<PeerStats> = definedExternally): Array<PeerStats>
    open fun totalInboundPeerCount(value: Number = definedExternally): Number
    open fun totalOutboundPeerCount(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TopologyResponseBody
        fun write(value: TopologyResponseBody, io: ByteArray)
        fun isValid(value: TopologyResponseBody): Boolean
        fun toXDR(value: TopologyResponseBody): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TopologyResponseBody

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TopologyResponseBody
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$134` {
    var sequence: Uint64
    var message: StellarMessage
    var mac: HmacSha256Mac
}

open external class AuthenticatedMessageV0(attributes: `T$134`) {
    open fun sequence(value: Uint64 = definedExternally): Uint64
    open fun message(value: StellarMessage = definedExternally): StellarMessage
    open fun mac(value: HmacSha256Mac = definedExternally): HmacSha256Mac
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AuthenticatedMessageV0
        fun write(value: AuthenticatedMessageV0, io: ByteArray)
        fun isValid(value: AuthenticatedMessageV0): Boolean
        fun toXDR(value: AuthenticatedMessageV0): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AuthenticatedMessageV0

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AuthenticatedMessageV0
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$135` {
    var counter: Number
    var value: ByteArray
}

open external class ScpBallot(attributes: `T$135`) {
    open fun counter(value: Number = definedExternally): Number
    open fun value(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpBallot
        fun write(value: ScpBallot, io: ByteArray)
        fun isValid(value: ScpBallot): Boolean
        fun toXDR(value: ScpBallot): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ScpBallot
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpBallot
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$136` {
    var quorumSetHash: ByteArray
    var votes: Array<ByteArray>
    var accepted: Array<ByteArray>
}

open external class ScpNomination(attributes: `T$136`) {
    open fun quorumSetHash(value: ByteArray = definedExternally): ByteArray
    open fun votes(value: Array<ByteArray> = definedExternally): Array<ByteArray>
    open fun accepted(value: Array<ByteArray> = definedExternally): Array<ByteArray>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpNomination
        fun write(value: ScpNomination, io: ByteArray)
        fun isValid(value: ScpNomination): Boolean
        fun toXDR(value: ScpNomination): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ScpNomination
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpNomination
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$137` {
    var quorumSetHash: ByteArray
    var ballot: ScpBallot
    var prepared: ScpBallot?
    var preparedPrime: ScpBallot?
    var nC: Number
    var nH: Number
}

open external class ScpStatementPrepare(attributes: `T$137`) {
    open fun quorumSetHash(value: ByteArray = definedExternally): ByteArray
    open fun ballot(value: ScpBallot = definedExternally): ScpBallot
    open fun prepared(value: ScpBallot? = definedExternally): ScpBallot?
    open fun preparedPrime(value: ScpBallot? = definedExternally): ScpBallot?
    open fun nC(value: Number = definedExternally): Number
    open fun nH(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpStatementPrepare
        fun write(value: ScpStatementPrepare, io: ByteArray)
        fun isValid(value: ScpStatementPrepare): Boolean
        fun toXDR(value: ScpStatementPrepare): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ScpStatementPrepare

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpStatementPrepare
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$138` {
    var ballot: ScpBallot
    var nPrepared: Number
    var nCommit: Number
    var nH: Number
    var quorumSetHash: ByteArray
}

open external class ScpStatementConfirm(attributes: `T$138`) {
    open fun ballot(value: ScpBallot = definedExternally): ScpBallot
    open fun nPrepared(value: Number = definedExternally): Number
    open fun nCommit(value: Number = definedExternally): Number
    open fun nH(value: Number = definedExternally): Number
    open fun quorumSetHash(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpStatementConfirm
        fun write(value: ScpStatementConfirm, io: ByteArray)
        fun isValid(value: ScpStatementConfirm): Boolean
        fun toXDR(value: ScpStatementConfirm): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ScpStatementConfirm

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpStatementConfirm
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$139` {
    var commit: ScpBallot
    var nH: Number
    var commitQuorumSetHash: ByteArray
}

open external class ScpStatementExternalize(attributes: `T$139`) {
    open fun commit(value: ScpBallot = definedExternally): ScpBallot
    open fun nH(value: Number = definedExternally): Number
    open fun commitQuorumSetHash(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpStatementExternalize
        fun write(value: ScpStatementExternalize, io: ByteArray)
        fun isValid(value: ScpStatementExternalize): Boolean
        fun toXDR(value: ScpStatementExternalize): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ScpStatementExternalize

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpStatementExternalize
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$140` {
    var nodeId: NodeId
    var slotIndex: Uint64
    var pledges: ScpStatementPledges
}

open external class ScpStatement(attributes: `T$140`) {
    open fun nodeId(value: NodeId = definedExternally): NodeId
    open fun slotIndex(value: Uint64 = definedExternally): Uint64
    open fun pledges(value: ScpStatementPledges = definedExternally): ScpStatementPledges
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpStatement
        fun write(value: ScpStatement, io: ByteArray)
        fun isValid(value: ScpStatement): Boolean
        fun toXDR(value: ScpStatement): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ScpStatement
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpStatement
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$141` {
    var statement: ScpStatement
    var signature: ByteArray
}

open external class ScpEnvelope(attributes: `T$141`) {
    open fun statement(value: ScpStatement = definedExternally): ScpStatement
    open fun signature(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpEnvelope
        fun write(value: ScpEnvelope, io: ByteArray)
        fun isValid(value: ScpEnvelope): Boolean
        fun toXDR(value: ScpEnvelope): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ScpEnvelope
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpEnvelope
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$142` {
    var threshold: Number
    var validators: Array<PublicKey>
    var innerSets: Array<ScpQuorumSet>
}

open external class ScpQuorumSet(attributes: `T$142`) {
    open fun threshold(value: Number = definedExternally): Number
    open fun validators(value: Array<PublicKey> = definedExternally): Array<PublicKey>
    open fun innerSets(value: Array<ScpQuorumSet> = definedExternally): Array<ScpQuorumSet>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpQuorumSet
        fun write(value: ScpQuorumSet, io: ByteArray)
        fun isValid(value: ScpQuorumSet): Boolean
        fun toXDR(value: ScpQuorumSet): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ScpQuorumSet
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpQuorumSet
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$143` {
    var id: Uint64
    var ed25519: ByteArray
}

open external class MuxedAccountMed25519(attributes: `T$143`) {
    open fun id(value: Uint64 = definedExternally): Uint64
    open fun ed25519(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): MuxedAccountMed25519
        fun write(value: MuxedAccountMed25519, io: ByteArray)
        fun isValid(value: MuxedAccountMed25519): Boolean
        fun toXDR(value: MuxedAccountMed25519): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): MuxedAccountMed25519

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): MuxedAccountMed25519
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$144` {
    var hint: ByteArray
    var signature: ByteArray
}

open external class DecoratedSignature(attributes: `T$144`) {
    open fun hint(value: ByteArray = definedExternally): ByteArray
    open fun signature(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): DecoratedSignature
        fun write(value: DecoratedSignature, io: ByteArray)
        fun isValid(value: DecoratedSignature): Boolean
        fun toXDR(value: DecoratedSignature): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): DecoratedSignature

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): DecoratedSignature
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$145` {
    var destination: AccountId
    var startingBalance: Int64
}

open external class CreateAccountOp(attributes: `T$145`) {
    open fun destination(value: AccountId = definedExternally): AccountId
    open fun startingBalance(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): CreateAccountOp
        fun write(value: CreateAccountOp, io: ByteArray)
        fun isValid(value: CreateAccountOp): Boolean
        fun toXDR(value: CreateAccountOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): CreateAccountOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): CreateAccountOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$146` {
    var destination: MuxedAccount
    var asset: Asset
    var amount: Int64
}

open external class PaymentOp(attributes: `T$146`) {
    open fun destination(value: MuxedAccount = definedExternally): MuxedAccount
    open fun asset(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PaymentOp
        fun write(value: PaymentOp, io: ByteArray)
        fun isValid(value: PaymentOp): Boolean
        fun toXDR(value: PaymentOp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): PaymentOp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PaymentOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$147` {
    var sendAsset: Asset
    var sendMax: Int64
    var destination: MuxedAccount
    var destAsset: Asset
    var destAmount: Int64
    var path: Array<Asset>
}

open external class PathPaymentStrictReceiveOp(attributes: `T$147`) {
    open fun sendAsset(value: Asset = definedExternally): Asset
    open fun sendMax(value: Int64 = definedExternally): Int64
    open fun destination(value: MuxedAccount = definedExternally): MuxedAccount
    open fun destAsset(value: Asset = definedExternally): Asset
    open fun destAmount(value: Int64 = definedExternally): Int64
    open fun path(value: Array<Asset> = definedExternally): Array<Asset>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PathPaymentStrictReceiveOp
        fun write(value: PathPaymentStrictReceiveOp, io: ByteArray)
        fun isValid(value: PathPaymentStrictReceiveOp): Boolean
        fun toXDR(value: PathPaymentStrictReceiveOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): PathPaymentStrictReceiveOp

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): PathPaymentStrictReceiveOp

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$148` {
    var sendAsset: Asset
    var sendAmount: Int64
    var destination: MuxedAccount
    var destAsset: Asset
    var destMin: Int64
    var path: Array<Asset>
}

open external class PathPaymentStrictSendOp(attributes: `T$148`) {
    open fun sendAsset(value: Asset = definedExternally): Asset
    open fun sendAmount(value: Int64 = definedExternally): Int64
    open fun destination(value: MuxedAccount = definedExternally): MuxedAccount
    open fun destAsset(value: Asset = definedExternally): Asset
    open fun destMin(value: Int64 = definedExternally): Int64
    open fun path(value: Array<Asset> = definedExternally): Array<Asset>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PathPaymentStrictSendOp
        fun write(value: PathPaymentStrictSendOp, io: ByteArray)
        fun isValid(value: PathPaymentStrictSendOp): Boolean
        fun toXDR(value: PathPaymentStrictSendOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): PathPaymentStrictSendOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PathPaymentStrictSendOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$149` {
    var selling: Asset
    var buying: Asset
    var amount: Int64
    var price: Price
    var offerId: Int64
}

open external class ManageSellOfferOp(attributes: `T$149`) {
    open fun selling(value: Asset = definedExternally): Asset
    open fun buying(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun price(value: Price = definedExternally): Price
    open fun offerId(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ManageSellOfferOp
        fun write(value: ManageSellOfferOp, io: ByteArray)
        fun isValid(value: ManageSellOfferOp): Boolean
        fun toXDR(value: ManageSellOfferOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageSellOfferOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageSellOfferOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$150` {
    var selling: Asset
    var buying: Asset
    var buyAmount: Int64
    var price: Price
    var offerId: Int64
}

open external class ManageBuyOfferOp(attributes: `T$150`) {
    open fun selling(value: Asset = definedExternally): Asset
    open fun buying(value: Asset = definedExternally): Asset
    open fun buyAmount(value: Int64 = definedExternally): Int64
    open fun price(value: Price = definedExternally): Price
    open fun offerId(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ManageBuyOfferOp
        fun write(value: ManageBuyOfferOp, io: ByteArray)
        fun isValid(value: ManageBuyOfferOp): Boolean
        fun toXDR(value: ManageBuyOfferOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageBuyOfferOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageBuyOfferOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$151` {
    var selling: Asset
    var buying: Asset
    var amount: Int64
    var price: Price
}

open external class CreatePassiveSellOfferOp(attributes: `T$151`) {
    open fun selling(value: Asset = definedExternally): Asset
    open fun buying(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun price(value: Price = definedExternally): Price
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): CreatePassiveSellOfferOp
        fun write(value: CreatePassiveSellOfferOp, io: ByteArray)
        fun isValid(value: CreatePassiveSellOfferOp): Boolean
        fun toXDR(value: CreatePassiveSellOfferOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): CreatePassiveSellOfferOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): CreatePassiveSellOfferOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$152` {
    var inflationDest: AccountId?
    var clearFlags: Number?
    var setFlags: Number?
    var masterWeight: Number?
    var lowThreshold: Number?
    var medThreshold: Number?
    var highThreshold: Number?
    var homeDomain: dynamic /* String? | ByteArray? */
        get() = definedExternally
        set(value) = definedExternally
    var signer: Signer?
}

open external class SetOptionsOp(attributes: `T$152`) {
    open fun inflationDest(value: AccountId? = definedExternally): AccountId?
    open fun clearFlags(value: Number? = definedExternally): Number?
    open fun setFlags(value: Number? = definedExternally): Number?
    open fun masterWeight(value: Number? = definedExternally): Number?
    open fun lowThreshold(value: Number? = definedExternally): Number?
    open fun medThreshold(value: Number? = definedExternally): Number?
    open fun highThreshold(value: Number? = definedExternally): Number?
    open fun homeDomain(value: String? = definedExternally): dynamic /* String? | ByteArray? */
    open fun homeDomain(): dynamic /* String? | ByteArray? */
    open fun homeDomain(value: ByteArray? = definedExternally): dynamic /* String? | ByteArray? */
    open fun signer(value: Signer? = definedExternally): Signer?
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SetOptionsOp
        fun write(value: SetOptionsOp, io: ByteArray)
        fun isValid(value: SetOptionsOp): Boolean
        fun toXDR(value: SetOptionsOp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): SetOptionsOp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SetOptionsOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$153` {
    var line: Asset
    var limit: Int64
}

open external class ChangeTrustOp(attributes: `T$153`) {
    open fun line(value: Asset = definedExternally): Asset
    open fun limit(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ChangeTrustOp
        fun write(value: ChangeTrustOp, io: ByteArray)
        fun isValid(value: ChangeTrustOp): Boolean
        fun toXDR(value: ChangeTrustOp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ChangeTrustOp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ChangeTrustOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$154` {
    var trustor: AccountId
    var asset: AssetCode
    var authorize: Number
}

open external class AllowTrustOp(attributes: `T$154`) {
    open fun trustor(value: AccountId = definedExternally): AccountId
    open fun asset(value: AssetCode = definedExternally): AssetCode
    open fun authorize(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AllowTrustOp
        fun write(value: AllowTrustOp, io: ByteArray)
        fun isValid(value: AllowTrustOp): Boolean
        fun toXDR(value: AllowTrustOp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): AllowTrustOp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AllowTrustOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$155` {
    var dataName: dynamic /* String | ByteArray */
        get() = definedExternally
        set(value) = definedExternally
    var dataValue: ByteArray?
}

open external class ManageDataOp(attributes: `T$155`) {
    open fun dataName(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun dataName(): dynamic /* String | ByteArray */
    open fun dataName(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun dataValue(value: ByteArray? = definedExternally): ByteArray?
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ManageDataOp
        fun write(value: ManageDataOp, io: ByteArray)
        fun isValid(value: ManageDataOp): Boolean
        fun toXDR(value: ManageDataOp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ManageDataOp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageDataOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$156` {
    var bumpTo: SequenceNumber
}

open external class BumpSequenceOp(attributes: `T$156`) {
    open fun bumpTo(value: SequenceNumber = definedExternally): SequenceNumber
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): BumpSequenceOp
        fun write(value: BumpSequenceOp, io: ByteArray)
        fun isValid(value: BumpSequenceOp): Boolean
        fun toXDR(value: BumpSequenceOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): BumpSequenceOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): BumpSequenceOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$157` {
    var asset: Asset
    var amount: Int64
    var claimants: Array<Claimant>
}

open external class CreateClaimableBalanceOp(attributes: `T$157`) {
    open fun asset(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun claimants(value: Array<Claimant> = definedExternally): Array<Claimant>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): CreateClaimableBalanceOp
        fun write(value: CreateClaimableBalanceOp, io: ByteArray)
        fun isValid(value: CreateClaimableBalanceOp): Boolean
        fun toXDR(value: CreateClaimableBalanceOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): CreateClaimableBalanceOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): CreateClaimableBalanceOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClaimClaimableBalanceOp(attributes: `T$103`) {
    open fun balanceId(value: ClaimableBalanceId = definedExternally): ClaimableBalanceId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimClaimableBalanceOp
        fun write(value: ClaimClaimableBalanceOp, io: ByteArray)
        fun isValid(value: ClaimClaimableBalanceOp): Boolean
        fun toXDR(value: ClaimClaimableBalanceOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimClaimableBalanceOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimClaimableBalanceOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$158` {
    var sponsoredId: AccountId
}

open external class BeginSponsoringFutureReservesOp(attributes: `T$158`) {
    open fun sponsoredId(value: AccountId = definedExternally): AccountId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): BeginSponsoringFutureReservesOp
        fun write(value: BeginSponsoringFutureReservesOp, io: ByteArray)
        fun isValid(value: BeginSponsoringFutureReservesOp): Boolean
        fun toXDR(value: BeginSponsoringFutureReservesOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): BeginSponsoringFutureReservesOp

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): BeginSponsoringFutureReservesOp

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$159` {
    var accountId: AccountId
    var signerKey: SignerKey
}

open external class RevokeSponsorshipOpSigner(attributes: `T$159`) {
    open fun accountId(value: AccountId = definedExternally): AccountId
    open fun signerKey(value: SignerKey = definedExternally): SignerKey
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): RevokeSponsorshipOpSigner
        fun write(value: RevokeSponsorshipOpSigner, io: ByteArray)
        fun isValid(value: RevokeSponsorshipOpSigner): Boolean
        fun toXDR(value: RevokeSponsorshipOpSigner): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): RevokeSponsorshipOpSigner

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): RevokeSponsorshipOpSigner
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$160` {
    var asset: Asset
    var from: MuxedAccount
    var amount: Int64
}

open external class ClawbackOp(attributes: `T$160`) {
    open fun asset(value: Asset = definedExternally): Asset
    open fun from(value: MuxedAccount = definedExternally): MuxedAccount
    open fun amount(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClawbackOp
        fun write(value: ClawbackOp, io: ByteArray)
        fun isValid(value: ClawbackOp): Boolean
        fun toXDR(value: ClawbackOp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): ClawbackOp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClawbackOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClawbackClaimableBalanceOp(attributes: `T$103`) {
    open fun balanceId(value: ClaimableBalanceId = definedExternally): ClaimableBalanceId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClawbackClaimableBalanceOp
        fun write(value: ClawbackClaimableBalanceOp, io: ByteArray)
        fun isValid(value: ClawbackClaimableBalanceOp): Boolean
        fun toXDR(value: ClawbackClaimableBalanceOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClawbackClaimableBalanceOp

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): ClawbackClaimableBalanceOp

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$161` {
    var trustor: AccountId
    var asset: Asset
    var clearFlags: Number
    var setFlags: Number
}

open external class SetTrustLineFlagsOp(attributes: `T$161`) {
    open fun trustor(value: AccountId = definedExternally): AccountId
    open fun asset(value: Asset = definedExternally): Asset
    open fun clearFlags(value: Number = definedExternally): Number
    open fun setFlags(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SetTrustLineFlagsOp
        fun write(value: SetTrustLineFlagsOp, io: ByteArray)
        fun isValid(value: SetTrustLineFlagsOp): Boolean
        fun toXDR(value: SetTrustLineFlagsOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SetTrustLineFlagsOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SetTrustLineFlagsOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$162` {
    var sourceAccount: MuxedAccount
    var seqNum: SequenceNumber
    var opNum: Number
}

open external class OperationIdId(attributes: `T$162`) {
    open fun sourceAccount(value: MuxedAccount = definedExternally): MuxedAccount
    open fun seqNum(value: SequenceNumber = definedExternally): SequenceNumber
    open fun opNum(value: Number = definedExternally): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): OperationIdId
        fun write(value: OperationIdId, io: ByteArray)
        fun isValid(value: OperationIdId): Boolean
        fun toXDR(value: OperationIdId): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): OperationIdId
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OperationIdId
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$163` {
    var minTime: TimePoint
    var maxTime: TimePoint
}

open external class TimeBounds(attributes: `T$163`) {
    open fun minTime(value: TimePoint = definedExternally): TimePoint
    open fun maxTime(value: TimePoint = definedExternally): TimePoint
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TimeBounds
        fun write(value: TimeBounds, io: ByteArray)
        fun isValid(value: TimeBounds): Boolean
        fun toXDR(value: TimeBounds): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): TimeBounds
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TimeBounds
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$164` {
    var sourceAccountEd25519: ByteArray
    var fee: Number
    var seqNum: SequenceNumber
    var timeBounds: TimeBounds?
    var memo: Memo
    var operations: Array<Operation>
    var ext: TransactionV0Ext
}

open external class TransactionV0(attributes: `T$164`) {
    open fun sourceAccountEd25519(value: ByteArray = definedExternally): ByteArray
    open fun fee(value: Number = definedExternally): Number
    open fun seqNum(value: SequenceNumber = definedExternally): SequenceNumber
    open fun timeBounds(value: TimeBounds? = definedExternally): TimeBounds?
    open fun memo(value: Memo = definedExternally): Memo
    open fun operations(value: Array<Operation> = definedExternally): Array<Operation>
    open fun ext(value: TransactionV0Ext = definedExternally): TransactionV0Ext
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionV0
        fun write(value: TransactionV0, io: ByteArray)
        fun isValid(value: TransactionV0): Boolean
        fun toXDR(value: TransactionV0): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): TransactionV0
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionV0
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$165` {
    var tx: TransactionV0
    var signatures: Array<DecoratedSignature>
}

open external class TransactionV0Envelope(attributes: `T$165`) {
    open fun tx(value: TransactionV0 = definedExternally): TransactionV0
    open fun signatures(value: Array<DecoratedSignature> = definedExternally): Array<DecoratedSignature>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionV0Envelope
        fun write(value: TransactionV0Envelope, io: ByteArray)
        fun isValid(value: TransactionV0Envelope): Boolean
        fun toXDR(value: TransactionV0Envelope): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionV0Envelope

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionV0Envelope
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$166` {
    var sourceAccount: MuxedAccount
    var fee: Number
    var seqNum: SequenceNumber
    var timeBounds: TimeBounds?
    var memo: Memo
    var operations: Array<Operation>
    var ext: TransactionExt
}

open external class Transaction(attributes: `T$166`) {
    open fun sourceAccount(value: MuxedAccount = definedExternally): MuxedAccount
    open fun fee(value: Number = definedExternally): Number
    open fun seqNum(value: SequenceNumber = definedExternally): SequenceNumber
    open fun timeBounds(value: TimeBounds? = definedExternally): TimeBounds?
    open fun memo(value: Memo = definedExternally): Memo
    open fun operations(value: Array<Operation> = definedExternally): Array<Operation>
    open fun ext(value: TransactionExt = definedExternally): TransactionExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Transaction
        fun write(value: Transaction, io: ByteArray)
        fun isValid(value: Transaction): Boolean
        fun toXDR(value: Transaction): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Transaction
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Transaction
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$167` {
    var tx: Transaction
    var signatures: Array<DecoratedSignature>
}

open external class TransactionV1Envelope(attributes: `T$167`) {
    open fun tx(value: Transaction = definedExternally): Transaction
    open fun signatures(value: Array<DecoratedSignature> = definedExternally): Array<DecoratedSignature>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionV1Envelope
        fun write(value: TransactionV1Envelope, io: ByteArray)
        fun isValid(value: TransactionV1Envelope): Boolean
        fun toXDR(value: TransactionV1Envelope): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionV1Envelope

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionV1Envelope
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$168` {
    var feeSource: MuxedAccount
    var fee: Int64
    var innerTx: FeeBumpTransactionInnerTx
    var ext: FeeBumpTransactionExt
}

open external class FeeBumpTransaction(attributes: `T$168`) {
    open fun feeSource(value: MuxedAccount = definedExternally): MuxedAccount
    open fun fee(value: Int64 = definedExternally): Int64
    open fun innerTx(value: FeeBumpTransactionInnerTx = definedExternally): FeeBumpTransactionInnerTx
    open fun ext(value: FeeBumpTransactionExt = definedExternally): FeeBumpTransactionExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): FeeBumpTransaction
        fun write(value: FeeBumpTransaction, io: ByteArray)
        fun isValid(value: FeeBumpTransaction): Boolean
        fun toXDR(value: FeeBumpTransaction): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): FeeBumpTransaction

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): FeeBumpTransaction
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$169` {
    var tx: FeeBumpTransaction
    var signatures: Array<DecoratedSignature>
}

open external class FeeBumpTransactionEnvelope(attributes: `T$169`) {
    open fun tx(value: FeeBumpTransaction = definedExternally): FeeBumpTransaction
    open fun signatures(value: Array<DecoratedSignature> = definedExternally): Array<DecoratedSignature>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): FeeBumpTransactionEnvelope
        fun write(value: FeeBumpTransactionEnvelope, io: ByteArray)
        fun isValid(value: FeeBumpTransactionEnvelope): Boolean
        fun toXDR(value: FeeBumpTransactionEnvelope): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): FeeBumpTransactionEnvelope

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): FeeBumpTransactionEnvelope

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$170` {
    var networkId: ByteArray
    var taggedTransaction: TransactionSignaturePayloadTaggedTransaction
}

open external class TransactionSignaturePayload(attributes: `T$170`) {
    open fun networkId(value: ByteArray = definedExternally): ByteArray
    open fun taggedTransaction(value: TransactionSignaturePayloadTaggedTransaction = definedExternally): TransactionSignaturePayloadTaggedTransaction
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionSignaturePayload
        fun write(value: TransactionSignaturePayload, io: ByteArray)
        fun isValid(value: TransactionSignaturePayload): Boolean
        fun toXDR(value: TransactionSignaturePayload): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionSignaturePayload

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): TransactionSignaturePayload

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$171` {
    var sellerId: AccountId
    var offerId: Int64
    var assetSold: Asset
    var amountSold: Int64
    var assetBought: Asset
    var amountBought: Int64
}

open external class ClaimOfferAtom(attributes: `T$171`) {
    open fun sellerId(value: AccountId = definedExternally): AccountId
    open fun offerId(value: Int64 = definedExternally): Int64
    open fun assetSold(value: Asset = definedExternally): Asset
    open fun amountSold(value: Int64 = definedExternally): Int64
    open fun assetBought(value: Asset = definedExternally): Asset
    open fun amountBought(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimOfferAtom
        fun write(value: ClaimOfferAtom, io: ByteArray)
        fun isValid(value: ClaimOfferAtom): Boolean
        fun toXDR(value: ClaimOfferAtom): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimOfferAtom

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimOfferAtom
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$172` {
    var destination: AccountId
    var asset: Asset
    var amount: Int64
}

open external class SimplePaymentResult(attributes: `T$172`) {
    open fun destination(value: AccountId = definedExternally): AccountId
    open fun asset(value: Asset = definedExternally): Asset
    open fun amount(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): SimplePaymentResult
        fun write(value: SimplePaymentResult, io: ByteArray)
        fun isValid(value: SimplePaymentResult): Boolean
        fun toXDR(value: SimplePaymentResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SimplePaymentResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SimplePaymentResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$173` {
    var offers: Array<ClaimOfferAtom>
    var last: SimplePaymentResult
}

open external class PathPaymentStrictReceiveResultSuccess(attributes: `T$173`) {
    open fun offers(value: Array<ClaimOfferAtom> = definedExternally): Array<ClaimOfferAtom>
    open fun last(value: SimplePaymentResult = definedExternally): SimplePaymentResult
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PathPaymentStrictReceiveResultSuccess
        fun write(value: PathPaymentStrictReceiveResultSuccess, io: ByteArray)
        fun isValid(value: PathPaymentStrictReceiveResultSuccess): Boolean
        fun toXDR(value: PathPaymentStrictReceiveResultSuccess): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): PathPaymentStrictReceiveResultSuccess

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): PathPaymentStrictReceiveResultSuccess

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$174` {
    var offers: Array<ClaimOfferAtom>
    var last: SimplePaymentResult
}

open external class PathPaymentStrictSendResultSuccess(attributes: `T$174`) {
    open fun offers(value: Array<ClaimOfferAtom> = definedExternally): Array<ClaimOfferAtom>
    open fun last(value: SimplePaymentResult = definedExternally): SimplePaymentResult
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): PathPaymentStrictSendResultSuccess
        fun write(value: PathPaymentStrictSendResultSuccess, io: ByteArray)
        fun isValid(value: PathPaymentStrictSendResultSuccess): Boolean
        fun toXDR(value: PathPaymentStrictSendResultSuccess): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): PathPaymentStrictSendResultSuccess

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): PathPaymentStrictSendResultSuccess

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$175` {
    var offersClaimed: Array<ClaimOfferAtom>
    var offer: ManageOfferSuccessResultOffer
}

open external class ManageOfferSuccessResult(attributes: `T$175`) {
    open fun offersClaimed(value: Array<ClaimOfferAtom> = definedExternally): Array<ClaimOfferAtom>
    open fun offer(value: ManageOfferSuccessResultOffer = definedExternally): ManageOfferSuccessResultOffer
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ManageOfferSuccessResult
        fun write(value: ManageOfferSuccessResult, io: ByteArray)
        fun isValid(value: ManageOfferSuccessResult): Boolean
        fun toXDR(value: ManageOfferSuccessResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageOfferSuccessResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageOfferSuccessResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$176` {
    var destination: AccountId
    var amount: Int64
}

open external class InflationPayout(attributes: `T$176`) {
    open fun destination(value: AccountId = definedExternally): AccountId
    open fun amount(value: Int64 = definedExternally): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): InflationPayout
        fun write(value: InflationPayout, io: ByteArray)
        fun isValid(value: InflationPayout): Boolean
        fun toXDR(value: InflationPayout): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): InflationPayout

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): InflationPayout
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$177` {
    var feeCharged: Int64
    var result: InnerTransactionResultResult
    var ext: InnerTransactionResultExt
}

open external class InnerTransactionResult(attributes: `T$177`) {
    open fun feeCharged(value: Int64 = definedExternally): Int64
    open fun result(value: InnerTransactionResultResult = definedExternally): InnerTransactionResultResult
    open fun ext(value: InnerTransactionResultExt = definedExternally): InnerTransactionResultExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): InnerTransactionResult
        fun write(value: InnerTransactionResult, io: ByteArray)
        fun isValid(value: InnerTransactionResult): Boolean
        fun toXDR(value: InnerTransactionResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): InnerTransactionResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): InnerTransactionResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$178` {
    var transactionHash: ByteArray
    var result: InnerTransactionResult
}

open external class InnerTransactionResultPair(attributes: `T$178`) {
    open fun transactionHash(value: ByteArray = definedExternally): ByteArray
    open fun result(value: InnerTransactionResult = definedExternally): InnerTransactionResult
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): InnerTransactionResultPair
        fun write(value: InnerTransactionResultPair, io: ByteArray)
        fun isValid(value: InnerTransactionResultPair): Boolean
        fun toXDR(value: InnerTransactionResultPair): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): InnerTransactionResultPair

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): InnerTransactionResultPair

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$179` {
    var feeCharged: Int64
    var result: TransactionResultResult
    var ext: TransactionResultExt
}

open external class TransactionResult(attributes: `T$179`) {
    open fun feeCharged(value: Int64 = definedExternally): Int64
    open fun result(value: TransactionResultResult = definedExternally): TransactionResultResult
    open fun ext(value: TransactionResultExt = definedExternally): TransactionResultExt
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionResult
        fun write(value: TransactionResult, io: ByteArray)
        fun isValid(value: TransactionResult): Boolean
        fun toXDR(value: TransactionResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$180` {
    var key: ByteArray
}

open external class Curve25519Secret(attributes: `T$180`) {
    open fun key(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Curve25519Secret
        fun write(value: Curve25519Secret, io: ByteArray)
        fun isValid(value: Curve25519Secret): Boolean
        fun toXDR(value: Curve25519Secret): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): Curve25519Secret

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Curve25519Secret
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class Curve25519Public(attributes: `T$180`) {
    open fun key(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): Curve25519Public
        fun write(value: Curve25519Public, io: ByteArray)
        fun isValid(value: Curve25519Public): Boolean
        fun toXDR(value: Curve25519Public): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): Curve25519Public

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Curve25519Public
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class HmacSha256Key(attributes: `T$180`) {
    open fun key(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): HmacSha256Key
        fun write(value: HmacSha256Key, io: ByteArray)
        fun isValid(value: HmacSha256Key): Boolean
        fun toXDR(value: HmacSha256Key): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): HmacSha256Key
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): HmacSha256Key
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

external interface `T$181` {
    var mac: ByteArray
}

open external class HmacSha256Mac(attributes: `T$181`) {
    open fun mac(value: ByteArray = definedExternally): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): HmacSha256Mac
        fun write(value: HmacSha256Mac, io: ByteArray)
        fun isValid(value: HmacSha256Mac): Boolean
        fun toXDR(value: HmacSha256Mac): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): HmacSha256Mac
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): HmacSha256Mac
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AssetCode {
    open fun switch(): AssetType
    open fun assetCode4(value: ByteArray = definedExternally): ByteArray
    open fun assetCode12(value: ByteArray = definedExternally): ByteArray
    open fun value(): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun assetTypeCreditAlphanum4(value: ByteArray): AssetCode
        fun assetTypeCreditAlphanum12(value: ByteArray): AssetCode
        fun read(io: ByteArray): AssetCode
        fun write(value: AssetCode, io: ByteArray)
        fun isValid(value: AssetCode): Boolean
        fun toXDR(value: AssetCode): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): AssetCode
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AssetCode
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class Asset {
    open fun switch(): AssetType
    open fun alphaNum4(value: AssetAlphaNum4 = definedExternally): AssetAlphaNum4
    open fun alphaNum12(value: AssetAlphaNum12 = definedExternally): AssetAlphaNum12
    open fun value(): dynamic /* AssetAlphaNum4 | AssetAlphaNum12 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun assetTypeNative(): Asset
        fun assetTypeCreditAlphanum4(value: AssetAlphaNum4): Asset
        fun assetTypeCreditAlphanum12(value: AssetAlphaNum12): Asset
        fun read(io: ByteArray): Asset
        fun write(value: Asset, io: ByteArray)
        fun isValid(value: Asset): Boolean
        fun toXDR(value: Asset): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Asset
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Asset
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AccountEntryExtensionV2Ext {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AccountEntryExtensionV2Ext
        fun write(value: AccountEntryExtensionV2Ext, io: ByteArray)
        fun isValid(value: AccountEntryExtensionV2Ext): Boolean
        fun toXDR(value: AccountEntryExtensionV2Ext): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AccountEntryExtensionV2Ext

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): AccountEntryExtensionV2Ext

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AccountEntryExtensionV1Ext {
    open fun switch(): Number
    open fun v2(value: AccountEntryExtensionV2 = definedExternally): AccountEntryExtensionV2
    open fun value(): dynamic /* AccountEntryExtensionV2 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AccountEntryExtensionV1Ext
        fun write(value: AccountEntryExtensionV1Ext, io: ByteArray)
        fun isValid(value: AccountEntryExtensionV1Ext): Boolean
        fun toXDR(value: AccountEntryExtensionV1Ext): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AccountEntryExtensionV1Ext

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): AccountEntryExtensionV1Ext

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AccountEntryExt {
    open fun switch(): Number
    open fun v1(value: AccountEntryExtensionV1 = definedExternally): AccountEntryExtensionV1
    open fun value(): dynamic /* AccountEntryExtensionV1 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AccountEntryExt
        fun write(value: AccountEntryExt, io: ByteArray)
        fun isValid(value: AccountEntryExt): Boolean
        fun toXDR(value: AccountEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AccountEntryExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AccountEntryExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TrustLineEntryV1Ext {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TrustLineEntryV1Ext
        fun write(value: TrustLineEntryV1Ext, io: ByteArray)
        fun isValid(value: TrustLineEntryV1Ext): Boolean
        fun toXDR(value: TrustLineEntryV1Ext): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TrustLineEntryV1Ext

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TrustLineEntryV1Ext
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TrustLineEntryExt {
    open fun switch(): Number
    open fun v1(value: TrustLineEntryV1 = definedExternally): TrustLineEntryV1
    open fun value(): dynamic /* TrustLineEntryV1 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TrustLineEntryExt
        fun write(value: TrustLineEntryExt, io: ByteArray)
        fun isValid(value: TrustLineEntryExt): Boolean
        fun toXDR(value: TrustLineEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TrustLineEntryExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TrustLineEntryExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class OfferEntryExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): OfferEntryExt
        fun write(value: OfferEntryExt, io: ByteArray)
        fun isValid(value: OfferEntryExt): Boolean
        fun toXDR(value: OfferEntryExt): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): OfferEntryExt
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OfferEntryExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class DataEntryExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): DataEntryExt
        fun write(value: DataEntryExt, io: ByteArray)
        fun isValid(value: DataEntryExt): Boolean
        fun toXDR(value: DataEntryExt): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): DataEntryExt
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): DataEntryExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClaimPredicate {
    open fun switch(): ClaimPredicateType
    open fun andPredicates(value: Array<ClaimPredicate> = definedExternally): Array<ClaimPredicate>
    open fun orPredicates(value: Array<ClaimPredicate> = definedExternally): Array<ClaimPredicate>
    open fun notPredicate(value: ClaimPredicate? = definedExternally): ClaimPredicate?
    open fun absBefore(value: Int64 = definedExternally): Int64
    open fun relBefore(value: Int64 = definedExternally): Int64
    open fun value(): dynamic /* Array<ClaimPredicate>? | Array<ClaimPredicate>? | ClaimPredicate? | Int64? | Unit? */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun claimPredicateUnconditional(): ClaimPredicate
        fun claimPredicateAnd(value: Array<ClaimPredicate>): ClaimPredicate
        fun claimPredicateOr(value: Array<ClaimPredicate>): ClaimPredicate
        fun claimPredicateNot(value: ClaimPredicate?): ClaimPredicate
        fun claimPredicateBeforeAbsoluteTime(value: Int64): ClaimPredicate
        fun claimPredicateBeforeRelativeTime(value: Int64): ClaimPredicate
        fun read(io: ByteArray): ClaimPredicate
        fun write(value: ClaimPredicate, io: ByteArray)
        fun isValid(value: ClaimPredicate): Boolean
        fun toXDR(value: ClaimPredicate): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimPredicate

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimPredicate
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class Claimant {
    open fun switch(): ClaimantType
    open fun v0(value: ClaimantV0 = definedExternally): ClaimantV0
    open fun value(): ClaimantV0
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun claimantTypeV0(value: ClaimantV0): Claimant
        fun read(io: ByteArray): Claimant
        fun write(value: Claimant, io: ByteArray)
        fun isValid(value: Claimant): Boolean
        fun toXDR(value: Claimant): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Claimant
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Claimant
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClaimableBalanceId {
    open fun switch(): ClaimableBalanceIdType
    open fun v0(value: ByteArray = definedExternally): ByteArray
    open fun value(): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun claimableBalanceIdTypeV0(value: ByteArray): ClaimableBalanceId
        fun read(io: ByteArray): ClaimableBalanceId
        fun write(value: ClaimableBalanceId, io: ByteArray)
        fun isValid(value: ClaimableBalanceId): Boolean
        fun toXDR(value: ClaimableBalanceId): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimableBalanceId

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimableBalanceId
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClaimableBalanceEntryExtensionV1Ext {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimableBalanceEntryExtensionV1Ext
        fun write(value: ClaimableBalanceEntryExtensionV1Ext, io: ByteArray)
        fun isValid(value: ClaimableBalanceEntryExtensionV1Ext): Boolean
        fun toXDR(value: ClaimableBalanceEntryExtensionV1Ext): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimableBalanceEntryExtensionV1Ext

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): ClaimableBalanceEntryExtensionV1Ext

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClaimableBalanceEntryExt {
    open fun switch(): Number
    open fun v1(value: ClaimableBalanceEntryExtensionV1 = definedExternally): ClaimableBalanceEntryExtensionV1
    open fun value(): dynamic /* ClaimableBalanceEntryExtensionV1 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ClaimableBalanceEntryExt
        fun write(value: ClaimableBalanceEntryExt, io: ByteArray)
        fun isValid(value: ClaimableBalanceEntryExt): Boolean
        fun toXDR(value: ClaimableBalanceEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimableBalanceEntryExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClaimableBalanceEntryExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerEntryExtensionV1Ext {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerEntryExtensionV1Ext
        fun write(value: LedgerEntryExtensionV1Ext, io: ByteArray)
        fun isValid(value: LedgerEntryExtensionV1Ext): Boolean
        fun toXDR(value: LedgerEntryExtensionV1Ext): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerEntryExtensionV1Ext

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerEntryExtensionV1Ext
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerEntryData {
    open fun switch(): LedgerEntryType
    open fun account(value: AccountEntry = definedExternally): AccountEntry
    open fun trustLine(value: TrustLineEntry = definedExternally): TrustLineEntry
    open fun offer(value: OfferEntry = definedExternally): OfferEntry
    open fun data(value: DataEntry = definedExternally): DataEntry
    open fun claimableBalance(value: ClaimableBalanceEntry = definedExternally): ClaimableBalanceEntry
    open fun value(): dynamic /* AccountEntry | TrustLineEntry | OfferEntry | DataEntry | ClaimableBalanceEntry */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun account(value: AccountEntry): LedgerEntryData
        fun trustline(value: TrustLineEntry): LedgerEntryData
        fun offer(value: OfferEntry): LedgerEntryData
        fun data(value: DataEntry): LedgerEntryData
        fun claimableBalance(value: ClaimableBalanceEntry): LedgerEntryData
        fun read(io: ByteArray): LedgerEntryData
        fun write(value: LedgerEntryData, io: ByteArray)
        fun isValid(value: LedgerEntryData): Boolean
        fun toXDR(value: LedgerEntryData): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerEntryData

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerEntryData
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerEntryExt {
    open fun switch(): Number
    open fun v1(value: LedgerEntryExtensionV1 = definedExternally): LedgerEntryExtensionV1
    open fun value(): dynamic /* LedgerEntryExtensionV1 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerEntryExt
        fun write(value: LedgerEntryExt, io: ByteArray)
        fun isValid(value: LedgerEntryExt): Boolean
        fun toXDR(value: LedgerEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerEntryExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerEntryExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerKey {
    open fun switch(): LedgerEntryType
    open fun account(value: LedgerKeyAccount = definedExternally): LedgerKeyAccount
    open fun trustLine(value: LedgerKeyTrustLine = definedExternally): LedgerKeyTrustLine
    open fun offer(value: LedgerKeyOffer = definedExternally): LedgerKeyOffer
    open fun data(value: LedgerKeyData = definedExternally): LedgerKeyData
    open fun claimableBalance(value: LedgerKeyClaimableBalance = definedExternally): LedgerKeyClaimableBalance
    open fun value(): dynamic /* LedgerKeyAccount | LedgerKeyTrustLine | LedgerKeyOffer | LedgerKeyData | LedgerKeyClaimableBalance */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun account(value: LedgerKeyAccount): LedgerKey
        fun trustline(value: LedgerKeyTrustLine): LedgerKey
        fun offer(value: LedgerKeyOffer): LedgerKey
        fun data(value: LedgerKeyData): LedgerKey
        fun claimableBalance(value: LedgerKeyClaimableBalance): LedgerKey
        fun read(io: ByteArray): LedgerKey
        fun write(value: LedgerKey, io: ByteArray)
        fun isValid(value: LedgerKey): Boolean
        fun toXDR(value: LedgerKey): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): LedgerKey
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerKey
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class StellarValueExt {
    open fun switch(): StellarValueType
    open fun lcValueSignature(value: LedgerCloseValueSignature = definedExternally): LedgerCloseValueSignature
    open fun value(): dynamic /* LedgerCloseValueSignature | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun stellarValueBasic(): StellarValueExt
        fun stellarValueSigned(value: LedgerCloseValueSignature): StellarValueExt
        fun read(io: ByteArray): StellarValueExt
        fun write(value: StellarValueExt, io: ByteArray)
        fun isValid(value: StellarValueExt): Boolean
        fun toXDR(value: StellarValueExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): StellarValueExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): StellarValueExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerHeaderExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerHeaderExt
        fun write(value: LedgerHeaderExt, io: ByteArray)
        fun isValid(value: LedgerHeaderExt): Boolean
        fun toXDR(value: LedgerHeaderExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerHeaderExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerHeaderExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerUpgrade {
    open fun switch(): LedgerUpgradeType
    open fun newLedgerVersion(value: Number = definedExternally): Number
    open fun newBaseFee(value: Number = definedExternally): Number
    open fun newMaxTxSetSize(value: Number = definedExternally): Number
    open fun newBaseReserve(value: Number = definedExternally): Number
    open fun value(): Number
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun ledgerUpgradeVersion(value: Number): LedgerUpgrade
        fun ledgerUpgradeBaseFee(value: Number): LedgerUpgrade
        fun ledgerUpgradeMaxTxSetSize(value: Number): LedgerUpgrade
        fun ledgerUpgradeBaseReserve(value: Number): LedgerUpgrade
        fun read(io: ByteArray): LedgerUpgrade
        fun write(value: LedgerUpgrade, io: ByteArray)
        fun isValid(value: LedgerUpgrade): Boolean
        fun toXDR(value: LedgerUpgrade): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): LedgerUpgrade
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerUpgrade
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class BucketMetadataExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): BucketMetadataExt
        fun write(value: BucketMetadataExt, io: ByteArray)
        fun isValid(value: BucketMetadataExt): Boolean
        fun toXDR(value: BucketMetadataExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): BucketMetadataExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): BucketMetadataExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class BucketEntry {
    open fun switch(): BucketEntryType
    open fun liveEntry(value: LedgerEntry = definedExternally): LedgerEntry
    open fun deadEntry(value: LedgerKey = definedExternally): LedgerKey
    open fun metaEntry(value: BucketMetadata = definedExternally): BucketMetadata
    open fun value(): dynamic /* LedgerEntry | LedgerKey | BucketMetadata */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun liveentry(value: LedgerEntry): BucketEntry
        fun initentry(value: LedgerEntry): BucketEntry
        fun deadentry(value: LedgerKey): BucketEntry
        fun metaentry(value: BucketMetadata): BucketEntry
        fun read(io: ByteArray): BucketEntry
        fun write(value: BucketEntry, io: ByteArray)
        fun isValid(value: BucketEntry): Boolean
        fun toXDR(value: BucketEntry): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): BucketEntry
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): BucketEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionHistoryEntryExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionHistoryEntryExt
        fun write(value: TransactionHistoryEntryExt, io: ByteArray)
        fun isValid(value: TransactionHistoryEntryExt): Boolean
        fun toXDR(value: TransactionHistoryEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionHistoryEntryExt

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): TransactionHistoryEntryExt

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionHistoryResultEntryExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionHistoryResultEntryExt
        fun write(value: TransactionHistoryResultEntryExt, io: ByteArray)
        fun isValid(value: TransactionHistoryResultEntryExt): Boolean
        fun toXDR(value: TransactionHistoryResultEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionHistoryResultEntryExt

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): TransactionHistoryResultEntryExt

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerHeaderHistoryEntryExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerHeaderHistoryEntryExt
        fun write(value: LedgerHeaderHistoryEntryExt, io: ByteArray)
        fun isValid(value: LedgerHeaderHistoryEntryExt): Boolean
        fun toXDR(value: LedgerHeaderHistoryEntryExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerHeaderHistoryEntryExt

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): LedgerHeaderHistoryEntryExt

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ScpHistoryEntry {
    open fun switch(): Number
    open fun v0(value: ScpHistoryEntryV0 = definedExternally): ScpHistoryEntryV0
    open fun value(): ScpHistoryEntryV0
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): ScpHistoryEntry
        fun write(value: ScpHistoryEntry, io: ByteArray)
        fun isValid(value: ScpHistoryEntry): Boolean
        fun toXDR(value: ScpHistoryEntry): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ScpHistoryEntry

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpHistoryEntry
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerEntryChange {
    open fun switch(): LedgerEntryChangeType
    open fun created(value: LedgerEntry = definedExternally): LedgerEntry
    open fun updated(value: LedgerEntry = definedExternally): LedgerEntry
    open fun removed(value: LedgerKey = definedExternally): LedgerKey
    open fun state(value: LedgerEntry = definedExternally): LedgerEntry
    open fun value(): dynamic /* LedgerEntry | LedgerKey */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun ledgerEntryCreated(value: LedgerEntry): LedgerEntryChange
        fun ledgerEntryUpdated(value: LedgerEntry): LedgerEntryChange
        fun ledgerEntryRemoved(value: LedgerKey): LedgerEntryChange
        fun ledgerEntryState(value: LedgerEntry): LedgerEntryChange
        fun read(io: ByteArray): LedgerEntryChange
        fun write(value: LedgerEntryChange, io: ByteArray)
        fun isValid(value: LedgerEntryChange): Boolean
        fun toXDR(value: LedgerEntryChange): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerEntryChange

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerEntryChange
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionMeta {
    open fun switch(): Number
    open fun operations(value: Array<OperationMeta> = definedExternally): Array<OperationMeta>
    open fun v1(value: TransactionMetaV1 = definedExternally): TransactionMetaV1
    open fun v2(value: TransactionMetaV2 = definedExternally): TransactionMetaV2
    open fun value(): dynamic /* Array<OperationMeta> | TransactionMetaV1 | TransactionMetaV2 */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionMeta
        fun write(value: TransactionMeta, io: ByteArray)
        fun isValid(value: TransactionMeta): Boolean
        fun toXDR(value: TransactionMeta): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionMeta

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionMeta
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class LedgerCloseMeta {
    open fun switch(): Number
    open fun v0(value: LedgerCloseMetaV0 = definedExternally): LedgerCloseMetaV0
    open fun value(): LedgerCloseMetaV0
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): LedgerCloseMeta
        fun write(value: LedgerCloseMeta, io: ByteArray)
        fun isValid(value: LedgerCloseMeta): Boolean
        fun toXDR(value: LedgerCloseMeta): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): LedgerCloseMeta

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): LedgerCloseMeta
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class PeerAddressIp {
    open fun switch(): IpAddrType
    open fun ipv4(value: ByteArray = definedExternally): ByteArray
    open fun ipv6(value: ByteArray = definedExternally): ByteArray
    open fun value(): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun iPv4(value: ByteArray): PeerAddressIp
        fun iPv6(value: ByteArray): PeerAddressIp
        fun read(io: ByteArray): PeerAddressIp
        fun write(value: PeerAddressIp, io: ByteArray)
        fun isValid(value: PeerAddressIp): Boolean
        fun toXDR(value: PeerAddressIp): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): PeerAddressIp
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PeerAddressIp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class SurveyResponseBody {
    open fun switch(): SurveyMessageCommandType
    open fun topologyResponseBody(value: TopologyResponseBody = definedExternally): TopologyResponseBody
    open fun value(): TopologyResponseBody
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun surveyTopology(value: TopologyResponseBody): SurveyResponseBody
        fun read(io: ByteArray): SurveyResponseBody
        fun write(value: SurveyResponseBody, io: ByteArray)
        fun isValid(value: SurveyResponseBody): Boolean
        fun toXDR(value: SurveyResponseBody): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SurveyResponseBody

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SurveyResponseBody
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class StellarMessage {
    open fun switch(): MessageType
    open fun error(value: Error = definedExternally): Error
    open fun hello(value: Hello = definedExternally): Hello
    open fun auth(value: Auth = definedExternally): Auth
    open fun dontHave(value: DontHave = definedExternally): DontHave
    open fun peers(value: Array<PeerAddress> = definedExternally): Array<PeerAddress>
    open fun txSetHash(value: ByteArray = definedExternally): ByteArray
    open fun txSet(value: TransactionSet = definedExternally): TransactionSet
    open fun transaction(value: TransactionEnvelope = definedExternally): TransactionEnvelope
    open fun signedSurveyRequestMessage(value: SignedSurveyRequestMessage = definedExternally): SignedSurveyRequestMessage
    open fun signedSurveyResponseMessage(value: SignedSurveyResponseMessage = definedExternally): SignedSurveyResponseMessage
    open fun qSetHash(value: ByteArray = definedExternally): ByteArray
    open fun qSet(value: ScpQuorumSet = definedExternally): ScpQuorumSet
    open fun envelope(value: ScpEnvelope = definedExternally): ScpEnvelope
    open fun getScpLedgerSeq(value: Number = definedExternally): Number
    open fun value(): dynamic /* Error | Hello | Auth | DontHave | Array<PeerAddress> | ByteArray | TransactionSet | TransactionEnvelope | SignedSurveyRequestMessage | SignedSurveyResponseMessage | ScpQuorumSet | ScpEnvelope | Number | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun errorMsg(value: Error): StellarMessage
        fun hello(value: Hello): StellarMessage
        fun auth(value: Auth): StellarMessage
        fun dontHave(value: DontHave): StellarMessage
        fun getPeers(): StellarMessage
        fun peers(value: Array<PeerAddress>): StellarMessage
        fun getTxSet(value: ByteArray): StellarMessage
        fun txSet(value: TransactionSet): StellarMessage
        fun transaction(value: TransactionEnvelope): StellarMessage
        fun surveyRequest(value: SignedSurveyRequestMessage): StellarMessage
        fun surveyResponse(value: SignedSurveyResponseMessage): StellarMessage
        fun getScpQuorumset(value: ByteArray): StellarMessage
        fun scpQuorumset(value: ScpQuorumSet): StellarMessage
        fun scpMessage(value: ScpEnvelope): StellarMessage
        fun getScpState(value: Number): StellarMessage
        fun read(io: ByteArray): StellarMessage
        fun write(value: StellarMessage, io: ByteArray)
        fun isValid(value: StellarMessage): Boolean
        fun toXDR(value: StellarMessage): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): StellarMessage

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): StellarMessage
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AuthenticatedMessage {
    open fun switch(): Number
    open fun v0(value: AuthenticatedMessageV0 = definedExternally): AuthenticatedMessageV0
    open fun value(): AuthenticatedMessageV0
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): AuthenticatedMessage
        fun write(value: AuthenticatedMessage, io: ByteArray)
        fun isValid(value: AuthenticatedMessage): Boolean
        fun toXDR(value: AuthenticatedMessage): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AuthenticatedMessage

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AuthenticatedMessage
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ScpStatementPledges {
    open fun switch(): ScpStatementType
    open fun prepare(value: ScpStatementPrepare = definedExternally): ScpStatementPrepare
    open fun confirm(value: ScpStatementConfirm = definedExternally): ScpStatementConfirm
    open fun externalize(value: ScpStatementExternalize = definedExternally): ScpStatementExternalize
    open fun nominate(value: ScpNomination = definedExternally): ScpNomination
    open fun value(): dynamic /* ScpStatementPrepare | ScpStatementConfirm | ScpStatementExternalize | ScpNomination */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun scpStPrepare(value: ScpStatementPrepare): ScpStatementPledges
        fun scpStConfirm(value: ScpStatementConfirm): ScpStatementPledges
        fun scpStExternalize(value: ScpStatementExternalize): ScpStatementPledges
        fun scpStNominate(value: ScpNomination): ScpStatementPledges
        fun read(io: ByteArray): ScpStatementPledges
        fun write(value: ScpStatementPledges, io: ByteArray)
        fun isValid(value: ScpStatementPledges): Boolean
        fun toXDR(value: ScpStatementPledges): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ScpStatementPledges

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ScpStatementPledges
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class MuxedAccount {
    open fun switch(): CryptoKeyType
    open fun ed25519(value: ByteArray = definedExternally): ByteArray
    open fun med25519(value: MuxedAccountMed25519 = definedExternally): MuxedAccountMed25519
    open fun value(): dynamic /* ByteArray | MuxedAccountMed25519 */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun keyTypeEd25519(value: ByteArray): MuxedAccount
        fun keyTypeMuxedEd25519(value: MuxedAccountMed25519): MuxedAccount
        fun read(io: ByteArray): MuxedAccount
        fun write(value: MuxedAccount, io: ByteArray)
        fun isValid(value: MuxedAccount): Boolean
        fun toXDR(value: MuxedAccount): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): MuxedAccount
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): MuxedAccount
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class RevokeSponsorshipOp {
    open fun switch(): RevokeSponsorshipType
    open fun ledgerKey(value: LedgerKey = definedExternally): LedgerKey
    open fun signer(value: RevokeSponsorshipOpSigner = definedExternally): RevokeSponsorshipOpSigner
    open fun value(): dynamic /* LedgerKey | RevokeSponsorshipOpSigner */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun revokeSponsorshipLedgerEntry(value: LedgerKey): RevokeSponsorshipOp
        fun revokeSponsorshipSigner(value: RevokeSponsorshipOpSigner): RevokeSponsorshipOp
        fun read(io: ByteArray): RevokeSponsorshipOp
        fun write(value: RevokeSponsorshipOp, io: ByteArray)
        fun isValid(value: RevokeSponsorshipOp): Boolean
        fun toXDR(value: RevokeSponsorshipOp): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): RevokeSponsorshipOp

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): RevokeSponsorshipOp
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class OperationBody {
    open fun switch(): OperationType
    open fun createAccountOp(value: CreateAccountOp = definedExternally): CreateAccountOp
    open fun paymentOp(value: PaymentOp = definedExternally): PaymentOp
    open fun pathPaymentStrictReceiveOp(value: PathPaymentStrictReceiveOp = definedExternally): PathPaymentStrictReceiveOp
    open fun manageSellOfferOp(value: ManageSellOfferOp = definedExternally): ManageSellOfferOp
    open fun createPassiveSellOfferOp(value: CreatePassiveSellOfferOp = definedExternally): CreatePassiveSellOfferOp
    open fun setOptionsOp(value: SetOptionsOp = definedExternally): SetOptionsOp
    open fun changeTrustOp(value: ChangeTrustOp = definedExternally): ChangeTrustOp
    open fun allowTrustOp(value: AllowTrustOp = definedExternally): AllowTrustOp
    open fun destination(value: MuxedAccount = definedExternally): MuxedAccount
    open fun manageDataOp(value: ManageDataOp = definedExternally): ManageDataOp
    open fun bumpSequenceOp(value: BumpSequenceOp = definedExternally): BumpSequenceOp
    open fun manageBuyOfferOp(value: ManageBuyOfferOp = definedExternally): ManageBuyOfferOp
    open fun pathPaymentStrictSendOp(value: PathPaymentStrictSendOp = definedExternally): PathPaymentStrictSendOp
    open fun createClaimableBalanceOp(value: CreateClaimableBalanceOp = definedExternally): CreateClaimableBalanceOp
    open fun claimClaimableBalanceOp(value: ClaimClaimableBalanceOp = definedExternally): ClaimClaimableBalanceOp
    open fun beginSponsoringFutureReservesOp(value: BeginSponsoringFutureReservesOp = definedExternally): BeginSponsoringFutureReservesOp
    open fun revokeSponsorshipOp(value: RevokeSponsorshipOp = definedExternally): RevokeSponsorshipOp
    open fun clawbackOp(value: ClawbackOp = definedExternally): ClawbackOp
    open fun clawbackClaimableBalanceOp(value: ClawbackClaimableBalanceOp = definedExternally): ClawbackClaimableBalanceOp
    open fun setTrustLineFlagsOp(value: SetTrustLineFlagsOp = definedExternally): SetTrustLineFlagsOp
    open fun value(): dynamic /* CreateAccountOp | PaymentOp | PathPaymentStrictReceiveOp | ManageSellOfferOp | CreatePassiveSellOfferOp | SetOptionsOp | ChangeTrustOp | AllowTrustOp | MuxedAccount | ManageDataOp | BumpSequenceOp | ManageBuyOfferOp | PathPaymentStrictSendOp | CreateClaimableBalanceOp | ClaimClaimableBalanceOp | BeginSponsoringFutureReservesOp | RevokeSponsorshipOp | ClawbackOp | ClawbackClaimableBalanceOp | SetTrustLineFlagsOp | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun createAccount(value: CreateAccountOp): OperationBody
        fun payment(value: PaymentOp): OperationBody
        fun pathPaymentStrictReceive(value: PathPaymentStrictReceiveOp): OperationBody
        fun manageSellOffer(value: ManageSellOfferOp): OperationBody
        fun createPassiveSellOffer(value: CreatePassiveSellOfferOp): OperationBody
        fun setOptions(value: SetOptionsOp): OperationBody
        fun changeTrust(value: ChangeTrustOp): OperationBody
        fun allowTrust(value: AllowTrustOp): OperationBody
        fun accountMerge(value: MuxedAccount): OperationBody
        fun inflation(): OperationBody
        fun manageData(value: ManageDataOp): OperationBody
        fun bumpSequence(value: BumpSequenceOp): OperationBody
        fun manageBuyOffer(value: ManageBuyOfferOp): OperationBody
        fun pathPaymentStrictSend(value: PathPaymentStrictSendOp): OperationBody
        fun createClaimableBalance(value: CreateClaimableBalanceOp): OperationBody
        fun claimClaimableBalance(value: ClaimClaimableBalanceOp): OperationBody
        fun beginSponsoringFutureReserves(value: BeginSponsoringFutureReservesOp): OperationBody
        fun endSponsoringFutureReserves(): OperationBody
        fun revokeSponsorship(value: RevokeSponsorshipOp): OperationBody
        fun clawback(value: ClawbackOp): OperationBody
        fun clawbackClaimableBalance(value: ClawbackClaimableBalanceOp): OperationBody
        fun setTrustLineFlags(value: SetTrustLineFlagsOp): OperationBody
        fun read(io: ByteArray): OperationBody
        fun write(value: OperationBody, io: ByteArray)
        fun isValid(value: OperationBody): Boolean
        fun toXDR(value: OperationBody): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): OperationBody
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OperationBody
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class OperationId {
    open fun switch(): EnvelopeType
    open fun id(value: OperationIdId = definedExternally): OperationIdId
    open fun value(): OperationIdId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun envelopeTypeOpId(value: OperationIdId): OperationId
        fun read(io: ByteArray): OperationId
        fun write(value: OperationId, io: ByteArray)
        fun isValid(value: OperationId): Boolean
        fun toXDR(value: OperationId): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): OperationId
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OperationId
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class Memo {
    open fun switch(): MemoType
    open fun text(value: String = definedExternally): dynamic /* String | ByteArray */
    open fun text(): dynamic /* String | ByteArray */
    open fun text(value: ByteArray = definedExternally): dynamic /* String | ByteArray */
    open fun id(value: Uint64 = definedExternally): Uint64
    open fun hash(value: ByteArray = definedExternally): ByteArray
    open fun retHash(value: ByteArray = definedExternally): ByteArray
    open fun value(): dynamic /* String | ByteArray | Uint64 | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun memoNone(): Memo
        fun memoText(value: String): Memo
        fun memoText(value: ByteArray): Memo
        fun memoId(value: Uint64): Memo
        fun memoHash(value: ByteArray): Memo
        fun memoReturn(value: ByteArray): Memo
        fun read(io: ByteArray): Memo
        fun write(value: Memo, io: ByteArray)
        fun isValid(value: Memo): Boolean
        fun toXDR(value: Memo): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Memo
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Memo
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionV0Ext {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionV0Ext
        fun write(value: TransactionV0Ext, io: ByteArray)
        fun isValid(value: TransactionV0Ext): Boolean
        fun toXDR(value: TransactionV0Ext): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionV0Ext

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionV0Ext
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionExt
        fun write(value: TransactionExt, io: ByteArray)
        fun isValid(value: TransactionExt): Boolean
        fun toXDR(value: TransactionExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class FeeBumpTransactionInnerTx {
    open fun switch(): EnvelopeType
    open fun v1(value: TransactionV1Envelope = definedExternally): TransactionV1Envelope
    open fun value(): TransactionV1Envelope
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun envelopeTypeTx(value: TransactionV1Envelope): FeeBumpTransactionInnerTx
        fun read(io: ByteArray): FeeBumpTransactionInnerTx
        fun write(value: FeeBumpTransactionInnerTx, io: ByteArray)
        fun isValid(value: FeeBumpTransactionInnerTx): Boolean
        fun toXDR(value: FeeBumpTransactionInnerTx): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): FeeBumpTransactionInnerTx

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): FeeBumpTransactionInnerTx
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class FeeBumpTransactionExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): FeeBumpTransactionExt
        fun write(value: FeeBumpTransactionExt, io: ByteArray)
        fun isValid(value: FeeBumpTransactionExt): Boolean
        fun toXDR(value: FeeBumpTransactionExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): FeeBumpTransactionExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): FeeBumpTransactionExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionEnvelope {
    open fun switch(): EnvelopeType
    open fun v0(value: TransactionV0Envelope = definedExternally): TransactionV0Envelope
    open fun v1(value: TransactionV1Envelope = definedExternally): TransactionV1Envelope
    open fun feeBump(value: FeeBumpTransactionEnvelope = definedExternally): FeeBumpTransactionEnvelope
    open fun value(): dynamic /* TransactionV0Envelope | TransactionV1Envelope | FeeBumpTransactionEnvelope */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun envelopeTypeTxV0(value: TransactionV0Envelope): TransactionEnvelope
        fun envelopeTypeTx(value: TransactionV1Envelope): TransactionEnvelope
        fun envelopeTypeTxFeeBump(value: FeeBumpTransactionEnvelope): TransactionEnvelope
        fun read(io: ByteArray): TransactionEnvelope
        fun write(value: TransactionEnvelope, io: ByteArray)
        fun isValid(value: TransactionEnvelope): Boolean
        fun toXDR(value: TransactionEnvelope): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionEnvelope

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionEnvelope
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionSignaturePayloadTaggedTransaction {
    open fun switch(): EnvelopeType
    open fun tx(value: Transaction = definedExternally): Transaction
    open fun feeBump(value: FeeBumpTransaction = definedExternally): FeeBumpTransaction
    open fun value(): dynamic /* Transaction | FeeBumpTransaction */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun envelopeTypeTx(value: Transaction): TransactionSignaturePayloadTaggedTransaction
        fun envelopeTypeTxFeeBump(value: FeeBumpTransaction): TransactionSignaturePayloadTaggedTransaction
        fun read(io: ByteArray): TransactionSignaturePayloadTaggedTransaction
        fun write(value: TransactionSignaturePayloadTaggedTransaction, io: ByteArray)
        fun isValid(value: TransactionSignaturePayloadTaggedTransaction): Boolean
        fun toXDR(value: TransactionSignaturePayloadTaggedTransaction): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionSignaturePayloadTaggedTransaction

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): TransactionSignaturePayloadTaggedTransaction

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class CreateAccountResult {
    open fun switch(): CreateAccountResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun createAccountSuccess(): CreateAccountResult
        fun read(io: ByteArray): CreateAccountResult
        fun write(value: CreateAccountResult, io: ByteArray)
        fun isValid(value: CreateAccountResult): Boolean
        fun toXDR(value: CreateAccountResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): CreateAccountResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): CreateAccountResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class PaymentResult {
    open fun switch(): PaymentResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun paymentSuccess(): PaymentResult
        fun read(io: ByteArray): PaymentResult
        fun write(value: PaymentResult, io: ByteArray)
        fun isValid(value: PaymentResult): Boolean
        fun toXDR(value: PaymentResult): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): PaymentResult
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PaymentResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class PathPaymentStrictReceiveResult {
    open fun switch(): PathPaymentStrictReceiveResultCode
    open fun success(value: PathPaymentStrictReceiveResultSuccess = definedExternally): PathPaymentStrictReceiveResultSuccess
    open fun noIssuer(value: Asset = definedExternally): Asset
    open fun value(): dynamic /* PathPaymentStrictReceiveResultSuccess | Asset */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun pathPaymentStrictReceiveSuccess(value: PathPaymentStrictReceiveResultSuccess): PathPaymentStrictReceiveResult
        fun pathPaymentStrictReceiveNoIssuer(value: Asset): PathPaymentStrictReceiveResult
        fun read(io: ByteArray): PathPaymentStrictReceiveResult
        fun write(value: PathPaymentStrictReceiveResult, io: ByteArray)
        fun isValid(value: PathPaymentStrictReceiveResult): Boolean
        fun toXDR(value: PathPaymentStrictReceiveResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): PathPaymentStrictReceiveResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): PathPaymentStrictReceiveResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class PathPaymentStrictSendResult {
    open fun switch(): PathPaymentStrictSendResultCode
    open fun success(value: PathPaymentStrictSendResultSuccess = definedExternally): PathPaymentStrictSendResultSuccess
    open fun noIssuer(value: Asset = definedExternally): Asset
    open fun value(): dynamic /* PathPaymentStrictSendResultSuccess | Asset */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun pathPaymentStrictSendSuccess(value: PathPaymentStrictSendResultSuccess): PathPaymentStrictSendResult
        fun pathPaymentStrictSendNoIssuer(value: Asset): PathPaymentStrictSendResult
        fun read(io: ByteArray): PathPaymentStrictSendResult
        fun write(value: PathPaymentStrictSendResult, io: ByteArray)
        fun isValid(value: PathPaymentStrictSendResult): Boolean
        fun toXDR(value: PathPaymentStrictSendResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): PathPaymentStrictSendResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): PathPaymentStrictSendResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ManageOfferSuccessResultOffer {
    open fun switch(): ManageOfferEffect
    open fun offer(value: OfferEntry = definedExternally): OfferEntry
    open fun value(): OfferEntry
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun manageOfferCreated(value: OfferEntry): ManageOfferSuccessResultOffer
        fun manageOfferUpdated(value: OfferEntry): ManageOfferSuccessResultOffer
        fun read(io: ByteArray): ManageOfferSuccessResultOffer
        fun write(value: ManageOfferSuccessResultOffer, io: ByteArray)
        fun isValid(value: ManageOfferSuccessResultOffer): Boolean
        fun toXDR(value: ManageOfferSuccessResultOffer): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageOfferSuccessResultOffer

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): ManageOfferSuccessResultOffer

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ManageSellOfferResult {
    open fun switch(): ManageSellOfferResultCode
    open fun success(value: ManageOfferSuccessResult = definedExternally): ManageOfferSuccessResult
    open fun value(): ManageOfferSuccessResult
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun manageSellOfferSuccess(value: ManageOfferSuccessResult): ManageSellOfferResult
        fun read(io: ByteArray): ManageSellOfferResult
        fun write(value: ManageSellOfferResult, io: ByteArray)
        fun isValid(value: ManageSellOfferResult): Boolean
        fun toXDR(value: ManageSellOfferResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageSellOfferResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageSellOfferResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ManageBuyOfferResult {
    open fun switch(): ManageBuyOfferResultCode
    open fun success(value: ManageOfferSuccessResult = definedExternally): ManageOfferSuccessResult
    open fun value(): ManageOfferSuccessResult
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun manageBuyOfferSuccess(value: ManageOfferSuccessResult): ManageBuyOfferResult
        fun read(io: ByteArray): ManageBuyOfferResult
        fun write(value: ManageBuyOfferResult, io: ByteArray)
        fun isValid(value: ManageBuyOfferResult): Boolean
        fun toXDR(value: ManageBuyOfferResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageBuyOfferResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageBuyOfferResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class SetOptionsResult {
    open fun switch(): SetOptionsResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun setOptionsSuccess(): SetOptionsResult
        fun read(io: ByteArray): SetOptionsResult
        fun write(value: SetOptionsResult, io: ByteArray)
        fun isValid(value: SetOptionsResult): Boolean
        fun toXDR(value: SetOptionsResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SetOptionsResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SetOptionsResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ChangeTrustResult {
    open fun switch(): ChangeTrustResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun changeTrustSuccess(): ChangeTrustResult
        fun read(io: ByteArray): ChangeTrustResult
        fun write(value: ChangeTrustResult, io: ByteArray)
        fun isValid(value: ChangeTrustResult): Boolean
        fun toXDR(value: ChangeTrustResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ChangeTrustResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ChangeTrustResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AllowTrustResult {
    open fun switch(): AllowTrustResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun allowTrustSuccess(): AllowTrustResult
        fun read(io: ByteArray): AllowTrustResult
        fun write(value: AllowTrustResult, io: ByteArray)
        fun isValid(value: AllowTrustResult): Boolean
        fun toXDR(value: AllowTrustResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AllowTrustResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AllowTrustResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class AccountMergeResult {
    open fun switch(): AccountMergeResultCode
    open fun sourceAccountBalance(value: Int64 = definedExternally): Int64
    open fun value(): Int64
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun accountMergeSuccess(value: Int64): AccountMergeResult
        fun read(io: ByteArray): AccountMergeResult
        fun write(value: AccountMergeResult, io: ByteArray)
        fun isValid(value: AccountMergeResult): Boolean
        fun toXDR(value: AccountMergeResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): AccountMergeResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): AccountMergeResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class InflationResult {
    open fun switch(): InflationResultCode
    open fun payouts(value: Array<InflationPayout> = definedExternally): Array<InflationPayout>
    open fun value(): Array<InflationPayout>
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun inflationSuccess(value: Array<InflationPayout>): InflationResult
        fun read(io: ByteArray): InflationResult
        fun write(value: InflationResult, io: ByteArray)
        fun isValid(value: InflationResult): Boolean
        fun toXDR(value: InflationResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): InflationResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): InflationResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ManageDataResult {
    open fun switch(): ManageDataResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun manageDataSuccess(): ManageDataResult
        fun read(io: ByteArray): ManageDataResult
        fun write(value: ManageDataResult, io: ByteArray)
        fun isValid(value: ManageDataResult): Boolean
        fun toXDR(value: ManageDataResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ManageDataResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ManageDataResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class BumpSequenceResult {
    open fun switch(): BumpSequenceResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun bumpSequenceSuccess(): BumpSequenceResult
        fun read(io: ByteArray): BumpSequenceResult
        fun write(value: BumpSequenceResult, io: ByteArray)
        fun isValid(value: BumpSequenceResult): Boolean
        fun toXDR(value: BumpSequenceResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): BumpSequenceResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): BumpSequenceResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class CreateClaimableBalanceResult {
    open fun switch(): CreateClaimableBalanceResultCode
    open fun balanceId(value: ClaimableBalanceId = definedExternally): ClaimableBalanceId
    open fun value(): ClaimableBalanceId
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun createClaimableBalanceSuccess(value: ClaimableBalanceId): CreateClaimableBalanceResult
        fun read(io: ByteArray): CreateClaimableBalanceResult
        fun write(value: CreateClaimableBalanceResult, io: ByteArray)
        fun isValid(value: CreateClaimableBalanceResult): Boolean
        fun toXDR(value: CreateClaimableBalanceResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): CreateClaimableBalanceResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): CreateClaimableBalanceResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClaimClaimableBalanceResult {
    open fun switch(): ClaimClaimableBalanceResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun claimClaimableBalanceSuccess(): ClaimClaimableBalanceResult
        fun read(io: ByteArray): ClaimClaimableBalanceResult
        fun write(value: ClaimClaimableBalanceResult, io: ByteArray)
        fun isValid(value: ClaimClaimableBalanceResult): Boolean
        fun toXDR(value: ClaimClaimableBalanceResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClaimClaimableBalanceResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): ClaimClaimableBalanceResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class BeginSponsoringFutureReservesResult {
    open fun switch(): BeginSponsoringFutureReservesResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun beginSponsoringFutureReservesSuccess(): BeginSponsoringFutureReservesResult
        fun read(io: ByteArray): BeginSponsoringFutureReservesResult
        fun write(value: BeginSponsoringFutureReservesResult, io: ByteArray)
        fun isValid(value: BeginSponsoringFutureReservesResult): Boolean
        fun toXDR(value: BeginSponsoringFutureReservesResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): BeginSponsoringFutureReservesResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): BeginSponsoringFutureReservesResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class EndSponsoringFutureReservesResult {
    open fun switch(): EndSponsoringFutureReservesResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun endSponsoringFutureReservesSuccess(): EndSponsoringFutureReservesResult
        fun read(io: ByteArray): EndSponsoringFutureReservesResult
        fun write(value: EndSponsoringFutureReservesResult, io: ByteArray)
        fun isValid(value: EndSponsoringFutureReservesResult): Boolean
        fun toXDR(value: EndSponsoringFutureReservesResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): EndSponsoringFutureReservesResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): EndSponsoringFutureReservesResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class RevokeSponsorshipResult {
    open fun switch(): RevokeSponsorshipResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun revokeSponsorshipSuccess(): RevokeSponsorshipResult
        fun read(io: ByteArray): RevokeSponsorshipResult
        fun write(value: RevokeSponsorshipResult, io: ByteArray)
        fun isValid(value: RevokeSponsorshipResult): Boolean
        fun toXDR(value: RevokeSponsorshipResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): RevokeSponsorshipResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): RevokeSponsorshipResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClawbackResult {
    open fun switch(): ClawbackResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun clawbackSuccess(): ClawbackResult
        fun read(io: ByteArray): ClawbackResult
        fun write(value: ClawbackResult, io: ByteArray)
        fun isValid(value: ClawbackResult): Boolean
        fun toXDR(value: ClawbackResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClawbackResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): ClawbackResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class ClawbackClaimableBalanceResult {
    open fun switch(): ClawbackClaimableBalanceResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun clawbackClaimableBalanceSuccess(): ClawbackClaimableBalanceResult
        fun read(io: ByteArray): ClawbackClaimableBalanceResult
        fun write(value: ClawbackClaimableBalanceResult, io: ByteArray)
        fun isValid(value: ClawbackClaimableBalanceResult): Boolean
        fun toXDR(value: ClawbackClaimableBalanceResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): ClawbackClaimableBalanceResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): ClawbackClaimableBalanceResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class SetTrustLineFlagsResult {
    open fun switch(): SetTrustLineFlagsResultCode
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun setTrustLineFlagsSuccess(): SetTrustLineFlagsResult
        fun read(io: ByteArray): SetTrustLineFlagsResult
        fun write(value: SetTrustLineFlagsResult, io: ByteArray)
        fun isValid(value: SetTrustLineFlagsResult): Boolean
        fun toXDR(value: SetTrustLineFlagsResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): SetTrustLineFlagsResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SetTrustLineFlagsResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class OperationResultTr {
    open fun switch(): OperationType
    open fun createAccountResult(value: CreateAccountResult = definedExternally): CreateAccountResult
    open fun paymentResult(value: PaymentResult = definedExternally): PaymentResult
    open fun pathPaymentStrictReceiveResult(value: PathPaymentStrictReceiveResult = definedExternally): PathPaymentStrictReceiveResult
    open fun manageSellOfferResult(value: ManageSellOfferResult = definedExternally): ManageSellOfferResult
    open fun createPassiveSellOfferResult(value: ManageSellOfferResult = definedExternally): ManageSellOfferResult
    open fun setOptionsResult(value: SetOptionsResult = definedExternally): SetOptionsResult
    open fun changeTrustResult(value: ChangeTrustResult = definedExternally): ChangeTrustResult
    open fun allowTrustResult(value: AllowTrustResult = definedExternally): AllowTrustResult
    open fun accountMergeResult(value: AccountMergeResult = definedExternally): AccountMergeResult
    open fun inflationResult(value: InflationResult = definedExternally): InflationResult
    open fun manageDataResult(value: ManageDataResult = definedExternally): ManageDataResult
    open fun bumpSeqResult(value: BumpSequenceResult = definedExternally): BumpSequenceResult
    open fun manageBuyOfferResult(value: ManageBuyOfferResult = definedExternally): ManageBuyOfferResult
    open fun pathPaymentStrictSendResult(value: PathPaymentStrictSendResult = definedExternally): PathPaymentStrictSendResult
    open fun createClaimableBalanceResult(value: CreateClaimableBalanceResult = definedExternally): CreateClaimableBalanceResult
    open fun claimClaimableBalanceResult(value: ClaimClaimableBalanceResult = definedExternally): ClaimClaimableBalanceResult
    open fun beginSponsoringFutureReservesResult(value: BeginSponsoringFutureReservesResult = definedExternally): BeginSponsoringFutureReservesResult
    open fun endSponsoringFutureReservesResult(value: EndSponsoringFutureReservesResult = definedExternally): EndSponsoringFutureReservesResult
    open fun revokeSponsorshipResult(value: RevokeSponsorshipResult = definedExternally): RevokeSponsorshipResult
    open fun clawbackResult(value: ClawbackResult = definedExternally): ClawbackResult
    open fun clawbackClaimableBalanceResult(value: ClawbackClaimableBalanceResult = definedExternally): ClawbackClaimableBalanceResult
    open fun setTrustLineFlagsResult(value: SetTrustLineFlagsResult = definedExternally): SetTrustLineFlagsResult
    open fun value(): dynamic /* CreateAccountResult | PaymentResult | PathPaymentStrictReceiveResult | ManageSellOfferResult | SetOptionsResult | ChangeTrustResult | AllowTrustResult | AccountMergeResult | InflationResult | ManageDataResult | BumpSequenceResult | ManageBuyOfferResult | PathPaymentStrictSendResult | CreateClaimableBalanceResult | ClaimClaimableBalanceResult | BeginSponsoringFutureReservesResult | EndSponsoringFutureReservesResult | RevokeSponsorshipResult | ClawbackResult | ClawbackClaimableBalanceResult | SetTrustLineFlagsResult */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun createAccount(value: CreateAccountResult): OperationResultTr
        fun payment(value: PaymentResult): OperationResultTr
        fun pathPaymentStrictReceive(value: PathPaymentStrictReceiveResult): OperationResultTr
        fun manageSellOffer(value: ManageSellOfferResult): OperationResultTr
        fun createPassiveSellOffer(value: ManageSellOfferResult): OperationResultTr
        fun setOptions(value: SetOptionsResult): OperationResultTr
        fun changeTrust(value: ChangeTrustResult): OperationResultTr
        fun allowTrust(value: AllowTrustResult): OperationResultTr
        fun accountMerge(value: AccountMergeResult): OperationResultTr
        fun inflation(value: InflationResult): OperationResultTr
        fun manageData(value: ManageDataResult): OperationResultTr
        fun bumpSequence(value: BumpSequenceResult): OperationResultTr
        fun manageBuyOffer(value: ManageBuyOfferResult): OperationResultTr
        fun pathPaymentStrictSend(value: PathPaymentStrictSendResult): OperationResultTr
        fun createClaimableBalance(value: CreateClaimableBalanceResult): OperationResultTr
        fun claimClaimableBalance(value: ClaimClaimableBalanceResult): OperationResultTr
        fun beginSponsoringFutureReserves(value: BeginSponsoringFutureReservesResult): OperationResultTr
        fun endSponsoringFutureReserves(value: EndSponsoringFutureReservesResult): OperationResultTr
        fun revokeSponsorship(value: RevokeSponsorshipResult): OperationResultTr
        fun clawback(value: ClawbackResult): OperationResultTr
        fun clawbackClaimableBalance(value: ClawbackClaimableBalanceResult): OperationResultTr
        fun setTrustLineFlags(value: SetTrustLineFlagsResult): OperationResultTr
        fun read(io: ByteArray): OperationResultTr
        fun write(value: OperationResultTr, io: ByteArray)
        fun isValid(value: OperationResultTr): Boolean
        fun toXDR(value: OperationResultTr): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): OperationResultTr

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OperationResultTr
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class OperationResult {
    open fun switch(): OperationResultCode
    open fun tr(value: OperationResultTr = definedExternally): OperationResultTr
    open fun value(): OperationResultTr
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun opInner(value: OperationResultTr): OperationResult
        fun read(io: ByteArray): OperationResult
        fun write(value: OperationResult, io: ByteArray)
        fun isValid(value: OperationResult): Boolean
        fun toXDR(value: OperationResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): OperationResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): OperationResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class InnerTransactionResultResult {
    open fun switch(): TransactionResultCode
    open fun results(value: Array<OperationResult> = definedExternally): Array<OperationResult>
    open fun value(): dynamic /* Array<OperationResult> | Unit */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun txSuccess(value: Array<OperationResult>): InnerTransactionResultResult
        fun txFailed(value: Array<OperationResult>): InnerTransactionResultResult
        fun txTooEarly(): InnerTransactionResultResult
        fun txTooLate(): InnerTransactionResultResult
        fun txMissingOperation(): InnerTransactionResultResult
        fun txBadSeq(): InnerTransactionResultResult
        fun txBadAuth(): InnerTransactionResultResult
        fun txInsufficientBalance(): InnerTransactionResultResult
        fun txNoAccount(): InnerTransactionResultResult
        fun txInsufficientFee(): InnerTransactionResultResult
        fun txBadAuthExtra(): InnerTransactionResultResult
        fun txInternalError(): InnerTransactionResultResult
        fun txNotSupported(): InnerTransactionResultResult
        fun txBadSponsorship(): InnerTransactionResultResult
        fun read(io: ByteArray): InnerTransactionResultResult
        fun write(value: InnerTransactionResultResult, io: ByteArray)
        fun isValid(value: InnerTransactionResultResult): Boolean
        fun toXDR(value: InnerTransactionResultResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): InnerTransactionResultResult

        fun fromXDR(
            input: String,
            format: String /* "hex" | "base64" */
        ): InnerTransactionResultResult

        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class InnerTransactionResultExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): InnerTransactionResultExt
        fun write(value: InnerTransactionResultExt, io: ByteArray)
        fun isValid(value: InnerTransactionResultExt): Boolean
        fun toXDR(value: InnerTransactionResultExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): InnerTransactionResultExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): InnerTransactionResultExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionResultResult {
    open fun switch(): TransactionResultCode
    open fun innerResultPair(value: InnerTransactionResultPair = definedExternally): InnerTransactionResultPair
    open fun results(value: Array<OperationResult> = definedExternally): Array<OperationResult>
    open fun value(): dynamic /* InnerTransactionResultPair | Array<OperationResult> */
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun txFeeBumpInnerSuccess(value: InnerTransactionResultPair): TransactionResultResult
        fun txFeeBumpInnerFailed(value: InnerTransactionResultPair): TransactionResultResult
        fun txSuccess(value: Array<OperationResult>): TransactionResultResult
        fun txFailed(value: Array<OperationResult>): TransactionResultResult
        fun read(io: ByteArray): TransactionResultResult
        fun write(value: TransactionResultResult, io: ByteArray)
        fun isValid(value: TransactionResultResult): Boolean
        fun toXDR(value: TransactionResultResult): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionResultResult

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionResultResult
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class TransactionResultExt {
    open fun switch(): Number
    open fun value()
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun read(io: ByteArray): TransactionResultExt
        fun write(value: TransactionResultExt, io: ByteArray)
        fun isValid(value: TransactionResultExt): Boolean
        fun toXDR(value: TransactionResultExt): ByteArray
        fun fromXDR(
            input: ByteArray,
            format: String /* "raw" */ = definedExternally
        ): TransactionResultExt

        fun fromXDR(input: String, format: String /* "hex" | "base64" */): TransactionResultExt
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class PublicKey {
    open fun switch(): PublicKeyType
    open fun ed25519(value: ByteArray = definedExternally): ByteArray
    open fun value(): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun publicKeyTypeEd25519(value: ByteArray): PublicKey
        fun read(io: ByteArray): PublicKey
        fun write(value: PublicKey, io: ByteArray)
        fun isValid(value: PublicKey): Boolean
        fun toXDR(value: PublicKey): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): PublicKey
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): PublicKey
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

open external class SignerKey {
    open fun switch(): SignerKeyType
    open fun ed25519(value: ByteArray = definedExternally): ByteArray
    open fun preAuthTx(value: ByteArray = definedExternally): ByteArray
    open fun hashX(value: ByteArray = definedExternally): ByteArray
    open fun value(): ByteArray
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun signerKeyTypeEd25519(value: ByteArray): SignerKey
        fun signerKeyTypePreAuthTx(value: ByteArray): SignerKey
        fun signerKeyTypeHashX(value: ByteArray): SignerKey
        fun read(io: ByteArray): SignerKey
        fun write(value: SignerKey, io: ByteArray)
        fun isValid(value: SignerKey): Boolean
        fun toXDR(value: SignerKey): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): SignerKey
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): SignerKey
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}