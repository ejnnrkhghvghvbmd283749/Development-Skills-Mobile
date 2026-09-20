package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button createAccountButton;
    Button loginInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Finding elements by their ids
        createAccountButton = findViewById(R.id.createAccountButton);
        loginInButton = findViewById(R.id.logInButton);

        //When button is clicked, it goes to sign up page
        createAccountButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);

        });

        //When button is clicked, it goes to login page
        loginInButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginInActivity.class);
            startActivity(intent);
        });
    }
}