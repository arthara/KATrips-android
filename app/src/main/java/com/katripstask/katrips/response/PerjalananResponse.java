package com.katripstask.katrips.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.katripstask.katrips.model.Perjalanan;

import java.util.List;

public class PerjalananResponse {
    @SerializedName("perjalanans")
    List<Perjalanan> perjalanans;
    public String message;
    public boolean success;

    public PerjalananResponse(List<Perjalanan> perjalanans) {
        this.perjalanans = perjalanans;
    }

    public List<Perjalanan> getPerjalanans() {
        return perjalanans;
    }

    public void setPerjalanans(List<Perjalanan> perjalanans) {
        this.perjalanans = perjalanans;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(perjalanans.size());
    }
}
