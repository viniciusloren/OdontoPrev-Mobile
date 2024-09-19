package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmarSaidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_saida)

        val textViewConfirmacao = findViewById<TextView>(R.id.text_confirmacao)
        val buttonSim = findViewById<Button>(R.id.button_sim)
        val buttonCancelar = findViewById<Button>(R.id.button_cancelar)

        buttonSim.setOnClickListener {
            finishAffinity()
        }

        buttonCancelar.setOnClickListener {
            val intent = Intent(this, ProntuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
