package com.ditomatto.iniciosesion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toast dashBoard = Toast.makeText(this, "Dashboard de la Aplicacion", Toast.LENGTH_LONG);
//        dashBoard.show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Obtener el Intent que inició esta actividad
        Intent intent = getIntent();

        // 2. Comprobar si el Intent contiene los datos que esperamos
        if (intent != null && intent.hasExtra("USER_FULL_NAME")) {
            // Obtener el nombre completo del Intent
            String fullName = intent.getStringExtra("USER_FULL_NAME");

            // Obtener la referencia al TextView en el layout
            TextView userFullNameTextView = findViewById(R.id.userFullName);

            // 3. Mostrar el nombre en la UI
            userFullNameTextView.setText("Hola, " + fullName + "!");

        } else {
            // Si no hay datos, mostrar un mensaje de error o una bienvenida genérica
            Toast.makeText(this, "No se encontraron datos de usuario.", Toast.LENGTH_SHORT).show();
        }
    }
}