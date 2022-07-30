package com.qubelex.mediraj.utils.data_source

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.qubelex.mediraj.R

data class Service(
    val id:Int,
    @DrawableRes val icon:Int,
    @StringRes val title:Int
)

val services = listOf(
    Service(1, R.drawable.ic_medicine,R.string.medicine),
    Service(2, R.drawable.ic_diagnostic,R.string.diagnostic),
    Service(3, R.drawable.ic_pathology,R.string.pathology),
    Service(4, R.drawable.ic_clinic,R.string.clinic),
    Service(5, R.drawable.ic_doctor,R.string.doctor),
    Service(6, R.drawable.ic_surgical,R.string.surgical),
    Service(7, R.drawable.ic_blood,R.string.blood),
    Service(8, R.drawable.ic_ambulance,R.string.ambulance),
    Service(9, R.drawable.ic_real_doctor,R.string.real_time_update)
)
