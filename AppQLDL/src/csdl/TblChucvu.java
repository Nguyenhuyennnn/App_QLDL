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
import javax.swing.table.TableModel;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tbl_chucvu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChucvu.findAll", query = "SELECT t FROM TblChucvu t")
    , @NamedQuery(name = "TblChucvu.findByMacv", query = "SELECT t FROM TblChucvu t WHERE t.macv = :macv")
    , @NamedQuery(name = "TblChucvu.findByTencv", query = "SELECT t FROM TblChucvu t WHERE t.tencv = :tencv")
    , @NamedQuery(name = "TblChucvu.findByHeso", query = "SELECT t FROM TblChucvu t WHERE t.heso = :heso")})
public class TblChucvu implements Serializable {

    private static final long serialVersionUID = 1L;

    public static TableModel getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MACV")
    private Long macv;
    @Basic(optional = false)
    @Column(name = "TENCV")
    private String tencv;
    @Basic(optional = false)
    @Column(name = "HESO")
    private int heso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "macv")
    private Collection<TblNhanvien> tblNhanvienCollection;

    public TblChucvu() {
    }

    public TblChucvu(Long macv) {
        this.macv = macv;
    }

    public TblChucvu(Long macv, String tencv, int heso) {
        this.macv = macv;
        this.tencv = tencv;
        this.heso = heso;
    }

    public Long getMacv() {
        return macv;
    }

    public void setMacv(Long macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    public int getHeso() {
        return heso;
    }

    public void setHeso(int heso) {
        this.heso = heso;
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
        hash += (macv != null ? macv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblChucvu)) {
            return false;
        }
        TblChucvu other = (TblChucvu) object;
        if ((this.macv == null && other.macv != null) || (this.macv != null && !this.macv.equals(other.macv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tencv;
    }
    
}
