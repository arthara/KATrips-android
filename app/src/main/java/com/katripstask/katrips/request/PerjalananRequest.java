package com.katripstask.katrips.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PerjalananRequest {
    @SerializedName("tanggal_berangkat")
    @Expose
    private String tglBerangkat;
    @SerializedName("lokasi_berangkat_id")
    @Expose
    private int lokasiBerangkatId;
    @SerializedName("lokasi_tiba_id")
    @Expose
    private int lokasiTibaId;
    @SerializedName("jmlh_penumpang")
    @Expose
    private int jmlhPenumpang;

    public PerjalananRequest(String tglBerangkat, int lokasiBerangkatId, int lokasiTibaId, int jmlhPenumpang) {
        this.tglBerangkat = tglBerangkat;
        this.lokasiBerangkatId = lokasiBerangkatId;
        this.lokasiTibaId = lokasiTibaId;
        this.jmlhPenumpang = jmlhPenumpang;
    }

    public String getTglBerangkat() {
        return tglBerangkat;
    }

    public void setTglBerangkat(String tglBerangkat) {
        this.tglBerangkat = tglBerangkat;
    }

    public int getLokasiBerangkatId() {
        return lokasiBerangkatId;
    }

    public void setLokasiBerangkatId(int lokasiBerangkatId) {
        this.lokasiBerangkatId = lokasiBerangkatId;
    }

    public int getLokasiTibaId() {
        return lokasiTibaId;
    }

    public void setLokasiTibaId(int lokasiTibaId) {
        this.lokasiTibaId = lokasiTibaId;
    }

    public int getJmlhPenumpang() {
        return jmlhPenumpang;
    }

    public void setJmlhPenumpang(int jmlhPenumpang) {
        this.jmlhPenumpang = jmlhPenumpang;
    }
}
