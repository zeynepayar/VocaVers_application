package com.sudedenizsuvar.vocaverseapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LoginViewModel : ViewModel() {
    lateinit var auth:FirebaseAuth
    lateinit var currentUser: FirebaseUser
    var databaseReference:DatabaseReference?=null
    var database:FirebaseDatabase?=null

    // Yeni üyelik oluşturma
    fun signIn(email:String, userName:String, password:String){
        auth = FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()
        databaseReference=database?.reference!!.child("profile")


        auth.createUserWithEmailAndPassword(email.toString(), password.toString()).addOnCompleteListener() { task ->
                if (task.isSuccessful){
                    //Şuanki kullanıcı bilgilerini alalım.
                      currentUser = auth.currentUser!!
                    //Kullanıcı id'sini alıp o id adı altında userName ve E-mail kaydedilir.
                    var currentUserDb =
                        currentUser?.let { it1 -> databaseReference?.child(it1.uid) }
                    currentUserDb?.child("KullaniciAdi")?.setValue(userName.toString())
                    currentUserDb?.child("E-mail")?.setValue(email.toString())
                }
            }
    }

    // Giriş yapma
    fun logIn(email: String, password: String){
        auth = FirebaseAuth.getInstance()
        var currentUser = auth.currentUser

        if(email != null && password != null){
            // Giriş bilgilerini doğrulamak ve giriş yapmak
            auth.signInWithEmailAndPassword(email , password)
                .addOnCompleteListener{
                    /*if (it.isSuccessful){
                        intent = Intent(applicationContext, ProfilePageActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(applicationContext, "Giriş hatalı, lütfen tekrar deneyin."
                            , Toast.LENGTH_LONG).show()
                    }*/
                }
        }


    }

}
