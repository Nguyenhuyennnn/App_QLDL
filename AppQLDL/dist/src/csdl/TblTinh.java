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
@Table(name = "tbl_tinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTinh.findAll", query = "SELECT t FROM TblTinh t")
    , @NamedQuery(name = "TblTinh.findByMatinh", query = "SELECT t FROM TblTinh t WHERE t.matinh = :matinh")
    , @NamedQuery(name = "TblTinh.findByTentinh", query = "SELECT t FROM TblTinh t WHERE t.tentinh = :tentinh")})
public class TblTinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MATINH")
    private Long matinh;
    @Basic(optional = false)
    @Column(name = "TENTINH")
    private String tentinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matinh")
    private Collection<TblKhachsan> tblKhachsanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matinh")
    private Collection<TblDiadiem> tblDiadiemCollection;

    public TblTinh() {
    }

    public TblTinh(Long matinh) {
        this.matinh = matinh;
    }

    public TblTinh(Long matinh, String tentinh) {
        this.matinh = matinh;
        this.tentinh = tentinh;
    }

    public Long getMatinh() {
        return matinh;
    }

    public void setMatinh(Long matinh) {
        this.matinh = matinh;
    }

    public String getTentinh() {
        return tentinh;
    }

    public void setTentinh(String tentinh) {
        this.tentinh = tentinh;
    }

    @XmlTransient
    public Collection<TblKhachsan> getTblKhachsanCollection() {
        return tblKhachsanCollection;
    }

    public void setTblKhachsanCollection(Collection<TblKhachsan> tblKhachsanCollection) {
        this.tblKhachsanCollection = tblKhachsanCollection;
    }

    @XmlTransient
    public Collection<TblDiadiem> getTblDiadiemCollection() {
        return tblDiadiemCollection;
    }

    public void setTblDiadiemCollection(Collection<TblDiadiem> tblDiadiemCollection) {
        this.tblDiadiemCollection = tblDiadiemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matinh != null ? matinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTinh)) {
            return false;
        }
        TblTinh other = (TblTinh) object;
        if ((this.matinh == null && other.matinh != null) || (this.matinh != null && !this.matinh.equals(other.matinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tentinh;
    }
    
}
