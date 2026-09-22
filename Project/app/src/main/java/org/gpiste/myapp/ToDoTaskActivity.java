package org.gpiste.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ToDoTaskActivity extends AppCompatActivity {

    TextView taskNameText;
    RadioGroup radioGroup;
    TextView noteText;
    Button saveButton;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_do_task);

        //Find elements by their id
        taskNameText = findViewById(R.id.taskNameText);
        radioGroup = findViewById(R.id.radioGroup);
        noteText = findViewById(R.id.noteText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get task name
                String taskName = taskNameText.getText().toString();

                //Get the selected radiobutton and its text by ID from radiogroup
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String priority = radioButton.getText().toString();

                //Get the task note
                String note = noteText.getText().toString();

                //Create task object
                Task task = new Task(taskName, priority, note);

                //Add task object to list
                Task.tasks.add(task);
            }
        });


    }
}