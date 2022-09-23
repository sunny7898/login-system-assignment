package com.example.loginsystemassignment

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginPreferences: SharedPreferences = getSharedPreferences("loginPref", MODE_PRIVATE)
        var userName : String = loginPreferences.getString("UserName", "NOT_LOGGED_IN").toString()
        var password: String = loginPreferences.getString("Password", "NOT_LOGGED_IN").toString()

        Log.i("MainActivity", userName)
        Log.i("MainActivity", password)

        if (userName.equals("NOT_LOGGED_IN")) {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }




    }
}