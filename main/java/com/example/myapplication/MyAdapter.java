package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Activity context;
    Dane[] dane;
    LayoutInflater layoutInflater;
    ImageView imageView;
    TextView textView;


    public MyAdapter(Activity context, Dane[] dane){
        super();
        this.context =context;
        this.dane = dane;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return dane.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        if(convertview==null)
            convertview = layoutInflater.inflate(R.layout.my_spinner_items, null);
        imageView = convertview.findViewById(R.id.imageview);
        textView = convertview.findViewById(R.id.textView);
        imageView.setImageResource(dane[position].getZdj());
        String prc = context.getString(R.string.price);
        String opis=dane[position].getOpis()+prc+dane[position].getCena();
        textView.setText(opis);
        return convertview;
    }

}
