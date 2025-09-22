package com.example.firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder> {

    private List<String> mFrutas;

    public FrutaAdapter(List<String> frutas){
        mFrutas = frutas;
    }

    @NonNull
    @Override
    public FrutaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.lista_item_fruta,parent, false);
        return  new FrutaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FrutaViewHolder holder, int position) {
        String fruta = mFrutas.get(position);
        holder.textView.setText(fruta);
    }

    @Override
    public int getItemCount() {
        return mFrutas.size();
    }


    //El ViewHolder es una clase interna
    public static class FrutaViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public FrutaViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_fruta_item);
        }
    }
}
