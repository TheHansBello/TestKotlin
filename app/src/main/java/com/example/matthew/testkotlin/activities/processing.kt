package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.matthew.testkotlin.R

class processing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_processing)
    }

    fun toMain(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Chose another Faculty", Toast.LENGTH_SHORT)
        myToast.show()
        val goToProcessing = Intent(this, faculty::class.java)

        startActivity(goToProcessing)
    }


}
