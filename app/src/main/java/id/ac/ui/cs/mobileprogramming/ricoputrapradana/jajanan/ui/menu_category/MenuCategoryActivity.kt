package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category.MenuCategoryFragment

class MenuCategoryActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()

    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_category)

        /**
         * Specifies the type of intent this component (MenuCategoryActivity) can receive.
         */
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        /**
         * Specifies the receiver and the response if an intent is received
         */
        receiver = object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, intent?.action, Toast.LENGTH_LONG).show()
            }
        }

        // register the receiver with the intent filter
        registerReceiver(receiver, filter)

        actionBar?.title = "Menu Category"
        supportActionBar?.title = "Menu Category"

        val menuCategoryFragment = MenuCategoryFragment()
        fragmentTransaction.add(R.id.menu_category_fragment, menuCategoryFragment)
        fragmentTransaction.commit()
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}
