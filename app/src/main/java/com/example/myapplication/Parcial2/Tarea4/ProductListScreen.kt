package com.example.myapplication.Parcial2.Tarea4

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun ProductListScreen(preferencias: Preferencias, navController: NavController) {
    val scope = rememberCoroutineScope()

    // Data class para productos
    data class Producto(
        val nombre: String,
        val precio: Float,
        val imagen: Int,
        val enOferta: Boolean,
        val destacado: Boolean
    )

    // Estado para el monedero
    var wallet by remember { mutableStateOf(0f) }
    val selectedProducts = remember { mutableStateListOf<String>() }

    // Lista de productos
    val products = listOf(
        Producto("Samsung Galaxy S24", 29999f, R.drawable.c1, true, false),
        Producto("iPhone 13", 13999f, R.drawable.c2, false, true),
        Producto("Xiaomi Redmi Note 10", 5399f, R.drawable.c3, true, false),
        Producto("Poco 7x Pro", 7299f, R.drawable.c4, true, false),
        Producto("Oppo Find x7 Ultra", 10299f, R.drawable.c5, false, true)
    )

    // Obtener el dinero almacenado en las preferencias
    LaunchedEffect(Unit) {
        scope.launch {
            wallet = preferencias.wallet.first() // Obtiene el dinero almacenado
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Dinero actual: $wallet")
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(products) { product ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(product.imagen),
                        contentDescription = product.nombre,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        product.nombre,
                        modifier = Modifier.weight(1f)
                    )

                    Button(
                        onClick = {
                            if (wallet >= product.precio) {
                                wallet -= product.precio
                                selectedProducts.add(product.nombre)

                                // Guardar el nuevo valor de monedero en las preferencias
                                scope.launch {
                                    preferencias.saveAllData(
                                        name = "---",
                                        age = 0,
                                        height = 0f,
                                        wallet = wallet
                                    )
                                }
                            }
                        },
                        enabled = wallet >= product.precio
                    ) {
                        Text("Comprar (${product.precio})")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar los productos seleccionados
        Text("Productos seleccionados:")
        selectedProducts.forEach { productName ->
            Text("- $productName")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para regresar a InputScreen
        Button(onClick = {
            navController.navigate("input")
        }) {
            Text("Regresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductListScreen() {
    val context = LocalContext.current
    val preferencias = Preferencias(context)
    ProductListScreen(preferencias = preferencias, navController = rememberNavController())
}
