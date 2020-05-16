package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    CampusBuddy fl;
    String eml, pass, unm;

    EditText ml, ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fl = new CampusBuddy(this);

        ml = findViewById(R.id.et_Email);
        ps = findViewById(R.id.et_Pass);

        

    }

    public void log(View view) {
        eml = ml.getText().toString();
        pass = ps.getText().toString();

        if (eml.equals("") || pass.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Required Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Cursor user = fl.fetchFaculty(eml,pass);
            if (user.getCount() > 0)
            {
                while (user.moveToNext())
                {
                    unm = user.getString(1);
                }
                Intent ne = new Intent(this, FacultyMenu.class);
                ne.putExtra("Username", unm);
                startActivity(ne);
            }

        }
    }

    public void regN(View view) {
        startActivity(new Intent(getApplicationContext(), FacRegisterActivity.class));
    }
}
