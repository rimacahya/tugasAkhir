/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author WIN 7
 */
public class koneksi {
  //buat atribut koneksi bertipe connection
    private static Connection koneksi;
    //buat method (fungsi koneksi)
    public static Connection getkoneksi(){
    //kondisi jika koneksi datbase kosong
        if(koneksi==null){
            try {
                // memanggil drive
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                // akses ke database
                koneksi=DriverManager.getConnection("jdbc:mysql://localhost/db_penggajian","root","123");    
            } catch (Exception e) {
                // pesan jika koneksi gagal
                System.out.println("koneksi database gagal.."+e);
            }
        }
        return koneksi;
    }
}
