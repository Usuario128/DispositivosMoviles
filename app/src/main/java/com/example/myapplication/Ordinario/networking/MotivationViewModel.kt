package com.example.myapplication.Ordinario.networking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MotivationViewModel : ViewModel() {

    private val api = PokemonApiService.create()

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    fun loadPokemonList() {
        viewModelScope.launch {
            try {
                val response = api.getPokemonList()
                _pokemonList.value = response.results
            } catch (e: Exception){
                // Handle error
            }
        }

    }
}

