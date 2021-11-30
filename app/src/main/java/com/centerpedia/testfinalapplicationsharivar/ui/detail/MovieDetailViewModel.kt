package com.centerpedia.testfinalapplicationsharivar.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.centerpedia.testfinalapplicationsharivar.Repo.Repository
import com.centerpedia.testfinalapplicationsharivar.model.INFMovie
import com.centerpedia.testfinalapplicationsharivar.model.MyMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(val repository: Repository) : ViewModel(){
    val liveData = MutableLiveData<INFMovie>()

    fun searchMovieById(omdbId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.searchMovieById(omdbId)
            liveData.postValue(result)
        }
    }

    fun saveMovie(movieInfo: MyMovies) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.db.movieDao().saveMovieInfo(movieInfo)
        }
    }

    suspend fun isSavedMovie(imdbId: String): Boolean {
        return repository.db.movieDao().isMovieSaved(imdbId)
    }

    fun unsaveMovie(favMovie: MyMovies) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.db.movieDao().unSaveMovieInfo(favMovie)

        }
    }
}