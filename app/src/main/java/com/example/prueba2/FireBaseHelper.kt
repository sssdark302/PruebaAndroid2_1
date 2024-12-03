package com.example.prueba2

import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar
import java.util.Locale

class FirebaseHelper {
    private val database = FirebaseDatabase.getInstance()
    private val clasesRef = database.getReference("clases")

    fun agregarClase(clase: Clase, onComplete: () -> Unit) {
        val id = clasesRef.push().key ?: return
        clasesRef.child(id).setValue(clase).addOnCompleteListener {
            onComplete()
        }
    }

    fun obtenerClases(dia: String, callback: (List<Clase>) -> Unit) {
        clasesRef.orderByChild("dia").equalTo(dia).get().addOnSuccessListener { snapshot ->
            val clases = snapshot.children.mapNotNull { it.getValue(Clase::class.java) }
            callback(clases)
        }
    }

    fun obtenerClaseActual(callback: (Clase?) -> Unit) {
        val ahora = Calendar.getInstance()
        val diaActual = ahora.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
        val horaActual = "%02d:%02d".format(ahora.get(Calendar.HOUR_OF_DAY), ahora.get(Calendar.MINUTE))

        val databaseRef = FirebaseDatabase.getInstance().getReference("clases")
        databaseRef.orderByChild("dia").equalTo(diaActual).get().addOnSuccessListener { snapshot ->
            val claseActual = snapshot.children.mapNotNull { it.getValue(Clase::class.java) }
                .find { it.hora == horaActual }
            callback(claseActual)
        }
    }

}
