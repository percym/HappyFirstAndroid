package zw.co.researchhub.happyfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class RegisterActivity extends AppCompatActivity {

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        HappyFirstDatabase database = Room.databaseBuilder(this, HappyFirstDatabase.class, CONSTANTS.HAPPY_FIRST)
                .allowMainThreadQueries()
                .build();

        submitButton = findViewById(R.id.submit_btn);
        submitButton.setOnClickListener(v -> {

            Intent i = new Intent(RegisterActivity.this, Welcome.class);
            startActivity(i);
        });

    }
}
