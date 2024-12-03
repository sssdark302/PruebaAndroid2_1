package com.example.prueba2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddClaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_clase) // Asegúrate de que este layout es correcto

        // Vincula los elementos del layout a las variables
        val btnGuardarClase = findViewById<Button>(R.id.btnGuardarClase)
        val etAsignatura = findViewById<EditText>(R.id.etAsignatura)
        val spDia = findViewById<Spinner>(R.id.spDia)
        val tpHora = findViewById<TimePicker>(R.id.tpHora)

        // Configura el TimePicker para el formato 24 horas
        tpHora.setIs24HourView(true)

        // Configura el Spinner con los días de la semana
        val dias = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDia.adapter = adapter

        // Configura el botón para guardar la clase
        btnGuardarClase.setOnClickListener {
            val asignatura = etAsignatura.text.toString()
            val dia = spDia.selectedItem.toString()
            val hora = "%02d:%02d".format(tpHora.hour, tpHora.minute)
            val clase = Clase(asignatura, dia, hora)

            // Guarda la clase en Firebase
            FirebaseHelper().agregarClase(clase) {
                Toast.makeText(this, "Clase añadida", Toast.LENGTH_SHORT).show()
                finish() // Cierra la actividad
            }
        }
    }
}
