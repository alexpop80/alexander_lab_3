package com.example.lab_3_recipe

 import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.lab_3_recipe.Data.food


class RecipeViewModel : ViewModel() {



    private val _uiState = MutableStateFlow(DescriptionUiState())
    val uiState: StateFlow<DescriptionUiState> = _uiState.asStateFlow()

    fun setrecipenumber(recipe_num: Int) {

        val selectedRecipe = food.find { it.third == recipe_num }
        selectedRecipe?.let {
            _uiState.update { currentState ->
                currentState.copy(
                    id = it.third,
                    name = it.first,
                    decs = it.second
                )
            }
        }
    }

    fun get_recipe_name(num: Int): Int {
        val selectedRecipe = food.find { it.third == num }
        return selectedRecipe?.first ?: R.string.recipe_not_found
    }

    fun get_recipe_decs(num: Int): Int {
        val selectedRecipe = food.find { it.third == num }
        return selectedRecipe?.second ?: R.string.desc_not_found
    }
}