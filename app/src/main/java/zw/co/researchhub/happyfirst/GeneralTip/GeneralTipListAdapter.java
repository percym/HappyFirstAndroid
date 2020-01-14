package zw.co.researchhub.happyfirst.GeneralTip;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.model.GeneralTip;


/**
 * @author
 */

public class GeneralTipListAdapter extends RecyclerView.Adapter<GeneralTipListAdapter.GeneralTipViewHolder> {
    private LayoutInflater layoutInflater;
    private List<GeneralTip> generalTipList;
    private Context context;

    public GeneralTipListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setGeneralTipList(List<GeneralTip> generalTipList) {
        this.generalTipList = generalTipList;
        notifyDataSetChanged();
    }

    @Override
    public GeneralTipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.item_list_movie, parent, false);
        return new GeneralTipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GeneralTipViewHolder holder, int position) {
        if (generalTipList == null) {
            return;
        }

        final GeneralTip generalTip = generalTipList.get(position);
        if (generalTip != null) {
            holder.titleText.setText(generalTip.getTitle());
            holder.contentText.setText(generalTip.getContent());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    DialogFragment dialogFragment = MovieSaveDialogFragment.newInstance(movie.title, directorFullName);
//                    dialogFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), TAG_DIALOG_MOVIE_SAVE);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (generalTipList == null) {
            return 0;
        } else {
            return generalTipList.size();
        }
    }

    static class GeneralTipViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private TextView contentText;

        public GeneralTipViewHolder(View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.generalTitle);
            contentText = itemView.findViewById(R.id.generalContent);
        }
    }
}
