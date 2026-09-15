package org.gpiste.listapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
public class MainActivity extends AppCompatActivity {

    ListView mainList;
    static String[] products;
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


        //Pass arrays to adapter class
        ProductAdapter productAdapter = new ProductAdapter(this, products, descriptions, prices, availability);
        //Setting received view to the list in mainactivity
        mainList.setAdapter(productAdapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, PhotoDetailActivity.class);//Move from main to photodetailactivity
                intent.putExtra("org.gpiste.listapp", i);//Send clicked items index to the activity
                startActivity(intent);
            }
        });
        }

}
