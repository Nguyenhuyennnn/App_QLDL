/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dao;
import Controller.UrlKN;
import Controller.XLDL;
import csdl.TblKhachhang;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ThemKH extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL khdl;
    UrlKN url;
    Dao dao;
    DsKhachHang KH;
    /**
     * Creates new form ThemKH
     */
    public ThemKH() {
        initComponents();
        setLocationRelativeTo(null);
        khdl=new XLDL();
        url=new UrlKN();
        dao= new Dao(url.knURL());
        KH =new DsKhachHang();
    }
    private boolean KiemTraDL() throws HeadlessException{
        StringBuilder sb= new StringBuilder();
        
        if(txtHoTen.getText().equals("")){
            sb.append("VUI LÒNG CHO BIẾT HỌ TÊN!\n");
            txtHoTen.setBackground(Color.yellow);
            txtHoTen.requestFocus();
        }
        else{
            txtHoTen.setBackground(Color.white);
            
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
        if(cboLoai.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN LOẠI!\n");
            cboLoai.setBackground(Color.yellow);
            cboLoai.requestFocus();
        }
        else{
            cboLoai.setBackground(Color.white);
            
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
        pnHinhAnh = new javax.swing.JPanel();
        lblanh = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblGioiTinh = new javax.swing.JLabel();
        cboLoai = new javax.swing.JComboBox<>();
        lblCMND = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblHinhAnh = new javax.swing.JLabel();
        txtHinhAnh = new javax.swing.JTextField();
        lblLoai = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JLabel();
        btnload = new javax.swing.JLabel();
        btnThoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM KHÁCH HÀNG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 370, 60));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 250, 10));

        pnHinhAnh.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnHinhAnhLayout = new javax.swing.GroupLayout(pnHinhAnh);
        pnHinhAnh.setLayout(pnHinhAnhLayout);
        pnHinhAnhLayout.setHorizontalGroup(
            pnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );
        pnHinhAnhLayout.setVerticalGroup(
            pnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        jPanel1.add(pnHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblMaKH.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMaKH.setForeground(new java.awt.Color(255, 255, 255));
        lblMaKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaKH.setText("MÃ KHÁCH HÀNG:");
        jPanel1.add(lblMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, 40));
        jPanel1.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 350, 50));

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoTen.setText("HỌ TÊN:");
        jPanel1.add(lblHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 160, 40));
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 350, 50));

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(255, 255, 255));
        lblGioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGioiTinh.setText("GIỚI TÍNH:");
        jPanel1.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 150, 40));

        cboLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIP", "Thường" }));
        jPanel1.add(cboLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, 350, 50));

        lblCMND.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCMND.setForeground(new java.awt.Color(255, 255, 255));
        lblCMND.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCMND.setText("CMND:");
        jPanel1.add(lblCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 100, 40));
        jPanel1.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 350, 50));

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        lblDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDiaChi.setText("ĐỊA CHỈ:");
        jPanel1.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 120, 30));
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 350, 50));

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSDT.setForeground(new java.awt.Color(255, 255, 255));
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSDT.setText("SĐT:");
        jPanel1.add(lblSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 120, 30));
        jPanel1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, 350, 50));

        lblHinhAnh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHinhAnh.setForeground(new java.awt.Color(255, 255, 255));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHinhAnh.setText("HÌNH ẢNH:");
        jPanel1.add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, 180, 30));
        jPanel1.add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, 240, 50));

        lblLoai.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLoai.setForeground(new java.awt.Color(255, 255, 255));
        lblLoai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoai.setText("LOẠI:");
        jPanel1.add(lblLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, 110, 30));

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel1.add(cboGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 350, 50));

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
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 630, 130, 50));

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
        jPanel1.add(btnload, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 530, 110, 50));

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

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:

        if(KiemTraDL()){

            try {
                String hotenkh= txtHoTen.getText();
                String gioitinh= cboGioiTinh.getSelectedItem().toString();
                String cmnd= txtCMND.getText();
                String diachi= txtDiaChi.getText();
                String sdt= txtSDT.getText();
                String loai= cboLoai.getSelectedItem().toString();
                String hinhanh= tenFile;

                Connection conn= dao.getConnect();

                String caulenh="INSERT INTO tbl_khachhang VALUES (null,'"+hotenkh+"','"+gioitinh+"','"+cmnd+"','"+diachi+"','"+sdt+"','"+loai+"','"+hinhanh+"')";
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

    }//GEN-LAST:event_btnLuuMouseClicked
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
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLuu;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnload;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblanh;
    private javax.swing.JPanel pnHinhAnh;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHinhAnh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
