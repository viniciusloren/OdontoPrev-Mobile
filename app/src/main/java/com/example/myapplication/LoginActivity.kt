package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val linkSignup = findViewById<TextView>(R.id.link_signup)
        linkSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        val buttonLogin = findViewById<Button>(R.id.button_login)
        buttonLogin.setOnClickListener {
            val email = findViewById<EditText>(R.id.email_login).text.toString()
            val password = findViewById<EditText>(R.id.password_login).text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val credentials = mapOf(
                "email" to email,
                "senha" to password
            )

            try {
                RetrofitClient.api.login(credentials).enqueue(object : retrofit2.Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        startActivity(Intent(this@LoginActivity, ProntuarioActivity::class.java))
                        finish()
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        startActivity(Intent(this@LoginActivity, ProntuarioActivity::class.java))
                        finish()
                    }
                })
            } catch (e: Exception) {
            }
        }

    }
}
