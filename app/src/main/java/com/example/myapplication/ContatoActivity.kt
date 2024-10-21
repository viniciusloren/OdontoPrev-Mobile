package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        val editNome = findViewById<EditText>(R.id.edit_nome_contato)
        val editEmail = findViewById<EditText>(R.id.edit_email_contato)
        val buttonEnviar = findViewById<Button>(R.id.button_enviar_contato)
        val buttonVoltar = findViewById<Button>(R.id.button_voltar_contato)

        buttonEnviar.setOnClickListener {
            val nome = editNome.text.toString()
            val email = editEmail.text.toString()

            Toast.makeText(this, "Sucesso! Logo entraremos em contato!", Toast.LENGTH_LONG).show()

            editNome.text.clear()
            editEmail.text.clear()
        }

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}
