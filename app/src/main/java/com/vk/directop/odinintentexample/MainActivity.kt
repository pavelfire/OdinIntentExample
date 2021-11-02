package com.vk.directop.odinintentexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

private const val KEY_ONE = "HELLO_KEY"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt1 = findViewById<Button>(R.id.bt1)
        val bt2 = findViewById<Button>(R.id.bt2)
        val bt3 = findViewById<Button>(R.id.bt3)
        val bt4 = findViewById<Button>(R.id.bt4)
        val bt5 = findViewById<Button>(R.id.bt5)
        val bt6 = findViewById<Button>(R.id.bt6)
        val bt7 = findViewById<Button>(R.id.bt7)
        val bt8 = findViewById<Button>(R.id.bt8)

        val intent1 = Intent(this, SecondActivity::class.java)
        intent1.putExtra(KEY_ONE, "Hello from Main Activity!")

        bt1.setOnClickListener {
            startActivity(intent1)
        }

        bt2.setOnClickListener {
            //открывает браузер и переходит по ссылке
            val link = Uri.parse("https://ya.ru")
            val intent = Intent(Intent.ACTION_VIEW, link)
            //проверить может ли телефон открыть
            startActivity(intent)
        }

        bt3.setOnClickListener {
            //val intent = Intent(Intent.ACTION_GET_CONTENT)
            //intent.type = "file/*"
            val intent = Intent(Settings.ACTION_ADD_ACCOUNT)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK // в новом окне

            startActivity(intent)
        }


        //находим файл и возвращаем результат
        val intent4 = Intent(Intent.ACTION_GET_CONTENT)
        intent4.type = "file/*"
        val resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
                result ->
            if(result.resultCode == RESULT_OK){
                result.data?.data.toString() //путь к файлу
            } else {
                Toast.makeText(this, "Nothing chose", Toast.LENGTH_LONG).show()
            }
        }
        bt4.setOnClickListener {
            resultLauncher.launch(intent4)
        }
        bt5.setOnClickListener {
            val youTubelink = Uri.parse("vnd.youtube://CmZfbkv9YlQ")
            val intent = Intent(Intent.ACTION_VIEW, youTubelink)
            startActivity(intent)
        }
        val intent6 = Intent(Intent.ACTION_HEADSET_PLUG)
        if (intent6.resolveActivity(packageManager) == null){
            bt6.isEnabled = false
        }
        bt6.setOnClickListener {

        }

        val intent7 = Intent(Intent.ACTION_SEND)
        intent7.type = "text/plain"
        intent7.putExtra(Intent.EXTRA_TEXT, getString(R.string.share ))
        val chooser = Intent.createChooser(intent7, "Поделиться!")
        bt7.setOnClickListener {
            startActivity(chooser)
        }

        bt8.setOnClickListener{
            showSnackBar(it)  // it в данном выражении это bt8
        }


    }

    private fun showSnackBar(view: View) {
        Snackbar.make(this, view, "Snackbar showed", Snackbar.LENGTH_INDEFINITE)
            .setAction("Action"){
                Toast.makeText(this, "Toast from snackbar", Toast.LENGTH_LONG).show()
            }.show()
    }
}
