package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.matthew.testkotlin.R

class peerTutoring : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peer_tutoring)


    }

    fun getTutor(view: View){

        val enterAbout = Intent(this, contactTutor::class.java)

        startActivity(enterAbout)
    }

    fun becomeTutor(view: View){

        val enterAbout = Intent(this, becomeTutor::class.java)

        startActivity(enterAbout)
    }

}
