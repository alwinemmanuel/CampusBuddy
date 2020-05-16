package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentMarkDetailsActivity extends AppCompatActivity {
    Marks marks;
    Spinner sem, sub;
    ArrayList arrayList_sem, arrayList_sub1, arrayList_sub2, arrayList_sub3, arrayList_sub4, arrayList_sub5, arrayList_sub6;
    ArrayAdapter arrayAdapter_sem, arrayAdapter_sub;
    TextView user;
    String un, sm, sb;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_mark_details);
        Intent gi = getIntent();
        un = gi.getStringExtra("Username");
        user = findViewById(R.id.tvstNm);
        user.setText(un);
        tableLayout = findViewById(R.id.tableLayout);
        marks = new Marks(this);
        
        sem = findViewById(R.id.spSem);
        sub = findViewById(R.id.spSub);
        
        arrayList_sem = new ArrayList();
        arrayList_sem.add("--Select Sem--");
        arrayList_sem.add("1");
        arrayList_sem.add("2");
        arrayList_sem.add("3");
        arrayList_sem.add("4");
        arrayList_sem.add("5");
        arrayList_sem.add("6");
        
        arrayAdapter_sem = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item,arrayList_sem);
        sem.setAdapter(arrayAdapter_sem);

        arrayList_sub1 = new ArrayList<>();
        arrayList_sub1.add("Choose subjects");
        arrayList_sub1.add("RLMCA101 - PS & CP");
        arrayList_sub1.add("RLMCA103 - DM");
        arrayList_sub1.add("RLMCA105 - AP & S");
        arrayList_sub1.add("RLMCA107 - PM");
        arrayList_sub1.add("RLMCA109 - DF");
        arrayList_sub1.add("RLMCA131 - PL");
        arrayList_sub1.add("RLMCA133 - ASL");

        arrayList_sub2 = new ArrayList<>();
        arrayList_sub2.add("Choose subjects");
        arrayList_sub2.add("RLMCA102 - OOP");
        arrayList_sub2.add("RLMCA104 - DS");
        arrayList_sub2.add("RLMCA106 - OS");
        arrayList_sub2.add("RLMCA108 - OR");
        arrayList_sub2.add("RLMCA112 - COA");
        arrayList_sub2.add("RLMCA132 - OOPL");
        arrayList_sub2.add("RLMCA134 - DSL");

        arrayList_sub3 = new ArrayList<>();
        arrayList_sub3.add("Choose subjects");
        arrayList_sub3.add("RLMCA201 - CN");
        arrayList_sub3.add("RLMCA203 - SE");
        arrayList_sub3.add("RLMCA205 - DBMS");
        arrayList_sub3.add("RLMCA207 - DAA");
        arrayList_sub3.add("RLMCA209 - WP");
        arrayList_sub3.add("RLMCA231 - DBL");
        arrayList_sub3.add("RLMCA233 - WPL");

        arrayList_sub4 = new ArrayList<>();
        arrayList_sub4.add("Choose subjects");
        arrayList_sub4.add("RLMCA202 - ADM");
        arrayList_sub4.add("RLMCA204 - BDT");
        arrayList_sub4.add("RLMCA206 - MC");
        arrayList_sub4.add("RLMCA208 - ML");
        arrayList_sub4.add("RLMCA274 - BI");
        arrayList_sub4.add("RLMCA232 - SDL");
        arrayList_sub4.add("RLMCA234 - MCL");

        arrayList_sub5 = new ArrayList<>();
        arrayList_sub5.add("Choose subjects");
        arrayList_sub5.add("RLMCA301 - WDM");
        arrayList_sub5.add("RLMCA303 - EC");
        arrayList_sub5.add("RLMCA305 - CCS");
        arrayList_sub5.add("RLMCA369 - PP");
        arrayList_sub5.add("RLMCA387 - CG");
        arrayList_sub5.add("RLMCA341 - SMR");
        arrayList_sub5.add("RLMCA351 - MP");

        arrayList_sub6 = new ArrayList<>();
        arrayList_sub6.add("Choose subjects");
        arrayList_sub6.add("RLMCA352 - PVV");
        
        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        sm = "1";
                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub1);
                        sub.setAdapter(arrayAdapter_sub);
                        break;

                    case 2:
                        sm = "2";
                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub2);
                        sub.setAdapter(arrayAdapter_sub);
                        break;

                    case 3:
                        sm = "3";
                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub3);
                        sub.setAdapter(arrayAdapter_sub);
                        break;

                    case 4:
                        sm = "4";
                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub4);
                        sub.setAdapter(arrayAdapter_sub);
                        break;

                    case 5:
                        sm = "5";
                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub5);
                        sub.setAdapter(arrayAdapter_sub);
                        break;

                    case 6:
                        sm = "6";
                        arrayAdapter_sub = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,arrayList_sub6);
                        sub.setAdapter(arrayAdapter_sub);
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
        
    }

    public void vwNw(View view) {
        tableLayout.removeAllViews();
        ArrayList<StudentDataDetails> studentDataDetails = marks.viewData(un, sm, sb);
        
        if (studentDataDetails.size() == 0)
        {
            TableRow tr = new TableRow(this);


            TableLayout.LayoutParams tableRowParams =
                    new TableLayout.LayoutParams
                            (TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);


            int leftMargin = 0;
            int topMargin = 0;
            int rightMargin = 0;
            int bottomMargin = 5;

            tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
            tr.setLayoutParams(tableRowParams);


            TextView t1 = new TextView(this);
            t1.setText("No available marks");
            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

            tr.addView(t1);

            tableLayout.addView(tr, tableRowParams);
        }else {
            
            for (int i = 0; i < studentDataDetails.size(); i++){
                TableRow tr = new TableRow(this);

                TableLayout.LayoutParams tableRowParams =
                        new TableLayout.LayoutParams
                                (TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);


                int leftMargin = 0;
                int topMargin = 0;
                int rightMargin = 0;
                int bottomMargin = 5;

                tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
                tr.setLayoutParams(tableRowParams);

                TextView t1 = new TextView(this);
                t1.setText(studentDataDetails.get(i).getSub());
                t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


                TextView t2 = new TextView(this);
                t2.setText(studentDataDetails.get(i).getMrk());
                t2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

                TextView t3 = new TextView(this);
                t3.setText(studentDataDetails.get(i).getTmr());
                t3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


                tr.addView(t1);
                tr.addView(t2);
                tr.addView(t3);

                tableLayout.addView(tr, tableRowParams);

                System.out.println(studentDataDetails.get(i).getSub());
                System.out.println(studentDataDetails.get(i).getMrk());
                System.out.println(studentDataDetails.get(i).getTmr());
            }
        }
    }

}
