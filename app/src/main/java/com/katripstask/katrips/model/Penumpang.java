package com.katripstask.katrips.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Penumpang implements Serializable {
    @SerializedName("nama_ktp")
    @Expose
    private String nama;
    @SerializedName("no_ktp")
    @Expose
    private int noKtp;
    @SerializedName("is_dewasa")
    @Expose
    private boolean isDewasa;

    public Penumpang(String nama, int noKtp, boolean isDewasa) {
        this.nama = nama;
        this.noKtp = noKtp;
        this.isDewasa = isDewasa;
    }

    public String getNama() {
        return nama;
    }

    public int getNoKtp() {
        return noKtp;
    }

    public boolean getIsDewasa() {
        return isDewasa;
    }
}
