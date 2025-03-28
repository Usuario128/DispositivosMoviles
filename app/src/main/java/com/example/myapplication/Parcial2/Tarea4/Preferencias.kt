package com.example.myapplication.Parcial2.Tarea4

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Preferencias(private val context: Context) {
    companion object {
        // Para que sea singleton el acceso al archivo
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

        // Llaves para las preferencias
        val AGE = intPreferencesKey("edad")
        val NAME = stringPreferencesKey("nombre")
        val HEIGHT = floatPreferencesKey("altura")
        val WALLET = floatPreferencesKey("dinero")
        val SIGN_UP = booleanPreferencesKey("registrado")
    }

    // Flujo para obtener el nombre
    val name: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[NAME] ?: "---"
    }

    // Flujo para obtener la edad
    val age: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[AGE] ?: -1
    }

    // Flujo para obtener la altura
    val height: Flow<Float> = context.dataStore.data.map { preferences ->
        preferences[HEIGHT] ?: 0f
    }

    // Flujo para obtener el dinero en monedero
    val wallet: Flow<Float> = context.dataStore.data.map { preferences ->
        preferences[WALLET] ?: 0f
    }

    // Función para guardar todos los datos del usuario
    suspend fun saveAllData(name: String, age: Int, height: Float, wallet: Float) {
        context.dataStore.edit { settings ->
            settings[NAME] = name
            settings[AGE] = age
            settings[HEIGHT] = height
            settings[WALLET] = wallet
        }
    }

    // Función para limpiar la sesión
    suspend fun clearSession() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}

