package com.example.androidscreen.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidscreen.ui.theme.AppTheme


@Composable
fun InstallButton(
    text: String,
){
    Box{
        var installed by remember{ mutableStateOf(false) }
        var buttonState by remember{ mutableStateOf(false) }
        val scale by animateFloatAsState( if(buttonState) 0.85f else 1f)
        Button(
            onClick = {installed = !installed},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 20.dp,
                    bottom = 40.dp
                )
                .clip(RoundedCornerShape(1.dp))
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .pointerInput(buttonState) {
                    awaitPointerEventScope {
                        buttonState = if (buttonState) {
                            waitForUpOrCancellation()
                            false
                        } else {
                            awaitFirstDown(false)
                            true
                        }
                    }
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(!installed) AppTheme.BgColors.buttonBgColor else Color.Red,
                contentColor = Color.Black
            )
        ) {
            Text(
                if(!installed) text else "Un${text}",
                style = AppTheme.TextStyle.regular_20_bold_0_6,
                color = AppTheme.TextColor.buttonTextColor,
                modifier = Modifier
                    .padding(
                        top=10.dp,
                        bottom=10.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewInstallButton(){
    InstallButton(text = "Install")
}