@file:JsModule("util")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package util

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
import tsstdlib.Map
import NodeJS.ErrnoException
import BigUint64Array
import BigInt64Array

external interface InspectOptions {
    var getters: dynamic /* "get" | "set" | Boolean? */
        get() = definedExternally
        set(value) = definedExternally
    var showHidden: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var depth: Number?
        get() = definedExternally
        set(value) = definedExternally
    var colors: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var customInspect: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showProxy: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var maxArrayLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var maxStringLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var breakLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var compact: dynamic /* Boolean? | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var sorted: dynamic /* Boolean? | ((a: String, b: String) -> Number)? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface InspectOptionsStylized : InspectOptions {
    fun stylize(text: String, styleType: String /* "special" | "number" | "bigint" | "boolean" | "undefined" | "null" | "string" | "symbol" | "date" | "regexp" | "module" */): String
}

external fun format(format: Any = definedExternally, vararg param: Any): String

external fun formatWithOptions(inspectOptions: InspectOptions, format: Any = definedExternally, vararg param: Any): String

external fun getSystemErrorMap(): Map<Number, dynamic /* JsTuple<String, String> */>

external fun log(string: String)

external fun inspect(obj: Any, showHidden: Boolean = definedExternally, depth: Number? = definedExternally, color: Boolean = definedExternally): String

external fun inspect(obj: Any): String

external fun inspect(obj: Any, showHidden: Boolean = definedExternally): String

external fun inspect(obj: Any, showHidden: Boolean = definedExternally, depth: Number? = definedExternally): String

external fun inspect(obj: Any, options: InspectOptions): String

external fun isArray(obj: Any): Boolean

external fun isRegExp(obj: Any): Boolean

external fun isDate(obj: Any): Boolean

external fun isError(obj: Any): Boolean

external fun inherits(constructor: Any, superConstructor: Any)

external interface DebugLogger {
    @nativeInvoke
    operator fun invoke(msg: String, vararg param: Any)
    var enabled: Boolean
}

external fun debuglog(section: String, callback: (fn: DebugLoggerFunction) -> Unit = definedExternally): DebugLogger

external fun isBoolean(obj: Any): Boolean

external fun isBuffer(obj: Any): Boolean

external fun isFunction(obj: Any): Boolean

external fun isNull(obj: Any): Boolean

external fun isNullOrUndefined(obj: Any): Boolean

external fun isNumber(obj: Any): Boolean

external fun isObject(obj: Any): Boolean

external fun isPrimitive(obj: Any): Boolean

external fun isString(obj: Any): Boolean

external fun isSymbol(obj: Any): Boolean

external fun isUndefined(obj: Any): Boolean

external fun <T : Function<*>> deprecate(fn: T, msg: String, code: String = definedExternally): T

external fun isDeepStrictEqual(val1: Any, val2: Any): Boolean

external fun callbackify(fn: () -> Promise<Unit>): (callback: (err: ErrnoException) -> Unit) -> Unit

external fun <TResult> callbackify(fn: () -> Promise<TResult>): (callback: (err: ErrnoException, result: TResult) -> Unit) -> Unit

external fun <T1> callbackify(fn: (arg1: T1) -> Promise<Unit>): (arg1: T1, callback: (err: ErrnoException) -> Unit) -> Unit

external fun <T1, TResult> callbackify(fn: (arg1: T1) -> Promise<TResult>): (arg1: T1, callback: (err: ErrnoException, result: TResult) -> Unit) -> Unit

external fun <T1, T2> callbackify(fn: (arg1: T1, arg2: T2) -> Promise<Unit>): (arg1: T1, arg2: T2, callback: (err: ErrnoException) -> Unit) -> Unit

external fun <T1, T2, TResult> callbackify(fn: (arg1: T1, arg2: T2) -> Promise<TResult>): (arg1: T1, arg2: T2, callback: (err: ErrnoException?, result: TResult) -> Unit) -> Unit

external fun <T1, T2, T3> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3) -> Promise<Unit>): (arg1: T1, arg2: T2, arg3: T3, callback: (err: ErrnoException) -> Unit) -> Unit

external fun <T1, T2, T3, TResult> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3) -> Promise<TResult>): (arg1: T1, arg2: T2, arg3: T3, callback: (err: ErrnoException?, result: TResult) -> Unit) -> Unit

external fun <T1, T2, T3, T4> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4) -> Promise<Unit>): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, callback: (err: ErrnoException) -> Unit) -> Unit

external fun <T1, T2, T3, T4, TResult> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4) -> Promise<TResult>): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, callback: (err: ErrnoException?, result: TResult) -> Unit) -> Unit

external fun <T1, T2, T3, T4, T5> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5) -> Promise<Unit>): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, callback: (err: ErrnoException) -> Unit) -> Unit

