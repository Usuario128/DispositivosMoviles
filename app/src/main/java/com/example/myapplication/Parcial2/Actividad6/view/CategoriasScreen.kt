package com.example.myapplication.Parcial2.Actividad6.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Parcial2.Actividad6.viewmodels.ProductosViewModel

@Composable
fun CategoriasScreen(navController: NavController) {
    val viewModel: ProductosViewModel = viewModel()

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start) // Asegura que el botón esté alineado a la izquierda
        ) {
            Text(text = "Regresar")
        }

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), // Hace que el LazyRow tome el espacio restante
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(viewModel.categorias.size) { index ->
                val categoria = viewModel.categorias[index]
                CategoriaItem(categoria.nombre, categoria.imagen) {
                    navController.navigate("productos/${categoria.nombre}")
                }
            }
        }
    }
}

@Composable
fun CategoriaItem(nombre: String, imagen: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imagen),
                contentDescription = nombre,
                modifier = Modifier.size(80.dp)
            )
            Text(text = nombre, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriasScreenPreview() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categorias") {
        composable("categorias") {
            CategoriasScreen(navController)
        }
        composable("productos/{categoria}") { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: ""
            ProductosScreen(categoria, navController) // Incluye el navController para manejar la navegación
        }
    }
}
