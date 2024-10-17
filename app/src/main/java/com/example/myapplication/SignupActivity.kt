package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val editNome = findViewById<EditText>(R.id.edit_nome)
        val editSobrenome = findViewById<EditText>(R.id.edit_sobrenome)
        val editEmail = findViewById<EditText>(R.id.edit_email)
        val editSenha = findViewById<EditText>(R.id.edit_senha)
        val editDataNascimento = findViewById<EditText>(R.id.edit_data_nascimento)
        val spinnerPlano = findViewById<Spinner>(R.id.spinner_plano)
        val spinnerSexo = findViewById<Spinner>(R.id.spinner_sexo)  // Spinner para sexo
        val editCep = findViewById<EditText>(R.id.edit_cep)
        val buttonCadastrar = findViewById<Button>(R.id.button_cadastrar)

        val planos = arrayOf("Integral MEI", "Integral PME", "Master PME")
        val adapterPlano = ArrayAdapter(this, android.R.layout.simple_spinner_item, planos)
        adapterPlano.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPlano.adapter = adapterPlano

        val sexos = arrayOf("Masculino", "Feminino", "Outro")
        val adapterSexo = ArrayAdapter(this, android.R.layout.simple_spinner_item, sexos)
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSexo.adapter = adapterSexo

        buttonCadastrar.setOnClickListener {
            val nome = editNome.text.toString()
            val sobrenome = editSobrenome.text.toString()
            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()
            val dataNascimento = editDataNascimento.text.toString()
            val planoSelecionado = spinnerPlano.selectedItem.toString()
            val sexoSelecionado = spinnerSexo.selectedItem.toString()
            val cep = editCep.text.toString()


            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
