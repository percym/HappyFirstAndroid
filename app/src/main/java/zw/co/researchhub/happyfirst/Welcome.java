package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class Welcome extends AppCompatActivity {
    private Button registerButton;
    private TextView txtGuest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(v -> {

            Intent i = new Intent(Welcome.this, RegisterActivity.class);
            startActivity(i);
        });

        txtGuest = findViewById(R.id.guest);
        txtGuest.setOnClickListener(v -> {

            Intent i = new Intent(Welcome.this, GuestActivity.class);
            startActivity(i);
        });

        reCreateDatabase();
    }

    private void reCreateDatabase() {
        HappyFirstDatabase.getDatabase(this).clearDb();
    }
}
