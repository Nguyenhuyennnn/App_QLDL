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
@Table(name = "tbl_khachsan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKhachsan.findAll", query = "SELECT t FROM TblKhachsan t")
    , @NamedQuery(name = "TblKhachsan.findByMaks", query = "SELECT t FROM TblKhachsan t WHERE t.maks = :maks")
    , @NamedQuery(name = "TblKhachsan.findByTenks", query = "SELECT t FROM TblKhachsan t WHERE t.tenks = :tenks")
    , @NamedQuery(name = "TblKhachsan.findByDiachi", query = "SELECT t FROM TblKhachsan t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblKhachsan.findByDanhgia", query = "SELECT t FROM TblKhachsan t WHERE t.danhgia = :danhgia")
    , @NamedQuery(name = "TblKhachsan.findBySdtlienhe", query = "SELECT t FROM TblKhachsan t WHERE t.sdtlienhe = :sdtlienhe")})
public class TblKhachsan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAKS")
    private Long maks;
    @Basic(optional = false)
    @Column(name = "TENKS")
    private String tenks;
    @Basic(optional = false)
    @Column(name = "DIACHI")
    private String diachi;
    @Basic(optional = false)
    @Column(name = "DANHGIA")
    private String danhgia;
    @Basic(optional = false)
    @Column(name = "SDTLIENHE")
    private String sdtlienhe;
    @JoinColumn(name = "MATINH", referencedColumnName = "MATINH")
    @ManyToOne(optional = false)
    private Long matinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maks")
    private Collection<TblPhongkhachsan> tblPhongkhachsanCollection;
    private String tentinh;

    public String getTentinh() {
        return tentinh;
    }

    public void setTentinh(String tentinh) {
        this.tentinh = tentinh;
    }
    public TblKhachsan() {
    }

    public TblKhachsan(Long maks) {
        this.maks = maks;
    }

    public TblKhachsan(Long maks, String tenks, String diachi, String danhgia, String sdtlienhe) {
        this.maks = maks;
        this.tenks = tenks;
        this.diachi = diachi;
        this.danhgia = danhgia;
        this.sdtlienhe = sdtlienhe;
    }

    public Long getMaks() {
        return maks;
    }

    public void setMaks(Long maks) {
        this.maks = maks;
    }

    public String getTenks() {
        return tenks;
    }

    public void setTenks(String tenks) {
        this.tenks = tenks;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(String danhgia) {
        this.danhgia = danhgia;
    }

    public String getSdtlienhe() {
        return sdtlienhe;
    }

    public void setSdtlienhe(String sdtlienhe) {
        this.sdtlienhe = sdtlienhe;
    }

    public Long getMatinh() {
        return matinh;
    }

    public void setMatinh(Long matinh) {
        this.matinh = matinh;
    }

    @XmlTransient
    public Collection<TblPhongkhachsan> getTblPhongkhachsanCollection() {
        return tblPhongkhachsanCollection;
    }

    public void setTblPhongkhachsanCollection(Collection<TblPhongkhachsan> tblPhongkhachsanCollection) {
        this.tblPhongkhachsanCollection = tblPhongkhachsanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maks != null ? maks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKhachsan)) {
            return false;
        }
        TblKhachsan other = (TblKhachsan) object;
        if ((this.maks == null && other.maks != null) || (this.maks != null && !this.maks.equals(other.maks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenks;
    }
    
}
