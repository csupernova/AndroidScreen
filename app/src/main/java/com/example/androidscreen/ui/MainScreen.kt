package com.example.androidscreen.ui.theme

import android.provider.Settings.Global.getString
import androidx.activity.SystemBarStyle
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.time.format.TextStyle

@Preview
@Composable
fun TestPreview(){

    ApplySystemBarColors()

    Text(
        text = stringResource(id = R.string.dota_description),
        color = AppTheme.TextColors.message,
        modifier = Modifier.padding(top = 16.dp, bottom = 12.dp),
        style = AppTheme.TextStyle.regular
    )
}

@Composable
private fun ApplySystemBarColors(){
    val systemUiController = rememberSystemUiController()

    SideEffect{
        systemUiController.setSystemBarsColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}

