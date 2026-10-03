package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

            //Sets error boxes to empty before checking conditions
            errorTextView1.setText("");
            errorTextView2.setText("");
            errorTextView3.setText("");
            errorTextView4.setText("");
            errorTextView5.setText("");


            //Checks for input requirements to register as user
            if(name.length() >= 3 && lastname.length() >= 3 && email.contains("@") && email.contains(".") && username.length() >= 4 && password.length() >= 12 && (password.contains("!") || password.contains("?") || password.contains("_"))) {
                if (User.users.containsKey(email)) {
                    Toast.makeText(SignUpActivity.this, "Email already exist", Toast.LENGTH_LONG).show();
                }else{

                    //Create an object out of inputs
                    User user = new User(name, lastname, username, password);

                    //Put email as key and object as value into hashmap
                    User.users.put(email, user);

                    //Proceed to main activity to login in
                    finish();
                }

            }//Check conditions in order to add errors
            else{
                if(name.length() < 3){
                    errorTextView1.setText("Name must be at least 3 characters");
                }
                if(lastname.length() < 3){
                    errorTextView2.setText("Lastname must be at least 3 characters");
                }
                if(email.isEmpty()){
                    errorTextView3.setText("Email must have at least 3 characters");

                }else if(!email.contains("@") || !email.contains(".")){
                    errorTextView3.setText("Email must have @.");
                }
                if(username.length() < 4){
                    errorTextView4.setText("Username must be at least 4 characters");
                }
                if(password.length() < 12){
                    errorTextView5.setText("Password must be at least 12 characters");
                }else if(!password.contains("!") && !password.contains("?") && !password.contains("_")){
                    errorTextView5.setText("Password must have at least one special characters !?_");
                }
            }


        });

    }
}