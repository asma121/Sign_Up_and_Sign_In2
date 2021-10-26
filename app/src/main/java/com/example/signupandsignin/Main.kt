package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Main : AppCompatActivity() {
    lateinit var buSignIn:Button
    lateinit var buSignUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buSignIn=findViewById(R.id.buMainSignIn)
        buSignUp=findViewById(R.id.buMainSignUp)

        this.setTitle("Main")

        buSignIn.setOnClickListener {
            val intent=Intent(applicationContext,SignIn::class.java)
            startActivity(intent)
        }

        buSignUp.setOnClickListener {
            val intent=Intent(applicationContext,SignUp::class.java)
            startActivity(intent)
        }
    }

}