package com.iesamml.androidtraining2.features.login.data

import com.iesamml.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.iesamml.androidtraining2.features.login.domain.LoginRepository

class LoginDataRepository(private val remoteDataSource: LoginMockRemoteDataSource): LoginRepository{
    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate (userName, password)
        TODO("Not yet implemented")
    }

}