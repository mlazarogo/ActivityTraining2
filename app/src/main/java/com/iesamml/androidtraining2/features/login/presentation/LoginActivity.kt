package com.iesamml.androidtraining2.features.login.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.iesamml.androidtraining2.R
import com.iesamml.androidtraining2.features.login.LoginFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel : LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //enableEdgeToEdge()
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/


    }
    private fun setupView(){
        val actionValidate = findViewById<Button>(R.id.action_validate)
        actionValidate.setOnClickListener {
           val userName = findViewById<EditText>(R.id.input_username).text.toString()
           val password = findViewById<EditText>(R.id.input_password).text.toString()
            val remerberIsChecked=findViewById<CheckBox>(R.id.check_remember).isChecked
            val isValid=loginViewModel.validateClicked(userName,password)
            if (isValid) {
                Snackbar.make (findViewById<View>(R.id.main),
                                            R.string.message_login_ok,
                                             Snackbar.LENGTH_SHORT).show()
            }else {
                Snackbar.make (findViewById<View>(R.id.main),
                    R.string.message_login_fails,
                    Snackbar.LENGTH_SHORT).show()
            }
        }


    }

}