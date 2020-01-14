package zw.co.researchhub.happyfirst;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import zw.co.researchhub.happyfirst.GeneralTip.GeneralTipDao;
import zw.co.researchhub.happyfirst.model.GeneralTip;

@Database(entities = {GeneralTip.class}, version = 1)
public abstract class HappyFirstDatabase extends RoomDatabase {
    private static HappyFirstDatabase INSTANCE;
    public abstract GeneralTipDao generalTipDao();

    public static HappyFirstDatabase getDatabase(final Context context){
    if (INSTANCE ==null){
        synchronized (HappyFirstDatabase.class){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),HappyFirstDatabase.class,CONSTANTS.HAPPY_FIRST )
                    .allowMainThreadQueries()
                    .addCallback(new RoomDatabase.Callback(){
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Log.d("HappyFirstDatabase","populating with data...");
                            new PopulateDbAsync(INSTANCE).execute();
                        }
                    }
                    ).build();
        }
    }
    return INSTANCE;
    }
    public void clearDb() {
        if (INSTANCE != null) {
            new PopulateDbAsync(INSTANCE).execute();
        }
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final GeneralTipDao generalTipDao;

        public PopulateDbAsync(HappyFirstDatabase instance) {
            generalTipDao = instance.generalTipDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            generalTipDao.deleteAll();

            GeneralTip generalTip1 = new GeneralTip();
            generalTip1.setTitle("General title");
            generalTip1.setContent("General Content General Content General Content General Content General Content General Content General Content General Content General Content General Content General Content ");

            GeneralTip generalTip2 = new GeneralTip();
            generalTip2.setTitle("General Content");

            generalTip2.setContent("General title");

            GeneralTip generalTip3 = new GeneralTip();
            generalTip3.setTitle("General Content");
            generalTip3.setContent("General title");

            GeneralTip generalTip4 = new GeneralTip();
            generalTip4.setTitle("General title");
            generalTip4.setContent("General Content General Content General Content General Content General Content General Content General Content General Content General Content General Content General Content ");

            GeneralTip generalTip5 = new GeneralTip();
            generalTip5.setTitle("General Content");
            generalTip5.setContent("General title");

            GeneralTip generalTip6 = new GeneralTip();
            generalTip6.setTitle("General Content");
            generalTip6.setContent("General title");

            generalTipDao.insert(generalTip1);
            generalTipDao.insert(generalTip2);
            generalTipDao.insert(generalTip3);
            generalTipDao.insert(generalTip4);
            generalTipDao.insert(generalTip5);
            generalTipDao.insert(generalTip6);
            return null;
        }
    }


}