package org.gpiste.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView numberOneEditText;
    TextView numberTwoEditText;
    Button addButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Finding xml elements using their ID
        numberOneEditText = findViewById(R.id.numberOneEditText);
        numberTwoEditText = findViewById(R.id.numberTwoEditText);
        addButton = findViewById(R.id.addButton);
        resultTextView = findViewById(R.id.resultTextView);

        addButton.setOnClickListener(new View.OnClickListener() { //Adding listener for when the add button is clicked to perform sum
            @Override
            public void onClick(View view) {

                //Get text of edit text and convert to string
                String content1 = numberOneEditText.getText().toString();
                String content2 = numberTwoEditText.getText().toString();

                //Parse Strings to integers
                int num1 = Integer.parseInt(content1);
                int num2 = Integer.parseInt(content2);

                //Sum of numbers
                int sum = num1 + num2;

                //Convert int to String and set it to text view using ""
                System.out.println("NOOOO");
                resultTextView.setText(sum + "");

            }
        });


    }
}