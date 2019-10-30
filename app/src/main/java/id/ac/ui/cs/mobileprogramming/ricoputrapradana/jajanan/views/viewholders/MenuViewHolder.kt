package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.views.viewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.models.Menu

class MenuViewHolder(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.menu_list_item, parent, false)) {

    private var menuImage: ImageView? = null
    private var menuName: TextView? = null
    private var menuPrice: TextView? = null

    init {
        menuImage = itemView.findViewById(R.id.menu_image)
        menuName = itemView.findViewById(R.id.menu_name)
        menuPrice = itemView.findViewById(R.id.menu_price)
    }

    fun bind(menu: Menu, context: Context) {

//        val drawableId: Int = context.resources.getIdentifier()
        menuName?.text = menu.menuName
        menuPrice?.text = menu.menuPrice.toString()
    }
}