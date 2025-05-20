package com.example.myapplication.Ordinario.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemonList(): PokemonResponse

    companion object {
        fun create(): PokemonApiService {
            return Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonApiService::class.java)
        }
    }
}

data class PokemonResponse(
    val count: Int,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
)