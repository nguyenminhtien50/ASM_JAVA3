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

/**
 *
 * @author Admin
 */
public class SanPham extends javax.swing.JFrame {

    String user;
    String pass;
    DefaultTableModel model;
    Connection ketNoi;
    DefaultComboBoxModel model1;

    public SanPham() {
        initComponents();
        user = DangNhap.tenDangNhap;
        pass = DangNhap.matKhau;
        lblChao.setText("Chào: " + user);
        TenCotSanPham();
        try {
            LoarDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }

    public void TenCotSanPham() {
        model = new DefaultTableModel();
        model.addColumn("MÃ SÁCH");
        model.addColumn("TÊN SÁCH");
        model.addColumn("TÁC GIẢ");
        model.addColumn("THỂ LOẠI");
        model.addColumn("NXB");
        model.addColumn("GIÁ BÁN");
        tblSanPham.setModel(model);
        model1 = new DefaultComboBoxModel();
        model1.addElement(" ");
        model1.addElement("Tiểu Thuyết");
        model1.addElement("Truyện Ngắn"); //Hoàng hôn đỏ rực
        model1.addElement("Công Nghệ"); // 
        model1.addElement("Toán Học"); // Cậu bé mê toán
        cboTheLoai.setModel(model1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuanLyDonGia = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
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
        pnlQuanLyDonGia1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        cboTheLoai = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        btnSXMaSach = new javax.swing.JButton();
        btnSXGiaBan = new javax.swing.JButton();
        btnSXTenSach = new javax.swing.JButton();
        btnSXNXB = new javax.swing.JButton();
        btnSXTacGia = new javax.swing.JButton();
        btnSXTheLoai = new javax.swing.JButton();

        pnlQuanLyDonGia.setBackground(new java.awt.Color(102, 102, 255));
        pnlQuanLyDonGia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("QUẢN LÝ ĐƠN GIÁ");
        pnlQuanLyDonGia.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 255, 204));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        jButton20.setText("Thêm ");

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        jButton21.setText("Sửa");

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jButton22.setText("Xóa");

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Accept.png"))); // NOI18N
        jButton23.setText("Cập nhật");

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        jButton24.setText("Làm Mới");

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        jButton25.setText("Thoát");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton24)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(jButton22))
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jButton25))
                .addGap(39, 39, 39))
        );

        pnlQuanLyDonGia.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 330, 240));

        jPanel12.setBackground(new java.awt.Color(0, 255, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField6.setPreferredSize(new java.awt.Dimension(25, 25));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 520, 28));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jButton27.setText("Tìm Kiếm");
        jPanel12.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 28));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Tên Sách:");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        pnlQuanLyDonGia.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 760, 60));

        jPanel13.setBackground(new java.awt.Color(0, 255, 204));
        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(102, 255, 204));
        jLabel15.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel15.setText("Mã Đơn:");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel13.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 247, -1));

        jLabel25.setBackground(new java.awt.Color(102, 255, 204));
        jLabel25.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel25.setText("Tên Sách:");
        jPanel13.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel13.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 247, -1));

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel13.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 247, -1));

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel13.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 247, -1));

        jLabel39.setBackground(new java.awt.Color(102, 255, 204));
        jLabel39.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel39.setText("Thành Tiền:");
        jPanel13.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel40.setBackground(new java.awt.Color(102, 255, 204));
        jLabel40.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel40.setText("Số Lượng:");
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel16.setBackground(new java.awt.Color(102, 255, 204));
        jLabel16.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel16.setText("Mã Sách:");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel13.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 247, -1));

        jLabel41.setBackground(new java.awt.Color(102, 255, 204));
        jLabel41.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel41.setText("Giá Bán:");
        jPanel13.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel13.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 247, -1));

        pnlQuanLyDonGia.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 400, 250));

        jPanel8.setBackground(new java.awt.Color(0, 255, 204));

        jButton28.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton28.setText("Previous");

        jButton29.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton29.setText("Next");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton29)
                .addGap(34, 34, 34)
                .addComponent(jButton28)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29)
                    .addComponent(jButton28))
                .addGap(21, 21, 21))
        );

        pnlQuanLyDonGia.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 240, 50));

        jTable4.setBackground(new java.awt.Color(0, 255, 204));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ ĐƠN", "MÃ SÁCH", "TÊN SÁCH", "SỐ LƯỢNG", "GIÁ", "THÀNH TIỀN"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        pnlQuanLyDonGia.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 760, 100));

        jPanel17.setBackground(new java.awt.Color(0, 255, 204));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp Xếp Theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton40.setText("Mã Đơn");
        jPanel17.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton41.setText("Thành Tiền");
        jPanel17.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jButton42.setText("Tên Sách");
        jPanel17.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jButton43.setText("Số Lượng");
        jPanel17.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        pnlQuanLyDonGia.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 490, 69));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Đăng Xuất");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        pnlQuanLyDonGia.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        pnl1.add(lblChao, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 230, -1));

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
        pnl2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        getContentPane().add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 680));

        pnlQuanLyDonGia1.setBackground(new java.awt.Color(102, 102, 255));
        pnlQuanLyDonGia1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Sản Phẩm");
        pnlQuanLyDonGia1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jPanel14.setBackground(new java.awt.Color(0, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(25, 25));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        jPanel14.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 520, 28));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel14.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, 28));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Tên Sách:");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        pnlQuanLyDonGia1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 780, 60));

        tblSanPham.setBackground(new java.awt.Color(0, 255, 204));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        pnlQuanLyDonGia1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 810, 210));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(102, 255, 204));
        jLabel9.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel9.setText("Mã Sách:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 247, -1));

        jLabel18.setBackground(new java.awt.Color(102, 255, 204));
        jLabel18.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel18.setText("Tên Sách:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtTacGia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 247, -1));

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 247, -1));

        jLabel19.setBackground(new java.awt.Color(102, 255, 204));
        jLabel19.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel19.setText("Tác Giả:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel20.setBackground(new java.awt.Color(102, 255, 204));
        jLabel20.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel20.setText("Thể Loại:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel21.setBackground(new java.awt.Color(102, 255, 204));
        jLabel21.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel21.setText("NXB:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 247, -1));

        jLabel23.setBackground(new java.awt.Color(102, 255, 204));
        jLabel23.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel23.setText("Giá Bán:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txtNXB.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(txtNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 247, -1));

        cboTheLoai.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cboTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTheLoaiActionPerformed(evt);
            }
        });
        jPanel1.add(cboTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 250, -1));

        pnlQuanLyDonGia1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 410, 290));

        jPanel15.setBackground(new java.awt.Color(0, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "    Sắp Xếp Theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSXMaSach.setText("Mã Sách");
        btnSXMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXMaSachActionPerformed(evt);
            }
        });
        jPanel15.add(btnSXMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, -1));

        btnSXGiaBan.setText("Giá  Bán");
        btnSXGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXGiaBanActionPerformed(evt);
            }
        });
        jPanel15.add(btnSXGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, -1));

        btnSXTenSach.setText("Tên Sách");
        btnSXTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTenSachActionPerformed(evt);
            }
        });
        jPanel15.add(btnSXTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 90, -1));

        btnSXNXB.setText("NXB");
        btnSXNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXNXBActionPerformed(evt);
            }
        });
        jPanel15.add(btnSXNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, -1));

        btnSXTacGia.setText("Tác Giả");
        btnSXTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTacGiaActionPerformed(evt);
            }
        });
        jPanel15.add(btnSXTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, -1));

        btnSXTheLoai.setText("Thể Loại");
        btnSXTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSXTheLoaiActionPerformed(evt);
            }
        });
        jPanel15.add(btnSXTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 90, -1));

        pnlQuanLyDonGia1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 160, 290));

        getContentPane().add(pnlQuanLyDonGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 830, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblQuanLyDonGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyDonGiaMouseClicked
        new SanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuanLyDonGiaMouseClicked

    private void lblQuanLyDonGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyDonGiaMouseEntered
        lblQuanLyDonGia.setOpaque(true);
        lblQuanLyDonGia.setBackground(Color.white);
        lblQuanLyDonGia.setForeground(pnlQuanLyDonGia1.getBackground());
    }//GEN-LAST:event_lblQuanLyDonGiaMouseEntered

    private void lblQuanLyDonGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyDonGiaMouseExited
        lblQuanLyDonGia.setOpaque(true);
        lblQuanLyDonGia.setBackground(pnl2.getBackground());
        lblQuanLyDonGia.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyDonGiaMouseExited

    private void lblQuanLySachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseClicked
        new QuanLySach().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblQuanLySachMouseClicked

    private void lblQuanLySachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLySachMouseEntered
        lblQuanLySach.setOpaque(true);
        lblQuanLySach.setBackground(Color.white);
        lblQuanLySach.setForeground(pnlQuanLyDonGia1.getBackground());
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
        lblQuanLyGia.setForeground(pnlQuanLyDonGia1.getBackground());
    }//GEN-LAST:event_lblQuanLyGiaMouseEntered
