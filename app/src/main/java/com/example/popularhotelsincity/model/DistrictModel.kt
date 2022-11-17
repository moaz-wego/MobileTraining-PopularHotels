package com.example.popularhotelsincity.model

import com.google.gson.annotations.SerializedName

data class DistrictModel (
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("permalink") val permalink:String,

        )
