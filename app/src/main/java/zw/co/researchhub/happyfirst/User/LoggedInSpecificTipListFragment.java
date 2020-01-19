package zw.co.researchhub.happyfirst.User;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import zw.co.researchhub.happyfirst.LoggedInActivity;
import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.SpecificTip.SpecificTipListAdapter;
import zw.co.researchhub.happyfirst.SpecificTip.SpecificTipViewModel;
import zw.co.researchhub.happyfirst.model.User;

/**
 * @author
 */

public class LoggedInSpecificTipListFragment extends Fragment {
    private SpecificTipListAdapter specificTipListAdapter;
    private SpecificTipViewModel specificTipViewModel;
    private Context context;
    private User loggedInUser;
    private FloatingActionButton back;


    public static LoggedInSpecificTipListFragment newInstance() {
        return new LoggedInSpecificTipListFragment();
    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        this.context = context;
        specificTipListAdapter = new SpecificTipListAdapter(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_tip_logged_in, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_specific_tip);
        recyclerView.setAdapter(specificTipListAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {

            Intent i = new Intent(getActivity(), LoggedInActivity.class);
            i.putExtra("loggedInUser", loggedInUser);
            startActivity(i);
        });

        return view;
    }

    private void initData() {
        loggedInUser = (User) getActivity().getIntent().getSerializableExtra("loggedInUser");
        Log.d("some data", loggedInUser.getName());
        specificTipViewModel = ViewModelProviders.of(this).get(SpecificTipViewModel.class);
        specificTipViewModel.getGeneralTipLiveData().observe(this, specificTips -> specificTipListAdapter.setGeneralTipList(specificTips));
    }

    public void removeData() {
        if (specificTipViewModel != null) {
            specificTipViewModel.deleteAll();
        }
    }
}
