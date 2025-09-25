package com.example.firstapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firstapp.R;
import com.example.firstapp.data.UsuarioDAO;

public class MainActivity extends AppCompatActivity  {

    private EditText etNombre, etEmail;
    private Button btnGuardar, btnVerLista;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnVerLista = findViewById(R.id.btnVerLista);

        usuarioDAO = new UsuarioDAO(this);

        btnGuardar.setOnClickListener(v -> {
            String nombre =  etNombre.getText().toString();
            String email =  etEmail.getText().toString();
            usuarioDAO.insertarUsuario(nombre, email);
            Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show();
        });

        btnVerLista.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListaActivity.class);
            startActivity(intent);
        });
    }

}