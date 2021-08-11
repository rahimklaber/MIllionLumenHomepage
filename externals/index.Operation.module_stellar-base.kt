@file:JsQualifier("Operation")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package Operation

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
import xdrHidden.Operation2
import Asset
import buffer.global.Buffer
import Claimant
import OperationOptions.BaseOptions
import OperationOptions.`T$84`

external interface BaseOperation<T : String> {
    var type: T
    var source: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AccountMerge : BaseOperation<String /* "accountMerge" */> {
    var destination: String
}

external fun accountMerge(options: OperationOptions.AccountMerge): Operation2<AccountMerge>

external interface AllowTrust : BaseOperation<String /* "allowTrust" */> {
    var trustor: String
    var assetCode: String
    var authorize: dynamic /* Boolean? | 0 | 1 | 2 */
        get() = definedExternally
        set(value) = definedExternally
}

external fun allowTrust(options: OperationOptions.AllowTrust): Operation2<AllowTrust>

external interface ChangeTrust : BaseOperation<String /* "changeTrust" */> {
    var line: Asset
    var limit: String
}

external fun changeTrust(options: OperationOptions.ChangeTrust): Operation2<ChangeTrust>

external interface CreateAccount : BaseOperation<String /* "createAccount" */> {
    var destination: String
    var startingBalance: String
}

external fun createAccount(options: OperationOptions.CreateAccount): Operation2<CreateAccount>

external interface CreatePassiveSellOffer : BaseOperation<String /* "createPassiveSellOffer" */> {
    var selling: Asset
    var buying: Asset
    var amount: String
    var price: String
}

external fun createPassiveSellOffer(options: OperationOptions.CreatePassiveSellOffer): Operation2<CreatePassiveSellOffer>

external interface Inflation : BaseOperation<String /* "inflation" */>

external fun inflation(options: OperationOptions.Inflation): Operation2<Inflation>

external interface ManageData : BaseOperation<String /* "manageData" */> {
    var name: String
    var value: Buffer?
        get() = definedExternally
        set(value) = definedExternally
}

external fun manageData(options: OperationOptions.ManageData): Operation2<ManageData>

external interface ManageSellOffer : BaseOperation<String /* "manageSellOffer" */> {
    var selling: Asset
    var buying: Asset
    var amount: String
    var price: String
    var offerId: String
}

external fun manageSellOffer(options: OperationOptions.ManageSellOffer): Operation2<ManageSellOffer>

external interface ManageBuyOffer : BaseOperation<String /* "manageBuyOffer" */> {
    var selling: Asset
    var buying: Asset
    var buyAmount: String
    var price: String
    var offerId: String
}

external fun manageBuyOffer(options: OperationOptions.ManageBuyOffer): Operation2<ManageBuyOffer>

external interface PathPaymentStrictReceive : BaseOperation<String /* "pathPaymentStrictReceive" */> {
    var sendAsset: Asset
    var sendMax: String
    var destination: String
    var destAsset: Asset
    var destAmount: String
    var path: Array<Asset>
}

external fun pathPaymentStrictReceive(options: OperationOptions.PathPaymentStrictReceive): Operation2<PathPaymentStrictReceive>

external interface PathPaymentStrictSend : BaseOperation<String /* "pathPaymentStrictSend" */> {
    var sendAsset: Asset
    var sendAmount: String
    var destination: String
    var destAsset: Asset
    var destMin: String
    var path: Array<Asset>
}

external fun pathPaymentStrictSend(options: OperationOptions.PathPaymentStrictSend): Operation2<PathPaymentStrictSend>

external interface Payment : BaseOperation<String /* "payment" */> {
    var amount: String
    var asset: Asset
    var destination: String
}

external fun payment(options: OperationOptions.Payment): Operation2<Payment>

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

external interface SetOptions__0 : SetOptions<dynamic /* SignerOptions.Ed25519PublicKey | SignerOptions.Sha256Hash | SignerOptions.PreAuthTx */>

external fun <T> setOptions(options: OperationOptions.SetOptions<T>): Operation2<SetOptions<T>>

external interface BumpSequence : BaseOperation<String /* "bumpSequence" */> {
    var bumpTo: String
}

external fun bumpSequence(options: OperationOptions.BumpSequence): Operation2<BumpSequence>

external interface CreateClaimableBalance : BaseOperation<String /* "createClaimableBalance" */> {
    var amount: String
    var asset: Asset
    var claimants: Array<Claimant>
}

external fun createClaimableBalance(options: OperationOptions.CreateClaimableBalance): Operation2<CreateClaimableBalance>

external interface ClaimClaimableBalance : BaseOperation<String /* "claimClaimableBalance" */> {
    var balanceId: String
}

external fun claimClaimableBalance(options: OperationOptions.ClaimClaimableBalance): Operation2<ClaimClaimableBalance>

external interface BeginSponsoringFutureReserves : BaseOperation<String /* "beginSponsoringFutureReserves" */> {
    var sponsoredId: String
}

external fun beginSponsoringFutureReserves(options: OperationOptions.BeginSponsoringFutureReserves): Operation2<BeginSponsoringFutureReserves>

external interface EndSponsoringFutureReserves : BaseOperation<String /* "endSponsoringFutureReserves" */>

external fun endSponsoringFutureReserves(options: BaseOptions): Operation2<EndSponsoringFutureReserves>

external interface RevokeAccountSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
}

