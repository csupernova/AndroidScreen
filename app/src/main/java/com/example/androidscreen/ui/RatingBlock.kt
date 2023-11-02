package com.example.androidscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
import com.example.androidscreen.ui.theme.AppTheme

@Composable
fun RatingBlock(
    rating: Float,
    reviewCount:String,
    modifier: Modifier
){
    Row(modifier = modifier){
        Text(
            text = "$rating",
            style = AppTheme.TextStyle.bold_48,
            color = Color.White
        )
        Column{
            Image(
                painter = painterResource(id = R.drawable.fourhalfstars),
                contentDescription = null,
                modifier = Modifier.padding(
                    start=15.dp, top = 17.dp)
            )
            Text(
                text="$reviewCount Reviews",
                style = AppTheme.TextStyle.regular_12,
                color = Color.Gray,
                modifier = Modifier.padding(
                    start = 15.dp, top=10.dp)
            )

        }
    }
}