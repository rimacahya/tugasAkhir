/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.model_jabatan;
import model.model_karyawan;

/**
 *
 * @author WIN 7
 */
public class frm_jabatan extends javax.swing.JFrame {

    /**
     * Creates new form frm_jabatan
     */
    public frm_jabatan() {
        initComponents();
        jabatanService = new controller_jabatan();
        awal();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_kode_jabatan = new javax.swing.JTextField();
        txt_jabatan = new javax.swing.JTextField();
        txt_gaji_pokok = new javax.swing.JTextField();
        txt_tunjangan = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Kode Jabatan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, -1));

        jLabel2.setText("Jabatan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));

        jLabel3.setText("Gaji Pokok");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, -1, -1));

        jLabel4.setText("Tunjangan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, -1, -1));
        getContentPane().add(txt_kode_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 16, 155, -1));
        getContentPane().add(txt_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 54, 155, -1));
        getContentPane().add(txt_gaji_pokok, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 92, 155, -1));
        getContentPane().add(txt_tunjangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 130, 155, -1));

        btn_simpan.setIcon(new javax.swing.ImageIcon("D:\\KUMPULAN TUGAS KULIAH\\TUGAS KULIAH SEMESTER 3\\Pemrograman Berbasis Objek\\gambar pbo\\SAVE.png")); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btn_ubah.setIcon(new javax.swing.ImageIcon("D:\\KUMPULAN TUGAS KULIAH\\TUGAS KULIAH SEMESTER 3\\Pemrograman Berbasis Objek\\gambar pbo\\CANCEL.png")); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 110, 40));

        btn_hapus.setIcon(new javax.swing.ImageIcon("D:\\KUMPULAN TUGAS KULIAH\\TUGAS KULIAH SEMESTER 3\\Pemrograman Berbasis Objek\\gambar pbo\\delete.png")); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Jabatan", "Jabatan", "Gaji Pokok", "Tunjangan"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 440, 97));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     interface_jabatan jabatanService;
    
    private void awal() 
    {
        txt_kode_jabatan.setText(null);
        txt_jabatan.setText(null);
        txt_gaji_pokok.setText(null);
        txt_tunjangan.setText(null);
        try
        {
            List<model.model_jabatan> data = jabatanService.tampil();
            DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
            table.setRowCount(0);
            for (model.model_jabatan row : data)
            {
                table.addRow(new Object[] { row.getKode_jabatan(), row.getJabatan(), row.getGaji_pokok(), row.getTunjangan() });
            }
            jTable1.setModel(table);
        } 
        catch(SQLException e)
        {
            System.out.println("Terjadi kesalahan pada : "+ e);
        }

    }
    
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
       try
       {
           model.model_jabatan data = new model_jabatan();
           data.setKode_jabatan(txt_kode_jabatan.getText());
           data.setJabatan(txt_jabatan.getText());
           data.setGaji_pokok(Integer.parseInt(txt_gaji_pokok.getText()));
           data.setTunjangan(Integer.parseInt(txt_tunjangan.getText()));
           jabatanService.tambah(data);
           JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
           this.awal();
       }
       catch(SQLException e)
        {
            System.out.println("Terjadi kesalahan pada : "+ e);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        try
       {
           model.model_jabatan data = new model_jabatan();
           data.setKode_jabatan(txt_kode_jabatan.getText());
           data.setJabatan(txt_jabatan.getText());
           data.setGaji_pokok(Integer.parseInt(txt_gaji_pokok.getText()));
           data.setTunjangan(Integer.parseInt(txt_tunjangan.getText()));
           jabatanService.ubah(data);
           JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
           this.awal();
       }
       catch(SQLException e)
        {
            System.out.println("Terjadi kesalahan pada : "+ e);
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try
        {
            int row = jTable1.getSelectedRow(); // mendapatkan index dari baris yang di click
            model.model_jabatan data = new model_jabatan();
            data.setKode_jabatan(jTable1.getValueAt(row, 0).toString());
            jabatanService.hapus(data);
        
            //tampil pesan
            JOptionPane.showMessageDialog(this,"Data berhasil dihapus!");
            this.awal();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fungsi tambah : "+e.toString());
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow(); // mendapatkan index dari baris yang di click
        txt_kode_jabatan.setText(jTable1.getValueAt(row, 0).toString());  //menamilkan data pada baris ke row dan column ke 0
        txt_jabatan.setText(jTable1.getValueAt(row,1).toString());
        txt_gaji_pokok.setText(jTable1.getValueAt(row,2).toString());
          txt_tunjangan.setText(jTable1.getValueAt(row,3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_jabatan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_gaji_pokok;
    private javax.swing.JTextField txt_jabatan;
    private javax.swing.JTextField txt_kode_jabatan;
    private javax.swing.JTextField txt_tunjangan;
    // End of variables declaration//GEN-END:variables
}
