package id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.CURRENT_USER_ID
import id.ac.ui.cs.mobileprogramming.ricoputrapradana.jajanan.data.db.entities.User


@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser(): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(user: User): Long

}