package zw.co.researchhub.happyfirst.GeneralTip;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import zw.co.researchhub.happyfirst.R;

public class ReadActivity extends AppCompatActivity {

    private TextView title;
    private TextView content;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_custom);
        title = findViewById(R.id.title);
        content = findViewById(R.id.name);
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            super.onBackPressed();
        });
        Intent intent = getIntent();
        String titleString = intent.getStringExtra("title");
        String contentString = intent.getStringExtra("content");
        title.setText(titleString);
        content.setText(contentString);


    }
}
