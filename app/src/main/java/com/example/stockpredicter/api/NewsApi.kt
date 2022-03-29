package com.example.stockpredicter.api

import com.example.stockpredicter.models.NewsData
import com.example.stockpredicter.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    @GET("everything?q=finance&apiKey=$API_KEY")
    fun getNewsData() : Call<NewsData>

}