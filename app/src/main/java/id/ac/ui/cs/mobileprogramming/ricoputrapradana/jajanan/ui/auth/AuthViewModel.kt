package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository.UserRepository

class AuthViewModel : ViewModel() {

    var username: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email/password")
            return
        }

        val loginResponse = UserRepository().userLogin(username!!, password!!)

        authListener?.onSuccess(loginResponse)
    }
}