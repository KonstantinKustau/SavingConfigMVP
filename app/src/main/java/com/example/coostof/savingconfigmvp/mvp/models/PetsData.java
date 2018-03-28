package com.example.coostof.savingconfigmvp.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetsData {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    public String title;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
