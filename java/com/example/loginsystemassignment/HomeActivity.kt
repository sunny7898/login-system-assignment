package com.example.loginsystemassignment

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        logoutButton = findViewById(R.id.logoutButton)
        logoutButton.setOnClickListener {
            var prefereces: SharedPreferences = getSharedPreferences("loginPref", MODE_PRIVATE)
            prefereces.edit().clear()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}