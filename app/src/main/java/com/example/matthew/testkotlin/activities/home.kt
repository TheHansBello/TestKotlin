package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.matthew.testkotlin.R

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun toastUp(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Welcome... Please Sign Up!", Toast.LENGTH_SHORT)
        myToast.show()

        val registerIntent = Intent(this, register::class.java)

        startActivity(registerIntent)
    }

    fun signIn(view: View){
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Welcome... Please Sign In!", Toast.LENGTH_SHORT)
        myToast.show()
        val signInIntent = Intent(this, signIn::class.java)

        startActivity(signInIntent)
    }
}
