package com.example.popularhotelsincity.popularHotelOverview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popularhotelsincity.model.APIModel
import com.example.popularhotelsincity.network.WegoApi
import kotlinx.coroutines.launch


class PopularHotelViewModel : ViewModel(){

    private val _popularHotels= MutableLiveData<List<APIModel>>()
    val popularHotels:LiveData<List<APIModel>> =_popularHotels
    init {
        getPopularHotels()
    }

    private fun getPopularHotels(){
        viewModelScope.launch {
            try {


            _popularHotels.value = WegoApi.retrofitService.getPhotos("en","SGD","SG","dxb")

            }

            catch (e:Exception){
                _popularHotels.value= listOf()

            }

    }

}}