external fun revokeAccountSponsorship(options: OperationOptions.RevokeAccountSponsorship): Operation2<RevokeAccountSponsorship>

external interface RevokeTrustlineSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
    var asset: Asset
}

external fun revokeTrustlineSponsorship(options: OperationOptions.RevokeTrustlineSponsorship): Operation2<RevokeTrustlineSponsorship>

external interface RevokeOfferSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var seller: String
    var offerId: String
}

external fun revokeOfferSponsorship(options: OperationOptions.RevokeOfferSponsorship): Operation2<RevokeOfferSponsorship>

external interface RevokeDataSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
    var name: String
}

external fun revokeDataSponsorship(options: OperationOptions.RevokeDataSponsorship): Operation2<RevokeDataSponsorship>

external interface RevokeClaimableBalanceSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var balanceId: String
}

external fun revokeClaimableBalanceSponsorship(options: OperationOptions.RevokeClaimableBalanceSponsorship): Operation2<RevokeClaimableBalanceSponsorship>

external interface RevokeSignerSponsorship : BaseOperation<String /* "revokeSponsorship" */> {
    var account: String
    var signer: dynamic /* SignerKeyOptions.Ed25519PublicKey | SignerKeyOptions.Sha256Hash | SignerKeyOptions.PreAuthTx */
        get() = definedExternally
        set(value) = definedExternally
}

external fun revokeSignerSponsorship(options: OperationOptions.RevokeSignerSponsorship): Operation2<RevokeSignerSponsorship>

external interface Clawback : BaseOperation<String /* "clawback" */> {
    var asset: Asset
    var amount: String
    var from: String
}

external fun clawback(options: OperationOptions.Clawback): Operation2<Clawback>

external interface ClawbackClaimableBalance : BaseOperation<String /* "clawbackClaimableBalance" */> {
    var balanceId: String
}

external fun clawbackClaimableBalance(options: OperationOptions.ClawbackClaimableBalance): Operation2<ClawbackClaimableBalance>

external interface SetTrustLineFlags : BaseOperation<String /* "setTrustLineFlags" */> {
    var trustor: String
    var asset: Asset
    var flags: `T$84`
}

external fun setTrustLineFlags(options: OperationOptions.SetTrustLineFlags): Operation2<SetTrustLineFlags>

external fun <T> fromXDRObject(xdrOperation: Operation2<T>): T