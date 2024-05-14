package com.example.my_task_management_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_task_management_application.databinding.ActivityHomeTaskActvityBinding


class HomeTaskActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeTaskActvityBinding
    private lateinit var db: TaskDatabaseHelper
    private lateinit var tasksAdapter: TasksAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTaskActvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)
        tasksAdapter = TasksAdapter(db.getAllTasks(), this)

        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter = tasksAdapter

        binding.addButton.setOnClickListener {
            val  intent =   Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        tasksAdapter.refreshData(db.getAllTasks())
    }
}
