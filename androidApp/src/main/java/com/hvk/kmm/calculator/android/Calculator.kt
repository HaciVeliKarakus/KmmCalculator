package com.hvk.kmm.calculator.android

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .then(modifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp, horizontal = 8.dp)
                    .border(width = 1.dp, color = MaterialTheme.colors.onSurface),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                maxLines = 2
            )
            Row1(buttonSpacing, onAction)
            Row2(buttonSpacing, onAction)
            Row3(buttonSpacing, onAction)
            Row4(buttonSpacing, onAction)
            Row5(buttonSpacing, onAction)
        }
    }
}

@Composable
private fun Row1(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "AC",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonClear)
                .aspectRatio(2f)
                .weight(2f),
            onclick = { onAction(CalculatorAction.Clear) }
        )
        CalculatorButton(
            symbol = "Del",
            modifier = Modifier
                .background(Color.LightGray)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Clear) }
        )
        CalculatorButton(
            symbol = "/",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonOperate)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Clear) }
        )
    }
}

@Composable
private fun Row2(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "7",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(7)) }
        )
        CalculatorButton(
            symbol = "8",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(8)) }
        )
        CalculatorButton(
            symbol = "9",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(9)) }
        )
        CalculatorButton(
            symbol = "*",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonOperate)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Mul)) }
        )
    }
}

@Composable
private fun Row3(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "4",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(4)) }
        )
        CalculatorButton(
            symbol = "5",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(5)) }
        )
        CalculatorButton(
            symbol = "6",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(6)) }
        )
        CalculatorButton(
            symbol = "-",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonOperate)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Sub)) }
        )
    }
}

@Composable
private fun Row4(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "1",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(1)) }
        )
        CalculatorButton(
            symbol = "2",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(2)) }
        )
        CalculatorButton(
            symbol = "3",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Number(3)) }
        )
        CalculatorButton(
            symbol = "+",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonOperate)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) }
        )
    }
}

@Composable
private fun Row5(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "0",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(2f)
                .weight(2f),
            onclick = { onAction(CalculatorAction.Number(0)) }
        )
        CalculatorButton(
            symbol = ".",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonNumber)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Decimal) }
        )
        CalculatorButton(
            symbol = "=",
            modifier = Modifier
                .background(MaterialTheme.colors.buttonCalculate)
                .aspectRatio(1f)
                .weight(1f),
            onclick = { onAction(CalculatorAction.Calculate) }
        )
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun CalculatorPreviewDarkTheme() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    MyApplicationTheme(darkTheme = true) {
        Calculator(state = state, onAction = viewModel::onAction)
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
fun CalculatorPreviewLightTheme() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    MyApplicationTheme(darkTheme = false) {
        Calculator(state = state, onAction = viewModel::onAction)
    }
}