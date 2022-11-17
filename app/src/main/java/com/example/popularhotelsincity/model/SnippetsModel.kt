package com.example.popularhotelsincity.model

import com.google.gson.annotations.SerializedName

data class SnippetsModel (
    @SerializedName("conceptCode")val conceptCode:String,
    @SerializedName("type") val type:String,
    @SerializedName("score")val score:Int,
    @SerializedName("sentiment")val sentiment:String,
    @SerializedName("text")val text:String,
    @SerializedName("name")val name:String
        )
