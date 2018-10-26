package com.example.matthew.testkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matthew.testkotlin.R
import com.example.matthew.testkotlin.sql.dataBaseHandler
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var db= dataBaseHandler(this)
        var data = db.readData()
        name.text= ""

        for (i in 0..data.size-1){
            name.append(data.get(i).id.toString() + "" + data.get(i).name + "" + data.get(i).email + "" + data.get(i).whatsApp)
        }





    }
}
