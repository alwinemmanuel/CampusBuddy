package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StuLoginActivity extends AppCompatActivity {
    CampusBuddy sl;
    String eml, pass, unm;
    EditText em, ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_login);
        sl = new CampusBuddy(this);

        em = findViewById(R.id.et_Email);
        ps = findViewById(R.id.et_Pass);

    }

    public void regN(View view) {
        startActivity(new Intent(getApplicationContext(),StuRegActivity.class));
    }

    public void log(View view) {
        eml  = em.getText().toString();
        pass = ps.getText().toString();

        if (eml.equals("") || pass.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Required Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Cursor user = sl.fetchStudent(eml,pass);
            if (user.getCount() > 0)
            {
                while (user.moveToNext())
                {
                    unm = user.getString(1);
                }
                Intent ne = new Intent(this, StudentMenu.class);
                ne.putExtra("Username", unm);
                startActivity(ne);
            }
        }
    }
}
