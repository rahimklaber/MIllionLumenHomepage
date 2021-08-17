@file:JsQualifier("Operation")
@file:JsNonModule
@file:JsModule("stellar-base")
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package Operation

import Asset
import Claimant
import OperationOptions.BaseOptions
import OperationOptions.`T$2`
import xdrHidden.Operation

external interface BaseOperation<T : String> {
    var type: T
    var source: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AccountMerge : BaseOperation<String /* "accountMerge" */> {
    var destination: String
}

external fun accountMerge(options: OperationOptions.AccountMerge): Operation

external interface AllowTrust : BaseOperation<String /* "allowTrust" */> {
    var trustor: String
    var assetCode: String
    var authorize: dynamic /* Boolean? | 0 | 1 | 2 */
        get() = definedExternally
        set(value) = definedExternally
}

external fun allowTrust(options: OperationOptions.AllowTrust): Operation

external interface ChangeTrust : BaseOperation<String /* "changeTrust" */> {
    var line: Asset
    var limit: String
}

external fun changeTrust(options: OperationOptions.ChangeTrust): Operation

external interface CreateAccount : BaseOperation<String /* "createAccount" */> {
    var destination: String
    var startingBalance: String
}

external fun createAccount(options: OperationOptions.CreateAccount): Operation

external interface CreatePassiveSellOffer : BaseOperation<String /* "createPassiveSellOffer" */> {
    var selling: Asset
    var buying: Asset
    var amount: String
    var price: String
}

external fun createPassiveSellOffer(options: OperationOptions.CreatePassiveSellOffer): Operation

external interface Inflation : BaseOperation<String /* "inflation" */>

external fun inflation(options: OperationOptions.Inflation): Operation

external interface ManageData : BaseOperation<String /* "manageData" */> {
    var name: String
    var value: ByteArray?
        get() = definedExternally
        set(value) = definedExternally
}

external fun manageData(options: OperationOptions.ManageData): Operation

external interface ManageSellOffer : BaseOperation<String /* "manageSellOffer" */> {
    var selling: Asset
    var buying: Asset
    var amount: String
    var price: String
    var offerId: String
}

external fun manageSellOffer(options: OperationOptions.ManageSellOffer): Operation

external interface ManageBuyOffer : BaseOperation<String /* "manageBuyOffer" */> {
    var selling: Asset
    var buying: Asset
    var buyAmount: String
    var price: String
    var offerId: String
}

external fun manageBuyOffer(options: OperationOptions.ManageBuyOffer): Operation

external interface PathPaymentStrictReceive :
    BaseOperation<String /* "pathPaymentStrictReceive" */> {
    var sendAsset: Asset
    var sendMax: String
    var destination: String
    var destAsset: Asset
    var destAmount: String
    var path: Array<Asset>
}

external fun pathPaymentStrictReceive(options: OperationOptions.PathPaymentStrictReceive): Operation

external interface PathPaymentStrictSend : BaseOperation<String /* "pathPaymentStrictSend" */> {
    var sendAsset: Asset
    var sendAmount: String
    var destination: String
    var destAsset: Asset
    var destMin: String
    var path: Array<Asset>
}

external fun pathPaymentStrictSend(options: OperationOptions.PathPaymentStrictSend): Operation

external interface Payment : BaseOperation<String /* "payment" */> {
    var amount: String
    var asset: Asset
    var destination: String
}

external fun payment(options: OperationOptions.Payment): Operation

external interface SetOptions<T> : BaseOperation<String /* "setOptions" */> {
    var inflationDest: String?
        get() = definedExternally
        set(value) = definedExternally
    var clearFlags: dynamic /* AuthFlag.required? | AuthFlag.immutable? | AuthFlag.revocable? | AuthFlag.clawbackEnabled? */
        get() = definedExternally
        set(value) = definedExternally
    var setFlags: dynamic /* AuthFlag.required? | AuthFlag.immutable? | AuthFlag.revocable? | AuthFlag.clawbackEnabled? */
        get() = definedExternally
        set(value) = definedExternally
    var masterWeight: Number?
        get() = definedExternally
        set(value) = definedExternally
    var lowThreshold: Number?
        get() = definedExternally
        set(value) = definedExternally
    var medThreshold: Number?
        get() = definedExternally
        set(value) = definedExternally
    var highThreshold: Number?
        get() = definedExternally
        set(value) = definedExternally
    var homeDomain: String?
        get() = definedExternally
        set(value) = definedExternally
    var signer: Any
}

external interface SetOptions__0 :
    SetOptions<dynamic /* SignerOptions.Ed25519PublicKey | SignerOptions.Sha256Hash | SignerOptions.PreAuthTx */>

external fun <T> setOptions(options: OperationOptions.SetOptions<T>): Operation

external interface BumpSequence : BaseOperation<String /* "bumpSequence" */> {
    var bumpTo: String
}

external fun bumpSequence(options: OperationOptions.BumpSequence): Operation

external interface CreateClaimableBalance : BaseOperation<String /* "createClaimableBalance" */> {
    var amount: String
    var asset: Asset
    var claimants: Array<Claimant>
}

external fun createClaimableBalance(options: OperationOptions.CreateClaimableBalance): Operation

external interface ClaimClaimableBalance : BaseOperation<String /* "claimClaimableBalance" */> {
    var balanceId: String
}

external fun claimClaimableBalance(options: OperationOptions.ClaimClaimableBalance): Operation

external interface BeginSponsoringFutureReserves :
    BaseOperation<String /* "beginSponsoringFutureReserves" */> {
    var sponsoredId: String
}

external fun beginSponsoringFutureReserves(options: OperationOptions.BeginSponsoringFutureReserves): Operation

external interface EndSponsoringFutureReserves :
    BaseOperation<String /* "endSponsoringFutureReserves" */>

external fun endSponsoringFutureReserves(options: BaseOptions): Operation

external interface RevokeAccountSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
}

