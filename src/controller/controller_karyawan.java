/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.koneksi;
import model.model_karyawan;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.HashMap;


/**
 *
 * @author WIN 7
 */
public class controller_karyawan implements interface_karyawan{

    @Override
    public model_karyawan tambah(model_karyawan o) throws SQLException {
        PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
       prepareStatement("INSERT INTO tbl_karyawan VALUES (?,?,?,?,?,?,?,?)");
       simpan.setString(1, o.getNIK());
       simpan.setString(2, o.getNama());
       simpan.setString(3, o.getTempat_lahir());
       simpan.setString(4, o.getTgl_lahir());
       simpan.setString(5, o.getJenis_kelamin());
       simpan.setString(6, o.getAlamat());
       simpan.setString(7, o.getStatus());
       simpan.setString(8, o.getKodeJabatan());
       simpan.executeUpdate();
      
        return o; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public model_karyawan ubah(model_karyawan o) throws SQLException {
         //To change body of generated methods, choose Tools | Templates.
    PreparedStatement ubah = (PreparedStatement) koneksi.getkoneksi().
                prepareStatement("UPDATE tbl_karyawan SET Nama=?, Alamat=?,Tempat_Lahir=?,Tanggal_lahir=?, Jenis_kelamin=?, Alamat=?, Status = ?,kode_jabatan = ? WHERE Nik=?");
        ubah.setString(1, o.getNama());
        ubah.setString(2, o.getAlamat());
       ubah.setString(3, o.getTempat_lahir());
       ubah.setString(4, o.getTgl_lahir());
       ubah.setString(5, o.getJenis_kelamin());
       ubah.setString(6, o.getAlamat());
       ubah.setString(7, o.getStatus());
       ubah.setString(8, o.getKodeJabatan());
        ubah.setString(9, o.getNIK());
        ubah.executeUpdate();
        return o;
    }

    @Override
    public model_karyawan hapus(model_karyawan o) throws SQLException {
        PreparedStatement hapus = (PreparedStatement) koneksi.getkoneksi()
                .prepareStatement("delete from tbl_karyawan where nik = ?");
        hapus.setString(1, o.getNIK());
        hapus.execute();
        return o;
    }

    @Override
    public List<model_karyawan> tampil() throws SQLException {
    //To change body of generated methods, choose Tools | Templates.
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst =stm.executeQuery("select * from tbl_karyawan");
        List <model_karyawan> listKry =new ArrayList<>();
        
        while (rst.next()){
        model_karyawan kry =new model_karyawan();
        kry.setNIK(rst.getString("NIK"));
        kry.setNama(rst.getString("Nama"));
        kry.setAlamat(rst.getString("Alamat"));
        kry.setJenis_kelamin(rst.getString("Jenis_kelamin"));
        kry.setTempat_lahir(rst.getString("Tempat_lahir"));
        kry.setTgl_lahir(rst.getString("Tanggal_lahir"));
        kry.setStatus(rst.getString("Status"));
        kry.setKodeJabatan(rst.getString("kode_jabatan"));
        
        listKry.add(kry);
        }
      return listKry;     
    }   
}
