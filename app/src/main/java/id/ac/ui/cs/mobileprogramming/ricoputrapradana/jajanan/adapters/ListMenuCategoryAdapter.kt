package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.models.MenuCategory
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views.viewholders.MenuCategoryViewHolder

class ListMenuCategoryAdapter(private val list: List<MenuCategory>) : RecyclerView.Adapter<MenuCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MenuCategoryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MenuCategoryViewHolder, position: Int) {
        val category: MenuCategory = list[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        Log.d("TEST: ", "list size = " + list.size)
        return list.size
    }
}