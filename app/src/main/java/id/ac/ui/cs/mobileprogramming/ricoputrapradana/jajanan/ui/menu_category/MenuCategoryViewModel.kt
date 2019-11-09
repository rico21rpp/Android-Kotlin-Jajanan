package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.ui.menu_category

import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.MenuCategory
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository.MenuCategoryRepository

class MenuCategoryViewModel(private val repository: MenuCategoryRepository): ViewModel() {

    val allCategories = repository.getAllCategories()

    suspend fun addCategory(category: MenuCategory) = repository.addCategory(category)

}