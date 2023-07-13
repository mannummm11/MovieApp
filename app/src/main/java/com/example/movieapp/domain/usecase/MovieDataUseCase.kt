package com.example.movieapp.domain.usecase

import com.example.movieapp.common.Resource
import com.example.movieapp.domain.model.MovieItem
import com.example.movieapp.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class MovieDataUseCase(private val movieRepository: MovieRepository) {

    fun getMovieData(): Flow<Resource<List<MovieItem>>> {
        return flow {
            emit(Resource.IsLoading())
            try {
                emit(Resource.Success(movieRepository.getMovieData()))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}