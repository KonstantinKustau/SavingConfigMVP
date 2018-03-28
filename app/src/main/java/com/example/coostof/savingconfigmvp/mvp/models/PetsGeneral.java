package com.example.coostof.savingconfigmvp.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PetsGeneral {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<PetsData> data = null;

    public String getMessage() {
        return message;
    }

    public List<PetsData> getData() {
        return data;
    }
}
