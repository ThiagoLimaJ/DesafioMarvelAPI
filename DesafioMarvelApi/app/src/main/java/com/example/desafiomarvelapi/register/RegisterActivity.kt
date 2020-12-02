package com.example.desafiomarvelapi.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.example.desafiomarvelapi.R
import com.example.desafiomarvelapi.listadequadrinhos.view.ComicsActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var name: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var registerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val actionBar = supportActionBar
        actionBar!!.title = "Register"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>ActionBartitle </font>"))

        name = findViewById(R.id.editTextNameRegister)
        email = findViewById(R.id.editTextEmaiRegister)
        password = findViewById(R.id.editTextPasswordRegister)
        registerButton = findViewById(R.id.btnSave)

        registerButton.setOnClickListener() {
            validarRegistro()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun validarRegistro() {
        when {
            name.text.toString().isEmpty() -> {
                name.error = "Campo vazio"
            }
            email.text.toString().isEmpty() -> {
                email.error = "Campo vazio"
            }
            password.text.toString().trim().isEmpty() -> {
                password.error = "Campo vazio"
            }
            password.text.toString().trim().length < 6 -> {
                password.error = "A senha digitada deve ter pelo menos 6 caracteres"
            }
            else -> {
                val intent = Intent(this, ComicsActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Registro realizado com sucesso", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}