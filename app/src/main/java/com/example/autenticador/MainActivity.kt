package com.example.autenticador

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = Firebase.auth

        Log.i(TAG, "OnCreate usuario atual: ${auth.currentUser}")

        auth.createUserWithEmailAndPassword(
            "maria.peixoto1@example-magazine.com",
            "123456"
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i(TAG, "onCreate: Sucesso")
            } else {
                Log.e(TAG, "onCreate: Falha", task.exception)
            }
        }
    }
}