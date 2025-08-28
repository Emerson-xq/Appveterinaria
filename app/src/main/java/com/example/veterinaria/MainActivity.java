package com.example.veterinaria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro, btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnLista = findViewById(R.id.btnLista);

        btnRegistro.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, RegistroActivity.class)));

        btnLista.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListaActivity.class)));

    }
}