package com.iesamml.androidtraining2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context){
    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)
    private val keyUsername="key_username"
    fun saveUsername(username: String){
        val editor=sharedPref.edit()
        editor.putString("key_username",username)
        editor.commit()
    }
    fun deleteUserName(){
        val editor =sharedPref.edit()
        editor.remove("key_username")
        editor.commit()
        //método habitual en Kotlin
        //Scape Function apply
       // sharedPref.edit().apply{
        //    remove("key_username")
        //    commit()
        //}

    }
    fun getUsername(): String?{
        return sharedPref.getString(keyUsername, null);
    }


}