package com.hvk.kmm.calculator.android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDelete()
        }
    }

    private fun performDelete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Div -> number1 / number2
                CalculatorOperation.Mul -> number1 * number2
                CalculatorOperation.Sub -> number1 - number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        when {
            state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank() -> {
                state = state.copy(number1 = state.number1 + ".")
            }

            !state.number2.contains(".") && state.number2.isNotBlank() -> {
                state = state.copy(number1 = state.number2 + ".")
            }
        }
    }

    private fun enterNumber(number: Int) {
        when {
            state.operation == null && state.number1.length < MAX_NUM_LENGTH -> {
                state = state.copy(number1 = state.number1 + number)
            }

            state.number2.length < MAX_NUM_LENGTH -> {
                state = state.copy(number2 = state.number2 + number)
            }
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}