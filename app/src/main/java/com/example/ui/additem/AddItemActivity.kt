package com.example.ui.additem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.response.Item
import com.example.extension.convertToInt
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
                if (edtRangeMinimum.text.isEmpty() || edtRangeMaximum.text.isEmpty() || edtNumberOfApproval.text.isEmpty()) {
                    Toast.makeText(
                        this@AddItemActivity,
                        AppConstants.WARNING_4,
                        Toast.LENGTH_SHORT
                    ).show()
                } else
                    if (edtRangeMinimum.text.convertToInt() >= edtRangeMaximum.text.convertToInt()) {
                        Toast.makeText(
                            this@AddItemActivity,
                            AppConstants.WARNING_1,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (edtRangeMinimum.text.convertToInt() < 0
                        || edtRangeMaximum.text.convertToInt() < 0
                    ) {
                        Toast.makeText(
                            this@AddItemActivity,
                            AppConstants.WARNING_2,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (edtNumberOfApproval.text.convertToInt() < 0) {
                        Toast.makeText(
                            this@AddItemActivity,
                            AppConstants.WARNING_3,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val item = Item(
                            0,
                            null,
                            null,
                            edtRangeMinimum.text.convertToInt(),
                            edtRangeMaximum.text.convertToInt(),
                            edtNumberOfApproval.text.convertToInt()
                        )
                        viewModel.insertDataItem(this@AddItemActivity, item)
                        Toast.makeText(
                            this@AddItemActivity,
                            AppConstants.ADD_SUCCESS,
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }

            }
        }
    }

}

