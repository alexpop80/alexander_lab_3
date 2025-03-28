package com.example.lab_3_recipe

import androidx.annotation.StringRes
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class Recipe(@StringRes val title: Int){
    Start(title = R.string.app_name),
    R1(title = R.string.recipe_1)
}





@Composable
fun RecipeExplorerApp(
    viewModel: RecipeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = Recipe.valueOf(
        backStackEntry?.destination?.route ?: Recipe.Start.name
    )

    Scaffold(//add things here
 ){ innerPadding ->

   NavHost(
       navController = navController,
       startDestination = Recipe.Start.name,
       modifier = Modifier
           .fillMaxSize()
           .verticalScroll(rememberScrollState())
           .padding(innerPadding)
   ) {
       composable(route = Recipe.Start.name){
           RecipelistScreen(
               food = Data.food,
               onNextButtonClicked = {
                   viewModel.get_recipe_number(it)
                   navController.navigate(Recipe.R1.name)
               },
               modifier = Modifier
                   .fillMaxSize()
           )
       }

       composable(route = Recipe.R1.name) {
           RecipeDetailScreen(
               descriptionUiState = DescriptionUiState()
           )
       }


   }
  }
}

