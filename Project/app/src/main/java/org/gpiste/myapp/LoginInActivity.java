package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginInActivity extends AppCompatActivity {

    TextView loginEmailText;
    TextView passwordLoginText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_in);

        //Finding elements by their ids
        loginEmailText = findViewById(R.id.loginEmailText);
        passwordLoginText = findViewById(R.id.passwordLoginText);

        loginButton = findViewById(R.id.loginButton);

        //When button is clicked it goes to new activity to create to do tasks
        loginButton.setOnClickListener(view -> {

            ////Converting inputs to string
            String email = loginEmailText.getText().toString();
            String password = passwordLoginText.getText().toString();

            //Checks users existence, if so it proceed to HomePage activity
            if(User.users.containsKey(email) && User.users.get(email).password.equals(password)){
                Intent intent = new Intent(LoginInActivity.this, HomePageActivity.class);
                //Send email to homepage
                intent.putExtra("org.gpiste.myapp.SOMETHING", email);
                startActivity(intent);
            }else if(User.users.containsKey(email) && !User.users.get(email).password.equals(password)){
                Toast.makeText(LoginInActivity.this, "Password is incorrect, try again",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(LoginInActivity.this, "User does not exist",Toast.LENGTH_SHORT).show();
            }
        });


    }
}