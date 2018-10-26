package com.example.matthew.testkotlin.model

/**
 * Created by matthew on 10/2/18.
 */

class User{

    var id : Int = 0
    var name : String = ""
    var email : String = ""
    var password : String = ""
    var whatsApp : Int = 0

    constructor(name:String,email:String,password:String,whatsApp:Int){

        this.name = name
        this.email = email
        this.password = password
        this.whatsApp = whatsApp
    }
    constructor(){}


}