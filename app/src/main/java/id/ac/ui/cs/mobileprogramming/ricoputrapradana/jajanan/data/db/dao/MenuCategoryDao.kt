package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.MenuCategory

@Dao
interface MenuCategoryDao {

    @Query("SELECT * FROM menu_category")
    fun getAllCategory(): List<MenuCategory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(category: MenuCategory)
}