package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class data_activity extends AppCompatActivity {
    public static ArrayList<ClassNama> classNamaArrayList=new ArrayList<ClassNama>();
    TextView tvnama, tvnomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_activity);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        switch (nama){
            case "Inayah":
                tvnama.setText("Inayah");
                tvnomor.setText("088797912345");
                break;
            case "Ilham":
                tvnama.setText("Ilham");
                tvnomor.setText("089756483924");
                break;
            case "Eris":
                tvnama.setText("Eris");
                tvnomor.setText("078691236458");
                break;
            case "Fikri":
                tvnama.setText("Fikri");
                tvnomor.setText("089758463527");
                break;
            case "Mual" :
                tvnama.setText("Maul");
                tvnomor.setText("087123548965");
                break;
            case "Intan":
                tvnama.setText("Intan");
                tvnomor.setText("081354782934");
                break;
            case "Vina":
                tvnama.setText("Vina");
                tvnomor.setText("087689546372");
                break;
            case "Gita":
                tvnama.setText("Gita");
                tvnomor.setText("087689546867");
                break;
            case "Vian":
                tvnama.setText("Vian");
                tvnomor.setText("087687946372");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi");
                tvnomor.setText("088989546372");
                break;
        }
    }
}
