package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProntuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prontuario)

        // Configurar o Spinner para Tipo de Plano
        val spinnerTipoPlano = findViewById<Spinner>(R.id.spinner_tipo_plano_prontuario)
        val tiposPlanos = arrayOf("Integral MEI", "Integral PME", "Master PME")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposPlanos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoPlano.adapter = adapter

        val buttonMenu = findViewById<Button>(R.id.button_menu)
        buttonMenu.setOnClickListener { view ->
            showPopupMenu(view)
        }

        val buttonEnviarProntuario = findViewById<Button>(R.id.button_enviar_prontuario)
        buttonEnviarProntuario.setOnClickListener {
            val tipoPlano = spinnerTipoPlano.selectedItem.toString()
            val descricaoSintomas = findViewById<EditText>(R.id.edit_descricao_sintomas).text.toString()

            Toast.makeText(this, "Prontuário enviado ao dentista com sucesso", Toast.LENGTH_LONG).show()

        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        MenuInflater(this).inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
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
