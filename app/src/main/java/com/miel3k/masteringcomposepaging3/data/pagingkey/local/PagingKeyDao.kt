package com.miel3k.masteringcomposepaging3.data.pagingkey.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miel3k.masteringcomposepaging3.data.pagingkey.entity.PagingKey

/**
 * Created by jmielczarek on 16/10/2022
 */
@Dao
interface PagingKeyDao {
    @Query("SELECT * FROM pagingKey WHERE id = :pagingId")
    fun getPagingKey(pagingId: String): PagingKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPagingKey(pagingKey: PagingKey)
}