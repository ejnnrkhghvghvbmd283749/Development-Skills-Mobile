package org.gpiste.myapp;

import java.util.ArrayList;

public class Task {
    String taskName;
    String priority;
    String note;

    static ArrayList<Task> tasks = new ArrayList<>();
    public Task(String t, String p, String n){
        taskName = t;
        priority = p;
        note = n;
    }
}
