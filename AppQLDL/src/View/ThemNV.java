/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dao;
import Controller.UrlKN;
import Controller.XLDL;
import csdl.TblChucvu;
import csdl.TblPhongtochuc;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
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
public class ThemNV extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL nvdl;
    UrlKN url;
    Dao dao;
    DsNhanVien NV;
    /**
     * Creates new form ThemNV
     */
    public ThemNV() {
        initComponents();
        setLocationRelativeTo(null);
        nvdl=new XLDL();
        url=new UrlKN();
        dao= new Dao(url.knURL());
        NV =new DsNhanVien();
        loadPTC();
        loadCV();
    }

    
    void loadPTC(){
        try{
            ArrayList<TblPhongtochuc> PTC=nvdl.getListPTC();
            for(TblPhongtochuc ptc:PTC){
                cboPTC.addItem(ptc);
            }
        }catch(Exception ex){
            
        }
    }
    void loadCV(){
        try{
            ArrayList<TblChucvu> CV= nvdl.getListCV();
            for(TblChucvu cv:CV){
                cboMaCV.addItem(cv);
            }
        }catch(Exception ex){
            
        }
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
        if(cboGioiTinh.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN GIỚI TÍNH!\n");
            cboGioiTinh.setBackground(Color.yellow);
            cboGioiTinh.requestFocus();
        }
        else{
            cboGioiTinh.setBackground(Color.white);
            
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
        
        if(cboPTC.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN PHÒNG TỔ CHỨC!\n");
            cboPTC.setBackground(Color.yellow);
            cboPTC.requestFocus();
        }
        else{
            cboPTC.setBackground(Color.white);
            
        }
        if(cboMaCV.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN CHỨC VỤ!\n");
            cboMaCV.setBackground(Color.yellow);
            cboMaCV.requestFocus();
        }
        else{
            cboPTC.setBackground(Color.white);
            
        }
        if(txtHinhAnh.getText().equals("")){
            sb.append("VUI LÒNG CUNG CẤP HÌNH ẢNH!\n");
            txtHinhAnh.setBackground(Color.yellow);
            txtHinhAnh.requestFocus();
        }
        else{
            txtHinhAnh.setBackground(Color.white);
            
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
        lblMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblCMND = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        dcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblNgaySinh = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        lblMaCV = new javax.swing.JLabel();
        cboMaCV = new javax.swing.JComboBox<>();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblGioiTinh = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        lblDiachi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblPTC = new javax.swing.JLabel();
        cboPTC = new javax.swing.JComboBox<>();
        lblHinhAnh = new javax.swing.JLabel();
        txtHinhAnh = new javax.swing.JTextField();
        btnThem = new javax.swing.JLabel();
        lblNgayVaoLam = new javax.swing.JLabel();
        dcNgayVaoLam = new com.toedter.calendar.JDateChooser();
        btnload = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblanh = new javax.swing.JLabel();
        btnThoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM NHÂN VIÊN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 340, 60));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 210, 10));

        lblMaNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(255, 255, 255));
        lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaNV.setText("MÃ NV:");
        jPanel1.add(lblMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 110, 40));
        jPanel1.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 330, 50));

        lblCMND.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCMND.setForeground(new java.awt.Color(255, 255, 255));
        lblCMND.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCMND.setText("CMND:");
        jPanel1.add(lblCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 140, 40));
        jPanel1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 330, 50));
        jPanel1.add(dcNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 330, 50));

        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        lblNgaySinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgaySinh.setText("NGÀY SINH:");
        jPanel1.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 190, 40));

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSDT.setForeground(new java.awt.Color(255, 255, 255));
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSDT.setText("SĐT:");
        jPanel1.add(lblSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 160, 40));
        jPanel1.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 330, 50));

        lblMaCV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaCV.setForeground(new java.awt.Color(255, 255, 255));
        lblMaCV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaCV.setText("MÃ CHỨC VỤ:");
        jPanel1.add(lblMaCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 190, 40));

        jPanel1.add(cboMaCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, 330, 50));

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoTen.setText("HỌ TÊN:");
        jPanel1.add(lblHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 40));
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 330, 50));

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(255, 255, 255));
        lblGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGioiTinh.setText("GIỚI TÍNH:");
        jPanel1.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 180, 40));

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel1.add(cboGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 330, 50));

        lblDiachi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDiachi.setForeground(new java.awt.Color(255, 255, 255));
        lblDiachi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDiachi.setText("ĐỊA CHỈ:");
        jPanel1.add(lblDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 110, 40));
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, 330, 50));

        lblPTC.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPTC.setForeground(new java.awt.Color(255, 255, 255));
        lblPTC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPTC.setText("PHÒNG TỔ CHỨC:");
        jPanel1.add(lblPTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 220, 40));

        jPanel1.add(cboPTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 330, 50));

        lblHinhAnh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHinhAnh.setForeground(new java.awt.Color(255, 255, 255));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHinhAnh.setText("HÌNH ẢNH:");
        jPanel1.add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 220, 40));
        jPanel1.add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 220, 50));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_save_white_24dp.png"))); // NOI18N
        btnThem.setText("Lưu");
        btnThem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 630, 110, 50));

        lblNgayVaoLam.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNgayVaoLam.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayVaoLam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayVaoLam.setText("NGÀY VÀO LÀM:");
        jPanel1.add(lblNgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 280, 40));
        jPanel1.add(dcNgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, 330, 50));

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
        jPanel1.add(btnload, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, 110, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 240));

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

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        if(KiemTraDL()){
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
               try {
                   
                   String hotenNV= txtHoTen.getText().toString();
                   String ngaysinh=dateFormat.format(dcNgaySinh.getDate());
                   String gioitinh= cboGioiTinh.getSelectedItem().toString();
                   String CMND= txtCMND.getText().toString();
                   String Diachi= txtDiaChi.getText().toString();
                   String sdt= txtSDT.getText().toString();
                   String ngayvaolam=dateFormat.format(dcNgayVaoLam.getDate());
                   TblPhongtochuc ptc= (TblPhongtochuc) cboPTC.getSelectedItem();
                            String maptc = String.valueOf(ptc.getMaptc());
                   TblChucvu cv= (TblChucvu) cboMaCV.getSelectedItem();
                            String macv = String.valueOf(cv.getMacv());
                   String hinhanh= tenFile;
                   
                   Connection conn= dao.getConnect();
                   
                   String caulenh="INSERT INTO tbl_nhanvien VALUES (null,'"+hotenNV+"','"+ngaysinh+"','"+gioitinh+"','"+CMND+"','"+Diachi+"','"+sdt+"','"+ngayvaolam+"','"+maptc+"','"+macv+"','"+hinhanh+"')";
                   boolean a= dao.Lenh(caulenh, conn);
                   if(a){
                       
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
    }//GEN-LAST:event_btnThemMouseClicked
    static String tenFile;
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
        txtHinhAnh.setText(tenFile);
    }//GEN-LAST:event_btnloadMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatMouseClicked
    void loadanh(JLabel lbl, String fileanh){
        ImageIcon icon= new ImageIcon(fileanh);
        Image image=icon.getImage().getScaledInstance(lbl.getWidth(),lbl.getHeight(),Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
        
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
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnload;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<TblChucvu> cboMaCV;
    private javax.swing.JComboBox<TblPhongtochuc> cboPTC;
    private com.toedter.calendar.JDateChooser dcNgaySinh;
    private com.toedter.calendar.JDateChooser dcNgayVaoLam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblDiachi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaCV;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblNgayVaoLam;
    private javax.swing.JLabel lblPTC;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHinhAnh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables

    
}
