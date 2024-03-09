/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiennmpc04188_it17304_assignment_gd2;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyGia extends javax.swing.JFrame {

    String user;
    String pass;
    DefaultTableModel model;
    Connection ketNoi;
    String duonDan = null;
    DefaultComboBoxModel model1;

    public QuanLyGia() {
        initComponents();
        user = DangNhap.tenDangNhap;
        pass = DangNhap.matKhau;
        lblChao.setText("Chào: " + user);

        TenCotGia();
        try {

            LoarDuLieuGia();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
         txtMaSach.disable();
         txtTenSach.disable();
         txtGiaNhap.disable();

    }

    public void KetNoiCSDL() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName = Assignment_Java3"; //localhost là cục bộ không cần mạng. them địa chỉ ip là 129.123.2:1433
            String user = "sa";
            String pass = "1234";
            ketNoi = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi kết nối CSDL");
        }
    }

    public void LoarDuLieuGia() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select * from quanlygia ";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
//            String theLoai = ketQua.getString(3);
            String tenSach = ketQua.getString(2);
            int giaNhap = ketQua.getInt(3);
            int giaBan = ketQua.getInt(4);

//            float giaBan = ketQua.getFloat(5);
            model.addRow(new Object[]{maSach, tenSach, giaNhap, giaBan});
