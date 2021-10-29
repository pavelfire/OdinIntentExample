package com.vk.directop.odinintentexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val KEY_ONE = "HELLO_KEY"

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val hello: String? = intent.extras?.get(KEY_ONE).toString()

        Toast.makeText(this, hello, Toast.LENGTH_LONG).show()

    }
}