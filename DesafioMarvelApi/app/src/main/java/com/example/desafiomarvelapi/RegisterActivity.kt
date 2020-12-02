package com.example.desafiomarvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        name = findViewById(R.id.editTextNameRegister)
        email = findViewById(R.id.editTextEmaiRegister)
        password = findViewById(R.id.editTextPasswordRegister)
        registerButton = findViewById(R.id.btnSave)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}