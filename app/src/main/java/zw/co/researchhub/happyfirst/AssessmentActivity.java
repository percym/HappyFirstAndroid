package zw.co.researchhub.happyfirst;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AssessmentActivity extends AppCompatActivity {

    private Button submitButton;
    private CheckBox chk1;
    private CheckBox chk2;
    private CheckBox chk3;
    private CheckBox chk4;
    private CheckBox chk5;
    private CheckBox chk6;
    private CheckBox chk7;
    private CheckBox chk8;
    private CheckBox chk9;
    private  int isGoing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws SQLiteConstraintException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess);
        submitButton = findViewById(R.id.submit_btn);
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);
        chk5 = findViewById(R.id.chk5);
        chk6 = findViewById(R.id.chk6);
        chk7 = findViewById(R.id.chk7);
        chk8 = findViewById(R.id.chk8);
        chk9 = findViewById(R.id.chk9);

        submitButton.setOnClickListener(v -> {
            if (chk1.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk2.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk3.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk4.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk5.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk6.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk7.isChecked()){
                isGoing = isGoing + 5;
            }
            if (chk8.isChecked()){
                isGoing = isGoing + 5;
            }

            if (chk9.isChecked()){
                isGoing = isGoing + 5;
            }

            if (isGoing > 20 ){
                Toast.makeText(this , "Period is close ", Toast.LENGTH_LONG).show();
                isGoing =0;
            }else{

                Toast.makeText(this , "Continue Monitoring ", Toast.LENGTH_LONG).show();
                isGoing =0;
            }




        });






    }



}
