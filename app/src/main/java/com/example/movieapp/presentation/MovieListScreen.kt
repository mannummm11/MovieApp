package com.example.movieapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import dagger.hilt.android.lifecycle.HiltViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MovieListScreen(movieViewModel: MovieViewModel = hiltViewModel()) {
    val movieState = movieViewModel.movieState.value
    if(movieState.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if(movieState.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(movieState.error)
        }
    }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn {
            items(movieState.data.size) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    AsyncImage(
                        model = movieState.data[it].posterLink ?: "",
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp)
                            .padding(bottom = 2.dp),
                    )
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)
                        , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(text = movieState.data[it].name)
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(text = movieState.data[it].year)
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(text = movieState.data[it].runtimeInHr)
                        Spacer(modifier = Modifier.padding(4.dp))
                    }

                }
            }
        }
    }


}