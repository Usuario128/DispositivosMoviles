package com.example.myapplication.Parcial2.Actividad6.models

data class Producto(
    val nombre: String,
    val precio: String,
    val imagen: Int,
    val envioGratis: Boolean,
    val promocion: Boolean
)

data class Categoria(
    val nombre: String,
    val imagen: Int
)