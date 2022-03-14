package com.example.maktab16.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.maktab16.R
import com.example.maktab16.data.City

class CustomAdapter(private val context: Context,private val cityList: MutableList<City>, private val listner : OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {



    @SuppressLint("ResourceAsColor")
    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        val cityImage : ImageView
        val tvTitle : TextView
        val itemBackground : ConstraintLayout


        init {
            cityImage = itemView.findViewById(R.id.imgCity)
            tvTitle = itemView.findViewById(R.id.tvCityName)
            itemBackground = itemView.findViewById(R.id.itemBackground)
            itemView.setOnClickListener(this)

     /*       itemView.setOnClickListener {
                if (cityList[adapterPosition].isSelected){
                    itemBackground.setBackgroundColor(R.color.white)
                    cityList[adapterPosition].isSelected = false
                }else{
                    itemBackground.setBackgroundColor(R.color.purple_200)
                    cityList[adapterPosition].isSelected = true

                }

            }*/
        }




        fun bind(position: Int) {

            cityImage.setImageResource(cityList[position].cityImage)
            tvTitle.text = cityList[position].cityName

            if(cityList[position].isSelected ) {
                itemBackground.setBackgroundColor(R.color.purple_200)
            }
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listner.onItemClick(position)
            }
        }


    }
    fun deleteItem(position: Int){
        cityList[position].isSelected = false
        cityList.removeAt(position)
        notifyDataSetChanged()
    }

    fun selectItem(position: Int){

        cityList[position].isSelected = !cityList[position].isSelected
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
      return cityList.size
    }

    interface OnItemClickListener{
        fun onItemClick(position : Int)
    }


}