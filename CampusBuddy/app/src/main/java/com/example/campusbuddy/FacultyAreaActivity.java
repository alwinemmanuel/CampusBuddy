package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.commonsware.cwac.richedit.RichEditText;

import java.util.ArrayList;

public class FacultyAreaActivity extends AppCompatActivity {
    Campus_Extra ft;
    String un, dy,sm,sb,cr,md,dr, tp;
    Spinner day, sem, sub, cor, mod, dur;
    ArrayList arrayList_day, arrayList_sem, arrayList_mod, arrayList_dur,
            arrayList_sub1, arrayList_sub2, arrayList_sub3, arrayList_sub4, arrayList_sub5, arrayList_sub6,
            arrayList_cor1, arrayList_cor2, arrayList_cor3, arrayList_cor4, arrayList_cor5, arrayList_cor6;
    ArrayAdapter arrayAdapter_day, arrayAdapter_sem, arrayAdapter_sub, arrayAdapter_cor, arrayAdapter_mod, arrayAdapter_dur;
    TextView unm;
    EditText top;
    Button upload, vWe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_area);
        ft = new Campus_Extra(this);

//        ***********************************************ACCEPTING USERNAME INTENTED FROM PREVIOUS ACTIVITY AND DISPLAY IN TEXTBOX**********************************************************************

        Intent gi = getIntent();
        un = gi.getStringExtra("Username");
        unm = findViewById(R.id.tv_usr);
        unm.setText(un);

