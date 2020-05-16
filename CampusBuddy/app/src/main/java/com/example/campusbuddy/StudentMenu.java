package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentMenu extends AppCompatActivity {
    Marks vMrk;
    String un;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);
        vMrk = new Marks(this);
        Intent gi = getIntent();
        un = gi.getStringExtra("Username");
    }

    public void vT(View view) {
        startActivity(new Intent(this, StudentAreaActivity.class).putExtra("Username",un));
    }

    public void vM(View view) {
        startActivity(new Intent(this, StudentMarkDetailsActivity.class).putExtra("Username",un));
    }
}
