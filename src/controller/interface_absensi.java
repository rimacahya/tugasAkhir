/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.table_absen;
import java.sql.SQLException;
import java.util.List;
import model.model_absensi;


/**
 *
 * @author WIN 7
 */
public interface interface_absensi {
    boolean masuk (model_absensi o)throws SQLException;
    boolean keluar (model_absensi o) throws SQLException;
    List<model.table_absen> tampil ()throws SQLException; 
    String[] getKaryawan (String nik) throws SQLException;
      
}
