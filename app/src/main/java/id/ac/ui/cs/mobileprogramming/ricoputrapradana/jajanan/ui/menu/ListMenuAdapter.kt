package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.models.Menu
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu.MenuViewHolder

class ListMenuAdapter(private val list: List<Menu>) : RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MenuViewHolder(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu: Menu = list[position]
        holder.bind(menu)
    }

    override fun getItemCount(): Int = list.size
}