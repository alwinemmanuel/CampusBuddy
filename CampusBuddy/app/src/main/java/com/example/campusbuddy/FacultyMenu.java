package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FacultyMenu extends AppCompatActivity {
    String un;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_menu);
        Intent gi = getIntent();
        un = gi.getStringExtra("Username");
    }

    public void aS(View view) {
        startActivity(new Intent(this, FacultyAreaActivity.class).putExtra("Username", un));
    }

    public void vS(View view) {
        startActivity(new Intent(this, FacultyViewActivity.class).putExtra("Username", un));
    }

    public void aI(View view) {
        startActivity(new Intent(this, MarksActivity.class).putExtra("Username", un));
    }

    public void vR(View view) {
    }
}
