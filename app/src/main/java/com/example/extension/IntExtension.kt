package com.example.extension

import android.content.Context
import android.text.Editable
import android.widget.Toast

fun Editable.convertToInt(): Int {
    return this.toString().toInt()
}

fun Context.toast(content: String){
    Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
}