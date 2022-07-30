package com.qubelex.mediraj.utils.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBar(
    navController: NavController,
    topBarState: MutableState<Boolean>,
    topTitle: MutableState<String>
) {

    AnimatedVisibility(
        visible = topBarState.value,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        TopAppBar(
            title = { Text(text = topTitle.value, color = MaterialTheme.colors.onBackground) },
            navigationIcon = {
                navController.previousBackStackEntry?.let {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            },
            contentColor = MaterialTheme.colors.surface,
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 10.dp
        )

    }

}
