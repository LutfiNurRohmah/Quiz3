package com.lutfi.quiz3.data.retrofit

import com.lutfi.quiz3.data.response.ApiResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/photos")
    fun getItem(): Call<List<ApiResponseItem>>
}