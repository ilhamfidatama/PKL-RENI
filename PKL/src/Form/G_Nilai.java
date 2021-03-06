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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author windows 7
 */
public class G_Nilai extends javax.swing.JFrame {
    JasperReport JasRep;
    JasperPrint JasPri;
    HashMap param = new HashMap();
    JasperDesign JasDes;
    java.sql.Connection conn = new DBConnection().connect();
    
    private final ArrayList<String> dataNisSiswa = new ArrayList<>();
    private int indexCB_Nis; //menampung data hasil pemilihan dari combo box
    
    private final ArrayList<String> dataKodeGuru = new ArrayList<>();
    private int indexCB_KodeGuru; //menampung data hasil pemilihan dari combo box
    
    private final ArrayList<String> dataKodeKelas = new ArrayList<>();
    private int indexCB_KodeKelas; //menampung data hasil pemilihan dari combo box
    
    private final ArrayList<String> dataKodeMapel = new ArrayList<>();
    private int indexCB_KodeMapel; //menampung data hasil pemilihan dari combo box
    
    private float pr = 0;
    private float persentasePR = 0;
    private float totalPR = 0;
    private float ulanganHarian = 0;
    private float persentaseUlanganHarian = 0;
    private float totalUlanganHarian = 0;
    private float nilai_uts = 0;
    private float persentaseUTS = 0;
    private float totalUTS = 0;
    private float nilai_uas = 0;
    private float persentaseUAS = 0;
    private float totalUAS = 0;
    
    /**
     * Creates new form G_Raport
     */
    public G_Nilai() {
        initComponents();
        cbnis();
        cbguru();
        cbmapel();
        cbkelas();
//        totalnilai();
        txtnama.setEnabled(false);
        tugas.setEnabled(false);
        uh.setEnabled(false);
        uts.setEnabled(false);
        uas.setEnabled(false);
        txt_total.setEnabled(false);
        kosong();
    }
    
    private void kosong() {
        cbnis.setSelectedIndex(-0);
        cbkdg.setSelectedIndex(-0);
        cbkelas.setSelectedIndex(-0);
        cbmp.setSelectedIndex(-0);
        txt_tugas.setText("");
        txt_ptugas.setText("");
        tugas.setText("");
        txt_uh.setText("");
        txt_puh.setText("");
        uh.setText("");
        txt_uts.setText("");
        txt_puts.setText("");
        uts.setText("");
        txt_uas.setText("");
        txt_puas.setText("");
        uas.setText("");
        txtnama.setText("");   
    }
    
