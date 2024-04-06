package com.sudedenizsuvar.vocaverseapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel : ViewModel() {
    private val _currentUser = MutableLiveData<FirebaseUser?>()
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    fun signIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _currentUser.value = firebaseAuth.currentUser
                } else {
                    _currentUser.value = null
                    // Giriş başarısız olduğunda işlemler buraya gelebilir
                }
            }
    }

    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _currentUser.value = firebaseAuth.currentUser
                } else {
                    _currentUser.value = null
                    // Kayıt başarısız olduğunda işlemler buraya gelebilir
                }
            }
    }

    fun signOut() {
        firebaseAuth.signOut()
        _currentUser.value = null
    }
}
