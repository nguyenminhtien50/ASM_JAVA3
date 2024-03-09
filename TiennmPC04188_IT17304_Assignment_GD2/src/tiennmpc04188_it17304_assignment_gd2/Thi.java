/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiennmpc04188_it17304_assignment_gd2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Thi extends javax.swing.JFrame {

     Connection ketNoi;
    DefaultTableModel model;
    String duongDan;
    public Thi() {
        initComponents();
             TenCot();
         try {
             LoadDuLieu();
         } catch (SQLException ex) {
             Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void TenCot() {
        model = new DefaultTableModel();
        model.addColumn("Tên sách");
        model.addColumn("Số Lượng");
        model.addColumn("Giá bán");
        model.addColumn("Thành tiền");
        model.addColumn("Đường dẫn");
        tblSach.setModel(model);
    }

    public void KetNoiCSDL() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName = ThiThu";
            String user = "sa";
            String pass = "1234";
            ketNoi = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi kết nối CSDL");
        }

    }

    public void LoadDuLieu() throws SQLException {
        model.setRowCount(0);// xóa dữ liệu cảu bảng
        KetNoiCSDL();
        String sql = "SELECT * FROM QuanLySach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            String tenSach = ketQua.getString(1);
            int soLuong = ketQua.getInt(2);
            int giaBan = ketQua.getInt(3);
            int thanhTien = ketQua.getInt(4);
            String Hinh = ketQua.getString(5);

            model.addRow(new Object[]{tenSach, soLuong, giaBan, thanhTien, Hinh});
        }
        ketNoi.close();
    }
    
        public void ChonHinh() {
        JFileChooser chooser = new JFileChooser("D:\\Java_3\\BaiTap\\TiennmPC04188_IT17304_Assignment_GD2\\src\\Images");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        if (f != null) {
            duongDan = f.getAbsolutePath(); //Đường dẫn tuyệt đối
            ImageIcon hinhanh = new ImageIcon(new ImageIcon(duongDan).
                    getImage().getScaledInstance(lblHinhAnh.getWidth(),
                            lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
            lblHinhAnh.setIcon(hinhanh);
            txtDuongDan.setText(duongDan);
        }
    
    }

    public void LoadHinh() {
        try {
            KetNoiCSDL();
            String sql = "SELECT HinhAnh FROM QuanLySach where HinhAnh = ?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setString(1, txtDuongDan.getText());
            ResultSet ketQua = cauLenh.executeQuery();
            if (ketQua.next()) {
                String duongDan = ketQua.getString(1);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(duongDan).
                        getImage().getScaledInstance(lblHinhAnh.getWidth(),
                                lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));

                lblHinhAnh.setIcon(imageIcon);
                txtDuongDan.setText(this.duongDan);
            }
        } catch (Exception ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public boolean KiemTraTrungMa() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT tenSach FROM QuanLySach WHERE tenSach=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTenSach.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtTenSach.getText().equalsIgnoreCase(ketQua.getString(1)));
            return true;
        }
        ketNoi.close();
        return false;
    }
            public void them() throws SQLException {
        KetNoiCSDL();
        String sql = "INSERT INTO QuanLySach VALUES(?,?,?,?,?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTenSach.getText());
        cauLenh.setInt(2, Integer.parseInt(txtSoLuong.getText()));
        cauLenh.setInt(3, Integer.parseInt(txtGiaBan.getText()));
        cauLenh.setInt(4, Integer.parseInt(txtThanhTien.getText()));
        cauLenh.setString(5, txtDuongDan.getText());
        cauLenh.executeUpdate();

        ketNoi.close();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDuongDan = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSach);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 490, 854, 146));

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 417, 70, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 70, -1));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 417, -1, -1));

        btnSapXep.setText("Sắp xếp");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });
        getContentPane().add(btnSapXep, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 417, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 117, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("QUẢN LÝ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 21, -1, -1));

        jLabel2.setText("Tên sách");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 124, -1, -1));
        getContentPane().add(txtDuongDan, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 355, 221, -1));
        getContentPane().add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 121, 293, -1));

        jLabel3.setText("Số Lượng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 202, -1, -1));

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });
        getContentPane().add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 199, 291, -1));

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });
        txtGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyReleased(evt);
            }
        });
        getContentPane().add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 277, 291, -1));

        jLabel4.setText("Giá bán");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 280, -1, -1));
        getContentPane().add(txtThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 355, 291, -1));

        jLabel5.setText("Thành tiền");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 358, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        int viTri = tblSach.getSelectedRow();
        txtTenSach.setText(tblSach.getValueAt(viTri, 0).toString());
        txtSoLuong.setText(tblSach.getValueAt(viTri, 1).toString());
        txtGiaBan.setText(tblSach.getValueAt(viTri, 2).toString());
        txtThanhTien.setText(tblSach.getValueAt(viTri, 3).toString());
        txtDuongDan.setText(tblSach.getValueAt(viTri, 4).toString());
