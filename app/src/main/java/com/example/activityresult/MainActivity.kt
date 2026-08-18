package com.example.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView

    // Forma moderna recomendada de reemplazo de startActivityForResult()
    private val lanzadorSegundaActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { resultado ->
        if (resultado.resultCode == Activity.RESULT_OK) {
            val nombre = resultado.data?.getStringExtra("NOMBRE_USUARIO") ?: ""
            tvResultado.text = "Nombre de usuario: $nombre"
            Toast.makeText(this, "Dato recibido correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResultado = findViewById(R.id.tvResultado)
        val btnSolicitarNombre = findViewById<Button>(R.id.btnSolicitarNombre)

        btnSolicitarNombre.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            lanzadorSegundaActivity.launch(intent)

            // Alternativa clásica (obsoleta desde API 30):
            // startActivityForResult(intent, 100)
        }
    }
}
