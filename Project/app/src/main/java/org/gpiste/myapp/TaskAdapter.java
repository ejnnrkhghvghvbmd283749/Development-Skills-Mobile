package org.gpiste.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TaskAdapter extends BaseAdapter {

    LayoutInflater inflater;

    //Constructor
    public TaskAdapter(Context c){
        //Send request to get a tool to inflate XML file
         inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Array length
    @Override
    public int getCount() {
        return Task.tasks.size();
    }

    //Get product by index
    @Override
    public Object getItem(int i) {
        return Task.tasks.get(i);
    }

    //Task id
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        //Convert XML file into a view
        View view = inflater.inflate(R.layout.listview_detail, null);

        //Get view's elements by ID
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView priorityTextView = view.findViewById(R.id.priorityTextView);

        //Get inputs from tasks array
        String taskName = Task.tasks.get(i).taskName;
        String priority = Task.tasks.get(i).priority;

        //Set inputs to View
        nameTextView.setText(taskName);
        priorityTextView.setText(priority);

        return view;
    }
}
