package com.sudedenizsuvar.vocaverseapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sudedenizsuvar.vocaverseapplication.R
import com.sudedenizsuvar.vocaverseapplication.databinding.LoginPageBinding
import com.sudedenizsuvar.vocaverseapplication.databinding.NewUserPageBinding
import com.sudedenizsuvar.vocaverseapplication.viewmodel.LoginViewModel

class new_user_page : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: NewUserPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewUserPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // SIGNUP butonuna basıldığında
        binding.Createbutton.setOnClickListener(){

            val email = binding.CreateEmailText.text.toString()
            val userName =binding.CreateUserNameEditText.text.toString()
            val password = binding.CreatePasswordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && userName.isNotEmpty()) {
                loginViewModel.signIn(email,userName,password)
                Toast.makeText(this, "Kayıt başarılı !!!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email'i ya da şifreyi boş geçmeyin !!!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}