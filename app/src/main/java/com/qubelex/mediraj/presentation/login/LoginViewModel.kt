package com.qubelex.mediraj.presentation.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qubelex.mediraj.utils.datastore_pref.PreferenceDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val preferenceDataStore: PreferenceDataStore
):ViewModel() {

    private val _loginEvent = Channel<LoginEvent>()
    val loginEvent = _loginEvent.receiveAsFlow()

    fun openLinkEvent()=viewModelScope.launch {
        _loginEvent.send(LoginEvent.OpenLink("https://www.google.com/"))
    }





    sealed class LoginEvent{
        data class OpenLink(val link:String):LoginEvent()
    }
}
