package com.example.prueba2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddClaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_clase)

        // Vincula las vistas
        val etAsignatura = findViewById<EditText>(R.id.etAsignatura)
        val spDia = findViewById<Spinner>(R.id.spDia)
        val tpHora = findViewById<TimePicker>(R.id.tpHora)
        val btnGuardarClase = findViewById<Button>(R.id.btnGuardarClase)

        // Configura el TimePicker
        tpHora.setIs24HourView(true)

        // Configura el Spinner
        val dias = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDia.adapter = adapter

        // Botón para guardar la clase
        btnGuardarClase.setOnClickListener {
            val asignatura = etAsignatura.text.toString()
            val dia = spDia.selectedItem?.toString() ?: "Día no seleccionado"
            val hora = "%02d:%02d".format(tpHora.hour, tpHora.minute)

            if (asignatura.isBlank()) {
                Toast.makeText(this, "Por favor, ingresa una asignatura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val clase = Clase(asignatura, dia, hora)
            FirebaseHelper().agregarClase(clase) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(this, "Clase añadida correctamente", Toast.LENGTH_SHORT).show()
                    finish() // Cierra la actividad
                } else {
                    Toast.makeText(this, "Error al añadir la clase", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
