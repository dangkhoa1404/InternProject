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

    @Query("UPDATE itemTable SET matrixName = :matrixName, rangeMinimum = :rangeMinimum, rangeMaximum = :rangeMaximum, numberOfApproval = :numberOfApproval WHERE id = :id")
    fun updateDataItem(
        id: Int,
        matrixName: String?,
        rangeMinimum: Int?,
        rangeMaximum: Int?,
        numberOfApproval: Int?
    )
}