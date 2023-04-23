package com.example.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internprojectapplication.databinding.ActivityMainBinding
import com.example.ui.additem.AddItemActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setEventListener()
    }

    private fun setEventListener() {
        binding.run {
            btnAdd.setOnClickListener {
                val intent = Intent(this@MainActivity, AddItemActivity::class.java)
                startActivity(intent)
            }
        }
    }
}