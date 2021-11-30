package com.centerpedia.testfinalapplicationsharivar.Repo

import com.centerpedia.testfinalapplicationsharivar.Repo.Net.RetroInterface
import com.centerpedia.testfinalapplicationsharivar.base.AppDatabase
import com.centerpedia.testfinalapplicationsharivar.model.INFMovie
import com.centerpedia.testfinalapplicationsharivar.model.MovieSearch
import javax.inject.Inject

class Repository @Inject constructor(val db: AppDatabase, val net: RetroInterface) {
    suspend fun searchMovieByTitle(title: String): MovieSearch {
        return net.searchMovieByTitle(title)
    }

    suspend fun searchMovieById(omdbId: String): INFMovie {
        return net.searchMovieByID(omdbId)
    }
}