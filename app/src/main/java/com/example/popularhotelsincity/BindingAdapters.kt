package com.example.popularhotelsincity

import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.popularhotelsincity.model.APIModel
import com.example.popularhotelsincity.popularHotelOverview.PopularHotelListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data:List<APIModel>?)
{
    val adapter=recyclerView.adapter as PopularHotelListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun setImage(imgView: ImageView, model: APIModel)
{

    model.images?.get(0)?.let {
        imgView.context?.let {
            Log.d("MOAZ",model.images[0].url)
            Glide.with(imgView.context)
                .load(model.images[0].url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)
                .into(imgView)
        }
    }
}

@BindingAdapter("imageText")
fun setText(tv:TextView,model:APIModel)
{
    tv.text=model.name
}
@BindingAdapter("star")
fun setStar(ratingBar: RatingBar,model: APIModel)
{
    ratingBar.rating=model.star.toFloat()
}