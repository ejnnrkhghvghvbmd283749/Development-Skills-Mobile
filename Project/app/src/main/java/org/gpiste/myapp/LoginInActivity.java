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
    TextView loginError1, loginError2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_in);

        //Finding elements by their ids
        loginEmailText = findViewById(R.id.loginEmailText);
        passwordLoginText = findViewById(R.id.passwordLoginText);

        loginError1 = findViewById(R.id.loginError1);
        loginError2 = findViewById(R.id.loginError2);

        loginButton = findViewById(R.id.loginButton);

        //When button is clicked it goes to new activity to create to do tasks
        loginButton.setOnClickListener(view -> {

            //Sets error boxes to empty before checking conditions
            loginError1.setText("");
            loginError2.setText("");

            //Converting inputs to string
            String email = loginEmailText.getText().toString();
            String password = passwordLoginText.getText().toString();

            //Checks users existence, if so it proceed to HomePage activity
            if(User.users.containsKey(email) && User.users.get(email).password.equals(password)){
                Intent intent = new Intent(LoginInActivity.this, HomePageActivity.class);
                //Send email to homepage
                intent.putExtra("org.gpiste.myapp.SOMETHING", email);
                startActivity(intent);

            }else if(User.users.containsKey(email) && !User.users.get(email).password.equals(password)){
                loginError1.setText("Password is incorrect, try again");

            }else {
                loginError2.setText("User does not exist");
            }
        });


    }
}