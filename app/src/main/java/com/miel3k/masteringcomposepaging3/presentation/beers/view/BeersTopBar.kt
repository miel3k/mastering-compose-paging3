package com.miel3k.masteringcomposepaging3.presentation.beers.view

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.miel3k.masteringcomposepaging3.R

/**
 * Created by jmielczarek on 17/10/2022
 */
@Composable
fun BeersTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {}
    )
}