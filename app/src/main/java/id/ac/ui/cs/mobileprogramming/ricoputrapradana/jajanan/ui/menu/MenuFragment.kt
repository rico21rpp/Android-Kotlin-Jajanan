package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.R
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.models.Menu
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu.ListMenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    private val menu = listOf(
        Menu("baksoberanak", "Bakso Beranak", 20000),
        Menu("baksokerikil", "Bakso Kerikil", 12000),
        Menu("baksogranat", "Bakso Granat", 15000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_menu_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListMenuAdapter(menu)
        }
    }


}
