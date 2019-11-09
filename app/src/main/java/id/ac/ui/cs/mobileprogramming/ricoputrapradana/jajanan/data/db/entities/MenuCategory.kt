package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_category")
data class MenuCategory(@PrimaryKey val category: String)