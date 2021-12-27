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
import static View.ThemKH.tenFile;
import csdl.TblNhanvien;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class thongTinNV extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL khdl;
    UrlKN url;
    Dao dao;
    DsNhanVien NV;
    KNCSDL kn;
    /**
     * Creates new form thongTinNV
     */
    public thongTinNV(String Manv) {
        initComponents();
        setLocationRelativeTo(null);
        khdl=new XLDL();
        url=new UrlKN();
        dao= new Dao(url.knURL());
        NV =new DsNhanVien();
        manv=Manv;
        kn= new KNCSDL();
        getListNV();
        txtHinhanh.setEnabled(false);
    }
    public static String manv;
    public void getListNV() {
        ArrayList<TblNhanvien> listKH = new ArrayList<>();
        listKH.clear();
        Connection conn;
        try {
            conn = kn.getConnect();
            String sql = "SELECT *FROM tbl_nhanvien WHERE manv = "+manv;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            String src = "src/IMG/"+result.getString(11);
            loadanh(lblanh, src);
            txtMaNV.setText(result.getLong(1)+"");
            txtHoTen.setText(result.getString(2));
            dcNgaySinh.setDate(result.getDate(3));
            cboGT.setSelectedItem(result.getString(4));
            txtCMND.setText(result.getString(5));
            txtDiaChi.setText(result.getString(6));
            txtSDT.setText(result.getString(7));
            dcNgayVaoLam.setDate(result.getDate(8));
            txtPTC.setText(result.getString(9));
            txtMaCV.setText(result.getString(10));
            txtHinhanh.setText(result.getString(11));
            
        }
        } catch (SQLException ex) {
           
        }
        
    }
    void loadanh(JLabel lbl, String fileanh){
        ImageIcon icon= new ImageIcon(fileanh);
        Image image=icon.getImage().getScaledInstance(lbl.getWidth(),lbl.getHeight(),Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
        
    }
    private boolean KiemTraDL() throws HeadlessException{
        StringBuilder sb= new StringBuilder();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        if(txtHoTen.getText().equals("")){
            sb.append("VUI LÒNG CHO BIẾT HỌ TÊN!\n");
            txtHoTen.setBackground(Color.yellow);
            txtHoTen.requestFocus();
        }
        else{
            txtHoTen.setBackground(Color.white);
            
        }
        if(dcNgaySinh.equals("")){
            sb.append("VUI LÒNG CHO BIẾT NGÀY SINH!\n");
            dcNgaySinh.setBackground(Color.yellow);
            dcNgaySinh.requestFocus();
        }
        else{
            dcNgaySinh.setBackground(Color.white);
            
        }
        if(cboGT.equals("")){
            sb.append("VUI LÒNG CHỌN GIỚI TÍNH!\n");
            cboGT.setBackground(Color.yellow);
            cboGT.requestFocus();
        }
        else{
            cboGT.setBackground(Color.white);
            
        }
        if(txtCMND.getText().equals("")){
            sb.append("VUI LÒNG CUNG CẤP CMND!\n");
            txtCMND.setBackground(Color.yellow);
            txtCMND.requestFocus();
        }
        else{
            txtCMND.setBackground(Color.white);
            
        }
        if(txtDiaChi.getText().equals("")){
            sb.append("VUI LÒNG CHO BIẾT ĐỊA CHỈ!\n");
            txtDiaChi.setBackground(Color.yellow);
            txtDiaChi.requestFocus();
        }
        else{
            txtDiaChi.setBackground(Color.white);
            
        }
        if(txtSDT.getText().equals("")){
            sb.append("VUI LÒNG CUNG CẤP SĐT!\n");
            txtSDT.setBackground(Color.yellow);
            txtSDT.requestFocus();
        }
        else{
            txtSDT.setBackground(Color.white);
            
        }
        if(dcNgayVaoLam.equals("")){
            sb.append("VUI LÒNG CHO BIẾT NGÀY VÀO LÀM!\n");
            dcNgayVaoLam.setBackground(Color.yellow);
            dcNgayVaoLam.requestFocus();
        }
        else{
            dcNgayVaoLam.setBackground(Color.white);
            
        }
        
        if(txtPTC.equals("")){
            sb.append("VUI LÒNG CHỌN PHÒNG TỔ CHỨC!\n");
            txtPTC.setBackground(Color.yellow);
            txtPTC.requestFocus();
        }
        else{
            txtPTC.setBackground(Color.white);
            
        }
        if(txtMaCV.equals("")){
            sb.append("VUI LÒNG CHỌN CHỨC VỤ!\n");
            txtMaCV.setBackground(Color.yellow);
            txtMaCV.requestFocus();
        }
        else{
            txtMaCV.setBackground(Color.white);
            
        }
        if(txtHinhanh.getText().equals("")){
            sb.append("VUI LÒNG CUNG CẤP HÌNH ẢNH!\n");
            txtHinhanh.setBackground(Color.yellow);
            txtHinhanh.requestFocus();
        }
        else{
            txtHinhanh.setBackground(Color.white);
            
        }
        if(sb.length()>0){
            JOptionPane.showConfirmDialog(this, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
        
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblanh = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblNgaySinh = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblCMND = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblPTC = new javax.swing.JLabel();
        txtPTC = new javax.swing.JTextField();
        lblMaCV = new javax.swing.JLabel();
        txtMaCV = new javax.swing.JTextField();
        btnSua = new javax.swing.JLabel();
        dcNVL = new javax.swing.JLabel();
        lblhinhanh = new javax.swing.JLabel();
        txtHinhanh = new javax.swing.JTextField();
        dcNgaySinh = new com.toedter.calendar.JDateChooser();
        dcNgayVaoLam = new com.toedter.calendar.JDateChooser();
        btnload = new javax.swing.JLabel();
        cboGT = new javax.swing.JComboBox<>();
        btnThoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 340, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 230));

        lblMaNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(255, 255, 255));
        lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaNV.setText("MÃ NV:");
        jPanel1.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 100, 40));
        jPanel1.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 330, 50));

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoTen.setText("HỌ TÊN:");
        jPanel1.add(lblHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 110, 40));
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 330, 50));

        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        lblNgaySinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgaySinh.setText("NGÀY SINH:");
        jPanel1.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 180, 40));

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(255, 255, 255));
        lblGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGioiTinh.setText("GIỚI TÍNH:");
        jPanel1.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 180, 40));

        lblCMND.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCMND.setForeground(new java.awt.Color(255, 255, 255));
        lblCMND.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCMND.setText("CMND:");
        jPanel1.add(lblCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 140, 40));
        jPanel1.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, 330, 50));

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        lblDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDiaChi.setText("ĐỊA CHỈ:");
        jPanel1.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 590, 120, 40));
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, 330, 50));

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSDT.setForeground(new java.awt.Color(255, 255, 255));
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSDT.setText("SĐT:");
        jPanel1.add(lblSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 120, 40));
        jPanel1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 330, 50));

        lblPTC.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPTC.setForeground(new java.awt.Color(255, 255, 255));
        lblPTC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPTC.setText("PHÒNG TỔ CHỨC:");
        jPanel1.add(lblPTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 220, 40));
        jPanel1.add(txtPTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, 330, 50));

        lblMaCV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaCV.setForeground(new java.awt.Color(255, 255, 255));
        lblMaCV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaCV.setText("MÃ CHỨC VỤ:");
        jPanel1.add(lblMaCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 190, 40));
        jPanel1.add(txtMaCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, 330, 50));

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
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 620, 100, 40));

        dcNVL.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dcNVL.setForeground(new java.awt.Color(255, 255, 255));
        dcNVL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dcNVL.setText("NGÀY VÀO LÀM:");
        jPanel1.add(dcNVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 220, 40));

        lblhinhanh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblhinhanh.setForeground(new java.awt.Color(255, 255, 255));
        lblhinhanh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblhinhanh.setText("HÌNH ẢNH:");
        jPanel1.add(lblhinhanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 490, 190, 40));
        jPanel1.add(txtHinhanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, 220, 50));
        jPanel1.add(dcNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 330, 50));
        jPanel1.add(dcNgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 330, 50));

        btnload.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnload.setForeground(new java.awt.Color(255, 255, 255));
        btnload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnload.setText("Tải ảnh");
        btnload.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnloadMouseClicked(evt);
            }
        });
        jPanel1.add(btnload, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 530, 110, 50));

        cboGT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel1.add(cboGT, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 330, 50));

        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnThoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
        if(KiemTraDL()){
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
            try{
                Integer Manv= Integer.parseInt(txtMaNV.getText());
                String hotenNV= txtHoTen.getText().toString();
                String ngaysinh=dateFormat.format(dcNgaySinh.getDate());
                String gioitinh= cboGT.getSelectedItem().toString();
                String CMND= txtCMND.getText().toString();
                String Diachi= txtDiaChi.getText().toString();
                String sdt= txtSDT.getText().toString();
                String ngayvaolam=dateFormat.format(dcNgayVaoLam.getDate());
                String maptc = txtPTC.getText().toString();
                String macv = txtMaCV.getText().toString();
                String hinhanh= txtHinhanh.getText().toString();
                   
                Connection conn= dao.getConnect();
                String caulenh="UPDATE tbl_nhanvien SET hotennv='"+hotenNV+"',ngaysinh='"+ngaysinh+"',gioitinh='"+gioitinh+"',cmnd='"+CMND+"',diachi='"+Diachi+"',sdt='"+sdt+"',ngayvaolam='"+ngayvaolam+"',maptc='"+maptc+"',macv='"+macv+"',hinhanh='"+hinhanh+"'where manv="+Manv;
                boolean a= dao.Lenh(caulenh, conn);
                if(a){
                    
                    JOptionPane.showMessageDialog(this, "SỬA THÀNH CÔNG!","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "SỬA KHÔNG THÀNH CÔNG!","Thông báo",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                
            }
        }
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloadMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser= new JFileChooser();
        chooser.showOpenDialog(null);
        File f= chooser.getSelectedFile();

        loadanh(lblanh, f.toString());
        String fileName=f.getAbsolutePath();
        String newPath="src/IMG/";
        File diretory= new File(newPath);
        if(!diretory.exists()){
            diretory.mkdirs();
        }
        File sourceFile=null;
        File destinationFile=null;
        String extension= fileName.substring(fileName.lastIndexOf('\\')+1);
        sourceFile=new File(fileName);
        destinationFile=new File(newPath+extension);
        tenFile=extension;

        try{
            Files.copy(sourceFile.toPath(),destinationFile.toPath());

        }catch(IOException ex){

        }
        txtHinhanh.setText(tenFile);
    }//GEN-LAST:event_btnloadMouseClicked

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
            java.util.logging.Logger.getLogger(thongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongTinNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongTinNV(manv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnload;
    private javax.swing.JComboBox<String> cboGT;
    private javax.swing.JLabel dcNVL;
    private com.toedter.calendar.JDateChooser dcNgaySinh;
    private com.toedter.calendar.JDateChooser dcNgayVaoLam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaCV;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblPTC;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblanh;
    private javax.swing.JLabel lblhinhanh;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHinhanh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaCV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtPTC;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
