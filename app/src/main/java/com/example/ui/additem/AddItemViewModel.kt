package com.example.ui.additem

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.data.Repository
import com.example.data.network.response.Item

class AddItemViewModel : ViewModel() {
    private var repository: Repository = Repository()

    fun insertDataItem(context: Context, item: Item) {
        Thread {
            repository.insertDataItem(context, item)
        }.start()
    }
}