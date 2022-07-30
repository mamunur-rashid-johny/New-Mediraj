package com.qubelex.mediraj.utils.data_source

import androidx.annotation.DrawableRes
import com.qubelex.mediraj.R

sealed class OnBoardingPager(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
){
    object First : OnBoardingPager(
        image = R.drawable.onboarding_1,
        title = "OnBoard Heading One",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Second:OnBoardingPager(
        image = R.drawable.onboarding_2,
        title = "OnBoard Heading Two",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    object Third:OnBoardingPager(
        image = R.drawable.onboarding_3,
        title = "OnBoard Heading Three",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
