package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {

    ImageButton accountImageButton;
    TextView welcomeTextView;
    ListView taskListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        //Finding elements by id to set listview and page's layout
        accountImageButton = findViewById(R.id.accountImageButton);
        welcomeTextView = findViewById(R.id.welcomeTextView);
        taskListView = findViewById(R.id.taskListView);

        //Homepage receives user's email from the login page to find their username
        Intent intent = getIntent();
        if(intent.hasExtra("org.gpiste.myapp.SOMETHING")){
            String email = intent.getExtras().getString("org.gpiste.myapp.SOMETHING");
            //Finds user's username
            String username = User.users.get(email).username;
            welcomeTextView.setText("Welcome " + username);
        }


    }
}