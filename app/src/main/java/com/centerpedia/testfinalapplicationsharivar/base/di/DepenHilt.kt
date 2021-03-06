package com.centerpedia.testfinalapplicationsharivar.base.di

import android.content.Context
import androidx.room.Room
import com.centerpedia.testfinalapplicationsharivar.Repo.Net.RetroInterface
import com.centerpedia.testfinalapplicationsharivar.base.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    fun roomProvider(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "OmdbMovies"
        ).build()
    }

    @Provides
    fun retrofitProvider(): RetroInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(RetroInterface::class.java)
    }
}