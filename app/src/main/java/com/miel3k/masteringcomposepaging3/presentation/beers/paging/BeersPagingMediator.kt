package com.miel3k.masteringcomposepaging3.presentation.beers.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.miel3k.masteringcomposepaging3.data.RepositoryResult
import com.miel3k.masteringcomposepaging3.data.beer.BeerDataSource
import com.miel3k.masteringcomposepaging3.data.beer.entity.Beer
import com.miel3k.masteringcomposepaging3.data.pagingkey.PagingKeyDataSource
import com.miel3k.masteringcomposepaging3.data.pagingkey.entity.PagingKey

/**
 * Created by jmielczarek on 16/10/2022
 */
@OptIn(ExperimentalPagingApi::class)
class BeersPagingMediator(
    private val pagingKeyRepository: PagingKeyDataSource,
    private val beerRepository: BeerDataSource
) : RemoteMediator<Int, Beer>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Beer>): MediatorResult {
        val key = when (loadType) {
            LoadType.REFRESH -> INITIAL_KEY
            LoadType.PREPEND -> return MediatorResult.Success(true)
            LoadType.APPEND -> pagingKeyRepository.getPagingKey(BEERS_PAGING_ID)?.nextPageKey
                ?: return MediatorResult.Success(true)
        }
        val pageSize = state.config.pageSize
        return when (val result = beerRepository.loadBeers(key, pageSize)) {
            is RepositoryResult.Success -> {
                savePage(loadType, result.data)
                saveNextKey(key)
                MediatorResult.Success(result.data.isEmpty())
            }
            is RepositoryResult.Error -> MediatorResult.Error(result.exception)
        }
    }

    private suspend fun savePage(
        loadType: LoadType,
        beers: List<Beer>
    ) = if (loadType == LoadType.REFRESH) {
        beerRepository.deleteBeers()
        beerRepository.saveBeers(beers)
    } else {
        beerRepository.saveBeers(beers)
    }

    private suspend fun saveNextKey(key: Int) {
        val newPagingKey = PagingKey().apply {
            id = BEERS_PAGING_ID
            nextPageKey = key + 1
        }
        pagingKeyRepository.savePagingKey(newPagingKey)
    }

    private companion object {
        const val INITIAL_KEY = 1
        const val BEERS_PAGING_ID = "beers"
    }
}