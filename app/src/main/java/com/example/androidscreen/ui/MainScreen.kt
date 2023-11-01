package com.example.androidscreen.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
import com.example.androidscreen.ui.CommentBlock
import com.example.androidscreen.ui.DescriptionDota
import com.example.androidscreen.ui.DotaScreenHeader
import com.example.androidscreen.ui.InstallButton
import com.example.androidscreen.ui.RatingBlock
import com.example.androidscreen.ui.VideoPreviewRow
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun MainScreen(){

    ApplySystemBarColors()

    Surface(
        color = AppTheme.BgColors.mainBgColor,
        modifier = Modifier.fillMaxSize()
    ){
        DotaScreen()
    }
}

@Composable
private fun ApplySystemBarColors(){
    val systemUiController = rememberSystemUiController()

    SideEffect{
        systemUiController.setSystemBarsColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}

@Composable
fun DotaScreen(){

    val context = LocalContext.current
    val LazyListState = rememberLazyListState()

    val comments = listOf(
        Pair(R.drawable.avatar1, "Auguste Conte"),
        Pair(R.drawable.avatar2, "Jang Marcelino")
    )

    LazyColumn(
        state = LazyListState,
        modifier = Modifier
            .fillMaxSize()
    ){
        item{
            DotaScreenHeader()
        }
        item{
            DescriptionDota()
        }
        item{
            VideoPreviewRow(listOf(
                R.drawable.dota2_screenshot1,
                R.drawable.dota2_screenshot2))
        }
        item{
            Text(
                text = stringResource(id = R.string.revrat),
                style = AppTheme.TextStyle.regular_16_bold,
                color = Color(0xFFEEF2FB),
                modifier = Modifier
                    .padding(
                        start=24.dp,
                        end=24.dp,
                        bottom=12.dp,
                        top=20.dp
                        )

            )
        }

        item{
            RatingBlock(
                rating = 4.9f,
                reviewCount = "70M",
                modifier = Modifier.padding(
                    start=24.dp, end =24.dp, bottom = 16.dp
                )
            )
        }

        itemsIndexed(comments){index, item ->
            CommentBlock(
                item,
                Modifier.padding(
                    start=24.dp,
                    end=24.dp,
                    top=16.dp
                ))
            if(index < comments.lastIndex){
                Divider(
                    color = Color(0xFF1A1F29),
                    thickness=1.dp,
                    modifier = Modifier
                        .padding(
                            bottom = 10.dp,
                            top=12.dp
                        )
                )
            }
        }

        item{
            InstallButton(
                text = stringResource(id = R.string.buttonInstall),
            )
        }

    }
}
