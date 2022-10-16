package com.miel3k.masteringcomposepaging3.data.pagingkey.local

import com.miel3k.masteringcomposepaging3.data.database.MasteringComposePaging3Database
import com.miel3k.masteringcomposepaging3.data.pagingkey.entity.PagingKey

/**
 * Created by jmielczarek on 16/10/2022
 */
class PagingKeyLocal(private val database: MasteringComposePaging3Database) :
    PagingKeyLocalDataSource {

    override fun getPagingKey(pagingId: String): PagingKey? =
        database.pagingKeyDao().getPagingKey(pagingId)

    override fun savePagingKey(pagingKey: PagingKey) {
        database.pagingKeyDao().insertPagingKey(pagingKey)
    }
}