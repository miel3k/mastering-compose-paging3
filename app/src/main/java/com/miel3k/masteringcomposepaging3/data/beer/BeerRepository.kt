package com.miel3k.masteringcomposepaging3.data.beer

import androidx.paging.PagingSource
import com.miel3k.masteringcomposepaging3.data.RepositoryResult
import com.miel3k.masteringcomposepaging3.data.beer.entity.Beer
import com.miel3k.masteringcomposepaging3.data.beer.local.BeerLocalDataSource
import com.miel3k.masteringcomposepaging3.data.beer.remote.BeerRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by jmielczarek on 15/10/2022
 */
class BeerRepository(
    private val local: BeerLocalDataSource,
    private val remote: BeerRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : BeerDataSource {
    override suspend fun saveBeers(beers: List<Beer>) {
        withContext(dispatcher) { local.saveBeers(beers) }
    }

    override suspend fun deleteBeers() {
        withContext(dispatcher) { local.deleteBeers() }
    }

    override fun getBeersPagingSource(): PagingSource<Int, Beer> {
        return local.getBeersPagingSource()
    }

    override suspend fun loadBeers(page: Int, perPage: Int): RepositoryResult<List<Beer>> {
        return withContext(dispatcher) { remote.loadBeers(page, perPage) }
    }
}