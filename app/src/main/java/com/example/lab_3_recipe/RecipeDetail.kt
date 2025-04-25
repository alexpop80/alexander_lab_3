package com.example.lab_3_recipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun RecipeDetailScreen(
    descriptionUiState: DescriptionUiState
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = stringResource(descriptionUiState.name))
        Text("")
        Text(text = stringResource(descriptionUiState.decs))

    }
}