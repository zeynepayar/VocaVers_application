package com.sudedenizsuvar.vocaverseapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sudedenizsuvar.vocaverseapplication.R
import com.sudedenizsuvar.vocaverseapplication.databinding.LoginPageBinding
import com.sudedenizsuvar.vocaverseapplication.viewmodel.LoginViewModel

class login_page : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: LoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Bu satır, belirli bir yaşam döngüsü sahibi (Activity veya Fragment) için ViewModel'i almak için kullanılan bir yöntemdir.
        loginViewModel= ViewModelProvider(this).get(loginViewModel::class.java)

        //GİRİŞ İŞLEMLERİ

       binding.Createbutton.setOnClickListener(){
           val email=binding.CreateNametext.text.toString()
           val password = binding.CreatePasswordEditText.text.toString()
           loginViewModel.signIn(email,password)

       }
        //yeni üyelik sayfasına gitmek için
        binding.loginsignup.setOnClickListener(){
            intent= Intent(applicationContext,new_user_page::class.java)
            startActivity(intent)
            finish()
        }
    }

}