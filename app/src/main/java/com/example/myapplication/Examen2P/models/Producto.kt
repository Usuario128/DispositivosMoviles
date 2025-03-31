package com.example.myapplication.Examen2P.models

data class Producto(
    val imagen: Int,
    val destino: String,
    val TipoVuelo: String,
    val extra: String,
)

data class Categoria(
    val nombre: String,
)