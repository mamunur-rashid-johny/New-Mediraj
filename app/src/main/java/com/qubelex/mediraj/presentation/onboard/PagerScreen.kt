package com.qubelex.mediraj.presentation.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qubelex.mediraj.utils.data_source.OnBoardingPager

@Composable
fun PagerScreen(onBoardingPager: OnBoardingPager) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = onBoardingPager.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f)
        )
        Text(
            text = onBoardingPager.title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = onBoardingPager.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            color = MaterialTheme.colorScheme.onBackground
        )

    }


}


@Preview(showBackground = true)
@Composable
fun PreviewPagerScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPager = OnBoardingPager.First)
    }
}
