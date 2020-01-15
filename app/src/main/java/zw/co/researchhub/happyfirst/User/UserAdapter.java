package zw.co.researchhub.happyfirst.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zw.co.researchhub.happyfirst.HappyFirstDatabase;
import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.model.User;


/**
 * @author
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private LayoutInflater layoutInflater;
    private List<User> userList;
    private Context context;
    private UserDao userDao;

    public UserAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        userDao = HappyFirstDatabase.getDatabase(context).userDao();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.item_list_manage_students, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        if (userList == null) {
            return;
        }

        final User user = userList.get(position);
        if (userList != null) {
            holder.fname.setText(user.getName());
            holder.lname.setText(user.getName());
            holder.gender.setText(user.getGender());
            holder.isGoing.setText(user.getIsGoing() == true ?"HAS STARTED":"HAS NOT STARTED");

            holder.takeQuiz.setOnClickListener(v -> {
//                Intent intent = new Intent(v.getContext(), ReadActivity.class);
//                intent.putExtra("title",holder.titleText.getText() );
//                intent.putExtra("content",holder.contentText.getText() );
//                v.getContext().startActivity(intent);
            });

            holder.setIsGoing.setOnClickListener(v -> {
                User currentUser = userList.get(position);
                if (currentUser.getIsGoing()==true){
                    currentUser.setIsGoing(false);
                }else {
                    currentUser.setIsGoing(true);
                }
                userDao.update(user);
                notifyDataSetChanged();

            });

        }
    }

    @Override
    public int getItemCount() {
        if (userList == null) {
            return 0;
        } else {
            return userList.size();
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView fname;
        private TextView lname;
        private TextView gender;
        private TextView isGoing;
        private Button takeQuiz;
        private Button setIsGoing;

        public UserViewHolder(View itemView) {
            super(itemView);

            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
            gender = itemView.findViewById(R.id.gender);
            isGoing = itemView.findViewById(R.id.isGoing);
            takeQuiz = itemView.findViewById(R.id.takeQuiz);
            setIsGoing = itemView.findViewById(R.id.setGoing);
        }
    }
}
