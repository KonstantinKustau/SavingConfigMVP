package com.example.coostof.savingconfigmvp.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.mvp.models.PetsData;

import java.util.List;

public class TabsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerViewClickListener mListener;
    private List<PetsData> mDataset;

    public TabsAdapter(RecyclerViewClickListener mListener, List<PetsData> mDataset) {
        this.mListener = mListener;
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder holder1 = (ViewHolder) holder;

            String mainImage = mDataset.get(position).getUrl();
            String textNumber = String.valueOf(position);
            String textContent = mDataset.get(position).getTitle();

            holder1.bindHolder(mainImage, textNumber, textContent);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerViewClickListener mListener;
        private LinearLayout layoutContainer;
        private ImageView ivMain;
        private TextView tvNumber;
        private TextView tvContent;

        ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            ivMain = itemView.findViewById(R.id.iv_item);
            tvNumber = itemView.findViewById(R.id.tv_number);
            tvContent = itemView.findViewById(R.id.tv_content);
            layoutContainer = itemView.findViewById(R.id.container);

            layoutContainer.setOnClickListener(this);
        }

        void bindHolder(String mainImage, String textNumber, String textContent) {
            Glide.with(SavingConfigMvpApp.getContext())
                    .load(mainImage)
                    .into(ivMain);
            tvNumber.setText(textNumber);
            tvContent.setText(textContent);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    public PetsData getItemByPosition(int position) {
        return mDataset == null || position < 0 || position > mDataset.size() ? null : mDataset.get(position);
    }
}
