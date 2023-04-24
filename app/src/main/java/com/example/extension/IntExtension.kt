package com.example.extension

import android.text.Editable

fun Editable.convertToInt(): Int {
    return this.toString().toInt()
}