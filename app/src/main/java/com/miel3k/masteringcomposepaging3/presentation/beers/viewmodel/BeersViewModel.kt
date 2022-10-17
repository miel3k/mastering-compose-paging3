package com.miel3k.masteringcomposepaging3.presentation.beers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.miel3k.masteringcomposepaging3.data.beer.BeerDataSource
import com.miel3k.masteringcomposepaging3.data.pagingkey.PagingKeyDataSource
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeerModel
import com.miel3k.masteringcomposepaging3.presentation.beers.model.BeersUiState
import com.miel3k.masteringcomposepaging3.presentation.beers.paging.BeersPagingMediator
import kotlinx.coroutines.flow.*

/**
 * Created by jmielczarek on 16/10/2022
 */
class BeersViewModel(
    private val pagingKeyRepository: PagingKeyDataSource,
    private val beerRepository: BeerDataSource
) : ViewModel() {

    private val _uiState = MutableStateFlow(BeersUiState())
    val uiState = _uiState.asStateFlow()

    @OptIn(ExperimentalPagingApi::class)
    val beerModelPagingDataFlow: Flow<PagingData<BeerModel>> by lazy {
        val config = PagingConfig(
            BEERS_PAGE_SIZE,
            initialLoadSize = BEERS_PAGE_SIZE,
            prefetchDistance = BEERS_PAGE_SIZE / 2
        )
        val mediator = BeersPagingMediator(pagingKeyRepository, beerRepository)
        val factory = { beerRepository.getBeersPagingSource() }
        Pager(config, remoteMediator = mediator, pagingSourceFactory = factory)
            .flow
            .map { it.map { beer -> BeerModel.fromBeer(beer) } }
            .cachedIn(viewModelScope)
    }

    fun onBeerTap() {
        _uiState.update {
            val newCountText = when (val newCount = it.count + 1) {
                in 1..9 -> "00$newCount"
                in 10..99 -> "0$newCount"
                else -> newCount.toString()
            }
            it.copy(count = it.count + 1, countText = newCountText)
        }
    }

    private companion object {
        const val BEERS_PAGE_SIZE = 20
    }
}