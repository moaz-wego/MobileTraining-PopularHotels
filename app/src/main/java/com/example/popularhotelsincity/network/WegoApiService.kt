package com.example.popularhotelsincity.network

import com.example.popularhotelsincity.model.APIModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL="https://srv.wegostaging.com/hotels/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface WegoApiService{

    @GET("hotels") // explore other
    suspend fun getPhotos(@Query("locale") language:String,
                          @Query("currency_code") currency:String,
                          @Query("site_code") site:String,
                          @Query("city_code") city:String):List<APIModel>

}

object WegoApi{
    val retrofitService:WegoApiService by lazy{
        retrofit.create(WegoApiService::class.java)
    }
}