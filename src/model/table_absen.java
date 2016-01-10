/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author WIN 7
 */
public class table_absen {
    private Date Tanggal;
    private String NIK;
    private String Nama;
    private String jabatan;
    private Date Masuk;
    private Date Keluar;

    public Date getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Date getMasuk() {
        return Masuk;
    }

    public void setMasuk(Date Masuk) {
        this.Masuk = Masuk;
    }

    public Date getKeluar() {
        return Keluar;
    }

    public void setKeluar(Date Keluar) {
        this.Keluar = Keluar;
    }
    
    
}
