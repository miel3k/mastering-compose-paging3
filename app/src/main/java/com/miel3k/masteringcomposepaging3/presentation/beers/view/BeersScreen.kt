package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.miel3k.masteringcomposepaging3.presentation.beers.viewmodel.BeersViewModel
import com.miel3k.masteringcomposepaging3.ui.theme.WhiteSmoke
import org.koin.androidx.compose.getViewModel

/**
 * Created by jmielczarek on 16/10/2022
 */
@Composable
fun BeersScreen(navController: NavHostController, viewModel: BeersViewModel = getViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val beersPagingItems = viewModel.beerModelPagingDataFlow.collectAsLazyPagingItems()
    Scaffold(backgroundColor = WhiteSmoke) {
        BeersContent(beersPagingItems = beersPagingItems)
    }
}