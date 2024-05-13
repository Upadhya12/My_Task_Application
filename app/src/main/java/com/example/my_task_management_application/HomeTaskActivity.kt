package com.example.my_task_management_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_task_management_application.databinding.ActivityHomeTaskActvityBinding


class HomeTaskActivity : AppCompatActivity() {

    private lateinit var db: TaskDatabaseHelper
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var binding: ActivityHomeTaskActvityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTaskActvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)
        taskAdapter = TaskAdapter(db.getAllTasks(), this)

        binding.tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.tasksRecyclerView.adapter = taskAdapter

        binding.addButton.setOnClickListener {
            val  intent =   Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }
    }



    override fun onResume() {
        super.onResume()
        taskAdapter.refreshData(db.getAllTasks())
    }
}
