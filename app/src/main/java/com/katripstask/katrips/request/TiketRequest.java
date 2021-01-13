package com.katripstask.katrips.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TiketRequest {
    @SerializedName("tiket_id")
    @Expose
    private String id;
    @SerializedName("waktu_berangkat")
    @Expose
    private String waktuBerangkat;
    @SerializedName("waktu_tiba")
    @Expose
    private String waktuTiba;
    @SerializedName("harga")
    @Expose
    private int harga;
    @SerializedName("status_tiket")
    @Expose
    private String statusTiket;
    @SerializedName("lokasi_berangkat")
    @Expose
    private String lokasiBerangkat;
    @SerializedName("lokasi_tiba")
    @Expose
    private String lokasiTiba;
    @SerializedName("kereta")
    @Expose
    private String kereta;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("no_kursi")
    @Expose
    private String noKursi;
    @SerializedName("gerbong_kode")
    @Expose
    private String kodeGerbong;

    public String getKodeGerbong() {
        return kodeGerbong;
    }

    public void setKodeGerbong(String kodeGerbong) {
        this.kodeGerbong = kodeGerbong;
    }

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
