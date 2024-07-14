package com.example.myreceipeapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel()  {

    private val _categorieState = mutableStateOf(RecipeState())
    val categorieState:State<RecipeState> = _categorieState

    //to call the network call
    init {
        fetchCategories()
    }


    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    list =response.categories,
                    error =null
                )
                Log.d("Init fetch",_categorieState.value.list.toString())

            }catch(e: Exception){
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error("error fetching Categories : ${e.message}")
                )
            }
        }
    }






   //data class
    data class RecipeState(
        val loading: Boolean = true,
        val  list: List<Category> = emptyList(),
        val error : String?= null
    )
}


