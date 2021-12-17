package com.avein.udftest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.avein.udftest.framework.testImpl.Msg
import com.avein.udftest.framework.testImpl.SimpleActor
import com.avein.udftest.framework.testImpl.UiState
import com.avein.udftest.ui.components.Counter
import com.avein.udftest.ui.components.ScreenSurface

class MainActivity : ComponentActivity() {
    private val initialUiState = UiState(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actor = SimpleActor(initialUiState)
        setContent {
            ScreenSurface {
                val state by actor.flow.collectAsState()
                Counter(state.count) { actor.event(Msg.Inc) }
            }
        }
    }
}