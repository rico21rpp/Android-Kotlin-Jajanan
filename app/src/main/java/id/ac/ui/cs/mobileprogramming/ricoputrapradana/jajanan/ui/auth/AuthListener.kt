package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(msg: String)
}