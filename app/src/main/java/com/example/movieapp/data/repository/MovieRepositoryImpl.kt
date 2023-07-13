package com.example.movieapp.data.repository

import com.example.movieapp.common.toDomainMovieItem
import com.example.movieapp.data.network.APIService
import com.example.movieapp.domain.model.MovieItem
import com.example.movieapp.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(private val apiService: APIService) : MovieRepository {
    override suspend fun getMovieData(): List<MovieItem> {
        try {
            return apiService.getMovieData().map { it.toDomainMovieItem() }
        } catch (e: Exception) {
            throw e
        }
    }
}