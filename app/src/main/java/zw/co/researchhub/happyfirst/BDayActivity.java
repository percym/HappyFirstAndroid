package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

import zw.co.researchhub.happyfirst.User.UserDao;
import zw.co.researchhub.happyfirst.model.User;

public class BDayActivity extends AppCompatActivity {

    private DatePicker bdayPicker;
    private Date bday ;
    private UserDao userDao;
    private User loggedInUser;
    private Button submit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_bday);
        userDao = HappyFirstDatabase.getDatabase(getApplicationContext()).userDao();
        bdayPicker = findViewById(R.id.bdayPicker);
        submit = findViewById(R.id.submit_btn);
        bday = getDateFromDatePicker(bdayPicker);

      loggedInUser =   (User) getIntent().getSerializableExtra("loggedInUser");
        submit.setOnClickListener(v -> {
            loggedInUser.setBirthDay(bday.toString());
            userDao.update(loggedInUser);
            Intent i = new Intent(BDayActivity.this, CycleStartedActivity.class);
            i.putExtra("loggedInUser", loggedInUser);
            startActivity(i);

        });
    }


    public static Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }
}
