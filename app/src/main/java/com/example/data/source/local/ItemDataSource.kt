package com.example.data.source.local

import android.content.Context
import com.example.data.network.response.Item
import com.example.data.source.interf.DBSource

class ItemDataSource : DBSource {
    override fun getAllItems(context: Context): List<Item> {
        return ItemDatabase.getDatabase(context).itemDAO().getAllItems()
    }

    override fun insertDataItem(context: Context, item: Item) {
        return ItemDatabase.getDatabase(context).itemDAO().insertDataItem(item)
    }

    override fun deleteDataItem(context: Context, item: Item) {
        return ItemDatabase.getDatabase(context).itemDAO().deleteDataItem(item)
    }

    override fun updateDataItem(
        context: Context,
        item: Item
    ) {
        return ItemDatabase.getDatabase(context).itemDAO().updateDataItem(
            item.id,
            item.matrixName,
            item.rangeMinimum,
            item.rangeMaximum,
            item.numberOfApproval
        )
    }
}