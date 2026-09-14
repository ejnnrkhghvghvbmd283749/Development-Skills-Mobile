package org.gpiste.quciklauncher;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SeccondActivity extends AppCompatActivity {


    TextView receivedTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seccond);

        //Find textview element by id
        receivedTextView = findViewById(R.id.receivedTextView);

        //If a message, It shows it in textbox other than that NULL
        if(getIntent().hasExtra("org.gpiste.quciklauncher.SOMETHING")){
            //Receiving the message and setting it to textview
            String text = getIntent().getExtras().getString("org.gpiste.quciklauncher.SOMETHING");
            receivedTextView.setText(text);
        }else{
            receivedTextView.setText("NULL");
        }

    }
}