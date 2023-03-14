package com.example.uistate.api

import com.example.uistate.data.TodoPhotoItem
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com"

@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

interface DemoApiService {
    @GET("/todos")
    suspend fun getTodo():List<TodoPhotoItem>
}
object DemoApi{
    val retrofitService :DemoApiService by lazy {
        retrofit.create(DemoApiService::class.java)
    }
}