package com.example.maktab16.ui.secondfragmrnt

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maktab16.R
import com.example.maktab16.data.City
import com.example.maktab16.databinding.FragmentSecondBinding
import com.example.maktab16.ui.CitiesData
import com.example.maktab16.ui.CustomAdapter
import com.example.maktab16.ui.SwipeGesture

class SecondFragment : Fragment(R.layout.fragment_second),CustomAdapter.OnItemClickListener {

    lateinit var binding: FragmentSecondBinding
    lateinit var customAdapter: CustomAdapter
    val cityViewModel : CitiesData by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)


        setRecyclerView()
    }



        fun setRecyclerView() {

            val customAdapter = CustomAdapter(requireContext(), (cityViewModel.cityList.filter { it.isSelected == true   }) as MutableList<City>,this)
            binding.rvSelectedItem.adapter = customAdapter
            binding.rvSelectedItem.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            val swipeGes = object : SwipeGesture() {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    when (direction) {
                        ItemTouchHelper.RIGHT -> {

                            customAdapter.deleteItem(viewHolder.adapterPosition)

                        }
                    }
                    super.onSwiped(viewHolder, direction)
                }
            }

            val itemTouchHelper = ItemTouchHelper(swipeGes)
            itemTouchHelper.attachToRecyclerView(binding.rvSelectedItem)
        }

    override fun onItemClick(position: Int) {

    }

}