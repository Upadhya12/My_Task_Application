package com.example.my_task_management_application

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my_task_management_application.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db: TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = TaskDatabaseHelper(this )

        binding.saveButton.setOnClickListener{
            val tasktitle = binding.taskEditText.text.toString()
            val context = binding.contentEditText.text.toString()
            val task= Task( 0, tasktitle, context)
            db.insertTask(task)
            finish()
            Toast.makeText( this, "Task Saved", Toast.LENGTH_SHORT).show()

        }
    }

}