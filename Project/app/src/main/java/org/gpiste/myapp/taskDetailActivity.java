package org.gpiste.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class taskDetailActivity extends AppCompatActivity {

    TextView priorityTextView;
    TextView taskTextView;
    TextView noteTextView;
    Button doneButton;

    Toolbar clickedTaskToolbar;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_detail);

        //Find elements by IDs
        priorityTextView = findViewById(R.id.priorityTextView);
        taskTextView = findViewById(R.id.taskTextView);
        noteTextView = findViewById(R.id.noteTextView);
        doneButton = findViewById(R.id.doneButton);
        clickedTaskToolbar = findViewById(R.id.clickedTaskToolbar);

        Intent intent = getIntent();

        //Check if item index is received
        if(intent.hasExtra("org.gpiste.myapp.SOMETHING")){
            i = intent.getIntExtra("org.gpiste.myapp.SOMETHING", -1);
            String priorityLevel = Task.tasks.get(i).priority;

            //Set priority box's color based on it level
            if (priorityLevel.equals("High")){
                priorityTextView.setBackgroundColor(Color.RED);
            } else if ( priorityLevel.equals("Medium")) {
                priorityTextView.setBackgroundColor(Color.YELLOW);
            } else if (priorityLevel.equals("Low")) {
                priorityTextView.setBackgroundColor(Color.GREEN);
            }

            //Sets selected item infomration to text boxes
            priorityTextView.setText(priorityLevel);
            taskTextView.setText(Task.tasks.get(i).taskName);
            noteTextView.setText(Task.tasks.get(i).note);
        }

        //When navigation icon is clicked it goes back to previous activity
        clickedTaskToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Removes task when it is done and goes to previous activity
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task.tasks.remove(i);
                finish();
            }
        });
    }
}