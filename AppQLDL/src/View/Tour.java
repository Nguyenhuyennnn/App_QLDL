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
import csdl.TblDichvu;
import csdl.TblKhachsan;
import csdl.TblPhongkhachsan;
import csdl.TblPhuongtien;

import csdl.TblTour;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.SQLException;
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
public class Tour extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL tdl;
    XLDL pksdl;
    UrlKN url;
    Dao dao;
    KNCSDL kn;
    TblPhongkhachsan pks;
    TblDichvu dv;
    TblPhuongtien pt;
    /**
     * Creates new form Tour
     */
    public Tour() {
        initComponents();
        setLocationRelativeTo(null);
        tdl=new XLDL();
        pksdl=new XLDL();
        loadT();
        url=new UrlKN();
        dao= new Dao(url.knURL());
        kn= new KNCSDL();
        loadmaDV();
        loadmaPT();
        loadKS();
    }
    
    void loadT(){
        ArrayList<TblTour>list;
        try{
        list = tdl.getListTour();
        tablemodel = (DefaultTableModel) tbltour.getModel();
        for(TblTour t : list){
            tablemodel.addRow(new Object[]{t.getMatour(),t.getTentour(),t.getThoigian(),t.getTenphongks(),t.getTendv(),t.getTenpt(),t.getDiadiem(), t.getGia(), t.getGhichu()});
        }
        }catch(SQLException ex){
            
        }
    }
     
  
     void loadmaDV(){
        try{
            ArrayList<TblDichvu> DV=tdl.getListDV();
            for(TblDichvu dv:DV){
                cboDV.addItem(dv);
            }
        }catch(Exception ex){
            
        }
    }
     void loadmaPT(){
        try{
            ArrayList<TblPhuongtien> PT=tdl.getListPT();
            for(TblPhuongtien pt:PT){
                cboPT.addItem(pt);
            }
        }catch(Exception ex){
            
        }
    }
     void loadKS(){
        try{
            ArrayList<TblKhachsan> KS=tdl.getListKS();
            for(TblKhachsan ks:KS){
                cboKS.addItem(ks);
            }
        }catch(Exception ex){
            
        }
    }
    void loadPhong(long maks){
        try{
           cbopKS.removeAllItems();
             ArrayList<TblPhongkhachsan> phongks =pksdl.getListPKS(maks);
             for(TblPhongkhachsan pks:phongks){
                cbopKS.addItem(pks);
            }
        }catch(Exception e){
            
        }
    }
    
     private boolean KiemTraDL() throws HeadlessException {
        StringBuilder sb= new StringBuilder();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        if(txtTentour.getText().equals("")){
            sb.append("VUI LÒNG NHẬP TÊN TOUR!\n");
            txtTentour.setBackground(Color.yellow);
            txtTentour.requestFocus();
        }
        else{
            txtTentour.setBackground(Color.white);
            
        }
        if(dcTG.equals("")){
            sb.append("VUI LÒNG CHO BIẾT THỜI GIAN!\n");
            dcTG.setBackground(Color.yellow);
            dcTG.requestFocus();
        }
        else{
            dcTG.setBackground(Color.white);
            
        }
        if(cbopKS.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN PHÒNG KHÁCH SẠN!\n");
            cbopKS.setBackground(Color.yellow);
            cbopKS.requestFocus();
        }
        else{
            cbopKS.setBackground(Color.white);
            
        }
        if(cboDV.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN DỊCH VỤ!\n");
            cboDV.setBackground(Color.yellow);
            cboDV.requestFocus();
        }
        else{
            cboDV.setBackground(Color.white);
            
        }
        if(cboPT.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN PHƯƠNG TIỆN!\n");
            cboPT.setBackground(Color.yellow);
            cboPT.requestFocus();
        }
        else{
            cboPT.setBackground(Color.white);
            
        }
        if(txtDiaDiem.getText().equals("")){
            sb.append("VUI LÒNG NHẬP ĐỊA ĐIỂM!\n");
            txtDiaDiem.setBackground(Color.yellow);
            txtDiaDiem.requestFocus();
        }
        else{
            txtDiaDiem.setBackground(Color.white);
            
        }
        if(frmGia.getText().equals("")){
            sb.append("VUI LÒNG CHO BIẾT GIÁ!\n");
            frmGia.setBackground(Color.yellow);
            frmGia.requestFocus();
        }
        else{
            frmGia.setBackground(Color.white);
            
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaHoaDon = new javax.swing.JLabel();
        txtMatour = new javax.swing.JTextField();
        lblMaHoaDon1 = new javax.swing.JLabel();
        txtTentour = new javax.swing.JTextField();
        lblMaHoaDon2 = new javax.swing.JLabel();
        dcTG = new com.toedter.calendar.JDateChooser();
        lblTour = new javax.swing.JLabel();
        cboPT = new javax.swing.JComboBox<>();
        lblTour1 = new javax.swing.JLabel();
        cbopKS = new javax.swing.JComboBox<>();
        lblTour2 = new javax.swing.JLabel();
        cboDV = new javax.swing.JComboBox<>();
        lblMaHoaDon3 = new javax.swing.JLabel();
        txtDiaDiem = new javax.swing.JTextField();
        lblMaHoaDon4 = new javax.swing.JLabel();
        txtghichu = new javax.swing.JTextField();
        lblMaHoaDon5 = new javax.swing.JLabel();
        frmGia = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltour = new javax.swing.JTable();
        btnThem = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnLuu = new javax.swing.JLabel();
        btnHuy = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JLabel();
        btnThoat1 = new javax.swing.JLabel();
        lblTour3 = new javax.swing.JLabel();
        cboKS = new javax.swing.JComboBox<>();
        btnThoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOUR");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, 50));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 80, 10));

        lblMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon.setText("MÃ TOUR:");
        jPanel2.add(lblMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 180, 30));
        jPanel2.add(txtMatour, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 330, 40));

        lblMaHoaDon1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaHoaDon1.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon1.setText("THỜI GIAN:");
        jPanel2.add(lblMaHoaDon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 180, 30));
        jPanel2.add(txtTentour, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 330, 40));

        lblMaHoaDon2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaHoaDon2.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon2.setText("TÊN TOUR:");
        jPanel2.add(lblMaHoaDon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 180, 30));
        jPanel2.add(dcTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 330, 40));

        lblTour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTour.setForeground(new java.awt.Color(255, 255, 255));
        lblTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTour.setText("PHƯƠNG TIỆN: ");
        jPanel2.add(lblTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 120, 200, 30));

        jPanel2.add(cboPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, 330, 40));

        lblTour1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTour1.setForeground(new java.awt.Color(255, 255, 255));
        lblTour1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTour1.setText("PHÒNG KHÁCH SẠN:");
        jPanel2.add(lblTour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 250, 30));

        jPanel2.add(cbopKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 330, 40));

        lblTour2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTour2.setForeground(new java.awt.Color(255, 255, 255));
        lblTour2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTour2.setText("DỊCH VỤ:");
        jPanel2.add(lblTour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 140, 30));

        jPanel2.add(cboDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 330, 40));

        lblMaHoaDon3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaHoaDon3.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon3.setText("ĐỊA ĐIỂM:");
        jPanel2.add(lblMaHoaDon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 180, 30));
        jPanel2.add(txtDiaDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 330, 40));

        lblMaHoaDon4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaHoaDon4.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon4.setText("GIÁ:");
        jPanel2.add(lblMaHoaDon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 180, 30));
        jPanel2.add(txtghichu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 440, 330, 40));

        lblMaHoaDon5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaHoaDon5.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon5.setText("GHI CHÚ:");
        jPanel2.add(lblMaHoaDon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 180, 30));
        jPanel2.add(frmGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 350, 330, 40));

        tbltour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Tour", "Tên Tour", "Thời gian", "Phòng khách sạn", "Dịch vụ", "Phương tiện", "Địa điểm", "Giá", "Ghi chú"
            }
        ));
        tbltour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltourMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltour);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1370, 230));

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
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 100, 40));

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
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 100, 40));

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
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 90, 40));

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
        jPanel2.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 100, 40));

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
        jPanel2.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 110, 40));

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
        jPanel2.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 310, 40));

        btntimkiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_search_white_24dp.png"))); // NOI18N
        btntimkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(btntimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 40, 40));

        btnThoat1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_disabled_by_default_white_24dp.png"))); // NOI18N
        btnThoat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoat1MouseClicked(evt);
            }
        });
        jPanel2.add(btnThoat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 0, 30, 30));

        lblTour3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTour3.setForeground(new java.awt.Color(255, 255, 255));
        lblTour3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTour3.setText("KHÁCH SẠN:");
        jPanel2.add(lblTour3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 250, 30));

        cboKS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKSItemStateChanged(evt);
            }
        });
        jPanel2.add(cboKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 330, 40));

        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnThoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        jPanel2.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        // TODO add your handling code here:
        txtMatour.setText("");
        txtTentour.setText("");
        dcTG.setDate(null);
        txtDiaDiem.setText("");
        frmGia.setText("");
        txtghichu.setText("");
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        txtTentour.requestFocus();
        tbltour.removeAll();
        tablemodel.setRowCount(0);
        loadT();
    }//GEN-LAST:event_btnHuyMouseClicked

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThoat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoat1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoat1MouseClicked

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        if(them){
           if(KiemTraDL()){
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
               try {
                   String tentour =txtTentour.getText();
                   String thoigian=dateFormat.format(dcTG.getDate());
                   TblPhongkhachsan pks= (TblPhongkhachsan) cbopKS.getSelectedItem();
                            String mapks=String.valueOf(pks.getMaphongks());
                   TblDichvu dv= (TblDichvu) cboDV.getSelectedItem();
                            String madv=String.valueOf(dv.getMadv());
                   TblPhuongtien pt= (TblPhuongtien) cboPT.getSelectedItem();
                            String mapt=String.valueOf(pt.getMaphuongtien());
                   String diadiem =txtDiaDiem.getText();
                   Float gia= Float.parseFloat(frmGia.getText());
                   String ghichu =txtghichu.getText();
                   Connection conn= dao.getConnect();
                   
                   String caulenh="INSERT INTO tbl_tour VALUES (null,'"+tentour+"','"+thoigian+"','"+mapks+"','"+madv+"','"+mapt+"','"+diadiem+"','"+gia+"','"+ghichu+"')";
                   boolean a= dao.Lenh(caulenh, conn);
                   if(a){
                       tbltour.removeAll();
                       tablemodel.setRowCount(0);
                       loadT();
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
                Integer MaTour=Integer.parseInt(txtMatour.getText());
                String tentour =txtTentour.getText();
                   String thoigian=dateFormat.format(dcTG.getDate());
                   TblPhongkhachsan pks= (TblPhongkhachsan) cbopKS.getSelectedItem();
                            String mapks=String.valueOf(pks.getMaphongks());
                   TblDichvu dv= (TblDichvu) cboDV.getSelectedItem();
                            String madv=String.valueOf(dv.getMadv());
                   TblPhuongtien pt= (TblPhuongtien) cboPT.getSelectedItem();
                            String mapt=String.valueOf(pt.getMaphuongtien());
                   String diadiem =txtDiaDiem.getText();
                   Float gia= Float.parseFloat(frmGia.getText());
                   String ghichu =txtghichu.getText();
                   Connection conn= dao.getConnect();
                String caulenh="UPDATE tbl_tour SET tentour='"+tentour+"',thoigian='"+thoigian+"',maphongks='"+mapks+"',madv='"+madv+"',maphuongtien='"+mapt+"',diadiem='"+diadiem+"',gia='"+gia+"',ghichu='"+ghichu+"'where matour="+MaTour;
                boolean a= dao.Lenh(caulenh, conn);
                if(a){
                    tbltour.removeAll();
                    tablemodel.setRowCount(0);
                    loadT();
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

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        them=true;
        sua=false;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnThemMouseClicked

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
                    Integer MaTour= Integer.parseInt(txtMatour.getText());
                    Connection conn= dao.getConnect();
                    String caulenh="DELETE FROM tbl_tour WHERE matour="+MaTour;
                    boolean a= dao.Lenh(caulenh, conn);
                    if(a){
                        tbltour.removeAll();
                        tablemodel.setRowCount(0);
                        loadT();
                        JOptionPane.showMessageDialog(this, "XÓA THÀNH CÔNG!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{ 
                        JOptionPane.showMessageDialog(this, "XÓA KHÔNG THÀNH CÔNG!","Thông báo",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                   
                }
            }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void tbltourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltourMouseClicked
        // TODO add your handling code here:
        int i= tbltour.getSelectedRow();
        hienThi(i);
    }//GEN-LAST:event_tbltourMouseClicked

    private void cboKSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKSItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            TblKhachsan ks = (TblKhachsan) cboKS.getSelectedItem();
            long maks = ks.getMaks();
            loadPhong(maks);           
        }
    }//GEN-LAST:event_cboKSItemStateChanged

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatMouseClicked
    void hienThi(int i){
        TableModel model= tbltour.getModel();
        txtMatour.setText(model.getValueAt(i,0).toString());
        txtTentour.setText(model.getValueAt(i,1).toString());
        Date date =null;
        try{
            date =new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i,2).toString());
        } catch (ParseException ex) {
            Logger.getLogger(DatTour.class.getName()).log(Level.SEVERE, null, ex);
        }
        dcTG.setDate(date);
        
        String cbosubKS=model.getValueAt(i, 3).toString();
        for(int j=0;j<cbopKS.getItemCount();j++){
            if(cbopKS.getItemAt(j).toString().equalsIgnoreCase(cbosubKS)){
                cbopKS.setSelectedIndex(j);
            }
        }
        String cbosubDV=model.getValueAt(i, 4).toString();
        for(int j=0;j<cboDV.getItemCount();j++){
            if(cboDV.getItemAt(j).toString().equalsIgnoreCase(cbosubDV)){
                cboDV.setSelectedIndex(j);
            }
        }
        String cbosubPT=model.getValueAt(i, 5).toString();
        for(int j=0;j<cboPT.getItemCount();j++){
            if(cboPT.getItemAt(j).toString().equalsIgnoreCase(cbosubPT)){
                cboPT.setSelectedIndex(j);
            }
        }
        txtDiaDiem.setText(model.getValueAt(i,6).toString());
        frmGia.setText(model.getValueAt(i,7).toString());
        txtghichu.setText(model.getValueAt(i,8).toString());
    }
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
            java.util.logging.Logger.getLogger(Tour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnHuy;
    private javax.swing.JLabel btnLuu;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnThoat1;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btntimkiem;
    private javax.swing.JComboBox<TblDichvu> cboDV;
    private javax.swing.JComboBox<TblKhachsan> cboKS;
    private javax.swing.JComboBox<TblPhuongtien> cboPT;
    private javax.swing.JComboBox<TblPhongkhachsan> cbopKS;
    private com.toedter.calendar.JDateChooser dcTG;
    private javax.swing.JFormattedTextField frmGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaHoaDon1;
    private javax.swing.JLabel lblMaHoaDon2;
    private javax.swing.JLabel lblMaHoaDon3;
    private javax.swing.JLabel lblMaHoaDon4;
    private javax.swing.JLabel lblMaHoaDon5;
    private javax.swing.JLabel lblTour;
    private javax.swing.JLabel lblTour1;
    private javax.swing.JLabel lblTour2;
    private javax.swing.JLabel lblTour3;
    private javax.swing.JTable tbltour;
    private javax.swing.JTextField txtDiaDiem;
    private javax.swing.JTextField txtMatour;
    private javax.swing.JTextField txtTentour;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtghichu;
    // End of variables declaration//GEN-END:variables
}
