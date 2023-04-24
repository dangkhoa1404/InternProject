package com.example.ui.additem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.response.Item
import com.example.extension.convertToInt
import com.example.extension.toast
import com.example.internprojectapplication.databinding.ActivityAddItemBinding
import com.example.util.AppConstants

class AddItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding
    private lateinit var viewModel: AddItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        viewModel = ViewModelProvider(this)[AddItemViewModel::class.java]
        setEventListener()
    }

    private fun setEventListener() {
        binding.run {
            imgBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            btnAddItem.setOnClickListener {
                if (edtAlias.text.isEmpty() || edtRangeMinimum.text.isEmpty() || edtRangeMaximum.text.isEmpty() || edtNumberOfApproval.text.isEmpty()) {
                    this@AddItemActivity.toast(AppConstants.WARNING_4)
                } else
                    if (edtRangeMinimum.text.convertToInt() >= edtRangeMaximum.text.convertToInt()) {
                        this@AddItemActivity.toast(AppConstants.WARNING_1)
                    } else if (edtRangeMinimum.text.convertToInt() < 0
                        || edtRangeMaximum.text.convertToInt() < 0
                    ) {
                        this@AddItemActivity.toast(AppConstants.WARNING_2)
                    } else if (edtNumberOfApproval.text.convertToInt() < 0) {
                        this@AddItemActivity.toast(AppConstants.WARNING_3)
                    } else {
                        val item = Item(
                            0,
                            edtAlias.text.toString(),
                            null,
                            edtRangeMinimum.text.convertToInt(),
                            edtRangeMaximum.text.convertToInt(),
                            edtNumberOfApproval.text.convertToInt()
                        )
                        viewModel.insertDataItem(this@AddItemActivity, item)
                        this@AddItemActivity.toast(AppConstants.ADD_SUCCESS)
                        finish()
                    }
            }
            btnReset.setOnClickListener {
                edtAlias.text.clear()
                edtRangeMinimum.text.clear()
                edtRangeMaximum.text.clear()
                edtNumberOfApproval.text.clear()
            }
        }
    }
}

