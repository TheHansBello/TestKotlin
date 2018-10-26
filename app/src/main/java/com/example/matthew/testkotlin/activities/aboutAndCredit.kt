package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.matthew.testkotlin.R

class aboutAndCredit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_and_credit)
    }
    fun toMain(view: View) {

        val goToProcessing = Intent(this, mainActivity::class.java)

        startActivity(goToProcessing)
    }

}
