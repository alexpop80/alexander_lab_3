package com.example.lab_3_recipe

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp



@Composable
fun RecipelistScreen(
    food: List<Triple<Int, Int, Int>>,
    onNextButtonClicked: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        food.forEach { item ->
            recipe_button(
                labelResourceId = item.first,
                labelResourceId2 = item.second,
                onClick = { onNextButtonClicked(item.third) },
                modifier = Modifier.fillMaxWidth(),
            )
        }

    }
}

@Composable
fun recipe_button(
    @StringRes labelResourceId: Int,
    @StringRes labelResourceId2: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 250.dp)
    ) {
        Text(stringResource(labelResourceId))
        Text(stringResource(labelResourceId2))
    }
}