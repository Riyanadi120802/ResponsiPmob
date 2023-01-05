package com.praktikan.responsipmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText setUsername, setPassword;
    Button btnLogin;
    int counter = 0; //untuk menghitung percobaan login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        setUsername = (EditText) findViewById(R.id.username);
        setPassword = (EditText)findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.button1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = setUsername.getText().toString().trim();
                String password = setPassword.getText().toString().trim();

                if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    Intent inte = new Intent(Login.this, TampilanAdmin.class);
                    startActivity(inte);
                } else if (username.equals("mhs") && password.equals("mhs")){
                    Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    Intent inte2 = new Intent(Login.this, TampilanMhs.class);
                    startActivity(inte2);
                } else {
                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_SHORT).show();
                    setUsername.setText("");
                    setPassword.setText("");
                    counter++;
                    if(counter==3){
                        Toast.makeText(Login.this, "Akun Telah Terblokir!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            }
        });
    }
}