package com.qubelex.mediraj.presentation.onboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.qubelex.mediraj.R
import com.qubelex.mediraj.presentation.ui.theme.ForestGreen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(modifier: Modifier, pagerState: PagerState, onClick:()->Unit) {
    Row(
        modifier = modifier.padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = pagerState.currentPage == 2,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, backgroundColor = ForestGreen)
            ) {
                Text(text = stringResource(id = R.string.finish))
            }
        }

    }
}