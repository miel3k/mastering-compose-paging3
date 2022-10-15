package com.miel3k.masteringcomposepaging3.data.beer.remote

import com.miel3k.masteringcomposepaging3.data.RepositoryResult
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer
import java.io.IOException

/**
 * Created by jmielczarek on 15/10/2022
 */
class BeerRemote(private val beerApi: BeerApi) : BeerRemoteDataSource {
    override suspend fun loadBeers(
        page: Int,
        perPage: Int
    ): RepositoryResult<List<Beer>> {
        return try {
            val response = beerApi.loadBeers(page, perPage)
            if (response.isSuccessful) {
                RepositoryResult.Success(response.body().orEmpty())
            } else {
                RepositoryResult.Error(Exception(response.message()))
            }
        } catch (e: IOException) {
            RepositoryResult.Error(e)
        }
    }
}