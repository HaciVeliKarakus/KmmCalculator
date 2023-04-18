package com.hvk.kmm.calculator.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Colors.buttonCalculate: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF30c973) else Color(0xFF59E797)
val Colors.buttonOperate: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFff9500) else Color(0xFFff9500)
val Colors.buttonClear: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFB64360) else Color(0xFFFF2B3B)
val Colors.buttonNumber: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF222427) else Color(0xFFe9f0f5)