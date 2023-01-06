package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TampilanMhs extends AppCompatActivity {

    TextView input, cetak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_mhs);

        input = (TextView) findViewById(R.id.Input);
        cetak = (TextView) findViewById(R.id.cetak);

        input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent inte2 = new Intent(TampilanMhs.this, InputDataMhs.class);
                startActivity(inte2);
            }
        });

        cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten2 = new Intent(TampilanMhs.this, CetakData.class);
                startActivity(inten2);
            }
        });
    }
}