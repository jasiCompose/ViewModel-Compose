package com.example.uistate.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uistate.api.DemoApi
import com.example.uistate.data.TodoPhotoItem
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface DemoUiState{
    data class Success(val photos :List<TodoPhotoItem>):DemoUiState
    object Error:DemoUiState
    object Loading :DemoUiState
}
class DemoViewModel:ViewModel() {
    var demoUiState :DemoUiState by mutableStateOf(DemoUiState.Loading)

    init {
        getDemoResult()
    }

    private fun getDemoResult(){
        viewModelScope.launch {
            demoUiState = try {
                val listResult =DemoApi.retrofitService.getTodo()
                DemoUiState.Success(listResult)
            }catch (e:IOException){
                DemoUiState.Error
            }
            catch (e:HttpException){
                DemoUiState.Error
            }
        }
    }


}