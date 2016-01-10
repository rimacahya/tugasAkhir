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
import model.model_jabatan;
import model.model_karyawan;

/**
 *
 * @author WIN 7
 */
public class controller_jabatan implements interface_jabatan{

    @Override
    public model_jabatan tambah(model_jabatan o) throws SQLException {
        PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
        prepareStatement("INSERT INTO tbl_jabatan (kode_jabatan, jabatan, gaji_pokok, tunjangan) VALUES (?,?,?,?)");
        simpan.setString(1, o.getKode_jabatan());
        simpan.setString(2, o.getJabatan());
        simpan.setInt(3, o.getGaji_pokok());
        simpan.setInt(4, o.getTunjangan());
        simpan.executeUpdate();
        return o;
    }

    @Override
    public model_jabatan ubah(model_jabatan o) throws SQLException {
        PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
        prepareStatement("update tbl_jabatan  set jabatan = ?, gaji_pokok = ?, tunjangan = ? where kode_jabatan = ?");
        simpan.setString(4, o.getKode_jabatan());
        simpan.setString(1, o.getJabatan());
        simpan.setInt(2, o.getGaji_pokok());
        simpan.setInt(3, o.getTunjangan());
        simpan.executeUpdate();
        return o;
    }

    @Override
    public model_jabatan hapus(model_jabatan o) throws SQLException {
        PreparedStatement simpan = (PreparedStatement) koneksi.getkoneksi().
        prepareStatement("delete from tbl_jabatan where kode_jabatan = ?");
        simpan.setString(1, o.getKode_jabatan());
        simpan.executeUpdate();
        return o;
    }

    @Override
    public List<model_jabatan> tampil() throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        Statement stm = (Statement) koneksi.getkoneksi().createStatement();
        ResultSet rst =stm.executeQuery("select * from tbl_jabatan");
        List <model_jabatan> listKry =new ArrayList<>();
        
        while (rst.next()){
        model_jabatan data = new model_jabatan();
        data.setKode_jabatan(rst.getString("kode_jabatan"));
        data.setJabatan(rst.getString("jabatan"));
        data.setGaji_pokok(rst.getInt("gaji_pokok"));
        data.setTunjangan(rst.getInt("tunjangan"));
        listKry.add(data);
        }
      return listKry;
    }
    
}
