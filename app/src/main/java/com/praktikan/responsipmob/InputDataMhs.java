package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InputDataMhs extends AppCompatActivity {
    protected Cursor cursor;
    Button btn1, btn2;
    EditText text1, text2, text3, text4;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_mhs);

        btn1 = (Button) findViewById(R.id.btnKembali);
        btn2 = (Button) findViewById(R.id.btnSimpan);
        text1 = (EditText) findViewById(R.id.etNama);
        text2 = (EditText) findViewById(R.id.etNIM);
        text3 = (EditText) findViewById(R.id.etKelas);
        text4 = (EditText) findViewById(R.id.etProdi);

        db = new DatabaseHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(InputDataMhs.this, TampilanMhs.class);
                startActivity(intent1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase DB = db.getWritableDatabase();
                DB.execSQL("INSERT INTO Mhs(nama, NIM, Kelas, prodi) VALUES ('" +
                        text1.getText().toString() +"','" +
                        text2.getText().toString() +"','" +
                        text3.getText().toString() +"','" +
                        text4.getText() +"')" );
                Toast.makeText(InputDataMhs.this, "Data Berhasil ditambahkan", Toast.LENGTH_LONG).show();
                SQLiteDatabase DB2 = db.getReadableDatabase();

//// Menjalankan perintah SELECT dan menyimpan hasilnya di dalam cursor
//                Cursor cursor = DB2.rawQuery("SELECT * FROM Mhs", null);
//
//// Iterasi melalui setiap baris yang ada di dalam cursor
//                while (cursor.moveToNext()) {
//                    String nama2 = cursor.getString(cursor.getColumnIndex("nama"));
//                    String NIM2 = cursor.getString(cursor.getColumnIndex("NIM"));
//                    String Kelas2 = cursor.getString(cursor.getColumnIndex("Kelas"));
//                    String Prodi2 = cursor.getString(cursor.getColumnIndex("prodi"));
//
//                    // Menampilkan data di logcat
//                    Log.d("Data Mhs", "Nama: " + nama2 + ", NIM: " + NIM2 + ", Kelas: " + Kelas2 + ", Prodi: " + Prodi2);
//                }

// Menutup cursor setelah selesai digunakan
                cursor.close();
                Intent intent2 = new Intent(InputDataMhs.this, TampilanData.class);
                startActivity(intent2);


//                Log.d("Data Mhs", "Nama: " + namaTXT + ", NIM: " + NIMTXT + ", Kelas: " + KelasTXT + ", Prodi: " + ProdiTXT);

//                db.cekInputData = db.tambahData(namaTXT, NIMTXT, KelasTXT, ProdiTXT);
//                if(cekInputData == true){
//                    Toast.makeText(InputDataMhs.this, "Data Berhasil ditambahkan", Toast.LENGTH_LONG).show();
//                    Intent intent2 = new Intent(InputDataMhs.this, TampilanData.class);
//                    startActivity(intent2);
//                }else {
//                    Toast.makeText(InputDataMhs.this, "Data Gagal Ditambahkan", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
}