package externals.stellar_base

import Asset

//import Operation.Payment
//var amount: String
//var asset: Asset
//var destination: String
//fun paymentOpts(source : String?, ) : OperationOptions.Payment {
//
//}
fun createPaymentOpts(
    amount: String,
    asset: Asset,
    destination: String,
    source: String? = null
): OperationOptions.Payment {
    val opts = js("{}").unsafeCast<OperationOptions.Payment>()
    opts.source = source
    opts.amount = amount
    opts.asset = asset
    opts.destination = destination
    return opts
}

fun createManageDataOpts(
    name: String,
    value: String?,
    source: String? = null
): OperationOptions.ManageData {
    val opts = js("{}").unsafeCast<OperationOptions.ManageData>()
    opts.source = source
    opts.name = name
    opts.value = value

    return opts
}
