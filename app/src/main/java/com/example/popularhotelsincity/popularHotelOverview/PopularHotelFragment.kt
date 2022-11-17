package com.example.popularhotelsincity.popularHotelOverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.popularhotelsincity.databinding.FragmentPopularHotelBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [PopularHotelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PopularHotelFragment : Fragment() {

    private val viewModel:PopularHotelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding= FragmentPopularHotelBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel
        binding.popularHotelList.adapter=PopularHotelListAdapter()
        return binding.root
    }


}