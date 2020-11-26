package com.katripstask.katrips.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FindedTiket {
    @SerializedName("tiket")
    @Expose
    private List<Tiket> tikets = null;

    public List<Tiket> getTikets(){
        return tikets;
    }

}
