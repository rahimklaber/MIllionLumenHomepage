@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

external interface PromiseFulfilledResult<T> {
    var status: String /* "fulfilled" */
    var value: T
}

external interface PromiseRejectedResult {
    var status: String /* "rejected" */
    var reason: Any
}