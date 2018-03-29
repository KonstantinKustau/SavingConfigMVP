package com.example.coostof.savingconfigmvp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.common.Constants;

public class PrefUtils {
    public static SharedPreferences getPrefs() {
        return SavingConfigMvpApp.getContext().getSharedPreferences(Constants.APP_PREFS, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }

    public static void setFirstScrollPosition(final int userType) {
        PrefUtils.getEditor().putInt(Constants.FIRST_SCROLL_POSITION, userType).commit();
    }

    public static int getFirstScrollPosition() {
        return PrefUtils.getPrefs().getInt(Constants.FIRST_SCROLL_POSITION, 0);
    }

    public static void setSecondScrollPosition(final int userType) {
        PrefUtils.getEditor().putInt(Constants.SECOND_SCROLL_POSITION, userType).commit();
    }

    public static int getSecondScrollPosition() {
        return PrefUtils.getPrefs().getInt(Constants.SECOND_SCROLL_POSITION, 0);
    }
}