//
    private void lblQuanLyGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuanLyGiaMouseExited
        lblQuanLyGia.setOpaque(true);
        lblQuanLyGia.setBackground(pnl2.getBackground());
        lblQuanLyGia.setForeground(Color.black);
    }//GEN-LAST:event_lblQuanLyGiaMouseExited

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        new DangNhap().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        new DangNhap().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int viTri = tblSanPham.getSelectedRow();
        txtMaSach.setText(tblSanPham.getValueAt(viTri, 0).toString());
        txtTenSach.setText(tblSanPham.getValueAt(viTri, 1).toString());
        txtTacGia.setText(tblSanPham.getValueAt(viTri, 2).toString());
        cboTheLoai.setSelectedItem(tblSanPham.getValueAt(viTri, 3).toString());
        txtNXB.setText(tblSanPham.getValueAt(viTri, 4).toString());
        txtGiaBan.setText(tblSanPham.getValueAt(viTri, 5).toString());

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cboTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTheLoaiActionPerformed

    }//GEN-LAST:event_cboTheLoaiActionPerformed
    public void sxMaSach() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach ORDER BY masach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
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
    public void sxGiaBan() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach ORDER BY GiaBan";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
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
    public void sxtenSach() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach ORDER BY tensach";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
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
    public void sxNXB() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach ORDER BY NXB";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXNXBActionPerformed
        try {
             sxNXB();
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXNXBActionPerformed
    public void sxTacGia() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach ORDER BY tacGia";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXTacGiaActionPerformed
        try {
            sxTacGia();
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXTacGiaActionPerformed
    public void sxTheLoai() throws SQLException {
        model.setRowCount(0);
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach ORDER BY theLoai";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        ResultSet ketQua = cauLenh.executeQuery(); //lưu bảng sinh vien selsect * from SinhVien
        while (ketQua.next() == true) { //còn dữ liệu thì được next hết thì false không nét đuọc
            String maSach = ketQua.getString(1);
            String tenSach = ketQua.getString(2);
            String tacGia = ketQua.getString(3);
            String theLoai = ketQua.getString(4);
            String nhaXuatBan = ketQua.getString(5);
            int giaBan = ketQua.getInt(6);

            model.addRow(new Object[]{maSach, tenSach, tacGia, theLoai, nhaXuatBan, giaBan});
        }
        ketNoi.close(); // thêm, sữa, xóa, cập nhật xong tự đông kết nối;
    }
    private void btnSXTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSXTheLoaiActionPerformed
        try {
            sxTheLoai();
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSXTheLoaiActionPerformed
    public boolean TimKiem() throws SQLException {
        KetNoiCSDL();
        String sql = "select S.masach, S.tensach , s.tacGia, s.theloai, s.NXB,  g.giaban \n"
                + "from quanlygia g join quanlysach s\n"
                + "on g.masach = s.maSach\n"
                + "\n"
                + "where s.tensach =?";
        PreparedStatement cauLenh = ketNoi.prepareStatement(sql);
        cauLenh.setString(1, txtTimKiem.getText());
        ResultSet ketQua = cauLenh.executeQuery();
        while (ketQua.next() == true) {
            if (txtTimKiem.getText().equalsIgnoreCase(ketQua.getString(1)));
            {
                txtMaSach.setText(ketQua.getString(1));
                txtTenSach.setText(ketQua.getString(2));
                txtTacGia.setText(ketQua.getString(3));
                cboTheLoai.setSelectedItem(ketQua.getString(4));
                txtNXB.setText(ketQua.getString(5));
                txtGiaBan.setText(ketQua.getInt(6) + "");
                model.addRow(new Object[]{});
            }
            return true;
        }
        ketNoi.close();
        return false;
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        try {
            if (TimKiem() == true) {
                TimKiem();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSXGiaBan;
    private javax.swing.JButton btnSXMaSach;
    private javax.swing.JButton btnSXNXB;
    private javax.swing.JButton btnSXTacGia;
    private javax.swing.JButton btnSXTenSach;
    private javax.swing.JButton btnSXTheLoai;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblChao;
    private javax.swing.JLabel lblQuanLyDonGia;
    private javax.swing.JLabel lblQuanLyGia;
    private javax.swing.JLabel lblQuanLySach;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnlQuanLyDonGia;
    private javax.swing.JPanel pnlQuanLyDonGia1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
