package com.centerpedia.testfinalapplicationsharivar.Repo.Net

import com.centerpedia.testfinalapplicationsharivar.model.INFMovie
import com.centerpedia.testfinalapplicationsharivar.model.MovieSearch
import retrofit2.http.GET
import retrofit2.http.Query

const val APIKEY: String = "137d5bf1"

interface RetroInterface {
    @GET("/")
    suspend fun searchMovieByTitle(
        @Query("s") name: String,
        @Query("apikey") apiKey: String = APIKEY
    ): MovieSearch

    @GET("/")
    suspend fun searchMovieByID(
        @Query("i") id: String,
        @Query("apikey") apiKey: String = APIKEY
    ): INFMovie
}