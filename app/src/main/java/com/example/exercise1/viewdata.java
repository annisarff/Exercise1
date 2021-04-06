package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewdata extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;
    private LViewAdapter adapter;
    SearchView searchView;
    String[] listNama;
    ArrayAdapter<String> arrayAdapter;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    String namakontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        searchView = findViewById(R.id.search);
        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina", "Luthfi"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, listNama);
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for (int i =0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
            adapter = new LViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    namakontak =classNamaArrayList.get(position).getNama();
                    bundle.putString("a",namakontak.trim());
                    PopupMenu pm=new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(viewdata.this);
                    pm.inflate(R.menu.popup);
                    pm.show();
                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    viewdata.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    viewdata.this.arrayAdapter.getFilter().filter(newText );
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent=new Intent(getApplicationContext(), data_activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor = namakontak.trim();
                String isinomor = "";
                if (nomor == "Inayah"){
                    isinomor = "088797912345";
                }
                else if (nomor == "Ilham"){
                    isinomor = "089756483924";
                }
                else if (nomor == "Eris"){
                    isinomor = "078691236458";
                }
                else if (nomor == "Fikri"){
                    isinomor = "089758463527";
                }
                else if (nomor == "Maul"){
                    isinomor = "087123548965";
                }
                else if (nomor == "Intan"){
                    isinomor = "081354782934";
                }
                else if (nomor == "Vina"){
                    isinomor = "087689546372";
                }
                else if (nomor == "Gita"){
                    isinomor = "087689546867";
                }
                else if (nomor == "Vian"){
                    isinomor = "087687946372";
                }
                else if (nomor == "Lutfi"){
                    isinomor = "088989546372";
                }

                Toast.makeText(getApplicationContext(), isinomor,
                        Toast.LENGTH_LONG).show();
                break;

        }
        return false;
    }
}