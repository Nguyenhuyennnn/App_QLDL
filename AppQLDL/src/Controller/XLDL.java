/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import csdl.ReportHoaDon;
import csdl.ReportPhieuCapLuong;
import csdl.ReportTheNV;
import csdl.TblAdmin;
import csdl.TblChitietdiemdanh;
import csdl.TblChitiettinhluong;
import csdl.TblChucvu;
import csdl.TblDattour;
import csdl.TblDiadiem;
import csdl.TblDichvu;
import csdl.TblHoadon;
import csdl.TblKhachhang;
import csdl.TblKhachsan;
import csdl.TblNhanvien;
import csdl.TblPhongkhachsan;
import csdl.TblPhongtochuc;
import csdl.TblPhuongtien;
import csdl.TblTinh;
import csdl.TblTour;
import csdl.thongKe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class XLDL {
    KNCSDL kn = null;

    public XLDL() {
        kn = new KNCSDL();
    }

    public ArrayList<TblNhanvien> getListNV() throws SQLException {
        ArrayList<TblNhanvien> listNV = new ArrayList<>();
        listNV.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_nhanvien.*,tbl_phongtochuc.tenptc, tbl_chucvu.tencv FROM tbl_nhanvien, tbl_phongtochuc, tbl_chucvu WHERE tbl_nhanvien.maptc= tbl_phongtochuc.maptc AND tbl_nhanvien.macv=tbl_chucvu.macv";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblNhanvien nv = new TblNhanvien();
            nv.setManv(result.getLong(1));
            nv.setHotennv(result.getString(2));
            nv.setNgaysinh(result.getDate(3));
            nv.setGioitinh(result.getString(4));
            nv.setCmnd(result.getString(5));
            nv.setDiachi(result.getString(6));
            nv.setSdt(result.getString(7));
            nv.setNgayvaolam(result.getDate(8));
            nv.setMaptc(result.getLong(9));
            nv.setMacv(result.getLong(10));
            nv.setHinhanh(result.getString(11));
            nv.setTenPTC(result.getString(12));
            nv.setTenCV(result.getString(13));
            listNV.add(nv);
        }
        return listNV;
    }
    public ArrayList<TblNhanvien> getListNV(String timkiem) throws SQLException {
        ArrayList<TblNhanvien> listNV = new ArrayList<>();
        listNV.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_nhanvien WHERE (manv like '%"+timkiem+"%' OR hotennv like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblNhanvien nv = new TblNhanvien();
            nv.setManv(result.getLong(1));
            nv.setHotennv(result.getString(2));
            nv.setNgaysinh(result.getDate(3));
            nv.setGioitinh(result.getString(4));
            nv.setCmnd(result.getString(5));
            nv.setDiachi(result.getString(6));
            nv.setSdt(result.getString(7));
            nv.setNgayvaolam(result.getDate(8));
            nv.setMaptc(result.getLong(9));
            nv.setMacv(result.getLong(10));
            nv.setHinhanh(result.getString(11));
            listNV.add(nv);
        }
        return listNV;
    }
    public float getHeso(String ma) throws SQLException{
     float heso=0;
        Connection conn=kn.getConnect();
         String sql  ="SELECT tbl_nhanvien.*,tbl_chucvu.tencv,tbl_chucvu.heso FROM tbl_nhanvien,tbl_chucvu where tbl_nhanvien.macv=tbl_chucvu.macv AND tbl_nhanvien.manv="+ ma;

        
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
          TblNhanvien nv=new TblNhanvien();
        while(result.next()){
          
           nv.setManv(result.getLong(1));
            nv.setHotennv(result.getString(2));
            nv.setNgaysinh(result.getDate(3));
            nv.setGioitinh(result.getString(4));
            nv.setCmnd(result.getString(5));
            nv.setDiachi(result.getString(6));
            nv.setSdt(result.getString(7));
            nv.setNgayvaolam(result.getDate(8));
            nv.setMaptc(result.getLong(9));
            nv.setMacv(result.getLong(10));
            nv.setHinhanh(result.getString(11));
            nv.setTenCV(result.getString(12));
            heso=result.getFloat(13);
        }
        return heso;
    }

    public ArrayList<TblChucvu> getListCV() throws SQLException{
        ArrayList<TblChucvu> listCV = new ArrayList<>();
        listCV.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_chucvu";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChucvu cv = new TblChucvu();
            cv.setMacv(result.getLong(1));
            cv.setTencv(result.getString(2));
            cv.setHeso(result.getInt(3));
            listCV.add(cv);
        }
        return listCV;
    }
    public ArrayList<TblChucvu> getListchucvu(String timkiem) throws SQLException{
        ArrayList<TblChucvu> listCV = new ArrayList<>();
        listCV.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_chucvu WHERE (macv like '%"+timkiem+"%' OR tencv like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChucvu cv = new TblChucvu();
            cv.setMacv(result.getLong(1));
            cv.setTencv(result.getString(2));
            cv.setHeso(result.getInt(3));
            listCV.add(cv);
        }
        return listCV;
    }
    public ArrayList<TblDichvu> getListDV() throws SQLException{
        ArrayList<TblDichvu> listDV = new ArrayList<>();
        listDV.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_dichvu";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblDichvu dv = new TblDichvu();
            dv.setMadv(result.getLong(1));
            dv.setTendv(result.getString(2));
            dv.setDongia(result.getFloat(3));
            
            listDV.add(dv);
        }
        return listDV;
    }
    public ArrayList<TblDichvu> getListDV(String timkiem) throws SQLException{
        ArrayList<TblDichvu> listDV = new ArrayList<>();
        listDV.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_dichvu WHERE (madv like '%"+timkiem+"%' OR tendv like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblDichvu dv = new TblDichvu();
            dv.setMadv(result.getLong(1));
            dv.setTendv(result.getString(2));
            dv.setDongia(result.getFloat(3));
            
            listDV.add(dv);
        }
        return listDV;
    }
    public ArrayList<TblDattour> getListDT() throws SQLException{
        ArrayList<TblDattour> listDT = new ArrayList<>();
        listDT.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_dattour.*,tbl_khachhang.hotenkh, tbl_nhanvien.hotennv, tbl_tour.tentour FROM tbl_dattour, tbl_khachhang, tbl_nhanvien, tbl_tour WHERE tbl_dattour.makh= tbl_khachhang.makh AND tbl_dattour.manv=tbl_nhanvien.manv AND tbl_dattour.matour=tbl_tour.matour";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblDattour dt = new TblDattour();
            dt.setMadattour(result.getLong(1));
            dt.setMatour(result.getLong(2));
            dt.setMakh(result.getLong(3));
            dt.setSoluong(result.getInt(4));
            dt.setThoigianbatdau(result.getDate(5));
            dt.setDiadiembatdau(result.getString(6));
            dt.setManv(result.getLong(7));
            dt.setHotenkh(result.getString(8));
            dt.setHotennv(result.getString(9));
            dt.setTentour(result.getString(10));
            listDT.add(dt);
        }
        return listDT;
    }
    
    public ArrayList<TblDattour> getListDT(String timkiem) throws SQLException{
        ArrayList<TblDattour> listDT = new ArrayList<>();
        
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_dattour.*,tbl_khachhang.hotenkh, tbl_nhanvien.hotennv, tbl_tour.tentour FROM tbl_dattour, tbl_khachhang, tbl_nhanvien, tbl_tour WHERE tbl_dattour.makh= tbl_khachhang.makh AND tbl_dattour.manv=tbl_nhanvien.manv AND tbl_dattour.matour=tbl_tour.matour and tbl_khachhang.hotenkh LIKE '%" +timkiem+"%'";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int n=0;
        while (result.next()) {
            TblDattour dt = new TblDattour();
            dt.setMadattour(result.getLong(1));
            dt.setMatour(result.getLong(2));
            dt.setMakh(result.getLong(3));
            dt.setSoluong(result.getInt(4));
            dt.setThoigianbatdau(result.getDate(5));
            dt.setDiadiembatdau(result.getString(6));
            dt.setManv(result.getLong(7));
            dt.setHotenkh(result.getString(8));
            dt.setHotennv(result.getString(9));
            dt.setTentour(result.getString(10));
            listDT.add(dt);
        }
        return listDT;
    }
    
    
    public ArrayList<TblDiadiem> getListDD() throws SQLException{
        ArrayList<TblDiadiem> listDD = new ArrayList<>();
        listDD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_diadiem.*, tbl_tinh.tentinh from tbl_diadiem, tbl_tinh WHERE tbl_diadiem.matinh=tbl_tinh.matinh ";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblDiadiem dd = new TblDiadiem();
            dd.setMadd(result.getLong(1));
            dd.setTendd(result.getString(2));
            dd.setMatinh(result.getLong(3));
            dd.setTentinh(result.getString(4));
            listDD.add(dd);
        }
        return listDD;
    }
    public ArrayList<TblDiadiem> getListDD(String timkiem) throws SQLException{
        ArrayList<TblDiadiem> listDD = new ArrayList<>();
        listDD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_diadiem WHERE (madd like '%"+timkiem+"%' OR tendd like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblDiadiem dd = new TblDiadiem();
            dd.setMadd(result.getLong(1));
            dd.setTendd(result.getString(2));
            dd.setMatinh(result.getLong(3));
            listDD.add(dd);
        }
        return listDD;
    }
    public ArrayList<TblKhachhang> getListKH() throws SQLException{
        ArrayList<TblKhachhang> listKH = new ArrayList<>();
        listKH.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_khachhang";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblKhachhang kh = new TblKhachhang();
            kh.setMakh(result.getLong(1));
            kh.setHotenkh(result.getString(2));
            kh.setGioitinh(result.getString(3));
            kh.setCmnd(result.getString(4));
            kh.setDiachi(result.getString(5));
            kh.setSdt(result.getString(6));
            kh.setLoai(result.getString(7));
            kh.setHinhanh(result.getString(8));
            listKH.add(kh);
        }
        return listKH;
    }
    public ArrayList<TblKhachhang> getListKH(String timkiem) throws SQLException{
        ArrayList<TblKhachhang> listKH = new ArrayList<>();
        listKH.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_khachhang WHERE (makh like '%"+timkiem+"%' OR hotenkh like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblKhachhang kh = new TblKhachhang();
            kh.setMakh(result.getLong(1));
            kh.setHotenkh(result.getString(2));
            kh.setGioitinh(result.getString(3));
            kh.setCmnd(result.getString(4));
            kh.setDiachi(result.getString(5));
            kh.setSdt(result.getString(6));
            kh.setLoai(result.getString(7));
            kh.setHinhanh(result.getString(8));
            listKH.add(kh);
        }
        return listKH;
    }
    public ArrayList<TblTinh> getListT() throws SQLException{
        ArrayList<TblTinh> listT = new ArrayList<>();
        listT.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_tinh";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblTinh t = new TblTinh();
            t.setMatinh(result.getLong(1));
            t.setTentinh(result.getString(2));
            
            listT.add(t);
        }
        return listT;
    }
    public ArrayList<TblChitietdiemdanh> getListdd() throws SQLException{
        ArrayList<TblChitietdiemdanh> listdd = new ArrayList<>();
        listdd.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_chitietdiemdanh.*,tbl_nhanvien.hotennv FROM tbl_chitietdiemdanh,tbl_nhanvien WHERE tbl_chitietdiemdanh.manv=tbl_nhanvien.manv ";
        
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChitietdiemdanh dd = new TblChitietdiemdanh();
            dd.setMadd(result.getLong(1));
            dd.setManv(result.getLong(2));
            dd.setNgay(result.getDate(3));
            dd.setGiovao(result.getTime(4));
            dd.setGiora(result.getTime(5));
            dd.setTrangthai(result.getString(6));
            dd.setGhichu(result.getString(7));
            dd.setHotennv(result.getString(8));
            
            listdd.add(dd);
        }
        return listdd;
    }
    public ArrayList<TblChitietdiemdanh> getListdd(String ngay) throws SQLException{
        ArrayList<TblChitietdiemdanh> listdd = new ArrayList<>();
        listdd.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT * FROM tbl_chitietdiemdanh WHERE ngay= '"+ ngay+"'";
        
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChitietdiemdanh dd = new TblChitietdiemdanh();
            dd.setMadd(result.getLong(1));
            dd.setManv(result.getLong(2));
            dd.setNgay(result.getDate(3));
            dd.setGiovao(result.getTime(4));
            dd.setGiora(result.getTime(5));
            dd.setTrangthai(result.getString(6));
            dd.setGhichu(result.getString(7));
          
            
            listdd.add(dd);
        }
        return listdd;
    }
    public ArrayList<TblChitietdiemdanh> getListdiemdanh(String locngay) throws SQLException{
        ArrayList<TblChitietdiemdanh> listdd = new ArrayList<>();
        listdd.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_chitietdiemdanh.*,tbl_nhanvien.hotennv FROM tbl_chitietdiemdanh,tbl_nhanvien WHERE tbl_chitietdiemdanh.manv=tbl_nhanvien.manv AND tbl_chitietdiemdanh.ngay = '"+locngay+ "'";
        
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChitietdiemdanh dd = new TblChitietdiemdanh();
            dd.setMadd(result.getLong(1));
            dd.setManv(result.getLong(2));
            dd.setNgay(result.getDate(3));
            dd.setGiovao(result.getTime(4));
            dd.setGiora(result.getTime(5));
            dd.setTrangthai(result.getString(6));
            dd.setGhichu(result.getString(7));
            dd.setHotennv(result.getString(8));
            
            listdd.add(dd);
        }
        return listdd;
    }
    
    public ArrayList<TblPhongtochuc> getListPTC() throws SQLException {
        ArrayList<TblPhongtochuc> listPTC = new ArrayList<>();
        listPTC.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_phongtochuc";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblPhongtochuc ptc = new TblPhongtochuc();
            ptc.setMaptc(result.getLong(1));
            ptc.setTenptc(result.getString(2));
            ptc.setTruongphong(result.getString(3));
            
            listPTC.add(ptc);
        }
        return listPTC;
    }
    public ArrayList<TblPhongtochuc> getListPTC(String timkiem) throws SQLException {
        ArrayList<TblPhongtochuc> listPTC = new ArrayList<>();
        listPTC.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_phongtochuc WHERE (maptc like '%"+timkiem+"%' OR tenptc like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblPhongtochuc ptc = new TblPhongtochuc();
            ptc.setMaptc(result.getLong(1));
            ptc.setTenptc(result.getString(2));
            ptc.setTruongphong(result.getString(3));
            
            listPTC.add(ptc);
        }
        return listPTC;
    }
    public ArrayList<TblKhachsan> getListKS() throws SQLException {
        ArrayList<TblKhachsan> listKS = new ArrayList<>();
       
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_khachsan.*, tbl_tinh.tentinh from tbl_khachsan, tbl_tinh WHERE tbl_khachsan.matinh=tbl_tinh.matinh ";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblKhachsan ks = new TblKhachsan();
            ks.setMaks(result.getLong(1));
            ks.setTenks(result.getString(2));
            ks.setDiachi(result.getString(3));
            ks.setMatinh(result.getLong(4));
            ks.setDanhgia(result.getString(5));
            ks.setSdtlienhe(result.getString(6));
            ks.setTentinh(result.getString(7));
            listKS.add(ks);
        }
        return listKS;
    }
    public ArrayList<TblKhachsan> getListKS(String timkiem) throws SQLException {
        ArrayList<TblKhachsan> listKS = new ArrayList<>();
        listKS.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_khachsan WHERE (maks like '%"+timkiem+"%' OR tenks like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblKhachsan ks = new TblKhachsan();
            ks.setMaks(result.getLong(1));
            ks.setTenks(result.getString(2));
            ks.setDiachi(result.getString(3));
            ks.setMatinh(result.getLong(4));
            ks.setDanhgia(result.getString(5));
            ks.setSdtlienhe(result.getString(6));
            listKS.add(ks);
        }
        return listKS;
    }
    public ArrayList<TblPhongkhachsan> getListPKS(long maks) throws SQLException{
        ArrayList<TblPhongkhachsan> listPKS = new ArrayList<>();
        listPKS.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_phongkhachsan.*,tbl_khachsan.tenks FROM tbl_phongkhachsan, tbl_khachsan WHERE tbl_phongkhachsan.maks= tbl_khachsan.maks AND tbl_phongkhachsan.maks="+maks;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblPhongkhachsan pks = new TblPhongkhachsan();
            pks.setMaphongks(result.getLong(1));
            pks.setTenphong(result.getString(2));
            pks.setLoai(result.getString(3));
            pks.setGia(result.getFloat(4));
            pks.setMaks(result.getLong(5));
            pks.setTenks(result.getString(6));
            listPKS.add(pks);
        }
        return listPKS;
    }
    public ArrayList<TblPhongkhachsan> getListPKS(String timkiem) throws SQLException{
        ArrayList<TblPhongkhachsan> listPKS = new ArrayList<>();
        listPKS.clear();
        Connection conn = kn.getConnect();
        
        String sql = "SELECT *FROM tbl_phongkhachsan WHERE (maphongks like '%"+timkiem+"%' OR tenphong like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblPhongkhachsan pks = new TblPhongkhachsan();
            pks.setMaphongks(result.getLong(1));
            pks.setTenphong(result.getString(2));
            pks.setLoai(result.getString(3));
            pks.setGia(result.getFloat(4));
            pks.setMaks(result.getLong(5));
            
            listPKS.add(pks);
        }
        return listPKS;
    }
    public ArrayList<TblHoadon> getListHDon() throws SQLException{
        ArrayList<TblHoadon> listHD = new ArrayList<>();
        listHD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_hoadon.*,tbl_nhanvien.hotennv FROM tbl_hoadon, tbl_nhanvien WHERE tbl_hoadon.manv= tbl_nhanvien.manv AND tbl_hoadon.trangthai= 'Chưa thanh toán'";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblHoadon hd = new TblHoadon();
            hd.setMahoadon(result.getLong(1));
            hd.setMadattour(result.getLong(2));
            hd.setNgaylap(result.getDate(3));
            hd.setManv(result.getLong(4));
            hd.setTongtien(result.getFloat(5));
            hd.setTrangthai(result.getString(6));
            hd.setTennv(result.getString(7));
            listHD.add(hd);
        }
        return listHD;
    }
    
     public ArrayList<TblHoadon> getListHD(long madt) throws SQLException{
        ArrayList<TblHoadon> listHD = new ArrayList<>();
        listHD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_dattour.madattour, tbl_nhanvien.HOTENNV, tbl_tour.matour, tbl_dattour.soluong, tbl_tour.gia, tbl_dattour.thoigianbatdau, tbl_dattour.diadiembatdau FROM  tbl_nhanvien,tbl_dattour, tbl_tour WHERE tbl_dattour.MANV=tbl_nhanvien.MANV and  tbl_tour.MATOUR=tbl_dattour.MATOUR and madattour="+madt;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblHoadon hd = new TblHoadon();
            hd.setMahoadon(result.getLong(1));
            hd.setMadattour(result.getLong(2));
            hd.setNgaylap(result.getDate(3));
            hd.setManv(result.getLong(4));
            hd.setTongtien(result.getFloat(5));
            hd.setTrangthai(result.getString(6));
            hd.setTennv(result.getString(7));
            listHD.add(hd);
        }
        return listHD;
    }
    public ArrayList<TblHoadon> getListHD(String timkiem) throws SQLException{
        ArrayList<TblHoadon> listHD = new ArrayList<>();
        listHD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_hoadon WHERE (mahoadon like '%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblHoadon hd = new TblHoadon();
            hd.setMahoadon(result.getLong(1));
            hd.setMadattour(result.getLong(2));
            hd.setNgaylap(result.getDate(3));
            hd.setManv(result.getLong(4));
            hd.setTongtien(result.getFloat(5));
            hd.setTrangthai(result.getString(6));
            listHD.add(hd);
        }
        return listHD;
    }
   
     public ArrayList<TblPhuongtien> getListPT() throws SQLException{
        ArrayList<TblPhuongtien> listPT = new ArrayList<>();
        listPT.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_phuongtien";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblPhuongtien pt = new TblPhuongtien();
            pt.setMaphuongtien(result.getLong(1));
            pt.setTenphuongtien(result.getString(2));
            pt.setLoai(result.getString(3));
            pt.setTentaixe(result.getString(4));
            pt.setSdtlienlac(result.getString(5));
            pt.setTrangthai(result.getString(6));
            pt.setGia(result.getFloat(7));
            listPT.add(pt);
        }
        return listPT;
    }
    public ArrayList<TblPhuongtien> getListPT(String timkiem) throws SQLException{
        ArrayList<TblPhuongtien> listPT = new ArrayList<>();
        listPT.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_phuongtien WHERE (maphuongtien like '%"+timkiem+"%' OR tenphuongtien like N'%"+timkiem+"%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblPhuongtien pt = new TblPhuongtien();
            pt.setMaphuongtien(result.getLong(1));
            pt.setTenphuongtien(result.getString(2));
            pt.setLoai(result.getString(3));
            pt.setTentaixe(result.getString(4));
            pt.setSdtlienlac(result.getString(5));
            pt.setTrangthai(result.getString(6));
            pt.setGia(result.getFloat(7));
            listPT.add(pt);
        }
        return listPT;
    }
    public ArrayList<TblTour> getListTour() throws SQLException{
        ArrayList<TblTour> listTour = new ArrayList<>();
        listTour.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_tour.*,tbl_phongkhachsan.tenphong, tbl_dichvu.tendv, tbl_phuongtien.tenphuongtien FROM tbl_tour, tbl_phongkhachsan, tbl_dichvu, tbl_phuongtien WHERE tbl_tour.maphongks= tbl_phongkhachsan.maphongks AND tbl_tour.madv=tbl_dichvu.madv AND tbl_tour.maphuongtien=tbl_phuongtien.maphuongtien";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblTour tour = new TblTour();
            tour.setMatour(result.getLong(1));
            tour.setTentour(result.getString(2));
            tour.setThoigian(result.getDate(3));
            tour.setMaphongks(result.getLong(4));
            tour.setMadv(result.getLong(5));
            tour.setMaphuongtien(result.getLong(6));
            tour.setDiadiem(result.getString(7));
            tour.setGia(result.getFloat(8));
            tour.setGhichu(result.getString(9));
            tour.setTenphongks(result.getString(10));
            tour.setTendv(result.getString(11));
            tour.setTenpt(result.getString(12));
            listTour.add(tour);
        }
        return listTour;
    }
    
   public String dangnhap(String taikhoan, String matKhau) throws SQLException {

        Connection conn = kn.getConnect();
        String sql = "SELECT * FROM tbl_admin where taikhoan like'" + taikhoan + "' and matkhau like '" + matKhau + "'";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int i = result.getRow();
        while (result.next()) {
            return result.getString(4);
        }
        return "";

    }
    public ArrayList<TblChitiettinhluong> getListluong() throws SQLException{
        ArrayList<TblChitiettinhluong> listluong = new ArrayList<>();
        listluong.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT *FROM tbl_Chitiettinhluong";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChitiettinhluong tl = new TblChitiettinhluong();
            tl.setMasotinhluong(result.getLong(1));
            tl.setManv(result.getLong(2));
            tl.setLuongcanban(result.getFloat(3));
            tl.setSongaylamviec(result.getInt(4));
            tl.setThuong(result.getFloat(5));
            tl.setPhucap(result.getFloat(6));
            tl.setTru(result.getFloat(7));
            tl.setThue(result.getFloat(8));
            tl.setTongluong(result.getFloat(9));
            tl.setNgayphat(result.getDate(10));
            listluong.add(tl);
        }
        return listluong;
    }
    public ArrayList<TblAdmin> getListAd() throws SQLException{
        ArrayList<TblAdmin> listAd = new ArrayList<>();
        listAd.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT * FROM tbl_admin";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblAdmin ad = new TblAdmin();
            ad.setTaikhoan(result.getString(1));
            ad.setMatkhau(result.getString(2));
            ad.setManv(result.getLong(3));
            ad.setQuyen(result.getString(4));
            ad.setHinhanh(result.getString(5));
            listAd.add(ad);
        }
        return listAd;
    }
    public  ReportTheNV thenv(String ma) throws SQLException{
        ReportTheNV dt= new ReportTheNV();
        Connection conn = kn.getConnect();
        String sql="SELECT tbl_nhanvien.HOTENNV, tbl_nhanvien.NGAYSINH,tbl_nhanvien.GIOITINH,tbl_chucvu.TENCV,tbl_phongtochuc.TENPTC FROM tbl_nhanvien,tbl_chucvu,tbl_phongtochuc WHERE ( tbl_nhanvien.MACV=tbl_chucvu.MACV and tbl_nhanvien.MAPTC=tbl_phongtochuc.MAPTC and tbl_nhanvien.MANV="+ma+")";
          Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int n=0;
        while (result.next()) {
           
            dt.setHoTen(result.getString(1));
            dt.setNgaySinh(result.getString(2));
            dt.setGioiTinh(result.getString(3));
            dt.setChucVu(result.getString(4));
            dt.setBoPhan(result.getString(5));
        }
        return dt;
    }
    
     public  ReportHoaDon hoadon(String ma) throws SQLException{
        ReportHoaDon hd= new ReportHoaDon();
        Connection conn = kn.getConnect();
        String sql="SELECT tbl_khachhang.makh, tbl_khachhang.hotenkh, tbl_khachhang.diachi, tbl_tour.tentour, tbl_hoadon.ngaylap, tbl_nhanvien.hotennv, tbl_hoadon.mahoadon, tbl_dattour.madattour, tbl_tour.gia, tbl_dattour.soluong, tbl_hoadon.tongtien FROM tbl_hoadon, tbl_khachhang, tbl_nhanvien, tbl_dattour, tbl_tour WHERE tbl_khachhang.MAKH=tbl_dattour.MAKH AND tbl_dattour.MATOUR= tbl_tour.MATOUR AND tbl_dattour.MADATTOUR= tbl_hoadon.MADATTOUR AND tbl_hoadon.MANV=tbl_nhanvien.MANV AND tbl_dattour.MADATTOUR="+ma;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int n=0;
        while (result.next()) {
           
            hd.setMaKH(result.getLong(1));
            hd.setTenKH(result.getString(2));
            hd.setDiaChi(result.getString(3));
            hd.setTenTour(result.getString(4));
            hd.setNgayLap(result.getString(5));
            hd.setTenNV(result.getString(6));
            hd.setMaHoaDon(result.getLong(7));
            hd.setMaDatTour(result.getLong(8));
            hd.setGia(result.getFloat(9));
            hd.setSoLuong(result.getInt(10));
            hd.setTongTien(result.getFloat(11));
        }
        return hd;
    }
     public ArrayList<ReportPhieuCapLuong> getListPL(String ma) throws SQLException {
        ArrayList<ReportPhieuCapLuong> list = new ArrayList<>();
        
        Connection conn = kn.getConnect();
        String sql="SELECT tbl_chitiettinhluong.*, tbl_nhanvien.HOTENNV, tbl_phongtochuc.TENPTC from tbl_chitiettinhluong, tbl_nhanvien, tbl_phongtochuc where tbl_chitiettinhluong.MANV = tbl_nhanvien.MANV and tbl_nhanvien.MAPTC= tbl_phongtochuc.MAPTC and year(NGAYPHAT) = year(now()) and month(NGAYPHAT) ="+ma;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        int n=0;
        while (result.next()) {
            ReportPhieuCapLuong luong= new ReportPhieuCapLuong();
            luong.setMaTinhluong(result.getLong(1));
            luong.setMaNV(result.getLong(2));
            luong.setLuongCB(result.getFloat(3));
            luong.setSoNLV(result.getInt(4));
            luong.setThuong(result.getFloat(5));
            luong.setPhuCap(result.getFloat(6));
            luong.setTru(result.getFloat(7));
            luong.setThue(result.getFloat(8));
            luong.setTongLuong(result.getFloat(9));
            luong.setNgayPhat(result.getDate(10));
            luong.setTenNV(result.getString(11));
            luong.setTenPTC(result.getString(12));
            list.add(luong);
        }
        return list;
    }
     public ArrayList<TblHoadon> getListthongkeHD(String trangthai) throws SQLException{
        ArrayList<TblHoadon> listHD = new ArrayList<>();
        listHD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT tbl_hoadon.*,tbl_nhanvien.hotennv FROM tbl_hoadon, tbl_nhanvien WHERE tbl_hoadon.manv= tbl_nhanvien.manv AND tbl_hoadon.trangthai like '"+trangthai+ "'";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblHoadon hd = new TblHoadon();
            hd.setMahoadon(result.getLong(1));
            hd.setMadattour(result.getLong(2));
            hd.setNgaylap(result.getDate(3));
            hd.setManv(result.getLong(4));
            hd.setTongtien(result.getFloat(5));
            hd.setTrangthai(result.getString(6));
            hd.setTennv(result.getString(7));
            listHD.add(hd);
        }
        return listHD;
    }
     
       public ArrayList<thongKe> thongKe() throws SQLException{
        ArrayList<thongKe> listHD = new ArrayList<>();
        listHD.clear();
        Connection conn = kn.getConnect();
        String sql = "SELECT  month(tbl_hoadon.NGAYLAP), sum(tbl_hoadon.TONGTIEN) FROM tbl_hoadon WHERE YEAR(tbl_hoadon.NGAYLAP) = year(now()) GROUP BY month(tbl_hoadon.NGAYLAP)";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            thongKe hd= new thongKe();
            hd.setThang("Tháng "+result.getInt(1));
            hd.setDoanhthu(result.getDouble(2));
            hd.setLoai("Doanh Thu");
            listHD.add(hd);
        }
        return listHD;
    }
     
     public ArrayList<TblNhanvien> getListthongkeNV(String loai, String thuoctinh) throws SQLException {
        ArrayList<TblNhanvien> listNV = new ArrayList<>();
        listNV.clear();
        Connection conn = kn.getConnect();
        String sql ="";
        if(loai.equals("gioitinh")){
            sql = "SELECT tbl_nhanvien.*,tbl_phongtochuc.tenptc, tbl_chucvu.tencv FROM tbl_nhanvien, tbl_phongtochuc, tbl_chucvu WHERE tbl_nhanvien.maptc= tbl_phongtochuc.maptc AND tbl_nhanvien.macv=tbl_chucvu.macv AND tbl_nhanvien.gioitinh like'"+thuoctinh+"'";
        }else if(loai.equals("tuoi")){
            sql = "SELECT tbl_nhanvien.*,tbl_phongtochuc.tenptc, tbl_chucvu.tencv FROM tbl_nhanvien, tbl_phongtochuc, tbl_chucvu WHERE tbl_nhanvien.maptc= tbl_phongtochuc.maptc AND tbl_nhanvien.macv=tbl_chucvu.macv and (year(now())- year(tbl_nhanvien.ngaysinh))>="+ thuoctinh ;
        }
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblNhanvien nv = new TblNhanvien();
            nv.setManv(result.getLong(1));
            nv.setHotennv(result.getString(2));
            nv.setNgaysinh(result.getDate(3));
            nv.setGioitinh(result.getString(4));
            nv.setCmnd(result.getString(5));
            nv.setDiachi(result.getString(6));
            nv.setSdt(result.getString(7));
            nv.setNgayvaolam(result.getDate(8));
            nv.setMaptc(result.getLong(9));
            nv.setMacv(result.getLong(10));
            nv.setHinhanh(result.getString(11));
            nv.setTenPTC(result.getString(12));
            nv.setTenCV(result.getString(13));
            listNV.add(nv);
        }
        return listNV;
    }
     
     
}
