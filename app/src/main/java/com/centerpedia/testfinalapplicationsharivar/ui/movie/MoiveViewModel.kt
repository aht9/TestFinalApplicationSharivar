package com.centerpedia.testfinalapplicationsharivar.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.centerpedia.testfinalapplicationsharivar.Repo.Repository
import com.centerpedia.testfinalapplicationsharivar.model.MovieSearch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoiveViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    val liveData = MutableLiveData<MovieSearch>()

    fun searchMovie(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.searchMovieByTitle(title)
            liveData.postValue(result)
        }
    }
}