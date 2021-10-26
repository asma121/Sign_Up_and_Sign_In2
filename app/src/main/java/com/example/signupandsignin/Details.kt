package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {
    lateinit var tvInfo:TextView
    lateinit var buSignOut:Button
    var text=""
    var text2=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        tvInfo=findViewById(R.id.tvInfo)
        buSignOut=findViewById(R.id.buSignOut)

        this.setTitle("Details")
        val sname=intent.getStringExtra("name")
        val slocatin=intent.getStringExtra("location")
        val smobaile=intent.getStringExtra("mobile")

        val sname1=intent.getStringExtra("name")
        val slocatin1=intent.getStringExtra("location")
        val smobaile1=intent.getStringExtra("mobile")

        text2= "Welcome $smobaile1\nyour details: \n$sname1\n$slocatin1"
        tvInfo.text=text2

             text="Welcome $smobaile\nyour details: \n$sname\n$slocatin"
            tvInfo.text=text


        buSignOut.setOnClickListener {
            val intent= Intent(applicationContext,Main::class.java)
            startActivity(intent)
        }
    }
}