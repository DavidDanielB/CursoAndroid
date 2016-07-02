package com.example.daviddaniel.androidapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by DavidDaniel on 01/07/2016.
 */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void registrarcliente (View v)
    {
        Intent intent= new Intent(getBaseContext(),RegistrarActivity.class);
        startActivity(intent);

    }

    public void listarcliente (View v)
    {
        Intent intent= new Intent(getBaseContext(),ListarActivity.class);
        startActivity(intent);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void salir (View v)
    {
        Toast.makeText(MenuActivity.this, "Gracias por usar este programa", Toast.LENGTH_SHORT).show();
        finishAffinity();

    }

}
