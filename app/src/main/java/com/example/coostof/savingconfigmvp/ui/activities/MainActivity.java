package com.example.coostof.savingconfigmvp.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.mvp.models.PetsData;
import com.example.coostof.savingconfigmvp.mvp.presenters.MainActivityPresenter;
import com.example.coostof.savingconfigmvp.mvp.views.MainView;
import com.example.coostof.savingconfigmvp.ui.fragments.FirstTabFragment;
import com.example.coostof.savingconfigmvp.ui.fragments.ItemFragment;
import com.example.coostof.savingconfigmvp.ui.fragments.SecondTabFragment;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainActivityPresenter mainActivityPresenter;

    public TabLayout tabLayout;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        if (savedInstanceState == null) {
            choiceFragment(0);
        }
        if (mainActivityPresenter.getTabPos() == 0) {
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            if (tab != null) {
                tab.select();
            }
        } else {
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            if (tab != null) {
                tab.select();
            }
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                choiceFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void itemClickList(PetsData petsData, int position) {
        tabLayout.setVisibility(View.GONE);
        ItemFragment itemFragment = new ItemFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(itemFragment.POS_ARG_TAG, position);
        bundle.putString(itemFragment.TITLE_ARG_TAG, petsData.getTitle());
        bundle.putString(itemFragment.URL_ARG_TAG, petsData.getUrl());
        itemFragment.setArguments(bundle);

        transaction = getSupportFragmentManager().beginTransaction();
        mainActivityPresenter.openItemList(transaction, itemFragment);
    }

    @Override
    public void onBackPressed() {
        tabLayout.setVisibility(View.VISIBLE);
        if (mainActivityPresenter.isItemFragmentShow()) {
            choiceFragment(mainActivityPresenter.getTabPos());
        } else {
            super.onBackPressed();
        }
    }

    private void choiceFragment(int position) {
        FirstTabFragment firstTabFragment = new FirstTabFragment();
        SecondTabFragment secondTabFragment = new SecondTabFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        mainActivityPresenter.setTabPos(position);
        switch (position) {
            case 0:
                mainActivityPresenter.setFragment(transaction, firstTabFragment);
                break;
            case 1:
                mainActivityPresenter.setFragment(transaction, secondTabFragment);
                break;
            default:
                break;
        }
    }
}
