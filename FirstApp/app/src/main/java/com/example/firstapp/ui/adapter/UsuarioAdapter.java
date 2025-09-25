package com.example.firstapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {
    private List<Usuario> listaUsuarios;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditar(Usuario usuario);
        void onEliminar(Usuario usuario);
    }

    public UsuarioAdapter(List<Usuario> listaUsuarios, OnItemClickListener listener) {
        this.listaUsuarios = listaUsuarios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.tvNombre.setText(usuario.getNombre());
        holder.tvEmail.setText(usuario.getEmail());

        holder.btnEditar.setOnClickListener(v -> listener.onEditar(usuario));
        holder.btnEliminar.setOnClickListener(v -> listener.onEliminar(usuario));
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEmail;
        Button btnEditar, btnEliminar;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            this.tvNombre = itemView.findViewById(R.id.tvNombre);
            this.tvEmail = itemView.findViewById(R.id.tvEmail);
            this.btnEditar = itemView.findViewById(R.id.btnEditar);
            this.btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}
