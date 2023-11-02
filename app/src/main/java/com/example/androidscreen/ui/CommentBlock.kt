package com.example.androidscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
import com.example.androidscreen.ui.theme.AppTheme

@Composable
fun CommentBlock(
    item: Pair<Int, String>,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Row{
            Box{
                Image(
                    painter = painterResource(id = item.first),
                    contentDescription = "AvatarProfile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                )
            }
            Column {
                Text(
                    text = item.second,
                    style = AppTheme.TextStyle.regular_16,
                    color = AppTheme.TextColor.whiteColor,
                    modifier = Modifier
                        .padding(start=15.dp, bottom = 5.dp)
                )
                Text(
                    text = "Febuary, 14, 2019",
                    style = AppTheme.TextStyle.regular_12_20,
                    color = AppTheme.TextColor.dateColor,
                    modifier = Modifier
                        .padding(start=15.dp)
                )
            }
        }
        Text(
            text = stringResource(id = R.string.comment),
            style = AppTheme.TextStyle.regular_12_20,
            modifier = Modifier
                .padding(top=16.dp),
            color = AppTheme.TextColor.commentColor
        )
    }
}