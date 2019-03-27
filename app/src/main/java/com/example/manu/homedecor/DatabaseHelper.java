package com.example.manu.homedecor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "dabaselogin";
    private static final int VERSION = 1;

    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableNotes.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableNotes.TABLE_NAME);
    }

    public void insertData(TableNotes notes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TableNotes.COLUMN_USER_NAME,notes.getUsername());
        cv.put(TableNotes.COLUMN_USER_PASSWORD,notes.getUserpassword());
        db.insert(TableNotes.TABLE_NAME,null,cv);
        db.close();
    }
}