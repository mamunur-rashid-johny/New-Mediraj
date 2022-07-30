package com.qubelex.mediraj.presentation.onboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qubelex.mediraj.utils.datastore_pref.PreferenceDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val preferenceDataStore: PreferenceDataStore
) : ViewModel() {

    private val _eventChannel = Channel<OnBoardEvent>()
    val eventChannel =_eventChannel.receiveAsFlow()

    fun saveOnBoardData(completed:Boolean) = viewModelScope.launch {
        preferenceDataStore.saveOnBoardState(completed)
    }



    sealed class OnBoardEvent {
        object NavigateToHome : OnBoardEvent()
        object NavigateToLogin : OnBoardEvent()
    }
}