package com.avein.udftest.framework.testImpl

import com.avein.udftest.framework.UiActor

class SimpleActor(state: UiState) : UiActor<UiState, Msg>(state) {
    override val reducer = fun UiState.(message: Msg): UiState {
        return when (message) {
            Msg.Dec -> {
                copy(count = count - 1)
            }
            Msg.Inc -> {
                copy(count = count + 1)
            }
            Msg.New -> effect {
                create("SimpleActor").send(Msg.Inc)
            }
            is Msg.Input -> {
                copy(count = message.value)
            }
        }
    }
}

data class UiState(
    val count: Int
)

sealed class Msg {
    class Input(val value: Int): Msg()
    object Inc : Msg()
    object Dec : Msg()
    object New : Msg()
}