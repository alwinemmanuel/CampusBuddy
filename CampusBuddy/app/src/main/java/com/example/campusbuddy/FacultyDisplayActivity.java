package com.example.campusbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FacultyDisplayActivity extends AppCompatActivity {
    Campus_Extra ft;

    String un, dy, sm, sb, cr, md, tp, dr;

    TextView tvUn, tvDy, tvSm, tvSb, tvCr, tvMd, tvTp, tvDr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_display);
        ft = new Campus_Extra(this);
        Intent gi = getIntent();

        un = gi.getStringExtra("Username");
        dy = gi.getStringExtra("Day");
        sm = gi.getStringExtra("Sem");
        sb = gi.getStringExtra("Sub");
        cr = gi.getStringExtra("Cor");
        md = gi.getStringExtra("Mod");
        tp = gi.getStringExtra("Top");
        dr = gi.getStringExtra("Dur");

        tvUn = findViewById(R.id.tvdUs);
        tvUn.setText(un);

        tvDy = findViewById(R.id.tvdDy);
        tvDy.setText(dy);

        tvSm = findViewById(R.id.tvdSm);
        tvSm.setText(sm);

        tvSb = findViewById(R.id.tvdSb);
        tvSb.setText(sb);

        tvCr = findViewById(R.id.tvdCr);
        tvCr.setText(cr);

        tvMd = findViewById(R.id.tvdMd);
        tvMd.setText(md);

        tvTp = findViewById(R.id.tvdTp);
        tvTp.setText(tp);

        tvDr = findViewById(R.id.tvdDr);
        tvDr.setText(dr);
    }

    public void cnfrm(View view) {
        Boolean insertTable = ft.insTbl(dr, dy, sm, sb, cr, md, tp, un);
        if (insertTable == true)
        {
            Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, FacultyViewActivity.class).putExtra("Username",un));
        }
        else
        {
            Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show();
        }
    }

}
