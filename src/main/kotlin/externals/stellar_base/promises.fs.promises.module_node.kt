@file:JsModule("fs/promises")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.promises

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
import buffer.global.Buffer
import fs.ObjectEncodingOptions
import fs.StatOptions
import fs.WriteVResult
import fs.ReadVResult
import url.URL
import fs.RmDirOptions
import fs.RmOptions
import fs.MakeDirectoryOptions
import fs.Dirent
import fs.OpenDirOptions
import fs.Dir
import fs.WatchOptions
import AsyncIterable

external interface FileChangeInfo<T> {
    var eventType: String /* "rename" | "change" */
    var filename: T
}

external interface FlagAndOpenMode {
    var mode: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var flag: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface FileReadResult<T : ArrayBufferView> {
    var bytesRead: Number
    var buffer: T
}

external interface FileReadOptions<T : ArrayBufferView> {
    var buffer: T?
        get() = definedExternally
        set(value) = definedExternally
    var offset: Number?
        get() = definedExternally
        set(value) = definedExternally
    var length: Number?
        get() = definedExternally
        set(value) = definedExternally
    var position: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$28` {
    var encoding: Any?
        get() = definedExternally
        set(value) = definedExternally
    var flag: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$29` {
    var encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */
    var flag: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$30` {
    var flag: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$31` {
    var bigint: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$32` {
    var bigint: Boolean
}

external interface `T$33`<TBuffer> {
    var bytesWritten: Number
    var buffer: TBuffer
}

external interface `T$34` {
    var bytesWritten: Number
    var buffer: String
}

external interface FileHandle {
    var fd: Number
    fun appendFile(data: String, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>
    fun appendFile(data: String): Promise<Unit>
    fun appendFile(data: Uint8Array, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>
    fun appendFile(data: Uint8Array): Promise<Unit>
    fun chown(uid: Number, gid: Number): Promise<Unit>
    fun chmod(mode: Number): Promise<Unit>
    fun chmod(mode: String): Promise<Unit>
    fun datasync(): Promise<Unit>
    fun sync(): Promise<Unit>
    fun <T : ArrayBufferView> read(buffer: T, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Promise<FileReadResult<T>>
    fun <T : ArrayBufferView> read(buffer: T): Promise<FileReadResult<T>>
    fun <T : ArrayBufferView> read(buffer: T, offset: Number? = definedExternally): Promise<FileReadResult<T>>
    fun <T : ArrayBufferView> read(buffer: T, offset: Number? = definedExternally, length: Number? = definedExternally): Promise<FileReadResult<T>>
    fun <T : ArrayBufferView> read(options: FileReadOptions<T> = definedExternally): Promise<FileReadResult<T>>
    fun <T : ArrayBufferView> read(): Promise<FileReadResult<T>>
    fun readFile(options: `T$28`? = definedExternally): Promise<Buffer>
    fun readFile(): dynamic /* Promise */
    fun readFile(options: `T$29`): Promise<String>
    fun readFile(options: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): dynamic /* Promise */
    fun readFile(options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$30` */ = definedExternally): Promise<dynamic /* String | Buffer */>
    fun stat(opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */
    fun stat(): dynamic /* Promise | Promise */
    fun truncate(len: Number = definedExternally): Promise<Unit>
    fun utimes(atime: String, mtime: String): Promise<Unit>
    fun utimes(atime: String, mtime: Number): Promise<Unit>
    fun utimes(atime: String, mtime: Date): Promise<Unit>
    fun utimes(atime: Number, mtime: String): Promise<Unit>
    fun utimes(atime: Number, mtime: Number): Promise<Unit>
    fun utimes(atime: Number, mtime: Date): Promise<Unit>
    fun utimes(atime: Date, mtime: String): Promise<Unit>
    fun utimes(atime: Date, mtime: Number): Promise<Unit>
    fun utimes(atime: Date, mtime: Date): Promise<Unit>
    fun writeFile(data: String, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>
    fun writeFile(data: String): Promise<Unit>
    fun writeFile(data: Uint8Array, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>
    fun writeFile(data: Uint8Array): Promise<Unit>
    fun <TBuffer : Uint8Array> write(buffer: TBuffer, offset: Number? = definedExternally, length: Number? = definedExternally, position: Number? = definedExternally): Promise<`T$33`<TBuffer>>
    fun <TBuffer : Uint8Array> write(buffer: TBuffer): Promise<`T$33`<TBuffer>>
    fun <TBuffer : Uint8Array> write(buffer: TBuffer, offset: Number? = definedExternally): Promise<`T$33`<TBuffer>>
    fun <TBuffer : Uint8Array> write(buffer: TBuffer, offset: Number? = definedExternally, length: Number? = definedExternally): Promise<`T$33`<TBuffer>>
    fun write(data: String, position: Number? = definedExternally, encoding: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<`T$34`>
    fun write(data: String): Promise<`T$34`>
    fun write(data: String, position: Number? = definedExternally): Promise<`T$34`>
    fun writev(buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, position: Number = definedExternally): Promise<WriteVResult>
    fun readv(buffers: Array<Any /* Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */>, position: Number = definedExternally): Promise<ReadVResult>
    fun close(): Promise<Unit>
}

external fun access(path: String, mode: Number = definedExternally): Promise<Unit>

external fun access(path: String): Promise<Unit>

external fun access(path: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun access(path: Buffer): Promise<Unit>

external fun access(path: URL, mode: Number = definedExternally): Promise<Unit>

external fun access(path: URL): Promise<Unit>

external fun copyFile(src: String, dest: String, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: String, dest: String): Promise<Unit>

external fun copyFile(src: String, dest: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: String, dest: Buffer): Promise<Unit>

external fun copyFile(src: String, dest: URL, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: String, dest: URL): Promise<Unit>

external fun copyFile(src: Buffer, dest: String, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: Buffer, dest: String): Promise<Unit>

external fun copyFile(src: Buffer, dest: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: Buffer, dest: Buffer): Promise<Unit>

external fun copyFile(src: Buffer, dest: URL, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: Buffer, dest: URL): Promise<Unit>

external fun copyFile(src: URL, dest: String, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: URL, dest: String): Promise<Unit>

external fun copyFile(src: URL, dest: Buffer, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: URL, dest: Buffer): Promise<Unit>

external fun copyFile(src: URL, dest: URL, mode: Number = definedExternally): Promise<Unit>

external fun copyFile(src: URL, dest: URL): Promise<Unit>

external fun open(path: String, flags: String, mode: Number = definedExternally): Promise<FileHandle>

external fun open(path: String, flags: String): Promise<FileHandle>

external fun open(path: String, flags: String, mode: String = definedExternally): Promise<FileHandle>

external fun open(path: String, flags: Number, mode: Number = definedExternally): Promise<FileHandle>

external fun open(path: String, flags: Number): Promise<FileHandle>

external fun open(path: String, flags: Number, mode: String = definedExternally): Promise<FileHandle>

external fun open(path: Buffer, flags: String, mode: Number = definedExternally): Promise<FileHandle>

external fun open(path: Buffer, flags: String): Promise<FileHandle>

external fun open(path: Buffer, flags: String, mode: String = definedExternally): Promise<FileHandle>

external fun open(path: Buffer, flags: Number, mode: Number = definedExternally): Promise<FileHandle>

external fun open(path: Buffer, flags: Number): Promise<FileHandle>

external fun open(path: Buffer, flags: Number, mode: String = definedExternally): Promise<FileHandle>

external fun open(path: URL, flags: String, mode: Number = definedExternally): Promise<FileHandle>

external fun open(path: URL, flags: String): Promise<FileHandle>

external fun open(path: URL, flags: String, mode: String = definedExternally): Promise<FileHandle>

external fun open(path: URL, flags: Number, mode: Number = definedExternally): Promise<FileHandle>

external fun open(path: URL, flags: Number): Promise<FileHandle>

external fun open(path: URL, flags: Number, mode: String = definedExternally): Promise<FileHandle>

external fun rename(oldPath: String, newPath: String): Promise<Unit>

external fun rename(oldPath: String, newPath: Buffer): Promise<Unit>

external fun rename(oldPath: String, newPath: URL): Promise<Unit>

external fun rename(oldPath: Buffer, newPath: String): Promise<Unit>

external fun rename(oldPath: Buffer, newPath: Buffer): Promise<Unit>

external fun rename(oldPath: Buffer, newPath: URL): Promise<Unit>

external fun rename(oldPath: URL, newPath: String): Promise<Unit>

external fun rename(oldPath: URL, newPath: Buffer): Promise<Unit>

external fun rename(oldPath: URL, newPath: URL): Promise<Unit>

external fun truncate(path: String, len: Number = definedExternally): Promise<Unit>

external fun truncate(path: String): Promise<Unit>

external fun truncate(path: Buffer, len: Number = definedExternally): Promise<Unit>

external fun truncate(path: Buffer): Promise<Unit>

external fun truncate(path: URL, len: Number = definedExternally): Promise<Unit>

external fun truncate(path: URL): Promise<Unit>

external fun rmdir(path: String, options: RmDirOptions = definedExternally): Promise<Unit>

external fun rmdir(path: String): Promise<Unit>

external fun rmdir(path: Buffer, options: RmDirOptions = definedExternally): Promise<Unit>

external fun rmdir(path: Buffer): Promise<Unit>

external fun rmdir(path: URL, options: RmDirOptions = definedExternally): Promise<Unit>

external fun rmdir(path: URL): Promise<Unit>

external fun rm(path: String, options: RmOptions = definedExternally): Promise<Unit>

external fun rm(path: String): Promise<Unit>

external fun rm(path: Buffer, options: RmOptions = definedExternally): Promise<Unit>

external fun rm(path: Buffer): Promise<Unit>

external fun rm(path: URL, options: RmOptions = definedExternally): Promise<Unit>

external fun rm(path: URL): Promise<Unit>

external interface `T$35` {
    var recursive: Boolean
}

external fun mkdir(path: String, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$35` | MakeDirectoryOptions & `T$36` */): dynamic /* Promise | Promise */

external fun mkdir(path: Buffer, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$35` | MakeDirectoryOptions & `T$36` */): dynamic /* Promise | Promise */

external fun mkdir(path: URL, options: MakeDirectoryOptions /* MakeDirectoryOptions & `T$35` | MakeDirectoryOptions & `T$36` */): dynamic /* Promise | Promise */

external interface `T$36` {
    var recursive: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun mkdir(path: String, options: Number? = definedExternally): dynamic /* Promise | Promise */

external fun mkdir(path: String): dynamic /* Promise */

external fun mkdir(path: String, options: String? = definedExternally): dynamic /* Promise | Promise */

external fun mkdir(path: Buffer, options: Number? = definedExternally): dynamic /* Promise | Promise */

external fun mkdir(path: Buffer): dynamic /* Promise */

external fun mkdir(path: Buffer, options: String? = definedExternally): dynamic /* Promise | Promise */

external fun mkdir(path: URL, options: Number? = definedExternally): dynamic /* Promise | Promise */

external fun mkdir(path: URL): dynamic /* Promise */

external fun mkdir(path: URL, options: String? = definedExternally): dynamic /* Promise | Promise */

external fun mkdir(path: String, options: MakeDirectoryOptions? = definedExternally): Promise<String?>

external fun mkdir(path: Buffer, options: MakeDirectoryOptions? = definedExternally): Promise<String?>

external fun mkdir(path: URL, options: MakeDirectoryOptions? = definedExternally): Promise<String?>

external interface `T$37` {
    var withFileTypes: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun readdir(path: String, options: Any? /* ObjectEncodingOptions & `T$37` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun readdir(path: String): dynamic /* Promise | Promise */

external fun readdir(path: Buffer, options: Any? /* ObjectEncodingOptions & `T$37` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun readdir(path: Buffer): dynamic /* Promise | Promise */

external fun readdir(path: URL, options: Any? /* ObjectEncodingOptions & `T$37` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun readdir(path: URL): dynamic /* Promise | Promise */

external interface `T$38` {
    var encoding: String /* "buffer" */
    var withFileTypes: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun readdir(path: String, options: `T$38`): Promise<Array<Buffer>>

external fun readdir(path: String, options: String /* "buffer" */): Promise<Array<Buffer>>

external fun readdir(path: Buffer, options: `T$38`): Promise<Array<Buffer>>

external fun readdir(path: Buffer, options: String /* "buffer" */): Promise<Array<Buffer>>

external fun readdir(path: URL, options: `T$38`): Promise<Array<Buffer>>

external fun readdir(path: URL, options: String /* "buffer" */): Promise<Array<Buffer>>

external interface `T$39` {
    var withFileTypes: Boolean
}

external fun readdir(path: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$39` */): Promise<Array<Dirent>>

external fun readdir(path: Buffer, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$39` */): Promise<Array<Dirent>>

external fun readdir(path: URL, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$39` */): Promise<Array<Dirent>>

external fun readlink(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<String>

external fun readlink(path: String): dynamic /* Promise */

external fun readlink(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<String>

external fun readlink(path: Buffer): dynamic /* Promise */

external fun readlink(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<String>

external fun readlink(path: URL): dynamic /* Promise */

external fun readlink(path: String, options: String /* "buffer" */): Promise<Buffer>

external fun readlink(path: String, options: `T$41`): Promise<Buffer>

external fun readlink(path: Buffer, options: String /* "buffer" */): Promise<Buffer>

external fun readlink(path: Buffer, options: `T$41`): Promise<Buffer>

external fun readlink(path: URL, options: String /* "buffer" */): Promise<Buffer>

external fun readlink(path: URL, options: `T$41`): Promise<Buffer>

external fun readlink(path: String, options: ObjectEncodingOptions? = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readlink(path: String, options: String? = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readlink(path: Buffer, options: ObjectEncodingOptions? = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readlink(path: Buffer, options: String? = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readlink(path: URL, options: ObjectEncodingOptions? = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readlink(path: URL, options: String? = definedExternally): Promise<dynamic /* String | Buffer */>

external fun symlink(target: String, path: String, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: String, path: String): Promise<Unit>

external fun symlink(target: String, path: Buffer, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: String, path: Buffer): Promise<Unit>

external fun symlink(target: String, path: URL, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: String, path: URL): Promise<Unit>

external fun symlink(target: Buffer, path: String, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: Buffer, path: String): Promise<Unit>

external fun symlink(target: Buffer, path: Buffer, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: Buffer, path: Buffer): Promise<Unit>

external fun symlink(target: Buffer, path: URL, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: Buffer, path: URL): Promise<Unit>

external fun symlink(target: URL, path: String, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: URL, path: String): Promise<Unit>

external fun symlink(target: URL, path: Buffer, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: URL, path: Buffer): Promise<Unit>

external fun symlink(target: URL, path: URL, type: String? = definedExternally): Promise<Unit>

external fun symlink(target: URL, path: URL): Promise<Unit>

external fun lstat(path: String, opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */

external fun lstat(path: String): dynamic /* Promise | Promise */

external fun lstat(path: Buffer, opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */

external fun lstat(path: Buffer): dynamic /* Promise | Promise */

external fun lstat(path: URL, opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */

external fun lstat(path: URL): dynamic /* Promise | Promise */

external fun stat(path: String, opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */

external fun stat(path: String): dynamic /* Promise | Promise */

external fun stat(path: Buffer, opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */

external fun stat(path: Buffer): dynamic /* Promise | Promise */

external fun stat(path: URL, opts: StatOptions /* StatOptions & `T$31` | StatOptions & `T$32` */ = definedExternally): dynamic /* Promise */

external fun stat(path: URL): dynamic /* Promise | Promise */

external fun link(existingPath: String, newPath: String): Promise<Unit>

external fun link(existingPath: String, newPath: Buffer): Promise<Unit>

external fun link(existingPath: String, newPath: URL): Promise<Unit>

external fun link(existingPath: Buffer, newPath: String): Promise<Unit>

external fun link(existingPath: Buffer, newPath: Buffer): Promise<Unit>

external fun link(existingPath: Buffer, newPath: URL): Promise<Unit>

external fun link(existingPath: URL, newPath: String): Promise<Unit>

external fun link(existingPath: URL, newPath: Buffer): Promise<Unit>

external fun link(existingPath: URL, newPath: URL): Promise<Unit>

external fun unlink(path: String): Promise<Unit>

external fun unlink(path: Buffer): Promise<Unit>

external fun unlink(path: URL): Promise<Unit>

external fun chmod(path: String, mode: Number): Promise<Unit>

external fun chmod(path: String, mode: String): Promise<Unit>

external fun chmod(path: Buffer, mode: Number): Promise<Unit>

external fun chmod(path: Buffer, mode: String): Promise<Unit>

external fun chmod(path: URL, mode: Number): Promise<Unit>

external fun chmod(path: URL, mode: String): Promise<Unit>

external fun lchmod(path: String, mode: Number): Promise<Unit>

external fun lchmod(path: String, mode: String): Promise<Unit>

external fun lchmod(path: Buffer, mode: Number): Promise<Unit>

external fun lchmod(path: Buffer, mode: String): Promise<Unit>

external fun lchmod(path: URL, mode: Number): Promise<Unit>

external fun lchmod(path: URL, mode: String): Promise<Unit>

external fun lchown(path: String, uid: Number, gid: Number): Promise<Unit>

external fun lchown(path: Buffer, uid: Number, gid: Number): Promise<Unit>

external fun lchown(path: URL, uid: Number, gid: Number): Promise<Unit>

external fun lutimes(path: String, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: String, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: String, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: Buffer, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: URL, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: URL, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun lutimes(path: URL, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun chown(path: String, uid: Number, gid: Number): Promise<Unit>

external fun chown(path: Buffer, uid: Number, gid: Number): Promise<Unit>

external fun chown(path: URL, uid: Number, gid: Number): Promise<Unit>

external fun utimes(path: String, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: String, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: String, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: Buffer, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: URL, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: URL, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun utimes(path: URL, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun realpath(path: String, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun realpath(path: String): dynamic /* Promise | Promise */

external fun realpath(path: Buffer, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun realpath(path: Buffer): dynamic /* Promise | Promise */

external fun realpath(path: URL, options: Any? /* ObjectEncodingOptions? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun realpath(path: URL): dynamic /* Promise | Promise */

external fun realpath(path: String, options: String /* "buffer" */): Promise<Buffer>

external fun realpath(path: String, options: `T$41`): Promise<Buffer>

external fun realpath(path: Buffer, options: String /* "buffer" */): Promise<Buffer>

external fun realpath(path: Buffer, options: `T$41`): Promise<Buffer>

external fun realpath(path: URL, options: String /* "buffer" */): Promise<Buffer>

external fun realpath(path: URL, options: `T$41`): Promise<Buffer>

external fun mkdtemp(prefix: String, options: ObjectEncodingOptions? = definedExternally): dynamic /* Promise | Promise */

external fun mkdtemp(prefix: String): dynamic /* Promise */

external fun mkdtemp(prefix: String, options: String /* "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | "buffer" | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise */

external fun mkdtemp(prefix: String, options: `T$41`): Promise<Buffer>

external interface `T$40` {
    var mode: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var flag: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external fun writeFile(file: String, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */, options: Any? /* ObjectEncodingOptions & `T$40` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun writeFile(file: String, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */): Promise<Unit>

external fun writeFile(file: Buffer, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */, options: Any? /* ObjectEncodingOptions & `T$40` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun writeFile(file: Buffer, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */): Promise<Unit>

external fun writeFile(file: URL, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */, options: Any? /* ObjectEncodingOptions & `T$40` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun writeFile(file: URL, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */): Promise<Unit>

external fun writeFile(file: FileHandle, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */, options: Any? /* ObjectEncodingOptions & `T$40` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun writeFile(file: FileHandle, data: Any /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView | Iterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | AsyncIterable<dynamic /* String | Uint8Array | Uint8ClampedArray | Uint16Array | Uint32Array | Int8Array | Int16Array | Int32Array | BigUint64Array | BigInt64Array | Float32Array | Float64Array | DataView */> | Stream */): Promise<Unit>

external fun appendFile(path: String, data: String, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: String, data: String): Promise<Unit>

external fun appendFile(path: String, data: Uint8Array, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: String, data: Uint8Array): Promise<Unit>

external fun appendFile(path: Buffer, data: String, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: Buffer, data: String): Promise<Unit>

external fun appendFile(path: Buffer, data: Uint8Array, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: Buffer, data: Uint8Array): Promise<Unit>

external fun appendFile(path: URL, data: String, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: URL, data: String): Promise<Unit>

external fun appendFile(path: URL, data: Uint8Array, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: URL, data: Uint8Array): Promise<Unit>

external fun appendFile(path: FileHandle, data: String, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: FileHandle, data: String): Promise<Unit>

external fun appendFile(path: FileHandle, data: Uint8Array, options: Any? /* ObjectEncodingOptions & FlagAndOpenMode | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<Unit>

external fun appendFile(path: FileHandle, data: Uint8Array): Promise<Unit>

external fun readFile(path: String, options: `T$28` /* `T$28` & Abortable */ = definedExternally): Promise<Buffer>

external fun readFile(path: String): dynamic /* Promise | Promise */

external fun readFile(path: Buffer, options: `T$28` /* `T$28` & Abortable */ = definedExternally): Promise<Buffer>

external fun readFile(path: Buffer): dynamic /* Promise | Promise */

external fun readFile(path: URL, options: `T$28` /* `T$28` & Abortable */ = definedExternally): Promise<Buffer>

external fun readFile(path: URL): dynamic /* Promise | Promise */

external fun readFile(path: FileHandle, options: `T$28` /* `T$28` & Abortable */ = definedExternally): Promise<Buffer>

external fun readFile(path: FileHandle): dynamic /* Promise | Promise */

external fun readFile(path: String, options: Any /* `T$29` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun readFile(path: Buffer, options: Any /* `T$29` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun readFile(path: URL, options: Any /* `T$29` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun readFile(path: FileHandle, options: Any /* `T$29` & Abortable | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */): Promise<String>

external fun readFile(path: String, options: Any? /* ObjectEncodingOptions & Abortable & `T$30` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readFile(path: Buffer, options: Any? /* ObjectEncodingOptions & Abortable & `T$30` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readFile(path: URL, options: Any? /* ObjectEncodingOptions & Abortable & `T$30` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun readFile(path: FileHandle, options: Any? /* ObjectEncodingOptions & Abortable & `T$30` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): Promise<dynamic /* String | Buffer */>

external fun opendir(path: String, options: OpenDirOptions = definedExternally): Promise<Dir>

external interface `T$41` {
    var encoding: String /* "buffer" */
}

external fun watch(filename: String, options: WatchOptions /* WatchOptions & `T$41` */): dynamic /* AsyncIterable */

external fun watch(filename: String, options: String /* "buffer" */): dynamic /* AsyncIterable */

external fun watch(filename: Buffer, options: WatchOptions /* WatchOptions & `T$41` */): dynamic /* AsyncIterable */

external fun watch(filename: Buffer, options: String /* "buffer" */): dynamic /* AsyncIterable */

external fun watch(filename: URL, options: WatchOptions /* WatchOptions & `T$41` */): dynamic /* AsyncIterable */

external fun watch(filename: URL, options: String /* "buffer" */): dynamic /* AsyncIterable */

external fun watch(filename: String, options: Any /* WatchOptions | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): AsyncIterable<FileChangeInfo<String>>

external fun watch(filename: String): AsyncIterable<FileChangeInfo<String>>

external fun watch(filename: Buffer, options: Any /* WatchOptions | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): AsyncIterable<FileChangeInfo<String>>

external fun watch(filename: Buffer): AsyncIterable<FileChangeInfo<String>>

external fun watch(filename: URL, options: Any /* WatchOptions | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): AsyncIterable<FileChangeInfo<String>>

external fun watch(filename: URL): AsyncIterable<FileChangeInfo<String>>