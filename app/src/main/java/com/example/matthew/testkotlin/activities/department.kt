package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.matthew.testkotlin.R

class department : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)
    }
    fun toCS(view: View) {
        val goToDepartment = Intent(this, csCourses::class.java)

        startActivity(goToDepartment)
    }
    fun toMCB(view: View) {
        val goToDepartment = Intent(this, mcbCourses::class.java)

        startActivity(goToDepartment)
    }
    fun toSLT(view: View) {
        val goToDepartment = Intent(this, sltCourses::class.java)

        startActivity(goToDepartment)
    }
    fun toMTH(view: View) {
        val goToDepartment = Intent(this, mthCourses::class.java)

        startActivity(goToDepartment)
    }
    fun toCHM(view: View) {
        val goToDepartment = Intent(this, chmCourses::class.java)

        startActivity(goToDepartment)
    }
    fun toPHY(view: View) {
        val goToDepartment = Intent(this, phyCourses::class.java)

        startActivity(goToDepartment)
    }
    fun toZOO(view: View) {
        val goToDepartment = Intent(this, zooCourses::class.java)

        startActivity(goToDepartment)
    }
}
