package com.example.firstapp.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.User;
import com.example.firstapp.ui.components.UserListAdapter;
import com.example.firstapp.viewModel.UserViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  {

    private UserViewModel userViewModel;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UserListAdapter adapter = new UserListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        //observa la lista de usuarios
        userViewModel.getAllUsers().observe(this, adapter::setUsers);

        //boton flotante
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            User newUser = new User("Juan", "perez");
            userViewModel.insert(newUser);
        });

//
//        btnGuardar.setOnClickListener(v -> {
//            String nombre =  etNombre.getText().toString();
//            String email =  etEmail.getText().toString();
//            usuarioDAO.insertarUsuario(nombre, email);
//            Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show();
//        });
//
//        btnVerLista.setOnClickListener(v -> {
//            Intent intent = new Intent(this, ListaActivity.class);
//            startActivity(intent);
//        });
    }

}