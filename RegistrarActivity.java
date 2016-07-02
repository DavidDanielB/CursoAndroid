package com.example.daviddaniel.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DavidDaniel on 01/07/2016.
 */
public class RegistrarActivity extends AppCompatActivity {
    EditText apellidopaterno,apellidomaterno,nombre,dni,ciudad,direccion,telefono,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        apellidopaterno=(EditText)findViewById(R.id.apellidopaterno);
        apellidomaterno=(EditText)findViewById(R.id.apellidomaterno);
        nombre=(EditText)findViewById(R.id.nombre);
        dni=(EditText)findViewById(R.id.dni);
        ciudad=(EditText)findViewById(R.id.ciudad);
        direccion=(EditText)findViewById(R.id.direccion);
        telefono=(EditText)findViewById(R.id.telefono);
        email=(EditText)findViewById(R.id.email);
    }
    public void menu(View v)
    {
        Intent intent = new Intent(getBaseContext(),MenuActivity.class);
        startActivity(intent);

    }
    public void registrarcliente (View v)
    {
        Toast.makeText(RegistrarActivity.this, "Registrando ...", Toast.LENGTH_SHORT).show();
        String ap=apellidopaterno.getText().toString();
        String am=apellidomaterno.getText().toString();
        String nm=nombre.getText().toString();
        String dn=dni.getText().toString();
        String ci=ciudad.getText().toString();
        String di=direccion.getText().toString();
        String te=telefono.getText().toString();
        String em=email.getText().toString();
        new DataActivity().getdata(ap,am,nm,dn,ci,di,te,em);

    }

}
