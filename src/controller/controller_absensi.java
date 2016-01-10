/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.table_absen;
import connection.koneksi;
import model.model_karyawan;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import model.model_absensi;
import model.model_jabatan;

/**
 *
 * @author WIN 7
 */
public class controller_absensi implements interface_absensi {

    @Override
    public boolean masuk(model_absensi o) throws SQLException {
        boolean result;
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM tbl_absensi WHERE nik='"+ o.getNIK() + "' AND Tanggal = DATE(NOW())");
        if (rst.isBeforeFirst()){
            result = false;
        }
        else
        {
                PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
                prepareStatement("insert into tbl_absensi (NIK, Tanggal, Masuk, Keluar) values (?, ?, ?, ?)");
                simpan.setString(1, o.getNIK());
                simpan.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(o.getTanggal()));
                simpan.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getMasuk()));
                simpan.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getMasuk()));
                result = simpan.execute();
        }
       return true;
    }

    @Override
    public boolean keluar(model_absensi o) throws SQLException {
        boolean result;
        PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
        prepareStatement("update tbl_absensi set Keluar = ? where nik = ? and date(Masuk) = Date(now())");
        simpan.setString(2, o.getNIK());
        simpan.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getKeluar()));
        result = simpan.execute();
        return true;
    }

    @Override
    public List<table_absen> tampil() throws SQLException {
        List<table_absen> result = new ArrayList<table_absen>();
        
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst = stm.executeQuery("select * from tbl_karyawan join tbl_absensi on tbl_karyawan.nik = tbl_absensi.nik join tbl_jabatan on tbl_jabatan.kode_jabatan = tbl_karyawan.kode_jabatan");
        while (rst.next()){
            table_absen data = new table_absen();
            data.setJabatan(rst.getString("jabatan"));
            data.setKeluar(rst.getTimestamp("Keluar"));
            data.setMasuk(rst.getTimestamp("Masuk"));
            data.setNIK(rst.getString("NIK"));
            data.setNama(rst.getString("Nama"));
            data.setTanggal(rst.getTimestamp("Tanggal"));
            result.add(data);
        }
        return result;
    }
   
    @Override
    public String[] getKaryawan(String nik) throws SQLException {
        String[] result = new String[3];
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst = stm.executeQuery("select * from tbl_karyawan join tbl_jabatan on tbl_jabatan.kode_jabatan = tbl_karyawan.kode_jabatan where NIK = '" + nik + "'");
        while (rst.next()){
            result[0] = rst.getString("NIK");
            result[1] = rst.getString("Nama");
            result[2] = rst.getString("jabatan");
        }
        return result;
    }
}