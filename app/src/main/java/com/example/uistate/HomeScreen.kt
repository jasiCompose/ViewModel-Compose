package com.example.uistate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uistate.data.TodoPhotoItem
import com.example.uistate.viewmodel.DemoUiState

@Composable
fun HomeScreen(
    demoUiState: DemoUiState,
    modifier: Modifier = Modifier
){
    when(demoUiState){
        is DemoUiState.Loading -> LoadingScreen(modifier)
        is DemoUiState.Success -> ResultScreen(demoUiState.photos,modifier)
        is DemoUiState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Something went Wrong")
    }


}

@Composable
fun ResultScreen(photos: List<TodoPhotoItem>, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn{
            items(photos){
                Text(text = it.title)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = it.completed.toString())
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = it.userId.toString())

                Divider()
                
                
            }
        }
    }


}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }

}
