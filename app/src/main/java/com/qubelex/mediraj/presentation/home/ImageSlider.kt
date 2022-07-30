package com.qubelex.mediraj.presentation.home

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.qubelex.mediraj.R
import com.qubelex.mediraj.presentation.ui.theme.ForestGreen
import com.qubelex.mediraj.utils.data_source.ImageSliderData
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(slides: List<ImageSliderData>) {
    val configuration = LocalConfiguration.current
    val height =
        animateDpAsState(targetValue = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 440.dp else 220.dp)

    val pagerState = rememberPagerState(
        initialPage = 0
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.value),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            state = pagerState,
            count = slides.size
        ) { page ->
            ImageSliderCard(imageSliderData = slides[page])
        }
        //Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(5.dp),
            activeColor = ForestGreen,
            inactiveColor = MaterialTheme.colorScheme.onBackground
        )
    }

}

@Composable
fun ImageSliderCard(imageSliderData: ImageSliderData) {
    val configuration = LocalConfiguration.current
    val cardHeight =
        animateDpAsState(targetValue = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 360.dp else 180.dp)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight.value)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageSliderData.url)
                .crossfade(true)
                .build(),
            contentDescription = null,
            error = painterResource(id = R.drawable.app_logo),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


