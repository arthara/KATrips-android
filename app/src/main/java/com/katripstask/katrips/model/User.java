package com.katripstask.katrips.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String nama;
    private String email;
    private String alamat;
    @SerializedName("tgl_lahir")
    private String tglLahir;

    public User(int id, String nama, String email, String alamat, String tglLahir) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.tglLahir = tglLahir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }
}
