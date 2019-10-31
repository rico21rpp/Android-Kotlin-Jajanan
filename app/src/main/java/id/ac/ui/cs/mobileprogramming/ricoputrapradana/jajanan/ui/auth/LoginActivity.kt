package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.AppDatabase
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.User
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.network.MyApi
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository.UserRepository
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.databinding.ActivityLoginBinding
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category.MenuCategoryActivity
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    private lateinit var viewmodel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = MyApi()
        val db = AppDatabase(this)
        val repository = UserRepository(api, db)
        val factory = AuthViewModelFactory(repository)

        var binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.vm = viewmodel
        viewmodel.authListener = this

        // check if the user is logged in, then navigate to next page
        viewmodel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {
                Intent(this, MenuCategoryActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    fun onSignupBtnClicked(v: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    /**
     * Overrided here from AuthListener that called in AuthViewModel
     * if login is succeed
     */
    override fun onSuccess(user: User) {
        toast("${user.name} is logged in!")
        val intent = Intent(this, MenuCategoryActivity::class.java)
        startActivity(intent)
    }

    /**
     * Overrided here from AuthListener that called in AuthViewModel
     * if login is failed
     */
    override fun onFailure(msg: String) {
        toast("LOGIN FAILED! " + msg )
    }
}
