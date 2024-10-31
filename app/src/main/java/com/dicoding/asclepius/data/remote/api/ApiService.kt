package com.dicoding.asclepius.data.remote.api

import com.dicoding.asclepius.data.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?q=cancer&category=health")
    fun getHealthy(@Query("apiKey")apiKey: String) : Call<NewsResponse>
}