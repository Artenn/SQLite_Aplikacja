package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AdapterViews {
    int[] decisions= new int[4];
    int[] values =new int[4];
    MainActivity context;
    public AdapterViews(MainActivity context){
        this.context=context;

    }
    public AdapterView.OnItemSelectedListener kompy(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                decisions[0]=i;
                switch (i) {
                    case 0:
                        values[0]=Dane.kompy[0].getCena();
                        break;
                    case 1:
                        values[0]=Dane.kompy[1].getCena();
                        break;
                    case 2:
                        values[0]=Dane.kompy[2].getCena();
                        break;
                }context.setcena(String.valueOf(Arrays.stream(values).sum()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }
    public AdapterView.OnItemSelectedListener myszki(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                decisions[1]=i;
                switch (i) {
                    case 0:
                        values[1]=Dane.mouse[0].getCena();
                        break;
                    case 1:
                        values[1]=Dane.mouse[1].getCena();
                        break;
                    case 2:
                        values[1]=Dane.mouse[2].getCena();
                        break;
                }context.setcena(String.valueOf(Arrays.stream(values).sum()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }
    public AdapterView.OnItemSelectedListener klawiatury(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                decisions[2]=i;
                switch (i) {
                    case 0:
                        values[2]=Dane.klawy[0].getCena();
                        break;
                    case 1:
                        values[2]=Dane.klawy[1].getCena();
                        break;
                    case 2:
                        values[2]=Dane.klawy[2].getCena();
                        break;
                }context.setcena(String.valueOf(Arrays.stream(values).sum()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }
    public AdapterView.OnItemSelectedListener monitory(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                decisions[3]=i;
                switch (i) {
                    case 0:
                        values[3]=Dane.monitory[0].getCena();
                        break;
                    case 1:
                        values[3]=Dane.monitory[1].getCena();
                        break;
                    case 2:
                        values[3]=Dane.monitory[2].getCena();
                        break;
                }context.setcena(String.valueOf(Arrays.stream(values).sum()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    public int[] getValues() {
        return values;
    }
}
