package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Integer cena = 0;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.listview);
        Spinner spinner1= findViewById(R.id.pies);
        Spinner spinner2= findViewById(R.id.pies2);
        Spinner spinner3= findViewById(R.id.pies3);





        dbHelper = new DBHelper(this);

        AdapterViews adapterViews = new AdapterViews(this);

        spinner.setOnItemSelectedListener(adapterViews.kompy());
        spinner1.setOnItemSelectedListener(adapterViews.myszki());
        spinner2.setOnItemSelectedListener(adapterViews.klawiatury());
        spinner3.setOnItemSelectedListener(adapterViews.monitory());

        spinner.setAdapter(new MyAdapter(this,Dane.kompy));
        spinner1.setAdapter(new MyAdapter(this, Dane.mouse));
        spinner2.setAdapter(new MyAdapter(this, Dane.klawy));
        spinner3.setAdapter(new MyAdapter(this, Dane.monitory));


        Button button = findViewById(R.id.zaplac);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ceno = Arrays.stream(adapterViews.values).sum();
                Intent mail = new Intent(Intent.ACTION_SEND);
                EditText imie = findViewById(R.id.edittext);
                EditText mail123 = findViewById(R.id.edittext1);
                EditText tel = findViewById(R.id.edittext2);
                String[] maile= new String[]{
                        mail123.getText().toString()
                };
                CharSequence ta = imie.getText().toString()+", data "+Instant.now()+", cena "+ceno;
                mail.setData(Uri.parse("mailto:"));
                mail.setType("text/plain");
                mail.putExtra(Intent.EXTRA_EMAIL,maile);
                mail.putExtra(Intent.EXTRA_SUBJECT,"zamowienie");
                mail.putExtra(Intent.EXTRA_TEXT, ta);

                mail.setType("message/rfc822");

                startActivity(Intent.createChooser(mail,"Text"));
                if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {
                    try {
                        SmsManager manager = SmsManager.getDefault();
                        ArrayList<String> nazwa = manager.divideMessage((String) ta);
                        manager.sendMultipartTextMessage(tel.getText().toString().trim(), null, nazwa, null, null);
                    }catch (Exception e){
                        e.printStackTrace();}

                    }else{
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                }

                int[] decisions = adapterViews.decisions;

                dbHelper.addData(Dane.kompy[decisions[0]].getOpis(),Dane.mouse[decisions[1]].getOpis(),Dane.klawy[decisions[2]].getOpis(),Dane.monitory[decisions[3]].getOpis(),ceno);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.listazam:
                startActivity(new Intent(this, ListDataActivity.class));
                return true;
            case R.id.autor:
                startActivity(new Intent(this,O_Autorze.class));
                return true;
            case R.id.zapamietaj:
                if(item.isChecked()){
                    item.setChecked(false);
                }else {
                    item.setChecked(true);
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void setcena(String a){
        TextView textcena = findViewById(R.id.cena);
        textcena.setText(a);
    }
}