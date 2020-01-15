package zw.co.researchhub.happyfirst.SpecificTip;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import zw.co.researchhub.happyfirst.HappyFirstDatabase;
import zw.co.researchhub.happyfirst.model.GeneralTip;
import zw.co.researchhub.happyfirst.model.SpecificTip;

public class SpecificTipViewModel extends AndroidViewModel {
    private SpecificTipDao specificTipDao;
    LiveData<List<SpecificTip>> specificTipLiveData;

    public SpecificTipViewModel(@NonNull Application application) {
        super(application);
        specificTipDao = HappyFirstDatabase.getDatabase(application).specificTipDao();
        specificTipLiveData = specificTipDao.getAll();
    }

    public LiveData<List<SpecificTip>> getGeneralTipLiveData() {
        return specificTipDao.getAll();
    }

    public void deleteAll() {
        specificTipDao.deleteAll();
    }
}
