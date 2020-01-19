package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import zw.co.researchhub.happyfirst.User.UserDao;
import zw.co.researchhub.happyfirst.model.User;

public class AreYouAnOrphanActivity extends AppCompatActivity {
    private Button submit;
    private Spinner started;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orphaned);
        UserDao userDao = HappyFirstDatabase.getDatabase(getApplicationContext()).userDao();
        String[] items = new String[]{"YES", "NO"};
        started = findViewById(R.id.started);
        ArrayAdapter<String> startedAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        started.setAdapter(startedAdapter);

        submit = findViewById(R.id.submit_btn);
        User loggedInUser = (User) getIntent().getSerializableExtra("loggedInUser");

        submit.setOnClickListener(v -> {
        if (started.getSelectedItem().toString().equals("YES")) {
            loggedInUser.setOrphan(true);
            loggedInUser.setFirstLogin(false);
            userDao.update(loggedInUser);
            Intent i = new Intent(AreYouAnOrphanActivity.this, LoggedInActivity.class);
            i.putExtra("loggedInUser", loggedInUser);
            startActivity(i);
        }else{
            loggedInUser.setOrphan(false);
            userDao.update(loggedInUser);
            loggedInUser.setFirstLogin(false);
            Intent i = new Intent(AreYouAnOrphanActivity.this, LoggedInActivity.class);
            i.putExtra("loggedInUser", loggedInUser);
            startActivity(i);
        }

        });
    }
}
