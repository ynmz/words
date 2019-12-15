package com.example.shiyan2;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;


import android.database.sqlite.SQLiteDatabase;
public class SQLiteDbHelper extends SQLiteOpenHelper {
    private String CREATE_CONTACT_TABLE="CREATE TABLE T_Message(id INTEGER PRIMARY KEY," +
            "date VARCHAR(50),title VARCHAR(50),content VARCHAR(200))";
    public SQLiteDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


