package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.MenuCategory

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

//    fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
//        return DataBindingUtil.inflate( LayoutInflater.from(parent.context), R.layout.menu_category_list_item, parent,false)
//    }
}