package com.example.data.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "itemTable")
data class Item(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("matrixName")
    val matrixName: String?,
    @SerializedName("feature")
    val feature: String?,
    @SerializedName("rangeMinimum")
    val rangeMinimum: Int?,
    @SerializedName("rangeMaximum")
    val rangeMaximum: Int?,
    @SerializedName("numberOfApproval")
    val numberOfApproval: Int?,
)
