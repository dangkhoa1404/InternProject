package com.example.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.response.Item
import com.example.internprojectapplication.databinding.ActivityMainBinding
import com.example.ui.additem.AddItemActivity

class MainActivity : AppCompatActivity(), MainAdapter.MainAdapterInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var listItems = mutableListOf<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        setDataItems()
        setEventListener()

        viewModel.getAllItems(this)
    }

    private fun setEventListener() {
        binding.run {
            btnAdd.setOnClickListener {
                val intent = Intent(this@MainActivity, AddItemActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setDataItems() {
        viewModel.dataItems.observe(this) {
            listItems.run {
                clear()
                addAll(it)
            }
            binding.rvListItem.adapter = MainAdapter(this@MainActivity, listItems)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllItems(this)
    }

    override fun deleteItem(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateItem(id: Int) {
        TODO("Not yet implemented")
    }

}