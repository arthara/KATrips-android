package com.katripstask.katrips.model;

public class Perjalanan {
    private String waktuBerangkat;
    private String waktuTiba;
    private String keretaKelasId;
    private int harga;
    private int lokasiBerangkatId;
    private int lokasiTibaId;
    private int penumpangTersedia;

    public Perjalanan(String waktuBerangkat, String waktuTiba, String keretaKelasId, int harga, int lokasiBerangkatId, int lokasiTibaId, int penumpangTersedia) {
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.keretaKelasId = keretaKelasId;
        this.harga = harga;
        this.lokasiBerangkatId = lokasiBerangkatId;
        this.lokasiTibaId = lokasiTibaId;
        this.penumpangTersedia = penumpangTersedia;
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

    public String getKeretaKelasId() {
        return keretaKelasId;
    }

    public void setKeretaKelasId(String keretaKelasId) {
        this.keretaKelasId = keretaKelasId;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
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

    public int getPenumpangTersedia() {
        return penumpangTersedia;
    }

    public void setPenumpangTersedia(int penumpangTersedia) {
        this.penumpangTersedia = penumpangTersedia;
    }
}