external fun <T1, T2, T3, T4, T5, TResult> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5) -> Promise<TResult>): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, callback: (err: ErrnoException?, result: TResult) -> Unit) -> Unit

external fun <T1, T2, T3, T4, T5, T6> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6) -> Promise<Unit>): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, callback: (err: ErrnoException) -> Unit) -> Unit

external fun <T1, T2, T3, T4, T5, T6, TResult> callbackify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6) -> Promise<TResult>): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, callback: (err: ErrnoException?, result: TResult) -> Unit) -> Unit

external fun <TCustom : Function<*>> promisify(fn: CustomPromisifySymbol<TCustom>): TCustom

external fun <TCustom : Function<*>> promisify(fn: CustomPromisifyLegacy<TCustom>): TCustom

external fun <TResult> promisify(fn: (callback: (err: Any, result: TResult) -> Unit) -> Unit): () -> Promise<TResult>

external fun promisify(fn: (callback: (err: Any) -> Unit) -> Unit): () -> Promise<Unit>

external fun <T1, TResult> promisify(fn: (arg1: T1, callback: (err: Any, result: TResult) -> Unit) -> Unit): (arg1: T1) -> Promise<TResult>

external fun <T1> promisify(fn: (arg1: T1, callback: (err: Any) -> Unit) -> Unit): (arg1: T1) -> Promise<Unit>

external fun <T1, T2, TResult> promisify(fn: (arg1: T1, arg2: T2, callback: (err: Any, result: TResult) -> Unit) -> Unit): (arg1: T1, arg2: T2) -> Promise<TResult>

external fun <T1, T2> promisify(fn: (arg1: T1, arg2: T2, callback: (err: Any) -> Unit) -> Unit): (arg1: T1, arg2: T2) -> Promise<Unit>

external fun <T1, T2, T3, TResult> promisify(fn: (arg1: T1, arg2: T2, arg3: T3, callback: (err: Any, result: TResult) -> Unit) -> Unit): (arg1: T1, arg2: T2, arg3: T3) -> Promise<TResult>

external fun <T1, T2, T3> promisify(fn: (arg1: T1, arg2: T2, arg3: T3, callback: (err: Any) -> Unit) -> Unit): (arg1: T1, arg2: T2, arg3: T3) -> Promise<Unit>

external fun <T1, T2, T3, T4, TResult> promisify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, callback: (err: Any, result: TResult) -> Unit) -> Unit): (arg1: T1, arg2: T2, arg3: T3, arg4: T4) -> Promise<TResult>

external fun <T1, T2, T3, T4> promisify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, callback: (err: Any) -> Unit) -> Unit): (arg1: T1, arg2: T2, arg3: T3, arg4: T4) -> Promise<Unit>

external fun <T1, T2, T3, T4, T5, TResult> promisify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, callback: (err: Any, result: TResult) -> Unit) -> Unit): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5) -> Promise<TResult>

external fun <T1, T2, T3, T4, T5> promisify(fn: (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, callback: (err: Any) -> Unit) -> Unit): (arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5) -> Promise<Unit>

external fun promisify(fn: Function<*>): Function<*>

external interface `T$67` {
    var fatal: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var ignoreBOM: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$68` {
    var stream: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class TextDecoder(encoding: String = definedExternally, options: `T$67` = definedExternally) {
    open var encoding: String
    open var fatal: Boolean
    open var ignoreBOM: Boolean
    open fun decode(input: Uint8Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(): String
    open fun decode(input: Uint8Array? = definedExternally): String
    open fun decode(input: Uint8ClampedArray? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Uint8ClampedArray? = definedExternally): String
    open fun decode(input: Uint16Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Uint16Array? = definedExternally): String
    open fun decode(input: Uint32Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Uint32Array? = definedExternally): String
    open fun decode(input: Int8Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Int8Array? = definedExternally): String
    open fun decode(input: Int16Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Int16Array? = definedExternally): String
    open fun decode(input: Int32Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Int32Array? = definedExternally): String
    open fun decode(input: BigUint64Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: BigUint64Array? = definedExternally): String
    open fun decode(input: BigInt64Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: BigInt64Array? = definedExternally): String
    open fun decode(input: Float32Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Float32Array? = definedExternally): String
    open fun decode(input: Float64Array? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: Float64Array? = definedExternally): String
    open fun decode(input: DataView? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: DataView? = definedExternally): String
    open fun decode(input: ArrayBuffer? = definedExternally, options: `T$68` = definedExternally): String
    open fun decode(input: ArrayBuffer? = definedExternally): String
}

external interface EncodeIntoResult {
    var read: Number
    var written: Number
}

external open class TextEncoder {
    open var encoding: String
    open fun encode(input: String = definedExternally): Uint8Array
    open fun encodeInto(src: String, dest: Uint8Array): EncodeIntoResult
}