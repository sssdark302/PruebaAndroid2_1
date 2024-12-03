package com.example.prueba2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Locale

class QueTocaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que_toca)

        val tvClaseActual = findViewById<TextView>(R.id.tvClaseActual)

        val diasMap = mapOf(
            "monday" to "Lunes",
            "tuesday" to "Martes",
            "wednesday" to "Miércoles",
            "thursday" to "Jueves",
            "friday" to "Viernes",
            "saturday" to "Sábado",
            "sunday" to "Domingo"
        )

        FirebaseHelper().obtenerClasesEnTiempoReal { clases ->
            val ahora = Calendar.getInstance()

            val diaActual = ahora.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())?.lowercase()
            val diaActualEnFirebase = diasMap[diaActual] ?: diaActual
            val horaActual = "%02d:%02d".format(ahora.get(Calendar.HOUR_OF_DAY), ahora.get(Calendar.MINUTE))

            Log.d("QueTocaActivity", "Día actual (Firebase): $diaActualEnFirebase")
            Log.d("QueTocaActivity", "Hora actual: $horaActual")

            val claseActual = clases.find { it.dia == diaActualEnFirebase && it.hora == horaActual }

            tvClaseActual.text = claseActual?.let {
                "Estás en clase de ${it.asignatura}"
            } ?: "No hay clases ahora mismo"
        }
    }
}
