package com.example.campusbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Campus_Extra extends SQLiteOpenHelper {
    public static final String DB_NAME = "TimeTable.db";
    public static final int DB_VER = 1;
    public Campus_Extra(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table timetable(id integer primary key autoincrement, tym_slot text, day text, sem text, sub text, cod text, mod text, top text, uname text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists timetable");

    }

    public boolean insTbl(String tym, String day, String sem, String sub, String cod, String mod, String top, String unm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tym_slot", tym);
        contentValues.put("day", day);
        contentValues.put("sem", sem);
        contentValues.put("sub", sub);
        contentValues.put("cod", cod);
        contentValues.put("mod",mod);
        contentValues.put("top", top);
        contentValues.put("uname", unm);

        long ins = db.insert("timetable", null, contentValues);

        if (ins == -1) return false;
        else return true;

    }

    public Cursor fetchTable(String unm)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from timetable where uname = ?", new String[]{unm});
        return cursor;
    }

    public ArrayList<FacultyDataDetails> viewData(String user, String sem)
    {
        ArrayList<FacultyDataDetails> facultyDataDetails = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Log.e("----------------","select tym_slot, sub from timetable where sem = "+sem+" and uname = "+user);
        Cursor cursor = db.rawQuery("select tym_slot, sub,top from timetable where sem = ? and uname = ?", new String[]{sem, user});


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String tym = cursor.getString(cursor.getColumnIndex("tym_slot"));
                String sub = cursor.getString(cursor.getColumnIndex("sub"));
                String topic = cursor.getString(cursor.getColumnIndex("top"));
                FacultyDataDetails temp = new FacultyDataDetails(tym,sub,topic);
                facultyDataDetails.add(temp);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();


        return facultyDataDetails;

    }



}