//        lblHinhAnh.setText(tblSach.getValueAt(viTri, 4).toString());
        LoadHinh();
    }//GEN-LAST:event_tblSachMouseClicked

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
         try {
             xoaTrang();
             LoadDuLieu();
         } catch (SQLException ex) {
             Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (txtTenSach.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Tên sách không được bỏ trống");
            } else if (txtSoLuong.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Số lượng không được để trống");
            } else if (txtGiaBan.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Giá bán không được để trống");
            } else if (txtThanhTien.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Thành tiền không được để trống");
            } else {
                if (KiemTraTrungMa() == false) {
                    them();
                    LoadDuLieu();
                } else {
                    JOptionPane.showMessageDialog(this, "Tên sách đã tồn tại");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed
    public void capNhat() throws SQLException {
        int viTri = tblSach.getSelectedRow();
        if (viTri >= 0) {
            KetNoiCSDL();
            String sql = "UPDATE QuanLySach set soLuong = ?, giaBan = ?, ThanhTien = ?, HinhAnh = ? WHERE TenSach = ?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setInt(1, Integer.parseInt(txtSoLuong.getText()));
            cauLenh.setInt(2, Integer.parseInt(txtGiaBan.getText()));
            cauLenh.setInt(3, Integer.parseInt(txtThanhTien.getText()));
            cauLenh.setString(4, txtDuongDan.getText());
            cauLenh.setString(5, txtTenSach.getText());
            cauLenh.executeUpdate();
            ketNoi.close();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng");
        }
    }

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            capNhat();
            LoadDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed
    public void xoa() throws SQLException {
        KetNoiCSDL();
        String sql = "DELETE QuanLySach WHERE tenSach = ?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTenSach.getText());
        int ketQua = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không", "Xóa sach", JOptionPane.YES_NO_OPTION);
        if (ketQua == JOptionPane.YES_OPTION) {
            cauLenh.executeUpdate();
            xoaTrang();
            ketNoi.close();
        }

    }
        public void xoaTrang() {
        txtTenSach.setText("");
        txtSoLuong.setText("");
        txtGiaBan.setText("");
        txtThanhTien.setText("");
        txtDuongDan.setText("");
        lblHinhAnh.setText("");
        txtTenSach.requestFocus();
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            xoa();
            LoadDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    public boolean timKiem() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT * FROM QuanLySach WHERE tenSach = ?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTenSach.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtTenSach.getText().equalsIgnoreCase(ketQua.getString(1)));
            {
                txtSoLuong.setText(ketQua.getInt(2) + "");
                txtGiaBan.setText(ketQua.getInt(3) + "");
                txtThanhTien.setText(ketQua.getInt(4) + "");               
            }
            return true;
        }
        ketNoi.close();
        return false;
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        try {
            if (timKiem() == true) {
                timKiem();
            } else {
                JOptionPane.showMessageDialog(this, "Tên sách không tồn tại");
            }

        } catch (SQLException ex) {
             Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed
    public void SapXep_DatBan() throws SQLException {
        KetNoiCSDL();
        model.setRowCount(0);
        String sql = "select * from QuanLySach order by GiaBan asc";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            String tenSach = ketQua.getString(1);
            int soLuong = ketQua.getInt(2);
            int giaTien = ketQua.getInt(3);
            int thanhTien = ketQua.getInt(4);
            String hinhAnh = ketQua.getString(5);
            model.addRow(new Object[]{tenSach, soLuong, giaTien, thanhTien, hinhAnh});
        }
        ketNoi.close();

    }
    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
         try {
             SapXep_DatBan();
         } catch (SQLException ex) {
             Logger.getLogger(Thi.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        ChonHinh();
    }//GEN-LAST:event_lblHinhAnhMouseClicked
    public void TinhThanhTien(){
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        int DonGia = Integer.parseInt(txtGiaBan.getText());        
        int thanhTien = soLuong * DonGia;
        txtThanhTien.setText(String.valueOf(thanhTien));
        txtThanhTien.setHorizontalAlignment(JTextField.RIGHT);
        txtThanhTien.setBackground(Color.orange);
        txtThanhTien.setForeground(Color.white);
        txtThanhTien.setFont(new Font("Tahoma", Font.BOLD,15));
    }
    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
           if(!txtSoLuong.getText().equals("") && !txtGiaBan.getText().equals("")){
        TinhThanhTien();
        }
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
         if(!txtSoLuong.getText().equals("") && !txtGiaBan.getText().equals("")){
        TinhThanhTien();
        }
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
         if(!txtSoLuong.getText().equals("") && !txtGiaBan.getText().equals("")){
        TinhThanhTien();
        }
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void txtGiaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyReleased
        if(!txtSoLuong.getText().equals("") && !txtGiaBan.getText().equals("")){
        TinhThanhTien();
        }
    }//GEN-LAST:event_txtGiaBanKeyReleased

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
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtDuongDan;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
