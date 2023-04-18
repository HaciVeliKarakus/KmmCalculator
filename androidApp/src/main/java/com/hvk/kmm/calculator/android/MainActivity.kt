package com.hvk.kmm.calculator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }
        }
    }
}

