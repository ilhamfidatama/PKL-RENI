/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Config.DBConnection;
import Config.Tengah;
import java.awt.Color;
/**
 *
 * @author windows 7
 */
public class D_Siswa extends javax.swing.JFrame {

    /**
     * Creates new form D_Siswa
     */
    public D_Siswa() {
        initComponents();
        cbkelas();
        TampilData();
        setLocationRelativeTo(this);
        txtkelas.setVisible(true);
        //tampilmata_kuliah("SELECT * FROM p_siswa");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void TampilData() {
        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Absen");
        model.addColumn("NIS");
        model.addColumn("Nama Siswa");
        model.addColumn("Kelas");
        tblmahasiswa.setModel(model);

        //menampilkan data database kedalam tabel
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            ResultSet data = stat.executeQuery("SELECT * FROM p_siswa order by no_abs asc");
            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("no_abs"),
                    data.getString("nis"),
                    data.getString("nama"),
                    data.getString("s_kelas")
                });
                tblmahasiswa.setModel(model);
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }
    
    private void cbkelas() {
        cbkelas.removeAllItems();
        cbkelas.addItem("Pilih Kelas");
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

    public void cari_kelas() {
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            String sql_t = "select id_kelas from p_kelas where nama_kelas ='" +  cbkelas.getSelectedItem() + "'";
            ResultSet rs = stat.executeQuery(sql_t);                              // yang anda ingin kan

            while (rs.next()) {
                this.txtkelas.setText(rs.getString("id_kelas"));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmahasiswa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtkelas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbkelas = new javax.swing.JComboBox<>();
        txt_abs = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("OCR A Extended", 0, 14), new java.awt.Color(57, 68, 106))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel4.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 22));

        bubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/update2.png"))); // NOI18N
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });
        jPanel4.add(bubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 100, 22));

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search2.png"))); // NOI18N
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel4.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 100, 22));

        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel2.png"))); // NOI18N
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });
        jPanel4.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 100, 22));

        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/delete2.png"))); // NOI18N
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel4.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 100, 22));

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 570, 80));

        tblmahasiswa.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tblmahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO ABSEN", "NIS", "NAMA SISWA", "KELAS"
            }
        ));
        tblmahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmahasiswa);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 630, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukkan Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("OCR A Extended", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("No Absen");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));
        jPanel2.add(txtkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 53, 20));

        jLabel2.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("NIS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        txtnis.setBackground(new Color (0, 0, 0, 0));
        txtnis.setFont(new java.awt.Font("Ebrima", 1, 13)); // NOI18N
        txtnis.setForeground(new java.awt.Color(51, 51, 51));
        txtnis.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txtnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnisActionPerformed(evt);
            }
        });
        jPanel2.add(txtnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 190, 25));

        jLabel3.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nama Siswa");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        txtnama.setBackground(new Color (0, 0, 0, 0));
        txtnama.setFont(new java.awt.Font("Ebrima", 1, 13)); // NOI18N
        txtnama.setForeground(new java.awt.Color(51, 51, 51));
        txtnama.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnama.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 360, 25));

        jLabel4.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Kelas");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        cbkelas.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        cbkelas.setMaximumRowCount(9);
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
        jPanel2.add(cbkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        txt_abs.setBackground(new Color (0, 0, 0, 0));
        txt_abs.setFont(new java.awt.Font("Ebrima", 1, 13)); // NOI18N
        txt_abs.setForeground(new java.awt.Color(51, 51, 51));
        txt_abs.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_abs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.add(txt_abs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 190, 25));

        jPanel10.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 570, 190));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 116, 710, 410));

        jPanel5.setBackground(new java.awt.Color(44, 52, 82));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(44, 52, 82));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(60, 135, 193));
        jLabel8.setFont(new java.awt.Font("Haettenschweiler", 0, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/-school_902262.png"))); // NOI18N
        jLabel8.setText("SMAN 1 BATU LAYAR");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 20, -1, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 70));

        jLabel11.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Logout");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 70));

        jPanel6.setBackground(new java.awt.Color(44, 52, 82));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 536, 950, 30));

        jPanel8.setBackground(new java.awt.Color(0, 0, 17));
        jPanel8.setForeground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dashboard_icon-icons2.png"))); // NOI18N
        jLabel6.setText(" Dashboard");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/w3586376-book-education-learning-teacher_107951.png"))); // NOI18N
        jLabel7.setText(" Data Siswa");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/profesor2.png"))); // NOI18N
        jLabel10.setText(" Data Guru");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/content-window_icon-icons2.png"))); // NOI18N
        jLabel9.setText(" Mata Pelajaran");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/-class_900852.png"))); // NOI18N
        jLabel12.setText(" Data Kelas");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel9.setBackground(new java.awt.Color(17, 17, 40));
        jPanel9.setForeground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 60));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 200, 500));

        jLabel13.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Data Siswa");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 567));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
        String nis = txtnis.getText();
        String nama = txtnama.getText();
        String abs = txt_abs.getText();
        String kelas = (String) cbkelas.getSelectedItem();
        if (txtnis.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong masukan data anda ", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                java.sql.Statement stat = conn.createStatement();
                ResultSet data = stat.executeQuery("SELECT * FROM p_siswa WHERE nis ='" + txtnis.getText() + "'");
                if (data.next()) {
                    JOptionPane.showMessageDialog(null, "Nis telah terdaftar", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
                    txtnis.requestFocus();
                } else {
                    String sql = "INSERT INTO p_siswa (no_abs,nis,nama,s_kelas) VALUES('" + abs + "'"
                    + ",'" + nis + "'"
                    + ",'" + nama + "'"
                    + ",'" + kelas + "')";
                    stat.executeUpdate(sql);
                    txtnis.setText("");
                    txtnama.setText("");
                    cbkelas.setSelectedIndex(-0);
                    txt_abs.setText("");
                    txt_abs.requestFocus();
                    JOptionPane.showMessageDialog(null, "Penyimpanan Berhasil", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
                    TampilData();
                    //tampilmata_kuliah("SELECT * FROM p_siswa");
                }
                stat.close();
            } catch (Exception exc) {
                System.err.println("ERROR:" + exc);
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin mengubah data ini?", "DIALOG CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "update p_siswa set no_abs='" + txt_abs.getText()
            + "',nama='" + txtnama.getText()
            + "',s_kelas='" + cbkelas.getSelectedItem()
            + "'where nis='" + txtnis.getText().trim() + "'";
            if (txtkelas.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Data Masih Kosong!", "UBAH DATA", JOptionPane.WARNING_MESSAGE);
                txt_abs.requestFocus();
            } else {
                try {
                    Statement stat = conn.createStatement();
                    stat.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Berhasil mengubah data", "UBAH DATA", JOptionPane.INFORMATION_MESSAGE);
                    stat.close();
                    txt_abs.requestFocus();
                    TampilData();
                    //tampilmata_kuliah("SELECT * FROM p_siswa");
                } catch (Exception exc) {
                    System.err.println("Error :" + exc);
                }
            }
        }
    }//GEN-LAST:event_bubahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet data = stat.executeQuery("SELECT * FROM p_siswa WHERE " + "nis='" + txtnis.getText() + "'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No Absen");
            model.addColumn("NIS");
            model.addColumn("Nama Siswa");
            model.addColumn("Kelas");
            tblmahasiswa.setModel(model);

            if (data.next()) {
                model.addRow(new Object[]{
                    data.getString("no_abs"),
                    data.getString("nis"),
                    data.getString("nama"),
                    data.getString("s_kelas")
                });
                tblmahasiswa.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
            stat.close();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        txtnis.setText("");
        txtnama.setText("");
        cbkelas.setSelectedIndex(-0);
        txt_abs.setText("");
        txt_abs.requestFocus();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin menghapus data ini?", "KONFIRMASI DIALOG", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            java.sql.Connection conn = new DBConnection().connect();
            String sql = "DELETE FROM p_siswa WHERE nis='" + txtnis.getText().trim() + "'";
            try {
                Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Berhasil menghapus data", "HAPUS DATA", JOptionPane.INFORMATION_MESSAGE);
                stat.close();
                txtnis.setText("");
                txtnama.setText("");
                cbkelas.setSelectedIndex(-0);
                txt_abs.setText("");
                txt_abs.requestFocus();
                TampilData();
                //tampilmata_kuliah("SELECT * FROM p_siswa");
            } catch (SQLException exc) {
                System.err.println(sql);
                System.err.println("ERROR: " + exc);
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void cbkelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkelasItemStateChanged
        // TODO add your handling code here:
        cari_kelas();
    }//GEN-LAST:event_cbkelasItemStateChanged

    private void cbkelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbkelasMouseClicked
        // TODO add your handling code here:
        cari_kelas();
    }//GEN-LAST:event_cbkelasMouseClicked

    private void tblmahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmahasiswaMouseClicked
        int baris = tblmahasiswa.getSelectedRow();
        if (baris != 1) {
            txt_abs.setText(tblmahasiswa.getValueAt(baris, 0).toString());
            txtnis.setText(tblmahasiswa.getValueAt(baris, 1).toString());
            txtnama.setText(tblmahasiswa.getValueAt(baris, 2).toString());
        }
        cbkelas.setSelectedItem(tblmahasiswa.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tblmahasiswaMouseClicked

    private void txtnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnisActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        int selectedoption = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar dari akun?", "KELUAR AKUN",
            JOptionPane.YES_NO_OPTION);
        if (selectedoption == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new AdminData().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        new D_Guru().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        new D_MataPelajaran().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new D_Kelas().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(D_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new D_Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cbkelas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblmahasiswa;
    private javax.swing.JTextField txt_abs;
    private javax.swing.JTextField txtkelas;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    // End of variables declaration//GEN-END:variables
}