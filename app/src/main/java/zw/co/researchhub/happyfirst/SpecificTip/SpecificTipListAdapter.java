package zw.co.researchhub.happyfirst.SpecificTip;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zw.co.researchhub.happyfirst.GeneralTip.ReadActivity;
import zw.co.researchhub.happyfirst.R;
import zw.co.researchhub.happyfirst.model.GeneralTip;
import zw.co.researchhub.happyfirst.model.SpecificTip;


/**
 * @author
 */

public class SpecificTipListAdapter extends RecyclerView.Adapter<SpecificTipListAdapter.GeneralTipViewHolder> {
    private LayoutInflater layoutInflater;
    private List<SpecificTip> specificTips;
    private Context context;

    public SpecificTipListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setGeneralTipList(List<SpecificTip> specificTips) {
        this.specificTips = specificTips;
        notifyDataSetChanged();
    }

    @Override
    public GeneralTipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.item_list_specific, parent, false);
        return new GeneralTipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GeneralTipViewHolder holder, int position) {
        if (specificTips == null) {
            return;
        }

        final SpecificTip specificTip = specificTips.get(position);
        if (specificTip != null) {
            holder.titleText.setText(specificTip.getTitle());
            holder.contentText.setText(specificTip.getContent());

            holder.itemView.setOnClickListener(v -> {

                Intent intent = new Intent(v.getContext(), ReadActivity.class);
                intent.putExtra("title",holder.titleText.getText() );
                intent.putExtra("content",holder.contentText.getText() );
                v.getContext().startActivity(intent);
            });

        }
    }

    @Override
    public int getItemCount() {
        if (specificTips == null) {
            return 0;
        } else {
            return specificTips.size();
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
