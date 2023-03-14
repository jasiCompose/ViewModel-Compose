package com.example.uistate.data

import kotlinx.serialization.Serializable

@Serializable
data class TodoPhotoItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)