package com.example.pixabay

import com.example.pixabay.model.PixabayApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PixabayService {
    var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com").addConverterFactory(GsonConverterFactory.create()).build()
    var api = retrofit.create(PixabayApi::class.java)
}