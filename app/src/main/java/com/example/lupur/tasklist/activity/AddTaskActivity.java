package com.example.lupur.tasklist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.lupur.tasklist.manager.PreferenceManager;
import com.example.lupur.tasklist.R;
import com.example.lupur.tasklist.model.Task;

public class AddTaskActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        init();
    }

    private void init() {
        title = (EditText) findViewById(R.id.add_task_title);
        description = (EditText) findViewById(R.id.add_task_description);



        final Button addTask = (Button) findViewById(R.id.add_task_btn);

        addTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String ttl = title.getText().toString();
                String desc = description.getText().toString();
                addNewTask(ttl, desc);
                goToTasksList();
            }
        });
    }

    private void addNewTask(String title, String description) {
        //TasksDatabaseHelper.getInstance(getApplicationContext()).addTask(task);

        //Task t2 = new Task("naslov", "opis");
        /*TasksDatabaseHelper taskHelper = TasksDatabaseHelper.getInstance(this);
        taskHelper.addTask(t2);*/
        Task task = new Task(title, description, false);
        PreferenceManager.tasks.add(task);
        PreferenceManager.getInstance().putTasks();


    }

    private void goToTasksList() {
        final Intent intent = new Intent(this, TasksListActivity.class);
        startActivity(intent);
    }
}
