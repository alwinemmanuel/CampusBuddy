package com.example.campusbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.campusbuddy.StudentDataDetails;

import java.util.ArrayList;

public class Marks extends SQLiteOpenHelper {

    public static final String DB_NAME = "mark.db";
    public static final int DB_VER = 1;

    public Marks(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table InternalMarks(id integer primary key autoincrement, sName text, sem text, sub text, Tmrk text, Omrk text, pf text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists InternalMarks");
    }

    public  boolean addMark(String name, String sem, String sub, String tmr, String omr, String pf)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sName", name);
        contentValues.put("sem", sem);
        contentValues.put("sub", sub);
        contentValues.put("Tmrk", tmr);
        contentValues.put("Omrk", omr);
        contentValues.put("pf", pf);

        long ins = db.insert("InternalMarks", null, contentValues);
        if (ins > 0) return true;
        else return false;
    }

    public ArrayList<StudentDataDetails> viewData(String user, String sem, String sb)
    {
        ArrayList<StudentDataDetails> studentDataDetails = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Log.e("----------------","select tym_slot, sub from timetable where sem = "+sem+" and uname = "+user);
        Cursor cursor = db.rawQuery("select sub, Omrk, Tmrk from InternalMarks where sName = ? and sem = ? and sub = ?", new String[]{user, sem, sb});

        if (cursor.moveToFirst()){
            do {
                String sub = cursor.getString(cursor.getColumnIndex("sub"));
                String mrk = cursor.getString(cursor.getColumnIndex("Omrk"));
                String tmr = cursor.getString(cursor.getColumnIndex("Tmrk"));
                StudentDataDetails temp = new StudentDataDetails(sub, mrk, tmr);
                studentDataDetails.add(temp);
            }while (cursor.moveToNext());
        }

        db.close();

        return studentDataDetails;
    }
}