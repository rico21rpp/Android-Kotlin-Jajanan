package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.databinding.ActivityLoginBinding
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.viewmodels.LoginActivityViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var viewmodel : LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)
        binding.vm = viewmodel
    }

    fun onLoginBtnClicked(v: View) {

        if (viewmodel.onLoginBtnClicked()) {
            val intent = Intent(this, MenuCategoryActivity::class.java)
//            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        else {
            // tampilkan dialog bahwa password salah
            Log.d("TEST: ", "username/password salah")
        }
    }

    fun onSignupBtnClicked(v: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}
