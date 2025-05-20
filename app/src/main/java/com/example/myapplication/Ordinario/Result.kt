package com.example.myapplication.Ordinario

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ordinario.R
import com.example.ordinario.examen.networking.MotivationViewModel

@Composable
fun Result(opcion: Int, navController: NavController) {
    val viewModel: MotivationViewModel = viewModel()
    val pokemonListState = viewModel.pokemonList.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                opcion == 1 -> {
                    // Cargar la lista de Pokémon
                    Text(text = "Cargando lista de Pokémon...")
                    viewModel.loadPokemonList()

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(pokemonListState.value) { pokemon ->
                            PokemonRow(pokemon)
                        }
                    }
                }

                opcion == 2 -> {
                    Image(
                        painter = painterResource(id = R.drawable.game_over),
                        contentDescription = "Fin del juego"
                    )
                }

                else -> {
                    Text(text = "Ingrese una opción válida")
                }
            }
            Button(onClick = { navController.navigate("Inicio") }) {
                Text(text = "Volver")
            }
        }

    }
}


@Composable
fun PokemonRow(pokemon: com.example.ordinario.examen.networking.Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = pokemon.name, modifier = Modifier.padding(start = 8.dp))
    }
}