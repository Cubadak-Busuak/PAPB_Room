package com.example.inventory.data
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}

/**
 * @Insert berfungsi untuk menambahkan item kedalam database
 * @Update berfungsi untuk mengubah isi database
 * @Detele berfungsi untuk menghapus isi database
 * @Query("SELECT * from items WHERE id = :id") mengambil satu item dari database berdasarkan id
 * @Query("SELECT * from items ORDER BY name ASC") mengambil semua item dari database
 */