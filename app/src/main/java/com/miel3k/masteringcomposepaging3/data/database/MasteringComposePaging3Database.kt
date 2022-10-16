package com.miel3k.masteringcomposepaging3.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miel3k.masteringcomposepaging3.data.beer.entity.Beer
import com.miel3k.masteringcomposepaging3.data.beer.local.BeerDao
import com.miel3k.masteringcomposepaging3.data.pagingkey.entity.PagingKey
import com.miel3k.masteringcomposepaging3.data.pagingkey.local.PagingKeyDao

/**
 * Created by jmielczarek on 15/10/2022
 */
@Database(entities = [Beer::class, PagingKey::class], version = 1, exportSchema = false)
abstract class MasteringComposePaging3Database : RoomDatabase() {
    abstract fun beerDao(): BeerDao
    abstract fun pagingKeyDao(): PagingKeyDao
}