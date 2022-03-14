package com.example.maktab16.ui.firstfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maktab16.R
import com.example.maktab16.databinding.ActivityMainBinding
import com.example.maktab16.databinding.FragmentFirstBinding
import com.example.maktab16.ui.CitiesData
import com.example.maktab16.ui.CustomAdapter
import com.example.maktab16.ui.SwipeGesture

class FirstFragment : Fragment(R.layout.fragment_first), CustomAdapter.OnItemClickListener {

    lateinit var binding: FragmentFirstBinding
    lateinit var customAdapter: CustomAdapter
    val cityViewModel: CitiesData by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        customAdapter = CustomAdapter(requireContext(),cityViewModel.cityList,this)
        makeRecyclerView()

    }

    fun makeRecyclerView() {

        binding.rvAllItem.adapter = customAdapter
        binding.rvAllItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }



    override fun onItemClick(position: Int) {


        if (cityViewModel.cityList[position].isSelected){
            cityViewModel.cityList[position].isSelected = false

        }else{
            cityViewModel.cityList[position].isSelected = true
        }


        customAdapter.notifyDataSetChanged()
    }




}