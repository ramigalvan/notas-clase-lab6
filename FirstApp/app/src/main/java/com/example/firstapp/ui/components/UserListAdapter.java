package com.example.firstapp.ui.components;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstapp.R;
import com.example.firstapp.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private List<User> users = new ArrayList<>();

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if(users != null){
            User current = users.get(position);
            holder.uidView.setText("ID: " + current.getUid());
            holder.firstNameView.setText("Nombre: " + current.getFirstName());
            holder.lastNameView.setText("Apellido: " + current.getLastName());
        }
    }

    @Override
    public int getItemCount() {
        return users != null? users.size() : 0;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{
        private final TextView uidView;
        private final TextView firstNameView;
        private final TextView lastNameView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            uidView = itemView.findViewById(R.id.textViewUid);
            firstNameView = itemView.findViewById(R.id.textViewFirstName);
            lastNameView = itemView.findViewById(R.id.textViewLastName);
        }
    }
}
