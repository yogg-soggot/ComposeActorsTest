package com.avein.udftest.ui.example_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.avein.udftest.ui.components.Counter
import com.avein.udftest.ui.components.DataMapper
import com.avein.udftest.ui.components.ExampleData
import com.avein.udftest.ui.components.StatefulWidget
import com.avein.udftest.ui.example_screen.ExampleEvent.Ui

@Composable
fun ExampleScreen(data: ScreenData, sendEvent: (Ui) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Counter(state = data.counter, changeState = { sendEvent(Ui.ValueChange(it)) })
        DataMapper(data.data)
        StatefulWidget(state = data.widgetState) { sendEvent(Ui.Stateless) }
    }
}

data class ScreenData(
    val counter: Int,
    val widgetState: String,
    val data: ExampleData,
)