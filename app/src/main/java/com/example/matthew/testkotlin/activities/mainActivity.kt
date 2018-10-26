package com.example.matthew.testkotlin.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.matthew.testkotlin.R
import com.example.matthew.testkotlin.sql.dataBaseHandler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*

class mainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = dataBaseHandler(this)

        btnPro.setOnClickListener({
            var data = db.readData()
            name.text = ""
            for (i in 0..(data.size-1)){
                name.append(data.get(i).id.toString() + "\n " + data.get(i).name + "\n " + data.get(i).email + "\n " + data.get(i).whatsApp)
            }



        })

    }

    fun course(view: View){
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Enter Faculty", Toast.LENGTH_SHORT)
        myToast.show()
        val enterFaculty = Intent(this, faculty::class.java)

        startActivity(enterFaculty)
    }
    fun about(view: View){

        val enterAbout = Intent(this, aboutAndCredit::class.java)

        startActivity(enterAbout)
    }

    fun profile(view: View){

        val enterAbout = Intent(this, profile::class.java)

        startActivity(enterAbout)
    }

    fun peerTutor(view: View){

        val enterAbout = Intent(this, peerTutoring::class.java)

        startActivity(enterAbout)
    }

    fun settings(view: View){

        val enterAbout = Intent(this, appsettings::class.java)

        startActivity(enterAbout)
    }


      //  val webIntent: Intent = Uri.parse("http://www.whatsapp.com").let { webpage ->
        //    Intent(Intent.ACTION_VIEW, webpage)

// Verify it resolves
          //  val activities: List<ResolveInfo> = packageManager.queryIntentActivities(
            //        intent,
              //      PackageManager.MATCH_DEFAULT_ONLY
            //)
           // val isIntentSafe: Boolean = activities.isNotEmpty()
// Start an activity if it's safe
            //if (isIntentSafe) {
              //  startActivity(webIntent)
            //}



}
