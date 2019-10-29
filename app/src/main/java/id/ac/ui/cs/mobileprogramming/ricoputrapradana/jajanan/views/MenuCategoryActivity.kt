package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views.fragments.MenuCategoryFragment

class MenuCategoryActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_category)

        val menuCategoryFragment = MenuCategoryFragment()
        fragmentTransaction.add(R.id.menu_category_fragment, menuCategoryFragment)
        fragmentTransaction.commit()

    }
}
