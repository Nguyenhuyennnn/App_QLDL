/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tbl_hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHoadon.findAll", query = "SELECT t FROM TblHoadon t")
    , @NamedQuery(name = "TblHoadon.findByMahoadon", query = "SELECT t FROM TblHoadon t WHERE t.mahoadon = :mahoadon")
    , @NamedQuery(name = "TblHoadon.findByNgaylap", query = "SELECT t FROM TblHoadon t WHERE t.ngaylap = :ngaylap")
    , @NamedQuery(name = "TblHoadon.findByTongtien", query = "SELECT t FROM TblHoadon t WHERE t.tongtien = :tongtien")})
public class TblHoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAHOADON")
    private Long mahoadon;
    @Basic(optional = false)
    @Column(name = "NGAYLAP")
    @Temporal(TemporalType.DATE)
    private Date ngaylap;
    @Basic(optional = false)
    @Column(name = "TONGTIEN")
    private float tongtien;
    @JoinColumn(name = "MADATTOUR", referencedColumnName = "MADATTOUR")
    @ManyToOne(optional = false)
    private Long madattour;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne(optional = false)
    private Long manv;
    private String trangthai;
    private String tennv;
    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
   
    

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }
    public TblHoadon() {
    }

    public TblHoadon(Long mahoadon) {
        this.mahoadon = mahoadon;
    }

    public TblHoadon(Long mahoadon, Date ngaylap, float tongtien) {
        this.mahoadon = mahoadon;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
    }

    public Long getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(Long mahoadon) {
        this.mahoadon = mahoadon;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public Long getMadattour() {
        return madattour;
    }

    public void setMadattour(Long madattour) {
        this.madattour = madattour;
    }

    public Long getManv() {
        return manv;
    }

    public void setManv(Long manv) {
        this.manv = manv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mahoadon != null ? mahoadon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHoadon)) {
            return false;
        }
        TblHoadon other = (TblHoadon) object;
        if ((this.mahoadon == null && other.mahoadon != null) || (this.mahoadon != null && !this.mahoadon.equals(other.mahoadon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "csdl.TblHoadon[ mahoadon=" + mahoadon + " ]";
    }
    
}
