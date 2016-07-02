package com.example.daviddaniel.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by DavidDaniel on 01/07/2016.
 */
public class ListarActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
    }

    public void menu(View v)
    {
        Intent intent = new Intent(getBaseContext(),MenuActivity.class);
        startActivity(intent);

    }
    public void buscarcliente(View v)
    {
        Toast.makeText(ListarActivity.this, "Buscando cliente ...", Toast.LENGTH_SHORT).show();

    }

    public void listadeclientes(View v)
    {
        Toast.makeText(ListarActivity.this, "Lista de clientes", Toast.LENGTH_SHORT).show();

    }
}

