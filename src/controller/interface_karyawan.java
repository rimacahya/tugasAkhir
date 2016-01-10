/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.SQLException;
import java.util.List;
import model.model_karyawan;

/**
 *
 * @author WIN 7
 */
public interface interface_karyawan {
    
    model_karyawan tambah (model_karyawan o)throws SQLException;
    model_karyawan ubah (model_karyawan o) throws SQLException;
    model_karyawan hapus (model_karyawan o)throws SQLException;
    List<model_karyawan> tampil ()throws SQLException;
    
}
