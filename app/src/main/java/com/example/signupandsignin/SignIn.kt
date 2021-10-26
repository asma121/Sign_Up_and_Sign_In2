package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var etMobileSearch:EditText
    lateinit var etPasswordSearch:EditText
    lateinit var buSignInSearch:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        etMobileSearch=findViewById(R.id.etMobileSearch)
        etPasswordSearch=findViewById(R.id.etPasswordSearch)
        buSignInSearch=findViewById(R.id.buSignInSearch)

        this.setTitle("Sign In")

        buSignInSearch.setOnClickListener {
            val dbHelper=DbHelper(applicationContext)
            if(etMobileSearch.text.toString().isNotEmpty()&&etPasswordSearch.text.toString().isNotEmpty()){
                var userInfo=dbHelper.retrieveData(etMobileSearch.text.toString(),etPasswordSearch.text.toString())
                if (userInfo.size>1){
                    val intent= Intent(applicationContext,Details::class.java)
                    intent.putExtra("name",userInfo[0])
                    intent.putExtra("mobile",userInfo[1])
                    intent.putExtra("location",userInfo[2])
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext, userInfo[0],Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,"Empty field",Toast.LENGTH_LONG).show()
            }
        }

    }
}