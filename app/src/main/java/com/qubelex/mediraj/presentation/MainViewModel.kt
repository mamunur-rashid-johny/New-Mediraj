package com.qubelex.mediraj.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qubelex.mediraj.utils.datastore_pref.PreferenceDataStore
import com.qubelex.mediraj.utils.nagivation.Screens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val preferenceDataStore: PreferenceDataStore
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> = mutableStateOf(Screens.OnBoard.route)
    val startDestination: State<String> = _startDestination

    private val _bottomState: MutableState<Boolean> = mutableStateOf(false)
    val bottomState: State<Boolean> = _bottomState


    init {
        viewModelScope.launch {
            preferenceDataStore.preferenceFlow().collect { pref ->
                if (pref.completed) {
                    if (pref.userAuth == null) {
                        _startDestination.value = Screens.Login.route
                        _bottomState.value = false
                    } else {
                        _startDestination.value = Screens.Home.route
                        _bottomState.value = true
                    }
                } else {
                    _startDestination.value = Screens.OnBoard.route
                    _bottomState.value = false
                }

            }
            _isLoading.value = false
        }
    }



}