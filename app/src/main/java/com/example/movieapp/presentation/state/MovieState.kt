package com.example.movieapp.presentation.state

import com.example.movieapp.domain.model.MovieItem

data class MovieState(
    override val isLoading: Boolean = false,
    override val data: List<MovieItem> = emptyList(),
    override val error: String = ""
) : BaseState<List<MovieItem>>() {
}