    private void cbnis() {
        cbnis.removeAllItems();
        cbnis.addItem("Pilih NIS");
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            String sql_tc = "select nis, nama from p_siswa";
            ResultSet rs = stat.executeQuery(sql_tc);
            
            String nama, nis;
            while (rs.next()) {
                nama = rs.getString("nama");
                nis = rs.getString("nis");
                cbnis.addItem(nama);
                dataNisSiswa.add(nis);
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cbguru() {
        cbkdg.removeAllItems();
        cbkdg.addItem("Pilih Nama Guru");
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            String sql_tc = "select kd_guru, nama_guru from p_guru ";
            ResultSet rs = stat.executeQuery(sql_tc);
            
            String nama, kode;
            while (rs.next()) {
                nama = rs.getString("nama_guru");
                kode = rs.getString("kd_guru");
                cbkdg.addItem(nama);
                dataKodeGuru.add(kode);
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cbmapel() {
        cbmp.removeAllItems();
        cbmp.addItem("Pilih Mata Pelajaran");
        try {
            java.sql.Connection conn = new DBConnection().connect();
            java.sql.Statement stat = conn.createStatement();
            String sql_tc = "select kd_mapel, nama_mapel from p_mapel";
            ResultSet rs = stat.executeQuery(sql_tc);
            
            String nama, kode;
            while (rs.next()) {
                nama = rs.getString("nama_mapel");
                kode = rs.getString("kd_mapel");
                cbmp.addItem(nama);
                dataKodeMapel.add(kode);
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            
            String nama, kode;
            while (rs.next()) {
                nama = rs.getString("nama_kelas");
                kode = rs.getString("id_kelas");
                cbkelas.addItem(nama);
                dataKodeKelas.add(kode);
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private float konversiNilai(String nilai){
        float konversi = 0;
        if (!nilai.isEmpty()) { //kondisi jika string nilai tidak kosong
            konversi = Float.parseFloat(nilai);
        }
        return konversi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbkelas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbmp = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbkdg = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_tugas = new javax.swing.JTextField();
        txt_uh = new javax.swing.JTextField();
        txt_uts = new javax.swing.JTextField();
        txt_uas = new javax.swing.JTextField();
        txt_ptugas = new javax.swing.JTextField();
        txt_puh = new javax.swing.JTextField();
        txt_puts = new javax.swing.JTextField();
        txt_puas = new javax.swing.JTextField();
        tugas = new javax.swing.JTextField();
        uh = new javax.swing.JTextField();
        uts = new javax.swing.JTextField();
        uas = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bbatal = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbnis = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukkan Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("OCR A Extended", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("NIS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel3.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nama Siswa");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, 20));

        txtnama.setBackground(new Color (0, 0, 0, 0));
        txtnama.setFont(new java.awt.Font("Ebrima", 1, 13)); // NOI18N
        txtnama.setForeground(new java.awt.Color(51, 51, 51));
        txtnama.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnama.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 190, 25));

        jLabel4.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Kelas");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        cbkelas.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        cbkelas.setMaximumRowCount(9);
        cbkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkelasActionPerformed(evt);
            }
        });
        jPanel2.add(cbkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 150, 30));

        jLabel9.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Mata Pelajaran");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, 20));

        cbmp.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        cbmp.setMaximumRowCount(9);
        cbmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmpActionPerformed(evt);
            }
        });
        jPanel2.add(cbmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 160, 30));

        jLabel14.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Kode Guru");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        cbkdg.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        cbkdg.setMaximumRowCount(9);
        cbkdg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkdgActionPerformed(evt);
            }
        });
        jPanel2.add(cbkdg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, 30));

        jLabel1.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Tugas");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Ulangan Harian");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel16.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Ujian Tengah Semester");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Ujian Akhir Semester");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("TOTAL");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        txt_tugas.setText("0");
        txt_tugas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tugasCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_tugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 40, 30));

        txt_uh.setText("0");
        txt_uh.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_uhCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_uh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 40, 30));

        txt_uts.setText("0");
        txt_uts.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_utsCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_uts, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 40, 30));

        txt_uas.setText("0");
        txt_uas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_uasCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_uas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 40, 30));

        txt_ptugas.setText("0");
        txt_ptugas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_ptugasCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_ptugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 40, 30));

        txt_puh.setText("0");
        txt_puh.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_puhCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_puh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 40, 30));

        txt_puts.setText("0");
        txt_puts.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_putsCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_puts, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 40, 30));

        txt_puas.setText("0");
        txt_puas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_puasCaretUpdate(evt);
            }
        });
        jPanel2.add(txt_puas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 40, 30));

        tugas.setEditable(false);
        tugas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(tugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 60, 30));

        uh.setEditable(false);
        uh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(uh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 60, 30));

        uts.setEditable(false);
        uts.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(uts, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 60, 30));

        uas.setEditable(false);
        uas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(uas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 60, 30));

        txt_total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 80, 40));

        jLabel19.setText("X");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 185, -1, -1));

        jLabel20.setText("X");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 225, -1, -1));

        jLabel21.setText("X");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 265, -1, -1));

        jLabel22.setText("X");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 305, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("OCR A Extended", 0, 14), new java.awt.Color(57, 68, 106))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancel2.png"))); // NOI18N
        jPanel4.add(bbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 100, 22));

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel4.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 22));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 120, 110));

        cbnis.setFont(new java.awt.Font("Ebrima", 0, 13)); // NOI18N
        cbnis.setMaximumRowCount(9);
        cbnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnisActionPerformed(evt);
            }
        });
        jPanel2.add(cbnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 690, 390));

        jPanel6.setBackground(new java.awt.Color(44, 52, 82));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 710, 30));

        jLabel13.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Nilai Siswa");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 40));

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
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kisspng-computer-icons-checkbox-checklist-5af23e12184338.png"))); // NOI18N
        jLabel10.setText(" Data Nilai");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/e6bd17c5ed435d466c3c42071183f6d32.png"))); // NOI18N
        jLabel12.setText(" Pengaturan");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(17, 17, 40));
        jPanel9.setForeground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        new D_Guru().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new D_Kelas().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        //java.sql.Connection conn = new DBConnection().connect();
        String nisSiswa = dataNisSiswa.get(indexCB_Nis-1);
        String namaSiswa = cbnis.getItemAt(indexCB_Nis);
        String kdGuru = dataKodeGuru.get(indexCB_KodeGuru-1);
        String kdKelas = dataKodeKelas.get(indexCB_KodeKelas-1);
        String kdMapel = dataKodeMapel.get(indexCB_KodeMapel-1);
        
        float totalNilai = totalPR+totalUlanganHarian+totalUTS+totalUAS;

        if (nisSiswa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tolong masukan data anda ", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                String sql = "INSERT INTO `p_nilai`(`n_nis`, `n_nama_siswa`, `n_guru`, `n_mapel`, `n_kelas`, `n_tugas`, `n_kuis`, `n_uts`, `n_uas`, `n_total`) VALUES ('"+nisSiswa+"','"+namaSiswa+"','"+kdGuru+"','"+kdMapel+"','"+kdKelas+"',"+totalPR+","+totalUlanganHarian+","+totalUTS+","+totalUAS+","+totalNilai+")";
                System.out.println(sql);
                java.sql.Statement stat = conn.createStatement();
                stat.executeUpdate(sql);
                System.out.println("berhasil");
            } catch (SQLException ex) {
                System.err.println("ERROR:" + ex);
            }
        }
