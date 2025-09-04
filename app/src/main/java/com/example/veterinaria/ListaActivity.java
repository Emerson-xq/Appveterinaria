package com.example.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ListView listView;
    private final String URL= "http://192.168.101.37:3000/";
    DBHelper dbHelper;
    ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = findViewById(R.id.listViewMascotas);
        dbHelper = new DBHelper(this);
        lista = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM mascota", null);

        if(cursor.moveToFirst()){
            do {
                String mascota = cursor.getInt(0) + " - " + cursor.getString(1) + " (" + cursor.getString(2) + ")";
                lista.add(mascota);
            } while (cursor.moveToNext());
        }

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista));
    }
}
