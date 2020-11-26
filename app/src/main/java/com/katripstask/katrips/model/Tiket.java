package com.katripstask.katrips.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tiket {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("waktuBerangkat")
    @Expose
    private String waktuBerangkat;
    @SerializedName("waktuTiba")
    @Expose
    private String waktuTiba;
    @SerializedName("harga")
    @Expose
    private int harga;
    @SerializedName("statusTiket")
    @Expose
    private String statusTiket;
    @SerializedName("lokasiBerangkat")
    @Expose
    private String lokasiBerangkat;
    @SerializedName("lokasiTiba")
    @Expose
    private String lokasiTiba;
    @SerializedName("kereta")
    @Expose
    private String kereta;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("noKursi")
    @Expose
    private String noKursi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWaktuBerangkat() {
        return waktuBerangkat;
    }

    public void setWaktuBerangkat(String waktuBerangkat) {
        this.waktuBerangkat = waktuBerangkat;
    }

    public String getWaktuTiba() {
        return waktuTiba;
    }

    public void setWaktuTiba(String waktuTiba) {
        this.waktuTiba = waktuTiba;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getStatusTiket() {
        return statusTiket;
    }

    public void setStatusTiket(String statusTiket) {
        this.statusTiket = statusTiket;
    }

    public String getLokasiBerangkat() {
        return lokasiBerangkat;
    }

    public void setLokasiBerangkat(String lokasiBerangkat) {
        this.lokasiBerangkat = lokasiBerangkat;
    }

    public String getLokasiTiba() {
        return lokasiTiba;
    }

    public void setLokasiTiba(String lokasiTiba) {
        this.lokasiTiba = lokasiTiba;
    }

    public String getKereta() {
        return kereta;
    }

    public void setKereta(String kereta) {
        this.kereta = kereta;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNoKursi() {
        return noKursi;
    }

    public void setNoKursi(String noKursi) {
        this.noKursi = noKursi;
    }
}
