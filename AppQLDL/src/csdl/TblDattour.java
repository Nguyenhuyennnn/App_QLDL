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
@Table(name = "tbl_dattour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDattour.findAll", query = "SELECT t FROM TblDattour t")
    , @NamedQuery(name = "TblDattour.findByMadattour", query = "SELECT t FROM TblDattour t WHERE t.madattour = :madattour")
    , @NamedQuery(name = "TblDattour.findBySoluong", query = "SELECT t FROM TblDattour t WHERE t.soluong = :soluong")
    , @NamedQuery(name = "TblDattour.findByThoigianbatdau", query = "SELECT t FROM TblDattour t WHERE t.thoigianbatdau = :thoigianbatdau")
    , @NamedQuery(name = "TblDattour.findByDiadiembatdau", query = "SELECT t FROM TblDattour t WHERE t.diadiembatdau = :diadiembatdau")})
public class TblDattour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MADATTOUR")
    private Long madattour;
    @Basic(optional = false)
    @Column(name = "SOLUONG")
    private int soluong;
    @Basic(optional = false)
    @Column(name = "THOIGIANBATDAU")
    @Temporal(TemporalType.DATE)
    private Date thoigianbatdau;
    @Basic(optional = false)
    @Column(name = "DIADIEMBATDAU")
    private String diadiembatdau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madattour")
    private Collection<TblHoadon> tblHoadonCollection;
    @JoinColumn(name = "MAKH", referencedColumnName = "MAKH")
    @ManyToOne(optional = false)
    private Long makh;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne(optional = false)
    private Long manv;
    @JoinColumn(name = "MATOUR", referencedColumnName = "MATOUR")
    @ManyToOne(optional = false)
    private Long matour;
    private String hotenkh, hotennv,tentour;
    
    public String getTentour() {
        return tentour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public String getHotenkh() {
        return hotenkh;
    }

    public void setHotenkh(String hotenkh) {
        this.hotenkh = hotenkh;
    }

    public String getHotennv() {
        return hotennv;
    }

    public void setHotennv(String hotennv) {
        this.hotennv = hotennv;
    }

    public TblDattour() {
    }

    public TblDattour(Long madattour) {
        this.madattour = madattour;
    }

    public TblDattour(Long madattour, int soluong, Date thoigianbatdau, String diadiembatdau) {
        this.madattour = madattour;
        this.soluong = soluong;
        this.thoigianbatdau = thoigianbatdau;
        this.diadiembatdau = diadiembatdau;
    }

    public Long getMadattour() {
        return madattour;
    }

    public void setMadattour(Long madattour) {
        this.madattour = madattour;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(Date thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public String getDiadiembatdau() {
        return diadiembatdau;
    }

    public void setDiadiembatdau(String diadiembatdau) {
        this.diadiembatdau = diadiembatdau;
    }

    @XmlTransient
    public Collection<TblHoadon> getTblHoadonCollection() {
        return tblHoadonCollection;
    }

    public void setTblHoadonCollection(Collection<TblHoadon> tblHoadonCollection) {
        this.tblHoadonCollection = tblHoadonCollection;
    }

    public Long getMakh() {
        return makh;
    }

    public void setMakh(Long makh) {
        this.makh = makh;
    }

    public Long getManv() {
        return manv;
    }

    public void setManv(Long manv) {
        this.manv = manv;
    }

    public Long getMatour() {
        return matour;
    }

    public void setMatour(Long matour) {
        this.matour = matour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (madattour != null ? madattour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDattour)) {
            return false;
        }
        TblDattour other = (TblDattour) object;
        if ((this.madattour == null && other.madattour != null) || (this.madattour != null && !this.madattour.equals(other.madattour))) {
            return false;
        }
        return true;
    }

   
    
}
