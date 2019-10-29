package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginActivityViewModel : ViewModel() {

    var username: String? = null
    var password: String? = null

    fun onLoginBtnClicked() {
        Log.d("TEST: ", username + " - " + password)
    }
}