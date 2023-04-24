package com.example.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.Repository
import com.example.data.network.response.Item

class MainViewModel: ViewModel() {
    private var repository: Repository = Repository()
    private var dataItem = MutableLiveData<List<Item>>()
    val dataItems: LiveData<List<Item>>
        get() = dataItem

    fun getAllItems(context : Context)  {
        Thread {
            dataItem.postValue(repository.getAllItems(context))
        }.start()
    }
    fun deleteDataItem(context: Context, item: Item) {
        Thread {
            repository.deleteDataItem(context, item)
        }.start()
    }
}