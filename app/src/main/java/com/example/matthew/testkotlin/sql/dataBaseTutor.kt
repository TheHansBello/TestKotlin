package com.example.matthew.testkotlin.sql

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.matthew.testkotlin.model.Tutor

/**
 * Created by matthew on 10/5/18.
 */


val DATABASE_TUTOR = "TutorManager"
val TABLE_TUTOR = "Tutor"
val TABLE_TUTEE = "Tutee"
val COL_TNAME = "tutor_name"
val COL_TID = "tutor_id"
val COL_TEMAIL = "tutor_email"
val COL_TNUM = "tutor_number"
val COL_TDEPT = "tutor_dept"
val COL_TCOURSE = "tutor_course"
val COL_TFACULTY = "tutor_faculty"
val COL_TLEVEL = "tutor_level"
val COL_TeNAME = "tutor_name"
val COL_TeID = "tutor_id"
val COL_TeEMAIL = "tutor_email"
val COL_TeNUM = "tutor_number"
val COL_TeDEPT = "tutor_dept"
val COL_TeCOURSE = "tutor_course"
val COL_TeFACULTY = "tutor_faculty"
val COL_TeLEVEL = "tutor_level"

class dataBaseTutor(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1){

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = ("CREATE TABLE" + TABLE_TUTOR + "("
                + COL_TID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TNAME + " TEXT," + COL_TEMAIL + " TEXT," + COL_TDEPT + " TEXT," + COL_TNUM + " INTEGER," + COL_TCOURSE + " TEXT," + COL_TFACULTY + " TEXT," + COL_TLEVEL + " NUM" +")")

        db?.execSQL(createTable)

        val createTableT = ("CREATE TABLE" + TABLE_TUTEE + "("
                + COL_TeID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TeNAME + " TEXT," + COL_TeEMAIL + " TEXT," + COL_TeDEPT + " TEXT," + COL_TeNUM + " INTEGER," + COL_TeCOURSE + " TEXT," + COL_TeFACULTY + " TEXT," + COL_TeLEVEL + " NUM" +")")

        db?.execSQL(createTableT)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    fun insertTData(tutor: Tutor){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_TNAME, tutor.name)
        cv.put(COL_TEMAIL, tutor.email)
        cv.put(COL_TDEPT, tutor.deptid)
        cv.put(COL_TNUM,tutor.phoneNumber)
        cv.put(COL_TCOURSE, tutor.courseid)
        cv.put(COL_TFACULTY, tutor.facultyid)
        cv.put(COL_TLEVEL, tutor.level)

        db.insert(TABLE_TUTOR, null,cv)

    }

    fun readTData() : MutableList<Tutor>{

        var list : MutableList<Tutor> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_USER
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var tutor = Tutor()
                tutor.id = result.getString(result.getColumnIndex(COL_TID)).toInt()
                tutor.name = result.getString(result.getColumnIndex(COL_TNAME))
                tutor.email = result.getString(result.getColumnIndex(COL_TEMAIL))
                tutor.phoneNumber = result.getString(result.getColumnIndex(COL_TNUM)).toInt()
                tutor.courseid = result.getString(result.getColumnIndex(COL_TCOURSE))
                tutor.deptid = result.getString(result.getColumnIndex(COL_TDEPT))
                tutor.facultyid = result.getString(result.getColumnIndex(COL_TFACULTY))
                tutor.level = result.getString(result.getColumnIndex(COL_TLEVEL)).toInt()
                list.add(tutor)


            }while (result.moveToFirst())
        }

        result.close()
        db.close()


        return list

    }


    fun insertTeData(tutee: Tutor){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_TeNAME, tutee.name)
        cv.put(COL_TeEMAIL, tutee.email)
        cv.put(COL_TeDEPT, tutee.deptid)
        cv.put(COL_TeNUM,tutee.phoneNumber)
        cv.put(COL_TeCOURSE, tutee.courseid)
        cv.put(COL_TeFACULTY, tutee.facultyid)
        cv.put(COL_TeLEVEL, tutee.level)

        db.insert(TABLE_TUTEE, null,cv)

    }


}