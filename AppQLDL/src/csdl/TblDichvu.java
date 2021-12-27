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
@Table(name = "tbl_dichvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDichvu.findAll", query = "SELECT t FROM TblDichvu t")
    , @NamedQuery(name = "TblDichvu.findByMadv", query = "SELECT t FROM TblDichvu t WHERE t.madv = :madv")
    , @NamedQuery(name = "TblDichvu.findByTendv", query = "SELECT t FROM TblDichvu t WHERE t.tendv = :tendv")
    , @NamedQuery(name = "TblDichvu.findByDongia", query = "SELECT t FROM TblDichvu t WHERE t.dongia = :dongia")})
public class TblDichvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MADV")
    private Long madv;
    @Basic(optional = false)
    @Column(name = "TENDV")
    private String tendv;
    @Basic(optional = false)
    @Column(name = "DONGIA")
    private float dongia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madv")
    private Collection<TblTour> tblTourCollection;

    public TblDichvu() {
    }

    public TblDichvu(Long madv) {
        this.madv = madv;
    }

    public TblDichvu(Long madv, String tendv, float dongia) {
        this.madv = madv;
        this.tendv = tendv;
        this.dongia = dongia;
    }

    public Long getMadv() {
        return madv;
    }

    public void setMadv(Long madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
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
        hash += (madv != null ? madv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDichvu)) {
            return false;
        }
        TblDichvu other = (TblDichvu) object;
        if ((this.madv == null && other.madv != null) || (this.madv != null && !this.madv.equals(other.madv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tendv;
    }
    
}
