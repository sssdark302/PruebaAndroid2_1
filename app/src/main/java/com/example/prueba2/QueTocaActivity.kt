package com.example.prueba2

import android.widget.TextView

val tvClaseActual = findViewById<TextView>(R.id.tvClaseActual)
FirebaseHelper().obtenerClaseActual { clase ->
    tvClaseActual.text = clase?.let
    { "Estás en clase de ${it.asignatura}" } ?: "No hay clases ahora mismo"
}
