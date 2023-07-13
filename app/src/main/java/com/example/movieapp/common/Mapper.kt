package com.example.movieapp.common

import com.example.movieapp.data.model.MovieItemDto
import com.example.movieapp.domain.model.MovieItem
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

fun MovieItemDto.toDomainMovieItem(): MovieItem {
    return MovieItem(
        name = this.Title,
        year = this.Year,
        runtimeInHr = this.Runtime.split(" ")[0].minuteToHour(),
        posterLink = this.Poster
    )
}

fun String.minuteToHour() = "${(this.toInt() / 60)} hour ${this.toInt() % 60} minutes"
