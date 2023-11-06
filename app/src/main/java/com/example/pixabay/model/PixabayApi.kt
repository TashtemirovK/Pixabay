package com.example.pixabay.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    fun getImage(
        @Query("q")
        keyWord:String,
        @Query("page")
        page:Int = 1,
        @Query("per_page")
        perPage:Int = 4,
        @Query("key")
        key:String = "25007027-7418deb977c638792f4bfb99f"
    ): Call<PixabayModel>
}
// https://pixabay.com/api/?key=25007027-7418deb977c638792f4bfb99f&q=car