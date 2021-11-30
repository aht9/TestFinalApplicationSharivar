package com.centerpedia.testfinalapplicationsharivar.base.di

import androidx.room.Room
import com.centerpedia.testfinalapplicationsharivar.base.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "OmdbMovies"
        ).allowMainThreadQueries().build()

    }
}