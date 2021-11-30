package com.centerpedia.testfinalapplicationsharivar.Repo.Dto

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.centerpedia.testfinalapplicationsharivar.model.MyMovies


@Dao
interface MovieInfoForDao {
    @Query("SELECT * FROM testMyMovies")
    suspend fun getAllMovies(): List<MyMovies>

    @Query("SELECT * FROM testMyMovies WHERE imdbId = :imdbId")
    suspend fun findById(imdbId: String): MyMovies

    @Query("SELECT EXISTS(SELECT * FROM testMyMovies WHERE imdbId = :imdbId)")
    suspend fun isMovieSaved(imdbId: String): Boolean

    @Insert(onConflict = REPLACE)
    fun saveMovieInfo(movie: MyMovies)

    @Delete
    suspend fun unSaveMovieInfo(movie: MyMovies)
}