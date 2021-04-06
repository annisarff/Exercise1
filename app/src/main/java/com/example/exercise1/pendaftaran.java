package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class pendaftaran extends AppCompatActivity {
    Button bdaftar,bbatal;
    EditText nama,alamat,email,password, repass;
    RadioGroup kelamin, agama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activvity_pendaftaran);

        bdaftar = findViewById(R.id.daftar);
        bbatal = findViewById(R.id.batal);
        nama = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        email =  findViewById(R.id.dfemail);
        password = findViewById(R.id.pewe);
        repass = findViewById(R.id.repassw);

        bdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty() ||
                        repass.getText().toString().isEmpty()) {
                    nama.setError("Nama Tidak Boleh Kosong");
                    alamat.setError("Alamat Tidak Boleh Kosong");
                    email.setError("Email Tidak Boleh Kosong");
                    password.setError("Password Tidak Boleh Kosong");
                    repass.setError("Re-Password Tidak Boleh Kosong");
                } else {
                    if (repass.getText().toString().equals(password.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        Snackbar.make(view, "Password dan Re-Password Harus Sama",
                                Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });
        bbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}