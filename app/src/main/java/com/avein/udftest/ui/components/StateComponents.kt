package com.avein.udftest.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.avein.udftest.framework.testImpl.UiState

@Composable
fun Counter(state: Int, changeState: (Int) -> Unit) {
    Row(
        Modifier.size(180.dp, 64.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Outlined.KeyboardArrowDown,
            contentDescription = "Add",
            Modifier
                .size(64.dp)
                .clickable { changeState(state - 1) })
        Text(state.toString(), style = MaterialTheme.typography.h4)
        Icon(
            Icons.Outlined.KeyboardArrowUp,
            contentDescription = "Subtract",
            Modifier
                .size(64.dp)
                .clickable { changeState(state + 1) }
        )
    }
}

@Composable
fun StatefulWidget(state: String, sendEvent: () -> Unit) {
    Button(onClick = sendEvent, Modifier.size(256.dp, 64.dp)) {
        Text(text = state)
    }
}

@Composable
fun Event(sendEvent: () -> Unit) {
    Icon(Icons.Default.ArrowForward, contentDescription = null,
        Modifier
            .size(64.dp)
            .clickable { sendEvent() })
}

@Composable
fun DataMapper(data: ExampleData) {
    @Composable fun Txt(text: String) = Text(text, style = MaterialTheme.typography.h4)
    Surface(
        Modifier.size(450.dp, 280.dp),
        elevation = 3.dp
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Txt(data.field1)
            Txt(data.field2)
            Txt("Number: ${data.field3}")
            Txt("isSomething: ${data.field4}")
        }
    }
}


data class ExampleData(
    val field1: String,
    val field2: String,
    val field3: Int,
    val field4: Boolean
)