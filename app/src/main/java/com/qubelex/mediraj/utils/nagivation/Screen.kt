package com.qubelex.mediraj.utils.nagivation

import androidx.annotation.DrawableRes
import com.qubelex.mediraj.R

sealed class Screens(val route:String, val title:Int, @DrawableRes val icon:Int?, @DrawableRes val selectedIcon:Int?) {
    object OnBoard:Screens("on_board", R.string.onBoard,null,null)
    object Login:Screens("login", R.string.login,null,null)
    object OtpVerify:Screens("otp_verify", R.string.otp,null,null)
    object Home:Screens("home", R.string.home, R.drawable.ic_home, R.drawable.ic_home_fill)
    object Order:Screens("order", R.string.order, R.drawable.ic_cart, R.drawable.ic_cart_fill)
    object Cart:Screens("wish_list", R.string.cart, R.drawable.ic_bookmark, R.drawable.ic_bookmark_fill)
    object Settings:Screens("settings", R.string.setting, R.drawable.ic_settings, R.drawable.ic_settings_fill)
    object Notification:Screens("notification",R.string.notification,null,null)
    object Medicine:Screens("medicine",R.string.medicine,null,null)
    object Diagnostic:Screens("diagnostic",R.string.diagnostic,null,null)
    object Pathology:Screens("pathology",R.string.pathology,null,null)
    object Clinic:Screens("clinic",R.string.clinic,null,null)
    object Doctor:Screens("doctor",R.string.doctor,null,null)
    object Surgical:Screens("surgical",R.string.surgical,null,null)
    object Blood:Screens("blood",R.string.blood,null,null)
    object Ambulance:Screens("ambulance",R.string.ambulance,null,null)
    object RealTimeMedicine:Screens("real_time_doctor",R.string.real_time_update,null,null)
    object Profile:Screens("profile",R.string.profile,null,null)
}
