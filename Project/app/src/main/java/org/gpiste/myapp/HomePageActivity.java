package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomePageActivity extends AppCompatActivity {

    ImageButton accountImageButton;
    ImageButton addTaskImageButton;
    TextView welcomeTextView;
    ListView taskListView;
    TaskAdapter taskAdapter;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        //Finding elements by id to set listview and page's layout
        accountImageButton = findViewById(R.id.accountImageButton);
        addTaskImageButton = findViewById(R.id.addTaskImageButton);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        taskListView = findViewById(R.id.taskListView);

        //Homepage receives user's email from the login page to find their username
        Intent intent = getIntent();
        if(intent.hasExtra("org.gpiste.myapp.SOMETHING")){
            email = intent.getExtras().getString("org.gpiste.myapp.SOMETHING");
        }

        //When addTaskImageButton is clicked, user get redirected to ToDoTaskActivity
        addTaskImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, ToDoTaskActivity.class);
                startActivity(intent);
            }
        });

        //Pass this activity to Adapter, then sets view to the listview
        taskAdapter = new TaskAdapter(this);
        taskListView.setAdapter(taskAdapter);

        //Send clicked items index
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomePageActivity.this, taskDetailActivity.class);
                intent.putExtra("org.gpiste.myapp.SOMETHING", i);
                startActivity(intent);
            }
        });

        //When icon is clicked, it goes to user account detail page
        accountImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, userAccounActivity.class);
                intent.putExtra("org.gpiste.myapp.SOMETHING", email);
                startActivity(intent);
            }
        });


    }

    //https://stackoverflow.com/questions/3053761/reload-activity-in-android
    //Task list get refreshed, when user returns to this activity
    @Override
    public void onRestart(){
        super.onRestart();
        taskAdapter.notifyDataSetChanged();

        //Finds user's username
        String username = User.users.get(email).username;
        welcomeTextView.setText("Welcome " + username);
    }
}