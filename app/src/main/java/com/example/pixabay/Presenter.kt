package com.example.pixabay

import android.util.Log
import com.example.pixabay.model.PixabayApi
import com.example.pixabay.model.PixabayModel
import com.example.pixabay.model.PixabayView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter (private var view: PixabayView) {

    private val api = PixabayService().api

    fun attachView(view: PixabayView) {
        this.view = view
    }

    fun getPixabay(keyWord:String,) {
        api.getImage(keyWord).enqueue(object : Callback<PixabayModel> {
            override fun onResponse(call: Call<PixabayModel>, response: Response<PixabayModel>) {
                if (response.isSuccessful) {
                    view.showPixabay(response.body()!!.images)
                    Log.d("denn", "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                view.showError(t.message.toString())
            }
        })
    }
}