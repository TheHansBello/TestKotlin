package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.matthew.testkotlin.R

class tAndC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t_and_c)
    }

    fun toMain(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Thanks for Signing In!", Toast.LENGTH_SHORT)
        myToast.show()

        val goToMainIntent = Intent(this, mainActivity::class.java)

        startActivity(goToMainIntent)
    }


}
