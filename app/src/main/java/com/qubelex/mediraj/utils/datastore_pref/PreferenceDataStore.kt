package com.qubelex.mediraj.utils.datastore_pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.qubelex.mediraj.common.Constants
import com.qubelex.mediraj.utils.data_source.FilterData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_PREF)

class PreferenceDataStore(context: Context) {
    private object PreferenceKey {
        val ON_BOARD = booleanPreferencesKey(name = "on_board_completed")
        val USER_AUTH = stringPreferencesKey(name = "user_auth")
    }

    private val dataStore = context.dataStore

    suspend fun saveOnBoardState(completed: Boolean) {
        dataStore.edit { pref ->
            pref[PreferenceKey.ON_BOARD] = completed
        }
    }

    suspend fun saveAuthData(authData: String) {
        dataStore.edit { pref ->
            pref[PreferenceKey.USER_AUTH] = authData
        }
    }

    fun preferenceFlow(): Flow<FilterData> {
        return dataStore.data
            .catch { execption ->
                if (execption is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw execption
                }
            }
            .map { pref ->
                val onBoardData = pref[PreferenceKey.ON_BOARD] ?: false
                val authData = pref[PreferenceKey.USER_AUTH]
                FilterData(onBoardData, authData)
            }
    }

    suspend fun removeAuthData() {
        dataStore.edit { pref ->
            pref.remove(PreferenceKey.USER_AUTH)
        }
    }
}
