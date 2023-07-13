package com.example.movieapp.data.network

import com.example.movieapp.data.model.MovieDto
import com.example.movieapp.data.model.MovieItemDto
import retrofit2.http.GET

interface APIService {

    @GET("fake-movies-api/movies")
    suspend fun getMovieData(): List<MovieItemDto>
}