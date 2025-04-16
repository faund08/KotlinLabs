package com.example.labs.data.network

import com.example.labs.data.model.ImageItem
import retrofit2.http.GET

interface ApiService {
    @GET("list") // використовуємо сервіс https://picsum.photos/v2/list
    suspend fun getImages(): List<ImageItem>
}