package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository.UserRepository
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils.ApiException
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils.Coroutines

class AuthViewModel(private val repository: UserRepository) : ViewModel() {

    var username: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    // observe user table changes in local db
    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClicked(view: View) {

        if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Please fill all the fields!")
            return
        }

        // Run codes asynchronously for calling login api request
        Coroutines.main {
            try {
                val authResponse = repository.userLogin(username!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }
            catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }
}