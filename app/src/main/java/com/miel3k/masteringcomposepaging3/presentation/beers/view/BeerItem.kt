package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeerModel

/**
 * Created by jmielczarek on 17/10/2022
 */
@Composable
fun BeerItem(beerModel: BeerModel) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
    ) {
        Text(text = beerModel.name)
    }
}