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
public class model_gaji {
    
    private int no_slip;
    private String NIK;
    private int gaji_pokok;
    private int jumlah_kehadiran;
    private int tunjangan;
    private int total_gaji;

    public int getNo_slip() {
        return no_slip;
    }

    public void setNo_slip(int no_slip) {
        this.no_slip = no_slip;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public int getGaji_pokok() {
        return gaji_pokok;
    }

    public void setGaji_pokok(int gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }

    public int getJumlah_kehadiran() {
        return jumlah_kehadiran;
    }

    public void setJumlah_kehadiran(int jumlah_kehadiran) {
        this.jumlah_kehadiran = jumlah_kehadiran;
    }

    public int getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(int tunjangan) {
        this.tunjangan = tunjangan;
    }

    public int getTotal_gaji() {
        return total_gaji;
    }

    public void setTotal_gaji(int total_gaji) {
        this.total_gaji = total_gaji;
    }
    
    
}
