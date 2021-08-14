@file:JsQualifier("fs.utimes")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package fs.utimes

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

external fun __promisify__(path: String, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: String, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: String, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: Buffer, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: Buffer, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: Buffer, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: URL, atime: String, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: URL, atime: Number, mtime: Any /* String | Number | Date */): Promise<Unit>

external fun __promisify__(path: URL, atime: Date, mtime: Any /* String | Number | Date */): Promise<Unit>