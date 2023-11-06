package com.example.pixabay.model

data class PixabayModel(
    var images:ArrayList<ImageModel>
)
data class ImageModel(
    var imageUrl:String,
)

