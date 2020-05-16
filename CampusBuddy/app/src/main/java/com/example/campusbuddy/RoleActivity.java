package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class RoleActivity extends AppCompatActivity {

    Spinner role;
    ArrayList arrayList_role;
    ArrayAdapter arrayAdapter_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        role = findViewById(R.id.spRole);
        arrayList_role = new ArrayList();
        arrayList_role.add("--Select Role--");
        arrayList_role.add("Faculty");
        arrayList_role.add("Student");
        arrayAdapter_role = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_role);
        role.setAdapter(arrayAdapter_role);

        role.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1:
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(getApplicationContext(),StuLoginActivity.class));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void facSes(View view) {
        startActivity(new Intent(RoleActivity.this, FacRegisterActivity.class));
    }

    public void stuSes(View view) {
        startActivity(new Intent(RoleActivity.this, StuRegActivity.class));
    }

    public void vSp(View view) {
        role.setVisibility(View.VISIBLE);
    }
}
