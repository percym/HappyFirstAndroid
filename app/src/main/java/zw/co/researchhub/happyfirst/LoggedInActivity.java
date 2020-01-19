package zw.co.researchhub.happyfirst;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import zw.co.researchhub.happyfirst.SpecificTip.SpecificTipListFragment;
import zw.co.researchhub.happyfirst.User.LoggedInGeneralTipListFragment;
import zw.co.researchhub.happyfirst.User.LoggedInSpecificTipListFragment;
import zw.co.researchhub.happyfirst.User.ManageChildrenActivity;
import zw.co.researchhub.happyfirst.User.ManageStudentActivity;
import zw.co.researchhub.happyfirst.model.User;


public class LoggedInActivity extends AppCompatActivity {
    private Button generalTipsButton;
    private Button specificTipsButton;
    private Button manageStudentButton;
    private Button manageChildrenButton;
    private FloatingActionButton askforhelp;
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

        specificTipsButton = findViewById(R.id.view_going);
        specificTipsButton.setOnClickListener(v-> showFragment(LoggedInSpecificTipListFragment.newInstance(), loggedInUser));

        manageStudentButton = findViewById(R.id.view_manage);
        if (loggedInUser.getRole().equals("TEACHER")){
            manageStudentButton.setVisibility(View.VISIBLE);
            manageStudentButton.setOnClickListener(v ->{

                Intent i = new Intent(LoggedInActivity.this, ManageStudentActivity.class);
                startActivity(i);
                finish();

            });
        }


        manageChildrenButton = findViewById(R.id.view_manage_children);
        if (loggedInUser.getRole().equals("PARENT")) {
            manageChildrenButton.setVisibility(View.VISIBLE);
            manageChildrenButton.setOnClickListener(v -> {
                Intent i = new Intent(LoggedInActivity.this, ManageChildrenActivity.class);
                startActivity(i);
            });
        }
        askforhelp = findViewById(R.id.ask_for_help);
        askforhelp.setOnClickListener(v -> {
            String number = "0772204155";  // The number on which you want to send SMS
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
        });
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

    private void showFragment(final Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commitNowAllowingStateLoss();
        Fragment shownFragment = fragment;

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"You are Home", Toast.LENGTH_SHORT).show();
    }
}
