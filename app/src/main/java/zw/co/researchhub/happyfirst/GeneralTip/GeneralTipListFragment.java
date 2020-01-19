package zw.co.researchhub.happyfirst.GeneralTip;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import zw.co.researchhub.happyfirst.GuestActivity;
import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.Welcome;
import zw.co.researchhub.happyfirst.model.GeneralTip;

/**
 * @author
 */

public class GeneralTipListFragment extends Fragment {
    private GeneralTipListAdapter generalTipListAdapter;
    private GeneralTipViewModel generalTipViewModel;
    private Context context;
    private FloatingActionButton back;



    public static GeneralTipListFragment newInstance() {
        return new GeneralTipListFragment();
    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        this.context = context;
        generalTipListAdapter = new GeneralTipListAdapter(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general_tip, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_general_tip);
        recyclerView.setAdapter(generalTipListAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), GuestActivity.class);
            startActivity(i);
        });
        return view;
    }

    private void initData() {
        generalTipViewModel = ViewModelProviders.of(this).get(GeneralTipViewModel.class);
        generalTipViewModel.getGeneralTipLiveData().observe(this, new Observer<List<GeneralTip>>() {
            @Override
            public void onChanged(@Nullable List<GeneralTip> generalTips) {
                generalTipListAdapter.setGeneralTipList(generalTips);
            }
        });
    }

    public void removeData() {
        if (generalTipViewModel != null) {
            generalTipViewModel.deleteAll();
        }
    }
}
