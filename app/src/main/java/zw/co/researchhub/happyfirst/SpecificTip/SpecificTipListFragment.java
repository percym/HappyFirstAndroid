package zw.co.researchhub.happyfirst.SpecificTip;


import android.content.Context;
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

import java.util.List;

import zw.co.researchhub.happyfirst.GeneralTip.GeneralTipListAdapter;
import zw.co.researchhub.happyfirst.GeneralTip.GeneralTipViewModel;
import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.model.GeneralTip;
import zw.co.researchhub.happyfirst.model.SpecificTip;

/**
 * @author
 */

public class SpecificTipListFragment extends Fragment {
    private SpecificTipListAdapter specificTipListAdapter;
    private SpecificTipViewModel specificTipViewModel;
    private Context context;



    public static SpecificTipListFragment newInstance() {
        return new SpecificTipListFragment();
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

        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_tip, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_specific_tip);
        recyclerView.setAdapter(specificTipListAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    private void initData() {
        specificTipViewModel = ViewModelProviders.of(this).get(SpecificTipViewModel.class);
        specificTipViewModel.getGeneralTipLiveData().observe(this, specificTips -> specificTipListAdapter.setGeneralTipList(specificTips));
    }

    public void removeData() {
        if (specificTipViewModel != null) {
            specificTipViewModel.deleteAll();
        }
    }
}
