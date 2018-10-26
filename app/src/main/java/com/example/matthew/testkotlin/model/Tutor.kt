package com.example.matthew.testkotlin.model

/**
 * Created by matthew on 10/5/18.
 */
class Tutor{

    var id : Int = 0
    var name : String = ""
    var email : String = ""
    var deptid : String = ""
    var phoneNumber : Int = 0
    var courseid : String = ""
    var level : Int = 0
    var facultyid : String = ""

    constructor(name:String,email:String,courseid:String,phoneNumber:Int,deptid:String,facultyid:String,level:Int){

        this.name = name
        this.email = email
        this.phoneNumber = phoneNumber
        this.courseid = courseid
        this.deptid = deptid
        this.facultyid = facultyid
        this.level = level
    }
    constructor(){}


}