package com.example.firstapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.firstapp.model.User;
import com.example.firstapp.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private final LiveData<List<User>> allUsers;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }
    public LiveData<List<User>> getAllUsers(){
        return this.allUsers;

    }
    public void insert(User user) {
        userRepository.insert(user);
    }
}
