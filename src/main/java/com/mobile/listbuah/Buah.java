package com.mobile.listbuah;

import java.util.List;

/**
 * Model data untuk satu buah.
 */
public class Buah {
    private String nama;
    private String emoji;
    private String asal;
    private String rasa;
    private String deskripsi;
    private List<String> manfaat;

    public Buah(String nama, String emoji, String asal, String rasa,
                String deskripsi, List<String> manfaat) {
        this.nama = nama;
        this.emoji = emoji;
        this.asal = asal;
        this.rasa = rasa;
        this.deskripsi = deskripsi;
        this.manfaat = manfaat;
    }

    public String getNama()      { return nama; }
    public String getEmoji()     { return emoji; }
    public String getAsal()      { return asal; }
    public String getRasa()      { return rasa; }
    public String getDeskripsi() { return deskripsi; }
    public List<String> getManfaat() { return manfaat; }
}
