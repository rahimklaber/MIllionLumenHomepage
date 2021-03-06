@file:JsQualifier("fs.readdir")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.readdir

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
import url.URL
import fs.promises.`T$39`
import fs.ObjectEncodingOptions
import fs.Dirent

external fun __promisify__(path: String, options: Any? /* `T$46`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ObjectEncodingOptions & `T$38` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun __promisify__(path: String): dynamic /* Promise | Promise */

external fun __promisify__(path: Buffer, options: Any? /* `T$46`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ObjectEncodingOptions & `T$38` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun __promisify__(path: Buffer): dynamic /* Promise | Promise */

external fun __promisify__(path: URL, options: Any? /* `T$46`? | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" | ObjectEncodingOptions & `T$38` | "ascii" | "utf8" | "utf-8" | "utf16le" | "ucs2" | "ucs-2" | "base64" | "base64url" | "latin1" | "binary" | "hex" */ = definedExternally): dynamic /* Promise | Promise */

external fun __promisify__(path: URL): dynamic /* Promise | Promise */

external fun __promisify__(path: String, options: String /* "buffer" */): Promise<Array<Buffer>>

external fun __promisify__(path: String, options: `T$39`): Promise<Array<Buffer>>

external fun __promisify__(path: Buffer, options: String /* "buffer" */): Promise<Array<Buffer>>

external fun __promisify__(path: Buffer, options: `T$39`): Promise<Array<Buffer>>

external fun __promisify__(path: URL, options: String /* "buffer" */): Promise<Array<Buffer>>

external fun __promisify__(path: URL, options: `T$39`): Promise<Array<Buffer>>

external fun __promisify__(path: String, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$40` */): Promise<Array<Dirent>>

external fun __promisify__(path: Buffer, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$40` */): Promise<Array<Dirent>>

external fun __promisify__(path: URL, options: ObjectEncodingOptions /* ObjectEncodingOptions & `T$40` */): Promise<Array<Dirent>>