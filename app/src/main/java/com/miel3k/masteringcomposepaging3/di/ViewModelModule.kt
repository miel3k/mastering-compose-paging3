package com.miel3k.masteringcomposepaging3.di

import com.miel3k.masteringcomposepaging3.presentation.beers.viewmodel.BeersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by jmielczarek on 16/10/2022
 */
val viewModelModule = module {
    viewModel { BeersViewModel(get(), get()) }
}