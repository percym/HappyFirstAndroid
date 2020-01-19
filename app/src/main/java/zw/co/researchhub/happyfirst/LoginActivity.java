package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import zw.co.researchhub.happyfirst.User.UserDao;
import zw.co.researchhub.happyfirst.model.User;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

public class LoginActivity extends AppCompatActivity {

    private Button submitButton;

    private TextView user_name;
    private TextView pass;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        userDao = HappyFirstDatabase.getDatabase(getApplicationContext()).userDao();
        AwesomeValidation mAwesomeValidation = new AwesomeValidation(COLORATION);
        mAwesomeValidation.setColor(Color.YELLOW);
// or
        HappyFirstDatabase database = Room.databaseBuilder(this, HappyFirstDatabase.class, CONSTANTS.HAPPY_FIRST)
                .allowMainThreadQueries()
                .build();

        user_name  = findViewById(R.id.user_name);
        pass  = findViewById(R.id.pass);


        mAwesomeValidation.addValidation(this, R.id.user_name, "[a-zA-Z\\s]+", R.string.errname);
        mAwesomeValidation.addValidation(this, R.id.pass, "[a-zA-Z\\s]+", R.string.password);

        submitButton = findViewById(R.id.submit_btn);
        submitButton.setOnClickListener(v -> {
         if(mAwesomeValidation.validate()){
             String username = user_name.getText().toString();
             String password = pass.getText().toString();
                 User loggedInUser = userDao.getUserByNameAndPassword(username,password);
                 if (loggedInUser != null) {

                     //remove when going live
                     loggedInUser.isFirstLogin();
                         Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show();
                         if ((loggedInUser.getRole().equals("STUDENT")) && (loggedInUser.isFirstLogin())){

                             Intent i = new Intent(LoginActivity.this, BDayActivity.class);
                             i.putExtra("loggedInUser", loggedInUser);
                             startActivity(i);
                         }else {
                             Intent i = new Intent(LoginActivity.this, LoggedInActivity.class);
                             i.putExtra("loggedInUser", loggedInUser);
                             startActivity(i);
                         }

                 }
         }
        });




    }



}
