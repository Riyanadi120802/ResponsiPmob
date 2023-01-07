package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;

public class TampilanData extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> nama, nim, id;
    DatabaseHelper DB;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_data);
        DB = new DatabaseHelper(this);
        nama = new ArrayList<>();
        nim = new ArrayList<>();
        id = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new Adapter(this, nama, nim, id);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata()
    {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(TampilanData.this, "Data Masih Kosong", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                nama.add(cursor.getString(1));
                nim.add(cursor.getString(2));

            }
        }
    }


}