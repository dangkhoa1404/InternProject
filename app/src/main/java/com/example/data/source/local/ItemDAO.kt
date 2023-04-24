package com.example.data.source.local

import androidx.room.*
import com.example.data.network.response.Item

@Dao
interface ItemDAO {
    @Query("SELECT * FROM itemTable")
    fun getAllItems(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataItem(item: Item)

    @Delete
    fun deleteDataItem(item: Item)

    @Query("SELECT * FROM itemTable WHERE id = :id")
    fun getItemByID(id: Int): Item?


}