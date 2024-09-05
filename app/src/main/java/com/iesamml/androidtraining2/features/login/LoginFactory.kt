package com.iesamml.androidtraining2.features.login

import android.content.Context
import com.iesamml.androidtraining2.features.login.data.LoginDataRepository
import com.iesamml.androidtraining2.features.login.data.local.LoginXmlLocalDataSource
import com.iesamml.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.iesamml.androidtraining2.features.login.domain.DeleteUsernameUseCase
import com.iesamml.androidtraining2.features.login.domain.GetUsernameUseCase
import com.iesamml.androidtraining2.features.login.domain.LoginRepository
import com.iesamml.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.iesamml.androidtraining2.features.login.domain.SignInUseCase
import com.iesamml.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory(private val context: Context) {

    private val loginMockRemoteDataSource: LoginMockRemoteDataSource =
        provideLoginMockRemoteDataSurce()
    private val loginXmlLocalDataSource: LoginXmlLocalDataSource = provideLoginXmlLocalDataSource()

    private val loginRepository: LoginRepository = provideLoginDataRepository()
    private val signInUseCase: SignInUseCase = provideSignInUseCase()
    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUserCase()
    private val deleteUsernameUseCase: DeleteUsernameUseCase = provideDeleteUsernameUserCase()
    private val getUsernameUseCase: GetUsernameUseCase = provideGetUsernameUserCase()

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase, saveUsernameUseCase, deleteUsernameUseCase, getUsernameUseCase)

    }

    private fun provideLoginMockRemoteDataSurce(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()

    }

    private fun provideLoginDataRepository(): LoginDataRepository {
        return LoginDataRepository(loginXmlLocalDataSource, loginMockRemoteDataSource)
    }

    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)

    }

    private fun provideSaveUsernameUserCase(): SaveUsernameUseCase {
        return SaveUsernameUseCase(loginRepository)
    }
    private fun provideDeleteUsernameUserCase(): DeleteUsernameUseCase {
        return DeleteUsernameUseCase(loginRepository)
    }
    private fun provideGetUsernameUserCase(): GetUsernameUseCase {
        return GetUsernameUseCase(loginRepository)
    }

}