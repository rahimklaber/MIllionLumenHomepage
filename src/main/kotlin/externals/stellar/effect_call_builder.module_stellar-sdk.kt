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
import ServerApi.CollectionPage

external open class EffectCallBuilder(serverUrl: URI) : CallBuilder<CollectionPage<dynamic /* Effects.AccountCreated | Effects.AccountCredited | Effects.AccountDebited | Effects.AccountThresholdsUpdated | Effects.AccountHomeDomainUpdated | Effects.AccountFlagsUpdated | Effects.DataCreated | Effects.DataRemoved | Effects.DataUpdated | Effects.SequenceBumped | Effects.SignerCreated | Effects.SignerRemoved | Effects.SignerUpdated | Effects.TrustlineCreated | Effects.TrustlineRemoved | Effects.TrustlineUpdated | Effects.TrustlineAuthorized | Effects.TrustlineDeauthorized | Effects.TrustlineAuthorizedToMaintainLiabilities | Effects.ClaimableBalanceCreated | Effects.ClaimableBalanceClaimed | Effects.ClaimableBalanceClaimantCreated | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$192` | Omit<AccountSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$194` | Omit<AccountSponsorshipEvents, String /* "sponsor" */> & `T$193` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$195` | Omit<TrustlineSponsorshipEvents, String /* "sponsor" */> & `T$196` | Omit<TrustlineSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$197` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$198` | Omit<DataSponsorshipEvents, String /* "sponsor" */> & `T$199` | Omit<DataSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$200` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$201` | Omit<ClaimableBalanceSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$203` | Omit<ClaimableBalanceSponsorshipEvents, String /* "sponsor" */> & `T$202` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "former_sponsor" */> & `T$204` | Omit<SignerSponsorshipEvents, String /* "sponsor" */> & `T$205` | Omit<SignerSponsorshipEvents, String /* "new_sponsor" | "sponsor" */> & `T$206` | Trade */>> {
    open fun forAccount(accountId: String): EffectCallBuilder /* this */
    open fun forLedger(sequence: Number): EffectCallBuilder /* this */
    open fun forLedger(sequence: String): EffectCallBuilder /* this */
    open fun forTransaction(transactionId: String): EffectCallBuilder /* this */
    open fun forOperation(operationId: String): EffectCallBuilder /* this */
}