package com.example.firstapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.firstapp.data.AppDatabase;
import com.example.firstapp.data.UserDAO;
import com.example.firstapp.model.User;
import com.example.firstapp.model.Usuario;

import java.util.List;

public class UserRepository {
    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDAO = db.userDAO();
        allUsers = userDAO.getAll();
//        mAllWords = mWordDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    LiveData<List<Word>> getAllWords() {
//        return mAllWords;
//    }
    public LiveData<List<User>>getAllUsers(){
        return allUsers;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.

//    void insert(Word word) {
//        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
//            mWordDao.insert(word);
//        });
//    }
    public void insert(User user){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.insertAll(user);
        });
    }
}
