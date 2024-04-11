package com.sudedenizsuvar.vocaverseapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sudedenizsuvar.vocaverseapplication.R
import com.sudedenizsuvar.vocaverseapplication.databinding.LoginPageBinding
import com.sudedenizsuvar.vocaverseapplication.viewmodel.LoginViewModel

class login_page : AppCompatActivity() {
    //binding
    private lateinit var binding: LoginPageBinding
    //viewmodel
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // signIn butonuna basıldığında
        binding.loginsignup.setOnClickListener(){
            val email = binding.LoginEmailEdittext.text.toString()
            val password = binding.CreatePasswordEditText.text.toString()

            // Email ve şifre boş mu kontrolü
            if(email==null){
                binding.LoginEmailEdittext.error = "E-mail boş bırakılamaz."
                return@setOnClickListener }
            if (password==null){
                binding.CreatePasswordEditText.error= "Şifre boş bırakılamaz."
                return@setOnClickListener }

            if(email != null && password != null){
                loginViewModel.logIn(email,password)
                startActivity(Intent(this,  Profile_page::class.java))
                finish()
            }
            else{
                Toast.makeText(this, "Email'i ya da şifreyi boş geçmeyin !!!", Toast.LENGTH_SHORT).show()
            }

        }


        // signUp butonuna basıldığında
        binding.loginsignup.setOnClickListener {
            intent = Intent(applicationContext, new_user_page::class.java)
            startActivity(intent)
            // UyeGirisActivity sayfasını kapatmak için ---> finish()
            finish()
        }
    }

}