//@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
//package tsstdlib
//
//import kotlin.js.*
//import org.khronos.webgl.*
//import org.w3c.dom.*
//import org.w3c.dom.events.*
//import org.w3c.dom.parsing.*
//import org.w3c.dom.svg.*
//import org.w3c.dom.url.*
//import org.w3c.fetch.*
//import org.w3c.files.*
//import org.w3c.notifications.*
//import org.w3c.performance.*
//import org.w3c.workers.*
//import org.w3c.xhr.*
//
//@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
//external interface AbortController {
//    var signal: AbortSignal
//    fun abort()
//
//    companion object {
//        var prototype: AbortController
//    }
//}
//
//external interface AbortSignalEventMap {
//    var abort: Event
//}
//
//@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
//external interface AbortSignal : EventTarget {
//    var aborted: Boolean
//    var onabort: ((self: AbortSignal, ev: Event) -> Any)?
//    fun <K : String> addEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: Boolean = definedExternally)
//    fun <K : String> addEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any)
//    fun <K : String> addEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: AddEventListenerOptions = definedExternally)
//    fun addEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
//    override fun addEventListener(type: String, listener: EventListener?, options: Boolean)
//    fun addEventListener(type: String, listener: EventListener)
//    override fun addEventListener(type: String, listener: EventListener?)
//    fun addEventListener(type: String, listener: EventListener, options: AddEventListenerOptions = definedExternally)
//    override fun addEventListener(type: String, listener: EventListener?, options: AddEventListenerOptions)
//    fun addEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
//    override fun addEventListener(type: String, listener: EventListenerObject?, options: Boolean)
//    fun addEventListener(type: String, listener: EventListenerObject)
//    override fun addEventListener(type: String, listener: EventListenerObject?)
//    fun addEventListener(type: String, listener: EventListenerObject, options: AddEventListenerOptions = definedExternally)
//    override fun addEventListener(type: String, listener: EventListenerObject?, options: AddEventListenerOptions)
//    fun <K : String> removeEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: Boolean = definedExternally)
//    fun <K : String> removeEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any)
//    fun <K : String> removeEventListener(type: K, listener: (self: AbortSignal, ev: Any) -> Any, options: EventListenerOptions = definedExternally)
//    fun removeEventListener(type: String, listener: EventListener, options: Boolean = definedExternally)
//    override fun removeEventListener(type: String, callback: EventListener?, options: Boolean)
//    fun removeEventListener(type: String, listener: EventListener)
//    override fun removeEventListener(type: String, callback: EventListener?)
//    fun removeEventListener(type: String, listener: EventListener, options: EventListenerOptions = definedExternally)
//    override fun removeEventListener(type: String, callback: EventListener?, options: EventListenerOptions)
//    fun removeEventListener(type: String, listener: EventListenerObject, options: Boolean = definedExternally)
//    override fun removeEventListener(type: String, callback: EventListenerObject?, options: Boolean)
//    fun removeEventListener(type: String, listener: EventListenerObject)
//    override fun removeEventListener(type: String, callback: EventListenerObject?)
//    fun removeEventListener(type: String, listener: EventListenerObject, options: EventListenerOptions = definedExternally)
//    override fun removeEventListener(type: String, callback: EventListenerObject?, options: EventListenerOptions)
//
//    companion object {
//        var prototype: AbortSignal
//    }
//}
//
//external interface EventListenerObject {
//    fun handleEvent(evt: Event)
//}