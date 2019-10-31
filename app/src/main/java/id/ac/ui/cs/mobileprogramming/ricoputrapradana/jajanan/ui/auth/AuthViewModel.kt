package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var username: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email/password")
            return
        }
        authListener?.onSuccess()
    }
}