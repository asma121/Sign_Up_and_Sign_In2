package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etMobile:EditText
    lateinit var etLocation:EditText
    lateinit var etPassword:EditText
    lateinit var buSubmit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        etName=findViewById(R.id.etName)
        etMobile=findViewById(R.id.etMobile)
        etLocation=findViewById(R.id.etLocation)
        etPassword=findViewById(R.id.etPassWord)
        buSubmit=findViewById(R.id.buSubmit)

        this.setTitle("Sign Up")

        buSubmit.setOnClickListener {
            val dbhelper=DbHelper(this)
            val name=etName.text.toString()
            val mobile=etMobile.text.toString()
            val location=etLocation.text.toString()
            val password=etPassword.text.toString()
            if (name.isNotEmpty() && mobile.isNotEmpty() && location.isNotEmpty() && password.isNotEmpty()){
                val status=dbhelper.saveData(name,mobile,location,password)
                Toast.makeText(applicationContext,"data saved successfully "+status, Toast.LENGTH_LONG).show()
                val intent= Intent(applicationContext,Details::class.java)
                intent.putExtra("name",name)
                intent.putExtra("location",location)
                intent.putExtra("mobile",mobile)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Empty field",Toast.LENGTH_LONG).show()
            }
        }

    }
}