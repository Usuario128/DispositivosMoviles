package com.example.myapplication.Parcial2.Tarea3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Datos(id: Int, name: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "$name -- $id")

        if (id in 1..10) {
            Text(text = "Bienvenido al Laboratorio de ISND estimado Coordinador $name")
        } else if (id in 11..100) {
            Text(text = "Permiso autorizado para el profesor $name")
        } else if (id in 101..19000) {
            Text(text = "Acceso denegado a egresados que no son de sistemas.")
        } else if (id in 19001..22210 && id != 22180) {
            Text(text = "Bienvenido $name, es un gusto verlo por aquí.")
        } else if (id == 22180) {
            Text(text = "Alumno en intercambio no es posible esté presente en el I.E.ST.")
        } else if (id in 22220..50000) {
            Text(text = "Alumno $name autorizado para uso del laboratorio.")
        } else {
            Text(text = "Este laboratorio es de uso exclusivo para la carrera ISND")

        }
    }
}