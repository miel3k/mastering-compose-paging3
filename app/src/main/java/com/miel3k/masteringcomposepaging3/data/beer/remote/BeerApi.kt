package com.miel3k.masteringcomposepaging3.data.beer.remote

import com.miel3k.masteringcomposepaging3.data.beer.model.Beer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jmielczarek on 15/10/2022
 */
interface BeerApi {
    @GET("/beers")
    suspend fun loadBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<Beer>>
}