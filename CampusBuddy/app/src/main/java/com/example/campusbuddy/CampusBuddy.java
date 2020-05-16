package com.example.campusbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CampusBuddy extends SQLiteOpenHelper {

    public static final String DB_NAME = "CB.db";
    public static final int DB_VER = 1;


    public CampusBuddy(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table facultyDetails(id integer primary key autoincrement, name text, email text, mobile text, dept text, password text)");

        db.execSQL("create table studentDetails(id integer primary key autoincrement, name text, email text, mobile text, dept text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists facultyDetails");

        db.execSQL("drop table if exists facultyDetails");

    }
//   -----------------------------------------Add Faculty Details-----------------------------------------------------------------
    public boolean addFaculty(String name, String eml, String num, String dpt, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("email", eml);
        values.put("mobile", num);
        values.put("dept", dpt);
        values.put("password", pass);

        long ins = db.insert("facultyDetails",null,values);
        if (ins > 0)
            return true;
        else
            return false;
    }


    public boolean checkFEm(String eml)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from facultyDetails where email =?", new  String[]{eml});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor fetchFaculty(String eml, String pass)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from facultyDetails where email = ? and password = ?", new String[]{eml,pass});
        return cursor;
    }

// -------------------------------------------Add Student Details ------------------------------------------------------------------
    public boolean addStudent(String name, String eml, String num, String dpt, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("email", eml);
        values.put("mobile", num);
        values.put("dept", dpt);
        values.put("password", pass);

        long ins = db.insert("studentDetails",null,values);
        if (ins > 0)
            return true;
        else
            return false;
    }

    public boolean checkSEm(String eml)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from studentDetails where email =?", new  String[]{eml});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor fetchStudent(String eml, String pass)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from studentDetails where email = ? and password = ?", new String[]{eml,pass});
        return cursor;
    }


}
