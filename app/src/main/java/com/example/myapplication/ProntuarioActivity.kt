package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu

class ProntuarioActivity : AppCompatActivity() {

    private lateinit var spinnerTipoPlano: Spinner
    private lateinit var editDescricaoSintomas: EditText
    private lateinit var buttonEnviarProntuario: Button
    private lateinit var buttonMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prontuario)

        spinnerTipoPlano = findViewById(R.id.spinner_tipo_plano_prontuario)
        editDescricaoSintomas = findViewById(R.id.edit_descricao_sintomas)
        buttonEnviarProntuario = findViewById(R.id.button_enviar_prontuario)
        buttonMenu = findViewById(R.id.button_menu)

        val planos = arrayOf("Integral MEI", "Integral PME", "Master PME")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoPlano.adapter = adapter

        buttonEnviarProntuario.setOnClickListener {
            enviarProntuario()
        }

        buttonMenu.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun enviarProntuario() {
        val tipoPlano = spinnerTipoPlano.selectedItem.toString()
        val descricaoSintomas = editDescricaoSintomas.text.toString()

        if (tipoPlano.isNotEmpty() && descricaoSintomas.isNotEmpty()) {
            Toast.makeText(this, "Prontuário enviado ao dentista", Toast.LENGTH_LONG).show()
            editDescricaoSintomas.text.clear()
            spinnerTipoPlano.setSelection(0)
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_historico -> {
                    val intent = Intent(this, HistoricoActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_contato -> {
                    val intent = Intent(this, ContatoActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_sair -> {
                    val intent = Intent(this, ConfirmarSaidaActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}
