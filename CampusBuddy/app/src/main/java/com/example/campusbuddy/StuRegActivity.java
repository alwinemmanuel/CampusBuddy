package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class StuRegActivity extends AppCompatActivity {
    CampusBuddy sr;
    TextView lgI;
    String nm, em, nb, dp, ps, cp;
    EditText name, eml, nbr, dpt, pass, c_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_reg);
        sr = new CampusBuddy(this);
        lgI = findViewById(R.id.tv_lgI);
        name = findViewById(R.id.et_name);
        eml = findViewById(R.id.et_email);
        nbr = findViewById(R.id.et_phn);
        dpt = findViewById(R.id.er_dpt);
        pass = findViewById(R.id.et_pass);
        c_pass = findViewById(R.id.et_cpwd);
    }

    public void reg(View view) {
        nm = name.getText().toString();
        em = eml.getText().toString();
        nb = nbr.getText().toString();
        dp = dpt.getText().toString();
        if (pass.getText().toString().equals(c_pass.getText().toString()))
        {
            ps = pass.getText().toString();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Password mismatch", Toast.LENGTH_SHORT).show();
            pass.setHint("Password");
            c_pass.setHint("Confirm Password");
            getCurrentFocus();
        }
        Boolean chkEml = sr.checkSEm(em);
        if (chkEml == true)
        {
            Toast.makeText(this,"Email Already Exists", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Boolean insert = sr.addStudent(nm,em,nb,dp,ps);

            if (insert)
                lgI.setVisibility(View.VISIBLE);
            else
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void lgInt(View view) {
        startActivity(new Intent(getApplicationContext(), StuLoginActivity.class));
    }
}
