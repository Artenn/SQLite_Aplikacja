package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {
    private static final String TAG = "ListDataActivity";

    DBHelper dbHelper;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        listView = findViewById(R.id.listviewalpha);
        dbHelper = new DBHelper(this);

        Button button = findViewById(R.id.bauton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });

        poplistview();
    }

    private void poplistview() {
        Cursor data = dbHelper.getdata();
        ArrayList<String> listdata = new ArrayList<>();
        ArrayList<Integer> listdata2 = new ArrayList<>();
        data.moveToFirst();
        do {
                listdata.add(data.getString(1));
                listdata2.add(data.getInt(5));
        }while (data.moveToNext());



        ZamowieniaAdapter adapter = new ZamowieniaAdapter(this,listdata,listdata2);
        listView.setAdapter(adapter);
    }
}