//        String nis = txtnis.getText();
//        if (txtnis.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Tolong masukan data anda ", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
//        } else {
//            try {
//                java.sql.Statement stat = conn.createStatement();
//                ResultSet data = stat.executeQuery("SELECT * FROM p_nilai WHERE nis ='" + txtnis.getText() + "'");
//                if (data.next()) {
//                    JOptionPane.showMessageDialog(null, "Nis sudah ada", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
//                    txtnis.requestFocus();
//                } else {
//                    String sql = "INSERT INTO p_nilai (n_nis,n_nama_siswa,n_guru, n_mapel,n_kelas) VALUES('" + cmbnis + "'"
//                    + ",'" + nama + "'"
//                    + ",'" + guru + "'"
//                    + ",'" + mapel + "'"
//                    + ",'" + kelas + "')";
//                    stat.executeUpdate(sql);
//                    cbnis.setSelectedIndex(-0);
//                    cbkdg.setSelectedIndex(-0);
//                    cbmp.setSelectedIndex(-0);
//                    cbkelas.setSelectedIndex(-0);
//                    txtnama.setText("");
//                    cbnis.requestFocus();
//                    JOptionPane.showMessageDialog(null, "Penyimpanan Berhasil", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
//                    //TampilData();
//                    //tampilmata_kuliah("SELECT * FROM p_siswa");
//                }
//                stat.close();
//            } catch (Exception exc) {
//                System.err.println("ERROR:" + exc);
//            }
//        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            File report = new File("report2.jrxml");
            JasDes = JRXmlLoader.load(report);
            param.clear();
            JasRep = JasperCompileManager.compileReport(JasDes);
            JasPri = JasperFillManager.fillReport(JasRep, param, conn);
            JasperViewer.viewReport(JasPri, false);
            
        } catch(Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnisActionPerformed
        indexCB_Nis = cbnis.getSelectedIndex();
    }//GEN-LAST:event_cbnisActionPerformed

    private void cbkdgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkdgActionPerformed
        indexCB_KodeGuru = cbkdg.getSelectedIndex();
    }//GEN-LAST:event_cbkdgActionPerformed

    private void cbkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkelasActionPerformed
        indexCB_KodeKelas = cbkelas.getSelectedIndex();
    }//GEN-LAST:event_cbkelasActionPerformed

    private void cbmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmpActionPerformed
        indexCB_KodeMapel = cbmp.getSelectedIndex();
    }//GEN-LAST:event_cbmpActionPerformed

    private void txt_ptugasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_ptugasCaretUpdate
        persentasePR = konversiNilai(txt_ptugas.getText());
        
        totalPR = pr*(persentasePR/100);
        tugas.setText(String.valueOf(totalPR));
    }//GEN-LAST:event_txt_ptugasCaretUpdate

    private void txt_uhCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_uhCaretUpdate
        ulanganHarian = konversiNilai(txt_uh.getText());
        
        totalUlanganHarian = ulanganHarian*(persentaseUlanganHarian/100);
        uh.setText(String.valueOf(totalUlanganHarian));
    }//GEN-LAST:event_txt_uhCaretUpdate

    private void txt_puhCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_puhCaretUpdate
        persentaseUlanganHarian = konversiNilai(txt_puh.getText());
        
        totalUlanganHarian = ulanganHarian*(persentaseUlanganHarian/100);
        uh.setText(String.valueOf(totalUlanganHarian));
    }//GEN-LAST:event_txt_puhCaretUpdate

    private void txt_utsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_utsCaretUpdate
        nilai_uts = konversiNilai(txt_uts.getText());
        
        totalUTS = nilai_uts*(persentaseUTS/100);
        uts.setText(String.valueOf(totalUTS));
    }//GEN-LAST:event_txt_utsCaretUpdate

    private void txt_putsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_putsCaretUpdate
        persentaseUTS = konversiNilai(txt_puts.getText());
        
        totalUTS = nilai_uts*(persentaseUTS/100);
        uts.setText(String.valueOf(totalUTS));
    }//GEN-LAST:event_txt_putsCaretUpdate

    private void txt_uasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_uasCaretUpdate
        nilai_uas = konversiNilai(txt_uas.getText());
        
        totalUAS = nilai_uas*(persentaseUAS/100);
        uas.setText(String.valueOf(totalUAS));
    }//GEN-LAST:event_txt_uasCaretUpdate

    private void txt_puasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_puasCaretUpdate
        persentaseUAS = konversiNilai(txt_puas.getText());
        
        totalUAS = nilai_uas*(persentaseUAS/100);
        uas.setText(String.valueOf(totalUAS));
    }//GEN-LAST:event_txt_puasCaretUpdate

    private void txt_tugasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tugasCaretUpdate
        pr = konversiNilai(txt_tugas.getText());

        totalPR = pr*(persentasePR/100);
        tugas.setText(String.valueOf(totalPR));
    }//GEN-LAST:event_txt_tugasCaretUpdate

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
            java.util.logging.Logger.getLogger(G_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(G_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(G_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(G_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new G_Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bsimpan;
    private javax.swing.JComboBox<String> cbkdg;
    private javax.swing.JComboBox<String> cbkelas;
    private javax.swing.JComboBox<String> cbmp;
    private javax.swing.JComboBox<String> cbnis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField tugas;
    private javax.swing.JTextField txt_ptugas;
    private javax.swing.JTextField txt_puas;
    private javax.swing.JTextField txt_puh;
    private javax.swing.JTextField txt_puts;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_tugas;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uh;
    private javax.swing.JTextField txt_uts;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField uas;
    private javax.swing.JTextField uh;
    private javax.swing.JTextField uts;
    // End of variables declaration//GEN-END:variables
}
