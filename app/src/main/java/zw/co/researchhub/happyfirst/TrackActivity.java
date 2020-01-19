package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TrackActivity extends AppCompatActivity {

    private TextView title;
    private TextView content;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Toast.makeText(this,"Method under construction", Toast.LENGTH_LONG).show();
//            super.onBackPressed();
        });


    }
}
