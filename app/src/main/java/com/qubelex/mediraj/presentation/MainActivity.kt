package com.qubelex.mediraj.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.qubelex.mediraj.presentation.ui.theme.MedirajTheme
import com.qubelex.mediraj.utils.nagivation.NavGraph
import com.qubelex.mediraj.utils.util.NavBottom
import com.qubelex.mediraj.utils.util.TopBar
import com.qubelex.mediraj.utils.util.exhaustive
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !mainViewModel.isLoading.value
        }
        setContent {
            MedirajTheme {
                val startDestination by mainViewModel.startDestination
                val bottomState by mainViewModel.bottomState

                MainScreen(screen = startDestination, bottomState = bottomState)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(screen: String, bottomState: Boolean) {

    val navController = rememberNavController()
    val showBottomBar = rememberSaveable { mutableStateOf(bottomState) }
    val showAppBar = rememberSaveable { mutableStateOf(false) }
    val appBarTitle = rememberSaveable { mutableStateOf("") }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        "on_board" -> {
            showBottomBar.value = false
            showAppBar.value = false
        }
        "login" -> {
            showBottomBar.value = false
            showAppBar.value = false
        }
        "otp_verify" -> {
            showBottomBar.value = false
            showAppBar.value = false
        }
        "home" -> {
            showBottomBar.value = true
            showAppBar.value = false
        }
        "order" -> {
            showBottomBar.value = true
            showAppBar.value = false
        }
        "wish_list" -> {
            showBottomBar.value = true
            showAppBar.value = false
        }
        "settings" -> {
            showBottomBar.value = true
            showAppBar.value = false
        }
        "notification"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Notification"
        }
        "medicine"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Medicine"
        }
        "diagnostic"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Diagnostic"
        }
        "pathology"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Pathology"
        }
        "clinic"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Clinic"
        }
        "doctor"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Doctor"
        }
        "surgical"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Surgical"
        }
        "blood"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Blood"
        }
        "ambulance"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Ambulance"
        }
        "real_time_doctor"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Real Time Medicine"
        }
        "profile"->{
            showBottomBar.value = false
            showAppBar.value = true
            appBarTitle.value = "Profile"
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                topBarState = showAppBar,
                topTitle = appBarTitle
            )
        },
        bottomBar = {
            NavBottom(
                navController = navController,
                bottomBarState = showBottomBar
            )
        }
    ) {padding->
        Box(modifier = Modifier.padding(padding)){
            NavGraph(navController = navController, startDestination = screen)
        }
    }

}

