package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/* Opening code for Database */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
       myDB.execSQL("create Table tbusers(username Text primary key,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {

        myDB.execSQL("drop Table if exists tbusers");
    }

    /* To Insert Data in the database */
    public boolean insertData(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = myDB.insert("tbusers",null,contentValues);

        if (result == -1){

            return false;

        }

        else {
            return true;
        }
    }
/* To Check if existing user is already in database with same name */
    public boolean checkusername(String username){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from tbusers where username = ?",new  String[] {username});
        if (cursor.getCount()>0){

            return true;
        }
        else {

            return false;
        }
    }

    /* To Check if existing user and password to Authenticate it is the write user*/

    public boolean checkusernamePassword(String username, String password){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from tbusers where username = ? and password=?" ,new  String[] {username, password});

        if (cursor.getCount()>0){

            return true;
        }
        else {
            return false;
        }
    }
}
