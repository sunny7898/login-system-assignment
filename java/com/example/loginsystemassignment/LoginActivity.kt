package com.example.loginsystemassignment

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    lateinit var editTextUserName: EditText
    lateinit var editTextPassword: EditText
    lateinit var checkBoxRememberMe: CheckBox
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUserName = findViewById(R.id.editTextUserName)
        editTextPassword = findViewById(R.id.editTextPassword)
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe)
        var rememberMe: Boolean = false
        checkBoxRememberMe.setOnCheckedChangeListener { button, checkBoxState ->
            if (checkBoxState == true) {
                Log.i("LoginActivity", "Checked me!")
                rememberMe = true
            }
        }

        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            submitData(rememberMe)
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

    }

    fun submitData (rememberMe: Boolean) {
        var userName: String = editTextUserName.text.toString()
        var password: String = editTextPassword.text.toString()

        if (rememberMe == true) {
            var preferences: SharedPreferences = getSharedPreferences("loginPref", MODE_PRIVATE)
            var editor: SharedPreferences.Editor = preferences.edit()

            editor.putString("UserName", userName)
            editor.putString("Password", password)

            editor.commit()

        }
    }
}