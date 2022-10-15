package com.miel3k.masteringcomposepaging3.di

import androidx.room.Room
import com.miel3k.masteringcomposepaging3.data.database.MasteringComposePaging3Database
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by jmielczarek on 15/10/2022
 */
val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MasteringComposePaging3Database::class.java,
            "mastering_compose_paging3.db"
        ).build()
    }
    single {
        get<MasteringComposePaging3Database>().beerDao()
    }
}