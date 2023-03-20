package com.robert.labb2

class Subscribers(

    //Subscriberklass för alla som signar upp till news
    var email: String

) {
    override fun toString(): String {
        return "Subscribers(email='$email')"
    }
}