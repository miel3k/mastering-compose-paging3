package com.miel3k.masteringcomposepaging3.di

import com.miel3k.masteringcomposepaging3.data.beer.remote.BeerApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Created by jmielczarek on 14/10/2022
 */
internal val networkModule = module {
    single {
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create<BeerApi>()
    }
}