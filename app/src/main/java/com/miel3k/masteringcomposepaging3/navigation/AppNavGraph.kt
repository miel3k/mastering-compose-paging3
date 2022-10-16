package com.miel3k.masteringcomposepaging3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miel3k.masteringcomposepaging3.presentation.beers.view.BeersScreen

/**
 * Created by jmielczarek on 16/10/2022
 */
@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = AppNavDestinations.BEERS_ROUTE) {
        composable(AppNavDestinations.BEERS_ROUTE) {
            BeersScreen(navHostController)
        }
    }
}