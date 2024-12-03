package com.example.prueba2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Locale

class QueTocaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que_toca) // Asegúrate de que este layout es correcto

        // Vincular el TextView al ID definido en el XML
        val tvClaseActual = findViewById<TextView>(R.id.tvClaseActual)

        // Lógica para obtener la clase actual y actualizar el TextView en tiempo real
        FirebaseHelper().obtenerClasesEnTiempoReal { clases ->
            val ahora = Calendar.getInstance()
            val diaActual = ahora.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
            val horaActual = "%02d:%02d".format(ahora.get(Calendar.HOUR_OF_DAY), ahora.get(Calendar.MINUTE))

            // Busca la clase que coincida con el día y la hora actual
            val claseActual = clases.find { it.dia == diaActual && it.hora == horaActual }

            tvClaseActual.text = claseActual?.let {
                "Estás en clase de ${it.asignatura}"
            } ?: "No hay clases ahora mismo"
        }

    }
}
