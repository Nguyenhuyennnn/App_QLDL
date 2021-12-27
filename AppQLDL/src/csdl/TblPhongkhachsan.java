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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_phongkhachsan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPhongkhachsan.findAll", query = "SELECT t FROM TblPhongkhachsan t")
    , @NamedQuery(name = "TblPhongkhachsan.findByMaphongks", query = "SELECT t FROM TblPhongkhachsan t WHERE t.maphongks = :maphongks")
    , @NamedQuery(name = "TblPhongkhachsan.findByTenphong", query = "SELECT t FROM TblPhongkhachsan t WHERE t.tenphong = :tenphong")
    , @NamedQuery(name = "TblPhongkhachsan.findByLoai", query = "SELECT t FROM TblPhongkhachsan t WHERE t.loai = :loai")
    , @NamedQuery(name = "TblPhongkhachsan.findByGia", query = "SELECT t FROM TblPhongkhachsan t WHERE t.gia = :gia")})
public class TblPhongkhachsan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAPHONGKS")
    private Long maphongks;
    @Basic(optional = false)
    @Column(name = "TENPHONG")
    private String tenphong;
    @Basic(optional = false)
    @Column(name = "LOAI")
    private String loai;
    @Basic(optional = false)
    @Column(name = "GIA")
    private float gia;
    @JoinColumn(name = "MAKS", referencedColumnName = "MAKS")
    @ManyToOne(optional = false)
    private Long maks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maphongks")
    private Collection<TblTour> tblTourCollection;
    private String tenks;

    public String getTenks() {
        return tenks;
    }

    public void setTenks(String tenks) {
        this.tenks = tenks;
    }

    
    public TblPhongkhachsan() {
    }

    public TblPhongkhachsan(Long maphongks) {
        this.maphongks = maphongks;
    }

    public TblPhongkhachsan(Long maphongks, String tenphong, String loai, float gia) {
        this.maphongks = maphongks;
        this.tenphong = tenphong;
        this.loai = loai;
        this.gia = gia;
    }

    public Long getMaphongks() {
        return maphongks;
    }

    public void setMaphongks(Long maphongks) {
        this.maphongks = maphongks;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public Long getMaks() {
        return maks;
    }

    public void setMaks(Long maks) {
        this.maks = maks;
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
        hash += (maphongks != null ? maphongks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPhongkhachsan)) {
            return false;
        }
        TblPhongkhachsan other = (TblPhongkhachsan) object;
        if ((this.maphongks == null && other.maphongks != null) || (this.maphongks != null && !this.maphongks.equals(other.maphongks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenphong;
    }
    
}
