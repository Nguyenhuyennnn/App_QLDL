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
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import csdl.ReportHoaDon;
import csdl.TblDattour;
import csdl.TblHoadon;
import csdl.TblHoadon_;
import csdl.TblTour_;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import static org.eclipse.persistence.config.ResultType.Map;

/**
 *
 * @author Administrator
 */
public class thongtinHD extends javax.swing.JFrame {
    DefaultTableModel tablemodel;
    XLDL hddl;
    UrlKN url;
    Dao dao;
    TblDattour DT;
    KNCSDL kn;
    /**
     * Creates new form thongtinHD
     */
    public thongtinHD(String Tour) {
        initComponents();
        hddl=new XLDL();
        kn= new KNCSDL();
       if(!Tour.equals("")){
           madt=Long.parseLong(Tour);
            try {
            getListHD( madt+"");
        } catch (SQLException ex) {
            Logger.getLogger(thongtinHD.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        
        url=new UrlKN();
        dao= new Dao(url.knURL());
        kn=new KNCSDL();
        loadHD();
        loadmadt();
        txtMaDatTour.setText(madt+"");
       
       
    }
    void loadHD(){
       
        ArrayList<TblHoadon>list= new ArrayList<>();
        try{
        list = hddl.getListHDon();
        tablemodel = (DefaultTableModel) tblHD.getModel();
        for(TblHoadon hd : list){
            tablemodel.addRow(new Object[]{hd.getMahoadon(), hd.getMadattour(), hd.getNgaylap(), hd.getTennv(), hd.getTongtien(), hd.getTrangthai()});
        }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, ex.toString());
            
        }
    }
    
    public long madt;
  
    void loadmadt(){
        try{
       
            ArrayList<TblDattour> DT= hddl.getListDT();
            for(TblDattour dt:DT){
                txtMaDatTour.setText(""+dt);
            }
        }catch(Exception ex){
            
        }
    }
    void loadforDatTour(String search){
        tblHD.removeAll();
        tablemodel.setRowCount(0);
        
    
        ArrayList<TblHoadon>list= new ArrayList<>();
        try{
        list = hddl.getListHD(search);
        tablemodel = (DefaultTableModel) tblHD.getModel();
        for(TblHoadon hd : list){
            tablemodel.addRow(new Object[]{hd.getMahoadon(), hd.getMadattour(), hd.getNgaylap(), hd.getTennv(), hd.getTongtien(),hd.getTrangthai()});
        }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, ex.toString());
            
        }
    }
    public static String MaDT;
    
    
     public void getListHD(String madt) throws SQLException{
     
  
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_dattour.madattour, tbl_nhanvien.hotennv, tbl_tour.matour, tbl_dattour.soluong, tbl_tour.gia, tbl_dattour.thoigianbatdau, tbl_dattour.diadiembatdau FROM  tbl_nhanvien,tbl_dattour, tbl_tour WHERE tbl_dattour.MANV=tbl_nhanvien.MANV and  tbl_tour.MATOUR=tbl_dattour.MATOUR and madattour="+madt;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
         //  txtMaDatTour.setText(result.getLong(1)+"");
           txtNVDanTour.setText(result.getString(2));
           txtMaTour.setText(result.getLong(3)+"");
           txtSoLuong.setText(result.getInt(4)+"");
           txtDonGia.setText(result.getFloat(5)+"");
           txtNgayDi.setText(result.getDate(6)+"");
           txtDDBD.setText(result.getString(7));
           
                  
        }
       
    }
     private boolean KiemTraDL() throws HeadlessException{
        StringBuilder sb= new StringBuilder();
        
        if(cbott.getSelectedItem().equals("")){
            sb.append("VUI LÒNG CHỌN TRẠNG THÁI!\n");
            cbott.setBackground(Color.yellow);
            cbott.requestFocus();
        }
        else{
            cbott.setBackground(Color.white);
            
        }
       
        if(txtPhuThu.getText().equals("")){
            sb.append("VUI LÒNG ĐIỀN SỐ TIỀN!\n");
            txtPhuThu.setBackground(Color.yellow);
            txtPhuThu.requestFocus();
        }
        else{
            txtPhuThu.setBackground(Color.white);
            
        }
        if(txtGiamGia.getText().equals("")){
            sb.append("VUI LÒNG CHO BIẾT SỐ TIỀN!\n");
            txtGiamGia.setBackground(Color.yellow);
            txtGiamGia.requestFocus();
        }
        else{
            txtGiamGia.setBackground(Color.white);
            
        }
        if(txtTong.getText().equals("")){
            sb.append("VUI LÒNG TÍNH TỔNG TIỀN TRƯỚC KHI THÊM!\n");
            txtTong.setBackground(Color.yellow);
            txtTong.requestFocus();
        }
        else{
            txtTong.setBackground(Color.white);
            
        }
        if(txtThuVao.getText().equals("")){
            sb.append("VUI LÒNG ĐIỀN SỐ TIỀN!\n");
            txtThuVao.setBackground(Color.yellow);
            txtThuVao.requestFocus();
        }
        else{
            txtThuVao.setBackground(Color.white);
            
        }
        if(txtTienThua.getText().equals("")){
            sb.append("VUI LÒNG TÍNH TIỀN TRƯỚC KHI THÊM!\n");
            txtTienThua.setBackground(Color.yellow);
            txtTienThua.requestFocus();
        }
        else{
            txtTienThua.setBackground(Color.white);
            
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
     /*private static JasperReport report;
     private static Collection getData(String ma) throws Exception {
        KNCSDL kn=new KNCSDL();
          ArrayList<TblHoadon> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="select pg.MaPhieuGui,kh.TenKH,pg.NgayGui,ht.Loai, tc.Giong, c.TenChuong, nkn.Ngay,nkn.Buoi, nkn.DichVu,nkn.TrangThai,nkn.ThanhTien, pg.TongTien,pg.TrangThai from tbl_PhieuGui pg,tbl_ChiTietPhieuGui ctpg, tbl_KhachHang kh,tbl_ThuCungKyGui tc,tbl_HinhThuc ht,tbl_NhatKyNuoi  nkn,tbl_Chuong c \n" +
"		where (pg.MaPhieuGui=ctpg.MaPhieuGui and pg.MaKH=kh.MaKH and pg.MaHinhThuc=ht.MaHinhThuc and ctpg.MaSoThuCung=tc.MaSoThuCung and c.MaChuong= ctpg.MaChuong  and tc.MaSoThuCung=nkn.MaSoThuCung and  pg.MaPhieuGui="+ma+")";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblHoaDon nv=new TblHoaDon();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setTenKH(result.getString(2));
            nv.setNgayGui(result.getString(3));
            nv.setLoai(result.getString(4));
            nv.setGiong(result.getString(5));
            nv.setTenChuong(result.getString(6));
            nv.setNgay(result.getString(7));
            nv.setBuoi(result.getString(8));
            nv.setDichVu(result.getString(9));
            nv.setTrangThai(result.getString(10));
            nv.setThanhTien(result.getFloat(11));
            nv.setTongTien(result.getFloat(12));
            nv.setTrangThaiHD(result.getString(13));
            list.add(nv);
        }
        return list;
        
    }

 
    public static void print(String ma) {
        try {
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(getData(ma));
            JasperPrint print = JasperFillManager.fillReport(report, null, jcd);
            if (false) {
                JasperPrintManager.printReport(print, true);    //  print auto
            } else {
                JasperViewer.viewReport(print, false);  //  view
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        lblMaHoaDon = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        lblMaTour = new javax.swing.JLabel();
        txtMaTour = new javax.swing.JTextField();
        lblNgayDi = new javax.swing.JLabel();
        txtNgayDi = new javax.swing.JTextField();
        lbMaDatTou = new javax.swing.JLabel();
        txtMaDatTour = new javax.swing.JTextField();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lblDDBD = new javax.swing.JLabel();
        txtDDBD = new javax.swing.JTextField();
        lblPhuThu = new javax.swing.JLabel();
        txtPhuThu = new javax.swing.JTextField();
        lblGiamGia = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        lblNVDanTour = new javax.swing.JLabel();
        txtNVDanTour = new javax.swing.JTextField();
        lblDonGia = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        lblThuVao = new javax.swing.JLabel();
        txtThuVao = new javax.swing.JTextField();
        lblTienThua = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        btnTinhtong = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHD = new javax.swing.JTable();
        btnThem = new javax.swing.JLabel();
        btnXoa = new javax.swing.JLabel();
        btnSua = new javax.swing.JLabel();
        btnInHD = new javax.swing.JLabel();
        btnLuu = new javax.swing.JLabel();
        btntimkiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnHuy = new javax.swing.JLabel();
        btnTinhtienthua = new javax.swing.JLabel();
        cbott = new javax.swing.JComboBox<>();
        btnThoat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1, -1, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 150, 10));

        lblMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaHoaDon.setText("MÃ HÓA ĐƠN:");
        jPanel1.add(lblMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 180, 30));
        jPanel1.add(txtMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 40));

        lblMaTour.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblMaTour.setForeground(new java.awt.Color(255, 255, 255));
        lblMaTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaTour.setText("MÃ TOUR:");
        jPanel1.add(lblMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 180, 30));
        jPanel1.add(txtMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 270, 40));

        lblNgayDi.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblNgayDi.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayDi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayDi.setText("NGÀY ĐI:");
        jPanel1.add(lblNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 180, 30));
        jPanel1.add(txtNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 270, 40));

        lbMaDatTou.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbMaDatTou.setForeground(new java.awt.Color(255, 255, 255));
        lbMaDatTou.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMaDatTou.setText("MÃ ĐẶT TOUR:");
        jPanel1.add(lbMaDatTou, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 180, 30));
        jPanel1.add(txtMaDatTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 270, 40));

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSoLuong.setText("SỐ LƯỢNG:");
        jPanel1.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 180, 30));
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 270, 40));

        lblDDBD.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblDDBD.setForeground(new java.awt.Color(255, 255, 255));
        lblDDBD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDDBD.setText("ĐỊA ĐIỂM BẮT ĐẦU:");
        jPanel1.add(lblDDBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 220, 30));
        jPanel1.add(txtDDBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 270, 40));

        lblPhuThu.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblPhuThu.setForeground(new java.awt.Color(255, 255, 255));
        lblPhuThu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPhuThu.setText("PHỤ THU:");
        jPanel1.add(lblPhuThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 180, 30));
        jPanel1.add(txtPhuThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 270, 40));

        lblGiamGia.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblGiamGia.setForeground(new java.awt.Color(255, 255, 255));
        lblGiamGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGiamGia.setText("GIẢM GIÁ:");
        jPanel1.add(lblGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 160, 30));
        jPanel1.add(txtGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 270, 40));

        lblNVDanTour.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblNVDanTour.setForeground(new java.awt.Color(255, 255, 255));
        lblNVDanTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNVDanTour.setText("NHÂN VIÊN DẪN TOUR:");
        jPanel1.add(lblNVDanTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 240, 30));
        jPanel1.add(txtNVDanTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 270, 40));

        lblDonGia.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblDonGia.setForeground(new java.awt.Color(255, 255, 255));
        lblDonGia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDonGia.setText("ĐƠN GIÁ:");
        jPanel1.add(lblDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 180, 30));
        jPanel1.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 270, 40));

        lblTrangThai.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTrangThai.setText("TRẠNG THÁI:");
        jPanel1.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 180, 30));

        lblThuVao.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblThuVao.setForeground(new java.awt.Color(255, 255, 255));
        lblThuVao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblThuVao.setText("THU VÀO:");
        jPanel1.add(lblThuVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 120, 180, 30));
        jPanel1.add(txtThuVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, 270, 40));

        lblTienThua.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTienThua.setText("TIỀN THỪA:");
        jPanel1.add(lblTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 280, 180, 30));
        jPanel1.add(txtTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 310, 270, 40));

        lblTong.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTong.setForeground(new java.awt.Color(255, 255, 255));
        lblTong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTong.setText("TỔNG :");
        jPanel1.add(lblTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, 180, 30));
        jPanel1.add(txtTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 200, 40));

        btnTinhtong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTinhtong.setForeground(new java.awt.Color(255, 255, 255));
        btnTinhtong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTinhtong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_calculate_white_24dp.png"))); // NOI18N
        btnTinhtong.setText("TÍNH");
        btnTinhtong.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTinhtong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTinhtongMouseClicked(evt);
            }
        });
        jPanel1.add(btnTinhtong, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 390, 70, 40));

        tblHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã đặt tour", "Ngày lập", "Mã nhân viên", "Tổng tiền", "Trạng thái"
            }
        ));
        tblHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHD);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1370, 210));

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
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 40));

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
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 90, 40));

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
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, 40));

        btnInHD.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnInHD.setForeground(new java.awt.Color(255, 255, 255));
        btnInHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_adf_scanner_white_24dp.png"))); // NOI18N
        btnInHD.setText("In hóa đơn");
        btnInHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnInHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHDMouseClicked(evt);
            }
        });
        jPanel1.add(btnInHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 390, 180, 50));

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
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 100, 40));

        btntimkiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_search_white_24dp.png"))); // NOI18N
        btntimkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btntimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntimkiemMouseClicked(evt);
            }
        });
        jPanel1.add(btntimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 40, 40));

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
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 310, 40));

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
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 110, 40));

        btnTinhtienthua.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnTinhtienthua.setForeground(new java.awt.Color(255, 255, 255));
        btnTinhtienthua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTinhtienthua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outline_calculate_white_24dp.png"))); // NOI18N
        btnTinhtienthua.setText("TÍNH");
        btnTinhtienthua.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTinhtienthua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTinhtienthuaMouseClicked(evt);
            }
        });
        jPanel1.add(btnTinhtienthua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 210, 180, 50));

        cbott.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cbott.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán" }));
        jPanel1.add(cbott, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 270, 40));

        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/baseline_clear_white_24dp.png"))); // NOI18N
        btnThoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        // TODO add your handling code here:
        txtMaHoaDon.setText("");
        txtMaDatTour.setText("");
        txtNVDanTour.setText("");
        txtMaTour.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtNgayDi.setText("");
        txtDDBD.setText("");
        txtPhuThu.setText("");
        txtGiamGia.setText("");
        txtTong.setText("");
        txtThuVao.setText("");
        txtTienThua.setText("");
        txtTimKiem.setText("");
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        
        tblHD.removeAll();
        tablemodel.setRowCount(0);
        loadHD();
    }//GEN-LAST:event_btnHuyMouseClicked

    private void tblHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDMouseClicked
        // TODO add your handling code here:
        int i= tblHD.getSelectedRow();
        hienThi(i);
    }//GEN-LAST:event_tblHDMouseClicked
    
    private void btnTinhtongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTinhtongMouseClicked
        // TODO add your handling code here:
        txtTong.setText(String.valueOf(Float.parseFloat(txtDonGia.getText())* Integer.parseInt(txtSoLuong.getText()) + Float.parseFloat(txtPhuThu.getText())- Float.parseFloat(txtGiamGia.getText())));
    }//GEN-LAST:event_btnTinhtongMouseClicked

    private void btnTinhtienthuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTinhtienthuaMouseClicked
        // TODO add your handling code here:
        txtTienThua.setText(String.valueOf(Float.parseFloat(txtThuVao.getText())- Float.parseFloat(txtTong.getText())));
    }//GEN-LAST:event_btnTinhtienthuaMouseClicked
    
    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        // TODO add your handling code here:
        if(them){
           if(KiemTraDL()){
            
               try {
                   Integer MaDattour=Integer.parseInt(txtMaDatTour.getText());
                   Date dt = new Date();
                   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   String ngay = dateFormat.format(dt);
                   
                   Float tongtien=Float.parseFloat(txtTong.getText());
                   String trangthai= cbott.getSelectedItem().toString();
                   Connection conn= dao.getConnect();
                   
                   String caulenh="INSERT INTO tbl_hoadon VALUES (null,'"+MaDattour+"','"+ngay+"','"+2+"','"+tongtien+"','"+trangthai+"')";
                   boolean a= dao.Lenh(caulenh, conn);
                   if(a){
                       tblHD.removeAll();
                       tablemodel.setRowCount(0);
                       loadHD();
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
                Integer Mahoadon=Integer.parseInt(txtMaHoaDon.getText());
                Integer MaDattour=Integer.parseInt(txtMaDatTour.getText());
                   Date dt = new Date();
                   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   String ngay = dateFormat.format(dt);
                   
                   Float tongtien=Float.parseFloat(txtTong.getText());
                   String trangthai= cbott.getSelectedItem().toString();
                   
                   Connection conn= dao.getConnect();

                
                String caulenh="UPDATE tbl_hoadon SET madattour='"+MaDattour+"',ngaylap='"+ngay+"',manv='"+2+"',tongtien='"+tongtien+"',trangthai='"+trangthai+"'where mahoadon="+Mahoadon;
                boolean a= dao.Lenh(caulenh, conn);
                if(a){
                    tblHD.removeAll();
                    tablemodel.setRowCount(0);
                    loadHD();
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
                    Integer Mahoadon= Integer.parseInt(txtMaHoaDon.getText());
                    Connection conn= dao.getConnect();
                    String caulenh="DELETE FROM tbl_hoadon WHERE mahoadon="+Mahoadon;
                    boolean a= dao.Lenh(caulenh, conn);
                    if(a){
                        tblHD.removeAll();
                        tablemodel.setRowCount(0);
                        loadHD();
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
        tblHD.removeAll();
        tablemodel.setRowCount(0);
        
        String timkiem=txtTimKiem.getText();
        ArrayList<TblHoadon>list= new ArrayList<>();
        try{
        list = hddl.getListHD(timkiem);
        tablemodel = (DefaultTableModel) tblHD.getModel();
        for(TblHoadon hd : list){
            tablemodel.addRow(new Object[]{hd.getMahoadon(), hd.getMadattour(), hd.getNgaylap(), hd.getTennv(), hd.getTongtien(),hd.getTrangthai()});
        }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(this, ex.toString());
            
        }
    }//GEN-LAST:event_btntimkiemMouseClicked
    
    private static JasperReport report;
    
       private Collection getData(String ma) throws Exception {
        ArrayList<ReportHoaDon> arr = new ArrayList<>();
        //     arr.add(new DataPrint("001", "Iamge 001", imageToInpuStream(new ImageIcon(PrintImage.class.getResource("printImages/i1.jpg")))));
        ReportHoaDon rp= new ReportHoaDon();
        rp=hddl.hoadon(ma);
        arr.add(rp);
        return arr;
    }
      public  void print(String ma) {
        try {
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(getData(ma));
            JasperPrint print = JasperFillManager.fillReport(report, null, jcd);
            if (false) {
                JasperPrintManager.printReport(print, true);    //  print auto
            } else {
                JasperViewer.viewReport(print, false);  //  view
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnInHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHDMouseClicked
        // TODO add your handling code here:
         try {
           
           report = JasperCompileManager.compileReport("src/View/ReportHoaDon.jrxml");
            print(txtMaDatTour.getText());
        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_btnInHDMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatMouseClicked
    void hienThi(int i){
        TableModel model= tblHD.getModel();
        txtMaHoaDon.setText(model.getValueAt(i,0).toString());
        txtMaDatTour.setText(model.getValueAt(i, 1).toString());
        txtTong.setText(model.getValueAt(i,4).toString());
        cbott.setSelectedItem(model.getValueAt(i,5).toString());
   try {
            getListHD(model.getValueAt(i,1).toString());
        } catch (SQLException ex) {
            Logger.getLogger(thongtinHD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(thongtinHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongtinHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongtinHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongtinHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongtinHD(MaDT).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnHuy;
    private javax.swing.JLabel btnInHD;
    private javax.swing.JLabel btnLuu;
    private javax.swing.JLabel btnSua;
    private javax.swing.JLabel btnThem;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel btnTinhtienthua;
    private javax.swing.JLabel btnTinhtong;
    private javax.swing.JLabel btnXoa;
    private javax.swing.JLabel btntimkiem;
    private javax.swing.JComboBox<String> cbott;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbMaDatTou;
    private javax.swing.JLabel lblDDBD;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaTour;
    private javax.swing.JLabel lblNVDanTour;
    private javax.swing.JLabel lblNgayDi;
    private javax.swing.JLabel lblPhuThu;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblThuVao;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTong;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblHD;
    private javax.swing.JTextField txtDDBD;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaDatTour;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaTour;
    private javax.swing.JTextField txtNVDanTour;
    private javax.swing.JTextField txtNgayDi;
    private javax.swing.JTextField txtPhuThu;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtThuVao;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
