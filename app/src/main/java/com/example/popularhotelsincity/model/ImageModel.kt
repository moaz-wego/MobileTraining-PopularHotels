package com.example.popularhotelsincity.model

import com.google.gson.annotations.SerializedName

data class ImageModel (
    @SerializedName("url") val url:String,
    @SerializedName("source") val source:String,
    @SerializedName("description") val description:String
        )