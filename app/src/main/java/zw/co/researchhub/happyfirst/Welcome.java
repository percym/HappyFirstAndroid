package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(v -> {

            Intent i = new Intent(Welcome.this, MainActivity.class);
            startActivity(i);
        });

    }
}
