/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author WIN 7
 */
public class model_absensi {
    private int id_absensi;
    private String NIK;
    private Date Tanggal;
    private Date Masuk;
    private Date Keluar;

    public int getId_absensi() {
        return id_absensi;
    }

    public String getNIK() {
        return NIK;
    }

    public Date getTanggal() {
        return Tanggal;
    }

    public Date getMasuk() {
        return Masuk;
    }

    public Date getKeluar() {
        return Keluar;
    }

    public void setId_absensi(int id_absensi) {
        this.id_absensi = id_absensi;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }

    public void setMasuk(Date Masuk) {
        this.Masuk = Masuk;
    }

    public void setKeluar(Date Keluar) {
        this.Keluar = Keluar;
    }
    
    
}
