package com.example.myapplication.Examen2P.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Examen2P.models.Categoria
import com.example.myapplication.Examen2P.models.Producto
import com.example.myapplication.Parcial2.Tarea4.Preferencias
import com.example.myapplication.Parcial2.Tarea4.ProductListScreen
import com.example.myapplication.R

class ProductosViewModel : ViewModel() {

    val categorias = listOf(
        Categoria("Vuelos Nacionales"),
        Categoria("Vuelos Internacionales")
    )

    val productosPorCategoria = mapOf(
        "Vuelos Nacionales" to listOf(
            Producto(R.drawable.cancun, "Cancún", "Ida y Vuelta", "No tiene extras"),
            Producto(R.drawable.mexico, "Ciudad de México", "Sencillo", "Incluye alojamiento"),
            Producto(R.drawable.mty, "Monterrey", "Ida y Vuelta", "Alojamiento y desayuno")
        ),
        "Vuelos Internacionales" to listOf(
            Producto(R.drawable.seul, "Seúl", "Ida y Vuelta", "Incluye alojamiento"),
            Producto(R.drawable.usa, "New York", "Sencillo", "Alojamiento y desayuno"),
            Producto(R.drawable.paris, "París", "Sencillo", "No tiene extras")
        )
    )

    fun getProductos(categoria: String): List<Producto> {
        return productosPorCategoria[categoria] ?: emptyList()
    }
}

@Composable
fun ProductosLazyList(viewModel: ProductosViewModel = viewModel()) {
    LazyRow {
        items(viewModel.categorias) { categoria ->
            Column(modifier = Modifier.padding(8.dp)) {
                CategoriaHeader(categoria.nombre)
                val productos = viewModel.getProductos(categoria.nombre)
                productos.forEach { producto ->
                    ProductoItem(producto)
                }
            }
        }
    }
}

@Composable
fun CategoriaHeader(nombre: String) {
    Text(text = nombre, modifier = Modifier.padding(8.dp))
}

@Composable
fun ProductoItem(producto: Producto) {
    
    Card(modifier = Modifier.padding(8.dp)) {

        Column(modifier = Modifier.padding(8.dp)) {
            Row {
            Image(
                painter = painterResource(producto.imagen),
                contentDescription = producto.destino,
                modifier = Modifier.size(80.dp)
            )
                Column{
                    Text(text = producto.destino)
                    Text(text = producto.TipoVuelo)
                    Text(text = producto.extra)
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductListScreen() {
    Text(text = "¿A donde quieres viajar?")


    ProductosLazyList()
}

