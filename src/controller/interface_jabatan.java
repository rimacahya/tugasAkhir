/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import model.model_jabatan;
/**
 *
 * @author WIN 7
 */
public interface interface_jabatan {
    model_jabatan tambah (model_jabatan o)throws SQLException;
    model_jabatan ubah (model_jabatan o) throws SQLException;
    model_jabatan hapus (model_jabatan o)throws SQLException;
    List<model_jabatan> tampil ()throws SQLException;
}