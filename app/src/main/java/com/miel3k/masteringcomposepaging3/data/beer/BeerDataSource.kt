package com.miel3k.masteringcomposepaging3.data.beer

import androidx.paging.PagingSource
import com.miel3k.masteringcomposepaging3.data.RepositoryResult
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer

/**
 * Created by jmielczarek on 15/10/2022
 */
interface BeerDataSource {
    suspend fun saveBeers(beers: List<Beer>)
    suspend fun deleteBeers()
    suspend fun getBeersPagingSource(): PagingSource<Int, Beer>
    suspend fun loadBeers(page: Int, perPage: Int): RepositoryResult<List<Beer>>
}