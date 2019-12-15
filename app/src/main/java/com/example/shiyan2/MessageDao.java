package com.example.shiyan2;

import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import android.content.ContentValues;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import java.util.List;

import java.util.Objects;


public class MessageDao {
    SQLiteDatabase db;
    public MessageDao(SQLiteDatabase db) {
        this.db = db;
    }
    public boolean save(Object objects) {
        try {
            Message message = (Message) objects;
            ContentValues values = new ContentValues();
            values.put("date",String.valueOf(message.getDate()));
            values.put("title", message.getTitle());
            values.put("content", message.getContent());
            long index = db.insert("T_Message", null, values);
            if (index > 0)
                return true;
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean update(Object objects) {
        try {
            Message message = (Message) objects;
            ContentValues values = new ContentValues();
            values.put("date",String.valueOf(message.getDate()));
            values.put("title", message.getTitle());
            values.put("content", message.getContent());
            long index = db.update("T_Message", values, "id=?", new String[]{String.valueOf(message.getId())});
            if (index > 0)
                return true;
            else {
                return false;

}
        } catch (Exception e) {
            return false;
        }
    }
    public boolean delete(String id) {
        try {
            int index = db.delete("T_Message", "id=?", new String[]{id});
            if (index > 0)
                return true;
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public List query() {
        Cursor cursor = db.rawQuery("select * from T_Message",new String[]{});
        List<Message> list =new ArrayList<Message>();
        while(cursor.moveToNext()){
            Message message = new Message(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            list.add(message);
        }
        return list;
    }
    public List visit(String id_query) {
        Cursor cursor = db.rawQuery("select * from T_Message where id = ?",new String[]{id_query});
        //Cursor cursor=db.query("T_Message",new String[]{"id","date","title","content"},"id=?",new String[]{id_query},null,null,null);
        List<Message> list =new ArrayList<Message>();
        while(cursor.moveToNext()){
            Message message = new Message(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            list.add(message);
        }
        return list;
    }

}
