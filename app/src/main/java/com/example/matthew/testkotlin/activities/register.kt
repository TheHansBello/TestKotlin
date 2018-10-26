package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.matthew.testkotlin.R
import com.example.matthew.testkotlin.model.User
import com.example.matthew.testkotlin.sql.dataBaseHandler
import kotlinx.android.synthetic.main.activity_register.*


class register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        btnReg.setOnClickListener({
            if(name.text.toString().length>0 && email.text.toString().length>0 && password.text.toString().length>7 && confirmPassword.text.toString().length>7 && whatsApp.text.toString().length>10){

                var info = User(name.text.toString(), password.text.toString(), email.text.toString(), whatsApp.text.toString().toInt() )
                var db = dataBaseHandler(this)
                db.insertData(info)
                val myToast = Toast.makeText(this, "Sign Up was Successful...", Toast.LENGTH_SHORT)
                myToast.show()
                val signInIntent = Intent(this, tAndC::class.java)

                startActivity(signInIntent)

            }else{
                Toast.makeText(this, "Fill in All Allocations to Register...", Toast.LENGTH_SHORT).show()
            }

        })



    }



}
