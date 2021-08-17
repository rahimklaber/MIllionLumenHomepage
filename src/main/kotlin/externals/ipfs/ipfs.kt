@file:JsModule("ipfs-http-client")
@file:JsNonModule

package externals.ipfs

import org.khronos.webgl.Uint8Array
import kotlin.js.Promise


external interface Options {
    var host: String?
        get() = definedExternally
        set(value) = definedExternally
    var port: Number?
        get() = definedExternally
        set(value) = definedExternally
    var protocol: String?
        get() = definedExternally
        set(value) = definedExternally
    var headers: dynamic /* Headers? | Record<String, String>? */
        get() = definedExternally
        set(value) = definedExternally
    var timeout: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var apiPath: String?
        get() = definedExternally
        set(value) = definedExternally
    var url: dynamic /* URL? | String? | Multiaddr? */
        get() = definedExternally
        set(value) = definedExternally

    //    var ipld: IPLDOptionsPartial?
//        get() = definedExternally
//        set(value) = definedExternally
    var agent: dynamic /* HttpAgent? | HttpsAgent? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface AddOptions {
    var chunker: String?
        get() = definedExternally
        set(value) = definedExternally
    var cidVersion: Number? /* 0 | 1 */
        get() = definedExternally
        set(value) = definedExternally
    var hashAlg: String?
        get() = definedExternally
        set(value) = definedExternally
    var onlyHash: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var pin: Boolean?
        get() = definedExternally
        set(value) = definedExternally

    //    var progress: AddProgressFn?
//        get() = definedExternally
//        set(value) = definedExternally
    var rawLeaves: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var trickle: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var wrapWithDirectory: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var preload: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var blockWriteConcurrency: Number?
        get() = definedExternally
        set(value) = definedExternally
}

open external class CID(
    version: Number /* 0 | 1 */,
    code: Number,
    multihash: Any,
    bytes: Uint8Array
) {
    open var code: Number
    open var version: Number /* 0 | 1 */
    open var multihash: Any
    open var bytes: Uint8Array
    open var byteOffset: Number
    open var byteLength: Number
    open var asCID: Any
    open var _baseCache: Any
    open fun toV0(): CID
    open fun toV1(): CID
    open fun equals(other: Any): Any
    open fun toString(base: Any? = definedExternally): String
//    open fun toJSON(): `T$15`

//    companion object {
//        fun isCID(value: Any): Boolean
//        fun asCID(value: Any): CID?
//        fun create(version: Number /* 0 | 1 */, code: Number, digest: MultihashDigest): CID
//        fun createV0(digest: MultihashDigest): CID
//        fun <Code : Number> createV1(code: Code, digest: MultihashDigest): CID
//        fun decode(bytes: Uint8Array): CID
//        fun decodeFirst(bytes: Uint8Array): dynamic /* JsTuple<CID, Uint8Array> */
//        fun inspectBytes(initialBytes: Uint8Array): `T$14`
//        fun <Prefix : String> parse(source: String, base: Any? = definedExternally): CID
//    }
}

external interface AddResult {
    var cid: CID
    var size: Number
    var path: String
    var mode: Number?
        get() = definedExternally
        set(value) = definedExternally
//    var mtime: Mtime?
//        get() = definedExternally
//        set(value) = definedExternally
}

external interface API {
    var add: (entry: dynamic /* ToFile | ToDirectory | String | InstanceType<Any> | ArrayBufferView | ArrayBuffer | Blob | Iterable<Uint8Array> | AsyncIterable<Uint8Array> | ReadableStream<Uint8Array> */, options: AddOptions /* AddOptions & OptionExtension */) -> Promise<AddResult>
    var isOnline: () -> Boolean
}

external fun create(options: Options = definedExternally): API