package zw.co.researchhub.happyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import zw.co.researchhub.happyfirst.User.UserDao;
import zw.co.researchhub.happyfirst.model.User;

public class CycleStartedActivity extends AppCompatActivity {
    private Button submit;
    private Spinner started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_started);
        UserDao userDao = HappyFirstDatabase.getDatabase(getApplicationContext()).userDao();
        String[] items = new String[]{"YES", "NO"};
        started = findViewById(R.id.started);
        ArrayAdapter<String> startedAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        started.setAdapter(startedAdapter);

        submit = findViewById(R.id.submit_btn);
        User loggedInUser = (User) getIntent().getSerializableExtra("loggedInUser");

        submit.setOnClickListener(v -> {
        if (started.getSelectedItem().toString().equals("YES")) {
            loggedInUser.setIsGoing(true);
            loggedInUser.setFirstLogin(false);
            userDao.update(loggedInUser);
            Intent i = new Intent(CycleStartedActivity.this, TrackActivity.class);
            i.putExtra("loggedInUser", loggedInUser);
            startActivity(i);
        }else{
            loggedInUser.setIsGoing(false);
            loggedInUser.setFirstLogin(false);
            userDao.update(loggedInUser);
            Intent i = new Intent(CycleStartedActivity.this, LoggedInActivity.class);
            i.putExtra("loggedInUser", loggedInUser);
            startActivity(i);
        }

        });
    }
}
