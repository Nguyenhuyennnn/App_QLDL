/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Dao;
import Controller.UrlKN;
import Controller.XLDL;
import csdl.TblChitietdiemdanh;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static kabitalib.util.Utilitas.dateFormat;

/**
 *
 * @author Administrator
 */
public class Diemdanh extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL ddnvdl;
    UrlKN url;
    Dao dao;
    
    
    public Diemdanh() {
        initComponents();
        ddnvdl=new XLDL();
       
        url=new UrlKN();
        dao= new Dao(url.knURL());
        Date dt = new Date();
        String ngay = dateFormat.format(dt);
        loaddiemdanh(ngay);
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    static Date today = new Date();
    
    void loaddiemdanh(String ngay){
        ArrayList<TblChitietdiemdanh>list;
        try{
        list = ddnvdl.getListdd(ngay);
        tablemodel = (DefaultTableModel) tblDiemDanh.getModel();
        for(TblChitietdiemdanh dd : list){
            tablemodel.addRow(new Object[]{dd.getMadd(), dd.getManv(), dd.getNgay(), dd.getGiovao(), dd.getGiora(), dd.getTrangthai(), dd.getGhichu()});
        }
        }catch(SQLException ex){
            
        }
    }
    void loadLN(){
        ArrayList<TblChitietdiemdanh>list;
        try{
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        String ngay=dateFormat.format(dcDiemDanh.getDate());
        list = ddnvdl.getListdiemdanh(ngay);
        tablemodel = (DefaultTableModel) tblDiemDanh.getModel();
        for(TblChitietdiemdanh dd : list){
            tablemodel.addRow(new Object[]{dd.getMadd(), dd.getHotennv(), dd.getNgay(), dd.getGiovao(), dd.getGiora(), dd.getTrangthai(), dd.getGhichu()});
        }
        }catch(SQLException ex){
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiemDanh = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        dcDiemDanh = new com.toedter.calendar.JDateChooser();
        btnQuetMa = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnLoc = new javax.swing.JLabel();
        btnThoat = new javax.swing.JLabel();
        btnsau = new javax.swing.JLabel();
        btnTruoc = new javax.swing.JLabel();
        btnhientai = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDiemDanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã điểm danh", "Mã nhân viên", "Ngày", "Giờ vào", "Giờ ra", "Trạng thái", "Ghi chú"
            }
        ));
        tblDiemDanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemDanhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDiemDanh);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1370, 350));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1370, 10));
        jPanel1.add(dcDiemDanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 310, 50));

        btnQuetMa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnQuetMa.setForeground(new java.awt.Color(255, 255, 255));
        btnQuetMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnQuetMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_qr_code_scanner_white_24dp.png"))); // NOI18N
        btnQuetMa.setText("QUÉT MÃ");
        btnQuetMa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQuetMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuetMaMouseClicked(evt);
            }
        });
        jPanel1.add(btnQuetMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 610, 180, 50));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1370, 10));

        btnLoc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 255, 255));
        btnLoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_filter_alt_white_24dp.png"))); // NOI18N
        btnLoc.setText("LỌC");
        btnLoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLocMouseClicked(evt);
            }
        });
        jPanel1.add(btnLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 70, 100, 50));

        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnThoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 40));

        btnsau.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnsau.setForeground(new java.awt.Color(255, 255, 255));
        btnsau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnsau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_arrow_forward_white_24dp.png"))); // NOI18N
        btnsau.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnsau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsauMouseClicked(evt);
            }
        });
        jPanel1.add(btnsau, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 50, 40));

        btnTruoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnTruoc.setForeground(new java.awt.Color(255, 255, 255));
        btnTruoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_arrow_back_white_24dp.png"))); // NOI18N
        btnTruoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTruocMouseClicked(evt);
            }
        });
        jPanel1.add(btnTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 50, 40));

        btnhientai.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnhientai.setForeground(new java.awt.Color(255, 255, 255));
        btnhientai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnhientai.setText("ll");
        btnhientai.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnhientai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhientaiMouseClicked(evt);
            }
        });
        jPanel1.add(btnhientai, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 60, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH ĐIỂM DANH");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 460, 60));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 290, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuetMaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuetMaMouseClicked
        // TODO add your handling code here:
        QuetMa qm= new QuetMa();
        qm.setVisible(true);
    }//GEN-LAST:event_btnQuetMaMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatMouseClicked

    private void tblDiemDanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemDanhMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblDiemDanhMouseClicked

    private void btnLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLocMouseClicked
        // TODO add your handling code here:
         try {
             tablemodel.setRowCount(0);
             tblDiemDanh.removeAll();
             loadLN();
           
        } catch (Exception e) {
             loadLN();
        }
    }//GEN-LAST:event_btnLocMouseClicked

    private void btnTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTruocMouseClicked
        // TODO add your handling code here:
        Date tomorrow = new Date(today.getTime() - (1000 * 60 * 60 * 24));
        today = tomorrow;
        String ngay = dateFormat.format(tomorrow);
        try {
            tblDiemDanh.removeAll();
            tablemodel.setRowCount(0);
            loaddiemdanh(ngay);
        } catch (Exception e) {
          
            loaddiemdanh(ngay);
        }
    }//GEN-LAST:event_btnTruocMouseClicked

    private void btnhientaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhientaiMouseClicked
        // TODO add your handling code here:
        try {
            tblDiemDanh.removeAll();
            tablemodel.setRowCount(0);
            today = new Date();
            String ngay = dateFormat.format(today);
            loaddiemdanh(ngay);
        } catch (Exception e) {
            today = new Date();
            String ngay = dateFormat.format(today);
            loaddiemdanh(ngay);
        }
        
    }//GEN-LAST:event_btnhientaiMouseClicked

    private void btnsauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsauMouseClicked
        // TODO add your handling code here:
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        today = tomorrow;
        String ngay = dateFormat.format(tomorrow);
          try {
            tblDiemDanh.removeAll();
            tablemodel.setRowCount(0);
            loaddiemdanh(ngay);
        } catch (Exception e) {
          
            loaddiemdanh(ngay);
        }
    }//GEN-LAST:event_btnsauMouseClicked

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
            java.util.logging.Logger.getLogger(Diemdanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diemdanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diemdanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diemdanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diemdanh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLoc;
    private javax.swing.JLabel btnQuetMa;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnTruoc;
    private javax.swing.JLabel btnhientai;
    private javax.swing.JLabel btnsau;
    private com.toedter.calendar.JDateChooser dcDiemDanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tblDiemDanh;
    // End of variables declaration//GEN-END:variables
}
