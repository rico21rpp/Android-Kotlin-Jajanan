package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R

class MenuActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        actionBar?.title = "Choose Menu"
        supportActionBar?.title = "Choose Menu"

        val menuFragment = MenuFragment()
        fragmentTransaction.add(R.id.menu_fragment, menuFragment)
        fragmentTransaction.commit()
    }
}
