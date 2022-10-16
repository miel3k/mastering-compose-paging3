package com.miel3k.masteringcomposepaging3.data.pagingkey.local

import com.miel3k.masteringcomposepaging3.data.pagingkey.entity.PagingKey

/**
 * Created by jmielczarek on 16/10/2022
 */
interface PagingKeyLocalDataSource {
    fun getPagingKey(pagingId: String): PagingKey?
    fun savePagingKey(pagingKey: PagingKey)
}