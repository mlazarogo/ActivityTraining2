package com.iesamml.androidtraining2.features.login

import com.iesamml.androidtraining2.features.login.data.LoginDataRepository
import com.iesamml.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.iesamml.androidtraining2.features.login.domain.LoginRepository
import com.iesamml.androidtraining2.features.login.domain.SignInUseCase
import com.iesamml.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory {

    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginMockRemoteDataSurce()
    private val loginRepository:LoginRepository=provideLoginDataRepository()
    private val signInUseCase: SignInUseCase = provideSignInUseCase()

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)

    }
    private fun provideLoginMockRemoteDataSurce(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()

    }

    private fun provideLoginDataRepository():LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)

    }

}