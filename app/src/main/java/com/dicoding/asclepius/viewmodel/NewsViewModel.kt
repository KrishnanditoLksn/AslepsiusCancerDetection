package com.dicoding.asclepius.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.asclepius.BuildConfig
import com.dicoding.asclepius.data.remote.api.ApiConfig
import com.dicoding.asclepius.data.remote.response.ArticlesItem
import com.dicoding.asclepius.data.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private var _news = MutableLiveData<List<ArticlesItem?>>()
    val news: LiveData<List<ArticlesItem?>> = _news

    init {
        getHealthyNews()
    }
    private fun getHealthyNews() {
        val client = ApiConfig.getApiService().getHealthy(BuildConfig.NEWS_API_KEY)
        client.enqueue(
            object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    val responseBody = response.body()
                    if (response.isSuccessful) {
                        _news.value = responseBody?.articles
                    }
                }

                override fun onFailure(p0: Call<NewsResponse>, p1: Throwable) {
                    Toast.makeText(null, "Failed to get data", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}