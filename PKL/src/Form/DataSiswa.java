package Form;

//import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Config.DBConnection;
import Config.Tengah;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataSiswa extends javax.swing.JFrame {

    public DataSiswa() {
        initComponents();
        //KoneksiDatabase();
        cbkelas();
        TampilData();
        setLocationRelativeTo(this);
        //txtkelas.setText("");
        setLocationRelativeTo(this);
        txtkelas.setVisible(false);
    }
    
    private void cbkelas() {
        cbkelas.removeAllItems();
        cbkelas.addItem("Pilih Kelas:");
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            String sql_tc = "select id_kelas, nama_kelas from p_kelas order by id_kelas asc";
            ResultSet rs = stat.executeQuery(sql_tc);

            while (rs.next()) {
                String nama = rs.getString("nama_kelas");
                cbkelas.addItem(nama);
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cari_cbkelas() {
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            String sql_t = "select id_kelas from p_kelas where nama_kelas='" + cbkelas.getSelectedItem() + "'";
            ResultSet rs = stat.executeQuery(sql_t);                              // yang anda ingin kan

            while (rs.next()) {
                this.txtkelas.setText(rs.getString("nama_kelas"));
            }
            rs.close();
            stat.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsiswa = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbkelas = new javax.swing.JComboBox<>();
        txtkelas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnoabs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 567));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 140));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblsiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "No Absen", "Nis", "Nama", "Kelas"
            }
        ));
        tblsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsiswa);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 250));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 390, 280));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Kelas");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));

        cbkelas.setMaximumRowCount(15);
        cbkelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbkelasItemStateChanged(evt);
            }
        });
        cbkelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbkelasMouseClicked(evt);
            }
        });
        cbkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkelasActionPerformed(evt);
            }
        });
        jPanel4.add(cbkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, 20));
        jPanel4.add(txtkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 60, -1));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("No Absen");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel4.add(txtnoabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 130, -1));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("NIS");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        txtnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnisActionPerformed(evt);
            }
        });
        jPanel4.add(txtnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 250, -1));

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Nama Siswa");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));
        jPanel4.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 250, 20));

        jTabbedPane1.addTab("INPUT DATA SISWA", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 420, 240));
        jTabbedPane1.getAccessibleContext().setAccessibleName("INPUT DATA");

        jPanel3.setBackground(new java.awt.Color(57, 68, 106));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/22250px-Logo_of_Ministry_of_Education_and_Culture_of_Republic_of_Indonesia.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        jLabel7.setBackground(new java.awt.Color(60, 135, 193));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SMA 1 BATU LAYAR");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 630, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logout2.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 90, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 120));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel5.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 22));

        bubah.setText("EDIT");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });
        jPanel5.add(bubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 100, 22));

        bcari.setText("CARI");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel5.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, 22));

        bkeluar.setText("EXIT");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });
        jPanel5.add(bkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 100, 22));

        bbatal.setText("CANCEL");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel5.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 22));

        bhapus.setText("DELETE");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel5.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 100, 22));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 420, 90));

        jPanel6.setBackground(new java.awt.Color(57, 68, 106));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 526, 850, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 567));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        cbkelas.setSelectedIndex(-0);
        txtkelas.setText("");
        txtnoabs.setText("");
        txtnis.setText("");
        txtnama.setText("");
        cbkelas.requestFocus();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
        String kelas = cbkelas.getItemAt(cbkelas.getSelectedIndex()).toString();
        String txtk = txtkelas.getText();
        String noabs = txtnoabs.getText();
        String nis = txtnis.getText();
        String nama = txtnama.getText();

        if (kelas.trim().equals(-0)) {
            JOptionPane.showMessageDialog(null, "Please input your data", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet data = stat.executeQuery("SELECT * FROM p_siswa WHERE no_abs ='" + txtnoabs.getText() + "'");
                if (data.next()) {
                    JOptionPane.showMessageDialog(null, "Absen number already exist!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
                    txtnoabs.requestFocus();
                } else {
                    String sql = "INSERT INTO p_siswa "
                            +"(s_kelas, no_abs, nis, nama) VALUES('" +txtk + "'"
                            + ",'" + noabs + "'"
                            + ",'" + nis + "'"
                            + ",'" + nama + "')";
                    stat.executeUpdate(sql);
                    cbkelas.setSelectedIndex(-0);
                    txtkelas.setText("");
                    txtnoabs.setText("");
                    txtnis.setText("");
                    txtnama.setText("");
                    cbkelas.requestFocus();
                    JOptionPane.showMessageDialog(null, "Save Successful", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
                    TampilData();
                }
                stat.close();
            } catch (Exception exc) {
                System.err.println("Terjadi Kesalahan :" + exc);
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void tblsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsiswaMouseClicked
        int baris = tblsiswa.getSelectedRow();
        if (baris != -1) {
            txtnoabs.setText(tblsiswa.getValueAt(baris, 0).toString());
            txtnis.setText(tblsiswa.getValueAt(baris, 1).toString());
            txtnama.setText(tblsiswa.getValueAt(baris, 2).toString());
        }
        cbkelas.setSelectedItem(tblsiswa.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tblsiswaMouseClicked

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet data = stat.executeQuery("SELECT * FROM p_siswa WHERE " + "no_abs='" + txtnoabs.getText() + "'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Kelas");
            model.addColumn("No Absen");
            model.addColumn("NIS");
            model.addColumn("Nama Siswa");
            tblsiswa.setModel(model);
            if (data.next()) {
                model.addRow(new Object[]{
                    data.getString("s_kelas"),
                    data.getString("no_abs"),
                    data.getString("nis"),
                    data.getString("nama")
                });
                tblsiswa.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            stat.close();
        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan :" + e);
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            java.sql.Connection conn = new DBConnection().connect();
            String sql = "DELETE FROM p_siswa WHERE no_abs='" + txtnoabs.getText().trim() + "'";
            try {
                java.sql.Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                stat.close();
                cbkelas.setSelectedIndex(-0);
                //txtkelas.setText("");
                txtnoabs.setText("");
                txtnama.setText("");
                cbkelas.requestFocus();
                TampilData();
            } catch (SQLException exc) {
                System.err.println(sql);
                System.err.println("Error : " + exc);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin mengubah data ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
        String sql = "update p_siswa set s_kelas='" + cbkelas.getSelectedItem()
                + "',no_abs='" + txtnoabs.getText()
                + "',nis='" + txtnis.getText()
                + "',nama='" + txtnama.getText()
                + "'where no_abs='" + txtnoabs.getText().trim() + "'";
        if (cbkelas.getSelectedItem().equals(-0)) {
            JOptionPane.showMessageDialog(null, "Data Masih Kosong!", "Ubah Data", JOptionPane.WARNING_MESSAGE);
            cbkelas.requestFocus();
        } else {
            try {
                java.sql.Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah", "Ubah Data", JOptionPane.INFORMATION_MESSAGE);
                stat.close();
                cbkelas.requestFocus();
                TampilData();
            } catch (Exception exc) {
                System.err.println("Error :" + exc);
            }
          }
        }
    }//GEN-LAST:event_bubahActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Keluar?", "Terima Kasih Atas Perhatiannya", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
           new Login().setVisible(true);
           dispose();
        }
    }//GEN-LAST:event_bkeluarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        JFrame form = new JFrame();
        form.setSize(400, 400);
        new Tengah(this);
    }//GEN-LAST:event_formWindowActivated

    private void cbkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkelasActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        int selectedoption = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Close Application",
            JOptionPane.YES_NO_OPTION);
        if (selectedoption == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void cbkelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkelasItemStateChanged
        // TODO add your handling code here:
        cari_cbkelas();
    }//GEN-LAST:event_cbkelasItemStateChanged

    private void cbkelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbkelasMouseClicked
        // TODO add your handling code here:
        cari_cbkelas();
    }//GEN-LAST:event_cbkelasMouseClicked

    private void txtnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnisActionPerformed

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
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //JOptionPane.showMessageDialog(null, "Selamat Datang");
                new DataSiswa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbkelas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblsiswa;
    private javax.swing.JTextField txtkelas;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txtnoabs;
    // End of variables declaration//GEN-END:variables

    private void TampilData() {
        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Absen");
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Kelas");
        tblsiswa.setModel(model);

        //menampilkan data database kedalam tabel
        try {
            //int i = 1;
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            ResultSet data = stat.executeQuery("SELECT * FROM p_siswa, p_kelas WHERE p_siswa.s_kelas=p_kelas.id_kelas");
            while (data.next()) {
                model.addRow(new Object[]{
                    //("" + i++),
                    data.getString("no_abs"),
                    data.getString("nis"),
                    data.getString("nama"),
                    data.getString("s_kelas")
                });
                tblsiswa.setModel(model);
            }
        } catch (Exception e) {
            System.err.println("Terjadi Kesalahan :" + e);
        }
    }
}
