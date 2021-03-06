package com.outsider.mycotact.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.outsider.mycotact.R;

import java.util.ArrayList;

import Models.Messages;
import androidx.annotation.Nullable;

public class DBAdapter extends SQLiteOpenHelper {

    public DBAdapter(@Nullable Context context) {
        super(context, "contactapp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE messages(id integer Primary key, " +
                "message text, reciever text, date text)";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String deletemsg = "DROP TABLE IF EXISTS messages";
        db.execSQL(deletemsg);
        onCreate(db);
    }

    public ArrayList<Messages> getAllMsgs(){

        ArrayList<Messages> messages = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        //SQLiteDatabase db = getWritableDatabase();

        String getall = "SELECT * FROM messages";

        Cursor cursor = db.rawQuery(getall, null);

        if(cursor.moveToFirst()){
            do{
                Messages msg = new Messages(cursor.getInt(0),
                        cursor.getString(2),
                        cursor.getString(1),
                        cursor.getString(3),
                        R.drawable.me);
                messages.add(msg);

            }while(cursor.moveToNext());
        }

        return messages;

    }

    public void ajouterMsg(Messages msg){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("message", msg.getLastMsg());
        contentValues.put("reciever", msg.getName());
        contentValues.put("date", msg.getDate());

        db.insert("messages", null, contentValues);

    }

    public void deleteMsg(int id){

        SQLiteDatabase db = getWritableDatabase(); //INSERT UPDATE DELETE
        db.delete("messages", " id = ?", new String[]{ String.valueOf(id) });

    }






}
