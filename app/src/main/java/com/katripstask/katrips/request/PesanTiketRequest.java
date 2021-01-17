package com.katripstask.katrips.request;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.katripstask.katrips.model.Penumpang;

import java.util.List;

public class PesanTiketRequest {
    @SerializedName("penumpangs")
    @Expose
    private List<Penumpang> penumpangs;
    @SerializedName("id_perjalanan")
    @Expose
    private int idPerjalanan;

    public PesanTiketRequest(List<Penumpang> penumpangs, int idPerjalanan) {
        this.penumpangs = penumpangs;
        this.idPerjalanan = idPerjalanan;
    }

    public List<Penumpang> getPenumpangs() {
        return penumpangs;
    }

    public void setPenumpangs(List<Penumpang> penumpangs) {
        this.penumpangs = penumpangs;
    }

    public int getIdPerjalanan() {
        return idPerjalanan;
    }

    public void setIdPerjalanan(int idPerjalanan) {
        this.idPerjalanan = idPerjalanan;
    }
}
