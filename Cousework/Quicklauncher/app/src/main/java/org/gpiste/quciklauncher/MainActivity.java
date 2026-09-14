package org.gpiste.quciklauncher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button secActivityButton;
    Button googloButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Find buttons using theit ID
        secActivityButton = findViewById(R.id.secActivityButton);
        googloButton = findViewById(R.id.googloButton);

        //Adding clicklisteners for when the buttons are clicked

        secActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SeccondActivity.class); //Request to go from main to sec activity
                intent.putExtra("org.gpiste.quciklauncher.SOMETHING", "WELCOME TO NEW ACTIVITY");//Sending message to thr seccond activity
                startActivity(intent);
            }
        });

        googloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}