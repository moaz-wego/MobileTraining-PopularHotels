package com.example.popularhotelsincity.model

import com.google.gson.annotations.SerializedName

data class ReviewsModel (
    @SerializedName("id") val score:Int,
    @SerializedName("count") val count:Int,
    @SerializedName("percentage") val percentage:Int,
    @SerializedName("reviewerGroup") val reviewerGroup:String,
    @SerializedName("snippets") val snippets:List<SnippetsModel>
        )