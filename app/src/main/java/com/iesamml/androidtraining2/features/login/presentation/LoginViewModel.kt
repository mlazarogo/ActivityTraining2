package com.iesamml.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.iesamml.androidtraining2.features.login.domain.DeleteUsernameUseCase
import com.iesamml.androidtraining2.features.login.domain.GetUsernameUseCase
import com.iesamml.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.iesamml.androidtraining2.features.login.domain.SignInUseCase


class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val deleteUsernameUseCase: DeleteUsernameUseCase,
    private val getUsernameUseCase: GetUsernameUseCase

) : ViewModel() {


    fun validateClicked(userName: String, password: String, isRememberChecked: Boolean): Boolean {
        if (isRememberChecked) {
            saveUsernameUseCase.invoke(userName)
        }
        else{
            deleteUsernameUseCase.invoke()
        }
        return signInUseCase.invoke(userName, password)

    }
fun onResumed(): String? {
        return getUsernameUseCase.invoke()
    //val userName: String? = getUsernameUseCase.invoke()
    //username?.let {

        //Se puede usar aplly o let y depende de como se accede al valor en uno se hace con it y en otro con this
        //username no es nulo
    //}
    //}
   // if (username == null) {
        //
    //} else {

    //}
//}

   // if (username !0null{
    //    return username
    //}
    //})
}
}