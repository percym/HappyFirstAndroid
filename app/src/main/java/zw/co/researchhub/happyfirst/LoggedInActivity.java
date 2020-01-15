package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import zw.co.researchhub.happyfirst.User.LoggedInGeneralTipListFragment;
import zw.co.researchhub.happyfirst.model.User;


public class LoggedInActivity extends AppCompatActivity {
    private Button generalTipsButton;
    private Button specificTipsButton;
    private Button manageStudentButton;
    private TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_tigashire);

        User loggedInUser = (User) getIntent().getSerializableExtra("loggedInUser");
        name = findViewById(R.id.name);
        name.setText(loggedInUser.getName());
        generalTipsButton = findViewById(R.id.view_general);
        generalTipsButton.setOnClickListener(v-> showFragment(LoggedInGeneralTipListFragment.newInstance(),loggedInUser));

//        specificTipsButton = findViewById(R.id.view_going);
//        specificTipsButton.setOnClickListener(v-> showFragment(SpecificTipListFragment.newInstance()));

        manageStudentButton = findViewById(R.id.view_manage);
        if (loggedInUser.getRole().equals("TEACHER")){
            manageStudentButton.setOnClickListener(v ->{

            });
        }
    }

    private void showFragment(final Fragment fragment, User user) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commitNowAllowingStateLoss();
        Bundle bundle = new Bundle();
        bundle.putSerializable("loggedInUser", user);
        fragment.setArguments(bundle);
        Fragment shownFragment = fragment;

    }

}
