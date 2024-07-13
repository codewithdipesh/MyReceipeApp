package com.example.myreceipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navHostController: NavHostController){
    val recipeViewModel:MainViewModel = viewModel()
    val viewState by recipeViewModel.categorieState

    NavHost(navController = navHostController, startDestination =Screen.RecipeScreen.route  ){
        composable(route= Screen.RecipeScreen.route){
            RecipeScreen(
                viewState =viewState , navigateToDetail = {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("Cat",it)
                    navHostController.navigate(Screen.DetailScreen.route)
                })
        }
        composable(route= Screen.DetailScreen.route){
            val category = navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("Cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }


}