package com.example.prueba2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QueTocaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que_toca) // Asegúrate de que este layout es correcto

        // Vincular el TextView al ID definido en el XML
        val tvClaseActual = findViewById<TextView>(R.id.tvClaseActual)

        // Lógica para obtener la clase actual y actualizar el TextView
        FirebaseHelper().obtenerClaseActual { clase ->
            tvClaseActual.text = clase?.let {
                "Estás en clase de ${it.asignatura}"
            } ?: "No hay clases ahora mismo"
        }
    }
}
