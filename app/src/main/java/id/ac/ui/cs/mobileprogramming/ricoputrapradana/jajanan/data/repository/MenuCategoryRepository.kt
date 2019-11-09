package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.repository

import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.AppDatabase
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.MenuCategory

class MenuCategoryRepository(private val db: AppDatabase) {

    /**
     * Retrieve all menu category data from local db
     */
    fun getAllCategories() = db.getMenuCategoryDao().getAllCategory()

    /**
     * Perform local db operation for add a new category
     */
    suspend fun addCategory(category: MenuCategory) = db.getMenuCategoryDao().insertOrUpdate(category)

}