package com.example.movieapp.domain.repository

import com.example.movieapp.domain.model.MovieItem

interface MovieRepository {
    suspend fun getMovieData(): List<MovieItem>
}