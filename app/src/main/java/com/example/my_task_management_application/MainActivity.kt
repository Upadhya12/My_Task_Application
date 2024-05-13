package com.example.my_task_management_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    val mainIntent = Intent(this@MainActivity, HomeTaskActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            }
        }
        thread.start()
    }


}
