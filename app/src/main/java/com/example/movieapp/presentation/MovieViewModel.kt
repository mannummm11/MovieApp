package com.example.movieapp.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.common.Resource
import com.example.movieapp.domain.model.MovieItem
import com.example.movieapp.domain.usecase.MovieDataUseCase
import com.example.movieapp.presentation.state.BaseState
import com.example.movieapp.presentation.state.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieDataUseCase: MovieDataUseCase
    ) : ViewModel() {

    private val _movieState =  mutableStateOf<BaseState<List<MovieItem>>>(MovieState())
    val movieState: State<BaseState<List<MovieItem>>> get() = _movieState

    init {
        //getMovieData()
    }

     fun getMovieData() {
         viewModelScope.launch {
             movieDataUseCase.getMovieData().onEach {
                 delay(3000)
                 when(it) {
                     is Resource.Success -> {
                         it.data?.let { data-> _movieState.value = MovieState(data = data) }
                     }
                     is Resource.Error -> {
                         _movieState.value = MovieState(error = it.error.toString())
                     }
                     is Resource.IsLoading -> {
                         _movieState.value = MovieState(isLoading = true)
                     }
                 }
             }.launchIn(viewModelScope)
         }
    }
}