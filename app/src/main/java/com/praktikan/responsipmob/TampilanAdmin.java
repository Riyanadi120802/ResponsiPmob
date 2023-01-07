package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TampilanAdmin extends AppCompatActivity {

    TextView edit, hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_admin);

        edit = (TextView) findViewById(R.id.menu1);
        hapus = (TextView) findViewById(R.id.menu2);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte2 = new Intent(TampilanAdmin.this, TampilanData.class);
                startActivity(inte2);
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte2 = new Intent(TampilanAdmin.this, TampilanData2.class);
                startActivity(inte2);
            }
        });
    }
}