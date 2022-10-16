package com.miel3k.masteringcomposepaging3.data.pagingkey.entity

import androidx.room.Entity
import java.util.*

/**
 * Created by jmielczarek on 16/10/2022
 */
@Entity(tableName = "pagingKey")
open class PagingKey(
    @androidx.room.PrimaryKey
    var id: String = UUID.randomUUID().toString(),
    var nextPageKey: Int = 0
)