package com.sudedenizsuvar.vocaverseapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val binding = NewUserPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Bu satır, belirli bir yaşam döngüsü sahibi (Activity veya Fragment) için ViewModel'i almak için kullanılan bir yöntemdir.
        loginViewModel = ViewModelProvider(this).get(loginViewModel::class.java)

        //GİRİŞ İŞLEMLERİ

        binding.Createbutton.setOnClickListener() {
            val email = binding.CreateNametext.text.toString()
            val password = binding.CreatePasswordEditText.text.toString()
            loginViewModel.signUp(email, password)
        }
    }
}