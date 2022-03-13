package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ZamowieniaAdapter extends ArrayAdapter {
    Activity context;
    LayoutInflater layoutInflater;
    ArrayList<String> komp;
    ArrayList<Integer> cena;
    TextView textView;
    TextView textView2;

    public ZamowieniaAdapter(@NonNull Activity context,ArrayList<String> komp, ArrayList<Integer> cena) {
        super(context, R.layout.my_listview_items, komp);
        this.context =context;
        this.komp = komp;
        this.cena = cena;
        layoutInflater = context.getLayoutInflater();
    }
    public View getView(int position, View convertview, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.my_listview_items, null);

        textView = view.findViewById(R.id.textView22);
        textView2 = view.findViewById(R.id.textView222);
        textView.setText(komp.get(position));
        textView2.setText(cena.get(position).toString());
        return view;
    }
}
