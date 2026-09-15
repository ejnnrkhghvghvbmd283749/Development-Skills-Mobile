package org.gpiste.listapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
public class MainActivity extends AppCompatActivity {

    ListView mainList;
    String[] products;
    String[] descriptions;
    String[] prices;
    String[] availability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Find elements to pass to adapter class
        Resources resourses = getResources();
        products = resourses.getStringArray(R.array.products);
        descriptions = resourses.getStringArray(R.array.description);
        prices = resourses.getStringArray(R.array.prices);
        availability = resourses.getStringArray(R.array.availability);

        //Find listview by id for setting elements to it
        mainList = findViewById(R.id.mainList);


        }

}
