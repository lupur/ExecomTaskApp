package com.example.lupur.tasklist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lupur.tasklist.R;
import com.example.lupur.tasklist.model.Task;
import com.example.lupur.tasklist.adapter.PagerAdapter;
import com.example.lupur.tasklist.model.Task;


import java.util.List;

/**
 * Created by lupur on 26-Oct-16.
 */

public class TaskAdapter extends BaseAdapter {

    private final List<Task> tasks;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.tasks = tasks;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_task, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.taskFinished = (TextView) convertView.findViewById(R.id.taskFinishedTxt);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Task task = (Task) getItem(position);

        viewHolder.title.setText(task.getTitle());
        viewHolder.description.setText(task.getDescription());
        if(task.getIsFinished())
        {
            viewHolder.taskFinished.setText("This task is finished!");
        }
        else {
            viewHolder.taskFinished.setText("");
        }

        return  convertView;

    }

    /**
     * Holder for view references.
     */
    private static class ViewHolder {
        TextView title;
        TextView description;
        TextView taskFinished;
    }
}
