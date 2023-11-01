package com.example.androidscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
import com.example.androidscreen.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DotaScreenHeader(
    modifier: Modifier = Modifier,
){
    Image(
        painter = painterResource(id = R.drawable.dota2mainscreen),
        contentDescription = "DotaHeader",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
    Column {
        Row() {
            Box() {
                DotaLogo()
            }
            Column {
                Text(
                    text = stringResource(id = R.string.dotamain),
                    style = AppTheme.TextStyle.regular_20_bold,
                    modifier = Modifier
                        .padding(start = 40.dp, top = 10.dp)
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.fivestars),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 40.dp, top = 10.dp)
                    )
                    Text(
                        text = "70M",
                        style = AppTheme.TextStyle.regular_12,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(start = 8.dp, top = 10.dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(start = 25.dp,)
                .offset(y = -(15).dp)

        ){
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                itemsIndexed(listOf("MOBA", "MULTIPLAYER", "STRATEGY")) { index, item ->
                    AssistChip(
                        border = null,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(size = 100.dp))
                            .height(22.dp),
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color(0x3D44A9F4),
                        ),
                        onClick = {},
                        label = {
                            Text(
                                text = item,
                                style = AppTheme.TextStyle.regular_10,
                                color = Color(0xFF41A0E7),
                            )
                        },
                    )
                }
            }
        }
    }
}