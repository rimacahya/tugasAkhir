/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author WIN 7
 */
public class model_jabatan {
    private String kode_jabatan;
    private String jabatan;
    private int gaji_pokok;
    private int tunjangan;

    public String getKode_jabatan() {
        return kode_jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public int getGaji_pokok() {
        return gaji_pokok;
    }

    public int getTunjangan() {
        return tunjangan;
    }

    public void setKode_jabatan(String kode_jabatan) {
        this.kode_jabatan = kode_jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setGaji_pokok(int gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }

    public void setTunjangan(int tunjangan) {
        this.tunjangan = tunjangan;
    }
}
