package com.iesamml.androidtraining2.features.login.domain

interface LoginRepository {
    fun isValid(UserName:String, password: String): Boolean
    fun saveUsername(userName:String)


}