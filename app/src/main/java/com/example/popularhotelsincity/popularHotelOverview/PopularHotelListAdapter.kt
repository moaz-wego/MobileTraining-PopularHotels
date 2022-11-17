package com.example.popularhotelsincity.popularHotelOverview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popularhotelsincity.R
import com.example.popularhotelsincity.databinding.FragmentPopularHotelBinding
import com.example.popularhotelsincity.databinding.PopularHotelBinding
import com.example.popularhotelsincity.model.APIModel

class PopularHotelListAdapter:ListAdapter<APIModel,
        PopularHotelListAdapter.HotelPhotoViewHolder>(DiffCallBack)
{



    class HotelPhotoViewHolder(private var binding: PopularHotelBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(photo: APIModel?) {
            binding.hotelInfo=photo
            binding.executePendingBindings()
        }

    }

    companion object DiffCallBack:DiffUtil.ItemCallback<APIModel>(){
        override fun areItemsTheSame(oldItem: APIModel, newItem: APIModel): Boolean {
            return oldItem.id==newItem.id

        }

        override fun areContentsTheSame(oldItem: APIModel, newItem: APIModel): Boolean {
            return oldItem.images?.get(0)?.url==newItem.images?.get(0)?.url
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelPhotoViewHolder {
        return HotelPhotoViewHolder(PopularHotelBinding.inflate(LayoutInflater.from(parent.context),parent,
            false))
    }

    override fun onBindViewHolder(holder: PopularHotelListAdapter.HotelPhotoViewHolder, position: Int) {
        val photo=getItem(position)
        holder.bind(photo)
    }
}