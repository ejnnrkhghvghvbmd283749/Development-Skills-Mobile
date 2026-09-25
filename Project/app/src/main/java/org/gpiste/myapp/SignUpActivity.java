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
    TextView errorTextView1, errorTextView2, errorTextView3, errorTextView4, errorTextView5;

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

        errorTextView1 = findViewById(R.id.errorTextView1);
        errorTextView2 = findViewById(R.id.errorTextView2);
        errorTextView3 = findViewById(R.id.errorTextView3);
        errorTextView4 = findViewById(R.id.errorTextView4);
        errorTextView5 = findViewById(R.id.errorTextView5);

        signUpButton = findViewById(R.id.signUpButton);

        //When button is clicked, user's data gets saved
        signUpButton.setOnClickListener(view -> {

            //Converting inputs to strings
            String name = fistNameText.getText().toString();
            String lastname = lastNameText.getText().toString();
            String email = emailText.getText().toString();
            String username = userNameText.getText().toString();
            String password = passwordText.getText().toString();

            //Get email characters before @
            String subEmail = email.substring(0, email.indexOf("@"));

            //Checks for input requirements to register as user
            if(name.length() >= 3 && lastname.length() >= 3 && subEmail.length() >= 3 && username.length() >= 4 && password.length() >= 12){

                //Create an object out of inputs
                User user = new User(name, lastname, username, password);

                //Put email as key and object as value into hashmap
                User.users.put(email, user);

                //Proceed to main activity to login in
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });

    }
}