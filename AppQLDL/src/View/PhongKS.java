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

import csdl.TblKhachsan;
import csdl.TblPhongkhachsan;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrator
 */
public class PhongKS extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL pksdl;
    UrlKN url;
    Dao dao;
    TblKhachsan KS;
    KNCSDL kn;
    
    /**
     * Creates new form PhongKS
     */
    public PhongKS(String tenKS) {
        initComponents();
        pksdl=new XLDL();
        maks=Long.parseLong(tenKS);
        url=new UrlKN();
        dao= new Dao(url.knURL());
        kn=new KNCSDL();
        loadmaKS();
        loadPKS();
    }
    public long maks;
    void loadPKS(){
        ArrayList<TblPhongkhachsan>list;
        try{
            list = pksdl.getListPKS(maks);
            tablemodel = (DefaultTableModel) tblPKS.getModel();
            for(TblPhongkhachsan pks : list){
                tablemodel.addRow(new Object[]{pks.getMaphongks(), pks.getTenphong(), pks.getLoai(), pks.getGia(), pks.getTenks()});
            }
        }catch(SQLException ex){
            
        }
        
    }
    void loadmaKS(){
        try{
            ArrayList<TblKhachsan> KS= pksdl.getListKS();
            for(TblKhachsan ks:KS){
                cboks.addItem(ks);
            }
        }catch(Exception ex){
            
        }
    }
    void loadforKhachSan(String search){
        tblPKS.removeAll();
        tablemodel.setRowCount(0);
        
    
        ArrayList<TblPhongkhachsan>list= new ArrayList<>();
        try{
        list = pksdl.getListPKS(search);
        tablemodel = (DefaultTableModel) tblPKS.getModel();
        for(TblPhongkhachsan pks : list){
            tablemodel.addRow(new Object[]{pks.getMaphongks(), pks.getTenphong(), pks.getLoai(), pks.getGia(), pks.getTenks()});
        }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, ex.toString());
            
        }
    }
    public static String MaKS;
    public void getListPKS() {
        ArrayList<TblPhongkhachsan> listKS = new ArrayList<>();
        listKS.clear();
        Connection conn;
        try {
            conn = kn.getConnect();
            String sql = "SELECT *FROM tbl_phongkhachsan WHERE maks = "+MaKS;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            
            txtMaPhong.setText(result.getLong(1)+"");
            txtTenPhong.setText(result.getString(2));
            cboLoai.setSelectedItem(result.getString(3));
            frmGia.setText(result.getString(4));
            cboks.setSelectedItem(result.getLong(5));
            
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ThongtinKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     void hienThi(int i){
        TableModel model= tblPKS.getModel();
        txtMaPhong.setText(model.getValueAt(i,0).toString());
        txtTenPhong.setText(model.getValueAt(i,1).toString());
        cboLoai.setSelectedItem(model.getValueAt(i,2).toString());
        frmGia.setText(model.getValueAt(i,3).toString());
        String cbosubT=model.getValueAt(i, 4).toString();
        for(int j=0;j<cboks.getItemCount();j++){
            if(cboks.getItemAt(j).toString().equalsIgnoreCase(cbosubT)){
                cboks.setSelectedIndex(j);
            }
        }
        
    }
    private boolean KiemTraDL() throws HeadlessException{
        StringBuilder sb= new StringBuilder();
        if(txtTenPhong.getText().equals("")){
            sb.append("VUI LÒNG NHẬP TÊN PHÒNG!\n");
            txtTenPhong.setBackground(Color.yellow);
            txtTenPhong.requestFocus();
        }
        else{
            txtTenPhong.setBackground(Color.white);
            
        }
        if(cboLoai.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN LOẠI!\n");
            cboLoai.setBackground(Color.yellow);
            cboLoai.requestFocus();
        }
        else{
            cboLoai.setBackground(Color.white);
            
        }
        if(frmGia.getText().equals("")){
            sb.append("VUI LÒNG NHẬP GIÁ PHÒNG!\n");
            frmGia.setBackground(Color.yellow);
            frmGia.requestFocus();
        }
        else{
            frmGia.setBackground(Color.white);
            
        }
        if(cboks.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN KHÁCH SẠN!\n");
            cboks.setBackground(Color.yellow);
            cboks.requestFocus();
        }
        else{
            cboks.setBackground(Color.white);
            
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaPhong = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        lblTenPhong = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        lblLoai = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPKS = new javax.swing.JTable();
        btntimkiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnSua = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnLuu = new javax.swing.JLabel();
        lblGia1 = new javax.swing.JLabel();
        cboks = new javax.swing.JComboBox<>();
        cboLoai = new javax.swing.JComboBox<>();
        frmGia = new javax.swing.JFormattedTextField();
        btnThem = new javax.swing.JLabel();
        btnHuy = new javax.swing.JLabel();
        btnthoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PHÒNG KHÁCH SẠN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 280, 10));

        lblMaPhong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblMaPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaPhong.setText("MÃ PHÒNG:");
        jPanel1.add(lblMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 160, 40));
        jPanel1.add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 133, 350, 50));

        lblTenPhong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTenPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblTenPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenPhong.setText("TÊN PHÒNG:");
        jPanel1.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 40));
        jPanel1.add(txtTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 350, 50));

        lblLoai.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLoai.setForeground(new java.awt.Color(255, 255, 255));
        lblLoai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoai.setText("LOẠI:");
        jPanel1.add(lblLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 160, 40));

        lblGia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblGia.setForeground(new java.awt.Color(255, 255, 255));
        lblGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGia.setText("KHÁCH SẠN:");
        jPanel1.add(lblGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 160, 40));

        tblPKS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPKS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng ", "Tên phòng", "Loại", "Giá", "Khách sạn"
            }
        ));
        tblPKS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPKSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPKS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 870, 340));

        btntimkiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_search_white_24dp.png"))); // NOI18N
        btntimkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btntimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntimkiemMouseClicked(evt);
            }
        });
        jPanel1.add(btntimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 50, 40, 40));

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
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 270, 40));

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
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, 130, 50));

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
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, 130, 50));

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
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 500, 130, 50));

        lblGia1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblGia1.setForeground(new java.awt.Color(255, 255, 255));
        lblGia1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGia1.setText("GIÁ:");
        jPanel1.add(lblGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 160, 40));

        jPanel1.add(cboks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 350, 50));

        cboLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PHÒNG VIP", "PHÒNG ĐÔI", "PHÒNG ĐƠN", "PHÒNG TẬP THỂ", " " }));
        jPanel1.add(cboLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 350, 50));
        jPanel1.add(frmGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 350, 50));

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
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 130, 50));

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
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 580, 130, 50));

        btnthoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnthoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnthoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthoatMouseClicked(evt);
            }
        });
        jPanel1.add(btnthoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        if(them){
            if(KiemTraDL()){
                try {
                    String tenphong= txtTenPhong.getText().toString();
                    String loai= cboLoai.getSelectedItem().toString();
                    Float gia = Float.parseFloat(frmGia.getText());
                    TblKhachsan ks= (TblKhachsan) cboks.getSelectedItem();
                            String maks=String.valueOf(ks.getMaks());
                    Connection conn= dao.getConnect();

                    String caulenh="INSERT INTO tbl_phongkhachsan VALUES (null,'"+tenphong+"','"+loai+"','"+gia+"',"+maks+")";
                    boolean a= dao.Lenh(caulenh, conn);
                    if(a){
                        tblPKS.removeAll();
                        tablemodel.setRowCount(0);
                        loadPKS();
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

                try{
                    Integer Mapks=Integer.parseInt(txtMaPhong.getText());
                    String tenphong= txtTenPhong.getText().toString();
                    String loai= cboLoai.getSelectedItem().toString();
                    Float gia = Float.parseFloat(frmGia.getText());
                    TblKhachsan ks= (TblKhachsan) cboks.getSelectedItem();
                            String maks=String.valueOf(ks.getMaks());
                    Connection conn= dao.getConnect();
                    String caulenh="UPDATE tbl_phongkhachsan SET tenphong='"+tenphong+"',loai='"+loai+"',gia='"+gia+"',maks='"+maks+"'where maphongks="+Mapks;
                    boolean a= dao.Lenh(caulenh, conn);
                    if(a){
                        tblPKS.removeAll();
                        tablemodel.setRowCount(0);
                        loadPKS();
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
                    Integer Mapks= Integer.parseInt(txtMaPhong.getText());
                    Connection conn= dao.getConnect();
                    String caulenh="DELETE FROM tbl_phongkhachsan WHERE maphongks="+Mapks;
                    boolean a= dao.Lenh(caulenh, conn);
                    if(a){
                        tblPKS.removeAll();
                        tablemodel.setRowCount(0);
                        loadPKS();
                        JOptionPane.showMessageDialog(this, "XÓA THÀNH CÔNG!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{ 
                        JOptionPane.showMessageDialog(this, "XÓA KHÔNG THÀNH CÔNG!","Thông báo",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                   
                }
            }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btntimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntimkiemMouseClicked
        // TODO add your handling code here:
        tblPKS.removeAll();
        tablemodel.setRowCount(0);
        
        String timkiem=txtTimKiem.getText();
        ArrayList<TblPhongkhachsan>list;
        try{
        list = pksdl.getListPKS(timkiem);
        tablemodel = (DefaultTableModel) tblPKS.getModel();
        for(TblPhongkhachsan pks : list){
            tablemodel.addRow(new Object[]{pks.getMaphongks(), pks.getTenphong(), pks.getLoai(), pks.getGia(), pks.getTenks()});
        }
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_btntimkiemMouseClicked

    private void tblPKSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPKSMouseClicked
        // TODO add your handling code here:
        int i= tblPKS.getSelectedRow();
        hienThi(i);
    }//GEN-LAST:event_tblPKSMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        them=true;
        sua=false;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        // TODO add your handling code here:
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        frmGia.setText("");
        txtTimKiem.setText("");
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        txtTenPhong.requestFocus();
        tblPKS.removeAll();
        tablemodel.setRowCount(0);
        loadPKS();
       
    }//GEN-LAST:event_btnHuyMouseClicked

    private void btnthoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnthoatMouseClicked

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
            java.util.logging.Logger.getLogger(PhongKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhongKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhongKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhongKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display t
        he form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhongKS(MaKS).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnHuy;
    private javax.swing.JLabel btnLuu;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btnthoat;
    private javax.swing.JLabel btntimkiem;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JComboBox<TblKhachsan> cboks;
    private javax.swing.JFormattedTextField frmGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblGia1;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblTenPhong;
    private javax.swing.JTable tblPKS;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
