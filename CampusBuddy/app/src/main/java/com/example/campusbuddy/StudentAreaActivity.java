package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAreaActivity extends AppCompatActivity {
    TextView user, s1, s2, s3, s4, s5, s6, s7;
    String nm;
    Spinner day, sem;
    ArrayList arrayList_day, arrayList_sem;
    ArrayAdapter arrayAdapter_day, arrayAdapter_sem;

    String[] sub1={
            "PS & CP",
            "DM",
            "AP & S",
            "PM",
            "DF",
            "DL",
            "ASL"
    };

    String[] sub2 = {
            "OOP",
            "DS",
            "OS",
            "OR",
            "COA",
            "OOPL",
            "DSL"
    };

    String[] sub3 = {
            "CN",
            "SE",
            "DBMS",
            "DAA",
            "WP",
            "DBL",
            "WPL"
    };

    String[] sub4 = {
            "ADM",
            "BDT",
            "MC",
            "ML",
            "BI",
            "SDL",
            "MCL"
    };

    String[] sub5 = {
            "WDM",
            "EC",
            "CCS",
            "PP",
            "CG",
            "SMR",
            "MP"
    };

    String[] sub6 = {
            "PVV"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_area);

        Intent gi = getIntent();
        nm = gi.getStringExtra("Username");
        user = findViewById(R.id.tv_usr);
        user.setText(nm);

        s1 = findViewById(R.id.tv_s1);
        s2 = findViewById(R.id.tv_s2);
        s3 = findViewById(R.id.tv_s3);
        s4 = findViewById(R.id.tv_s4);
        s5 = findViewById(R.id.tv_s5);
        s6 = findViewById(R.id.tv_s6);
        s7 = findViewById(R.id.tv_s7);

        day = findViewById(R.id.sp_day);
        sem = findViewById(R.id.sp_sem);

        arrayList_day = new ArrayList<>();
        arrayList_day.add("Select Day");
        arrayList_day.add("Monday");
        arrayList_day.add("Tuesday");
        arrayList_day.add("Wednesday");
        arrayList_day.add("Thursday");
        arrayList_day.add("Friday");
        arrayList_day.add("Saturday");

        arrayAdapter_day = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_day);
        day.setAdapter(arrayAdapter_day);

        arrayList_sem = new ArrayList<>();
        arrayList_sem.add("Select Semester");
        arrayList_sem.add("1");
        arrayList_sem.add("2");
        arrayList_sem.add("3");
        arrayList_sem.add("4");
        arrayList_sem.add("5");
        arrayList_sem.add("6");

        arrayAdapter_sem = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sem);
        sem.setAdapter(arrayAdapter_sem);

        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        s1.setText(sub1[0]);
                        s2.setText(sub1[1]);
                        s3.setText(sub1[2]);
                        s4.setText(sub1[3]);
                        s5.setText(sub1[4]);
                        s6.setText(sub1[5]);
                        s7.setText(sub1[6]);

                        break;

                    case 2:
                        s1.setText(sub2[0]);
                        s2.setText(sub2[1]);
                        s3.setText(sub2[2]);
                        s4.setText(sub2[3]);
                        s5.setText(sub2[4]);
                        s6.setText(sub2[5]);
                        s7.setText(sub2[6]);

                        break;

                    case 3:
                        s1.setText(sub3[0]);
                        s2.setText(sub3[1]);
                        s3.setText(sub3[2]);
                        s4.setText(sub3[3]);
                        s5.setText(sub3[4]);
                        s6.setText(sub3[5]);
                        s7.setText(sub3[6]);

                        break;

                    case 4:
                        s1.setText(sub4[0]);
                        s2.setText(sub4[1]);
                        s3.setText(sub4[2]);
                        s4.setText(sub4[3]);
                        s5.setText(sub4[4]);
                        s6.setText(sub4[5]);
                        s7.setText(sub4[6]);

                        break;

                    case 5:
                        s1.setText(sub5[0]);
                        s2.setText(sub5[1]);
                        s3.setText(sub5[2]);
                        s4.setText(sub5[3]);
                        s5.setText(sub5[4]);
                        s6.setText(sub5[5]);
                        s7.setText(sub5[6]);

                        break;

                    case 6:
                        s1.setText(sub6[0]);
                        s2.setText(sub6[0]);
                        s3.setText(sub6[0]);
                        s4.setText(sub6[0]);
                        s5.setText(sub6[0]);
                        s6.setText(sub6[0]);
                        s7.setText(sub6[0]);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
