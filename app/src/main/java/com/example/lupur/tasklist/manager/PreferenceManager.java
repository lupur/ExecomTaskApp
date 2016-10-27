package com.example.lupur.tasklist.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lupur.tasklist.TasksListApp;
import com.google.gson.Gson;

import com.example.lupur.tasklist.model.Task;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.ArrayList;

/**
 * Created by lupur on 26-Oct-16.
 */

public class PreferenceManager {

    private static final String PREFERENCE_STORE = "TaskStore";

    public static ArrayList<Task> tasks;

    private static final String PREFERENCE = "taskList";

    private static final PreferenceManager ourInstance = new PreferenceManager();

    public static PreferenceManager getInstance() {return ourInstance;}

    private final SharedPreferences sharedPreferences;

    private final Gson gson = new Gson();

    private PreferenceManager() {
        sharedPreferences = TasksListApp.getAppContext().getSharedPreferences(PREFERENCE_STORE, Context.MODE_PRIVATE);
    }

    public void putTasks() {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFERENCE, gson.toJson(tasks));
        editor.apply();
    }

    public ArrayList<Task> getTasks() {
        Type type = new TypeToken<ArrayList<Task>>() {}.getType();
        tasks = gson.fromJson(sharedPreferences.getString(PREFERENCE, ""),type);
        return tasks;
    }
}
