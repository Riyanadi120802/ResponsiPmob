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
import android.widget.EditText;
import android.widget.Toast;

public class UpdateData extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        dbHelper = new DatabaseHelper(this);
        text1 = (EditText) findViewById(R.id.etNama);
        text2 = (EditText) findViewById(R.id.etNIM);
        text3 = (EditText) findViewById(R.id.etKelas);
        text4 = (EditText) findViewById(R.id.etProdi);
        ton1 = (Button) findViewById(R.id.btnSimpan);
        ton2 = (Button) findViewById(R.id.btnKembali);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT nama, NIM, Kelas, prodi FROM Mhs WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
        }

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE Mhs SET nama='"+
                        text1.getText().toString() +"', NIM='" +
                        text2.getText().toString()+"', Kelas='"+
                        text3.getText().toString()+"', prodi='"+
                        text4.getText() + "' WHERE nama='"+
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Data berhasil di update", Toast.LENGTH_LONG).show();
                if (TampilanData2.ma != null) {
                    TampilanData2.ma.RefreshList();
                }
                finish();
            }
        });

        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte2 = new Intent(UpdateData.this, TampilanAdmin.class);
                startActivity(inte2);
            }
        });
    }
}