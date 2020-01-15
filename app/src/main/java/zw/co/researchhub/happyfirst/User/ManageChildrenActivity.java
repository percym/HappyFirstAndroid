package zw.co.researchhub.happyfirst.User;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.model.User;

public class ManageChildrenActivity extends AppCompatActivity {

   private UserAdapter userAdapter;
   private Context context;
   private UserViewModel userViewModel;
   private RecyclerView studentsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);
        context = getApplicationContext();
        userAdapter = new UserAdapter(context);


        initData();
        studentsRecyclerView = findViewById(R.id.recyclerview_manage_student);
        studentsRecyclerView.setAdapter(userAdapter);
        studentsRecyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        studentsRecyclerView.setLayoutManager(new LinearLayoutManager(context));

    }


    private void initData() {
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userAdapter.setUserList(users);
            }
        });
    }
}
