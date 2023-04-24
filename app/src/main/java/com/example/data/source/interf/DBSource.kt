package com.example.data.source.interf

import android.content.Context
import com.example.data.network.response.Item

interface DBSource {
    fun getAllItems(context: Context): List<Item>
    fun insertDataItem(context: Context, item: Item)
    fun deleteDataItem(context: Context, item: Item)
    fun updateDataItem(context: Context, item: Item)
}