package com.example.ui.updateitem

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.data.Repository
import com.example.data.network.response.Item

class UpdateItemViewModel : ViewModel() {
    private var repository: Repository = Repository()

    fun updateDataItem(
        context: Context,
        item: Item
    ) {
        Thread {
            repository.updateDataItem(context, item)
        }.start()
    }
}