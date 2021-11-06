package com.vk.directop.odinintentexample.city

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.odinintentexample.R

class CityAdapter(private val citiesList: List<City>) : RecyclerView.Adapter<CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val cityListItemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.city_list_item, parent, false)

        return CityViewHolder(cityListItemView)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = citiesList[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int {
        return citiesList.size
    }
}