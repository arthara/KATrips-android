package com.katripstask.katrips.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Perjalanan implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("waktu_berangkat")
    private String waktuBerangkat;
    @SerializedName("waktu_tiba")
    private String waktuTiba;
    @SerializedName("kelas")
    private String kelas;
    @SerializedName("kereta")
    private String kereta;
    @SerializedName("harga")
    private int harga;
    @SerializedName("lokasi_berangkat")
    private Stasiun lokasiBerangkat;
    @SerializedName("lokasi_tiba")
    private Stasiun lokasiTiba;
    @SerializedName("penumpang_tersedia")
    private int penumpangTersedia;

    public Perjalanan(int id, String waktuBerangkat, String waktuTiba, String kelas, String kereta, int harga, Stasiun lokasiBerangkat, Stasiun lokasiTiba, int penumpangTersedia) {
        this.id = id;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.kelas = kelas;
        this.kereta = kereta;
        this.harga = harga;
        this.lokasiBerangkat = lokasiBerangkat;
        this.lokasiTiba = lokasiTiba;
        this.penumpangTersedia = penumpangTersedia;
    }

    public int getId() {
        return id;
    }

    public String getKelas() {
        return kelas;
    }

    public String getKereta() {
        return kereta;
    }

    public Stasiun getLokasiBerangkat() {
        return lokasiBerangkat;
    }

    public Stasiun getLokasiTiba() {
        return lokasiTiba;
    }

    public String getWaktuBerangkat(Boolean tanggal) {
        String[] temp = waktuBerangkat.split(" ");
        if(tanggal)
            return temp[0];
        else
            return temp[1];
    }

    public void setWaktuBerangkat(String waktuBerangkat) {
        this.waktuBerangkat = waktuBerangkat;
    }

    public String getWaktuTiba(Boolean tanggal) {
        String[] temp = waktuTiba.split(" ");
        if(tanggal)
            return temp[0];
        else
            return temp[1];
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

    public int getPenumpangTersedia() {
        return penumpangTersedia;
    }

    public void setPenumpangTersedia(int penumpangTersedia) {
        this.penumpangTersedia = penumpangTersedia;
    }
}
