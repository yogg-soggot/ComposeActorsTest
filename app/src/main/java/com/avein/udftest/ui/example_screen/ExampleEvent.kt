package com.avein.udftest.ui.example_screen

sealed interface ExampleEvent {
    sealed class Ui: ExampleEvent {
        object Stateless: Ui()
        class UserInput(text: String): Ui()
        class ValueChange(value: Int): Ui()
    }
}
