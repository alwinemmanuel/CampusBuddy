package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FacultyViewActivity extends AppCompatActivity {
    Campus_Extra ft;

    TextView user, hr, sb;

    String un;

    TableLayout tableLayout;

    Spinner day; EditText sem;
    ArrayList  arrayList_day; ArrayAdapter arrayAdapter_day;
    Button vWn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_view);
        ft = new Campus_Extra(this);

        Intent gi = getIntent();
        un = gi.getStringExtra("Username");
        user = findViewById(R.id.tv_usr);
        user.setText(un);

//        hr = findViewById(R.id.tvHr);
//        sb = findViewById(R.id.tvSb);

        tableLayout = findViewById(R.id.tableLayout);

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

        sem = findViewById(R.id.etSm);


        vWn = findViewById(R.id.btVn);



    }

    public void vn(View view) {
        tableLayout.removeAllViews();
        String sm = sem.getText().toString();
        sm = sm.trim();
        ArrayList<FacultyDataDetails> facultyDataDetails = ft.viewData(un, sm);

        if (facultyDataDetails.size() == 0) {
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
            t1.setText("No scheduled session");
            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

            tr.addView(t1);

            tableLayout.addView(tr, tableRowParams);
        }else{

        for (int i = 0; i < facultyDataDetails.size(); i++) {
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
            t1.setText(facultyDataDetails.get(i).getSub());
            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


            TextView t2 = new TextView(this);
            t2.setText(facultyDataDetails.get(i).getTym());
            t2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

            TextView t3 = new TextView(this);
            t3.setText(facultyDataDetails.get(i).getTopic());
            t3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

            tr.addView(t1);
            tr.addView(t2);
            tr.addView(t3);

            tableLayout.addView(tr, tableRowParams);


            System.out.println(facultyDataDetails.get(i).getSub());
            System.out.println(facultyDataDetails.get(i).getTym());
        }
    }

        System.out.println();
//        if (fetchData.getCount() > 0)
//        {
//            while (fetchData.moveToNext())
//            {
//                hr.setText(fetchData.getString(0)+ "\n");
//                sb.setText(fetchData.getString(3)+ "\n");
//            }
//        }
//        else
//        {
//            Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show();
//        }
    }

}
