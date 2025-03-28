package com.example.lab_3_recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab_3_recipe.ui.theme.Lab_3_recipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Lab_3_recipeTheme {
                RecipeExplorerApp()
            }
        }
    }
}
