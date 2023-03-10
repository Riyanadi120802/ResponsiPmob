package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CetakData extends AppCompatActivity {
    protected Cursor cursor;
    private DatabaseHelper dbHelper;
    private TextView text1, text2, text3, text4;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak_data);

        btn1 = (Button) findViewById(R.id.button2);
        btn2 = (Button) findViewById(R.id.ubah);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte2 = new Intent(CetakData.this, TampilanMhs.class);
                startActivity(inte2);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CetakData.this, "Cetak Data Berhasil", Toast.LENGTH_LONG).show();
                Intent inte3 = new Intent(CetakData.this, TampilanMhs.class);
                startActivity(inte3);
            }
        });

        dbHelper = new DatabaseHelper(this);
        text1 = (TextView) findViewById(R.id.isiNama);
        text2 = (TextView) findViewById(R.id.isiNIM);
        text3 = (TextView) findViewById(R.id.isiKelas);
        text4 = (TextView) findViewById(R.id.isiProdi);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Mhs ORDER BY id DESC LIMIT 1", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString());
            text4.setText(cursor.getString(4).toString());
        }

    }
}