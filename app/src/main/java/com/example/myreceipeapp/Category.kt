package com.example.myreceipeapp

data class Category(
    val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    val idCategoryDescription:String,
)

data class  categoryResponse(val categories: List<Category>)