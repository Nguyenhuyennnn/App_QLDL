/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dao;
import Controller.KNCSDL;
import Controller.UrlKN;
import Controller.XLDL;
import csdl.TblDattour;
import csdl.TblKhachhang;
import csdl.TblNhanvien;
import csdl.TblTour;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Administrator
 */
public class DatTour extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL dtdl;
    UrlKN url;
    Dao dao;
    TblKhachhang KH;
    TblNhanvien NV;
    TblTour T;
    KNCSDL kn;
    
    /**
     * Creates new form DatTour
     */
    public DatTour(String tenkh) {
        initComponents();
        setLocationRelativeTo(null);
        dtdl=new XLDL();
        loadDT();
        url=new UrlKN();
        dao= new Dao(url.knURL());
        kn= new KNCSDL();
        
        loadmaTour();
        loadmaKH();
        loadmaNV();
       if(tenkh!=null && !tenkh.equals("")){
            loadforKhachHang(tenkh);
        }else{
             getListDT();
        }
       
    }

    

    
    void loadDT(){
        ArrayList<TblDattour>list;
        try{
        list = dtdl.getListDT();
        tablemodel = (DefaultTableModel) tblDT.getModel();
        for(TblDattour dt : list){
            tablemodel.addRow(new Object[]{dt.getMadattour(),dt.getTentour(),dt.getHotenkh(),dt.getSoluong(),dt.getThoigianbatdau(),dt.getDiadiembatdau(),dt.getHotennv()});
        }
        }catch(SQLException ex){
            
        }
    }
    void loadmaTour(){
        try{
            ArrayList<TblTour> tour=dtdl.getListTour();
            for(TblTour t:tour){
                cboTour.addItem(t);
            }
        }catch(Exception ex){
            
        }
    }
    void loadmaKH(){
        try{
            ArrayList<TblKhachhang> KH=dtdl.getListKH();
            for(TblKhachhang kh:KH){
                cboKH.addItem(kh);
            }
        }catch(Exception ex){
            
        }
    }
    void loadmaNV(){
        try{
            ArrayList<TblNhanvien> NV=dtdl.getListNV();
            for(TblNhanvien nv:NV){
                cboNV.addItem(nv);
            }
        }catch(Exception ex){
            
        }
    }
    public static String MaKH;
    public void getListDT() {
        ArrayList<TblDattour> listDT = new ArrayList<>();
        listDT.clear();
        Connection conn;
        try {
            conn = kn.getConnect();
            String sql = "SELECT *FROM tbl_dattour WHERE makh = "+MaKH;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            
            txtMaDT.setText(result.getLong(1)+"");
            cboTour.setSelectedItem(result.getLong(2));
            cboKH.setSelectedItem(result.getLong(3));
            txtSL.setText(result.getString(4));
            dcTGBD.setDate(result.getDate(5));
            txtDDBD.setText(result.getString(6));
            cboNV.setSelectedItem(result.getLong(7));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ThongtinKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private boolean KiemTraDL() throws HeadlessException{
        StringBuilder sb= new StringBuilder();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        if(cboTour.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN TOUR!\n");
            cboTour.setBackground(Color.yellow);
            cboTour.requestFocus();
        }
        else{
            cboTour.setBackground(Color.white);
            
        }
        if(cboKH.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN KHÁCH HÀNG!\n");
            cboKH.setBackground(Color.yellow);
            cboKH.requestFocus();
        }
        else{
            cboKH.setBackground(Color.white);
            
        }
        if(txtSL.getText().equals("")){
            sb.append("VUI LÒNG CHO BIẾT SỐ LƯỢNG!\n");
            txtSL.setBackground(Color.yellow);
            txtSL.requestFocus();
        }
        else{
            txtSL.setBackground(Color.white);
            
        }
        if(dcTGBD.equals("")){
            sb.append("VUI LÒNG CHỌN THỜI GIAN BẮT ĐẦU!\n");
            dcTGBD.setBackground(Color.yellow);
            dcTGBD.requestFocus();
        }
        else{
            dcTGBD.setBackground(Color.white);
            
        }
        if(txtDDBD.getText().equals("")){
            sb.append("VUI LÒNG CHỌN ĐỊA ĐIỂM BẮT ĐẦU!\n");
            txtSL.setBackground(Color.yellow);
            txtSL.requestFocus();
        }
        else{
            txtSL.setBackground(Color.white);
            
        }
        if(cboNV.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN NHÂN VIÊN SẮP TOUR!\n");
            cboNV.setBackground(Color.yellow);
            cboNV.requestFocus();
        }
        else{
            cboNV.setBackground(Color.white);
            
        }
        if(sb.length()>0){
            JOptionPane.showConfirmDialog(this, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
        
    }
    boolean them, sua;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaDT = new javax.swing.JLabel();
        txtMaDT = new javax.swing.JTextField();
        lblTour = new javax.swing.JLabel();
        cboKH = new javax.swing.JComboBox<>();
        cboTour = new javax.swing.JComboBox<>();
        lblDDBD = new javax.swing.JLabel();
        txtDDBD = new javax.swing.JTextField();
        lblSL = new javax.swing.JLabel();
        dcTGBD = new com.toedter.calendar.JDateChooser();
        lblTGBD = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        lblNhanVien = new javax.swing.JLabel();
        cboNV = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnThemmoiKH = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JLabel();
        btnLuu = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JLabel();
        btnHuy = new javax.swing.JLabel();
        txtKH1 = new javax.swing.JLabel();
        btnTinh = new javax.swing.JLabel();
        btnThoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt tour", "Tour", "Mã khách hàng", "Số lượng ", "Thời gian bắt đầu", "Địa điểm bắt đầu", "Mã nhân viên"
            }
        ));
        tblDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDT);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 910, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ĐẶT TOUR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 140, 10));

        lblMaDT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaDT.setForeground(new java.awt.Color(255, 255, 255));
        lblMaDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaDT.setText("MÃ ĐẶT TOUR:");
        jPanel1.add(lblMaDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 220, 40));
        jPanel1.add(txtMaDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 350, 40));

        lblTour.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTour.setForeground(new java.awt.Color(255, 255, 255));
        lblTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTour.setText("TOUR: ");
        jPanel1.add(lblTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 210, 30));

        jPanel1.add(cboKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 220, 40));

        jPanel1.add(cboTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 350, 40));

        lblDDBD.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDDBD.setForeground(new java.awt.Color(255, 255, 255));
        lblDDBD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDDBD.setText("ĐỊA ĐIỂM BẮT ĐẦU: ");
        jPanel1.add(lblDDBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 515, 260, 40));
        jPanel1.add(txtDDBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 350, 40));

        lblSL.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSL.setForeground(new java.awt.Color(255, 255, 255));
        lblSL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSL.setText("SỐ LƯỢNG: ");
        jPanel1.add(lblSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 335, 210, 40));
        jPanel1.add(dcTGBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 350, 40));

        lblTGBD.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTGBD.setForeground(new java.awt.Color(255, 255, 255));
        lblTGBD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTGBD.setText("THỜI GIAN BẮT ĐẦU: ");
        jPanel1.add(lblTGBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, 270, 40));
        jPanel1.add(txtSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 350, 40));

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhanVien.setText("NHÂN VIÊN: ");
        jPanel1.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 210, 40));

        jPanel1.add(cboNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 350, 40));

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_edit_white_24dp.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 630, 120, 50));

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_delete_white_24dp.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 110, 50));

        btnThemmoiKH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemmoiKH.setForeground(new java.awt.Color(255, 255, 255));
        btnThemmoiKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThemmoiKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_person_add_white_24dp.png"))); // NOI18N
        btnThemmoiKH.setText("Thêm mới");
        btnThemmoiKH.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThemmoiKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemmoiKHMouseClicked(evt);
            }
        });
        jPanel1.add(btnThemmoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 130, 40));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(102, 102, 102));
        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimKiem.setOpaque(false);
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 70, 280, 40));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_add_white_24dp.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 630, 120, 50));

        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_save_white_24dp.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 630, 120, 50));

        btnTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_search_white_24dp.png"))); // NOI18N
        btnTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        jPanel1.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 70, 40, 40));

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 630, 120, 50));

        txtKH1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtKH1.setForeground(new java.awt.Color(255, 255, 255));
        txtKH1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtKH1.setText("KHÁCH HÀNG: ");
        jPanel1.add(txtKH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, 220, 40));

        btnTinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnTinh.setForeground(new java.awt.Color(255, 255, 255));
        btnTinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_calculate_white_24dp.png"))); // NOI18N
        btnTinh.setText("Tính hóa đơn");
        btnTinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTinhMouseClicked(evt);
            }
        });
        jPanel1.add(btnTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, 190, 50));

        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnThoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        them=true;
        sua=false;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        if(them){
           if(KiemTraDL()){
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
               try {
                   
                   TblTour t= (TblTour) cboTour.getSelectedItem();
                            String matour=String.valueOf(t.getMatour());
                   TblKhachhang kh= (TblKhachhang) cboKH.getSelectedItem();
                            String makh=String.valueOf(kh.getMakh());
                   Integer soluong = Integer.parseInt(txtSL.getText());
                   String thoigianbatdau=dateFormat.format(dcTGBD.getDate());
                   String diadiembatdau= txtDDBD.getText();
                   TblNhanvien nv= (TblNhanvien) cboNV.getSelectedItem();
                            String manv=String.valueOf(nv.getManv());

                   Connection conn= dao.getConnect();
                   
                   String caulenh="INSERT INTO tbl_dattour VALUES (null,'"+matour+"','"+makh+"','"+soluong+"','"+thoigianbatdau+"','"+diadiembatdau+"','"+manv+"')";
                   boolean a= dao.Lenh(caulenh, conn);
                   if(a){
                       tblDT.removeAll();
                       tablemodel.setRowCount(0);
                       loadDT();
                       JOptionPane.showMessageDialog(this, "THÊM THÀNH CÔNG!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "THÊM KHÔNG THÀNH CÔNG!","Thông báo",JOptionPane.ERROR_MESSAGE);
                   }
               } catch (SQLException ex) {
                   
               }
           } else{
            JOptionPane.showMessageDialog(this, "NHẬP SAI VUI LÒNG NHẬP LẠI!","Thông báo",JOptionPane.ERROR_MESSAGE);
        }
        }
       
           
        if(sua){
             if(KiemTraDL()){
             SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());    
            try{
                Integer MaDattour=Integer.parseInt(txtMaDT.getText());
                TblTour t= (TblTour) cboTour.getSelectedItem();
                        String matour=String.valueOf(t.getMatour());
                TblKhachhang kh= (TblKhachhang) cboKH.getSelectedItem();
                        String makh=String.valueOf(kh.getMakh());
                Integer soluong = Integer.parseInt(txtSL.getText());
                String thoigianbatdau=dateFormat.format(dcTGBD.getDate());
                String diadiembatdau= txtDDBD.getText();
                TblNhanvien nv= (TblNhanvien) cboNV.getSelectedItem();
                        String manv=String.valueOf(nv.getManv());

                Connection conn= dao.getConnect();
                String caulenh="UPDATE tbl_dattour SET matour='"+matour+"',makh='"+makh+"',soluong='"+soluong+"',thoigianbatdau='"+thoigianbatdau+"',diadiembatdau='"+diadiembatdau+"',manv='"+manv+"'where madattour="+MaDattour;
                boolean a= dao.Lenh(caulenh, conn);
                if(a){
                    tblDT.removeAll();
                    tablemodel.setRowCount(0);
                    loadDT();
                    JOptionPane.showMessageDialog(this, "SỬA THÀNH CÔNG!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "SỬA KHÔNG THÀNH CÔNG!","Thông báo",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "NHẬP SAI VUI LÒNG NHẬP LẠI!","Thông báo",JOptionPane.ERROR_MESSAGE);
            }
        }   
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
        them=false;
        sua=true;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        
            int chon= JOptionPane.showConfirmDialog(this,"BẠN CÓ MUỐN XÓA?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(chon== JOptionPane.YES_OPTION){
                try {
                    Integer MaDattour= Integer.parseInt(txtMaDT.getText());
                    Connection conn= dao.getConnect();
                    String caulenhh="DELETE FROM tbl_hoadon WHERE madattour="+MaDattour;
                     boolean b= dao.Lenh(caulenhh, conn);
                    String caulenh="DELETE FROM tbl_dattour WHERE madattour="+MaDattour;
                    boolean a= dao.Lenh(caulenh, conn);
                    if(a){
                        tblDT.removeAll();
                        tablemodel.setRowCount(0);
                        loadDT();
                        JOptionPane.showMessageDialog(this, "XÓA THÀNH CÔNG!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{ 
                        JOptionPane.showMessageDialog(this, "XÓA KHÔNG THÀNH CÔNG!","Thông báo",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                   
                }
            }
        
    }//GEN-LAST:event_btnXoaMouseClicked
    void hienThi(int i){
        TableModel model= tblDT.getModel();
        txtMaDT.setText(model.getValueAt(i,0).toString());
        String cbosubT=model.getValueAt(i, 1).toString();
        for(int j=0;j<cboTour.getItemCount();j++){
            if(cboTour.getItemAt(j).toString().equalsIgnoreCase(cbosubT)){
                cboTour.setSelectedIndex(j);
            }
        }
        String cbosubKH=model.getValueAt(i, 2).toString();
        for(int j=0;j<cboKH.getItemCount();j++){
            if(cboKH.getItemAt(j).toString().equalsIgnoreCase(cbosubKH)){
                cboKH.setSelectedIndex(j);
            }
        }
        txtSL.setText(model.getValueAt(i,3).toString());
        Date date =null;
        try{
            date =new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i,4).toString());
        } catch (ParseException ex) {
            Logger.getLogger(DatTour.class.getName()).log(Level.SEVERE, null, ex);
        }
        dcTGBD.setDate(date);
        txtDDBD.setText(model.getValueAt(i,5).toString());
        String cbosubNV=model.getValueAt(i, 6).toString();
        for(int j=0;j<cboNV.getItemCount();j++){
            if(cboNV.getItemAt(j).toString().equalsIgnoreCase(cbosubNV)){
                cboNV.setSelectedIndex(j);
            }
        }
    }
    String Madattour;
    private void tblDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDTMouseClicked
        // TODO add your handling code here:
        int i= tblDT.getSelectedRow();
        hienThi(i);
        TableModel model= tblDT.getModel();
        Madattour=model.getValueAt(i,0).toString();
        tenTour=model.getValueAt(i,1).toString();
    }//GEN-LAST:event_tblDTMouseClicked

    private void btnThemmoiKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemmoiKHMouseClicked
        // TODO add your handling code here:
        ThemKH tKH= new ThemKH();
        tKH.setVisible(true);
    }//GEN-LAST:event_btnThemmoiKHMouseClicked
    
    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        // TODO add your handling code here:
        txtMaDT.setText("");
        txtSL.setText("");
        dcTGBD.setDate(null);
        txtDDBD.setText("");
        txtTimKiem.setText("");
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        txtSL.requestFocus();
        tblDT.removeAll();
        tablemodel.setRowCount(0);
        loadDT();
       
    }//GEN-LAST:event_btnHuyMouseClicked

    void loadforKhachHang(String search){
        tblDT.removeAll();
        tablemodel.setRowCount(0);
        
    
        ArrayList<TblDattour>list= new ArrayList<>();
        try{
        list = dtdl.getListDT(search);
        tablemodel = (DefaultTableModel) tblDT.getModel();
        for(TblDattour dt : list){
            tablemodel.addRow(new Object[]{dt.getMadattour(), dt.getTentour(), dt.getHotenkh(), dt.getSoluong(), dt.getThoigianbatdau(), dt.getDiadiembatdau(), dt.getHotennv()});
        }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, ex.toString());
            
        }
    }
    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        tblDT.removeAll();
        tablemodel.setRowCount(0);
        
        String timkiem=txtTimKiem.getText();
        ArrayList<TblDattour>list= new ArrayList<>();
        try{
        list = dtdl.getListDT(timkiem);
        tablemodel = (DefaultTableModel) tblDT.getModel();
        for(TblDattour dt : list){
            tablemodel.addRow(new Object[]{dt.getMadattour(), dt.getTentour(), dt.getHotenkh(), dt.getSoluong(), dt.getThoigianbatdau(), dt.getDiadiembatdau(), dt.getHotennv()});
        }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, ex.toString());
            
        }
             
    }//GEN-LAST:event_btnTimKiemMouseClicked
    public static  String tenTour;
    private void btnTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTinhMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, txtMaDT.getText());
        thongtinHD hd= new thongtinHD(txtMaDT.getText());
        hd.setVisible(true);
    }//GEN-LAST:event_btnTinhMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatMouseClicked

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
            java.util.logging.Logger.getLogger(DatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatTour(MaKH).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnHuy;
    private javax.swing.JLabel btnLuu;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnThemmoiKH;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JLabel btnTinh;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JComboBox<TblKhachhang> cboKH;
    private javax.swing.JComboBox<TblNhanvien> cboNV;
    private javax.swing.JComboBox<TblTour> cboTour;
    private com.toedter.calendar.JDateChooser dcTGBD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDDBD;
    private javax.swing.JLabel lblMaDT;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblTGBD;
    private javax.swing.JLabel lblTour;
    private javax.swing.JTable tblDT;
    private javax.swing.JTextField txtDDBD;
    private javax.swing.JLabel txtKH1;
    private javax.swing.JTextField txtMaDT;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
