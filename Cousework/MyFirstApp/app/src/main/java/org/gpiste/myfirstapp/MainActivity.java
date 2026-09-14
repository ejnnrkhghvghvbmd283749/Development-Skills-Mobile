package org.gpiste.myfirstapp;

import android.os.Bundle;
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

    }
}