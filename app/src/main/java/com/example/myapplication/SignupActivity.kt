package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Model.User
import com.example.myapplication.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val spinnerSexo = findViewById<Spinner>(R.id.spinner_sexo)
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
            val user = User(
                nome = editNome.text.toString(),
                sobrenome = editSobrenome.text.toString(),
                email = editEmail.text.toString(),
                senha = editSenha.text.toString(),
                dataNascimento = editDataNascimento.text.toString(),
                planoSelecionado = spinnerPlano.selectedItem.toString(),
                sexoSelecionado = spinnerSexo.selectedItem.toString(),
                cep = editCep.text.toString()
            )

            RetrofitClient.api.signup(user).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
                    finish()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
                    finish()
                }
            })
        }
    }
}
