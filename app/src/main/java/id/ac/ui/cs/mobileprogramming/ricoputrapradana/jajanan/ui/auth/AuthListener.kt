package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.User

interface AuthListener {
    fun onSuccess(user: User)
    fun onFailure(msg: String)
}