package com.miel3k.masteringcomposepaging3.data.pagingkey

import com.miel3k.masteringcomposepaging3.data.pagingkey.entity.PagingKey

/**
 * Created by jmielczarek on 16/10/2022
 */
interface PagingKeyDataSource {
    suspend fun getPagingKey(pagingId: String): PagingKey?
    suspend fun savePagingKey(pagingKey: PagingKey)
}