package com.example.lupur.tasklist.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.lupur.tasklist.R;
import com.example.lupur.tasklist.manager.PreferenceManager;

public class EditTaskActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private CheckBox isFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);


        init();


    }
    private void init() {
        Intent i = getIntent();
        final int position = i.getIntExtra("position", 0);
        if (i != null) {


            title = (EditText) findViewById(R.id.edit_task_title);
            description = (EditText) findViewById(R.id.edit_task_description);
            isFinished = (CheckBox) findViewById(R.id.task_finished_box);


            String ttl = PreferenceManager.tasks.get(position).getTitle();
            String desc = PreferenceManager.tasks.get(position).getDescription();
            Boolean isFin = PreferenceManager.tasks.get(position).getIsFinished();

            title.setText(ttl);
            description.setText(desc);
            isFinished.setChecked(isFin);
            //The key argument here must match that used in the other activity
        }

        final Button editButton = (Button) findViewById(R.id.edit_task_btn);
        editButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editTask(position);
                goToTasksList();
            }
        });

        final Button deleteTaskBtn = (Button) findViewById(R.id.delete_task_btn);
        deleteTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTask(position);
                goToTasksList();
            }
        });
    }

    private void deleteTask(int position) {
        PreferenceManager.tasks.remove(position);
        PreferenceManager.getInstance().putTasks();
    }

    private void editTask(int position) {
        String ttl = title.getText().toString();
        String desc = description.getText().toString();
        Boolean isFin = isFinished.isChecked();

        PreferenceManager.tasks.get(position).setTitle(ttl);
        PreferenceManager.tasks.get(position).setDescription(desc);
        PreferenceManager.tasks.get(position).setIsFinished(isFin);

        PreferenceManager.getInstance().putTasks();
    }

    private void goToTasksList() {
        final Intent intent = new Intent(this, TasksListActivity.class);
        startActivity(intent);
    }
}
