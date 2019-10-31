package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository.UserRepository
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils.Coroutines

class AuthViewModel : ViewModel() {

    var username: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email/password")
            return
        }

        Coroutines.main {
            val response = UserRepository().userLogin(username!!, password!!)
            if (response.isSuccessful) {
                authListener?.onSuccess(response.body()?.user!!)
            }
            else {
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }
    }
}