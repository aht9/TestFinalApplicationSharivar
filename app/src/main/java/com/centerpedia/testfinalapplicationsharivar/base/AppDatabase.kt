package com.centerpedia.testfinalapplicationsharivar.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.centerpedia.testfinalapplicationsharivar.Repo.Dto.MovieInfoForDao
import com.centerpedia.testfinalapplicationsharivar.model.MyMovies

@Database(entities = [MyMovies::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieInfoForDao
}