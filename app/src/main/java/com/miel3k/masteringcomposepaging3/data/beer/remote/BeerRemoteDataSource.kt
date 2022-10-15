package com.miel3k.masteringcomposepaging3.data.beer.remote

import com.miel3k.masteringcomposepaging3.data.RepositoryResult
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer

/**
 * Created by jmielczarek on 15/10/2022
 */
interface BeerRemoteDataSource {
    suspend fun loadBeers(
        page: Int,
        perPage: Int
    ): RepositoryResult<List<Beer>>
}