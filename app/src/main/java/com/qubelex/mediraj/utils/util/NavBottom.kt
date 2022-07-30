package com.qubelex.mediraj.utils.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.qubelex.mediraj.presentation.ui.theme.ForestGreen
import com.qubelex.mediraj.utils.nagivation.Screens

@Composable
fun NavBottom(
    navController: NavController,
    bottomBarState: MutableState<Boolean>
) {
    val items = listOf(Screens.Home, Screens.Order, Screens.Cart, Screens.Settings)
    val context = LocalContext.current
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = expandVertically(),
        exit = shrinkVertically(),
        content = {
            BottomNavigation(
                elevation = 10.dp,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.height(60.dp),
            ) {

                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                items.forEach { item ->
                    val selectedIcon =
                        navController.currentDestination?.hierarchy?.any { it.route == item.route } == true

                    BottomNavigationItem(
                        selected = currentRoute == item.route,
                        icon = {
                            Icon(
                                painter = if (selectedIcon) painterResource(id = item.selectedIcon!!) else painterResource(
                                    id = item.icon!!
                                ), contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                tint = if (selectedIcon) ForestGreen else Color.LightGray
                            )
                        },
                        label = {
                            Text(text = stringResource(id = item.title))
                        },
                        onClick = {

                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }

            }
        }
    )

}