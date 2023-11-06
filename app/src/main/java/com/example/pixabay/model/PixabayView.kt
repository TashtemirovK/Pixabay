package com.example.pixabay.model


interface PixabayView {
    fun showPixabay(pixabayModel: ArrayList<ImageModel>)
    fun showError(error: String)
}