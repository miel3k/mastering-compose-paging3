package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeerModel
import com.miel3k.masteringcomposepaging3.ui.theme.TangerineYellow

/**
 * Created by jmielczarek on 16/10/2022
 */
@Composable
fun BeersContent(beersPagingItems: LazyPagingItems<BeerModel>) {
    Box(
        modifier = Modifier
            .background(
                color = TangerineYellow,
                shape = RoundedCornerShape(bottomStart = 50f, bottomEnd = 50f),
            )
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Tap to taste!")

        }
    }
    BeerList(
        modifier = Modifier.padding(top = 150.dp),
        beersPagingItems = beersPagingItems
    )
}