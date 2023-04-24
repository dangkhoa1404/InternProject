package com.example.data

import android.content.Context
import com.example.data.network.response.Item
import com.example.data.source.interf.DBSource
import com.example.data.source.local.ItemDataSource

class Repository : DBSource {
    override fun getAllItems(context: Context): List<Item> {
        return ItemDataSource().getAllItems(context)
    }

    override fun insertDataItem(context: Context, item: Item) {
        return ItemDataSource().insertDataItem(context, item)
    }

    override fun deleteDataItem(context: Context, item: Item) {
        return ItemDataSource().deleteDataItem(context, item)
    }

    override fun updateDataItem(
        context: Context,
        item: Item
    ) {
        return ItemDataSource().updateDataItem(
            context,
            item
        )
    }
}