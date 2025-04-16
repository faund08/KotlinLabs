package com.example.labs.data.repository

import com.example.labs.data.model.ImageItem
import com.example.labs.data.network.ApiService

class ImageRepository(private val apiService: ApiService) {
    suspend fun fetchImages(): List<ImageItem> = apiService.getImages()
}