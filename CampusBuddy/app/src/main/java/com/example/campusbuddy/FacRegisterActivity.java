package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class FacRegisterActivity extends AppCompatActivity {
    CampusBuddy fr;
    String nm, em, nb, dp, ps;
    TextView in;
    EditText name, eml, nbr, dpt, pass, c_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac_register);
        fr = new CampusBuddy(this);
        in = findViewById(R.id.tv_lgI);
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
        Boolean chkEml = fr.checkFEm(em);
        if (chkEml == true)
        {
            Toast.makeText(this, "Email Already Exists", Toast.LENGTH_SHORT).show();
            eml.setText("");
            nbr.setText("");
            dpt.setText("");
        }
        else
        {
            Boolean insert = fr.addFaculty(nm,em,nb,dp,ps);
            if (insert)
                in.setVisibility(View.VISIBLE);
            else
                Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show();
        }


    }

    public void lgInt(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}
