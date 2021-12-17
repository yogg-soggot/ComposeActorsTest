package com.avein.udftest.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun <T>rememberState(state: T) = remember { mutableStateOf(state) }