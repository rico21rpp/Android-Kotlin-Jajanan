package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.AppDatabase
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.User
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.network.MyApi
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.network.SafeApiRequest
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val api: MyApi, private val db: AppDatabase) : SafeApiRequest() {

    /**
     * Perform network operation for login functionality asynchronously
     */
    suspend fun userLogin(email: String, password: String) : AuthResponse {
       return apiRequest { api.userLogin(email, password) }
    }

    /**
     * Perform local db operation for save a user asynchronously
     */
    suspend fun saveUser(user: User) = db.getUserDao().insertOrUpdate(user)

    /**
     * Retrieve a user data from local db
     */
    fun getUser() = db.getUserDao().getUser()



}