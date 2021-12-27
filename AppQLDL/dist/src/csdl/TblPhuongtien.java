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
@Table(name = "tbl_phuongtien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPhuongtien.findAll", query = "SELECT t FROM TblPhuongtien t")
    , @NamedQuery(name = "TblPhuongtien.findByMaphuongtien", query = "SELECT t FROM TblPhuongtien t WHERE t.maphuongtien = :maphuongtien")
    , @NamedQuery(name = "TblPhuongtien.findByTenphuongtien", query = "SELECT t FROM TblPhuongtien t WHERE t.tenphuongtien = :tenphuongtien")
    , @NamedQuery(name = "TblPhuongtien.findByLoai", query = "SELECT t FROM TblPhuongtien t WHERE t.loai = :loai")
    , @NamedQuery(name = "TblPhuongtien.findByTentaixe", query = "SELECT t FROM TblPhuongtien t WHERE t.tentaixe = :tentaixe")
    , @NamedQuery(name = "TblPhuongtien.findBySdtlienlac", query = "SELECT t FROM TblPhuongtien t WHERE t.sdtlienlac = :sdtlienlac")
    , @NamedQuery(name = "TblPhuongtien.findByTrangthai", query = "SELECT t FROM TblPhuongtien t WHERE t.trangthai = :trangthai")
    , @NamedQuery(name = "TblPhuongtien.findByGia", query = "SELECT t FROM TblPhuongtien t WHERE t.gia = :gia")})
public class TblPhuongtien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAPHUONGTIEN")
    private Long maphuongtien;
    @Basic(optional = false)
    @Column(name = "TENPHUONGTIEN")
    private String tenphuongtien;
    @Basic(optional = false)
    @Column(name = "LOAI")
    private String loai;
    @Basic(optional = false)
    @Column(name = "TENTAIXE")
    private String tentaixe;
    @Basic(optional = false)
    @Column(name = "SDTLIENLAC")
    private String sdtlienlac;
    @Basic(optional = false)
    @Column(name = "TRANGTHAI")
    private String trangthai;
    @Basic(optional = false)
    @Column(name = "GIA")
    private float gia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maphuongtien")
    private Collection<TblTour> tblTourCollection;

    public TblPhuongtien() {
    }

    public TblPhuongtien(Long maphuongtien) {
        this.maphuongtien = maphuongtien;
    }

    public TblPhuongtien(Long maphuongtien, String tenphuongtien, String loai, String tentaixe, String sdtlienlac, String trangthai, float gia) {
        this.maphuongtien = maphuongtien;
        this.tenphuongtien = tenphuongtien;
        this.loai = loai;
        this.tentaixe = tentaixe;
        this.sdtlienlac = sdtlienlac;
        this.trangthai = trangthai;
        this.gia = gia;
    }

    public Long getMaphuongtien() {
        return maphuongtien;
    }

    public void setMaphuongtien(Long maphuongtien) {
        this.maphuongtien = maphuongtien;
    }

    public String getTenphuongtien() {
        return tenphuongtien;
    }

    public void setTenphuongtien(String tenphuongtien) {
        this.tenphuongtien = tenphuongtien;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTentaixe() {
        return tentaixe;
    }

    public void setTentaixe(String tentaixe) {
        this.tentaixe = tentaixe;
    }

    public String getSdtlienlac() {
        return sdtlienlac;
    }

    public void setSdtlienlac(String sdtlienlac) {
        this.sdtlienlac = sdtlienlac;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @XmlTransient
    public Collection<TblTour> getTblTourCollection() {
        return tblTourCollection;
    }

    public void setTblTourCollection(Collection<TblTour> tblTourCollection) {
        this.tblTourCollection = tblTourCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maphuongtien != null ? maphuongtien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPhuongtien)) {
            return false;
        }
        TblPhuongtien other = (TblPhuongtien) object;
        if ((this.maphuongtien == null && other.maphuongtien != null) || (this.maphuongtien != null && !this.maphuongtien.equals(other.maphuongtien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenphuongtien;
    }
    
}
