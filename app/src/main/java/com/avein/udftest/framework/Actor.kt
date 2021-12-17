package com.avein.udftest.framework

import kotlinx.coroutines.*

interface Actor {
    val address: String
    fun send(message: Any)
}

abstract class AbstractActor<State, Message>(
): Actor {
    abstract var state: State
    override val address: String = javaClass.simpleName
    private val recipients: HashMap<String, Actor> = hashMapOf()
    fun addRecipient(recipient: Actor) {
        recipients[recipient.address] = recipient
    }

    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    abstract val reducer: State.(message: Message) -> State

    protected fun effect(produce: suspend () -> Unit): State {
        scope.launch { produce() }
        return state
    }

    @Suppress("unchecked_cast")
    override fun send(message: Any) {
        val msg = message as? Message
        if(msg != null) {
            state = reducer(state, message)
        } else {
            Configuration.log("Actor $address received incompatible message $message")
        }
    }

    protected fun forward(address: String, message: Any) {
        if(recipients.containsKey(address)) {
            recipients[address]!!.send(message)
        }
    }
    protected fun create(address: String): Actor {
        if(recipients.containsKey(address)) return recipients[address]!!
        val actor = Registry.create(address)
        recipients[address] = actor
        return actor
    }
}

object NullActor: Actor {
    override val address: String = "null"
    override fun send(message: Any) = Unit
}
object Registry {
    var create: (String) -> Actor = { NullActor }
}