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
import zw.co.researchhub.happyfirst.SpecificTip.SpecificTipDao;
import zw.co.researchhub.happyfirst.User.UserDao;
import zw.co.researchhub.happyfirst.model.GeneralTip;
import zw.co.researchhub.happyfirst.model.SpecificTip;
import zw.co.researchhub.happyfirst.model.User;

@Database(entities = {GeneralTip.class, SpecificTip.class, User.class}, version = 1 , exportSchema = false)
public abstract class HappyFirstDatabase extends RoomDatabase {
    private static HappyFirstDatabase INSTANCE;
    public abstract GeneralTipDao generalTipDao();
    public abstract SpecificTipDao specificTipDao();
    public abstract UserDao userDao();

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
        private final SpecificTipDao specificTipDao;
        private final UserDao userDao;

        public PopulateDbAsync(HappyFirstDatabase instance) {
            generalTipDao = instance.generalTipDao();
            specificTipDao = instance.specificTipDao();
            userDao = instance.userDao();


        }

        @Override
        protected Void doInBackground(Void... voids) {
            generalTipDao.deleteAll();

            GeneralTip generalTip1 = new GeneralTip();
            generalTip1.setTitle("What is a period and why do we have them?");
            generalTip1.setContent("Simply put: A period is when a woman’s body releases tissue it no longer needs. This tissue\n" +
                    "comes from the uterus, which is where a baby (fetus) can develop in the female body. Every\n" +
                    "month or so, the uterus lining gets thicker to prepare for a fertilized egg if the woman becomes\n" +
                    "pregnant. If the egg doesn’t get fertilized, that lining is released from the body as blood through\n" +
                    "the vagina. This monthly process is called menstruation or a period.\n" +
                    "So when a girl has her period, her body is just getting rid of a small amount of blood and some\n" +
                    "unneeded tissue. It is a natural, normal body process for all females as they become women and\n" +
                    "mature physically");

            GeneralTip generalTip2 = new GeneralTip();
            generalTip2.setTitle("What does a period feel like?");

            generalTip2.setContent("The actual flow of your period doesn’t feel like much when it’s happening. Chances are, you\n" +
                    "won’t even feel it coming out. When you actually start your period, you may feel some dampness\n" +
                    "in your private area — this may be caused by a few spots of blood on your underwear.");

            GeneralTip generalTip3 = new GeneralTip();
            generalTip3.setTitle("Does having your period smell?");
            generalTip3.setContent("It shouldn’t! Menstrual odor happens when menstrual fluid comes in contact with air. When\n" +
                    "menstrual fluid is absorbed within the vagina, like through a tampon, it is not exposed to the air,\n" +
                    "so there shouldn’t be an odor. If you’re feeling worried, just be sure to change your pads and\n" +
                    "tampons frequently to help keep odor at bay.");

            GeneralTip generalTip4 = new GeneralTip();
            generalTip4.setTitle("Does having your period hurt?");
            generalTip4.setContent("Menstruation itself doesn’t hurt, but some girls and women get cramps or other symptoms during\n" +
                    "their periods that may be uncomfortable. This is typically due to the hormones your body\n" +
                    "releases during menstruation that cause the uterus to contract so it can shed it’s lining");

            GeneralTip generalTip5 = new GeneralTip();
            generalTip5.setTitle("What are the first signs I am having my periodt");
            generalTip5.setContent("For most girls, their first menstrual period, or menarche (say: MEH-nar-kee), begins about 2\n" +
                    "years after she first starts to get breasts. For most girls this is around age 12. But it can be as\n" +
                    "early as age 8 or as late as 15. Talk to your doctor if your period started before age 8 or you are\n" +
                    "15 and haven’t started your period.\n" +
                    "A good sign you're getting close to the time when your first period will arrive is if you notice a\n" +
                    "discharge coming from your vagina. It might be thin and slightly sticky or thick and gooey, and\n" +
                    "can be clear to white or off-white in color. Usually, this happens about 6 months before you get\n" +
                    "your first period");

            GeneralTip generalTip6 = new GeneralTip();
            generalTip6.setTitle("How do I get ready for my first period?");
            generalTip6.setContent("Talk to your mum or another adult you trust about what you can expect before it actually\n" +
                    "happens.\n" +
                    "It's a good idea to start carrying sanitary pads or tampons around with you in advance, so you\n" +
                    "aren't scrambling to find some when your period finally arrives.\n" +
                    "If you find yourself at school without a pad or tampon, talk to a female teacher or the school\n" +
                    "nurse. They're used to being asked and they'll want to help you out.");

            generalTipDao.insert(generalTip1);
            generalTipDao.insert(generalTip2);
            generalTipDao.insert(generalTip3);
            generalTipDao.insert(generalTip4);
            generalTipDao.insert(generalTip5);
            generalTipDao.insert(generalTip6);



            SpecificTip specificTip = new SpecificTip();
            specificTip.setTitle("I got my period and I haven't told my mom yet. It's really hard for me to talk about things\n" +
                    "like this. I have a lot of questions. What should I do?");
            specificTip.setContent("Lots of girls have the same concern. Your mom will be one of your best resources when you\n" +
                    "have questions about your period, so try to start the conversation yourself! Know that she will be\n" +
                    "understanding and helpful. Actually, she may be your best friend during this time in your life.\n" +
                    "Still don’t feel like you can talk to your mom? An aunt, friend’s mom or older sister are also\n" +
                    "great women to ask");


            SpecificTip specificTip1 = new SpecificTip();
            specificTip1.setTitle("Is it OK to have a bath or shower when I have my period?");
            specificTip1.setContent("Yep! During your period, it’s important to keep yourself fresh and clean. They’re a simple way\n" +
                    "to stay feeling feminine and fresh. Always Incredibly Thin Liners and Always Xtra Protection\n" +
                    "Liners are great choices for daily liners that help you feel dry, fresh and confident every day.");

            SpecificTip specificTip2 = new SpecificTip();
            specificTip2.setTitle("Some Title");
            specificTip2.setContent("Some Content Some ContentSome ContentSome ContentSome ContentSome ContentSome ContentSome ContentSome ContentSome Content");


            SpecificTip specificTip3= new SpecificTip();
            specificTip3.setTitle("Is there anything I won’t be able to do when I have my period?");
            specificTip3.setContent("Your period doesn’t have to stop you from doing things you usually do. You can still go to\n" +
                    "school, help at home, see your friends, play sports and do all the things you’d normally do.\n" +
                    "Tip: See the whole line of Always products so you can pick the best fit for your lifestyle and\n" +
                    "flow");


            SpecificTip specificTip4 = new SpecificTip();
            specificTip4.setTitle("Will anyone, like boys or my mom, notice when I have my period? ");
            specificTip4.setContent("No — not unless you tell them! If they ask you, it’s totally up to you to share or not.");


            SpecificTip specificTip5= new SpecificTip();
            specificTip5.setTitle("How much blood do I lose during my period? ");
            specificTip5.setContent("Most girls lose about 1/4 cup of menstrual fluid during their periods (mostly in the first few\n" +
                    "days). Not to worry, though — your body makes up for it.");

            SpecificTip specificTip6= new SpecificTip();
            specificTip6.setTitle("When will I stop having my period for good? ");
            specificTip6.setContent("Women get periods until menopause, which is when menstruation and the ability to have\n" +
                    "children stops. In most women, it usually happens in their late 40sor early 50s. But menopause\n" +
                    "can happen earlier or later. Some women may stop menstruation by the time they're 35 years old,\n" +
                    "and others may not stop until their late 50s.");

            SpecificTip specificTip7= new SpecificTip();
            specificTip7.setTitle("Do Periods Happen Regularly When Menstruation Starts? ");
            specificTip7.setContent("For the first few years after a girl starts her period, it may not come regularly. This is normal at\n" +
                    "first. By about 2–3 years after her first period, a girl's periods should be coming around once\n" +
                    "every 4–5 weeks.");

            specificTipDao.insert(specificTip);
            specificTipDao.insert(specificTip1);
            specificTipDao.insert(specificTip2);
            specificTipDao.insert(specificTip3);
            specificTipDao.insert(specificTip4);
            specificTipDao.insert(specificTip5);
            specificTipDao.insert(specificTip6);
            specificTipDao.insert(specificTip7);

            return null;
        }
    }
}