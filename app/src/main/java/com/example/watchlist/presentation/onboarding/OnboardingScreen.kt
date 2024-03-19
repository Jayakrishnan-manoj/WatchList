package com.example.watchlist.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun onBoardingScreen() {
    val items = OnboardingItems.getData()
//    val state = rememberPagerState { 3 }
//    val currentPage = state.currentPage
    val state = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        3
    }
    val coroutineScope = rememberCoroutineScope()

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

                ElevatedButton(
                    onClick = {
                        coroutineScope.launch {
                            if (page < items.lastIndex) {
                                state.scrollToPage(page + 1)
                            } else {
                                // Navigate to Sign In screen
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    Text(
                        text = if (page < items.lastIndex) "Next" else " Sign In with Google",
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}