/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author WIN 7
 */
public interface interface_gaji
{
    public boolean simpan(model.model_gaji o) throws SQLException;
    public List<model.table_gaji> tampil() throws SQLException;
    public String[] getKaryawan(String nik) throws SQLException;
}
