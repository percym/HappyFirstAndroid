package zw.co.researchhub.happyfirst;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import zw.co.researchhub.happyfirst.GeneralTip.GeneralTipListFragment;


public class GuestActivity extends AppCompatActivity {
    private Button generalTipsButton;
    private Fragment shownFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_tigashire);
        generalTipsButton = findViewById(R.id.view_general);
        generalTipsButton.setOnClickListener(v->{
            showFragment(GeneralTipListFragment.newInstance());
        });



    }

    private void showFragment(final Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commitNow();
        shownFragment = fragment;

    }

}
