/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tbl_khachhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKhachhang.findAll", query = "SELECT t FROM TblKhachhang t")
    , @NamedQuery(name = "TblKhachhang.findByMakh", query = "SELECT t FROM TblKhachhang t WHERE t.makh = :makh")
    , @NamedQuery(name = "TblKhachhang.findByHotenkh", query = "SELECT t FROM TblKhachhang t WHERE t.hotenkh = :hotenkh")
    , @NamedQuery(name = "TblKhachhang.findByGioitinh", query = "SELECT t FROM TblKhachhang t WHERE t.gioitinh = :gioitinh")
    , @NamedQuery(name = "TblKhachhang.findByCmnd", query = "SELECT t FROM TblKhachhang t WHERE t.cmnd = :cmnd")
    , @NamedQuery(name = "TblKhachhang.findByDiachi", query = "SELECT t FROM TblKhachhang t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblKhachhang.findBySdt", query = "SELECT t FROM TblKhachhang t WHERE t.sdt = :sdt")
    , @NamedQuery(name = "TblKhachhang.findByLoai", query = "SELECT t FROM TblKhachhang t WHERE t.loai = :loai")})
public class TblKhachhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAKH")
    private Long makh;
    @Basic(optional = false)
    @Column(name = "HOTENKH")
    private String hotenkh;
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
    @Column(name = "LOAI")
    private String loai;
    @Basic(optional = false)
    @Lob
    @Column(name = "HINHANH")
    private String hinhanh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "makh")
    private Collection<TblDattour> tblDattourCollection;

    public TblKhachhang() {
    }

    public TblKhachhang(Long makh) {
        this.makh = makh;
    }

    public TblKhachhang(Long makh, String hotenkh, String gioitinh, String cmnd, String diachi, String sdt, String loai, String hinhanh) {
        this.makh = makh;
        this.hotenkh = hotenkh;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.sdt = sdt;
        this.loai = loai;
        this.hinhanh = hinhanh;
    }

    public Long getMakh() {
        return makh;
    }

    public void setMakh(Long makh) {
        this.makh = makh;
    }

    public String getHotenkh() {
        return hotenkh;
    }

    public void setHotenkh(String hotenkh) {
        this.hotenkh = hotenkh;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @XmlTransient
    public Collection<TblDattour> getTblDattourCollection() {
        return tblDattourCollection;
    }

    public void setTblDattourCollection(Collection<TblDattour> tblDattourCollection) {
        this.tblDattourCollection = tblDattourCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (makh != null ? makh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKhachhang)) {
            return false;
        }
        TblKhachhang other = (TblKhachhang) object;
        if ((this.makh == null && other.makh != null) || (this.makh != null && !this.makh.equals(other.makh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return hotenkh;
    }
    
}
