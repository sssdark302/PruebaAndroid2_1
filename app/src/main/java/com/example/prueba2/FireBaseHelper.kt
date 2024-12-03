package com.example.prueba2

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Calendar
import java.util.Locale

class FirebaseHelper {
    private val database = FirebaseDatabase.getInstance()
    private val clasesRef = database.getReference("clases")

    fun agregarClase(clase: Clase, callback: (Boolean) -> Unit) {
        val id = clasesRef.push().key ?: return
        clasesRef.child(id).setValue(clase).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("Firebase", "Clase añadida correctamente con ID: $id")
            } else {
                Log.e("Firebase", "Error al añadir la clase: ${task.exception?.message}")
            }
            callback(task.isSuccessful)
        }
    }

    fun obtenerClases(dia: String, callback: (List<Clase>) -> Unit) {
        clasesRef.orderByChild("dia").equalTo(dia).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val clases = task.result?.children?.mapNotNull { it.getValue(Clase::class.java) } ?: emptyList()
                callback(clases)
            } else {
                callback(emptyList())
            }
        }
    }

    fun obtenerClasesEnTiempoReal(callback: (List<Clase>) -> Unit) {
        clasesRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val clases = snapshot.children.mapNotNull { it.getValue(Clase::class.java) }
                callback(clases)
            }

            override fun onCancelled(error: DatabaseError) {
                callback(emptyList()) // Devuelve una lista vacía si hay un error
            }
        })
    }


}
