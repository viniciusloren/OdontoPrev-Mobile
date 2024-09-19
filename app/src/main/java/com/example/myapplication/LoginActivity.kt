package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

            val intent = Intent(this, ProntuarioActivity::class.java)
            startActivity(intent)
        }
    }
}

