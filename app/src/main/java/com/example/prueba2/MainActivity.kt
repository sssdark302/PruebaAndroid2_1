package com.example.prueba2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de que el layout es correcto

        // Inicializa los botones con findViewById
        val btnAgregarClase = findViewById<Button>(R.id.btnAgregarClase)
        val btnVerHorario = findViewById<Button>(R.id.btnVerHorario)
        val btnQueToca = findViewById<Button>(R.id.btnQueToca)
        val etAsignatura = findViewById<EditText>(R.id.etAsignatura)
        val spDia = findViewById<Spinner>(R.id.spDia)
        val tpHora = findViewById<TimePicker>(R.id.tpHora)

        // Establece los listeners para cada botón
        btnAgregarClase.setOnClickListener {
            val asignatura = etAsignatura.text.toString()
            val dia = spDia.selectedItem.toString()
            val hora = "%02d:%02d".format(tpHora.hour, tpHora.minute)
            val clase = Clase(asignatura, dia, hora)

            FirebaseHelper().agregarClase(clase) { isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(this, "Clase añadida correctamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error al añadir la clase", Toast.LENGTH_SHORT).show()
                }
            }
        }


        btnVerHorario.setOnClickListener {
            startActivity(Intent(this, VerHorarioActivity::class.java))
        }

        btnQueToca.setOnClickListener {
            startActivity(Intent(this, QueTocaActivity::class.java))
        }
    }
}
