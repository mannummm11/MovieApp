package com.example.movieapp.presentation.state

abstract class BaseState<T> {
    abstract val isLoading: Boolean
    abstract val data: T
    abstract val error: String
}