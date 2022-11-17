package com.example.popularhotelsincity.model
import com.google.gson.annotations.SerializedName

data class APIModel (
     @SerializedName("id") val id:Int,
     @SerializedName("permalink") val permalink:String,
     @SerializedName("star") val star:Int,
     @SerializedName("name") val name:String,
     @SerializedName("popularRank") val popularRank:Int,
     @SerializedName("reviews") val reviews:List<ReviewsModel>?,
     @SerializedName("images") val images:List<ImageModel>?,
     @SerializedName("district") val district:DistrictModel?
        )