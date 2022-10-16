package com.miel3k.masteringcomposepaging3.presentation.beers.model

/**
 * Created by jmielczarek on 16/10/2022
 */
sealed class BeersError {
    object NoError : BeersError()
}
