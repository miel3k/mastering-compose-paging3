package com.miel3k.masteringcomposepaging3.data.beer.local

import androidx.paging.PagingSource
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer

/**
 * Created by jmielczarek on 15/10/2022
 */
class BeerLocal(private val beerDao: BeerDao) : BeerLocalDataSource {
    override suspend fun saveBeers(beers: List<Beer>) {
        beerDao.insertBeers(beers)
    }

    override fun deleteBeers() {
        beerDao.deleteBeers()
    }

    override fun getBeersPagingSource(): PagingSource<Int, Beer> {
        return beerDao.getBeersPagingSource()
    }
}