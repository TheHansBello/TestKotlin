package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.matthew.testkotlin.R
import com.example.matthew.testkotlin.helper.inputValidation


class signIn : AppCompatActivity(){

   // lateinit var email : EditText;
    //lateinit var password : EditText;
    //lateinit var btnSignIn : Button;
    //lateinit var register : TextView;




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //email = findViewById(R.id.email) as EditText;
        //password = findViewById(R.id.password) as EditText;
        //btnSignIn = findViewById(R.id.password) as Button;

       // btnSignIn.setOnClickListener({
        //    if
        //})
        inputValidation(this)



    }

    fun enterOtherReg(view: View){
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Sign Up was Successful...", Toast.LENGTH_SHORT)
        myToast.show()
        val signInIntent = Intent(this, mainActivity::class.java)

        startActivity(signInIntent)
    }
}
