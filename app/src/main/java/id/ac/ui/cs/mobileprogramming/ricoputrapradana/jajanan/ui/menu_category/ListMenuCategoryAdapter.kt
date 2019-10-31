package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.models.MenuCategory
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category.MenuCategoryViewHolder

class ListMenuCategoryAdapter(private val list: List<MenuCategory>, val clickListener: (MenuCategory) -> Unit)
    : RecyclerView.Adapter<MenuCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MenuCategoryViewHolder(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(holder: MenuCategoryViewHolder, position: Int) {
        val category: MenuCategory = list[position]
        holder.bind(category, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}