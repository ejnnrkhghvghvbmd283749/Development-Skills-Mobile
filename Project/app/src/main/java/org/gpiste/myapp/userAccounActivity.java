package org.gpiste.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class userAccounActivity extends AppCompatActivity {

    TextView firstNameTextView, lastNameTextView, emailTextView, userNameTextView, passwordTextView;
    Button saveChangesButton;
    Button logOutButton;
    String receivedEmail,curfirstname, curlastname,curusername,curpassword;
    TextView nameError, lastNameError,usernameError,passwordError;
    Toolbar userAccountToolbar;

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

        nameError = findViewById(R.id.nameError);
        lastNameError = findViewById(R.id.lastNameError);
        usernameError = findViewById(R.id.usernameError);
        passwordError = findViewById(R.id.passwordError);

        userAccountToolbar = findViewById(R.id.userAccountToolbar);

        //When navigation icon is clicked it goes back to previous activity
        userAccountToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //Homepage receives user's email from home page
        Intent intent = getIntent();
        if(intent.hasExtra("org.gpiste.myapp.SOMETHING")){
            receivedEmail= intent.getExtras().getString("org.gpiste.myapp.SOMETHING");
            emailTextView.setText(receivedEmail);

            curfirstname = User.users.get(receivedEmail).firstname;
            firstNameTextView.setText(curfirstname);
            curlastname = User.users.get(receivedEmail).lastname;
            lastNameTextView.setText(curlastname);
            curusername = User.users.get(receivedEmail).username;
            userNameTextView.setText(curusername);
            curpassword = User.users.get(receivedEmail).password;
            passwordTextView.setText(curpassword);
        }

        //New user edits gets saved if there are any
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get and convert inputs to strings
                String newFirstName = firstNameTextView.getText().toString();
                String newLastName = lastNameTextView.getText().toString();
                String newUsername = userNameTextView.getText().toString();
                String newPassword = passwordTextView.getText().toString();

                //Get specific email details
                User user = User.users.get(receivedEmail);

                //Sets error boxes to empty before checking conditions
                nameError.setText("");
                lastNameError.setText("");
                usernameError.setText("");
                passwordError.setText("");

                //Checks for input requirements to edit already existed user information
                if(newFirstName.length() >= 3){
                    user.firstname = newFirstName;
                } else{
                    nameError.setText("Name must be at least 3 characters");
                }
                if(newLastName.length() >= 3){
                    user.lastname = newLastName;
                }else{
                    lastNameError.setText("Lastname must be at least 3 characters");
                }

                if(newUsername.length() >= 4){
                    user.username = newUsername;
                }else{
                    usernameError.setText("Username must be at least 4 characters");
                }

                if(newPassword.length() >= 12 && (newPassword.contains("!") || newPassword.contains("?") || newPassword.contains("_"))){
                    user.password = newPassword;
                }else if(newPassword.length() < 12){
                    passwordError.setText("Password must be at least 12 characters");
                } else if(!newPassword.contains("!") && !newPassword.contains("?") && !newPassword.contains("_")){
                    passwordError.setText("Password must have at least one special characters !?_");
                }

            }
        });

        //Redirect use to main page after logging out
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task.tasks.clear();
                Intent intent = new Intent(userAccounActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}