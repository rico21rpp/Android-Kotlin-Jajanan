package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onLoginBtnClicked(v: View) {
        val intent: Intent = Intent(this, MenuCategoryActivity::class.java)
        startActivity(intent)
    }
}
