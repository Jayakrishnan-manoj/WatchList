package com.example.watchlist.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen() {
    val items = OnboardingItems.getData()
    val state = rememberPagerState { 3 }

    HorizontalPager(
        state = state,

    ) { page ->
        Box(

            ) {
            if (page in items.indices) {
                val currentItem = items[page]
                // Display image, title, and description from OnboardingItems
                Image(
                    painter = painterResource(id = currentItem.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize(),
                    colorFilter = ColorFilter.tint(Color.Black, blendMode = BlendMode.Lighten)
                )
            }
        }
    }
}