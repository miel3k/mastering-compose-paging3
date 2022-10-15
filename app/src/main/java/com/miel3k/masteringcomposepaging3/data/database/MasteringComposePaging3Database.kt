package com.miel3k.masteringcomposepaging3.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miel3k.masteringcomposepaging3.data.beer.local.BeerDao
import com.miel3k.masteringcomposepaging3.data.beer.model.Beer

/**
 * Created by jmielczarek on 15/10/2022
 */
@Database(entities = [Beer::class], version = 1, exportSchema = false)
abstract class MasteringComposePaging3Database : RoomDatabase() {
    abstract fun beerDao(): BeerDao
}