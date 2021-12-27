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
@Table(name = "tbl_tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTour.findAll", query = "SELECT t FROM TblTour t")
    , @NamedQuery(name = "TblTour.findByMatour", query = "SELECT t FROM TblTour t WHERE t.matour = :matour")
    , @NamedQuery(name = "TblTour.findByTentour", query = "SELECT t FROM TblTour t WHERE t.tentour = :tentour")
    , @NamedQuery(name = "TblTour.findByThoigian", query = "SELECT t FROM TblTour t WHERE t.thoigian = :thoigian")
    , @NamedQuery(name = "TblTour.findByDiadiem", query = "SELECT t FROM TblTour t WHERE t.diadiem = :diadiem")
    , @NamedQuery(name = "TblTour.findByGia", query = "SELECT t FROM TblTour t WHERE t.gia = :gia")
    , @NamedQuery(name = "TblTour.findByGhichu", query = "SELECT t FROM TblTour t WHERE t.ghichu = :ghichu")})
public class TblTour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MATOUR")
    private Long matour;
    @Basic(optional = false)
    @Column(name = "TENTOUR")
    private String tentour;
    @Basic(optional = false)
    @Column(name = "THOIGIAN")
    @Temporal(TemporalType.DATE)
    private Date thoigian;
    @Basic(optional = false)
    @Column(name = "DIADIEM")
    private String diadiem;
    @Basic(optional = false)
    @Column(name = "GIA")
    private float gia;
    @Basic(optional = false)
    @Column(name = "GHICHU")
    private String ghichu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matour")
    private Collection<TblDattour> tblDattourCollection;
    @JoinColumn(name = "MAPHONGKS", referencedColumnName = "MAPHONGKS")
    @ManyToOne(optional = false)
    private Long maphongks;
    @JoinColumn(name = "MADV", referencedColumnName = "MADV")
    @ManyToOne(optional = false)
    private Long madv;
    @JoinColumn(name = "MAPHUONGTIEN", referencedColumnName = "MAPHUONGTIEN")
    @ManyToOne(optional = false)
    private Long maphuongtien;
    private String tenphongks, tendv, tenpt;

    public String getTenphongks() {
        return tenphongks;
    }

    public void setTenphongks(String tenphongks) {
        this.tenphongks = tenphongks;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getTenpt() {
        return tenpt;
    }

    public void setTenpt(String tenpt) {
        this.tenpt = tenpt;
    }
    public TblTour() {
    }

    public TblTour(Long matour) {
        this.matour = matour;
    }

    public TblTour(Long matour, String tentour, Date thoigian, String diadiem, float gia, String ghichu) {
        this.matour = matour;
        this.tentour = tentour;
        this.thoigian = thoigian;
        this.diadiem = diadiem;
        this.gia = gia;
        this.ghichu = ghichu;
    }

    public Long getMatour() {
        return matour;
    }

    public void setMatour(Long matour) {
        this.matour = matour;
    }

    public String getTentour() {
        return tentour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @XmlTransient
    public Collection<TblDattour> getTblDattourCollection() {
        return tblDattourCollection;
    }

    public void setTblDattourCollection(Collection<TblDattour> tblDattourCollection) {
        this.tblDattourCollection = tblDattourCollection;
    }

    public Long getMaphongks() {
        return maphongks;
    }

    public void setMaphongks(Long maphongks) {
        this.maphongks = maphongks;
    }

    public Long getMadv() {
        return madv;
    }

    public void setMadv(Long madv) {
        this.madv = madv;
    }

    public Long getMaphuongtien() {
        return maphuongtien;
    }

    public void setMaphuongtien(Long maphuongtien) {
        this.maphuongtien = maphuongtien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matour != null ? matour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTour)) {
            return false;
        }
        TblTour other = (TblTour) object;
        if ((this.matour == null && other.matour != null) || (this.matour != null && !this.matour.equals(other.matour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tentour;
    }
    
}
