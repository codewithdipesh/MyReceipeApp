package com.example.myreceipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    val idCategoryDescription:String):Parcelable
data class  categoryResponse(val categories: List<Category>)