//            model.addRow(new Object[]{maSach, tenSach, theLoai, giaNhap, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }

    public void TenCotGia() {
        model = new DefaultTableModel();
        model.addColumn("MÃ SÁCH");
        model.addColumn("TÊN SÁCH");
        model.addColumn("GIÁ NHẬP");
        model.addColumn("GIÁ BÁN");
        tblQuanLyGia.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuanLyGia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanLyGia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnSXMaSach = new javax.swing.JButton();
        btnSXGiaBan = new javax.swing.JButton();
        btnSXTenSach = new javax.swing.JButton();
        btnSXGiaNhap = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        btnChonSachThemGia = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        pnl1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblChao = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        lblQuanLySach = new javax.swing.JLabel();
        lblQuanLyGia = new javax.swing.JLabel();
        lblQuanLyDonGia = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlQuanLyGia.setBackground(new java.awt.Color(102, 102, 255));
        pnlQuanLyGia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblQuanLyGia.setBackground(new java.awt.Color(0, 255, 204));
        tblQuanLyGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MÃ SÁCH", "TÊN SÁCH", "GIÁ NHẬP", "GIÁ BÁN"
            }
        ));
        tblQuanLyGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyGiaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanLyGia);

        pnlQuanLyGia.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 760, 230));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("QUẢN LÝ GIÁ");
        pnlQuanLyGia.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 255, 204));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(102, 255, 204));
        jLabel11.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel11.setText("Mã Sách:");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });
        jPanel7.add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 247, -1));

        jLabel24.setBackground(new java.awt.Color(102, 255, 204));
        jLabel24.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel24.setText("Tên Sách:");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel7.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 247, -1));

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel7.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 247, -1));

        txtGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel7.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 247, -1));

        jLabel30.setBackground(new java.awt.Color(102, 255, 204));
        jLabel30.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel30.setText("Giá Bán:");
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel38.setBackground(new java.awt.Color(102, 255, 204));
        jLabel38.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel38.setText("Giá Nhập:");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        pnlQuanLyGia.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 400, 180));

        jPanel9.setBackground(new java.awt.Color(0, 255, 204));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jButton14.setText("Xóa");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Accept.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        jButton18.setText("Làm Mới");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        jButton19.setText("Thoát");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCapNhat)
                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton18))
                .addGap(31, 31, 31)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(jButton19))
                .addContainerGap())
        );

        pnlQuanLyGia.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 330, 170));

        jPanel11.setBackground(new java.awt.Color(0, 255, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(25, 25));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        jPanel11.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 520, 28));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jButton26.setText("Tìm Kiếm");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 28));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Tên Sách:");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        pnlQuanLyGia.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 760, 60));

        jPanel14.setBackground(new java.awt.Color(0, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp Xếp Theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSXMaSach.setText("Mã Sách");
        btnSXMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXMaSachActionPerformed(evt);
            }
        });
        jPanel14.add(btnSXMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnSXGiaBan.setText("Giá  Bán");
        btnSXGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXGiaBanActionPerformed(evt);
            }
        });
        jPanel14.add(btnSXGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        btnSXTenSach.setText("Tên Sách");
        btnSXTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTenSachActionPerformed(evt);
            }
        });
        jPanel14.add(btnSXTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        btnSXGiaNhap.setText("Giá Nhập");
        btnSXGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXGiaNhapActionPerformed(evt);
            }
        });
        jPanel14.add(btnSXGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        pnlQuanLyGia.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 500, 69));

        jPanel15.setBackground(new java.awt.Color(0, 255, 204));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonSachThemGia.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnChonSachThemGia.setText("Chọn Sách Thêm Giá");
        btnChonSachThemGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSachThemGiaActionPerformed(evt);
            }
        });
        jPanel15.add(btnChonSachThemGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 5, -1, -1));

        jButton35.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton35.setText("Xem Bảng Giá");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 45, 160, -1));

        pnlQuanLyGia.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 240, 80));

        getContentPane().add(pnlQuanLyGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 830, 680));

        pnl1.setBackground(new java.awt.Color(0, 0, 0));
        pnl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Nhà Sách mooi");
        pnl1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.jpg"))); // NOI18N
        pnl1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        lblChao.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        lblChao.setForeground(new java.awt.Color(255, 255, 255));
        lblChao.setText(" ");
        pnl1.add(lblChao, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 240, -1));

        getContentPane().add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 110));

        pnl2.setBackground(new java.awt.Color(255, 153, 153));
        pnl2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblQuanLySach.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblQuanLySach.setText("||Quản Lý Sách");
        lblQuanLySach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLySachMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuanLySachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLySachMouseExited(evt);
            }
        });
        pnl2.add(lblQuanLySach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblQuanLyGia.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblQuanLyGia.setText("||Quản Lý Giá");
        lblQuanLyGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLyGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuanLyGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLyGiaMouseExited(evt);
            }
        });
        pnl2.add(lblQuanLyGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lblQuanLyDonGia.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblQuanLyDonGia.setText("||Sản Phẩm");
        lblQuanLyDonGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuanLyDonGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuanLyDonGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuanLyDonGiaMouseExited(evt);
            }
        });
        pnl2.add(lblQuanLyDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setText("DANH MỤC ");
        pnl2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Đăng Xuất");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        pnl2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        getContentPane().add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed

    }//GEN-LAST:event_txtMaSachActionPerformed
    public void XoaONhapLieu() {
        txtMaSach.setText("");
        txtTenSach.setText("");

        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtGiaBan.requestFocus();
       
    }
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        XoaONhapLieu();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed
    public void Them() throws SQLException {
        KetNoiCSDL();
        String sql = "INSERT INTO QuanLyGia VALUES(?,?,?,?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMaSach.getText());
        cauLenh.setString(2, txtTenSach.getText());
        cauLenh.setInt(3, Integer.parseInt(txtGiaNhap.getText()));
        cauLenh.setInt(4, Integer.parseInt(txtGiaBan.getText()));
        cauLenh.executeUpdate();
        ketNoi.close();
        txtGiaBan.requestFocus();
    }

    public boolean KiemTraTrungMa() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT Masach FROM quanlygia WHERE maSach=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMaSach.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtMaSach.getText().equalsIgnoreCase(ketQua.getString(1)));
            return true;
        }
        ketNoi.close();
        return false;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (KiemTraTrungMa() == false) {
                Them();
                JOptionPane.showMessageDialog(this, "Thêm thành công vào bảng giá");
                LoarDuLieuGia();
                XoaONhapLieu();
            } else {
                JOptionPane.showMessageDialog(this, "Sách này đã được thêm vào bản giá!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblQuanLyGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyGiaMouseClicked
        try {
            int viTri = tblQuanLyGia.getSelectedRow();
            txtMaSach.setText(tblQuanLyGia.getValueAt(viTri, 0).toString());
            txtTenSach.setText(tblQuanLyGia.getValueAt(viTri, 1).toString());
            txtGiaNhap.setText(tblQuanLyGia.getValueAt(viTri, 2).toString());
            txtGiaBan.setText(tblQuanLyGia.getValueAt(viTri, 3).toString());
        } catch (Exception e) {
            System.out.println("...");
        }

    }//GEN-LAST:event_tblQuanLyGiaMouseClicked
    public void capNhat() throws SQLException {
        int ViTri = tblQuanLyGia.getSelectedRow();
        if (ViTri >= 0) {
            KetNoiCSDL();
            String sql = "UPDATE QuanLygia set  tenSach=?, giaNhap=?, giaBan=?    Where maSach =?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
//            cauLenh.setString(1, txtMaSach.getText());

            cauLenh.setString(1, txtTenSach.getText());
            cauLenh.setInt(2, Integer.parseInt(txtGiaNhap.getText()));
            cauLenh.setInt(3, Integer.parseInt(txtGiaBan.getText()));
            cauLenh.setString(4, txtMaSach.getText());
            cauLenh.executeUpdate();
            ketNoi.close();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng cập nhật");
        }
    }
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            capNhat();
            LoarDuLieuGia();
            XoaONhapLieu();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void lblQuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseClicked
        new QuanLySach().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuanLySachMouseClicked

    private void lblQuanLySachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseEntered
        lblQuanLySach.setOpaque(true);
        lblQuanLySach.setBackground(Color.white);
        lblQuanLySach.setForeground(pnlQuanLyGia.getBackground());
    }//GEN-LAST:event_lblQuanLySachMouseEntered

    private void lblQuanLySachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseExited
        lblQuanLySach.setOpaque(true);
        lblQuanLySach.setBackground(pnl2.getBackground());
        lblQuanLySach.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLySachMouseExited

    private void lblQuanLyGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyGiaMouseClicked
        new QuanLyGia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuanLyGiaMouseClicked

    private void lblQuanLyGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyGiaMouseEntered
        lblQuanLyGia.setOpaque(true);
        lblQuanLyGia.setBackground(Color.white);
        lblQuanLyGia.setForeground(pnlQuanLyGia.getBackground());
    }//GEN-LAST:event_lblQuanLyGiaMouseEntered

    private void lblQuanLyGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyGiaMouseExited
        lblQuanLyGia.setOpaque(true);
        lblQuanLyGia.setBackground(pnl2.getBackground());
        lblQuanLyGia.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyGiaMouseExited

    private void lblQuanLyDonGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyDonGiaMouseClicked
        new SanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuanLyDonGiaMouseClicked

    private void lblQuanLyDonGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyDonGiaMouseEntered
        lblQuanLyDonGia.setOpaque(true);
        lblQuanLyDonGia.setBackground(Color.white);
        lblQuanLyDonGia.setForeground(pnlQuanLyGia.getBackground());
    }//GEN-LAST:event_lblQuanLyDonGiaMouseEntered

    private void lblQuanLyDonGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyDonGiaMouseExited
        lblQuanLyDonGia.setOpaque(true);
        lblQuanLyDonGia.setBackground(pnl2.getBackground());
        lblQuanLyDonGia.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyDonGiaMouseExited

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        new DangNhap().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel29MouseClicked
    public void chonSachThemGia() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select masach, tensach,gianhap from quanlysach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
