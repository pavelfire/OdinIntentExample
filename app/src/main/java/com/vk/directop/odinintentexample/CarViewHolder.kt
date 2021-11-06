package com.vk.directop.odinintentexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(car: Car){
        val tvBrand: TextView = itemView.findViewById(R.id.brand_text_view)
        val tvColor: TextView = itemView.findViewById(R.id.color_text_view)
        val tvMaxSpeed: TextView = itemView.findViewById(R.id.speed_text_view)

        tvBrand.text = car.brand
        tvColor.text = car.color

        val speedFormat = "${car.maxSpeed} км/ч"
        tvMaxSpeed.text = speedFormat

    }
}