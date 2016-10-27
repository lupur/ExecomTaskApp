package com.example.lupur.tasklist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lupur.tasklist.manager.PreferenceManager;
import com.example.lupur.tasklist.activity.AddTaskActivity;
import com.example.lupur.tasklist.activity.EditTaskActivity;
import com.example.lupur.tasklist.manager.PreferenceManager;
import com.example.lupur.tasklist.R;

import java.util.ArrayList;
import java.util.List;

import com.example.lupur.tasklist.adapter.TaskAdapter;
import com.example.lupur.tasklist.model.Task;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.

 */
public class TasksFragment extends Fragment {

    private View view;

    public TasksFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Getting a reference to this fragment's view.
        view = inflater.inflate(R.layout.fragment_tasks, container, false);

        initList();

        return view;
    }

    private void initList() {

        final ListView listView = (ListView) view.findViewById(R.id.list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                redirectToEditActivity(position);
            }
        });

        final List<Task> tasks = PreferenceManager.getInstance().getTasks();


        final TaskAdapter adapter = new TaskAdapter(getActivity(), tasks);
        listView.setAdapter(adapter);

    }

    private void redirectToEditActivity(int position) {


        Intent i  = new Intent(getContext(), EditTaskActivity.class);

        i.putExtra("position", position);
        startActivity(i);

    }

}
