package com.example.prueba2

import android.content.Intent
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity


val btnAgregarClase = findViewById<Button>(R.id.btnAgregarClase)
val btnVerHorario = findViewById<Button>(R.id.btnVerHorario)
val btnQueToca = findViewById<Button>(R.id.btnQueToca)

btnAgregarClase.setOnClickListener {
    startActivity(Intent(this, AddClaseActivity::class.java))
}
btnVerHorario.setOnClickListener {
    startActivity(Intent(this, VerHorarioActivity::class.java))
}

btnQueToca.setOnClickListener {
    startActivity(Intent(this, QueTocaActivity::class.java))
}
