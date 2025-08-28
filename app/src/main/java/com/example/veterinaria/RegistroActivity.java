package com.example.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText etNombre, etRaza, etTipo, etGenero, etPeso, etColor;
    Button btnGuardar;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = findViewById(R.id.etNombre);
        etRaza = findViewById(R.id.etRaza);
        etTipo = findViewById(R.id.etTipo);
        etGenero = findViewById(R.id.etGenero);
        etPeso = findViewById(R.id.etPeso);
        etColor = findViewById(R.id.etColor);
        btnGuardar = findViewById(R.id.btnGuardar);

        dbHelper = new DBHelper(this);

        btnGuardar.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", etNombre.getText().toString());
            values.put("raza", etRaza.getText().toString());
            values.put("tipo", etTipo.getText().toString());
            values.put("genero", etGenero.getText().toString());
            values.put("peso", etPeso.getText().toString());
            values.put("color", etColor.getText().toString());

            long result = db.insert("mascota", null, values);
            if(result != -1){
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
