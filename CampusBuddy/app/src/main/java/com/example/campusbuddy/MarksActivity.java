package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MarksActivity extends AppCompatActivity {
    Marks marks;
    TextView user;
    EditText sub, stnm, tmrk,omrk;
    Spinner sem, pf;
    ArrayList arrayList_sem, arrayList_pf;
    ArrayAdapter arrayAdapter_sem, arrayAdapter_pf;
    String un, sb, st, tm, om, sm, Pf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        marks = new Marks(this);

        Intent gi = getIntent();

        un = gi.getStringExtra("Username");
        user = findViewById(R.id.tvUsr);
        user.setText(un);
        sub = findViewById(R.id.etSub);
        stnm = findViewById(R.id.etSnm);
        tmrk = findViewById(R.id.etTm);
        omrk = findViewById(R.id.etOm);

        sem = findViewById(R.id.spSem);

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

        pf = findViewById(R.id.spPF);

        arrayList_pf = new ArrayList();
        arrayList_pf.add("--Select Status--");
        arrayList_pf.add("Pass");
        arrayList_pf.add("Fail");

        arrayAdapter_pf = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item,arrayList_pf);
        pf.setAdapter(arrayAdapter_pf);

        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        sm = "1";
                        break;

                    case 2:
                        sm = "2";
                        break;

                    case 3:
                        sm = "3";
                        break;

                    case 4:
                        sm = "4";
                        break;

                    case 5:
                        sm = "5";
                        break;

                    case 6:
                        sm = "6";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        Pf = "Pass";
                        break;

                    case 2:
                        Pf = "Fail";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void sbm(View view) {
        sb = sub.getText().toString();
        st = stnm.getText().toString();
        tm = tmrk.getText().toString();
        om = omrk.getText().toString();

        Boolean insert = marks.addMark(un, sm, sb, tm, om, Pf);
        if (insert == true)
        {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, FacultyMenu.class));
        }
        else
        {
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
        }
    }
}
