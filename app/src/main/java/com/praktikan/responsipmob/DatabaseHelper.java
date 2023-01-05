package com.praktikan.responsipmob;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Responsi.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Mhs(id INTEGER PRIMARY KEY AUTOINCREMENT, nama text, NIM text, Kelas char, prodi text)";
        Log.d("Data", "OnCreate: " + sql);
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO Mhs(nama, NIM, Kelas, prodi) VALUES( 'Riyan Adi','E', 'Informatika')";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void hapusDatabase(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS Mhs");
        onCreate(db);
    }
}
