package com.example.chatexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class optionsLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_options_login)

        val btnNavigate = findViewById<Button>(R.id.optionEmail)

        btnNavigate.setOnClickListener {
            val intent = Intent(this, LoginMailActivity::class.java)
            startActivity(intent)
        }
    }

}