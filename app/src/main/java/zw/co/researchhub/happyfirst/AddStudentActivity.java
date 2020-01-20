package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import zw.co.researchhub.happyfirst.User.UserDao;
import zw.co.researchhub.happyfirst.model.User;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

public class AddStudentActivity extends AppCompatActivity {

    private Button submitButton;
    private  Spinner dropdownRole;
    private  Spinner dropdownGender;
    private TextView user_name;
    private TextView surname;
    private TextView pass;
    private UserDao userDao;
    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws SQLiteConstraintException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDao = HappyFirstDatabase.getDatabase(getApplicationContext()).userDao();
        AwesomeValidation mAwesomeValidation = new AwesomeValidation(COLORATION);
        mAwesomeValidation.setColor(Color.YELLOW);
// or
        HappyFirstDatabase database = Room.databaseBuilder(this, HappyFirstDatabase.class, CONSTANTS.HAPPY_FIRST)
                .allowMainThreadQueries()
                .build();



        String[] items = new String[]{"STUDENT"};
        dropdownRole = findViewById(R.id.role);
        ArrayAdapter<String> roleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownRole.setAdapter(roleAdapter);
        String[] gender = new String[]{"FEMALE"};
        dropdownGender = findViewById(R.id.gender);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        dropdownGender.setAdapter(genderAdapter);

        dropdownRole = findViewById(R.id.role);
        dropdownGender = findViewById(R.id.gender);
        user_name  = findViewById(R.id.user_name);
        surname  = findViewById(R.id.surname);
        pass  = findViewById(R.id.pass);

        mAwesomeValidation.addValidation(this, R.id.user_name, "[a-zA-Z\\s]+", R.string.errname);
        mAwesomeValidation.addValidation(this, R.id.surname, "[a-zA-Z\\s]+", R.string.errsurname);
        mAwesomeValidation.addValidation(this, R.id.pass, "[a-zA-Z\\s]+", R.string.password);

        submitButton = findViewById(R.id.submit_btn);
        submitButton.setOnClickListener(v -> {
         if(mAwesomeValidation.validate()){
             User user = new User();
             user.setName(user_name.getText().toString());
             user.setSurname(surname.getText().toString());
             user.setPassword(pass.getText().toString());
             user.setRole(dropdownRole.getSelectedItem().toString());
             user.setGender(dropdownGender.getSelectedItem().toString());
             user.setIsGoing(false);
             if (user.getRole().equals("STUDENT")){
                 user.setFirstLogin(true);
             }

             try {
                 userDao.insert(user);
                 Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
                 Intent i = new Intent(AddStudentActivity.this, Welcome.class);
                 startActivity(i);
             }catch (SQLiteConstraintException sqe){
                 Toast.makeText(this, sqe.getLocalizedMessage(), Toast.LENGTH_LONG).show();
             }
         }
        });

    }



}
