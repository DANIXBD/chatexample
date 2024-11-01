package com.example.chatexample


import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatexample.databinding.ActivityMainBinding
import Fragments.FragmentChats
import Fragments.FragmentProfile
import Fragments.FragmentUsers
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        //if (firebaseAuth.currentUser == null){
        //    goToLogin()
       // }

        viewProfile()
        binding.bottomNV.setOnItemSelectedListener { item ->

            when(item.itemId){
                R.id.item_profile -> {
                    //Visualizar el Item PROFILE
                    viewProfile()
                    true
                }
                R.id.item_users -> {
                    //Visualizar el Item users
                    viewUsers()
                    true
                }
                R.id.item_chats -> {
                    //Visualizar el Item chats
                    viewChats()
                    true
                }
                else -> {false}
            }
        }
    }

    private fun goToLogin(){
        startActivity(Intent(applicationContext, optionsLoginActivity::class.java))
    }

    private fun viewProfile(){
        binding.tvTitle.text = "Profile"
        val fragment = FragmentProfile()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentFL.id, fragment)
        fragmentTransaction.commit()
    }

    private fun viewUsers(){
        binding.tvTitle.text = "Users"
        val fragment = FragmentUsers()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentFL.id, fragment)
        fragmentTransaction.commit()
    }

    private fun viewChats(){
        binding.tvTitle.text = "Chats"
        val fragment = FragmentChats()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmentFL.id, fragment)
        fragmentTransaction.commit()
    }


}