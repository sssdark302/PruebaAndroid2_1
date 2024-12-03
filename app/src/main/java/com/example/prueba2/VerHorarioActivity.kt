package com.example.prueba2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VerHorarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_horario)

        val spVerDia = findViewById<Spinner>(R.id.spVerDia)
        val lvClases = findViewById<ListView>(R.id.lvClases)

        val dias = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, dias)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spVerDia.adapter = adapterSpinner

        spVerDia.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val diaSeleccionado = parent?.getItemAtPosition(position).toString()
                Log.d("VerHorarioActivity", "Día seleccionado: $diaSeleccionado")

                FirebaseHelper().obtenerClases(diaSeleccionado) { clases ->
                    if (clases.isEmpty()) {
                        Toast.makeText(this@VerHorarioActivity, "No hay clases para $diaSeleccionado", Toast.LENGTH_SHORT).show()
                        lvClases.adapter = null
                    } else {
                        val adapter = ArrayAdapter(
                            this@VerHorarioActivity,
                            android.R.layout.simple_list_item_1,
                            clases.map { "${it.hora}: ${it.asignatura}" }
                        )
                        lvClases.adapter = adapter
                        Log.d("VerHorarioActivity", "Clases mostradas: ${clases.size}")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
