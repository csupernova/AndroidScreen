package com.example.androidscreen.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R

@Composable
fun DotaLogo(){
    Box(
        modifier = Modifier
            .size(90.dp)
            .offset(x = 20.dp, y = (-20).dp)
            .clip(RoundedCornerShape(15.dp))
            .border(
                BorderStroke(1.dp, Color(0xFF1F2430)),
                RoundedCornerShape(15.dp)
            )
            .background(color = Color.Black)
    ){
        Image(
            painter = painterResource(id = R.drawable.dota2_logo),
            contentDescription = "DotaLogo",
            modifier = Modifier
                .padding(all=17.dp)
        )
    }

}