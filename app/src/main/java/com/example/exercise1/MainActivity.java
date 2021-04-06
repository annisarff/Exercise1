package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edUser, edPass;
    Button btnLogin;
    String usr, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        edUser=findViewById(R.id.email);
        edPass=findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr = edUser.getText().toString();
                password = edPass.getText().toString();

                if(edUser.getText().toString().equals("admin@mail.com")&&edPass.getText().toString().equals("123456")) {

                    Toast t = Toast.makeText(getApplicationContext(),
                            "LOGIN SUKSES || email : " + usr + " password : " + password + "", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", usr.trim());
                    b.putString("b",password.trim());
                    Intent i = new Intent(MainActivity.this, viewdata.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else if (usr.isEmpty() && password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(), "Email dan password Wajib Diisi", Toast.LENGTH_LONG);
                    edUser.setError("Email tidak boleh Kosong");
                    edPass.setError("Password tidak boleh Kosong");
                    t.show();
                }
                else if(TextUtils.isEmpty(usr)){
                    edUser.setError("Email Tidak Boleh Kosong");
                }
                else if(TextUtils.isEmpty(password)){
                    edPass.setError("Password tidak boleh kosong");
                }


            }
        });
    }
}