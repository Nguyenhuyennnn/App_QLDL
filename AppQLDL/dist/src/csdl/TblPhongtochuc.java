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
@Table(name = "tbl_phongtochuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPhongtochuc.findAll", query = "SELECT t FROM TblPhongtochuc t")
    , @NamedQuery(name = "TblPhongtochuc.findByMaptc", query = "SELECT t FROM TblPhongtochuc t WHERE t.maptc = :maptc")
    , @NamedQuery(name = "TblPhongtochuc.findByTenptc", query = "SELECT t FROM TblPhongtochuc t WHERE t.tenptc = :tenptc")
    , @NamedQuery(name = "TblPhongtochuc.findByTruongphong", query = "SELECT t FROM TblPhongtochuc t WHERE t.truongphong = :truongphong")})
public class TblPhongtochuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAPTC")
    private Long maptc;
    @Basic(optional = false)
    @Column(name = "TENPTC")
    private String tenptc;
    @Basic(optional = false)
    @Column(name = "TRUONGPHONG")
    private String truongphong;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maptc")
    private Collection<TblNhanvien> tblNhanvienCollection;

    public TblPhongtochuc() {
    }

    public TblPhongtochuc(Long maptc) {
        this.maptc = maptc;
    }

    public TblPhongtochuc(Long maptc, String tenptc, String truongphong) {
        this.maptc = maptc;
        this.tenptc = tenptc;
        this.truongphong = truongphong;
    }

    public Long getMaptc() {
        return maptc;
    }

    public void setMaptc(Long maptc) {
        this.maptc = maptc;
    }

    public String getTenptc() {
        return tenptc;
    }

    public void setTenptc(String tenptc) {
        this.tenptc = tenptc;
    }

    public String getTruongphong() {
        return truongphong;
    }

    public void setTruongphong(String truongphong) {
        this.truongphong = truongphong;
    }

    @XmlTransient
    public Collection<TblNhanvien> getTblNhanvienCollection() {
        return tblNhanvienCollection;
    }

    public void setTblNhanvienCollection(Collection<TblNhanvien> tblNhanvienCollection) {
        this.tblNhanvienCollection = tblNhanvienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maptc != null ? maptc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPhongtochuc)) {
            return false;
        }
        TblPhongtochuc other = (TblPhongtochuc) object;
        if ((this.maptc == null && other.maptc != null) || (this.maptc != null && !this.maptc.equals(other.maptc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenptc;
    }
    
}
