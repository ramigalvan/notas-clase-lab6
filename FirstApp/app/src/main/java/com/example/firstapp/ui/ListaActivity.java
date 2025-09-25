package com.example.firstapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.ui.adapter.UsuarioAdapter;
import com.example.firstapp.data.UsuarioDAO;
import com.example.firstapp.model.Usuario;

import java.util.List;

public class ListaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UsuarioDAO usuarioDAO;
    private UsuarioAdapter adapter;
    private List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        recyclerView = findViewById(R.id.recyclerUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        usuarioDAO = new UsuarioDAO(this);
        listaUsuarios = usuarioDAO.obtenerUsuarios();

        adapter = new UsuarioAdapter(listaUsuarios, new UsuarioAdapter.OnItemClickListener() {
            @Override
            public void onEditar(Usuario usuario) {
                usuarioDAO.actualizarUsuario(usuario.getId(), "Nuevo NombreX", "randomail@sample.com");
                refrescarLista();
                Log.d("Adapter Evento", "Boton editar");
            }

            @Override
            public void onEliminar(Usuario usuario) {
                usuarioDAO.eliminarUsuario(usuario.getId());
                refrescarLista();
                Log.d("Adapter Evento", "Boton eliminar");
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void refrescarLista() {
        listaUsuarios.clear();
        listaUsuarios.addAll(usuarioDAO.obtenerUsuarios());
        adapter.notifyDataSetChanged();

    }
}