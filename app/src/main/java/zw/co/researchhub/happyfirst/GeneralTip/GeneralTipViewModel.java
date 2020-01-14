package zw.co.researchhub.happyfirst.GeneralTip;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import zw.co.researchhub.happyfirst.HappyFirstDatabase;
import zw.co.researchhub.happyfirst.model.GeneralTip;

public class GeneralTipViewModel extends AndroidViewModel {
    private GeneralTipDao generalTipDao;
    LiveData<List<GeneralTip>> generalTipLiveData;

    public GeneralTipViewModel(@NonNull Application application) {
        super(application);
        generalTipDao = HappyFirstDatabase.getDatabase(application).generalTipDao();
        generalTipLiveData = generalTipDao.getAll();
    }



}
