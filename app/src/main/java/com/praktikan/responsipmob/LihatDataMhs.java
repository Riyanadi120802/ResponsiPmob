package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatDataMhs extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    Button ton2;
    TextView text1, text2, text3, text4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_mhs);
        dbHelper = new DatabaseHelper(this);
        text1 = (TextView) findViewById(R.id.isiNama);
        text2 = (TextView) findViewById(R.id.isiNIM);
        text3 = (TextView) findViewById(R.id.isiKelas);
        text4 = (TextView) findViewById(R.id.isiProdi);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Mhs WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString());
            text4.setText(cursor.getString(4).toString());
        }

        ton2 = (Button) findViewById(R.id.btn2);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte2 = new Intent(LihatDataMhs.this, TampilanAdmin.class);
                startActivity(inte2);
            }
        });


    }

}