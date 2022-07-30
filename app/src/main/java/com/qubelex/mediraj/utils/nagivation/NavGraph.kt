package com.qubelex.mediraj.utils.nagivation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qubelex.mediraj.presentation.ambulance.AmbulanceScreen
import com.qubelex.mediraj.presentation.blood.BloodScreen
import com.qubelex.mediraj.presentation.cart.CartScreen
import com.qubelex.mediraj.presentation.clinic.ClinicScreen
import com.qubelex.mediraj.presentation.diagnostic.DiagnosticScreen
import com.qubelex.mediraj.presentation.doctor.DoctorScreen
import com.qubelex.mediraj.presentation.home.HomeScreen
import com.qubelex.mediraj.presentation.login.LoginScreen
import com.qubelex.mediraj.presentation.medicine.MedicineScreen
import com.qubelex.mediraj.presentation.notification.NotificationScreen
import com.qubelex.mediraj.presentation.onboard.OnBoardScreen
import com.qubelex.mediraj.presentation.order.OrderScreen
import com.qubelex.mediraj.presentation.otp_verify.OtpVerifyScreen
import com.qubelex.mediraj.presentation.pathology.PathologyScreen
import com.qubelex.mediraj.presentation.profile.ProfileScreen
import com.qubelex.mediraj.presentation.real_time_medicine.RealTimeMedicineScreen
import com.qubelex.mediraj.presentation.settings.SettingsScreen
import com.qubelex.mediraj.presentation.surgical.SurgicalScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable(Screens.OnBoard.route) {
            OnBoardScreen(navController = navController)
        }

        composable(Screens.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Screens.OtpVerify.route) {
            OtpVerifyScreen(navController = navController)
        }

        composable(Screens.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screens.Order.route) {
            OrderScreen(navController = navController)
        }

        composable(Screens.Cart.route) {
            CartScreen(navController = navController)
        }

        composable(Screens.Settings.route) {
            SettingsScreen(navController = navController)
        }

        composable(Screens.Notification.route){
            NotificationScreen(navController = navController)
        }

        composable(Screens.Medicine.route){
            MedicineScreen(navController = navController)
        }

        composable(Screens.Diagnostic.route){
            DiagnosticScreen(navController = navController)
        }

        composable(Screens.Pathology.route){
            PathologyScreen(navController = navController)
        }
        composable(Screens.Clinic.route){
            ClinicScreen(navController = navController)
        }
        composable(Screens.Doctor.route){
            DoctorScreen(navController = navController)
        }
        composable(Screens.Surgical.route){
            SurgicalScreen(navController = navController)
        }
        composable(Screens.Blood.route){
            BloodScreen(navController = navController)
        }
        composable(Screens.Ambulance.route){
            AmbulanceScreen(navController = navController)
        }
        composable(Screens.RealTimeMedicine.route){
            RealTimeMedicineScreen(navController = navController)
        }
        composable(Screens.Profile.route){
            ProfileScreen(navController = navController)
        }


    }

}
