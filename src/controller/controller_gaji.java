/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import connection.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.model_gaji;
import model.table_gaji;

/**
 *
 * @author WIN 7
 */
public class controller_gaji implements interface_gaji {

    @Override
    public boolean simpan(model_gaji o) throws SQLException
    {
        boolean result = false;
        PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
        prepareStatement("insert into tbl_gaji (no_slip, NIK, gaji_pokok, jumlah_kehadiran,tunjangan, total_gaji) values (?, ?, ?, ?, ?, ?)");
        simpan.setInt(1, o.getNo_slip());
        simpan.setString(2, o.getNIK());
        simpan.setInt(3, o.getGaji_pokok());
        simpan.setInt(4, o.getJumlah_kehadiran());
        simpan.setInt(5, o.getTunjangan());
        simpan.setInt(6, o.getTotal_gaji());
        result = simpan.execute();
        return result;
    }

    @Override
    public String[] getKaryawan(String nik) throws SQLException {
        String[] result = new String[5];
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst = stm.executeQuery("SELECT nama,jabatan,gaji_pokok,tunjangan, IFNULL((SELECT COUNT(id_absensi) FROM tbl_absensi WHERE NIK = tbl_karyawan.`NIK` GROUP BY tbl_absensi.NIK),0) AS jumlah FROM tbl_karyawan JOIN tbl_jabatan ON tbl_karyawan.kode_jabatan = tbl_jabatan.`kode_jabatan` where tbl_karyawan.NIK = '" + nik +"'");
        while (rst.next()){
            result[0] = rst.getString("nama");
            result[1] = rst.getString("jabatan");
            result[2] = rst.getString("gaji_pokok");
            result[3] = rst.getString("tunjangan");
            result[4] = rst.getString("jumlah");
        }
        return result;
    }

    @Override
    public List<table_gaji> tampil() throws SQLException {
        List<table_gaji> result = new ArrayList<table_gaji>();
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst = stm.executeQuery("SELECT no_slip, tbl_karyawan.nik,nama,jabatan,tbl_gaji.gaji_pokok,tbl_gaji.tunjangan,jumlah_kehadiran,total_gaji FROM tbl_gaji JOIN tbl_karyawan ON tbl_gaji.`NIK`=tbl_karyawan.`NIK` JOIN tbl_jabatan ON tbl_jabatan.`kode_jabatan`=tbl_karyawan.`kode_jabatan`");
        while (rst.next()){
            model.table_gaji row = new model.table_gaji();
            row.setNo_slip(Integer.parseInt(rst.getString("no_slip")));
            row.setNIK(rst.getString("nik"));
            row.setNama(rst.getString("nama"));
            row.setJabatan(rst.getString("jabatan"));
            row.setGaji_pokok(Integer.parseInt(rst.getString("gaji_pokok")));
            row.setTunjangan(Integer.parseInt(rst.getString("tunjangan")));
            row.setJumlah_kehadiran(Integer.parseInt(rst.getString("jumlah_kehadiran")));
            row.setTotal_gaji(Integer.parseInt(rst.getString("total_gaji")));
            result.add(row);
        }
        return result;
    }
}
