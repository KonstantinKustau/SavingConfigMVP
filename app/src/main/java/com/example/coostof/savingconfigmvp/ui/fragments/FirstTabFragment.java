package com.example.coostof.savingconfigmvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.mvp.models.PetsData;
import com.example.coostof.savingconfigmvp.mvp.presenters.FirstTabPresenter;
import com.example.coostof.savingconfigmvp.mvp.views.FirstTabView;
import com.example.coostof.savingconfigmvp.mvp.views.MainView;
import com.example.coostof.savingconfigmvp.ui.adapters.TabsAdapter;

public class FirstTabFragment extends MvpAppCompatFragment implements FirstTabView {

    @InjectPresenter
    FirstTabPresenter firstTabPresenter;

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_tab_fragment, container, false);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        firstTabPresenter.setPetsInAdapter();

        return view;
    }

    @Override
    public void setAdapter(TabsAdapter adapter) {
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.getLayoutManager().scrollToPosition(firstTabPresenter.getLastListPosition());
    }

    @Override
    public void internetError() {
        Toast.makeText(getContext(), getResources().getString(R.string.error_connection_internet), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClickList(PetsData petsData, int position) {
        if (getActivity() instanceof MainView) {
            ((MainView) getActivity()).itemClickList(petsData, position);
        }
    }

    @Override
    public void onStop() {
        int lastListPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        firstTabPresenter.setLastListPosition(lastListPosition);
        super.onStop();
    }
}
