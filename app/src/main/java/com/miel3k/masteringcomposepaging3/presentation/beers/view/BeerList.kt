package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeerModel

/**
 * Created by jmielczarek on 17/10/2022
 */
@Composable
fun BeerList(
    beersPagingItems: LazyPagingItems<BeerModel>,
    onBeerTap: () -> Unit,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
    ) {
        items(
            items = beersPagingItems,
            key = { beerModel -> beerModel.id }
        ) { beerModel ->
            if (beerModel != null) {
                BeerItem(
                    name = beerModel.name,
                    description = beerModel.id.toString(),
                    imageUrl = beerModel.imageUrl,
                    onBeerTap = onBeerTap
                )
            }
        }
    }
}