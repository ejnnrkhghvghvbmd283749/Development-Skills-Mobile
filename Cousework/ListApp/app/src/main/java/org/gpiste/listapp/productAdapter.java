package org.gpiste.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
public class productAdapter extends BaseAdapter {

    String[] products;
    String[] descriptions;
    String[] prices;
    String[] availability;

    LayoutInflater inflater;
    public productAdapter(Context c, String[] p, String[] d, String[] ps, String[] a){

        inflater= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Request to get a tool to inflate xml file to view
        p = products;
        d = descriptions;
        ps = prices;
        a = availability;
    }

    //Gets array length
    @Override
    public int getCount() {
        return products.length;
    }

    //Gets prodcut by index
    @Override
    public Object getItem(int i) {
        return products[i];
    }

    //Product Id
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        return null;
    }
}
