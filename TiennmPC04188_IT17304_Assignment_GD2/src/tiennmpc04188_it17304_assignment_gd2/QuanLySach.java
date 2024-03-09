/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiennmpc04188_it17304_assignment_gd2;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLySach extends javax.swing.JFrame {

    String user;
    String pass;
    DefaultTableModel model;
    Connection ketNoi;
    String duonDan = null;

    DefaultComboBoxModel model1;
    List<Book> danhsach = new ArrayList<>();
    private int vt = -1;

    public QuanLySach() {
        initComponents();
        user = DangNhap.tenDangNhap;
        pass = DangNhap.matKhau;
        lblChao.setText("Chào: " + user);
        TenCot();
//        TenCotGia();
        try {
            LoarDuLieu();
//            LoarDuLieuGia();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void TenCot() {
        model = new DefaultTableModel();
        model.addColumn("MÃ SÁCH");
        model.addColumn("TÊN SÁCH");
        model.addColumn("THỂ LOẠI");
        model.addColumn("NHÀ XUẤT BẢN");
        model.addColumn("TÁC GIẢ");
        model.addColumn("SỐ LƯỢNG");
        model.addColumn("GIÁ NHẬP");
        model.addColumn("HÌNH ẢNH");
        tblQuanLySach.setModel(model);

        tblQuanLySach.setModel(model);
        model1 = new DefaultComboBoxModel();
        model1.addElement(" ");
        model1.addElement("Tiểu Thuyết");
        model1.addElement("Truyện Ngắn"); //Hoàng hôn đỏ rực
        model1.addElement("Công Nghệ"); // 
        model1.addElement("Toán Học"); // Cậu bé mê toán
        cboTheLoai.setModel(model1);

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

    public void LoarDuLieu() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLySach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String theLoai = ketQua.getString(3);
            String nhaXuatBan = ketQua.getString(4);
            String tacGia = ketQua.getString(5);
            int soLuong = ketQua.getInt(6);
            int giaNhap = ketQua.getInt(7);
            String hinhAnh = ketQua.getString(8);

            model.addRow(new Object[]{maSach, tenSach, theLoai, nhaXuatBan, tacGia, soLuong, giaNhap, hinhAnh});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
//        public void LoarDuLieuGia() throws SQLException {
//        model.setRowCount(0);
//        KetNoiCSDL();
//        String sql = "SELECt * FROM QuanLyGia";
//        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
//        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
//        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
//            String maSach = ketQua.getString(1);
//            String tenSach = ketQua.getString(2);
//            String theLoai = ketQua.getString(3);
//            float giaNhap = ketQua.getFloat(4);
//            float giaBan = ketQua.getFloat(5);
//
//            model.addRow(new Object[]{maSach, tenSach, theLoai, giaNhap, giaBan});
//        }
//        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuanLySach = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblQuanLySach = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        cboTheLoai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSXMaSach = new javax.swing.JButton();
        btnSoLuong = new javax.swing.JButton();
        btnSXTenSach = new javax.swing.JButton();
        btnSXGiaNhap = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLoard = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        txtHinhAnh = new javax.swing.JTextField();
        btnThemAnh = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jButton36 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblChao = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        lblQuanLySach = new javax.swing.JLabel();
        lblQuanLyGia = new javax.swing.JLabel();
        lblQuanLyDonGia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlQuanLySach.setBackground(new java.awt.Color(102, 102, 255));
        pnlQuanLySach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlQuanLySach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblQuanLySach.setBackground(new java.awt.Color(0, 255, 204));
        tblQuanLySach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SÁCH", "TÊN SÁCH", "THỂ LOẠI", "NHÀ XUẤT BẢN", "TÁC GIẢ", "SỐ LƯỢNG", "NGÀY NHẬP", "GIÁ NHẬP", "HÌNH ẢNH"
            }
        ));
        tblQuanLySach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLySachMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblQuanLySach);

        pnlQuanLySach.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 860, 160));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("QUẢN LÝ SÁCH");
        pnlQuanLySach.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(102, 255, 204));
        jLabel9.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel9.setText("Mã Sách:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 247, -1));

        jLabel17.setBackground(new java.awt.Color(102, 255, 204));
        jLabel17.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel17.setText("Tên Sách:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtTacGia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 247, -1));

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 247, -1));

        jLabel18.setBackground(new java.awt.Color(102, 255, 204));
        jLabel18.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel18.setText("Thể Loại:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel19.setBackground(new java.awt.Color(102, 255, 204));
        jLabel19.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel19.setText("NXB");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel20.setBackground(new java.awt.Color(102, 255, 204));
        jLabel20.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel20.setText("Tác Giả:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 247, -1));

        jLabel21.setBackground(new java.awt.Color(102, 255, 204));
        jLabel21.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel21.setText("Số Lượng:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 247, -1));

        jLabel23.setBackground(new java.awt.Color(102, 255, 204));
        jLabel23.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel23.setText("Giá Nhập:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtNXB.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 247, -1));

        cboTheLoai.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cboTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTheLoaiActionPerformed(evt);
            }
        });
        jPanel1.add(cboTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, -1));

        pnlQuanLySach.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 400, 290));

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHinh.setBackground(new java.awt.Color(204, 102, 0));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlQuanLySach.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, 176));

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Accept.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLamMoi)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCapNhat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnThoat))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlQuanLySach.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 270, -1));

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp Xếp Theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSXMaSach.setText("Mã Sách");
        btnSXMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXMaSachActionPerformed(evt);
            }
        });
        jPanel4.add(btnSXMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnSoLuong.setText("Số Lượng");
        btnSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoLuongActionPerformed(evt);
            }
        });
        jPanel4.add(btnSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        btnSXTenSach.setText("Tên Sách");
        btnSXTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTenSachActionPerformed(evt);
            }
        });
        jPanel4.add(btnSXTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        btnSXGiaNhap.setText("Giá Nhập");
        btnSXGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXGiaNhapActionPerformed(evt);
            }
        });
        jPanel4.add(btnSXGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        pnlQuanLySach.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 439, 69));

        jPanel6.setBackground(new java.awt.Color(0, 255, 204));

        btnPrevious.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnPrevious.setText("Previous");

        btnNext.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLoard.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnLoard.setText("Loard");
        btnLoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnNext)
                .addGap(43, 43, 43)
                .addComponent(btnPrevious)
                .addGap(52, 52, 52)
                .addComponent(btnLoard)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnLoard)
                    .addComponent(btnPrevious))
                .addGap(21, 21, 21))
        );

        pnlQuanLySach.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 400, 50));

        jPanel18.setBackground(new java.awt.Color(0, 255, 204));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtHinhAnh.setPreferredSize(new java.awt.Dimension(25, 25));
        txtHinhAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHinhAnhActionPerformed(evt);
            }
        });
        jPanel18.add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 190, 28));

        btnThemAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        btnThemAnh.setText("Thêm Ảnh");
        btnThemAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAnhActionPerformed(evt);
            }
        });
        jPanel18.add(btnThemAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 28));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Đường dẫn:");
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        pnlQuanLySach.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 440, 60));

        jPanel16.setBackground(new java.awt.Color(0, 255, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(25, 25));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        jPanel16.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 600, 28));

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jButton36.setText("Tìm Kiếm");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, 28));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Tên Sách:");
        jPanel16.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        pnlQuanLySach.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 860, 60));

        getContentPane().add(pnlQuanLySach, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 900, 680));

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
        pnl1.add(lblChao, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 240, -1));

        getContentPane().add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 110));

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

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setText("DANH MỤC ");
        pnl2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Đăng Xuất");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        pnl2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, -1));

        getContentPane().add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoardActionPerformed
        try {
            LoarDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoardActionPerformed

    private void tblQuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLySachMouseClicked
        int viTri = tblQuanLySach.getSelectedRow();
        txtMaSach.setText(tblQuanLySach.getValueAt(viTri, 0).toString());
        txtTenSach.setText(tblQuanLySach.getValueAt(viTri, 1).toString());
        cboTheLoai.setSelectedItem(tblQuanLySach.getValueAt(viTri, 2).toString());
        txtNXB.setText(tblQuanLySach.getValueAt(viTri, 3).toString());
        txtTacGia.setText(tblQuanLySach.getValueAt(viTri, 4).toString());
        txtSoLuong.setText(tblQuanLySach.getValueAt(viTri, 5).toString());
        txtGiaNhap.setText(tblQuanLySach.getValueAt(viTri, 6).toString());
        txtHinhAnh.setText(tblQuanLySach.getValueAt(viTri, 7).toString());
        LoadHinh();
    }//GEN-LAST:event_tblQuanLySachMouseClicked

    private void cboTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTheLoaiActionPerformed

    }//GEN-LAST:event_cboTheLoaiActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed
    public void Them() throws SQLException {
        KetNoiCSDL();
        String sql = "INSERT INTO QuanLySach VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMaSach.getText());
        cauLenh.setString(2, txtTenSach.getText());
        cauLenh.setString(3, (String) cboTheLoai.getSelectedItem());
        cauLenh.setString(4, txtNXB.getText());
        cauLenh.setString(5, txtTacGia.getText());
        cauLenh.setInt(6, Integer.parseInt(txtSoLuong.getText()));
        cauLenh.setInt(7, Integer.parseInt(txtGiaNhap.getText()));
        cauLenh.setString(8, txtHinhAnh.getText());
        cauLenh.executeUpdate();
        ketNoi.close();
    }

    public boolean KiemTraTrungMa() throws SQLException {
        KetNoiCSDL();
        String sql = "SELECT Masach FROM quanlySach WHERE maSach=?";
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
                LoarDuLieu();
                XoaONhapLieu();
                JOptionPane.showMessageDialog(this, "thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Mã sách bị trùng!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed
    public void ChonHinh() {
        JFileChooser chooser = new JFileChooser("D:\\Java_3\\BaiTap\\TiennmPC04188_IT17304_Assignment_GD2\\src\\Images");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        if (f != null) {
            String duongDan = f.getAbsolutePath(); //Đường dẫn tuyệt đối
            ImageIcon hinhanh = new ImageIcon(new ImageIcon(duongDan).
                    getImage().getScaledInstance(lblHinh.getWidth(),
                            lblHinh.getHeight(), Image.SCALE_SMOOTH));

            lblHinh.setIcon(hinhanh);
            txtHinhAnh.setText(duongDan);
        }
    }

    public void LoadHinh() {
        try {
            KetNoiCSDL();
            String sql = "SELECT HinhAnh FROM QuanLySach where HinhAnh = ?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
            cauLenh.setString(1, txtHinhAnh.getText());
            ResultSet ketQua = cauLenh.executeQuery();
            if (ketQua.next()) {
                String duongDan = ketQua.getString(1);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(duongDan).
                        getImage().getScaledInstance(lblHinh.getWidth(),
                                lblHinh.getHeight(), Image.SCALE_SMOOTH));

                lblHinh.setIcon(imageIcon);
                txtHinhAnh.setText(duonDan);
            }
        } catch (Exception ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Xoa() throws SQLException {
        KetNoiCSDL();
        String sql = "DELETE QuanLySach where MaSach=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtMaSach.getText());
        int ketQua = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá không", "Xóa sách", JOptionPane.YES_NO_OPTION);
        if (ketQua == JOptionPane.YES_OPTION) {
            cauLenh.executeUpdate();
            ketNoi.close();
        }
    }

    public void XoaONhapLieu() {
        txtMaSach.setText("");
        txtTenSach.setText("");
        cboTheLoai.setSelectedIndex(0);
        txtNXB.setText("");
        txtTacGia.setText("");
        txtSoLuong.setText("");
        txtGiaNhap.setText("");
        txtHinhAnh.setText("");
        lblHinh.setText("");
        txtMaSach.requestFocus();

    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            Xoa();
            LoarDuLieu();
            JOptionPane.showMessageDialog(this, "xóa thành công!");
            XoaONhapLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    public void capNhat() throws SQLException {
        int ViTri = tblQuanLySach.getSelectedRow();
        if (ViTri >= 0) {

            KetNoiCSDL();
            String sql = "UPDATE QuanLySach set tenSach=?, theLoai=?, NXB=?, tacGia=?, soLuong=?, giaNhap=?,  hinhAnh=?  Where maSach =?";
            PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
//            cauLenh.setString(1, txtMaSach.getText());
            cauLenh.setString(1, txtTenSach.getText());
            cauLenh.setString(2, (String) cboTheLoai.getSelectedItem());
            cauLenh.setString(3, txtNXB.getText());
            cauLenh.setString(4, txtTacGia.getText());
            cauLenh.setInt(5, Integer.parseInt(txtSoLuong.getText()));
            cauLenh.setInt(6, Integer.parseInt(txtGiaNhap.getText()));
            cauLenh.setString(7, txtHinhAnh.getText());
            cauLenh.setString(8, txtMaSach.getText());
            cauLenh.executeUpdate();
            ketNoi.close();

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng cập nhật");
        }

    }
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {

            capNhat();
            LoarDuLieu();
            XoaONhapLieu();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        txtTenSach.requestFocus();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        XoaONhapLieu();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
//        try {
//
//            rs.next();
//            btnPrevious.setEnabled(true);
//            if (rs.isAfterLast() || rs.isBeforeFirst()) {
//                btnNext.setEnabled(false);
//                btnPrevious.setEnabled(true);
//                JOptionPane.showMessageDialog(this, "Bạn đang ở cuối danh sách!");
//            } else {
//                int viTri = tblQuanLySach.getSelectedRow();
//                viTri=0;
//                txtMaSach.setText(tblQuanLySach.getValueAt(viTri, 0).toString());
//                txtTenSach.setText(tblQuanLySach.getValueAt(viTri, 1).toString());
//                cboTheLoai.setSelectedItem(tblQuanLySach.getValueAt(viTri, 2).toString());
//                txtNXB.setText(tblQuanLySach.getValueAt(viTri, 3).toString());
//                txtTacGia.setText(tblQuanLySach.getValueAt(viTri, 4).toString());
//                txtSoLuong.setText(tblQuanLySach.getValueAt(viTri, 5).toString());
//                txtGiaNhap.setText(tblQuanLySach.getValueAt(viTri, 6).toString());
//                txtNgayNhap.setText(tblQuanLySach.getValueAt(viTri, 7).toString());
//                txtHinhAnh.setText(tblQuanLySach.getValueAt(viTri, 8).toString());
//                tblQuanLySach.setRowSelectionInterval(tblQuanLySach.getRow() - 1, tblQuanLySach.getRow() - 1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void lblQuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseClicked
        new QuanLySach().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuanLySachMouseClicked

    private void lblQuanLySachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseEntered
        lblQuanLySach.setOpaque(true);
        lblQuanLySach.setBackground(Color.white);
        lblQuanLySach.setForeground(pnlQuanLySach.getBackground());
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
        lblQuanLyGia.setForeground(pnlQuanLySach.getBackground());
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
        lblQuanLyDonGia.setForeground(pnlQuanLySach.getBackground());
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
    public void sxten() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLySach ORDER BY tensach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String theLoai = ketQua.getString(3);
            String nhaXuatBan = ketQua.getString(4);
            String tacGia = ketQua.getString(5);
            int soLuong = ketQua.getInt(6);
            int giaNhap = ketQua.getInt(7);
            String hinhAnh = ketQua.getString(8);

            model.addRow(new Object[]{maSach, tenSach, theLoai, nhaXuatBan, tacGia, soLuong, giaNhap, hinhAnh});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXTenSachActionPerformed
        try {
            sxten();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXTenSachActionPerformed
    public void sxMaSach() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLySach ORDER BY masach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String theLoai = ketQua.getString(3);
            String nhaXuatBan = ketQua.getString(4);
            String tacGia = ketQua.getString(5);
            int soLuong = ketQua.getInt(6);
            int giaNhap = ketQua.getInt(7);
            String hinhAnh = ketQua.getString(8);

            model.addRow(new Object[]{maSach, tenSach, theLoai, nhaXuatBan, tacGia, soLuong, giaNhap, hinhAnh});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXMaSachActionPerformed
        try {
            sxMaSach();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXMaSachActionPerformed
    public void sxGiaNhap() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLySach ORDER BY giaNhap";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String theLoai = ketQua.getString(3);
            String nhaXuatBan = ketQua.getString(4);
            String tacGia = ketQua.getString(5);
            int soLuong = ketQua.getInt(6);
            int giaNhap = ketQua.getInt(7);
            String hinhAnh = ketQua.getString(8);

            model.addRow(new Object[]{maSach, tenSach, theLoai, nhaXuatBan, tacGia, soLuong, giaNhap, hinhAnh});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXGiaNhapActionPerformed
        try {
            sxGiaNhap();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXGiaNhapActionPerformed
    public void sxSoLuong() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "SELECt * FROM QuanLySach ORDER BY soLuong";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String theLoai = ketQua.getString(3);
            String nhaXuatBan = ketQua.getString(4);
            String tacGia = ketQua.getString(5);
            int soLuong = ketQua.getInt(6);
            int giaNhap = ketQua.getInt(7);
            String hinhAnh = ketQua.getString(8);

            model.addRow(new Object[]{maSach, tenSach, theLoai, nhaXuatBan, tacGia, soLuong, giaNhap, hinhAnh});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoLuongActionPerformed
        try {
            sxSoLuong();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSoLuongActionPerformed
    public boolean TimKiem() throws SQLException {

        KetNoiCSDL();
        String sql = "SELECT * FROM quanLysach  WHERE tenSach=?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTimKiem.getText());
        ResultSet ketQua = cauLenh.executeQuery();

        while (ketQua.next() == true) {
            if (txtTimKiem.getText().equalsIgnoreCase(ketQua.getString(1)));
            {
                txtMaSach.setText(ketQua.getString(1));
                txtTenSach.setText(ketQua.getString(2));
                cboTheLoai.setSelectedItem(ketQua.getString(3));
                txtNXB.setText(ketQua.getString(4));
                txtTacGia.setText(ketQua.getString(5));
                txtSoLuong.setText(ketQua.getInt(6) + "");
                txtGiaNhap.setText(ketQua.getInt(7) + "");
                txtHinhAnh.setText(ketQua.getString(8));

                model.addRow(new Object[]{});
                tblQuanLySach.getSelectedRow();

            }
            return true;
//
//            int timthay = 0;
//            int vitri = -1;
//            if (txtTimKiem.getText().equals("")) {
//                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách!!!");
//            } else {
//                for (int i = 0; i < danhsach.size(); i++) {
//                    
//                    if (ketQua.next() == true) {
//                        vitri = i;
//                        timthay = 1;
//                    }
//                }
//                if (timthay == 1) {
//                    txtMaSach.setText(tblQuanLySach.getValueAt(vitri, 1).toString());
//                    txtTenSach.setText(tblQuanLySach.getValueAt(vitri, 2).toString());                    
//                    cboTheLoai.setSelectedItem(tblQuanLySach.getValueAt(vitri, 3).toString());
//                    txtNXB.setText(tblQuanLySach.getValueAt(vitri, 4).toString());
//                    txtTacGia.setText(tblQuanLySach.getValueAt(vitri, 5).toString());
//                    txtSoLuong.setText(tblQuanLySach.getValueAt(vitri, 6).toString());
//                    txtGiaNhap.setText(tblQuanLySach.getValueAt(vitri, 7).toString());
//                    txtHinhAnh.setText(tblQuanLySach.getValueAt(vitri, 8).toString());
//                     model.addRow(new Object[]{});
//                } else {
//                    JOptionPane.showMessageDialog(this, "Không tìm thấy!!!");
//                    XoaONhapLieu();
//                }
//            }
        }
        ketNoi.close();
        return false;
    }
    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        try {
            if (TimKiem() == true) {
                TimKiem();

            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        ChonHinh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void btnThemAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAnhActionPerformed
        ChonHinh();
    }//GEN-LAST:event_btnThemAnhActionPerformed

    private void txtHinhAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHinhAnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhAnhActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoard;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSXGiaNhap;
    private javax.swing.JButton btnSXMaSach;
    private javax.swing.JButton btnSXTenSach;
    private javax.swing.JButton btnSoLuong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemAnh;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JButton jButton36;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblChao;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblQuanLyDonGia;
    private javax.swing.JLabel lblQuanLyGia;
    private javax.swing.JLabel lblQuanLySach;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnlQuanLySach;
    private javax.swing.JTable tblQuanLySach;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHinhAnh;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void lblDangXuat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
