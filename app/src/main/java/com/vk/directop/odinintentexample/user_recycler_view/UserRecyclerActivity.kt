package com.vk.directop.odinintentexample.user_recycler_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.odinintentexample.R
import com.vk.directop.odinintentexample.car_recycler.Car
import com.vk.directop.odinintentexample.car_recycler.CarAdapter

class UserRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val userNameList = listOf<String>(
            "Андрей",
            "Владимир",
            "Борис",
            "Гриша",
            "Дима",
            "Егор",
            "Женя",
            "Зиннур",
            "Константин",
            "Леонид",
            "Максим",
            "Николая",
            "Олег"
        )

        val carList: List<Car> = listOf(
            Car("Audi", "Red", 300),
            Car("BMW", "Blue", 350),
            Car("Ferrari", "White", 450),
            Car("Volga", "Red", 300),
            Car("Mers", "Black", 320),
            Car("VW", "Grey", 150),
            Car("Kia", "Yellow", 210),
            Car("Lifan", "Blue", 350),
            Car("Range Rover", "Dark green", 180)
        )

        val usersRecyclerView: RecyclerView = findViewById(R.id.users_recycler_view)
        usersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        usersRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        usersRecyclerView.adapter = UserAdapter(userNameList)
        //usersRecyclerView.adapter = CarAdapter(carList)
    }
}