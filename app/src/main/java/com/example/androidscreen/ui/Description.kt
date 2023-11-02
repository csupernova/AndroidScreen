package com.example.androidscreen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
import com.example.androidscreen.ui.theme.AppTheme

@Composable
fun DescriptionDota(){
    Box(){
        Text(
            text = stringResource(id = R.string.dota_description),
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                    bottom=14.dp),
            style = AppTheme.TextStyle.regular_12,
            color = AppTheme.TextColor.descColor
        )
    }
}