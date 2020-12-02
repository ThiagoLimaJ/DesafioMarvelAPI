package com.example.desafiomarvelapi.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafiomarvelapi.R
import com.example.desafiomarvelapi.listadequadrinhos.view.ComicsActivity
import com.example.desafiomarvelapi.register.RegisterActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var buttonCreateAccount: MaterialButton
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonCreateAccount = findViewById(R.id.btnCreateAccount)
        buttonLogin = findViewById(R.id.btnLogin)
        email = findViewById(R.id.editTextEmailLogin)
        password = findViewById(R.id.editTextPasswordLogin)


        buttonCreateAccount.setOnClickListener(){
            val intent =Intent(this,
                RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener() {
            verificaCamposLogin(email, password)
        }
    }

    private fun verificaCamposLogin(email: TextInputEditText, password: TextInputEditText) {
        when {
            email.text.toString().isEmpty() -> {
                email.error = "Campo email vazio"
            }
            password.text.toString().isEmpty() -> {
                password.error = "Campo password vazio"
            }
            password.text.toString().trim().length < 6 -> {
                password.error = "A senha deve ter pelo menos 6 caracteres"
            }
            else -> {
                val intent = Intent(this, ComicsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}