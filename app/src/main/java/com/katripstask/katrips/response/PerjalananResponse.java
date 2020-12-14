package com.katripstask.katrips.response;

import com.katripstask.katrips.model.Perjalanan;

import java.util.ArrayList;

public class PerjalananResponse {
    ArrayList<Perjalanan> perjalanans;

    public PerjalananResponse(ArrayList<Perjalanan> perjalanans) {
        this.perjalanans = perjalanans;
    }

    public ArrayList<Perjalanan> getPerjalanans() {
        return perjalanans;
    }

    public void setPerjalanans(ArrayList<Perjalanan> perjalanans) {
        this.perjalanans = perjalanans;
    }
}
