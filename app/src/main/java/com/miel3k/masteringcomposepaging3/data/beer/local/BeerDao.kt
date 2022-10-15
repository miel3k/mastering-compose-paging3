package com.miel3k.masteringcomposepaging3.data.beer.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer

/**
 * Created by jmielczarek on 15/10/2022
 */
@Dao
interface BeerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBeers(beers: List<Beer>)

    @Query("DELETE FROM beers")
    fun deleteBeers()

    @Query("SELECT * FROM beers")
    fun getBeersPagingSource(): PagingSource<Int, Beer>
}