package com.example.roomapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class ModelEntyty(

    @PrimaryKey
    val idn: Int,
    @ColumnInfo()
    val name: String,
    val surname: String,



)
