/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Administrator
 */
public class heThong extends javax.swing.JInternalFrame {

    /**
     * Creates new form heThong
     */
    public heThong(String quyen) {
        initComponents();
        Quyen=quyen;
        if(quyen.equals("Quản lý")){
            
        }else{
            
            btnNV2.setEnabled(false);
            btnChucvu2.setEnabled(false);
            btnPTC2.setEnabled(false);
            btnKS2.setEnabled(false);
            btnDV2.setEnabled(false);
            btnPhuongtien2.setEnabled(false);
            btntinhluong.setEnabled(false);
            btndiadiem2.setEnabled(false);
            btntour2.setEnabled(false);
            btnThongke3.setEnabled(false);
            btnLH2.setEnabled(false);
            
        }
    }
    static String Quyen;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPTC2 = new javax.swing.JLabel();
        btnChucvu2 = new javax.swing.JLabel();
        btnNV2 = new javax.swing.JLabel();
        btnDiemdanh3 = new javax.swing.JLabel();
        btntinhluong = new javax.swing.JLabel();
        btnPhuongtien2 = new javax.swing.JLabel();
        btnDV2 = new javax.swing.JLabel();
        btnKS2 = new javax.swing.JLabel();
        btndiadiem2 = new javax.swing.JLabel();
        btntour2 = new javax.swing.JLabel();
        btnDattour2 = new javax.swing.JLabel();
        btnLH2 = new javax.swing.JLabel();
        btnThongke3 = new javax.swing.JLabel();
        btnHD2 = new javax.swing.JLabel();
        btnKH2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPTC2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnPTC2.setForeground(new java.awt.Color(255, 255, 255));
        btnPTC2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPTC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_badge_white_24dp.png"))); // NOI18N
        btnPTC2.setText("PHÒNG TỔ CHỨC");
        btnPTC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPTC2MouseClicked(evt);
            }
        });
        jPanel1.add(btnPTC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnChucvu2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnChucvu2.setForeground(new java.awt.Color(255, 255, 255));
        btnChucvu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_account_box_white_24dp.png"))); // NOI18N
        btnChucvu2.setText("CHỨC VỤ");
        btnChucvu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChucvu2MouseClicked(evt);
            }
        });
        jPanel1.add(btnChucvu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        btnNV2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnNV2.setForeground(new java.awt.Color(255, 255, 255));
        btnNV2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNV2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_account_box_white_24dp.png"))); // NOI18N
        btnNV2.setText("NHÂN VIÊN");
        btnNV2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNV2MouseClicked(evt);
            }
        });
        jPanel1.add(btnNV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btnDiemdanh3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDiemdanh3.setForeground(new java.awt.Color(255, 255, 255));
        btnDiemdanh3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDiemdanh3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_calendar_today_white_24dp.png"))); // NOI18N
        btnDiemdanh3.setText("ĐIỂM DANH");
        btnDiemdanh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDiemdanh3MouseClicked(evt);
            }
        });
        jPanel1.add(btnDiemdanh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        btntinhluong.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btntinhluong.setForeground(new java.awt.Color(255, 255, 255));
        btntinhluong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btntinhluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_edit_white_24dp.png"))); // NOI18N
        btntinhluong.setText("TÍNH LƯƠNG");
        btntinhluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntinhluongMouseClicked(evt);
            }
        });
        jPanel1.add(btntinhluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        btnPhuongtien2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnPhuongtien2.setForeground(new java.awt.Color(255, 255, 255));
        btnPhuongtien2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPhuongtien2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_directions_car_white_24dp.png"))); // NOI18N
        btnPhuongtien2.setText("PHƯƠNG TIỆN");
        btnPhuongtien2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPhuongtien2MouseClicked(evt);
            }
        });
        jPanel1.add(btnPhuongtien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        btnDV2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDV2.setForeground(new java.awt.Color(255, 255, 255));
        btnDV2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDV2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_fact_check_white_24dp.png"))); // NOI18N
        btnDV2.setText("DỊCH VỤ");
        btnDV2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDV2MouseClicked(evt);
            }
        });
        jPanel1.add(btnDV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        btnKS2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnKS2.setForeground(new java.awt.Color(255, 255, 255));
        btnKS2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKS2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_home_work_white_24dp.png"))); // NOI18N
        btnKS2.setText("KHÁCH SẠN");
        btnKS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKS2MouseClicked(evt);
            }
        });
        jPanel1.add(btnKS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        btndiadiem2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btndiadiem2.setForeground(new java.awt.Color(255, 255, 255));
        btndiadiem2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btndiadiem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_place_white_24dp.png"))); // NOI18N
        btndiadiem2.setText("ĐỊA ĐIỂM");
        btndiadiem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndiadiem2MouseClicked(evt);
            }
        });
        jPanel1.add(btndiadiem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        btntour2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btntour2.setForeground(new java.awt.Color(255, 255, 255));
        btntour2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btntour2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_map_white_24dp.png"))); // NOI18N
        btntour2.setText("TOUR");
        btntour2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntour2MouseClicked(evt);
            }
        });
        jPanel1.add(btntour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 170, -1));

        btnDattour2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDattour2.setForeground(new java.awt.Color(255, 255, 255));
        btnDattour2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDattour2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_flight_takeoff_white_24dp.png"))); // NOI18N
        btnDattour2.setText("ĐẶT TOUR");
        btnDattour2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDattour2MouseClicked(evt);
            }
        });
        jPanel1.add(btnDattour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, -1));

        btnLH2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnLH2.setForeground(new java.awt.Color(255, 255, 255));
        btnLH2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLH2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_call_white_24dp.png"))); // NOI18N
        btnLH2.setText("LIÊN HỆ");
        btnLH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLH2MouseClicked(evt);
            }
        });
        jPanel1.add(btnLH2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 180, 180, 50));

        btnThongke3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnThongke3.setForeground(new java.awt.Color(255, 255, 255));
        btnThongke3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThongke3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_trending_up_white_24dp.png"))); // NOI18N
        btnThongke3.setText("THỐNG KÊ");
        btnThongke3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongke3MouseClicked(evt);
            }
        });
        jPanel1.add(btnThongke3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 100, -1, 50));

        btnHD2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnHD2.setForeground(new java.awt.Color(255, 255, 255));
        btnHD2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_article_white_24dp.png"))); // NOI18N
        btnHD2.setText("HÓA ĐƠN");
        btnHD2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHD2MouseClicked(evt);
            }
        });
        jPanel1.add(btnHD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, -1, 50));

        btnKH2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnKH2.setForeground(new java.awt.Color(255, 255, 255));
        btnKH2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKH2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_supervisor_account_white_24dp.png"))); // NOI18N
        btnKH2.setText("KHÁCH HÀNG");
        btnKH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKH2MouseClicked(evt);
            }
        });
        jPanel1.add(btnKH2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPTC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPTC2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            PhongToChuc ptc= new PhongToChuc();
            ptc.setVisible(true);
        }
    }//GEN-LAST:event_btnPTC2MouseClicked

    private void btnKS2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKS2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            KhachSan ks= new KhachSan();
            ks.setVisible(true);
        }
        
    }//GEN-LAST:event_btnKS2MouseClicked

    private void btnKH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKH2MouseClicked
        // TODO add your handling code here:
        
        
            DsKhachHang dskh= new DsKhachHang();
            dskh.setVisible(true);
        
    }//GEN-LAST:event_btnKH2MouseClicked

    private void btnHD2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHD2MouseClicked
        // TODO add your handling code here:
        thongtinHD hd= new thongtinHD("");
        hd.setVisible(true);
    }//GEN-LAST:event_btnHD2MouseClicked

    private void btnLH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLH2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            lienhe lh= new lienhe();
            lh.setVisible(true);
        }
    }//GEN-LAST:event_btnLH2MouseClicked

    private void btnDattour2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDattour2MouseClicked
        // TODO add your handling code here:
        DatTour dt= new DatTour("");
        dt.setVisible(true);
    }//GEN-LAST:event_btnDattour2MouseClicked

    private void btntour2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntour2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            Tour t= new Tour();
        t.setVisible(true);
        }
    }//GEN-LAST:event_btntour2MouseClicked

    private void btndiadiem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndiadiem2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            DiaDiem diadiem= new DiaDiem();
        diadiem.setVisible(true);
        }
    }//GEN-LAST:event_btndiadiem2MouseClicked

    private void btnDV2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDV2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            DVDuLich dv= new DVDuLich();
            dv.setVisible(true);
        }
    }//GEN-LAST:event_btnDV2MouseClicked

    private void btnPhuongtien2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPhuongtien2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            PhuongTien pt= new PhuongTien();
            pt.setVisible(true);
        }
    }//GEN-LAST:event_btnPhuongtien2MouseClicked

    private void btntinhluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntinhluongMouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            TinhLuong tl= new TinhLuong();
            tl.setVisible(true);
        }
    }//GEN-LAST:event_btntinhluongMouseClicked

    private void btnDiemdanh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiemdanh3MouseClicked
        // TODO add your handling code here:
        Diemdanh dd= new Diemdanh();
        dd.setVisible(true);
    }//GEN-LAST:event_btnDiemdanh3MouseClicked

    private void btnNV2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNV2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            DsNhanVien nv= new DsNhanVien();
            nv.setVisible(true);
        }
    }//GEN-LAST:event_btnNV2MouseClicked

    private void btnChucvu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChucvu2MouseClicked
        // TODO add your handling code here:
        
        if(Quyen.equals("Quản lý")){
            ChucVu cv= new ChucVu();
            cv.setVisible(true);
        }
    }//GEN-LAST:event_btnChucvu2MouseClicked

    private void btnThongke3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongke3MouseClicked
        // TODO add your handling code here:
         if(Quyen.equals("Quản lý")){
            thongKe tk= new thongKe();
            tk.setVisible(true);
        }
    }//GEN-LAST:event_btnThongke3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnChucvu2;
    private javax.swing.JLabel btnDV2;
    private javax.swing.JLabel btnDattour2;
    private javax.swing.JLabel btnDiemdanh3;
    private javax.swing.JLabel btnHD2;
    private javax.swing.JLabel btnKH2;
    private javax.swing.JLabel btnKS2;
    private javax.swing.JLabel btnLH2;
    private javax.swing.JLabel btnNV2;
    private javax.swing.JLabel btnPTC2;
    private javax.swing.JLabel btnPhuongtien2;
    private javax.swing.JLabel btnThongke3;
    private javax.swing.JLabel btndiadiem2;
    private javax.swing.JLabel btntinhluong;
    private javax.swing.JLabel btntour2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}