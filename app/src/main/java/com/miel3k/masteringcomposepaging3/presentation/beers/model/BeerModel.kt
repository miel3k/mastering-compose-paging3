package com.miel3k.masteringcomposepaging3.presentation.beers.model

import com.miel3k.masteringcomposepaging3.data.beer.entity.Beer

/**
 * Created by jmielczarek on 16/10/2022
 */
data class BeerModel(val id: Int, val name: String, val imageUrl: String) {
    companion object {
        fun fromBeer(beer: Beer): BeerModel = BeerModel(beer.id, beer.name, beer.image_url)
    }
}
