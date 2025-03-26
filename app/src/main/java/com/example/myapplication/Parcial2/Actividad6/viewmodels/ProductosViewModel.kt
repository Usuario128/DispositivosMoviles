package com.example.myapplication.Parcial2.Actividad6.viewmodels

import androidx.lifecycle.ViewModel
import com.example.myapplication.Parcial2.Actividad6.models.Categoria
import com.example.myapplication.Parcial2.Actividad6.models.Producto
import com.example.myapplication.R

class ProductosViewModel : ViewModel() {

    val categorias = listOf(
        Categoria("Celulares", R.drawable.c0),
        Categoria("Computación", R.drawable.l0),
        Categoria("Linea Blanca", R.drawable.lb0),
        Categoria("SuperMercado", R.drawable.s0),
        Categoria("Hogar", R.drawable.h0)
    )

    private val productosPorCategoria = mapOf(
        "Celulares" to listOf(
            Producto(
                "Samsung Galaxy S24",
                "$29,999",
                R.drawable.c1,
                true,
                false),
            Producto(
                "iPhone 13",
                "$13,999",
                R.drawable.c2,
                false,
                true),
            Producto(
                "Xiaomi Redmi Note 10",
                "$5,399",
                R.drawable.c3,
                true,
                false),
            Producto(
                "Poco 7x Pro",
                "$7,299",
                R.drawable.c4,
                true,
                false),
            Producto(
                "Oppo Find x7 Ultra",
                "$10,299",
                R.drawable.c5,
                false,
                true)
        ),
        "Computación" to listOf(
            Producto(
                "MacBook Air M1",
                "$18,369",
                R.drawable.l1,
                true,
                false),
            Producto(
                "Dell XPS 13",
                "$38,265",
                R.drawable.l2,
                false,
                true),
            Producto(
                "HP Spectre x360",
                "$40,693",
                R.drawable.l3,
                true,
                false),
            Producto(
                "ASUS ROG Zephyrus",
                "$39,586",
                R.drawable.l4,
                false,
                false),
            Producto(
                "Lenovo ThinkPad X1",
                "$43,099",
                R.drawable.l5,
                true,
                true)
        ),
        "Linea Blanca" to listOf(
            Producto(
                "Frigobar 4.4 Pies TSD44B",
                "$3,786",
                R.drawable.lb1,
                true,
                false),
            Producto(
                "Cámara De Seguridad Exterior Wifi Inalámbrica 1080p",
                "$202",
                R.drawable.lb2,
                false,
                true),
            Producto(
                "Batidora Manual Electrica De Mano 7 Velocidades 260w 2 En 1",
                "$145",
                R.drawable.lb3,
                true,
                false),
            Producto(
                "Blackdecker Bced37 - Secador Compacto",
                "$25,200",
                R.drawable.lb4,
                false,
                false),
            Producto(
                "Baker's Friend Sandwichera De 4 Rebanadas De Desayuno",
                "$2,604",
                R.drawable.lb5,
                true,
                true)
        ),
        "SuperMercado" to listOf(
            Producto(
                "Agua Member's Mark 40 Piezas De 355 Ml C/u",
                "$134",
                R.drawable.s1,
                true,
                false),
            Producto(
                "Refresco Sprite Sin Azúcar Lima Limón 6 Pack 355ml",
                "$122",
                R.drawable.s2,
                false,
                true),
            Producto(
                "4 Lt Lavatrastes Liquido Cortagrasa Limón",
                "$115",
                R.drawable.s3,
                true,
                false),
            Producto(
                "Lysol® Limpiador Desinfectante Multiusos Citrus de 5 L",
                "$1599",
                R.drawable.s4,
                false,
                false),
            Producto(
                "Engagrow Pro Select etapa 4 vainilla 1.5kg",
                "$581",
                R.drawable.s5,
                true,
                true)
        ),
        "Hogar" to listOf(
            Producto(
                "Carpa Toldo Plegable 3x3 Impermeable Y Reforzado Styrka Color Azul",
                "$905",
                R.drawable.h1,
                true,
                false),
            Producto(
                "Bagada Mesablanca120 Mesa de exterior de acero color blanco",
                "$620",
                R.drawable.h2,
                false,
                true),
            Producto(
                "Escritorio Minimalista Oficina Estacion Trabajo Metal Repisa",
                "$989",
                R.drawable.h3,
                true,
                false),
            Producto(
                "Cortina Blackout En 2 Paneles 280x220cm Premium Quality!",
                "$295",
                R.drawable.h4,
                false,
                false),
            Producto(
                "Espejo redondo de pared F005-89 con luz cálida de 60cm x 60cm con 60cm de diámetro eléctrico 127V marco nude\n",
                "$651",
                R.drawable.h5,
                true,
                true)
        ),
    )

    fun getProductos(categoria: String): List<Producto> {
        return productosPorCategoria[categoria] ?: emptyList()
    }
}
