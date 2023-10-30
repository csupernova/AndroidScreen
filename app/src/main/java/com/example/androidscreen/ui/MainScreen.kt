package com.example.androidscreen.ui.theme

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
            InstallButton(
                text = "Install",
                onClick = {
                    Toast.makeText(context, "CLICKED", Toast.LENGTH_LONG).show()
                }
            )
        }

    }
}

@Composable
fun DotaScreenHeader(
    modifier: Modifier = Modifier,
){
    Image(
        painter = painterResource(id = R.drawable.dota2mainscreen),
        contentDescription = "DotaHeader",
        contentScale = ContentScale.Crop
    )
    DotaLogo()

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
