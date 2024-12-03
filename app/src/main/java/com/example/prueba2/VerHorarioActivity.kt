package com.example.prueba2

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner

val spVerDia = findViewById<Spinner>(R.id.spVerDia)
val lvClases = findViewById<ListView>(R.id.lvClases)

spVerDia.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val diaSeleccionado = parent?.getItemAtPosition(position).toString()
        FirebaseHelper().obtenerClases(diaSeleccionado) { clases ->
            val adapter = ArrayAdapter(this@VerHorarioActivity, android.R.layout.simple_list_item_1, clases.map { "${it.hora}: ${it.asignatura}" })
            lvClases.adapter = adapter
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {}
}