//            String theLoai = ketQua.getString(3);
//            String nhaXuatBan = ketQua.getString(4);
//            String tacGia = ketQua.getString(5);
//            int soLuong = ketQua.getInt(6);
            int giaNhap = ketQua.getInt(3);
//            int giaban = ketQua.getInt(4);
//            String hinhAnh = ketQua.getString(8);

            model.addRow(new Object[]{maSach, tenSach, giaNhap});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
//        , tenSach, theLoai, nhaXuatBan, tacGia, soLuong, giaNhap, hinhAnh
    }
    private void btnChonSachThemGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSachThemGiaActionPerformed
        try {
            chonSachThemGia();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChonSachThemGiaActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        try {
            LoarDuLieuGia();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton35ActionPerformed
    public void Xoa() throws SQLException {
        KetNoiCSDL();
        String sql = "DELETE QuanLyGia where MaSach=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMaSach.getText());
        int ketQua = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá không", "Xóa sách", JOptionPane.YES_NO_OPTION);
        if (ketQua == JOptionPane.YES_OPTION) {
            cauLenh.executeUpdate();
            ketNoi.close();
        }
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            Xoa();
            LoarDuLieuGia();
            JOptionPane.showMessageDialog(this, "xóa thành công!");
            XoaONhapLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed
    public boolean TimKiem() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT masach,tensach,gianhap FROM quanLysach  WHERE tenSach=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTimKiem.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtTimKiem.getText().equalsIgnoreCase(ketQua.getString(1)));
            {
                txtMaSach.setText(ketQua.getString(1));
                txtTenSach.setText(ketQua.getString(2));

                txtGiaNhap.setText(ketQua.getInt(3) + "");
                model.addRow(new Object[]{});
            }
            return true;
        }
        ketNoi.close();
        return false;
    }
    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        try {
            if (TimKiem() == true) {
                TimKiem();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        txtGiaBan.requestFocus();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton19ActionPerformed
    public void sxMaSach() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLyGia ORDER BY masach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);                      
            int giaNhap = ketQua.getInt(3);
            int giaBan = ketQua.getInt(4);
            model.addRow(new Object[]{maSach, tenSach, giaNhap, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXMaSachActionPerformed
        try {
            sxMaSach();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXMaSachActionPerformed
    public void sxtenSach() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLyGia ORDER BY tensach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);                      
            int giaNhap = ketQua.getInt(3);
            int giaBan = ketQua.getInt(4);
            model.addRow(new Object[]{maSach, tenSach, giaNhap, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXTenSachActionPerformed
        try {
            sxtenSach();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXTenSachActionPerformed
    public void sxGiaNhap() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLyGia ORDER BY giaNhap";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);                      
            int giaNhap = ketQua.getInt(3);
            int giaBan = ketQua.getInt(4);
            model.addRow(new Object[]{maSach, tenSach, giaNhap, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXGiaNhapActionPerformed
        try {
            sxGiaNhap();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXGiaNhapActionPerformed
    public void sxGiaBan() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLyGia ORDER BY giaBan";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);                      
            int giaNhap = ketQua.getInt(3);
            int giaBan = ketQua.getInt(4);
            model.addRow(new Object[]{maSach, tenSach, giaNhap, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXGiaBanActionPerformed
        try {
            sxGiaBan();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXGiaBanActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChonSachThemGia;
    private javax.swing.JButton btnSXGiaBan;
    private javax.swing.JButton btnSXGiaNhap;
    private javax.swing.JButton btnSXMaSach;
    private javax.swing.JButton btnSXTenSach;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton35;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChao;
    private javax.swing.JLabel lblQuanLyDonGia;
    private javax.swing.JLabel lblQuanLyGia;
    private javax.swing.JLabel lblQuanLySach;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnlQuanLyGia;
    private javax.swing.JTable tblQuanLyGia;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
