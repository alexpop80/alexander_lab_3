package com.example.lab_3_recipe

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.lab_3_recipe.Data
import com.example.lab_3_recipe.Data.food


class RecipeViewModel : ViewModel() {


    //V might be the problem
    private val _uiState = MutableStateFlow(DescriptionUiState())
    val uiState: StateFlow<DescriptionUiState> = _uiState.asStateFlow()

    fun get_recipe_number(recipe_num: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                num = recipe_num,
                name = get_recipe_name(num = recipe_num).toString(),
                decs = get_recipe_decs(num = recipe_num).toString(),
            )
        }
    }

    fun get_recipe_name(
 num: Int = _uiState.value.num

    ): Int {
        var (x,y,z) = food[num]
      var recipe_name = x
        return recipe_name
    }

    fun get_recipe_decs(
        num: Int = _uiState.value.num

    ): Int {
        var (x,y,z) = food[num]
        var recipe_decs = y
        return recipe_decs
    }

}