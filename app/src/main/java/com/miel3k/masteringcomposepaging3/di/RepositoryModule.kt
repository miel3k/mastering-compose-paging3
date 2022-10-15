package com.miel3k.masteringcomposepaging3.di

import com.miel3k.masteringcomposepaging3.data.beer.BeerDataSource
import com.miel3k.masteringcomposepaging3.data.beer.BeerRepository
import com.miel3k.masteringcomposepaging3.data.beer.local.BeerLocal
import com.miel3k.masteringcomposepaging3.data.beer.remote.BeerRemote
import org.koin.dsl.module

/**
 * Created by jmielczarek on 15/10/2022
 */
val repositoryModule = module {
    single<BeerDataSource> {
        val local = BeerLocal(get())
        val remote = BeerRemote(get())
        BeerRepository(local, remote)
    }
}