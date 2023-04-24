package com.example.ui.updateitem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internprojectapplication.databinding.ActivityUpdateItemBinding

class UpdateItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}