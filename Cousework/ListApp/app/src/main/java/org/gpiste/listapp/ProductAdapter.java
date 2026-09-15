package org.gpiste.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter {

    String[] products;
    String[] descriptions;
    String[] prices;
    String[] availability;

    LayoutInflater inflater;
    public ProductAdapter(Context c, String[] p, String[] d, String[] ps, String[] a){

        inflater= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Request to get a tool to inflate XML file to view
        products = p;
        descriptions = d;
        prices = ps;
        availability = a;
    }

    //Gets array length
    @Override
    public int getCount() {
        return products.length;
    }

    //Gets product by index
    @Override
    public Object getItem(int i) {
        return products[i];
    }

    //Product id
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        //Convert XML file into a view
        View view = inflater.inflate(R.layout.listview_detail, null);

        //find views elements by ID
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView descriptTextView = view.findViewById(R.id.descriptTextView);
        TextView priceTextView = view.findViewById(R.id.priceTextView);
        TextView availabilityTextView = view.findViewById(R.id.availabilityTextView);

        //Get infos from arrays using index
        String name = products[i];
        String description = descriptions[i];
        String price = prices[i];
        String stock = availability[i];

        //Setting received info to view
        nameTextView.setText(name);
        descriptTextView.setText(description);
        priceTextView.setText(price);
        availabilityTextView.setText(stock);

        return view;
    }
}
