package com.qubelex.mediraj.presentation.onboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.qubelex.mediraj.presentation.ui.theme.ForestGreen
import com.qubelex.mediraj.utils.data_source.OnBoardingPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardScreen(navController: NavController) {

    val viewModel: OnBoardViewModel = hiltViewModel()
    val pages = listOf(OnBoardingPager.First, OnBoardingPager.Second, OnBoardingPager.Third)
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        SkipButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), pagerState = pagerState
        ) {
            viewModel.saveOnBoardData(true)
        }

        HorizontalPager(
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(9f)
        ) { position ->
            PagerScreen(onBoardingPager = pages[position])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            activeColor = ForestGreen,
            inactiveColor = MaterialTheme.colorScheme.onBackground
        )

        FinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {
            viewModel.saveOnBoardData(true)
        }

    }
}
