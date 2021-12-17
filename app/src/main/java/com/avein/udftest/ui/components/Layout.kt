package com.avein.udftest.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.avein.udftest.ui.theme.UDFTestTheme

@Composable
fun ScreenSurface(content: @Composable () -> Unit) {
    UDFTestTheme {
        Surface(color = MaterialTheme.colors.background, content = content)
    }
}