//        *****************************************************************************END OF PROCESS****************************************************************************************************
        sub = findViewById(R.id.sp_sub);
        cor = findViewById(R.id.sp_cor);
        mod = findViewById(R.id.sp_mod);
        dur = findViewById(R.id.sp_dur);
        top = findViewById(R.id.ret_top);




        day = findViewById(R.id.sp_day);

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

        sem = findViewById(R.id.sp_sem);

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
                        sm = "1";
                        sub.setVisibility(View.VISIBLE);
                        arrayList_sub1 = new ArrayList<>();
                        arrayList_sub1.add("Choose subjects");
                        arrayList_sub1.add("RLMCA101 - PS & CP");
                        arrayList_sub1.add("RLMCA103 - DM");
                        arrayList_sub1.add("RLMCA105 - AP & S");
                        arrayList_sub1.add("RLMCA107 - PM");
                        arrayList_sub1.add("RLMCA109 - DF");
                        arrayList_sub1.add("RLMCA131 - PL");
                        arrayList_sub1.add("RLMCA133 - ASL");

                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub1);
                        sub.setAdapter(arrayAdapter_sub);

                        cor.setVisibility(View.VISIBLE);
                        arrayList_cor1 = new ArrayList<>();
                        arrayList_cor1.add("Choose C_Code");
                        arrayList_cor1.add("RLMCA101");
                        arrayList_cor1.add("RLMCA103");
                        arrayList_cor1.add("RLMCA105");
                        arrayList_cor1.add("RLMCA107");
                        arrayList_cor1.add("RLMCA109");
                        arrayList_cor1.add("RLMCA131");
                        arrayList_cor1.add("RLMCA133");

                        arrayAdapter_cor = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_cor1);
                        cor.setAdapter(arrayAdapter_cor);

                        mod.setVisibility(View.VISIBLE);
                        arrayList_mod = new ArrayList<>();
                        arrayList_mod.add("Choose Module");
                        arrayList_mod.add("1");
                        arrayList_mod.add("2");
                        arrayList_mod.add("3");
                        arrayList_mod.add("4");
                        arrayList_mod.add("5");
                        arrayList_mod.add("6");

                        arrayAdapter_mod = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_mod);
                        mod.setAdapter(arrayAdapter_mod);

                        top.setVisibility(View.VISIBLE);

                        dur.setVisibility(View.VISIBLE);
                        arrayList_dur = new ArrayList<>();
                        arrayList_dur.add("Select Time Slot");
                        arrayList_dur.add("09:15 AM to 10:15 AM");
                        arrayList_dur.add("10:15 AM to 11:15 AM");
                        arrayList_dur.add("11:25 AM to 12:30 PM");
                        arrayList_dur.add("12:30 PM to 01:00 PM");
                        arrayList_dur.add("01:45 PM to 02:30 PM");
                        arrayList_dur.add("02:30 PM to 03:30 PM");
                        arrayList_dur.add("03:30 PM to 04:30 PM");

                        arrayAdapter_dur = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_dur);
                        dur.setAdapter(arrayAdapter_dur);

                        break;

                    case 2:
                        sm = "2";
                        sub.setVisibility(View.VISIBLE);
                        arrayList_sub2 = new ArrayList<>();
                        arrayList_sub2.add("Choose subjects");
                        arrayList_sub2.add("RLMCA102 - OOP");
                        arrayList_sub2.add("RLMCA104 - DS");
                        arrayList_sub2.add("RLMCA106 - OS");
                        arrayList_sub2.add("RLMCA108 - OR");
                        arrayList_sub2.add("RLMCA112 - COA");
                        arrayList_sub2.add("RLMCA132 - OOPL");
                        arrayList_sub2.add("RLMCA134 - DSL");

                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub2);
                        sub.setAdapter(arrayAdapter_sub);

                        cor.setVisibility(View.VISIBLE);
                        arrayList_cor2 = new ArrayList<>();
                        arrayList_cor2.add("Choose C_Code");
                        arrayList_cor2.add("RLMCA102");
                        arrayList_cor2.add("RLMCA104");
                        arrayList_cor2.add("RLMCA106");
                        arrayList_cor2.add("RLMCA108");
                        arrayList_cor2.add("RLMCA112");
                        arrayList_cor2.add("RLMCA132");
                        arrayList_cor2.add("RLMCA134");

                        arrayAdapter_cor = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_cor2);
                        cor.setAdapter(arrayAdapter_cor);

                        mod.setVisibility(View.VISIBLE);

                        arrayList_mod = new ArrayList<>();
                        arrayList_mod.add("Choose Module");
                        arrayList_mod.add("1");
                        arrayList_mod.add("2");
                        arrayList_mod.add("3");
                        arrayList_mod.add("4");
                        arrayList_mod.add("5");
                        arrayList_mod.add("6");

                        arrayAdapter_mod = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_mod);
                        mod.setAdapter(arrayAdapter_mod);

                        top.setVisibility(View.VISIBLE);

                        dur.setVisibility(View.VISIBLE);
                        arrayList_dur = new ArrayList<>();
                        arrayList_dur.add("Select Time Slot");
                        arrayList_dur.add("09:15 AM to 10:15 AM");
                        arrayList_dur.add("10:15 AM to 11:15 AM");
                        arrayList_dur.add("11:25 AM to 12:30 PM");
                        arrayList_dur.add("12:30 PM to 01:00 PM");
                        arrayList_dur.add("01:45 PM to 02:30 PM");
                        arrayList_dur.add("02:30 PM to 03:30 PM");
                        arrayList_dur.add("03:30 PM to 04:30 PM");

                        arrayAdapter_dur = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_dur);
                        dur.setAdapter(arrayAdapter_dur);

                        break;

                    case 3:
                        sm = "3";
                        sub.setVisibility(View.VISIBLE);
                        arrayList_sub3 = new ArrayList<>();
                        arrayList_sub3.add("Choose subjects");
                        arrayList_sub3.add("RLMCA201 - CN");
                        arrayList_sub3.add("RLMCA203 - SE");
                        arrayList_sub3.add("RLMCA205 - DBMS");
                        arrayList_sub3.add("RLMCA207 - DAA");
                        arrayList_sub3.add("RLMCA209 - WP");
                        arrayList_sub3.add("RLMCA231 - DBL");
                        arrayList_sub3.add("RLMCA233 - WPL");

                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub3);
                        sub.setAdapter(arrayAdapter_sub);

                        cor.setVisibility(View.VISIBLE);
                        arrayList_cor3 = new ArrayList<>();
                        arrayList_cor3.add("Choose C_Code");
                        arrayList_cor3.add("RLMCA201");
                        arrayList_cor3.add("RLMCA203");
                        arrayList_cor3.add("RLMCA205");
                        arrayList_cor3.add("RLMCA207");
                        arrayList_cor3.add("RLMCA209");
                        arrayList_cor3.add("RLMCA231");
                        arrayList_cor3.add("RLMCA233");

                        arrayAdapter_cor = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_cor3);
                        cor.setAdapter(arrayAdapter_cor);

                        mod.setVisibility(View.VISIBLE);

                        arrayList_mod = new ArrayList<>();
                        arrayList_mod.add("Choose Module");
                        arrayList_mod.add("1");
                        arrayList_mod.add("2");
                        arrayList_mod.add("3");
                        arrayList_mod.add("4");
                        arrayList_mod.add("5");
                        arrayList_mod.add("6");

                        arrayAdapter_mod = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_mod);
                        mod.setAdapter(arrayAdapter_mod);

                        top.setVisibility(View.VISIBLE);

                        dur.setVisibility(View.VISIBLE);
                        arrayList_dur = new ArrayList<>();
                        arrayList_dur.add("Select Time Slot");
                        arrayList_dur.add("09:15 AM to 10:15 AM");
                        arrayList_dur.add("10:15 AM to 11:15 AM");
                        arrayList_dur.add("11:25 AM to 12:30 PM");
                        arrayList_dur.add("12:30 PM to 01:00 PM");
                        arrayList_dur.add("01:45 PM to 02:30 PM");
                        arrayList_dur.add("02:30 PM to 03:30 PM");
                        arrayList_dur.add("03:30 PM to 04:30 PM");

                        arrayAdapter_dur = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_dur);
                        dur.setAdapter(arrayAdapter_dur);

                        break;

                    case 4:
                        sm = "4";
                        sub.setVisibility(View.VISIBLE);
                        arrayList_sub4 = new ArrayList<>();
                        arrayList_sub4.add("Choose subjects");
                        arrayList_sub4.add("RLMCA202 - ADM");
                        arrayList_sub4.add("RLMCA204 - BDT");
                        arrayList_sub4.add("RLMCA206 - MC");
                        arrayList_sub4.add("RLMCA208 - ML");
                        arrayList_sub4.add("RLMCA274 - BI");
                        arrayList_sub4.add("RLMCA232 - SDL");
                        arrayList_sub4.add("RLMCA234 - MCL");

                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub4);
                        sub.setAdapter(arrayAdapter_sub);

                        cor.setVisibility(View.VISIBLE);
                        arrayList_cor4 = new ArrayList<>();
                        arrayList_cor4.add("Choose C_Code");
                        arrayList_cor4.add("RLMCA202");
                        arrayList_cor4.add("RLMCA204");
                        arrayList_cor4.add("RLMCA206");
                        arrayList_cor4.add("RLMCA208");
                        arrayList_cor4.add("RLMCA212");
                        arrayList_cor4.add("RLMCA232");
                        arrayList_cor4.add("RLMCA234");

                        arrayAdapter_cor = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_cor4);
                        cor.setAdapter(arrayAdapter_cor);

                        mod.setVisibility(View.VISIBLE);

                        arrayList_mod = new ArrayList<>();
                        arrayList_mod.add("Choose Module");
                        arrayList_mod.add("1");
                        arrayList_mod.add("2");
                        arrayList_mod.add("3");
                        arrayList_mod.add("4");
                        arrayList_mod.add("5");
                        arrayList_mod.add("6");

                        arrayAdapter_mod = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_mod);
                        mod.setAdapter(arrayAdapter_mod);

                        top.setVisibility(View.VISIBLE);

                        dur.setVisibility(View.VISIBLE);
                        arrayList_dur = new ArrayList<>();
                        arrayList_dur.add("Select Time Slot");
                        arrayList_dur.add("09:15 AM to 10:15 AM");
                        arrayList_dur.add("10:15 AM to 11:15 AM");
                        arrayList_dur.add("11:25 AM to 12:30 PM");
                        arrayList_dur.add("12:30 PM to 01:00 PM");
                        arrayList_dur.add("01:45 PM to 02:30 PM");
                        arrayList_dur.add("02:30 PM to 03:30 PM");
                        arrayList_dur.add("03:30 PM to 04:30 PM");

                        arrayAdapter_dur = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_dur);
                        dur.setAdapter(arrayAdapter_dur);

                        break;

                    case 5:
                        sm = "5";
                        sub.setVisibility(View.VISIBLE);
                        arrayList_sub5 = new ArrayList<>();
                        arrayList_sub5.add("Choose subjects");
                        arrayList_sub5.add("RLMCA301 - WDM");
                        arrayList_sub5.add("RLMCA303 - EC");
                        arrayList_sub5.add("RLMCA305 - CCS");
                        arrayList_sub5.add("RLMCA369 - PP");
                        arrayList_sub5.add("RLMCA387 - CG");
                        arrayList_sub5.add("RLMCA341 - SMR");
                        arrayList_sub5.add("RLMCA351 - MP");


                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub5);
                        sub.setAdapter(arrayAdapter_sub);

                        cor.setVisibility(View.VISIBLE);
                        arrayList_cor5 = new ArrayList<>();
                        arrayList_cor5.add("Choose C_Code");
                        arrayList_cor5.add("RLMCA301");
                        arrayList_cor5.add("RLMCA303");
                        arrayList_cor5.add("RLMCA305");
                        arrayList_cor5.add("RLMCA369");
                        arrayList_cor5.add("RLMCA387");
                        arrayList_cor5.add("RLMCA341");
                        arrayList_cor5.add("RLMCA351");

                        arrayAdapter_cor = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_cor5);
                        cor.setAdapter(arrayAdapter_cor);

                        mod.setVisibility(View.VISIBLE);

                        arrayList_mod = new ArrayList<>();
                        arrayList_mod.add("Choose Module");
                        arrayList_mod.add("1");
                        arrayList_mod.add("2");
                        arrayList_mod.add("3");
                        arrayList_mod.add("4");
                        arrayList_mod.add("5");
                        arrayList_mod.add("6");

                        arrayAdapter_mod = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_mod);
                        mod.setAdapter(arrayAdapter_mod);

                        top.setVisibility(View.VISIBLE);

                        dur.setVisibility(View.VISIBLE);
                        arrayList_dur = new ArrayList<>();
                        arrayList_dur.add("Select Time Slot");
                        arrayList_dur.add("09:15 AM to 10:15 AM");
                        arrayList_dur.add("10:15 AM to 11:15 AM");
                        arrayList_dur.add("11:25 AM to 12:30 PM");
                        arrayList_dur.add("12:30 PM to 01:00 PM");
                        arrayList_dur.add("01:45 PM to 02:30 PM");
                        arrayList_dur.add("02:30 PM to 03:30 PM");
                        arrayList_dur.add("03:30 PM to 04:30 PM");

                        arrayAdapter_dur = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_dur);
                        dur.setAdapter(arrayAdapter_dur);

                        break;

                    case 6:
                         sm = "6";
                        sub.setVisibility(View.VISIBLE);
                        arrayList_sub6 = new ArrayList<>();
                        arrayList_sub6.add("Choose subjects");
                        arrayList_sub6.add("RLMCA352 - PVV");

                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub5);
                        sub.setAdapter(arrayAdapter_sub);

                        cor.setVisibility(View.VISIBLE);
                        arrayList_cor6 = new ArrayList<>();
                        arrayList_cor6.add("Choose C_Code");
                        arrayList_cor6.add("RLMCA352");

                        arrayAdapter_cor = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_cor6);
                        cor.setAdapter(arrayAdapter_cor);

                        mod.setVisibility(View.VISIBLE);

                        arrayList_mod = new ArrayList<>();
                        arrayList_mod.add("Choose Module");
                        arrayList_mod.add("1");
                        arrayList_mod.add("2");
                        arrayList_mod.add("3");
                        arrayList_mod.add("4");
                        arrayList_mod.add("5");
                        arrayList_mod.add("6");

                        arrayAdapter_mod = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_mod);
                        mod.setAdapter(arrayAdapter_mod);

                        top.setVisibility(View.VISIBLE);

                        dur.setVisibility(View.VISIBLE);
                        arrayList_dur = new ArrayList<>();
                        arrayList_dur.add("Select Time Slot");
                        arrayList_dur.add("09:15 AM to 10:15 AM");
                        arrayList_dur.add("10:15 AM to 11:15 AM");
                        arrayList_dur.add("11:25 AM to 12:30 PM");
                        arrayList_dur.add("12:30 PM to 01:00 PM");
                        arrayList_dur.add("01:45 PM to 02:30 PM");
                        arrayList_dur.add("02:30 PM to 03:30 PM");
                        arrayList_dur.add("03:30 PM to 04:30 PM");

                        arrayAdapter_dur = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_dur);
                        dur.setAdapter(arrayAdapter_dur);

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        dy = "Monday";
                        break;

                    case 2:
                        dy = "Tuesday";
                        break;

                    case 3:
                        dy = "Wednesday";
                        break;

                    case 4:
                        dy = "Thursday";
                        break;

                    case 5:
                        dy = "Friday";
                        break;

                    case 6:
                        dy = "Saturday";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (sm == "1")
                {
                    switch (position)
                    {
                        case 1:
                            sb = "PS & CP";
                            break;

                        case 2:
                            sb = "DM";
                            break;

                        case 3:
                            sb = "AP & S";
                            break;

                        case 4:
                            sb = "PM";
                            break;

                        case 5:
                            sb = "DF";
                            break;

                        case 6:
                            sb = "DL";
                            break;

                        case 7:
                            sb = "ASL";
                            break;
                    }
                }
                else  if (sm == "2")
                {
                    switch (position)
                    {
                        case 1:
                            sb = "OOP";
                            break;

                        case 2:
                            sb = "DS";
                            break;

                        case 3:
                            sb = "OS";
                            break;

                        case 4:
                            sb = "OR";
                            break;

                        case 5:
                            sb = "COA";
                            break;

                        case 6:
                            sb = "OOPL";
                            break;

                        case 7:
                            sb = "DSL";
                            break;
                    }
                }
                else if (sm == "3")
                {
                    switch (position)
                    {
                        case 1:
                            sb = "CN";
                            break;

                        case 2:
                            sb = "SE";
                            break;

                        case 3:
                            sb = "DBMS";
                            break;

                        case 4:
                            sb = "DAA";
                            break;

                        case 5:
                            sb = "WP";
                            break;

                        case 6:
                            sb = "DBL";

                        case 7:
                            sb = "WPL";
                            break;
                    }
                }
                else if (sm == "4")
                {
                    switch (position)
                    {
                        case 1:
                            sb = "ADM";
                            break;

                        case 2:
                            sb = "BDT";
                            break;

                        case 3:
                            sb = "MC";
                            break;

                        case 4:
                            sb = "ML";
                            break;

                        case 5:
                            sb = "BI";
                            break;

                        case 6:
                            sb = "SDL";
                            break;

                        case 7:
                            sb = "MCL";
                            break;
                    }
                }
                else if (sm == "5")
                {
                    switch (position)
                    {
                        case 1:
                            sb = "WDM";
                            break;

                        case 2:
                            sb = "EC";
                            break;

                        case 3:
                            sb = "CCS";
                            break;

                        case 4:
                            sb = "PP";
                            break;

                        case 5:
                            sb = "CG";
                            break;

                        case 6:
                            sb = "SMR";
                            break;

                        case  7:
                            sb = "MP";
                            break;
                    }
                }
                else
                {
                    switch (position)
                    {
                        case 1:
                            sb = "PVV";
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (sm == "1")
                {
                    switch (position)
                    {
                        case 0:
                            cr = "RLMCA101";
                            break;

                        case 2:
                            cr = "RLMCA103";
                            break;

                        case 3:
                            cr = "RLMCA105";
                            break;

                        case 4:
                            cr = "RLMCA107";
                            break;

                        case 5:
                            cr = "RLMCA109";
                            break;

                        case 6:
                            cr = "RLMCA131";
                            break;

                        case 7:
                            cr = "RLMCA133";
                            break;
                    }
                }
                else if (sm == "2")
                {
                    switch (position)
                    {
                        case 1:
                            cr = "RLMCA102";
                            break;

                        case 2:
                            cr = "RLMCA104";
                            break;

                        case 3:
                            cr = "RLMCA106";
                            break;

                        case 4:
                            cr = "RLMCA108";
                            break;

                        case 5:
                            cr = "RLMCA112";
                            break;

                        case 6:
                            cr = "RLMCA132";
                            break;

                        case 7:
                            cr = "RLMCA134";
                            break;
                    }
                }
                else if (sm == "3")
                {
                    switch (position)
                    {
                        case 1:
                            cr = "RLMCA201";
                            break;

                        case 2:
                            cr = "RLMCA203";
                            break;

                        case 3:
                            cr = "RLMCA205";
                            break;

                        case 4:
                            cr = "RLMCA207";
                            break;

                        case 5:
                            cr = "RLMCA209";
                            break;

                        case 6:
                            cr = "RLMCA231";
                            break;

                        case 7:
                            cr = "RLMCA233";
                            break;
                    }
                }
                else if (sm =="4")
                {
                    switch (position)
                    {
                        case 1:
                            cr = "RLMCA202";
                            break;

                        case 2:
                            cr = "RLMCA204";
                            break;

                        case 3:
                            cr = "RLMCA206";
                            break;

                        case 4:
                            cr = "RLMCA208";
                            break;

                        case 5:
                            cr = "RLMCA212";
                            break;

                        case 6:
                            cr = "RLMCA232";
                            break;

                        case 7:
                            cr = "RLMCA234";
                            break;
                    }
                }
                else if (sm == "5")
                {
                    switch (position)
                    {
                        case 1:
                            cr = "RLMCA301";
                            break;

                        case 2:
                            cr = "RLMCA303";
                            break;

                        case 3:
                            cr = "RLMCA305";
                            break;

                        case 4:
                            cr = "RLMCA369";
                            break;

                        case 5:
                            cr = "RLMCA387";
                            break;

                        case 6:
                            cr = "RLMCA341";
                            break;

                        case 7:
                            cr = "RLMCA351";
                            break;
                    }
                }
                else
                {
                    switch (position)
                    {
                        case 1:
                            cr = "RLMCA352";
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        md = "1";

                        break;

                    case 2:
                        md = "2";

                        break;

                    case 3:
                        md = "3";

                        break;

                    case 4:
                        md = "4";

                        break;

                    case 5:
                        md = "5";

                        break;

                    case 6:
                        md = "6";

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tp = top.getText().toString();

        dur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        dr = "09:15 AM to 10:15 AM";
                        break;

                    case 2:
                        dr = "10:15 AM to 11:15 AM";
                        break;

                    case 3:
                        dr = "11:25 AM to 12:30 PM";
                        break;

                    case 4:
                        dr = "12:30 PM to 01:00 PM";
                        break;

                    case 5:
                        dr = "01:45 PM to 02:30 PM";
                        break;

                    case 6:
                        dr = "02:30 PM to 03:30 PM";
                        break;

                    case 7:
                        dr = "03:30 PM to 04:30 PM";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void cnfTbl(View view) {

        Intent disp = new Intent(getApplicationContext(), FacultyDisplayActivity.class);
        disp.putExtra("Username", un);
        disp.putExtra("Day", dy);
        disp.putExtra("Sem", sm);
        disp.putExtra("Sub", sb);
        disp.putExtra("Cor", cr);
        disp.putExtra("Mod", md);
        disp.putExtra("Top", top.getText().toString());
        disp.putExtra("Dur", dr);

        startActivity(disp);

    }


    public void vwS(View view) {
        Cursor cursor = ft.fetchTable(un);
        if (cursor.getCount() > 0)
        {
            startActivity(new Intent(this, FacultyViewActivity.class).putExtra("Username", un));
        }
        else
        {
            Toast.makeText(this, "Nothing to View", Toast.LENGTH_SHORT).show();
        }
    }
}
