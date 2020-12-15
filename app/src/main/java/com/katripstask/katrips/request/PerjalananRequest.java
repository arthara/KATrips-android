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
    @SerializedName("jmlh_penumpang_dewasa")
    @Expose
    private int jmlhPenumpangDws;
    @SerializedName("jmlh_penumpang_bayi")
    @Expose
    private int jmlhPenumpangBy;

    public PerjalananRequest(String tglBerangkat, int lokasiBerangkatId, int lokasiTibaId, int jmlhPenumpangDws, int jmlhPenumpangBy) {
        this.tglBerangkat = tglBerangkat;
        this.lokasiBerangkatId = lokasiBerangkatId;
        this.lokasiTibaId = lokasiTibaId;
        this.jmlhPenumpangDws = jmlhPenumpangDws;
        this.jmlhPenumpangBy = jmlhPenumpangBy;
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

    public int getJmlhPenumpangDws() {
        return jmlhPenumpangDws;
    }

    public void setJmlhPenumpangDws(int jmlhPenumpangDws) {
        this.jmlhPenumpangDws = jmlhPenumpangDws;
    }

    public int getJmlhPenumpangBy() {
        return jmlhPenumpangBy;
    }

    public void setJmlhPenumpangBy(int jmlhPenumpangBy) {
        this.jmlhPenumpangBy = jmlhPenumpangBy;
    }
}
