package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    TextView fistNameText;
    TextView lastNameText;
    TextView emailText;
    TextView userNameText;
    TextView passwordText;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        //Finding elements by their Ids
        fistNameText = findViewById(R.id.fistNameText);
        lastNameText = findViewById(R.id.lastNameText);
        emailText = findViewById(R.id.emailText);
        userNameText = findViewById(R.id.userNameText);
        passwordText = findViewById(R.id.passwordText);

        signUpButton = findViewById(R.id.signUpButton);

        //When button is clicked, user's data gets saved
        signUpButton.setOnClickListener(view -> {

            //Converting inputs to strings
            String name = fistNameText.getText().toString();
            String lastname = lastNameText.getText().toString();
            String email = emailText.getText().toString();
            String username = userNameText.getText().toString();
            String password = passwordText.getText().toString();

            //Create an object out of inputs
            User user = new User(name, lastname, username, password);

            //Put email as key and object as value into hashmap
            User.users.put(email, user);

            //Proceed to main activity to login in
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);

        });

    }
}