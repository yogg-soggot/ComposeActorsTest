package com.avein.udftest.framework.testImpl

import com.avein.udftest.framework.Actor
import com.avein.udftest.framework.NullActor
import com.avein.udftest.framework.Registry

object ActorFactory: (String) -> Actor {
    init {
        Registry.create = ::invoke
    }
    override fun invoke(address: String): Actor {
        return when(address) {
            Addresses.SomeActor -> NullActor
            else -> NullActor
        }
    }
}

object Addresses {
    const val SomeActor = "SomeActor"
}