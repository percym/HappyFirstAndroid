package zw.co.researchhub.happyfirst;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import zw.co.researchhub.happyfirst.GeneralTip.GeneralTipDao;
import zw.co.researchhub.happyfirst.model.GeneralTip;

@Database(entities = {GeneralTip.class}, version = 1)
public abstract class HappyFirstDatabase extends RoomDatabase {

    public abstract GeneralTipDao generalTipDao();
}
