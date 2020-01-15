package zw.co.researchhub.happyfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class RegisterActivity extends AppCompatActivity {

    private Button submitButton;
    private  Spinner dropdownRole;
    private  Spinner dropdownGender;
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
        String[] items = new String[]{"TEACHER", "PARENT", "STUDENT"};
        dropdownRole = findViewById(R.id.role);
        ArrayAdapter<String> roleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownRole.setAdapter(roleAdapter);
        String[] gender = new String[]{"FEMALE", "MALE"};
        dropdownGender = findViewById(R.id.gender);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        dropdownGender.setAdapter(genderAdapter);

    }
}
