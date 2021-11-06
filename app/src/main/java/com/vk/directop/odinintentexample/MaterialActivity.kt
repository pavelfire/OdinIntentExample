package com.vk.directop.odinintentexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MaterialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        val fab = findViewById<FloatingActionButton>(R.id.floating_action_button)

        topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Snackbar.make(findViewById(android.R.id.content),
                        "I like it!",
                        Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {

                    true
                }
                R.id.save -> {
                    Snackbar.make(findViewById(android.R.id.content),
                        "Successfully saved",
                        Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.upload -> {
                    Snackbar.make(findViewById(android.R.id.content),
                        "Successfully loaded",
                        Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.delete_all -> {
                    Snackbar.make(findViewById(android.R.id.content),
                        "All data was removed",
                        Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.about -> {
                    Snackbar.make(findViewById(android.R.id.content),
                        "Pavel make this great app! Like and subscribe!",
                        Snackbar.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        fab.setOnClickListener {
            val link = Uri.parse("https://play.google.com/store/apps/developer?id=Pavel+Vasilevich&hl=ru&gl=US")
            val intent = Intent(Intent.ACTION_VIEW, link)
            //проверить может ли телефон открыть
            startActivity(intent)
        }
    }


}