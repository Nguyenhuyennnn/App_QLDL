/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tbl_nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNhanvien.findAll", query = "SELECT t FROM TblNhanvien t")
    , @NamedQuery(name = "TblNhanvien.findByManv", query = "SELECT t FROM TblNhanvien t WHERE t.manv = :manv")
    , @NamedQuery(name = "TblNhanvien.findByHotennv", query = "SELECT t FROM TblNhanvien t WHERE t.hotennv = :hotennv")
    , @NamedQuery(name = "TblNhanvien.findByNgaysinh", query = "SELECT t FROM TblNhanvien t WHERE t.ngaysinh = :ngaysinh")
    , @NamedQuery(name = "TblNhanvien.findByGioitinh", query = "SELECT t FROM TblNhanvien t WHERE t.gioitinh = :gioitinh")
    , @NamedQuery(name = "TblNhanvien.findByCmnd", query = "SELECT t FROM TblNhanvien t WHERE t.cmnd = :cmnd")
    , @NamedQuery(name = "TblNhanvien.findByDiachi", query = "SELECT t FROM TblNhanvien t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblNhanvien.findBySdt", query = "SELECT t FROM TblNhanvien t WHERE t.sdt = :sdt")
    , @NamedQuery(name = "TblNhanvien.findByNgayvaolam", query = "SELECT t FROM TblNhanvien t WHERE t.ngayvaolam = :ngayvaolam")})
public class TblNhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MANV")
    private Long manv;
    @Basic(optional = false)
    @Column(name = "HOTENNV")
    private String hotennv;
    @Basic(optional = false)
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Basic(optional = false)
    @Column(name = "GIOITINH")
    private String gioitinh;
    @Basic(optional = false)
    @Column(name = "CMND")
    private String cmnd;
    @Basic(optional = false)
    @Column(name = "DIACHI")
    private String diachi;
    @Basic(optional = false)
    @Column(name = "SDT")
    private String sdt;
    @Basic(optional = false)
    @Column(name = "NGAYVAOLAM")
    @Temporal(TemporalType.DATE)
    private Date ngayvaolam;
    @Basic(optional = false)
    @Lob
    @Column(name = "HINHANH")
    private String hinhanh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manv")
    private Collection<TblHoadon> tblHoadonCollection;
    @JoinColumn(name = "MACV", referencedColumnName = "MACV")
    @ManyToOne(optional = false)
    private Long macv;
    @JoinColumn(name = "MAPTC", referencedColumnName = "MAPTC")
    @ManyToOne(optional = false)
    private Long maptc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manv")
    private Collection<TblDattour> tblDattourCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manv")
    private Collection<TblAdmin> tblAdminCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblNhanvien")
    private Collection<TblChitietdiemdanh> tblChitietdiemdanhCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblNhanvien")
    private Collection<TblChitiettinhluong> tblChitiettinhluongCollection;
    private String tenPTC;
    private String tenCV;

    public String getTenPTC() {
        return tenPTC;
    }

    public void setTenPTC(String tenPTC) {
        this.tenPTC = tenPTC;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
    public TblNhanvien() {
    }

    public TblNhanvien(Long manv) {
        this.manv = manv;
    }

    public TblNhanvien(Long manv, String hotennv, Date ngaysinh, String gioitinh, String cmnd, String diachi, String sdt, Date ngayvaolam, String hinhanh) {
        this.manv = manv;
        this.hotennv = hotennv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.sdt = sdt;
        this.ngayvaolam = ngayvaolam;
        this.hinhanh = hinhanh;
    }

    public Long getManv() {
        return manv;
    }

    public void setManv(Long manv) {
        this.manv = manv;
    }

    public String getHotennv() {
        return hotennv;
    }

    public void setHotennv(String hotennv) {
        this.hotennv = hotennv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayvaolam() {
        return ngayvaolam;
    }

    public void setNgayvaolam(Date ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @XmlTransient
    public Collection<TblHoadon> getTblHoadonCollection() {
        return tblHoadonCollection;
    }

    public void setTblHoadonCollection(Collection<TblHoadon> tblHoadonCollection) {
        this.tblHoadonCollection = tblHoadonCollection;
    }

    public Long getMacv() {
        return macv;
    }

    public void setMacv(Long macv) {
        this.macv = macv;
    }

    public Long getMaptc() {
        return maptc;
    }

    public void setMaptc(Long maptc) {
        this.maptc = maptc;
    }

    @XmlTransient
    public Collection<TblDattour> getTblDattourCollection() {
        return tblDattourCollection;
    }

    public void setTblDattourCollection(Collection<TblDattour> tblDattourCollection) {
        this.tblDattourCollection = tblDattourCollection;
    }

    @XmlTransient
    public Collection<TblAdmin> getTblAdminCollection() {
        return tblAdminCollection;
    }

    public void setTblAdminCollection(Collection<TblAdmin> tblAdminCollection) {
        this.tblAdminCollection = tblAdminCollection;
    }

    @XmlTransient
    public Collection<TblChitietdiemdanh> getTblChitietdiemdanhCollection() {
        return tblChitietdiemdanhCollection;
    }

    public void setTblChitietdiemdanhCollection(Collection<TblChitietdiemdanh> tblChitietdiemdanhCollection) {
        this.tblChitietdiemdanhCollection = tblChitietdiemdanhCollection;
    }

    @XmlTransient
    public Collection<TblChitiettinhluong> getTblChitiettinhluongCollection() {
        return tblChitiettinhluongCollection;
    }

    public void setTblChitiettinhluongCollection(Collection<TblChitiettinhluong> tblChitiettinhluongCollection) {
        this.tblChitiettinhluongCollection = tblChitiettinhluongCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manv != null ? manv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNhanvien)) {
            return false;
        }
        TblNhanvien other = (TblNhanvien) object;
        if ((this.manv == null && other.manv != null) || (this.manv != null && !this.manv.equals(other.manv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return hotennv;
    }

    
    
}
