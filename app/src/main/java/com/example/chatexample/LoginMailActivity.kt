package com.example.chatexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class LoginMailActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var etemail: EditText
    private lateinit var etpassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_mail)

        auth = FirebaseAuth.getInstance()

        etemail = findViewById(R.id.et_email)
        etpassword = findViewById(R.id.et_password)

    }

    fun login(view: View){
        val email = etemail.text.toString()
        val password = etpassword.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

}