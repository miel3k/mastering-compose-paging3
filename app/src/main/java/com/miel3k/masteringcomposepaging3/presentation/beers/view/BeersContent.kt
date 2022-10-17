package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeerModel

/**
 * Created by jmielczarek on 16/10/2022
 */
@Composable
fun BeersContent(beersPagingItems: LazyPagingItems<BeerModel>) {
    BeerList(beersPagingItems = beersPagingItems)
}