package com.example.movieapp.domain.di

import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.domain.usecase.MovieDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetMovieDataUseCase(movieRepository: MovieRepository): MovieDataUseCase {
        return MovieDataUseCase(movieRepository)
    }
}