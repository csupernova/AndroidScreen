package com.example.androidscreen.ui.theme

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidscreen.R
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
                R.drawable.dota2_screenshot2
            ),
                PaddingValues(start=24.dp, end=24.dp)
            )
        }
        item{
            Text(
                text = stringResource(id = R.string.revrat),
                style = AppTheme.TextStyle.regular_16_bold,
                color = Color.White,
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
                onClick = {
                    Toast.makeText(context, "CLICKED", Toast.LENGTH_LONG).show()
                }
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DotaScreenHeader(
    modifier: Modifier = Modifier,
){
    Image(
        painter = painterResource(id = R.drawable.dota2mainscreen),
        contentDescription = "DotaHeader",
        contentScale = ContentScale.Crop
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
                                style = AppTheme.TextStyle.regular_12,
                                color = Color(0xFF44A9F4)
                            )
                        },
                    )
                }
            }
        }
    }
}


@Composable
fun DotaLogo(){
    Box(
        modifier = Modifier
            .size(100.dp)
            .offset(x = 20.dp, y = (-35).dp)
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

@Composable
fun DescriptionDota(){
    Box(){
        Text(
            text = stringResource(id = R.string.dota_description),
            color = Color(0xFFF2FBB2),
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                    bottom=14.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoPreviewRow(
    previewResList: List<Int>,
    contentPadding: PaddingValues
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val pagerState = rememberPagerState{previewResList.size}
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            key = {previewResList[it]},
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(start = 24.dp, end = 24.dp),
            pageSpacing = -(50).dp
        ) {
            index ->
            Image(
                painter = painterResource(id = previewResList[index]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(270.dp)
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(15.dp))
            )
        }

    }
}

@Composable
fun InstallButton(
    text: String,
    onClick: () -> Unit,
){
    Box(){
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 20.dp,
                    bottom = 40.dp
                )
                .clip(RoundedCornerShape(1.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4D144),
                contentColor = Color.Black
            )
        ) {
            Text(
                text,
                style = AppTheme.TextStyle.regular_20_bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        top=10.dp,
                        bottom=10.dp)
            )
        }
    }
}

@Composable
fun RatingBlock(
    rating: Float,
    reviewCount:String,
    modifier:Modifier
){
    Row(modifier = modifier){
        Text(
            text = "$rating",
            style = AppTheme.TextStyle.bold_48,
            color = Color.White
        )
        Column(){
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

@Composable
fun CommentBlock(
    item: Pair<Int, String>,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Row(
        ) {
            Box() {
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
                    color = Color.White,
                    modifier = Modifier
                        .padding(start=15.dp, bottom = 5.dp)
                )
                Text(
                    text = "Febuary, 14, 2019",
                    style = AppTheme.TextStyle.regular_10,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start=15.dp)
                )
            }
        }
        Text(
            text = stringResource(id = R.string.comment),
            style = AppTheme.TextStyle.regular_12,
            modifier = Modifier
                .padding(top=16.dp),
            color = Color.Gray
        )
    }
}
