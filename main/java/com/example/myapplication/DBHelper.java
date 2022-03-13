package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "Zamowienia";
    public DBHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Zamowienia (ID INTEGER PRIMARY KEY AUTOINCREMENT, Kompy Text, Myszki Text, Klawiatury Text, Monitory Text, Cena INTEGER)"); }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean addData( String item, String item2, String item3, String item4, int cena){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Kompy", item);
        contentValues.put("Myszki",item2);
        contentValues.put("Klawiatury", item3);
        contentValues.put("Monitory",item4);
        contentValues.put("Cena", cena);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result==-1){
            return false;
        }else return true;

    }

    public Cursor getdata(){
        SQLiteDatabase db  = this.getReadableDatabase();
        String query = "Select * FROM Zamowienia";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
