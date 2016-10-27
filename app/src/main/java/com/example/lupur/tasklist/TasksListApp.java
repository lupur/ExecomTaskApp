package com.example.lupur.tasklist;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.example.lupur.tasklist.manager.PreferenceManager;
import com.example.lupur.tasklist.model.Task;

import java.util.ArrayList;

import static com.example.lupur.tasklist.manager.PreferenceManager.tasks;

/**
 * Created by lupur on 26-Oct-16.
 */

public class TasksListApp extends Application {

    private static  TasksListApp tasksListApp;

    public static Context getAppContext() { return tasksListApp.getApplicationContext();}

    @Override
    public void onCreate() {

        //SQLiteDatabase taskListDB = openOrCreateDatabase("taskListDB",MODE_PRIVATE,null);


        super.onCreate();
        tasksListApp = this;
        PreferenceManager.getInstance().getTasks();
        if(tasks == null)
        {
            tasks = new ArrayList<Task>();

            Task t1 = new Task("Initial Task 1", "Description of Initial Task 1", false);
            tasks.add(t1);

            PreferenceManager.getInstance().putTasks();
        }

    }
}
