package com.notin.momotest.data

import android.app.Activity
import android.content.Context

class ManagerData(var context: Context) {
    companion object{
        var phone = ""
    }
    var sharedPreferences = context.getSharedPreferences("users", Activity.MODE_PRIVATE)
    var editor = sharedPreferences.edit()

    fun login(phone: String, password: String):Boolean{
        var pass = sharedPreferences.getString(phone, null)
        return !(pass == null || pass != password)
    }
    fun checkPhoneExist(phone: String):Boolean{
        var pass = sharedPreferences.getString(phone, null)
        return pass != null
    }
    fun addUser(password: String){
        editor.putString(phone, password)
        editor.apply()
    }

    fun addInfoUser(name: String, email: String){
        editor.putString("name_$phone", name)
        editor.putString("email_$phone", email)
        editor.apply()
    }

    fun checkInfo():Boolean{
        var email = sharedPreferences.getString("email_$phone", null)
        return email!= null
    }




}