package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.matthew.testkotlin.R

class faculty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)
    }

    fun toProcessing(view: View) {
        val goToProcessing = Intent(this, processing::class.java)

        startActivity(goToProcessing)
    }

    fun toDepartment(view: View) {
        val goToDepartment = Intent(this, department::class.java)

        startActivity(goToDepartment)
    }
}
