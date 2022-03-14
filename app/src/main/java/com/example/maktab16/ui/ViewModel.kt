package com.example.maktab16.ui

import androidx.lifecycle.ViewModel
import com.example.maktab16.R
import com.example.maktab16.data.City

class CitiesData : ViewModel() {



    val cityList = mutableListOf(
        City("Cahabahar","05437", R.drawable.chabahar),
        City("Tehran","05437", R.drawable.tehran,),
        City("Esfahan","05437", R.drawable.esfahan,),
        City("Qazvin","05437", R.drawable.qazvin),
        City("Mashhad","05437", R.drawable.mash),
        City("Tabriz","05437", R.drawable.tabriz),
        City("Shiraz","05437", R.drawable.shiraz)
    )



}