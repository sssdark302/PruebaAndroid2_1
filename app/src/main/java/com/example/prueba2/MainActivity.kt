package com.example.prueba2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de que el layout es correcto

        // Inicializa los botones con findViewById
        val btnAgregarClase = findViewById<Button>(R.id.btnAgregarClase)
        val btnVerHorario = findViewById<Button>(R.id.btnVerHorario)
        val btnQueToca = findViewById<Button>(R.id.btnQueToca)

        // Establece los listeners para cada botón
        btnAgregarClase.setOnClickListener {
            startActivity(Intent(this, AddClaseActivity::class.java))
        }

        btnVerHorario.setOnClickListener {
            startActivity(Intent(this, VerHorarioActivity::class.java))
        }

        btnQueToca.setOnClickListener {
            startActivity(Intent(this, QueTocaActivity::class.java))
        }
    }
}
