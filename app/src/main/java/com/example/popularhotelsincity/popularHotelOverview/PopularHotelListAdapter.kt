package com.example.popularhotelsincity.popularHotelOverview

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popularhotelsincity.R
import com.example.popularhotelsincity.databinding.FragmentPopularHotelBinding
import com.example.popularhotelsincity.databinding.PopularHotelBinding
import com.example.popularhotelsincity.detailedScreen.DetailedHotelScreen
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

        holder.itemView.setOnClickListener{

            val context=holder.itemView.context
            val intent=Intent(context,DetailedHotelScreen::class.java)
            intent.putExtra("pic", photo.images?.get(0)?.url.toString())
            intent.putExtra("name",photo.name)
            intent.putExtra("star",photo.star)
            if(photo.reviews?.get(0)?.score==null)
            {
                intent.putExtra("score",-1)
            }
            else
            {
                intent.putExtra("score",photo.reviews?.get(0)?.score)
            }

            context.startActivity(intent)


        }
        holder.bind(photo)
    }
}