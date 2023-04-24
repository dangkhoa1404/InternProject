package com.example.ui.main

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.response.Item
import com.example.extension.toast
import com.example.internprojectapplication.databinding.ActivityMainBinding
import com.example.internprojectapplication.databinding.DialogWarningCustomBinding
import com.example.ui.additem.AddItemActivity
import com.example.util.AppConstants

class MainActivity : AppCompatActivity(), MainAdapter.MainAdapterInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogBinding: DialogWarningCustomBinding
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

    private fun setDialogWarning(item: Item) {
        val dialog = Dialog(this)
        dialogBinding = DialogWarningCustomBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        val dialogBackground = dialog.window
        dialogBackground?.setBackgroundDrawable(ColorDrawable(0))
        dialog.setCancelable(true)
        dialog.show()
        dialogBinding.btnDismiss.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.btnContinueDelete.setOnClickListener {
            viewModel.deleteDataItem(this, item)
            this.toast(AppConstants.DELETE_SUCCESS)
            dialog.dismiss()
            viewModel.getAllItems(this)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllItems(this)
    }

    override fun deleteItem(item: Item) {
        setDialogWarning(item)
    }

    override fun updateItem(id: Int) {
        TODO("Not yet implemented")
    }

}