package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.dao.MenuCategoryDao
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.dao.UserDao
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.MenuCategory
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.User

@Database(entities = [User::class, MenuCategory::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getMenuCategoryDao(): MenuCategoryDao

    companion object {

        /**
         * The instance of the AppDatabase
         * Volatile means that variable is immediately visible to all the other threads
         */
        @Volatile
        private var instance: AppDatabase? = null

        // Use LOCK to ensure we don't create two instances of AppDatabases
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "mydatabase.db"
            ).build()
    }

}