package com.example.coostof.savingconfigmvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.bumptech.glide.Glide;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;

public class ItemFragment extends MvpAppCompatFragment {

    public final String POS_ARG_TAG = "POS_ARG";
    public final String TITLE_ARG_TAG = "TITLE_ARG";
    public final String URL_ARG_TAG = "URL_ARG";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_fragment, container, false);

        ImageView ivItem = view.findViewById(R.id.iv_item);
        TextView tvNumber = view.findViewById(R.id.tv_number);
        TextView tvContent = view.findViewById(R.id.tv_content);

        Bundle bundle = this.getArguments();
        if (bundle == null) {
            return view;
        }

        int position = bundle.getInt(POS_ARG_TAG);
        String title = bundle.getString(TITLE_ARG_TAG);
        String url = bundle.getString(URL_ARG_TAG);

        Glide.with(SavingConfigMvpApp.getContext())
                .load(url)
                .into(ivItem);
        tvNumber.setText(String.valueOf(position));
        tvContent.setText(title);

        return view;
    }

}
