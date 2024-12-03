package com.example.prueba2

btnGuardarClase.setOnClickListener {
    val asignatura = etAsignatura.text.toString()
    val dia = spDia.selectedItem.toString()
    val hora = "%02d:%02d".format(tpHora.hour, tpHora.minute)
    val clase = Clase(asignatura, dia, hora)

    FirebaseHelper().agregarClase(clase) {
        Toast.makeText(this, "Clase añadida", Toast.LENGTH_SHORT).show()
        finish()
    }
}
