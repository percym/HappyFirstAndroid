package zw.co.researchhub.happyfirst.User;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import zw.co.researchhub.happyfirst.HappyFirstDatabase;
import zw.co.researchhub.happyfirst.SpecificTip.SpecificTipDao;
import zw.co.researchhub.happyfirst.model.SpecificTip;
import zw.co.researchhub.happyfirst.model.User;

public class UserViewModel extends AndroidViewModel {
    private UserDao userDao;
    LiveData<List<User>> userLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userDao = HappyFirstDatabase.getDatabase(application).userDao();
        userLiveData = userDao.getAll();
    }

    public LiveData<List<User>> getUserLiveData() {
        return userDao.getUserByRole("STUDENT");
    }

    public void deleteAll() {
        userDao.deleteAll();
    }
}
