package com.miel3k.masteringcomposepaging3.data.beer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by jmielczarek on 15/10/2022
 */
@Entity(tableName = "beers")
open class Beer(
    @PrimaryKey var id: Int = 0,
    var name: String = "",
    var image_url: String = ""
)