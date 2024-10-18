package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Model.Prontuario
import com.example.myapplication.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProntuarioActivity : AppCompatActivity() {

    private lateinit var editDescricaoSintomas: EditText
    private lateinit var spinnerTipoPlano: Spinner
    private lateinit var buttonEnviarProntuario: Button
    private lateinit var buttonMenu: Button

    private val planos = arrayOf("Integral MEI", "Integral PME", "Master PME") // Tipos de plano disponíveis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prontuario) // Certifique-se de que o layout está correto

        // Inicializando os componentes do layout
        editDescricaoSintomas = findViewById(R.id.edit_descricao_sintomas)
        spinnerTipoPlano = findViewById(R.id.spinner_tipo_plano_prontuario)
        buttonEnviarProntuario = findViewById(R.id.button_enviar_prontuario)
        buttonMenu = findViewById(R.id.button_menu)

        // Configurando o adapter para o Spinner
        spinnerTipoPlano.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, planos).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Configurando o listener do botão de enviar prontuário
        buttonEnviarProntuario.setOnClickListener {
            enviarProntuario() // Chama o método para enviar o prontuário
        }

        // Configurando o listener do botão de menu
        buttonMenu.setOnClickListener { view ->
            showPopupMenu(view) // Mostra o popup menu ao clicar
        }
    }

    private fun enviarProntuario() {
        // Obtendo os valores do formulário
        val tipoPlano = spinnerTipoPlano.selectedItem.toString() // Obtendo o tipo do plano selecionado
        val descricaoSintomas = editDescricaoSintomas.text.toString() // Obtendo a descrição dos sintomas

        // Criando o objeto Prontuario
        val prontuario = Prontuario(
            tipoPlano = tipoPlano,
            descricaoSintomas = descricaoSintomas
        )

        // Chamando a API para enviar o prontuário
        RetrofitClient.api.enviarProntuario(prontuario).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ProntuarioActivity, "Prontuário enviado com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    // Não exibir mensagem de erro, apenas prosseguir
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Não exibir mensagem de erro, apenas prosseguir
            }
        })
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu) // Inflate seu menu aqui

        // Configurando o listener do popup menu
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_historico -> {
                    // Ação para o item "Histórico"
                    Toast.makeText(this, "Histórico selecionado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_contato -> {
                    // Ação para o item "Contato"
                    Toast.makeText(this, "Contato selecionado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_sair -> {
                    // Ação para o item "Sair"
                    Toast.makeText(this, "Sair selecionado", Toast.LENGTH_SHORT).show()
                    finish() // Finaliza a atividade
                    true
                }
                else -> false
            }
        }

        popupMenu.show() // Mostra o popup menu
    }
}
