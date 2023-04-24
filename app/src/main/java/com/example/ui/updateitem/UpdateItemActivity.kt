package com.example.ui.updateitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.data.network.response.Item
import com.example.extension.convertToInt
import com.example.extension.toast
import com.example.internprojectapplication.databinding.ActivityUpdateItemBinding
import com.example.util.AppConstants

class UpdateItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateItemBinding
    private lateinit var viewModel: UpdateItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@UpdateItemActivity)[UpdateItemViewModel::class.java]
        val itemData = intent.getSerializableExtra(AppConstants.TRANSFER_DATA) as Item
        binding.run {
            edtAlias.setText(itemData.matrixName)
            edtRangeMinimum.setText(itemData.rangeMinimum.toString())
            edtRangeMaximum.setText(itemData.rangeMaximum.toString())
            edtNumberOfApproval.setText(itemData.numberOfApproval.toString())
        }
        setEventListener(itemData.id)
    }

    private fun setEventListener(id: Int) {
        binding.run {
            imgBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }

            btnUpdateItem.setOnClickListener {
                if (edtAlias.text.isEmpty() || edtRangeMinimum.text.isEmpty() || edtRangeMaximum.text.isEmpty() || edtNumberOfApproval.text.isEmpty()) {
                    this@UpdateItemActivity.toast(AppConstants.WARNING_4)
                } else
                    if (edtRangeMinimum.text.convertToInt() >= edtRangeMaximum.text.convertToInt()) {
                        this@UpdateItemActivity.toast(AppConstants.WARNING_1)
                    } else if (edtRangeMinimum.text.convertToInt() < 0
                        || edtRangeMaximum.text.convertToInt() < 0
                    ) {
                        this@UpdateItemActivity.toast(AppConstants.WARNING_2)
                    } else if (edtNumberOfApproval.text.convertToInt() < 0) {
                        this@UpdateItemActivity.toast(AppConstants.WARNING_3)
                    } else {
                        val item = Item(
                            id,
                            edtAlias.text.toString(),
                            null,
                            edtRangeMinimum.text.convertToInt(),
                            edtRangeMaximum.text.convertToInt(),
                            edtNumberOfApproval.text.convertToInt()
                        )
                        viewModel.updateDataItem(this@UpdateItemActivity, item)
                        this@UpdateItemActivity.toast(AppConstants.UPDATE_SUCCESS)
                        finish()
                    }
            }
        }
    }
}