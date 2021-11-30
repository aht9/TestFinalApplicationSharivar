package com.centerpedia.testfinalapplicationsharivar.ui.mymovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.centerpedia.testfinalapplicationsharivar.Repo.Repository
import com.centerpedia.testfinalapplicationsharivar.model.MyMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyMovieViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    val liveData = MutableLiveData<List<MyMovies>>()

    suspend fun getFavMovies() {
        liveData.postValue(repository.db.movieDao().getAllMovies())
    }
}