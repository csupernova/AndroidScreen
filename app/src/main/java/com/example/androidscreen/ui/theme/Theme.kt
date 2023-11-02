package com.example.androidscreen.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

object AppTheme{

    object BgColors{
        val mainBgColor
            @Composable
            get() =
                Color(0xFF050B18)

        val filterBgColor
            @Composable
            get() =
                Color(0x3D44A9F4)

        val buttonBgColor
            @Composable
            get() = Color(0xFFF4D144)

    }

    object TextColor{
        val descColor
            @Composable
            get()  =
                Color(0xB2EEF2FB)

        val commentColor
            @Composable
            get()  =
                Color(0xFFA8ADB7)

        val whiteColor
            @Composable
            get()  =
                Color.White

        val darkGrayColor
            @Composable
            get() =
                Color.DarkGray

        val dateColor
            @Composable
            get() =
                Color(0x66FFFFFF)

        val filterColor
            @Composable
            get() =
                Color(0xFF41A0E7)

        val buttonTextColor
            @Composable
            get() =
                Color(0xFF050B18)

    }

    object TextStyle{
        val bold_48
        @Composable
        get() =
            TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false),
                lineHeightStyle = LineHeightStyle(
                    LineHeightStyle.Alignment.Proportional,
                    LineHeightStyle.Trim.None
                )
            )

        val regular_12
            @Composable
            get() =
                TextStyle(
                    fontFamily = fontFamily,
                    fontSize = 12.sp ,
                    fontWeight = FontWeight(400),
                    lineHeight = 19.sp,
                )

        val regular_12_20
        @Composable
        get() =
            TextStyle(
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight(400),
                letterSpacing = 0.5.sp,
            )

        val regular_20_bold
            @Composable
            get() =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp ,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.5.sp,
                )

        val regular_20_bold_0_6
            @Composable
            get() =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(700),
                    fontSize = 20.sp ,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.6.sp,
                )
        val regular_16_bold
            @Composable
            get() =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp ,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                )

        val regular_16
            @Composable
            get() =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp ,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                    letterSpacing = 0.5.sp
                )
        val regular_10
            @Composable
            get() =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    fontSize = 10.sp ,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        LineHeightStyle.Alignment.Proportional,
                        LineHeightStyle.Trim.None
                    ),
                )
    }
}