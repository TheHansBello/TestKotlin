package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.matthew.testkotlin.R
import com.example.matthew.testkotlin.model.Tutor
import com.example.matthew.testkotlin.sql.dataBaseTutor
import kotlinx.android.synthetic.main.activity_become_tutor.*

class becomeTutor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_become_tutor)

        var courseSug = arrayOf("CSC101", "CSC102", "CSC201", "CSC202", "CSC203", "CSC204", "CSC205", "CSC301", "CSC302", "CSC303", "CSC304", "CSC305", "CSC306", "CSC307", "CSC318")
        var departmentSug = arrayOf("CSC", "CHM", "MTH", "ZOO", "PLT", "SLT", "PHY", "MCB")
        var levelSug = arrayOf(100, 200, 300, 400, 500, 600)
        var facultySug = arrayOf("ART", "EDU", "SS", "NS", "AGRIC", "LAW", "MS", "PHM", "MD")

        var levelAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,levelSug)
        var courseAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,courseSug)
        var departmentAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,departmentSug)
        var facultyAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,facultySug)

        level.threshold=0
        level.setAdapter(levelAdapter)
        level.setOnFocusChangeListener { v, hasFocus -> if(hasFocus) level.showDropDown()}
        courseid.threshold=0
        courseid.setAdapter(courseAdapter)
        courseid.setOnFocusChangeListener { v, hasFocus -> if(hasFocus) courseid.showDropDown()}
        deptid.threshold=0
        deptid.setAdapter(departmentAdapter)
        deptid.setOnFocusChangeListener { v, hasFocus -> if(hasFocus) deptid.showDropDown()}
        facultyid.threshold=0
        facultyid.setAdapter(facultyAdapter)
        facultyid.setOnFocusChangeListener { v, hasFocus -> if(hasFocus) facultyid.showDropDown()}

        btnBAT.setOnClickListener({
            if(name.text.toString().length>0 && email.text.toString().length>0 && level.text.toString().length==2 && deptid.text.toString().length>0 && phoneNumber.text.toString().length>10 && facultyid.text.toString().length>0 && courseid.text.toString().length>0){

                var info = Tutor(name.text.toString(), courseid.text.toString(), email.text.toString(), phoneNumber.text.toString().toInt(), deptid.text.toString(), facultyid.text.toString(), level.text.toString().toInt())
                var db = dataBaseTutor(this)
                db.insertTData(info)
                val myToast = Toast.makeText(this, "You are Now a Tutor", Toast.LENGTH_SHORT)
                myToast.show()
                val signInIntent = Intent(this, mainActivity::class.java)

                startActivity(signInIntent)

            }else{
                Toast.makeText(this, "Fill in All Allocations to become a Tutor...", Toast.LENGTH_SHORT).show()
            }

        })


    }
}
