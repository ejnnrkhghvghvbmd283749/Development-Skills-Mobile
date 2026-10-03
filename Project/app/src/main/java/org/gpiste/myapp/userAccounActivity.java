package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class userAccounActivity extends AppCompatActivity {

    TextView firstNameTextView;
    TextView lastNameTextView;
    TextView emailTextView;
    TextView userNameTextView;
    TextView passwordTextView;
    Button saveChangesButton;
    Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_accoun);

        //Finding elements by id to set listview and page's layout
        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        userNameTextView = findViewById(R.id.userNameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        saveChangesButton = findViewById(R.id.saveChangesButton);
        logOutButton = findViewById(R.id.logOutButton);

        //Homepage receives user's email from home page
        Intent intent = getIntent();
        if(intent.hasExtra("org.gpiste.myapp.SOMETHING")){
            String email = intent.getExtras().getString("org.gpiste.myapp.SOMETHING");
        }

    }
}