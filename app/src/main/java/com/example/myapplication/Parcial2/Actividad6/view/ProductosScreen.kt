package com.example.myapplication.Parcial2.Actividad6.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.myapplication.Parcial2.Actividad6.models.Producto
import com.example.myapplication.Parcial2.Actividad6.viewmodels.ProductosViewModel


@Composable
fun ProductoItem(producto: Producto) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(producto.imagen),
                contentDescription = producto.nombre,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = producto.nombre, color = Color.Black)
                Text(text = producto.precio, color = Color.Black)
                Text(
                    text = if (producto.envioGratis) "Envío Gratis" else "Sin Envío Gratis",
                    color = if (producto.envioGratis) Color.Green else Color.Red
                )
                if (producto.promocion) {
                    Text(text = "¡Promoción!", color = Color.Blue)
                }
            }
        }
    }
}
@Composable
fun ProductosScreen(categoria: String, navController: NavController) {
    val viewModel: ProductosViewModel = viewModel()
    val productos = viewModel.getProductos(categoria)

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start) // Asegura que el botón esté alineado a la izquierda
        ) {
            Text(text = "Regresar")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), // Esto asegura que el LazyColumn tome el espacio restante
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(productos.size) { index ->
                ProductoItem(productos[index])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductosScreenPreview() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "productos/{categoria}") {
        composable("productos/{categoria}") { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: ""
            ProductosScreen(categoria, navController)
        }
    }
}