external fun revokeAccountSponsorship(options: OperationOptions.RevokeAccountSponsorship): Operation

external interface RevokeTrustlineSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
    var asset: Asset
}

external fun revokeTrustlineSponsorship(options: OperationOptions.RevokeTrustlineSponsorship): Operation

external interface RevokeOfferSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var seller: String
    var offerId: String
}

external fun revokeOfferSponsorship(options: OperationOptions.RevokeOfferSponsorship): Operation

external interface RevokeDataSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
    var name: String
}

external fun revokeDataSponsorship(options: OperationOptions.RevokeDataSponsorship): Operation

external interface RevokeClaimableBalanceSponsorship :
    BaseOperation<String /* "revokeSponsorship" */> {
    var balanceId: String
}

external fun revokeClaimableBalanceSponsorship(options: OperationOptions.RevokeClaimableBalanceSponsorship): Operation

external interface RevokeSignerSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
    var signer: dynamic /* SignerKeyOptions.Ed25519PublicKey | SignerKeyOptions.Sha256Hash | SignerKeyOptions.PreAuthTx */
        get() = definedExternally
        set(value) = definedExternally
}

external fun revokeSignerSponsorship(options: OperationOptions.RevokeSignerSponsorship): Operation

external interface Clawback : BaseOperation<String /* "clawback" */> {
    var asset: Asset
    var amount: String
    var from: String
}

external fun clawback(options: OperationOptions.Clawback): Operation

external interface ClawbackClaimableBalance :
    BaseOperation<String /* "clawbackClaimableBalance" */> {
    var balanceId: String
}

external fun clawbackClaimableBalance(options: OperationOptions.ClawbackClaimableBalance): Operation

external interface SetTrustLineFlags : BaseOperation<String /* "setTrustLineFlags" */> {
    var trustor: String
    var asset: Asset
    var flags: `T$2`
}

external fun setTrustLineFlags(options: OperationOptions.SetTrustLineFlags): Operation

//external fun <T> fromXDRObject(xdrOperation: Operation2): T