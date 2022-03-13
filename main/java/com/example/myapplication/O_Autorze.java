package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class O_Autorze extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oautorze);
        Button button = findViewById(R.id.bauton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
              finish();
            }
        });
    }

}