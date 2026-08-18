package com.example.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        btnEnviar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Escriba un nombre antes de enviar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val resultIntent = Intent().apply {
                putExtra("NOMBRE_USUARIO", nombre)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        btnCancelar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
