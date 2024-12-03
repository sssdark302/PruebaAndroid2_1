package com.example.prueba2

FirebaseHelper().obtenerClaseActual { clase ->
    tvClaseActual.text = clase?.let { "Estás en clase de ${it.asignatura}" } ?: "No hay clases ahora mismo"
}
