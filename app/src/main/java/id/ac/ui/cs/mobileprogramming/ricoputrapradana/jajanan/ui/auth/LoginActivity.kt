package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.databinding.ActivityLoginBinding
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category.MenuCategoryActivity
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    private lateinit var viewmodel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.vm = viewmodel
        viewmodel.authListener = this
    }

    fun onSignupBtnClicked(v: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    /**
     * Overrided here from AuthListener that called in AuthViewModel
     * if login is succeed
     */
    override fun onSuccess() {
        toast("LOGIN SUCCESS!")
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
