package com.vk.directop.odinintentexample.city

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.vk.directop.odinintentexample.R

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(city: City){
        val name: TextView = itemView.findViewById(R.id.tv_city_name)
        val population: TextView = itemView.findViewById(R.id.tv_city_population)

        name.text = city.name
        population.text = city.population.toString()

        val linLayCity: LinearLayout = itemView.findViewById(R.id.lin_lay_city)
        linLayCity.setOnClickListener {
            //Snackbar.make(itemView, "erere", Snackbar.LENGTH_LONG)

            Toast.makeText(itemView.context,
                "City: ${name}, population: ${population}",
                Toast.LENGTH_LONG).show()

            Log.d("MyTag", "Pressed ${name}")
        }
    }
}