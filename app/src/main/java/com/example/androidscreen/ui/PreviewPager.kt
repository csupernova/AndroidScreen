package com.example.androidscreen.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoPreviewRow(
    previewResList: List<Int>,
) {
    val pagerState = rememberPagerState{previewResList.size}
    Box(
        modifier = Modifier.height(160.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            key = {previewResList[it]},
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
            pageSpacing = -(50).dp,
        ) {
                index ->
            Box{
                Image(
                    painter = painterResource(id = previewResList[index]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(270.dp)
                        .aspectRatio(16f / 9f)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0x77000000))
                        .graphicsLayer {
                            shape = CircleShape
                            alpha = 0.7f
                        },
                    colorFilter =
                    ColorFilter.colorMatrix(
                        ColorMatrix()
                            .apply {
                                setToScale(
                                    0.6f, 0.6f, 0.6f, 1f
                                )
                            }),

                    )
                if (index == 0) {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(54.dp)
                            .clip(CircleShape)
                            .blur(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray.copy(alpha = 0.5f)
                        ),
                    ) {}
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(13.dp)

                    )
                }
            }
        }
    }
}