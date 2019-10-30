package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.models.MenuCategory
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views.MenuActivity
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.adapters.ListMenuCategoryAdapter
import kotlinx.android.synthetic.main.fragment_menu_category.*

class MenuCategoryFragment : Fragment() {

    private val categories = listOf(
        MenuCategory("FOOD"),
        MenuCategory("DRINK")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu_category, container, false)
    }

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_menu_category_recycler_view.apply {
            // set a LinearLayoutManager to handle Android RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)

            // set the custom adapter to the RecyclerView as well as the custom click listener
            adapter = ListMenuCategoryAdapter(categories, { menuCategory: MenuCategory -> onCategoryClicked(menuCategory)})
        }
    }

    private fun onCategoryClicked(menuCategory: MenuCategory) {
        val intent = Intent(activity, MenuActivity::class.java)
        startActivity(intent)
    }
}
