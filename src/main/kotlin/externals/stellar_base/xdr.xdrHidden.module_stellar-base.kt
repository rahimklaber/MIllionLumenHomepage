//@file:JsQualifier("xdrHidden")
@file:JsNonModule
@file:JsModule("stellar-base")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package xdrHidden

import OperationOptions.BaseOptions
import xdr.MuxedAccount
import xdr.OperationBody

external interface `T$81` {
    var sourceAccount: MuxedAccount?
    var body: OperationBody
}

open external class Operation(attributes: `T$81`) {
    open fun sourceAccount(value: MuxedAccount? = definedExternally): MuxedAccount?
    open fun body(value: OperationBody = definedExternally): OperationBody
    open fun toXDR(format: String /* "raw" | "hex" | "base64" */ = definedExternally): dynamic /* ByteArray | String */
    open fun toXDR(): ByteArray

    companion object {
        fun payment(options: OperationOptions.Payment): Operation
        fun accountMerge(options: OperationOptions.AccountMerge): Operation
        fun allowTrust(options: OperationOptions.AllowTrust): Operation
        fun changeTrust(options: OperationOptions.ChangeTrust): Operation
        fun createAccount(options: OperationOptions.CreateAccount): Operation
        fun createPassiveSellOffer(options: OperationOptions.CreatePassiveSellOffer): Operation
        fun inflation(options: OperationOptions.Inflation): Operation
        fun manageData(options: OperationOptions.ManageData): Operation
        fun manageSellOffer(options: OperationOptions.ManageSellOffer): Operation
        fun manageBuyOffer(options: OperationOptions.ManageBuyOffer): Operation
        fun pathPaymentStrictReceive(options: OperationOptions.PathPaymentStrictReceive): Operation
        fun pathPaymentStrictSend(options: OperationOptions.PathPaymentStrictSend): Operation
        fun <T> setOptions(options: OperationOptions.SetOptions<T>): Operation
        fun bumpSequence(options: OperationOptions.BumpSequence): Operation
        fun createClaimableBalance(options: OperationOptions.CreateClaimableBalance): Operation
        fun claimClaimableBalance(options: OperationOptions.ClaimClaimableBalance): Operation
        fun beginSponsoringFutureReserves(options: OperationOptions.BeginSponsoringFutureReserves): Operation
        fun endSponsoringFutureReserves(options: BaseOptions): Operation
        fun revokeAccountSponsorship(options: OperationOptions.RevokeAccountSponsorship): Operation
        fun revokeTrustlineSponsorship(options: OperationOptions.RevokeTrustlineSponsorship): Operation
        fun revokeOfferSponsorship(options: OperationOptions.RevokeOfferSponsorship): Operation
        fun revokeDataSponsorship(options: OperationOptions.RevokeDataSponsorship): Operation
        fun revokeClaimableBalanceSponsorship(options: OperationOptions.RevokeClaimableBalanceSponsorship): Operation
        fun revokeSignerSponsorship(options: OperationOptions.RevokeSignerSponsorship): Operation
        fun clawback(options: OperationOptions.Clawback): Operation
        fun clawbackClaimableBalance(options: OperationOptions.ClawbackClaimableBalance): Operation
        fun setTrustLineFlags(options: OperationOptions.SetTrustLineFlags): Operation

        //external fun <T> fromXDRObject(xdrOperation: Operation2): T
        fun read(io: ByteArray): Operation
        fun write(value: Operation, io: ByteArray)
        fun isValid(value: Operation): Boolean
        fun toXDR(value: Operation): ByteArray
        fun fromXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Operation
        fun fromXDR(input: String, format: String /* "hex" | "base64" */): Operation
        fun validateXDR(input: ByteArray, format: String /* "raw" */ = definedExternally): Boolean
        fun validateXDR(input: String, format: String /* "hex" | "base64" */): Boolean
    }
}

