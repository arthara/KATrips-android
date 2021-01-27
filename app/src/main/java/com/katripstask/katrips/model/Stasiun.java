package com.katripstask.katrips.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Stasiun implements Serializable {
    private int id;
    private String nama;
    private String kode;

    public Stasiun(int id, String nama, String kode) {
        this.id = id;
        this.nama = nama;
        this.kode = kode;
    }

    public Stasiun() {
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getStasiunId() {
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

    @NonNull
    @Override
    public String toString() {
        return nama + " (" + kode + ")";
    }
}
