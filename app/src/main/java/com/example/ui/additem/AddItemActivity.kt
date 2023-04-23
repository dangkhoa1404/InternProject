package com.example.ui.additem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internprojectapplication.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setEventListener()
    }

    private fun setEventListener() {
        binding.run {
            imgBack.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}