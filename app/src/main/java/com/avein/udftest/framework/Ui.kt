package com.avein.udftest.framework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class UiActor<State, Message>(
    initial: State
): AbstractActor<State, Message>() {
    private val _flow = MutableStateFlow(initial)
    val flow = _flow as StateFlow<State>

    override var state: State
        get() = _flow.value
        set(value) { _flow.value = value }

    fun event(msg: Message) = send(msg as Any)
}