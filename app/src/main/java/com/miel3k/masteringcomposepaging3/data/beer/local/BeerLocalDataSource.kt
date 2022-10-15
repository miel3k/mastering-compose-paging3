package com.miel3k.masteringcomposepaging3.data.beer.local

import androidx.paging.PagingSource
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer

/**
 * Created by jmielczarek on 15/10/2022
 */
interface BeerLocalDataSource {
    suspend fun saveBeers(beers: List<Beer>)
    fun deleteBeers()
    fun getBeersPagingSource(): PagingSource<Int, Beer>
}